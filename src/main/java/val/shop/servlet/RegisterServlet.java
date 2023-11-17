package val.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import val.shop.connection.DbCon;
import val.shop.dao.*;
import val.shop.model.*;

@WebServlet("/user-register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String name = request.getParameter("reg-name");
			String email = request.getParameter("reg-email");
			String password = request.getParameter("reg-password");

			UserDao udao = new UserDao(DbCon.getConnection());
			Boolean res = udao.userRegister(name, email, password);
			if (res) {
				response.sendRedirect("login.jsp");
			} else {
				out.println("Cannot add user now");
			}

		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		} 

	}
}
