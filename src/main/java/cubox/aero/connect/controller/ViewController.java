package cubox.aero.connect.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ViewController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping({"/"})
    public String logout(HttpServletRequest request) {
        return "redirect:/landing";
    }

    @RequestMapping({"/landing"})
    public String memberRegister() {
        return "landing";
    }

}
