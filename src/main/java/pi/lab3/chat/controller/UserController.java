package pi.lab3.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import pi.lab3.chat.entity.User;
import pi.lab3.chat.service.IUserService;

import java.util.Map;

/**
 * Yuliia Vovk
 * 16.11.15
 */
@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody User user, WebRequest request) {
        Map<String, Object> response = userService.login(user);

        if (response.containsKey("error")) {
            return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
        }
        request.setAttribute("user", response.get("user"), WebRequest.SCOPE_SESSION);
        response.remove("user");

        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(SessionStatus status, WebRequest request) {
        status.setComplete();
        request.removeAttribute("user", WebRequest.SCOPE_SESSION);

        return "/";
    }

}
