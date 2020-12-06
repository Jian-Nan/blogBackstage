package com.huangjn.blogbackstage.modules.content.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/content")
public class ContentController {
    @GetMapping("/article")
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

    @GetMapping("/software")
    public String software()
    {
        return "index";
    }
    /*
    }
     */
}
