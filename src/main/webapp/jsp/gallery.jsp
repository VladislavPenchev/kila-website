<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 25.5.2020 г.
  Time: 17:43
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
                    <h4>gallery</h4>
                </section>
                <section class="section-gallery">
                    <ul>
                        <c:forEach items="${model}" var="gallery">
                            <li id="${gallery.id}">
                                <h3>${gallery.name}</h3>
                                <div class="images">
                                    <c:forEach items="${gallery.imageViewModels}" var="i">
                                        <img src="data:image/jpeg;base64,${i.image_content}" alt="" id="${i.id}">
                                    </c:forEach>
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

