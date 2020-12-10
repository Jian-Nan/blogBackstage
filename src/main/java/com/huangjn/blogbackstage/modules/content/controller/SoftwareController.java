package com.huangjn.blogbackstage.modules.content.controller;


import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.pojo.Software;
import com.huangjn.blogbackstage.modules.content.service.SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SoftwareController {

    @Autowired
    private SoftwareService softwareService;

    @PostMapping("/findAllSoftware")
    PageInfo<Software> findAllSoftware(@RequestBody SearchVo searchVo)
    {
        return softwareService.findAllSoftware(searchVo);
    }
}
