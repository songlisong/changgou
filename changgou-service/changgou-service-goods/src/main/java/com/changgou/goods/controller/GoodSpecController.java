package com.changgou.goods.controller;

import com.changgou.goods.pojo.GoodSpec;
import com.changgou.goods.service.GoodSpecService;
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
@Api(value = "GoodSpecController")
@RestController
@RequestMapping("/goodSpec")
@CrossOrigin
public class GoodSpecController {

    @Autowired
    private GoodSpecService goodSpecService;

    /***
     * GoodSpec分页条件搜索实现
     * @param goodSpec
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "GoodSpec条件分页查询",notes = "分页条件查询GoodSpec方法详情",tags = {"GoodSpecController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "GoodSpec对象",value = "传入JSON数据",required = false) GoodSpec goodSpec, @PathVariable  int page, @PathVariable  int size){
        //调用GoodSpecService实现分页条件查询GoodSpec
        PageInfo<GoodSpec> pageInfo = goodSpecService.findPage(goodSpec, page, size);
        return new CommonResult(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * GoodSpec分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "GoodSpec分页查询",notes = "分页查询GoodSpec方法详情",tags = {"GoodSpecController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用GoodSpecService实现分页查询GoodSpec
        PageInfo<GoodSpec> pageInfo = goodSpecService.findPage(page, size);
        return new CommonResult<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param goodSpec
     * @return
     */
    @ApiOperation(value = "GoodSpec条件查询",notes = "条件查询GoodSpec方法详情",tags = {"GoodSpecController"})
    @PostMapping(value = "/search" )
    public CommonResult<List<GoodSpec>> findList(@RequestBody(required = false) @ApiParam(name = "GoodSpec对象",value = "传入JSON数据",required = false) GoodSpec goodSpec){
        //调用GoodSpecService实现条件查询GoodSpec
        List<GoodSpec> list = goodSpecService.findList(goodSpec);
        return new CommonResult<List<GoodSpec>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodSpec根据ID删除",notes = "根据ID删除GoodSpec方法详情",tags = {"GoodSpecController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public CommonResult delete(@PathVariable Integer id){
        //调用GoodSpecService实现根据主键删除
        goodSpecService.delete(id);
        return new CommonResult(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改GoodSpec数据
     * @param goodSpec
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodSpec根据ID修改",notes = "根据ID修改GoodSpec方法详情",tags = {"GoodSpecController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public CommonResult update(@RequestBody @ApiParam(name = "GoodSpec对象",value = "传入JSON数据",required = false) GoodSpec goodSpec,@PathVariable Integer id){
        //设置主键值
        goodSpec.setId(id);
        //调用GoodSpecService实现修改GoodSpec
        goodSpecService.update(goodSpec);
        return new CommonResult(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增GoodSpec数据
     * @param goodSpec
     * @return
     */
    @ApiOperation(value = "GoodSpec添加",notes = "添加GoodSpec方法详情",tags = {"GoodSpecController"})
    @PostMapping
    public CommonResult add(@RequestBody  @ApiParam(name = "GoodSpec对象",value = "传入JSON数据",required = true) GoodSpec goodSpec){
        //调用GoodSpecService实现添加GoodSpec
        goodSpecService.add(goodSpec);
        return new CommonResult(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询GoodSpec数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodSpec根据ID查询",notes = "根据ID查询GoodSpec方法详情",tags = {"GoodSpecController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public CommonResult<GoodSpec> findById(@PathVariable Integer id){
        //调用GoodSpecService实现根据主键查询GoodSpec
        GoodSpec goodSpec = goodSpecService.findById(id);
        return new CommonResult<GoodSpec>(true,StatusCode.OK,"查询成功",goodSpec);
    }

    /***
     * 查询GoodSpec全部数据
     * @return
     */
    @ApiOperation(value = "查询所有GoodSpec",notes = "查询所GoodSpec有方法详情",tags = {"GoodSpecController"})
    @GetMapping
    public CommonResult<List<GoodSpec>> findAll(){
        //调用GoodSpecService实现查询所有GoodSpec
        List<GoodSpec> list = goodSpecService.findAll();
        return new CommonResult<List<GoodSpec>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
