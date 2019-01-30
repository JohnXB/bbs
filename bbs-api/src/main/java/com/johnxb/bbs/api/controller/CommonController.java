package com.johnxb.bbs.api.controller;

import com.johnxb.bbs.dto.Common.TagOutputDto;
import com.johnxb.bbs.dto.Common.TagsOutputDto;
import com.johnxb.bbs.entity.BbsTag;
import com.johnxb.bbs.service.TagService;
import com.johnxb.bbs.utils.BeanMapper;
import com.johnxb.bbs.utils.JSONResult;
import com.johnxb.bbs.utils.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@Api(description = "公共服务api")
@RequestMapping(value = "/common")
public class CommonController {
    private final TagService tagService;

    @Autowired
    public CommonController(TagService tagService) {
        this.tagService = tagService;
    }


    @ApiOperation(value = "所有文章", notes = "所有文章", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public String articles() {
        return "ab";
    }

    @ApiOperation(value = "所有标签", notes = "获取所有标签基本信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/tags", method = RequestMethod.GET)
    public JSONResult<List<TagsOutputDto>> tags() {
        JSONResult<List<TagsOutputDto>> jsonResult = new JSONResult();
        List<BbsTag> tags = tagService.getTagList();

        List<TagsOutputDto> tagsOutputDtos = BeanMapper.mapList(tags, TagsOutputDto.class);
        jsonResult.setData(tagsOutputDtos);
        return jsonResult;
    }

    @ApiOperation(value = "标签信息", notes = "根据标签id获取标签详细信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/tag/{tagId}", method = RequestMethod.GET)
    public JSONResult<TagOutputDto> tag(@PathVariable @NotNull(message = "标签id不能为空") Integer tagId) throws BusinessException {
        JSONResult<TagOutputDto> jsonResult = new JSONResult<>();
        // 获取数据+数据转换+异常处理
        TagOutputDto tagOutputDto = BeanMapper.map(Optional.ofNullable(this.tagService.getTagById(tagId)).orElseThrow(() -> new BusinessException("无对应标签")), TagOutputDto.class);
        jsonResult.setData(tagOutputDto);
        return jsonResult;
    }

    @ApiOperation(value = "首页文章", notes = "根据tag获取文章")
    @RequestMapping(value = "/tag/{tagId}/articles", method = RequestMethod.GET)
    public JSONResult getArticlesByTag(@PathVariable Integer tagId) {
        JSONResult jsonResult = new JSONResult();
        return jsonResult;
    }
}
