package pi.lab3.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pi.lab3.chat.entity.Message;
import pi.lab3.chat.entity.User;
import pi.lab3.chat.service.IMessageService;
import pi.lab3.chat.validator.IValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Yuliia Vovk
 * 17.11.15
 */
@Controller
@SessionAttributes("user")
public class ChatWebSocketController {

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IValidator<Message> messageValidator;

    @MessageMapping("/endpoint")
    @SendTo("/message")
    public Message sendMessage(SimpMessageHeaderAccessor headerAccessor, @RequestBody Message message) {
        messageValidator.validate(message);

        Map<String, Object> sessionAttributes = headerAccessor.getSessionAttributes();
        messageService.sendMessage((User)sessionAttributes.get("user"), message.getMessage());

        return messageService.getLastMessage();
    }

    @ResponseBody
    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public List<Message> getMessages() {
       return new ArrayList<>(messageService.getAllMessages());
    }


    @ResponseBody
    @ExceptionHandler
    public ResponseEntity handleException(RuntimeException exc) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", exc.getMessage());

        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }
}
