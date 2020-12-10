package com.huangjn.blogbackstage.modules.content.controller;


import com.github.pagehelper.PageInfo;
import com.huangjn.blogbackstage.modules.common.vo.Result;
import com.huangjn.blogbackstage.modules.common.vo.SearchVo;
import com.huangjn.blogbackstage.modules.content.pojo.Software;
import com.huangjn.blogbackstage.modules.content.service.SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/insertSoftware")
    Result<Object> insertSoftware(@RequestBody Software software)
    {
        return softwareService.insertSoftware(software);
    }

    @DeleteMapping("/deleteSoftwareById/{softwareId}")
    Result<Object> deleteSoftwareById(@PathVariable int softwareId)
    {
        return softwareService.deleteSoftwareById(softwareId);
    }

    @GetMapping("/findSoftwareBySid/{softwareId}")
    Software findSoftwareBySid(@PathVariable int softwareId)
    {
        return softwareService.findSoftwareBySid(softwareId);
    }
    @PostMapping("/editSoftware")
    Result<Object> editSoftware(@RequestBody Software software)
    {
        return softwareService.editSoftware(software);
    }
}
