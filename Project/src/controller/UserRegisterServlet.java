
package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// フォワード

		HttpSession session = request.getSession();
		if(session.getAttribute("userInfo") == null) {
			response.sendRedirect("LoginServlet");
			return;
		}


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //文字化け防止

		UserDao userDao = new UserDao();

		// リクエストパラメータの入力項目を取得
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String passwordc = request.getParameter("passwordC");
		String name = request.getParameter("name");
		String birthdate = request.getParameter("birthDate");

		boolean exist = userDao.checkId(loginId);

		if (exist== true) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "既存のログインIDは使用出来ません。");

			// 登録jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp");
			dispatcher.forward(request, response);

			return;
		}



		if (!password.equals(passwordc)) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "異なるパスワードが入力されています。");

			// 登録jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp");
			dispatcher.forward(request, response);

			return;
		}

		if (loginId.equals("") || password.equals("") || passwordc.equals("") ||
				name.equals("") || birthdate.equals("")) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "未入力の項目があります。");

			// 登録jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp");
			dispatcher.forward(request, response);

			return;
		}

		userDao.register(loginId, password, name, birthdate);

		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("UserListServlet");


	}

}
