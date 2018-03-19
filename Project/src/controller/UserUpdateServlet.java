package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		// 確認用：idをコンソールに出力
		System.out.println(id);

		if (id == null) {
			response.sendRedirect("LoginServlet");
		}

		//idを引数にして、idに紐づくユーザ情報を出力する
		UserDao userDao = new UserDao();
		User user = userDao.findById(id);

		//ユーザ情報をリクエストスコープにセットしてjspにフォワード
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8");



		String id = request.getParameter("id");
		// リクエストパラメータの入力項目を取得
		String password = request.getParameter("password");
		String passwordc = request.getParameter("passwordC");
		String name = request.getParameter("name");
		String birthdate = request.getParameter("birthDate");

		if (!password.equals(passwordc)) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "異なるパスワードが入力されています。");

			UserDao userDao = new UserDao();
			User user = userDao.findById(id);

			request.setAttribute("user", user);

			// 更新jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
			dispatcher.forward(request, response);

			return;
		}

		// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
		UserDao userDao = new UserDao();
		userDao.update(password, name, birthdate, id);

		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("UserListServlet");
	}



}
