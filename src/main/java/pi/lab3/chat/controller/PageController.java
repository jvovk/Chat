package pi.lab3.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Yuliia Vovk
 * 16.11.15
 */
@Controller
public class PageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String getChatPage() {
        return "chat";
    }

}
