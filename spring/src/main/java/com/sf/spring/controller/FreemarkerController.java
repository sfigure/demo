package com.sf.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author jzx
 * @date 2019/02/14 09:45
 * @Description:
 */
@Controller
public class FreemarkerController {
    
    @GetMapping("/test")
    public String index(Model model) {
        model.addAttribute("name","freemarker test");
        return "index";
    }
}
