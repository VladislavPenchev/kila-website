<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 18.5.2020 г.
  Time: 19:13
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
        <div class="wrapper ">
            <div class="form">
                <section class="section-title">
                    <h4>videos</h4>
                </section>
                <section class="elements">
                    <ul>
                        <c:forEach items="${listVideos}" var="video">
                            <li class="card">
                                <img src="../resources/images/${video.imageId}.jpg" alt="#">
                            </li>
                        </c:forEach>
                        <%--                        <li class="card">--%>
                        <%--                            <h2>D2 x 100 KILA – Ди ...</h2>--%>
                        <%--                            <img src="../kilata_pic/song_divi_i_shtastlivi.jpg" alt="">--%>
                        <%--                        </li>--%>
                    </ul>
                </section>
                <section class="section-paging">
                    <div>
                        <c:if test="${currentPage != 1}">
                            <a class="button paging-button"
                               href="videos?recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}"><<</a>
                        </c:if>

                        <c:forEach begin="1" end="${noOfPages}" var="i">
                            <c:choose>
                                <c:when test="${currentPage eq i}">
                                    <a class="button paging-button">${i}</a>
                                </c:when>
                                <c:otherwise>
                                    <a class="button paging-button"
                                       href="videos?recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>

                        <c:if test="${currentPage lt noOfPages}">
                            <a class="button paging-button"
                               href="videos?recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">>></a>
                        </c:if>
<%--                        <a href="#" class="button paging-button"><<</a>--%>
<%--                        <a href="#" class="button paging-button">1</a>--%>
<%--                        <a href="#" class="button paging-button">2</a>--%>
<%--                        <a href="#" class="button paging-button">3</a>--%>
<%--                        <a href="#" class="button paging-button">>></a>--%>
                    </div>
                    <div>
                        <span>Page ${currentPage} of ${noOfPages}</span>
                    </div>
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
