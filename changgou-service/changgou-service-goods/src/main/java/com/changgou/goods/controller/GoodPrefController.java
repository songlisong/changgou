package com.changgou.goods.controller;

import com.changgou.goods.pojo.GoodPref;
import com.changgou.goods.service.GoodPrefService;
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
@Api(value = "GoodPrefController")
@RestController
@RequestMapping("/goodPref")
@CrossOrigin
public class GoodPrefController {

    @Autowired
    private GoodPrefService goodPrefService;

    /***
     * GoodPref分页条件搜索实现
     * @param goodPref
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "GoodPref条件分页查询",notes = "分页条件查询GoodPref方法详情",tags = {"GoodPrefController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "GoodPref对象",value = "传入JSON数据",required = false) GoodPref goodPref, @PathVariable  int page, @PathVariable  int size){
        //调用GoodPrefService实现分页条件查询GoodPref
        PageInfo<GoodPref> pageInfo = goodPrefService.findPage(goodPref, page, size);
        return new CommonResult(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * GoodPref分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "GoodPref分页查询",notes = "分页查询GoodPref方法详情",tags = {"GoodPrefController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用GoodPrefService实现分页查询GoodPref
        PageInfo<GoodPref> pageInfo = goodPrefService.findPage(page, size);
        return new CommonResult<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param goodPref
     * @return
     */
    @ApiOperation(value = "GoodPref条件查询",notes = "条件查询GoodPref方法详情",tags = {"GoodPrefController"})
    @PostMapping(value = "/search" )
    public CommonResult<List<GoodPref>> findList(@RequestBody(required = false) @ApiParam(name = "GoodPref对象",value = "传入JSON数据",required = false) GoodPref goodPref){
        //调用GoodPrefService实现条件查询GoodPref
        List<GoodPref> list = goodPrefService.findList(goodPref);
        return new CommonResult<List<GoodPref>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodPref根据ID删除",notes = "根据ID删除GoodPref方法详情",tags = {"GoodPrefController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public CommonResult delete(@PathVariable Integer id){
        //调用GoodPrefService实现根据主键删除
        goodPrefService.delete(id);
        return new CommonResult(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改GoodPref数据
     * @param goodPref
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodPref根据ID修改",notes = "根据ID修改GoodPref方法详情",tags = {"GoodPrefController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public CommonResult update(@RequestBody @ApiParam(name = "GoodPref对象",value = "传入JSON数据",required = false) GoodPref goodPref,@PathVariable Integer id){
        //设置主键值
        goodPref.setId(id);
        //调用GoodPrefService实现修改GoodPref
        goodPrefService.update(goodPref);
        return new CommonResult(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增GoodPref数据
     * @param goodPref
     * @return
     */
    @ApiOperation(value = "GoodPref添加",notes = "添加GoodPref方法详情",tags = {"GoodPrefController"})
    @PostMapping
    public CommonResult add(@RequestBody  @ApiParam(name = "GoodPref对象",value = "传入JSON数据",required = true) GoodPref goodPref){
        //调用GoodPrefService实现添加GoodPref
        goodPrefService.add(goodPref);
        return new CommonResult(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询GoodPref数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodPref根据ID查询",notes = "根据ID查询GoodPref方法详情",tags = {"GoodPrefController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public CommonResult<GoodPref> findById(@PathVariable Integer id){
        //调用GoodPrefService实现根据主键查询GoodPref
        GoodPref goodPref = goodPrefService.findById(id);
        return new CommonResult<GoodPref>(true,StatusCode.OK,"查询成功",goodPref);
    }

    /***
     * 查询GoodPref全部数据
     * @return
     */
    @ApiOperation(value = "查询所有GoodPref",notes = "查询所GoodPref有方法详情",tags = {"GoodPrefController"})
    @GetMapping
    public CommonResult<List<GoodPref>> findAll(){
        //调用GoodPrefService实现查询所有GoodPref
        List<GoodPref> list = goodPrefService.findAll();
        return new CommonResult<List<GoodPref>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
