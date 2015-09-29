<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@include file="/WEB-INF/views/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <%@ include file="/WEB-INF/views/common/_include.jsp"%>
  <title>Bootstrap 101 Template</title>
  <meta name="description" content="Programmer">
  <meta name="viewport" content="width=device-width">
  <!-- cover -->
  <link href="${ctx}/assets/res/css/cover-main.css" rel="stylesheet">
</head>

<body class="cover-body">
<div class="layout">
  <header class="navbar navbar-static-top bs-docs-nav" id="top" role="banner">
    <div class="container">
      <div class="navbar-header">
        <button class="navbar-toggle collasped" type="button" data-toggle="collapse" data-target="#bs-navbar" aria-controls="bs-navbar" aria-expanded="false">
          <span class="sr-only">toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a href="${ctx}/cover/index.do" class="navbar-brand">XYU</a>
      </div>
      <nav id="bs-navbar" class="navbar-collapse collapse in" aria-expanded="true" style="height: 1px;">
        <ul class="nav navbar-nav">
          <li class="active"><a href="${ctx}/cover/index.do">Cover</a> </li>
          <li><a href="${ctx}/resume/index.do">Resume</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li>
          <a href="${ctx}/resume/index.do" target="_blank">Resume</a>
          </li>
        </ul>
      </nav>
    </div>

  </header>
  <nav>nav</nav>
  <div>homeBanner
    <h1 class="heading" style="font-family: 'Amatic SC';">UNFOLD YOUR IDEAS</h1>
    <h2 class="subheading">Task Management</h2>
    <h3 class="login-txt">Good Morning</h3><strong>xiang.yu</strong>
    <div class="check-button">CHECK</div>
    <img src="${ctx}/assets/res/image/home-banner.jpg">;
  </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${ctx}/assets/plugin/jquery/jquery-1.11.3.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${ctx}/assets/plugin/bootstrap/js/bootstrap.js"></script>
</body>
</html>