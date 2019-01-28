package com.johnxb.bbs.api.controller;

import com.johnxb.bbs.dto.Common.TagsOutputDto;
import com.johnxb.bbs.entity.BbsTag;
import com.johnxb.bbs.service.TagService;
import com.johnxb.bbs.utils.BeanMapper;
import com.johnxb.bbs.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Api(description = "公共服务api")
@RequestMapping(value = "/common")
public class CommonController {
    private final TagService tagService;

    @Autowired
    public CommonController(TagService tagService){
        this.tagService = tagService;
    }


    @ApiOperation(value = "所有文章", notes = "所有文章", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public String articles() {
        return "ab";
    }

    @ApiOperation(value = "所有标签", notes = "标签", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/tags", method = RequestMethod.GET)
    public JSONResult<List<TagsOutputDto>> tags() {
        JSONResult<List<TagsOutputDto>> jsonResult = new JSONResult();
        List<BbsTag> tags= tagService.getTagList();
        List<TagsOutputDto> tagsOutputDtos = BeanMapper.mapList(tags,TagsOutputDto.class);
        jsonResult.setData(tagsOutputDtos);
        return jsonResult;
    }
}
