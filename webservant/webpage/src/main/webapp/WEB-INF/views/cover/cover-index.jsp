<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ include file="/WEB-INF/views/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ include file="/WEB-INF/views/common/_include.jsp" %>
    <title>Cover</title>
    <meta name="description" content="Programmer">
    <meta name="viewport" content="width=device-width">
    <!-- cover -->
    <link href="${ctx}/assets/res/css/cover-main.css" rel="stylesheet">
</head>
<body class="cover-body">
<div class="layout">
    <%@ include file="/WEB-INF/views/layout/_header.jsp"%>
    <main id="cover-main" class="cover-main">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 text-center">
                    <h1 class="heading" style="font-family: 'Amatic SC';">UNFOLD YOUR IDEAS</h1>

                    <h2 class="subheading">Task Management</h2>

                    <h3 class="login-txt">Good Morning</h3><strong>xiang.yu</strong>

                    <div class="check-button">CHECK</div>
                    <img src="${ctx}/assets/res/img/home-banner.jpg">
                </div>
            </div>
        </div>
    </main>
</div>
<div>

</div>


</body>


</html>