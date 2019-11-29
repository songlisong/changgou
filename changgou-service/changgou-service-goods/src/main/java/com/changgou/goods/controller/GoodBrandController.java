package com.changgou.goods.controller;

import com.changgou.goods.pojo.GoodBrand;
import com.changgou.goods.service.GoodBrandService;
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
@Api(value = "GoodBrandController")
@RestController
@RequestMapping("/goodBrand")
@CrossOrigin
public class GoodBrandController {

    @Autowired
    private GoodBrandService goodBrandService;

    /***
     * GoodBrand分页条件搜索实现
     * @param goodBrand
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "GoodBrand条件分页查询",notes = "分页条件查询GoodBrand方法详情",tags = {"GoodBrandController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "GoodBrand对象",value = "传入JSON数据",required = false) GoodBrand goodBrand, @PathVariable  int page, @PathVariable  int size){
        //调用GoodBrandService实现分页条件查询GoodBrand
        PageInfo<GoodBrand> pageInfo = goodBrandService.findPage(goodBrand, page, size);
        return new CommonResult(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * GoodBrand分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "GoodBrand分页查询",notes = "分页查询GoodBrand方法详情",tags = {"GoodBrandController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用GoodBrandService实现分页查询GoodBrand
        PageInfo<GoodBrand> pageInfo = goodBrandService.findPage(page, size);
        return new CommonResult<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param goodBrand
     * @return
     */
    @ApiOperation(value = "GoodBrand条件查询",notes = "条件查询GoodBrand方法详情",tags = {"GoodBrandController"})
    @PostMapping(value = "/search" )
    public CommonResult<List<GoodBrand>> findList(@RequestBody(required = false) @ApiParam(name = "GoodBrand对象",value = "传入JSON数据",required = false) GoodBrand goodBrand){
        //调用GoodBrandService实现条件查询GoodBrand
        List<GoodBrand> list = goodBrandService.findList(goodBrand);
        return new CommonResult<List<GoodBrand>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodBrand根据ID删除",notes = "根据ID删除GoodBrand方法详情",tags = {"GoodBrandController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public CommonResult delete(@PathVariable Integer id){
        //调用GoodBrandService实现根据主键删除
        goodBrandService.delete(id);
        return new CommonResult(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改GoodBrand数据
     * @param goodBrand
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodBrand根据ID修改",notes = "根据ID修改GoodBrand方法详情",tags = {"GoodBrandController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public CommonResult update(@RequestBody @ApiParam(name = "GoodBrand对象",value = "传入JSON数据",required = false) GoodBrand goodBrand,@PathVariable Integer id){
        //设置主键值
        goodBrand.setId(id);
        //调用GoodBrandService实现修改GoodBrand
        goodBrandService.update(goodBrand);
        return new CommonResult(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增GoodBrand数据
     * @param goodBrand
     * @return
     */
    @ApiOperation(value = "GoodBrand添加",notes = "添加GoodBrand方法详情",tags = {"GoodBrandController"})
    @PostMapping
    public CommonResult add(@RequestBody  @ApiParam(name = "GoodBrand对象",value = "传入JSON数据",required = true) GoodBrand goodBrand){
        //调用GoodBrandService实现添加GoodBrand
        goodBrandService.add(goodBrand);
        return new CommonResult(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询GoodBrand数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodBrand根据ID查询",notes = "根据ID查询GoodBrand方法详情",tags = {"GoodBrandController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public CommonResult<GoodBrand> findById(@PathVariable Integer id){
        //调用GoodBrandService实现根据主键查询GoodBrand
        GoodBrand goodBrand = goodBrandService.findById(id);
        return new CommonResult<GoodBrand>(true,StatusCode.OK,"查询成功",goodBrand);
    }

    /***
     * 查询GoodBrand全部数据
     * @return
     */
    @ApiOperation(value = "查询所有GoodBrand",notes = "查询所GoodBrand有方法详情",tags = {"GoodBrandController"})
    @GetMapping
    public CommonResult<List<GoodBrand>> findAll(){
        //调用GoodBrandService实现查询所有GoodBrand
        List<GoodBrand> list = goodBrandService.findAll();
        return new CommonResult<List<GoodBrand>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
