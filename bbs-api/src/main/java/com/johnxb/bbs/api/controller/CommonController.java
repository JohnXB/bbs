package com.johnxb.bbs.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "公共服务api")
@RequestMapping(value = "/common")
public class CommonController {
    @ApiOperation(value = "所有文章", notes = "所有文章", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/articles",method = RequestMethod.GET)
    public String articles(){
        return "ab";
    }
//    @ApiOperation(value = "根据id查找文章", notes = "有文章", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @RequestMapping(value = "/article/{id}",method = RequestMethod.GET)
//    public String article(@RequestParam int id){
//        return "ab"+id;
//    }
}
