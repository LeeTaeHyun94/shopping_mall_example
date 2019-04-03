<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Hyun Admin</title>
        <link rel="stylesheet" href="/resources/css/AdminIndex.css"/>
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
                    <h2>상품 등록</h2>
                    <form role="form" method="post" autocomplete="off">
                        <label>1차 분류</label>
                        <select class="firstCategory">
                            <option value="">전체</option>
                        </select>

                        <label>2차 분류</label>
                        <select class="secondCategory">
                            <option value="">전체</option>
                        </select>
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
            let jsonData = JSON.parse('${goodsCategories}');
            console.log(jsonData);

            let firstCategories = new Array();

            for (let i  = 0; i < jsonData.length; i++)
                if (jsonData[i].categoryIdRef === 0) {
                    let firstCategoryObject = new Object();
                    firstCategoryObject.id = jsonData[i].id;
                    firstCategoryObject.name = jsonData[i].name;
                    firstCategories.push(firstCategoryObject);
                }

            let firstCategorySelectBox = $('select.firstCategory');

            for (let i = 0; i < firstCategories.length; i++)
                firstCategorySelectBox.append("<option value='" + firstCategories[i].id + "'>" + firstCategories[i].name + "</option>");

            $(document).on("change", "select.firstCategory", function () {
                let secondCategories = new Array();

                for (let i  = 0; i < jsonData.length; i++)
                    if (jsonData[i].categoryIdRef !== 0) {
                        let secondCategoryObject = new Object();
                        secondCategoryObject.id = jsonData[i].id;
                        secondCategoryObject.name = jsonData[i].name;
                        secondCategoryObject.categoryIdRef = jsonData[i].categoryIdRef;
                        secondCategories.push(secondCategoryObject);
                    }

                let secondCategorySelectBox = $('select.secondCategory');

                secondCategorySelectBox.children().remove();

                $("option:selected", this).each(function () {
                    let selectedFirstCategory = $(this).val();
                    secondCategorySelectBox.append("<option value=''>전체</option>");
                    for (let i = 0; i < secondCategories.length; i++)
                        if (selectedFirstCategory == secondCategories[i].categoryIdRef)
                            secondCategorySelectBox.append("<option value='" + secondCategories[i].id + "'>" + secondCategories[i].name + "</option>");
                });
            })
        </script>
    </body>
</html>
