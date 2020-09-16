<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 30.5.2020 г.
  Time: 19:42
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
                    <h4>Create discography</h4>
                </section>
                <section class="section-create-video">
                    <form action="/create/discography" method="POST" enctype="multipart/form-data">
                        <div class="container">
                            <div class="label">
                                <label for="nameInput">Discography name:</label>
                            </div>
                            <input type="text" id="nameInput" name="name">
                        </div>
                        <div class="container">
                            <div class="label">
                                <label for="yearInput">Year:</label>
                            </div>
                            <input type="text" id="yearInput" name="year">
                        </div>
                        <div class="container">
                            <div class="label">
                                <label for="yearInput">Duration:</label>
                            </div>
                            <input type="text" id="durationInput" name="duration">
                        </div>
                        <div class="container">
                            <div class="label">
                                <label for="bitRateInput">BitRate:</label>
                            </div>
                            <input type="text" id="bitRateInput" name="bitrate">
                        </div>
                        <div class="container description">
                            <div class="label add-buttons">
                                <label>Song:</label>
                                <div id="addNewDiscography" class="button add-new-line">Add</div>
                            </div>
                        </div>
                        <div class="container upl-img">
                            <div class="label add-buttons">
                                <label for="nameInput">Image:</label>
                                <div id="addUploadButton" class="button add-new-line">Add</div>
                            </div>
                        </div>
                        <div class="container">
                            <div class="label">
                                <label for="yearInput">Can buy?</label>
                            </div>
                            <div class="checkbox">
                                <div class="btn-check">
                                    <label for="buyYes">Yes</label>
                                    <input type="checkbox" id="buyYes" name="buyYes">
                                </div>
                                <div class="btn-check">
                                    <label for="buyNo">No</label>
                                    <input type="checkbox" id="buyNo" name="buyNo">
                                </div>
                            </div>
                        </div>
                        <button type="submit" class="button create">Create Discography</button>
                    </form>
                </section>
            </div>
        </div>
    </main>
    <footer class="site-footer">
        <c:import url="templates/footer.jsp"/>
    </footer>
</div>
<script src="<c:url value="/resources/js/create-new-discography.js"/>"></script>
<script src="<c:url value="/resources/js/add-new-image.js"/>"></script>
</body>
</html>
