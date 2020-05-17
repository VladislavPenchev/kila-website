<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 15.5.2020 г.
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <form action="/create/video" method="POST">
                        <div class="container">
                            <div class="label">
                                <label for="nameInput">Video name:</label>
                            </div>
                            <input type="text" id="nameInput" name="name">
                        </div>
                        <!-- <div>
                            <label for="addImageInput">Add image</label>
                            <input type="text" id="addImageInput" name="name">
                        </div> -->
                        <div class="container">
                            <div class="label">
                                <label for="youtubeUrlInput">YouTube url:</label>
                            </div>
                            <input type="text" id="youtubeUrlInput" name="youTubeUrl">
                        </div>
                        <div class="container">
                            <div class="label">
                                <label for="timeInput">Time:</label>
                            </div>
                            <input type="text" id="timeInput" name="time">
                        </div>
                        <div class="container description">
                            <div class="label add-buttons">
                                <label for="descriptionInput">Description:</label>
                                <div id="addDescriptionNewLine" class="button add-new-line">Add</div>
                            </div>
                            <div id="divDescription" class="inputs">
                                <input type="text" id="descriptionInput" name="description">
                                <div id="deleteDescription" class="button delete">Delete</div>
                            </div>
                        </div>
                        <div class="container tag">
                            <div class="label add-buttons">
                                <label for="tagInput">Tags:</label>
                                <div id="addTag" class="button add-new-line">Add</div>
                            </div>
                            <input type="text" id="tagInput" name="tags">
                        </div>
                        <div class="container singer">
                            <div class="label add-buttons">
                                <label for="singerInput">Singers:</label>
                                <div id="addSinger" class="button add-new-line">Add</div>
                            </div>
                            <input type="text" id="singerInput" name="singer">
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
<script src="<c:url value="/resources/js/create-new-description.js"/>"></script>
</body>
</html>
