<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="ru.job4j.dreamjob.store.DbStore" %>
<%@ page import="ru.job4j.dreamjob.model.Candidate" %>
<!doctype html>
<html lang="en">
<jsp:include page="../header.jsp" />
<body>
<div class="container">
    <jsp:include page="../navbar.jsp" />
    <%
        String id = request.getParameter("id");
        Candidate candidate = new Candidate(0, "");
        if (id != null) {
            candidate = DbStore.instanceOf().findCandidateById(Integer.parseInt(id));
        }
    %>
    <div class="row pt-3">
        <div class="card" style="width: 100%">
            <div class="card-header">
                <% if (id == null) { %>
                Новый кандидат
                <% } else { %>
                Редактирование кандидата
                <% } %>
            </div>
            <div class="card-body">
                <form action="<%=request.getContextPath()%>/candidates.do?id=<%=candidate.getId()%>" method="post">
                    <div class="form-group">
                        <label>Имя</label>
                        <input type="text" class="form-control" name="name" value="<%=candidate.getName()%>">
                    </div>
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>