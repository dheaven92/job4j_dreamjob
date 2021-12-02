<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="ru.job4j.dreamjob.store.DbStore" %>
<%@ page import="ru.job4j.dreamjob.model.Post" %>
<!doctype html>
<jsp:include page="../header.jsp" />
<body>
<div class="container">
    <jsp:include page="../navbar.jsp" />
    <%
        String id = request.getParameter("id");
        Post post = new Post(0, "");
        if (id != null) {
            post = DbStore.instanceOf().findPostById(Integer.parseInt(id));
        }
    %>
    <div class="row pt-3">
        <div class="card" style="width: 100%">
            <div class="card-header">
                <% if (id == null) { %>
                Новая вакансия
                <% } else { %>
                Редактирование вакансии
                <% } %>
            </div>
            <div class="card-body">
                <form action="<%=request.getContextPath()%>/posts.do?id=<%=post.getId()%>" method="post">
                    <div class="form-group">
                        <label>Имя</label>
                        <input type="text" class="form-control" name="name" value="<%=post.getName()%>">
                    </div>
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>