package ru.job4j.dreamjob.servlet;

import ru.job4j.dreamjob.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("posts", DbStore.instanceOf().findRecentPosts());
        req.setAttribute("candidates", DbStore.instanceOf().findRecentCandidates());
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }
}
