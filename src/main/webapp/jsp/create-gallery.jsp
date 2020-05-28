<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 19.5.2020 г.
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>--%>

<html>
<head>
    <c:import url="templates/head.jsp"/>
</head>
<body>
<div class="site">
    <header class="site-header">
        <c:import url="templates/navbar.jsp"/>
    </header>
    <main class="site-main">
        <div class="wrapper">
            <div class="form">
                <section class="section-title">
                    <h4>Create Video</h4>
                </section>
                <section class="section-create-video">
                    <form action="/create/gallery" method="POST" enctype="multipart/form-data">
                        <div class="container">
                            <div class="label">
                                <label for="nameInput">Gallery Name:</label>
                            </div>
                            <input type="text" id="nameInput" name="name">
                        </div>
                        <div class="container upl-img">
                            <div class="label add-buttons">
                                <label for="nameInput">Image:</label>
                                <div id="addUploadButton" class="button add-new-line">Add</div>
                            </div>
                        </div>
                        <button type="submit" class="button create">Create Video</button>
                    </form>
                </section>
            </div>
        </div>
    </main>
    <footer class="site-footer">
        <c:import url="templates/footer.jsp"/>
    </footer>
</div>
<script src="<c:url value="/resources/js/add-new-image.js"/>"></script>
</body>
</html>
