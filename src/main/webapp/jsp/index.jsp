<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 17.5.2020 г.
  Time: 17:24
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
                <section class="section-iframe">
                    <iframe src="https://www.youtube.com/embed/${youTubeUrl}" frameborder="0"
                            allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                            allowfullscreen></iframe>
                </section>
            </div>
            <div class="form">
                <section class="section-title">
                    <h4>latest videos</h4>
                </section>
                <section class="section-lastest-videos">
                    <ul>
                        <c:forEach items="${latestVideos}" var="lvideo">
                            <li id="${lvideo.id}">
                                <img src="../resources/images/${lvideo.imageId}.jpg" alt="#">
                                <a href="/videos/${lvideo.id}">${lvideo.name}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </section>
                <section class="load-videos">
                    <ul>
                        <c:forEach items="${posts}" var="post">
                            <li id="${post.id}">
                                <div class="video-image">
                                    <img src="../resources/images/${post.imageId}.jpg" alt="#">
                                </div>
                                <div class="video-content">
                                    <a href="/posts/${post.id}" class="video-title">${post.name}</a>
                                    <p class="video-description">${post.description}</p>
                                    <a href="/posts/${post.id}" class="button video-button">read more</a>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </section>
            </div>
        </div>
    </main>
    <footer class="site-footer">
        <c:import url="templates/footer.jsp"/>
    </footer>
</div>
</body>
</html>
