<%--
  Created by IntelliJ IDEA.
  User: hyun
  Date: 19. 3. 30
  Time: 오후 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul>
    <c:if test="${user == null}">
        <li>
            <a href="/user/signin">로그인</a>
        </li>
        <li>
            <a href="/user/signup">회원가입</a>
        </li>
    </c:if>
    <c:if test="${user != null}">
        <c:if test="${user.isEmailVerified == 9}">
            <a href="/admin/index">관리자 화면</a>
        </c:if>
        <li>
            ${user.username} 님, 환영합니다!
        </li>
        <li>
            <a href="/user/signout">로그아웃</a>
        </li>
    </c:if>
</ul>