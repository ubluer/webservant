<%--
  Created by IntelliJ IDEA.
  User: Xiang
  Date: 2015/10/17
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>

<!-- basic scripts -->

<!--[if !IE]> -->

<script src="${ctx}/assets/plugin/jquery/jquery-2.1.4.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="${ctx}/assets/plugin/jquery/jquery-1.11.3.js"></script>
<![endif]-->

<script type="text/javascript">
  if("ontouched" in document) document.write("<script src='${ctx}/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="${ctx}/assets/plugin/bootstrap/js/bootstrap.js"></script>
<script src="${ctx}/assets/plugin/ace/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->

<script src="${ctx}/assets/plugin/ace/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="${ctx}/assets/plugin/ace/js/jqGrid/jquery.jqGrid.min.js"></script>
<script src="${ctx}/assets/plugin/ace/js/jqGrid/i18n/grid.locale-en.js"></script>

<!-- ace scripts -->

<script src="${ctx}/assets/plugin/ace/js/ace-elements.min.js"></script>
<script src="${ctx}/assets/plugin/ace/js/ace.min.js"></script>