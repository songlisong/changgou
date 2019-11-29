package com.changgou.goods.controller;

import com.changgou.goods.pojo.GoodTemplate;
import com.changgou.goods.service.GoodTemplateService;
import com.changgou.vo.CommonResult;
import com.changgou.vo.StatusCode;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/
@Api(value = "GoodTemplateController")
@RestController
@RequestMapping("/goodTemplate")
@CrossOrigin
public class GoodTemplateController {

    @Autowired
    private GoodTemplateService goodTemplateService;

    /***
     * GoodTemplate分页条件搜索实现
     * @param goodTemplate
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "GoodTemplate条件分页查询",notes = "分页条件查询GoodTemplate方法详情",tags = {"GoodTemplateController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "GoodTemplate对象",value = "传入JSON数据",required = false) GoodTemplate goodTemplate, @PathVariable  int page, @PathVariable  int size){
        //调用GoodTemplateService实现分页条件查询GoodTemplate
        PageInfo<GoodTemplate> pageInfo = goodTemplateService.findPage(goodTemplate, page, size);
        return new CommonResult(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * GoodTemplate分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "GoodTemplate分页查询",notes = "分页查询GoodTemplate方法详情",tags = {"GoodTemplateController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用GoodTemplateService实现分页查询GoodTemplate
        PageInfo<GoodTemplate> pageInfo = goodTemplateService.findPage(page, size);
        return new CommonResult<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param goodTemplate
     * @return
     */
    @ApiOperation(value = "GoodTemplate条件查询",notes = "条件查询GoodTemplate方法详情",tags = {"GoodTemplateController"})
    @PostMapping(value = "/search" )
    public CommonResult<List<GoodTemplate>> findList(@RequestBody(required = false) @ApiParam(name = "GoodTemplate对象",value = "传入JSON数据",required = false) GoodTemplate goodTemplate){
        //调用GoodTemplateService实现条件查询GoodTemplate
        List<GoodTemplate> list = goodTemplateService.findList(goodTemplate);
        return new CommonResult<List<GoodTemplate>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodTemplate根据ID删除",notes = "根据ID删除GoodTemplate方法详情",tags = {"GoodTemplateController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public CommonResult delete(@PathVariable Integer id){
        //调用GoodTemplateService实现根据主键删除
        goodTemplateService.delete(id);
        return new CommonResult(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改GoodTemplate数据
     * @param goodTemplate
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodTemplate根据ID修改",notes = "根据ID修改GoodTemplate方法详情",tags = {"GoodTemplateController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public CommonResult update(@RequestBody @ApiParam(name = "GoodTemplate对象",value = "传入JSON数据",required = false) GoodTemplate goodTemplate,@PathVariable Integer id){
        //设置主键值
        goodTemplate.setId(id);
        //调用GoodTemplateService实现修改GoodTemplate
        goodTemplateService.update(goodTemplate);
        return new CommonResult(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增GoodTemplate数据
     * @param goodTemplate
     * @return
     */
    @ApiOperation(value = "GoodTemplate添加",notes = "添加GoodTemplate方法详情",tags = {"GoodTemplateController"})
    @PostMapping
    public CommonResult add(@RequestBody  @ApiParam(name = "GoodTemplate对象",value = "传入JSON数据",required = true) GoodTemplate goodTemplate){
        //调用GoodTemplateService实现添加GoodTemplate
        goodTemplateService.add(goodTemplate);
        return new CommonResult(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询GoodTemplate数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodTemplate根据ID查询",notes = "根据ID查询GoodTemplate方法详情",tags = {"GoodTemplateController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public CommonResult<GoodTemplate> findById(@PathVariable Integer id){
        //调用GoodTemplateService实现根据主键查询GoodTemplate
        GoodTemplate goodTemplate = goodTemplateService.findById(id);
        return new CommonResult<GoodTemplate>(true,StatusCode.OK,"查询成功",goodTemplate);
    }

    /***
     * 查询GoodTemplate全部数据
     * @return
     */
    @ApiOperation(value = "查询所有GoodTemplate",notes = "查询所GoodTemplate有方法详情",tags = {"GoodTemplateController"})
    @GetMapping
    public CommonResult<List<GoodTemplate>> findAll(){
        //调用GoodTemplateService实现查询所有GoodTemplate
        List<GoodTemplate> list = goodTemplateService.findAll();
        return new CommonResult<List<GoodTemplate>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
