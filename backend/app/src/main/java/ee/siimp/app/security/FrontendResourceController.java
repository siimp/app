package ee.siimp.app.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendResourceController {

    @GetMapping("/client")
    public String clientAddForm() {
        return "/index.html";
    }

    @GetMapping("/client/**")
    public String clientEditForm() {
        return "/index.html";
    }

}
