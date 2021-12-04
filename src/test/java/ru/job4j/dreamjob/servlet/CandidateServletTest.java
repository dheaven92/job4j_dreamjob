package ru.job4j.dreamjob.servlet;

import org.junit.Test;
import ru.job4j.dreamjob.model.Candidate;
import ru.job4j.dreamjob.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CandidateServletTest {

    @Test
    public void whenCreateCandidate() throws IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse res = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("name")).thenReturn("New Candidate");
        new CandidateServlet().doPost(req, res);
        Candidate candidate = DbStore.instanceOf().findCandidateById(1);
        assertThat(candidate, notNullValue());
    }

    @Test
    public void whenEditCandidate() throws IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse res = mock(HttpServletResponse.class);
        DbStore.instanceOf().saveCandidate(new Candidate(0, "New candidate"));
        when(req.getParameter("id")).thenReturn("1");
        when(req.getParameter("name")).thenReturn("Updated candidate");
        new CandidateServlet().doPost(req, res);
        Candidate candidate = DbStore.instanceOf().findCandidateById(1);
        assertThat(candidate.getName(), is("Updated candidate"));
    }

    @Test
    public void whenDeleteCandidate() throws IOException, ServletException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse res = mock(HttpServletResponse.class);
        DbStore.instanceOf().saveCandidate(new Candidate(0, "New candidate"));
        when(req.getServletPath()).thenReturn("/candidate/delete.do");
        when(req.getParameter("id")).thenReturn("1");
        new CandidateServlet().doGet(req, res);
        Candidate candidate = DbStore.instanceOf().findCandidateById(1);
        assertThat(candidate, nullValue());
    }
}