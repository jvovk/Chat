<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <script src="<c:url value="/resources/js/jquery-2.1.4.min.js"/>"></script>
    <title>Simple Chat</title>
    <jsp:invoke fragment="header"/>
</head>
<body>
<div class="container">
    <div class="row">
        <jsp:doBody/>
    </div>
</div>
</body>
<jsp:invoke fragment="footer"/>
