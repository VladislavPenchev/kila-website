<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 31.5.2020 г.
  Time: 13:43
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
        <div class="wrapper wrapper-main">
            <div class="wrapper wrapper-content">
                <div class="form">
                    <section class="section-title">
                        <h4>Discography</h4>
                    </section>
                    <section class="section-article">
                        <ul>
                            <c:forEach items="${model}" var="discography" >
                                <li id="${discography.id}">
                                    <div class="article-img">
                                        <c:forEach items="${discography.images}" var="img" >
                                            <img src="data:image/jpeg;base64,${img.image_content}" alt="" id="${img.id}">
                                        </c:forEach>
                                    </div>
                                    <div class="article-content">
                                        <h2 class="article-title">${discography.name}</h2>
                                        <span class="article-info">Година : ${discography.year}</span>
                                        <span class="article-info">Времетраене : ${discography.duration}</span>
                                        <span class="article-info">Битрейт : ${discography.bitrate}</span>
                                        <a href="/discography/${discography.id}" class="button article-button">Read more</a>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </section>
                </div>
            </div>
            <div class="wrapper wrapper-aside">
                <div class="form">
                    <section class="section-title">
                        <h4>LATEST VIDEOS</h4>
                    </section>
                    <section class="section-sidebar">
<%--                        <div id="slider">--%>
<%--                            <figure>--%>
<%--                                <img src="../kilata_pic/100kila_store2.jpg" alt="">--%>
<%--                                <img src="../kilata_pic/100kila_store.jpg" alt="">--%>
<%--                                <img src="../kilata_pic/jabulah.png" alt="">--%>
<%--                                <img src="../kilata_pic//HHI-new-BIG-10-2015-LAST.png" alt="">--%>
<%--                                <img src="../kilata_pic//100kila_store2.jpg" alt="">--%>
<%--                            </figure>--%>
<%--                        </div>--%>
                    </section>
                </div>
                <div class="form">
                    <section class="section-title">
                        <h4>100k shop</h4>
                    </section>
                    <section class="section-content-aside">
<%--                        <ul>--%>
<%--                            <li>--%>
<%--                                <div class="img">--%>
<%--                                    <img src="../kilata_pic/100kila_store2.jpg" alt="">--%>
<%--                                </div>--%>
<%--                                <div class="content">--%>
<%--                                    <a href="#">LONG SLEEVE HORTA "100 KILA X PANDA"</a>--%>
<%--                                    <p>50.00лв.</p>--%>
<%--                                </div>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <div class="img">--%>
<%--                                    <img src="../kilata_pic/100kila_store2.jpg" alt="">--%>
<%--                                </div>--%>
<%--                                <div class="content">--%>
<%--                                    <a href="#">LONG SLEEVE HORTA "100 KILA X PANDA"</a>--%>
<%--                                    <p>50.00лв.</p>--%>
<%--                                </div>--%>
<%--                            </li>--%>
<%--                        </ul>--%>
                    </section>
                </div>
                <div class="form">
                    <section class="section-title">
                        <h4>100KILA FACEBOOK</h4>
                    </section>
                    <section class="section-sidebar">

                    </section>
                </div>
                <div class="form">
                    <section class="section-title">
                        <h4>100KILA INSTAGRAM</h4>
                    </section>
                    <section class="section-sidebar">

                    </section>
                </div>
            </div>
        </div>
    </main>
    <footer class="site-footer">
        <c:import url="templates/footer.jsp"/>
    </footer>
</div>
</body>
</html>


