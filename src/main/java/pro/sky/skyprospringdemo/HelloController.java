package pro.sky.skyprospringdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
