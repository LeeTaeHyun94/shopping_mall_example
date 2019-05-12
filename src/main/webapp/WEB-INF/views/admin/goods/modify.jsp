<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Hyun Admin</title>
        <link rel="stylesheet" href="/resources/css/AdminIndex.css"/>
        <link rel="stylesheet" href="/resources/css/AdminRegisterGoods.css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://cdn.ckeditor.com/4.11.4/standard/ckeditor.js"></script>
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
                    <h2>상품 등록</h2>
                    <form role="form" method="post" autocomplete="off" enctype="multipart/form-data">
                        <input type="hidden" name="id" value="${goods.id}">
                        <div class="inputArea">
                            <label>1차 분류</label>
                            <select class="firstCategory">
                                <option value="">전체</option>
                            </select>

                            <label>2차 분류</label>
                            <select class="secondCategory" name="categoryId">
                                <option value="">전체</option>
                            </select>
                        </div>

                        <div class="inputArea">
                            <label for="name">상품명 : </label>
                            <input type="text" id="name" name="name" value="${goods.name}">
                        </div>

                        <div class="inputArea">
                            <label for="price">상품 가격 : </label>
                            <input type="text" id="price" name="price" value="${goods.price}">
                        </div>

                        <div class="inputArea">
                            <label for="stock">상품 수량 : </label>
                            <input type="text" id="stock" name="stock" value="${goods.stock}">
                        </div>

                        <div class="inputArea">
                            <label for="description">상품 소개 : </label>
                            <textarea rows="5" cols="50" id="description" name="description">${goods.description}</textarea>
                            <script>
                                let ckeditor_config = {
                                    resize_enable: false,
                                    enterMode: CKEDITOR.ENTER_BR,
                                    shiftEnterMode: CKEDITOR.ENTER_P,
                                    filebrowserUploadUrl: "/admin/goods/ckupload",
                                };
                                CKEDITOR.replace("description", ckeditor_config);
                            </script>
                        </div>

                        <div class="inputArea">
                            <label for="imgFile">이미지 : </label>
                            <input type="file" id="imgFile" name="imgFile" />
                            <div class="select_img">
                                <img src="${goods.imgUrl}" />
                                <input type="hidden" name="imgUrl" value="${goods.imgUrl}" />
                                <input type="hidden" name="thumbImgUrl" value="${goods.thumbImgUrl}" />
                            </div>
                            <script>
                                $("#imgFile").change(function () {
                                    if (this.files && this.files[0]) {
                                        let fileReader = new FileReader();
                                        fileReader.onload = function (data) {
                                            $(".select_img img").attr("src", data.target.result).width(500);
                                        };
                                        fileReader.readAsDataURL(this.files[0]);
                                    }
                                });
                            </script>
                        </div>

                        <div class="inputArea">
                            <button type="submit" id="modify_btn" class="btn btn-primary">수정 완료</button>
                            <button type="button" id="cancel_btn" class="btn btn-warning">취소</button>
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
        <script>
            let selectedCategoryId = ${goods.categoryId}, selectedCategoryName = "${goods.secondCategoryName}", selectedCategoryIdRef = ${goods.categoryIdRef};

            let firstCategory = $(".firstCategory"), secondCategory = $(".secondCategory");

            if (selectedCategoryIdRef != 0) {
                firstCategory.val(selectedCategoryIdRef);

                firstCategory.children().remove();
                firstCategory.append("<option value='" + selectedCategoryIdRef + "'>" + "${goods.firstCategoryName}" + "</option>");
                secondCategory.val(selectedCategoryId);
                secondCategory.children().remove();
                secondCategory.append("<option value='" + selectedCategoryId + "'>" + selectedCategoryName + "</option>");
            } else {
                firstCategory.val(selectedCategoryId);
                firstCategory.children().remove();
                firstCategory.append("<option value='" + selectedCategoryId + "'>" + "${goods.secondCategoryName}" + "</option>");
                secondCategory.val(selectedCategoryId);
                secondCategory.append("<option value='" + selectedCategoryId + "' selected>전체</option>");
            }

            $("#cancel_btn").click(function () {
                location.href = "/admin/goods/detail?id=" + ${goods.id};
            });
        </script>
    </body>
</html>
