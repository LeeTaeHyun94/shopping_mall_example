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
                                <input type="email" id="username" name="username" placeholder="example@email.com" required="required" />
                            </div>
                            <div class="input_area">
                                <label for="password">Password : </label>
                                <input type="password" id="password" name="password" required="required" />
                            </div>
                            <div class="input_area">
                                <label for="name">Name : </label>
                                <input type="name" id="name" name="name" placeholder="이름을 입력해주세요." required="required" />
                            </div>
                            <div class="input_area">
                                <label for="phoneNumber">Phone_number : </label>
                                <input type="phoneNumber" id="phoneNumber" name="phoneNumber" placeholder="'-'를 제외한 연락처를 입력해주세요." required="required" />
                            </div>
                            <div class="input_area">
                                <label for="address">주소 : </label>
                                <input type="address" id="address" name="address" placeholder="주소를 입력해주세요." required="required" />
                            </div>
                            <div class="input_area">
                                <label for="detailAddress">상세 주소 : </label>
                                <input type="detailAddress" id="detailAddress" name="detailAddress" placeholder="상세 주소를 입력해주세요." required="required" />
                            </div>
                            <div class="input_area">
                                <label for="zipcode">우편번호 : </label>
                                <input type="zipcode" id="zipcode" name="zipcode" placeholder="우편번호를 입력해주세요." required="required" />
                            </div>
                            <button type="submit" id="signup_btn" name="signup_btn">회원가입</button>
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
