package pro.sky.skyprospringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringdemo.HelloServiceImpl;

@RestController
public class HelloController {
    private final HelloServiceImpl helloServiceImpl;
    public HelloController (HelloServiceImpl helloServiceImpl) {
        this.helloServiceImpl = helloServiceImpl;
    }
    @GetMapping
    public String hello() {
        return helloServiceImpl.hello();
    }


    @GetMapping(path = "/hello")
    public String answerHelloName(@RequestParam("name") String userName) {
        return helloServiceImpl.answerHelloName(userName);
    }
}
