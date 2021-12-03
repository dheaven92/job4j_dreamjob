package ru.job4j.dreamjob.servlet;

import ru.job4j.dreamjob.model.User;
import ru.job4j.dreamjob.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User userWithSameEmail = DbStore.instanceOf().findUserByEmail(email);
        if (userWithSameEmail != null) {
            req.setAttribute("error", "Email занят другим пользователем");
            req.getRequestDispatcher("reg.jsp").forward(req, res);
        } else {
            DbStore.instanceOf().saveUser(new User(0, name, email, password));
            User userInDb = DbStore.instanceOf().findUserByEmail(email);
            HttpSession session = req.getSession();
            session.setAttribute("user", userInDb);
            res.sendRedirect(req.getContextPath() + "/posts.do");
        }
    }
}
