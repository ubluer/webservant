<%--
  Created by IntelliJ IDEA.
  User: Xiany.Yu
  Date: 2015/10/6 0006
  Time: 16:47
--%>
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
<body>
<div class="layout">
    <%@ include file="/WEB-INF/views/layout/_header.jsp"%>
    <main>
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12">
                    <form class="form-horizontal" action="${ctx}/login.do" style="margin:0px auto" method="post">
                        <div class="form-group">
                            <label for="username" class="col-sm-2 control-label">用户名：</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="username" name="username"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">密码：</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="password" name="password" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="checkbox">
                                    <label><input type="checkbox" name="rememberMe"/> 记住我</label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">登录</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </main>
</div>
<div>

</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${ctx}/assets/plugin/jquery/jquery-1.11.3.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${ctx}/assets/plugin/bootstrap/js/bootstrap.js"></script>
</body>


</html>
