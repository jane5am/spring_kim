package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//컨트롤러 사용시 붙는 어노테이션
public class HelloController {

    @GetMapping("hello") // /hello라고 들어오면 이 메소드를 호출
    public String hello(Model model) { // 여기서 model은 MVC에서의 MODEL을 의미
        model.addAttribute("data","Hello World");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model ) {// 외부에서 파라미터를 받을때는 @RequestParam 어노테이션 사용
       // required 를 false로 하면 해당 파라미터 값이 필수로 안들어와도 된다, required의 기본값은 true
        // 파라미터를 넘길 때 웹브라우저에서 ?{RequestParam이름}={값}
        model.addAttribute("name",name); // 외부에서 받은 파라미터를 model에 담아서 전달
        return "hello-template";
    }


    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}













