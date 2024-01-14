package pro.sky.skyprospringdemo;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {
    public String hello() {
        return "<b>hello</b>";
    }

    public String answerHelloName(String userName) {
        return "<b>hello </b> " + userName;
    }
}

