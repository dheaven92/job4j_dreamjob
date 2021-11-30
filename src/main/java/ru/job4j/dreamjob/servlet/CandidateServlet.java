package ru.job4j.dreamjob.servlet;

import ru.job4j.dreamjob.model.Candidate;
import ru.job4j.dreamjob.store.Store;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CandidateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.setCharacterEncoding("UTF-8");
        Store.instanceOf().saveCandidate(new Candidate(0, req.getParameter("name")));
        res.sendRedirect(req.getContextPath() + "/candidates.jsp");
    }
}
