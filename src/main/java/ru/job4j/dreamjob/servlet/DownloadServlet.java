package ru.job4j.dreamjob.servlet;

import ru.job4j.dreamjob.config.PropertiesConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("id");
        File downloadFile = null;
        String imagesFolder = PropertiesConfig.getConfig().getProperty("path.images");
        for (File file : new File(imagesFolder).listFiles()) {
            if (file.getName().contains(name)) {
                downloadFile = file;
                break;
            }
        }
        try (FileInputStream in = new FileInputStream(downloadFile)) {
            res.getOutputStream().write(in.readAllBytes());
            res.setContentType("application/octet-stream");
            res.setHeader("Content-Disposition", "attachment; filename=\"" + downloadFile.getName() + "\"");
        }
    }
}
