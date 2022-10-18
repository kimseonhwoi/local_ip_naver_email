package shop.shlove.naveremail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.shlove.naveremail.runner.NaverMailSenderRunner;

@RestController
public class TestController {

    @Autowired
    private NaverMailSenderRunner naverMailSenderRunner;

    @GetMapping("/")
    public String testEmail(){
        try {
            naverMailSenderRunner.sand();
            return "true";
        } catch (Exception e) {
            return "false";
        }
    }
}
