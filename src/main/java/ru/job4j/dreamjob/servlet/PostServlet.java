package ru.job4j.dreamjob.servlet;

import ru.job4j.dreamjob.model.Post;
import ru.job4j.dreamjob.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Store.instanceOf().savePost(new Post(0, req.getParameter("name")));
        res.sendRedirect(req.getContextPath() + "/posts.jsp");
    }
}