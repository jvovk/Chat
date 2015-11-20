$(document).ready(function () {

    refresh();

    connect();

    //load messages when messages refresh
    function refresh() {
        //clean panel with messages
        $('#response').empty();

        //obtain context path of application
        var contextPath = $('#context-path').val();
        $.ajax({
            url: contextPath + "/messages",
            success: function (data) {
                if (data.length > 0) {
                    //template for message
                    var markup =
                        "<div>" +
                        "<div class='row'>" +
                        "<div class='col-xs-2'>" +
                        "<h5>${$item.getFullName()}:</h5>" +
                        "</div>" +
                        "<div class='col-xs-8'>" +
                        "<div class='alert alert-info' role='alert'>${message}" +
                        "</div>" +
                        "</div>" +
                        "<div class='col-xs-2'>" +
                        "<h5>${$item.getDate()}</h5>" +
                        "</div>" +
                        "</div>";
                    $.template("messageTemplate", markup);
                    $.tmpl("messageTemplate", data, {
                        getDate: function () {
                            //get time from date
                            return new Date(this.data.date).toLocaleTimeString();
                        },
                        getFullName: function () {
                            //get full name of user
                            return this.data.sender.fullName.toString();
                        }
                    }).appendTo("#response");

                    animateScroll();
                }
            }
        });
    }

    //handle sending message on "Enter" button
    $('body').keypress(function (eventCode) {
        if (eventCode.keyCode == 13) {
            $('#send-message').click();
        }
    });

});

var contextPath = $('#context-path').val();
var stompClient = null;

//method to log out from chat
function logout() {
    $.ajax({
        url: "/logout",
        success: function (data) {
            window.location.href = data;
        }
    });
}

function connect() {
    var socket = new SockJS('/endpoint');

    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe(contextPath + '/message', function (calResult) {
            showMessage(JSON.parse(calResult.body));
        });
    });
}

function sendMessage() {
    //obtain massage
    var message = $.trim($('#message').val());

    // if (!message) {
    //add red border to message input to show that the message can't be empty
    //$('#form-group-message').addClass("has-error");
    // } else {
    stompClient.send(contextPath +"/chat/endpoint", {}, JSON.stringify({'message': message}));

    //unfocus send-message button
    $('#send-message').blur();
    //}
}

function showMessage(message) {
    var date = new Date(message.date);

    //append message to panel with messages
    $('#response').append(
        '<div>' +
        '<div class="row">' +
        '<div class="col-xs-2">' +
        '<h5>' + message.sender.fullName + ":" + '</h5>' +
        '</div>' +
        '<div class="col-xs-8">' +
        '<div class="alert alert-info" role="alert">'
        + message.message +
        '</div>' +
        '</div>' +
        '<div class="col-xs-2">' +
        '<h5>' + date.toLocaleTimeString() + '</h5>' +
        '</div>' +
        '</div>'
    );

    var messageInput = $('#message');

    //clean message input from text
    messageInput.val('');

    //focus to message input
    messageInput.focus();

    animateScroll();

    //clean message input from errors
    $('#form-group-message').removeClass("has-error");
}

//animate scrolling list of messages to the end of panel (last message)
function animateScroll() {
    var messagesPanel = $('.message-container');
    messagesPanel.animate({scrollTop: messagesPanel.prop("scrollHeight")}, 500);
}

