package io.xiaomo.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
@RefreshScope
public class IndexController {

    @Value("${name:weiguangyue}")
    private String name;

    @RequestMapping("")
    public String home(){
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model uiModel){
        uiModel.addAttribute("name",this.name);
        return "index";
    }
}
