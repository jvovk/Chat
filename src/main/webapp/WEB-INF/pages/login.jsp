<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:template>

    <jsp:attribute name="header">
         <link href="<c:url value="/resources/custom_css/login.css"/>" rel="stylesheet"/>
    </jsp:attribute>

    <jsp:attribute name="footer">
      <script src="<c:url value="/resources/custom_js/login.js"/>"></script>
    </jsp:attribute>

    <jsp:body>

        <input type="hidden" value="${pageContext.request.contextPath}" id="context-path">

        <noscript><h2>Enable Java Script and reload this page to login to chat</h2></noscript>

        <div class="col-md-4 col-xs-4 col-md-offset-4 col-xs-offset-4">
            <div class="alert alert-danger non-visible alert-danger-position" id="invalid-login" role="alert"></div>
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Log in to chat<a href="<c:url value="/login"/>"></a>
                    </h3>
                </div>
                <div class="panel-body">
                    <form role="form">
                        <fieldset>
                            <div class="form-group" id="form-group-login">
                                <label class="control-label" for="login">Login:</label>
                                <input class="form-control" placeholder="Login" id="login" type="text" autofocus>
                            </div>
                            <div class="form-group" id="form-group-password">
                                <label class="control-label" for="password">Password:</label>
                                <input class="form-control" placeholder="Password" id="password" type="password">
                            </div>
                            <button type="submit" class="btn btn-lg btn-primary btn-block" id="sign-in-btn">Sign in
                            </button>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </jsp:body>
</t:template>

