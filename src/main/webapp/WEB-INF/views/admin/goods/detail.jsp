<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Hyun Admin</title>
        <link rel="stylesheet" href="/resources/css/AdminIndex.css"/>
        <link rel="stylesheet" href="/resources/css/AdminRegisterGoods.css"/>
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
                    <h2>상품 정보</h2>
                    <form role="form" method="post" autocomplete="off">
                        <input type="hidden" name="id" value="${goods.id}">
                        <div class="inputArea">
                            <label>1차 분류</label>
                            <span class="firstCategory">
                                <c:if test="${goods.categoryIdRef != 0}">${goods.categoryIdRef}</c:if>
                                <c:if test="${goods.categoryIdRef == 0}">${goods.categoryId}</c:if>
                            </span>

                            <label>2차 분류</label>
                            <span class="secondCategory">
                                <c:if test="${goods.categoryIdRef != 0}">${goods.categoryId}</c:if>
                            </span>
                        </div>

                        <div class="inputArea">
                            <label for="name">상품명 : </label>
                            <span id="name">${goods.name}</span>
                        </div>

                        <div class="inputArea">
                            <label for="price">상품 가격 : </label>
                            <span id="price"><fmt:formatNumber value="${goods.price}" pattern="###,###,###" /></span>
                        </div>

                        <div class="inputArea">
                            <label for="stock">상품 수량 : </label>
                            <span id="stock">${goods.stock}</span>
                        </div>

                        <div class="inputArea">
                            <label for="description">상품 소개 : </label>
                            <span id="description">${goods.description}</span>
                        </div>

                        <div class="inputArea">
                            <label>이미지 : </label>
                            <p>원본 이미지</p>
                            <img class="oriImg" src="${goods.imgUrl}" />
                            <p>썸네일</p>
                            <img class="thumbImg" src="${goods.thumbImgUrl}" />
                        </div>

                        <div class="inputArea">
                            <button type="button" id="modify_btn" class="btn btn-warning">수정</button>
                            <button type="button" id="delete_btn" class="btn btn-danger">삭제</button>
                        </div>
                    </form>
                </div>
            </section>
            <footer id="footer">
                <div id="footer_box">
                    <%@ include file="../include/footer.jsp" %>
                </div>
            </footer>
        </div>
    </body>
    <script>
        let formObject = $("form[role='form']");

        $("#modify_btn").click(function () {
            formObject.attr("method", "get");
            formObject.attr("action", "/admin/goods/modify");
            formObject.submit();
        });

        $("#delete_btn").click(function () {
            let confirmed = confirm("삭제하시겠습니까?");
            if (confirmed) {
                formObject.attr("action", "/admin/goods/delete");
                formObject.submit();
            }
        });
    </script>
</html>
