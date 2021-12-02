package ru.job4j.dreamjob.servlet;

import ru.job4j.dreamjob.config.PropertiesConfig;
import ru.job4j.dreamjob.model.Candidate;
import ru.job4j.dreamjob.store.MemStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class CandidateServlet extends HttpServlet {

    private final static String CANDIDATES_PATH = "/candidates.do";
    private final static String CANDIDATE_DELETE_PATH = "/candidate/delete";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (CANDIDATES_PATH.equals(req.getServletPath())) {
            req.setAttribute("candidates", MemStore.instanceOf().findAllCandidates());
            req.getRequestDispatcher("candidates.jsp").forward(req, res);
        }
        if (CANDIDATE_DELETE_PATH.equals(req.getServletPath())) {
            String id = req.getParameter("id");
            MemStore.instanceOf().deleteCandidate(Integer.parseInt(id));
            String imagesFolder = PropertiesConfig.getConfig().getProperty("path.images");
            for (File file : new File(imagesFolder).listFiles()) {
                if (file.getName().contains(id)) {
                    file.delete();
                    break;
                }
            }
            res.sendRedirect(req.getContextPath() + CANDIDATES_PATH);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.setCharacterEncoding("UTF-8");
        MemStore.instanceOf().saveCandidate(
                new Candidate(
                        Integer.parseInt(req.getParameter("id")),
                        req.getParameter("name")
                )
        );
        res.sendRedirect(req.getContextPath() + CANDIDATES_PATH);
    }
}
