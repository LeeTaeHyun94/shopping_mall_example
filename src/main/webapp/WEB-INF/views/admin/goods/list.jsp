<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <title>Hyun Admin</title>
        <link rel="stylesheet" href="/resources/css/AdminIndex.css"/>
        <link rel="stylesheet" href="/resources/css/AdminRegisterGoods.css"/>
        <link rel="stylesheet" href="/resources/css/AdminGoodsList.css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
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
                <aside>
                    <%@ include file="../include/aside.jsp"%>
                </aside>
                <div id="container_box">
                    <h2>상품 목록</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th>상품명</th>
                                <th>카테고리</th>
                                <th>가격</th>
                                <th>수량</th>
                                <th>등록일</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${goodsList}" var="goods">
                                <tr>
                                    <td>${goods.id}</td>
                                    <td>
                                        <a href="/admin/goods/detail?goodsid=${goods.id}">${goods.name}</a>
                                    </td>
                                    <td>${goods.categoryId}</td>
                                    <td>
                                        <fmt:formatNumber value="${goods.price}" pattern="###,###,###" />
                                    </td>
                                    <td>${goods.stock}</td>
                                    <td>
                                        <fmt:formatDate value="${goods.reg_date}" pattern="yyyy-MM-dd" />
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
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
