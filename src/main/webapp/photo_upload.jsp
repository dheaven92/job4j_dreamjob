<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="header.jsp" />
<body>
<div class="container">
    <jsp:include page="navbar.jsp" />
    <div class="row pt-3">
        <a href="<%=request.getContextPath()%>/candidates.do">Назад</a>
    </div>
    <div class="row pt-3">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Загрузить фото
            </div>
            <div class="card-body">
                <form
                        action="<%=request.getContextPath()%>/upload?id=<%=request.getParameter("id")%>"
                        method="post"
                        enctype="multipart/form-data"
                >
                    <div class="checkbox">
                        <input type="file" name="file">
                    </div>
                    <br>
                    <button type="submit" class="btn btn-primary">Загрузить</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>