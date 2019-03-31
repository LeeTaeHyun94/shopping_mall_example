<%--
  Created by IntelliJ IDEA.
  User: hyun
  Date: 19. 3. 30
  Time: 오후 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Hyun</title>
    </head>
    <body>
        <div id="root">
            <header id="header">
                <div id="header_box">
                    <%@ include file="../include/header.jsp"%>
                </div>
            </header>
            <nav id="nav_box">
                <%@ include file="../include/nav.jsp"%>
            </nav>
            <section id="container">
                <div id="container_box">
                    <section id="content">
                        <form role="form" method="post" autocomplete="off">
                            <div class="input_area">
                                <label for="username">Username : </label>
                                <input id="username" name="username" required="required" />
                            </div>
                            <div class="input_area">
                                <label for="password">Password : </label>
                                <input type="password" id="password" name="password" required="required" />
                            </div>
                            <button type="submit" id="signin_btn" name="signin_btn">로그인</button>
                            <c:if test="${msg == false}">
                                <p style="color: #ff000000;">Login Failed</p>
                            </c:if>
                        </form>
                    </section>
                </div>
            </section>
            <footer id="footer">
                <div id="footer_box">
                    <%@ include file="../include/footer.jsp" %>
                </div>
            </footer>
        </div>
    </body>
</html>
