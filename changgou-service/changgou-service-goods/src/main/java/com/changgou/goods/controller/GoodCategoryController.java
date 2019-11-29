package com.changgou.goods.controller;

import com.changgou.goods.pojo.GoodCategory;
import com.changgou.goods.service.GoodCategoryService;
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
@Api(value = "GoodCategoryController")
@RestController
@RequestMapping("/goodCategory")
@CrossOrigin
public class GoodCategoryController {

    @Autowired
    private GoodCategoryService goodCategoryService;

    /***
     * GoodCategory分页条件搜索实现
     * @param goodCategory
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "GoodCategory条件分页查询",notes = "分页条件查询GoodCategory方法详情",tags = {"GoodCategoryController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "GoodCategory对象",value = "传入JSON数据",required = false) GoodCategory goodCategory, @PathVariable  int page, @PathVariable  int size){
        //调用GoodCategoryService实现分页条件查询GoodCategory
        PageInfo<GoodCategory> pageInfo = goodCategoryService.findPage(goodCategory, page, size);
        return new CommonResult(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * GoodCategory分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "GoodCategory分页查询",notes = "分页查询GoodCategory方法详情",tags = {"GoodCategoryController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用GoodCategoryService实现分页查询GoodCategory
        PageInfo<GoodCategory> pageInfo = goodCategoryService.findPage(page, size);
        return new CommonResult<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param goodCategory
     * @return
     */
    @ApiOperation(value = "GoodCategory条件查询",notes = "条件查询GoodCategory方法详情",tags = {"GoodCategoryController"})
    @PostMapping(value = "/search" )
    public CommonResult<List<GoodCategory>> findList(@RequestBody(required = false) @ApiParam(name = "GoodCategory对象",value = "传入JSON数据",required = false) GoodCategory goodCategory){
        //调用GoodCategoryService实现条件查询GoodCategory
        List<GoodCategory> list = goodCategoryService.findList(goodCategory);
        return new CommonResult<List<GoodCategory>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodCategory根据ID删除",notes = "根据ID删除GoodCategory方法详情",tags = {"GoodCategoryController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public CommonResult delete(@PathVariable Integer id){
        //调用GoodCategoryService实现根据主键删除
        goodCategoryService.delete(id);
        return new CommonResult(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改GoodCategory数据
     * @param goodCategory
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodCategory根据ID修改",notes = "根据ID修改GoodCategory方法详情",tags = {"GoodCategoryController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public CommonResult update(@RequestBody @ApiParam(name = "GoodCategory对象",value = "传入JSON数据",required = false) GoodCategory goodCategory,@PathVariable Integer id){
        //设置主键值
        goodCategory.setId(id);
        //调用GoodCategoryService实现修改GoodCategory
        goodCategoryService.update(goodCategory);
        return new CommonResult(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增GoodCategory数据
     * @param goodCategory
     * @return
     */
    @ApiOperation(value = "GoodCategory添加",notes = "添加GoodCategory方法详情",tags = {"GoodCategoryController"})
    @PostMapping
    public CommonResult add(@RequestBody  @ApiParam(name = "GoodCategory对象",value = "传入JSON数据",required = true) GoodCategory goodCategory){
        //调用GoodCategoryService实现添加GoodCategory
        goodCategoryService.add(goodCategory);
        return new CommonResult(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询GoodCategory数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodCategory根据ID查询",notes = "根据ID查询GoodCategory方法详情",tags = {"GoodCategoryController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public CommonResult<GoodCategory> findById(@PathVariable Integer id){
        //调用GoodCategoryService实现根据主键查询GoodCategory
        GoodCategory goodCategory = goodCategoryService.findById(id);
        return new CommonResult<GoodCategory>(true,StatusCode.OK,"查询成功",goodCategory);
    }

    /***
     * 查询GoodCategory全部数据
     * @return
     */
    @ApiOperation(value = "查询所有GoodCategory",notes = "查询所GoodCategory有方法详情",tags = {"GoodCategoryController"})
    @GetMapping
    public CommonResult<List<GoodCategory>> findAll(){
        //调用GoodCategoryService实现查询所有GoodCategory
        List<GoodCategory> list = goodCategoryService.findAll();
        return new CommonResult<List<GoodCategory>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
