<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 13.5.2020 г.
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <div class="wrapper">
        <section class="shop">
            <div class="form-search">
                <form action="/search">
                    <label for="searchInput">Search</label>
                    <input type="text" id="searchInput" name="search">
                </form>
            </div>
            <div class="shop-card">
                <span>0 - 0.00lv.</span>
            </div>
            <div class="sign-in">
                <a href="/login" class="button">sign in</a>
            </div>
        </section>
        <section class="navigation">
            <div class="site-branding">
                <img src="/resources/images/100KILA-logo.png" alt="100-kila-logo">
            </div>
            <nav class="site-nav">
                <ul>
                    <li>
                        <a href="/">home</a>
                        <span>First page</span>
                    </li>
                    <li>
                        <a href="#">event</a>
                        <span>Show dates</span>
                    </li>
                    <li>
                        <a href="/videos">video</a>
                        <span>productions</span>
                    </li>
                    <li>
                        <a href="/pictures">gallery</a>
                        <span>party pictures</span>
                    </li>
                    <li>
                        <a href="#">discography</a>
                        <span>album list</span>
                    </li>
                    <li>
                        <a href="#">100k shop</a>
                        <span>buy items</span>
                    </li>
                    <li>
                        <a href="#">biography</a>
                        <span>story of my life</span>
                    </li>
                    <li>
                        <a href="#">contact</a>
                        <span>how to reach me</span>
                    </li>
                </ul>
            </nav>
        </section>
    </div>
</html>
