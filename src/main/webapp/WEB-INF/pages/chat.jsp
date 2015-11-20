<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:template>

    <jsp:attribute name="header">
      <link href="<c:url value="/resources/custom_css/chat.css"/>" rel="stylesheet"/>
    </jsp:attribute>

    <jsp:attribute name="footer">
        <script src="<c:url value="/resources/js/sock.min.js"/>"></script>
        <script src="<c:url value="/resources/js/jquery.tmpl.js"/>"></script>
        <script src="<c:url value="/resources/js/stomp.js"/>"></script>
        <script src="<c:url value="/resources/custom_js/chat.js"/>"></script>
    </jsp:attribute>

    <jsp:body>

        <input type="hidden" value="${pageContext.request.contextPath}" id="context-path">

        <noscript><h2>Enable Java Script and reload this page to run WebSocket Chat</h2></noscript>

        <div class="col-md-8 col-md-offset-2">
            <div class="messenger-container">
                <h5>Chat Room:</h5>

                <div class="well">
                    <div class="panel panel-info">
                        <div class="panel-body">
                            <div class="message-container">
                                <div id="response"></div>
                            </div>
                        </div>
                        <div class="panel-footer">
                            <div class="message-form">
                                <div class="row">
                                    <div class="col-md-10">
                                        <div class="panel panel-default">
                                            <div class="input-message">
                                                <div id="form-group-message">
                                                <textarea placeholder="Your message" class="form-control" id="message"
                                                          rows="3" autofocus></textarea>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <button type="button" class="btn btn-sm btn-primary btn-block"
                                                id="send-message"
                                                style="margin-bottom: 15px" onclick="sendMessage()">Send
                                        </button>
                                        <button type="button" class="btn btn-sm btn-primary btn-block"
                                                id="btn-logout" onclick="logout()">Log out
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:template>