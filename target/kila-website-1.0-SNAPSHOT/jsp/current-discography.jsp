<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 31.5.2020 г.
  Time: 10:09
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
    <div class="wrapper wrapper-main">
        <div class="wrapper wrapper-content">
            <div class="form">
                <section class="section-title">
                    <h4>${model.name}</h4>
                </section>
                <section class="section-cur-discography">
                    <div class="disc-pic-info">
                        <div class="disc-pictures">
                            <c:forEach items="${model.images}" var="i">
                                <img src="data:image/jpeg;base64,${i.image_content}" alt="" id="${i.id}">
                            </c:forEach>
                        </div>
                        <div class="disc-info">
                            <span>Година : ${model.year}</span>
                            <span>Времетраене : ${model.duration} минути</span>
                            <span>Битрейт : ${model.bitrate} kbps</span>
                        </div>
                    </div>
                    <div class="disc-songs">
                        <ul>
                            <c:forEach items="${model.videos}" var="v">
<%--                                <li id="${v.id}"><span>${v.name}</span></li>--%>
                                <li><span>${v.name}</span></li>
                            </c:forEach>
                        </ul>
                    </div>
                </section>
            </div>
        </div>
        <div class="wrapper wrapper-aside">
            <div class="form">
                <section class="section-title">
                    <h4>LATEST VIDEOS</h4>
                </section>
                <section class="section-sidebar">
<%--                    <div id="slider">--%>
<%--                        <figure>--%>
<%--                            <img src="../kilata_pic/100kila_store2.jpg" alt="">--%>
<%--                            <img src="../kilata_pic/100kila_store.jpg" alt="">--%>
<%--                            <img src="../kilata_pic/jabulah.png" alt="">--%>
<%--                            <img src="../kilata_pic//HHI-new-BIG-10-2015-LAST.png" alt="">--%>
<%--                            <img src="../kilata_pic//100kila_store2.jpg" alt="">--%>
<%--                        </figure>--%>
<%--                    </div>--%>
                </section>
            </div>
            <div class="form">
                <section class="section-title">
<%--                    <h4>100k shop</h4>--%>
                </section>
                <section class="section-content-aside">
<%--                    <ul>--%>
<%--                        <li>--%>
<%--                            <div class="img">--%>
<%--                                <img src="../kilata_pic/100kila_store2.jpg" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="content">--%>
<%--                                <a href="#">LONG SLEEVE HORTA "100 KILA X PANDA"</a>--%>
<%--                                <p>50.00лв.</p>--%>
<%--                            </div>--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <div class="img">--%>
<%--                                <img src="../kilata_pic/100kila_store2.jpg" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="content">--%>
<%--                                <a href="#">LONG SLEEVE HORTA "100 KILA X PANDA"</a>--%>
<%--                                <p>50.00лв.</p>--%>
<%--                            </div>--%>
<%--                        </li>--%>
<%--                    </ul>--%>
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

