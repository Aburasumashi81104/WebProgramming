package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.Util;

public class UserDao {

	/**
     * ログインIDとパスワードに紐づくユーザ情報を返す
     * @param loginId
     * @param password
     * @return
     */
    public User findByLoginInfo(String loginId, String password) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, Util.angou(password));
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            return new User(loginIdData, nameData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

    public List<User> findAll() {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // 管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM user WHERE login_id NOT IN ('admin')";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }

    public List<User> findSearch(String targetId,String targetName, String targetDateA, String targetDateB) {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();


        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // 管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM user WHERE login_id NOT IN ('admin')";


            //値が入っていた場合の処理
            if(!targetId.equals("")) {
            	sql += " and login_id = '" + targetId + "'";
            }

            if(!targetName.equals("")) {
            	sql += " and name LIKE '%" + targetName + "%'";
            }

            if(!targetDateA.equals("")) {
            	sql += " and birth_date >= '" + targetDateA + "'";
            }

            if(!targetDateB.equals("")) {

            	sql += " and birth_date <= '" + targetDateB + "'";
            }


            /*sql += " and birth_date >= TO_DATE('" + targetDateA + "'"+",'YYYY/MM/DD')";*/



             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);



                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }

	public User findById(String targetId) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user WHERE id = ?";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, targetId);
			ResultSet rs = pStmt.executeQuery();

			// 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
			if (!rs.next()) {
				return null;
			}
			int id = rs.getInt("id");
			String loginId = rs.getString("login_id");
			String name = rs.getString("name");
			Date birthDate = rs.getDate("birth_date");
			String password = rs.getString("password");
			String createDate = rs.getString("create_date");
			String updateDate = rs.getString("update_date");

			return new User(id, loginId, name, birthDate, password, createDate, updateDate);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}

	public void update(String password, String name, String birthdate, String targetId) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SQL文を準備
			String sql = "UPDATE user SET password = ?, name = ?, birth_date = ? WHERE id = ?";
			String sql2 = "UPDATE user SET update_date = now()";
			// SELECTを実行し、データを更新
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, Util.angou(password));
			pStmt.setString(2, name);
			pStmt.setString(3, birthdate);
			pStmt.setString(4, targetId);
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);
			pStmt.executeUpdate();
			pStmt2.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
			return;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return;
				}
			}
		}
	}

	public void register(String loginId, String password, String name, String birthdate) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "INSERT INTO user (login_id,name,birth_date,password,create_date,update_date) VALUES (?,?,?,?,now(), now())";

			// SELECTを実行し、データを更新
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, name);
			pStmt.setString(3, birthdate);
			pStmt.setString(4, Util.angou(password));

			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return;
				}
			}
		}
	}

	public void delete(String targetId) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "DELETE FROM user WHERE id = ?";

			// SELECTを実行し、ユーザを削除
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, targetId);

			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return;
				}
			}
		}
	}

	public boolean checkId(String targetId) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user WHERE login_id = ?";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, targetId);
			ResultSet rs = pStmt.executeQuery();
			// 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
			if (!rs.next()) {
				return null != null;
			}
			String loginId = rs.getString("login_id");

			if(loginId != null) {
				return true;
			}

			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
	}

}
