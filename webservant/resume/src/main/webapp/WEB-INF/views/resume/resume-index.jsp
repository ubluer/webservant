<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@include file="/WEB-INF/views/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ include file="/WEB-INF/views/common/_include.jsp"%>
    <title>Bootstrap 101 Template</title>
    <meta name="description" content="Programmer">
    <meta name="viewport" content="width=device-width">
    <!-- resume -->
    <link href="${ctx}/assets/res/css/resume-main.css" rel="stylesheet">
</head>

<body class="resume-body">
<div class="background fade in"></div>
<div class="grid-flicker background fade in points"></div>
<main>
    <div class="resume-main container">
        <section class="fade in">
            <h1 class="fade in">FUNC(Xiang:Y)</h1>
            <h1>
                <span class="eyebow" style="opacity: 1; transform: matrix(1,0,0,1,0,0);">Hello, world.</span>
                <span class="large-block" style="opacity: 1; transform: matrix(1,0,0,1,0,0);">I'm a programmer</span>
                <br>
                in China.
            </h1>
            <p class="lead">
                <a class="btn btn-lg btn-primary" href="https://github.com/ubluer" style="opacity: 1; transform: matrix(1,0,0,1,0,0);transform-origin: 50% 50% 0px;">Follow me on GitHub</a>
            </p>
        </section>
    </div>
</main>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${ctx}/assets/plugin/jquery/jquery-1.11.3.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${ctx}/assets/plugin/bootstrap/js/bootstrap.js"></script>
</body>
</html>