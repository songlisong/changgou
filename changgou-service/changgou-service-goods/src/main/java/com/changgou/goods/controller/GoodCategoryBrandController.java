package com.changgou.goods.controller;

import com.changgou.goods.pojo.GoodCategoryBrand;
import com.changgou.goods.service.GoodCategoryBrandService;
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
@Api(value = "GoodCategoryBrandController")
@RestController
@RequestMapping("/goodCategoryBrand")
@CrossOrigin
public class GoodCategoryBrandController {

    @Autowired
    private GoodCategoryBrandService goodCategoryBrandService;

    /***
     * GoodCategoryBrand分页条件搜索实现
     * @param goodCategoryBrand
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "GoodCategoryBrand条件分页查询",notes = "分页条件查询GoodCategoryBrand方法详情",tags = {"GoodCategoryBrandController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "GoodCategoryBrand对象",value = "传入JSON数据",required = false) GoodCategoryBrand goodCategoryBrand, @PathVariable  int page, @PathVariable  int size){
        //调用GoodCategoryBrandService实现分页条件查询GoodCategoryBrand
        PageInfo<GoodCategoryBrand> pageInfo = goodCategoryBrandService.findPage(goodCategoryBrand, page, size);
        return new CommonResult(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * GoodCategoryBrand分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "GoodCategoryBrand分页查询",notes = "分页查询GoodCategoryBrand方法详情",tags = {"GoodCategoryBrandController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用GoodCategoryBrandService实现分页查询GoodCategoryBrand
        PageInfo<GoodCategoryBrand> pageInfo = goodCategoryBrandService.findPage(page, size);
        return new CommonResult<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param goodCategoryBrand
     * @return
     */
    @ApiOperation(value = "GoodCategoryBrand条件查询",notes = "条件查询GoodCategoryBrand方法详情",tags = {"GoodCategoryBrandController"})
    @PostMapping(value = "/search" )
    public CommonResult<List<GoodCategoryBrand>> findList(@RequestBody(required = false) @ApiParam(name = "GoodCategoryBrand对象",value = "传入JSON数据",required = false) GoodCategoryBrand goodCategoryBrand){
        //调用GoodCategoryBrandService实现条件查询GoodCategoryBrand
        List<GoodCategoryBrand> list = goodCategoryBrandService.findList(goodCategoryBrand);
        return new CommonResult<List<GoodCategoryBrand>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodCategoryBrand根据ID删除",notes = "根据ID删除GoodCategoryBrand方法详情",tags = {"GoodCategoryBrandController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public CommonResult delete(@PathVariable Integer id){
        //调用GoodCategoryBrandService实现根据主键删除
        goodCategoryBrandService.delete(id);
        return new CommonResult(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改GoodCategoryBrand数据
     * @param goodCategoryBrand
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodCategoryBrand根据ID修改",notes = "根据ID修改GoodCategoryBrand方法详情",tags = {"GoodCategoryBrandController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public CommonResult update(@RequestBody @ApiParam(name = "GoodCategoryBrand对象",value = "传入JSON数据",required = false) GoodCategoryBrand goodCategoryBrand,@PathVariable Integer id){
        //设置主键值
        goodCategoryBrand.setCategoryId(id);
        //调用GoodCategoryBrandService实现修改GoodCategoryBrand
        goodCategoryBrandService.update(goodCategoryBrand);
        return new CommonResult(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增GoodCategoryBrand数据
     * @param goodCategoryBrand
     * @return
     */
    @ApiOperation(value = "GoodCategoryBrand添加",notes = "添加GoodCategoryBrand方法详情",tags = {"GoodCategoryBrandController"})
    @PostMapping
    public CommonResult add(@RequestBody  @ApiParam(name = "GoodCategoryBrand对象",value = "传入JSON数据",required = true) GoodCategoryBrand goodCategoryBrand){
        //调用GoodCategoryBrandService实现添加GoodCategoryBrand
        goodCategoryBrandService.add(goodCategoryBrand);
        return new CommonResult(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询GoodCategoryBrand数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodCategoryBrand根据ID查询",notes = "根据ID查询GoodCategoryBrand方法详情",tags = {"GoodCategoryBrandController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public CommonResult<GoodCategoryBrand> findById(@PathVariable Integer id){
        //调用GoodCategoryBrandService实现根据主键查询GoodCategoryBrand
        GoodCategoryBrand goodCategoryBrand = goodCategoryBrandService.findById(id);
        return new CommonResult<GoodCategoryBrand>(true,StatusCode.OK,"查询成功",goodCategoryBrand);
    }

    /***
     * 查询GoodCategoryBrand全部数据
     * @return
     */
    @ApiOperation(value = "查询所有GoodCategoryBrand",notes = "查询所GoodCategoryBrand有方法详情",tags = {"GoodCategoryBrandController"})
    @GetMapping
    public CommonResult<List<GoodCategoryBrand>> findAll(){
        //调用GoodCategoryBrandService实现查询所有GoodCategoryBrand
        List<GoodCategoryBrand> list = goodCategoryBrandService.findAll();
        return new CommonResult<List<GoodCategoryBrand>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
