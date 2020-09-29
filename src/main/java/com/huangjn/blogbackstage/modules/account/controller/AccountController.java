package com.huangjn.blogbackstage.modules.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    /*
    *127.0.0.1/account/welcome
     */
    @GetMapping("/welcome")
    public String testIndexPage(ModelMap modelMap)
    {
//        modelMap.addAttribute("template","account/welcome");
        return "index";
    }


    /*
     *127.0.0.1/account/member
     */
    @GetMapping("/member")
    public String member()
    {
        return "index";
    }

    /*
     *127.0.0.1/account/knowledge
     */
    @GetMapping("/knowledge")
    public String knowledge()
    {
        return "index";
    }

    /*
     *127.0.0.1/account/music
     */
    @GetMapping("/music")
    public String music()
    {
        return "index";
    }

    /*
     *127.0.0.1/account/member
     */
    @GetMapping("/picture")
    public String picture()
    {
        return "index";
    }

    /*
     *127.0.0.1/account/member
     */
    @GetMapping("/power")
    public String power()
    {
        return "index";
    }

    /*
     *127.0.0.1/account/roles
     */
    @GetMapping("/roles")
    public String roles()
    {
        return "index";
    }

    /*
     *127.0.0.1/account/software
     */
    @GetMapping("/software")
    public String software()
    {
        return "index";
    }
    /*
     *127.0.0.1/account/administrators
     */
    @GetMapping("/administrators")
    public String administrators()
    {
        return "index";
    }

    /*
     *127.0.0.1/account/page
     */
    @GetMapping("/page")
    public String page()
    {
        return "index";
    }
}
