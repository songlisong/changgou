package com.changgou.goods.controller;

import com.changgou.goods.pojo.GoodPara;
import com.changgou.goods.service.GoodParaService;
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
@Api(value = "GoodParaController")
@RestController
@RequestMapping("/goodPara")
@CrossOrigin
public class GoodParaController {

    @Autowired
    private GoodParaService goodParaService;

    /***
     * GoodPara分页条件搜索实现
     * @param goodPara
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "GoodPara条件分页查询",notes = "分页条件查询GoodPara方法详情",tags = {"GoodParaController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "GoodPara对象",value = "传入JSON数据",required = false) GoodPara goodPara, @PathVariable  int page, @PathVariable  int size){
        //调用GoodParaService实现分页条件查询GoodPara
        PageInfo<GoodPara> pageInfo = goodParaService.findPage(goodPara, page, size);
        return new CommonResult(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * GoodPara分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "GoodPara分页查询",notes = "分页查询GoodPara方法详情",tags = {"GoodParaController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用GoodParaService实现分页查询GoodPara
        PageInfo<GoodPara> pageInfo = goodParaService.findPage(page, size);
        return new CommonResult<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param goodPara
     * @return
     */
    @ApiOperation(value = "GoodPara条件查询",notes = "条件查询GoodPara方法详情",tags = {"GoodParaController"})
    @PostMapping(value = "/search" )
    public CommonResult<List<GoodPara>> findList(@RequestBody(required = false) @ApiParam(name = "GoodPara对象",value = "传入JSON数据",required = false) GoodPara goodPara){
        //调用GoodParaService实现条件查询GoodPara
        List<GoodPara> list = goodParaService.findList(goodPara);
        return new CommonResult<List<GoodPara>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodPara根据ID删除",notes = "根据ID删除GoodPara方法详情",tags = {"GoodParaController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public CommonResult delete(@PathVariable Integer id){
        //调用GoodParaService实现根据主键删除
        goodParaService.delete(id);
        return new CommonResult(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改GoodPara数据
     * @param goodPara
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodPara根据ID修改",notes = "根据ID修改GoodPara方法详情",tags = {"GoodParaController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public CommonResult update(@RequestBody @ApiParam(name = "GoodPara对象",value = "传入JSON数据",required = false) GoodPara goodPara,@PathVariable Integer id){
        //设置主键值
        goodPara.setId(id);
        //调用GoodParaService实现修改GoodPara
        goodParaService.update(goodPara);
        return new CommonResult(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增GoodPara数据
     * @param goodPara
     * @return
     */
    @ApiOperation(value = "GoodPara添加",notes = "添加GoodPara方法详情",tags = {"GoodParaController"})
    @PostMapping
    public CommonResult add(@RequestBody  @ApiParam(name = "GoodPara对象",value = "传入JSON数据",required = true) GoodPara goodPara){
        //调用GoodParaService实现添加GoodPara
        goodParaService.add(goodPara);
        return new CommonResult(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询GoodPara数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodPara根据ID查询",notes = "根据ID查询GoodPara方法详情",tags = {"GoodParaController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public CommonResult<GoodPara> findById(@PathVariable Integer id){
        //调用GoodParaService实现根据主键查询GoodPara
        GoodPara goodPara = goodParaService.findById(id);
        return new CommonResult<GoodPara>(true,StatusCode.OK,"查询成功",goodPara);
    }

    /***
     * 查询GoodPara全部数据
     * @return
     */
    @ApiOperation(value = "查询所有GoodPara",notes = "查询所GoodPara有方法详情",tags = {"GoodParaController"})
    @GetMapping
    public CommonResult<List<GoodPara>> findAll(){
        //调用GoodParaService实现查询所有GoodPara
        List<GoodPara> list = goodParaService.findAll();
        return new CommonResult<List<GoodPara>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
