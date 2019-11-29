package com.changgou.goods.controller;

import com.changgou.goods.pojo.GoodSku;
import com.changgou.goods.service.GoodSkuService;
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
@Api(value = "GoodSkuController")
@RestController
@RequestMapping("/goodSku")
@CrossOrigin
public class GoodSkuController {

    @Autowired
    private GoodSkuService goodSkuService;

    /***
     * GoodSku分页条件搜索实现
     * @param goodSku
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "GoodSku条件分页查询",notes = "分页条件查询GoodSku方法详情",tags = {"GoodSkuController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "GoodSku对象",value = "传入JSON数据",required = false) GoodSku goodSku, @PathVariable  int page, @PathVariable  int size){
        //调用GoodSkuService实现分页条件查询GoodSku
        PageInfo<GoodSku> pageInfo = goodSkuService.findPage(goodSku, page, size);
        return new CommonResult(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * GoodSku分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "GoodSku分页查询",notes = "分页查询GoodSku方法详情",tags = {"GoodSkuController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用GoodSkuService实现分页查询GoodSku
        PageInfo<GoodSku> pageInfo = goodSkuService.findPage(page, size);
        return new CommonResult<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param goodSku
     * @return
     */
    @ApiOperation(value = "GoodSku条件查询",notes = "条件查询GoodSku方法详情",tags = {"GoodSkuController"})
    @PostMapping(value = "/search" )
    public CommonResult<List<GoodSku>> findList(@RequestBody(required = false) @ApiParam(name = "GoodSku对象",value = "传入JSON数据",required = false) GoodSku goodSku){
        //调用GoodSkuService实现条件查询GoodSku
        List<GoodSku> list = goodSkuService.findList(goodSku);
        return new CommonResult<List<GoodSku>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodSku根据ID删除",notes = "根据ID删除GoodSku方法详情",tags = {"GoodSkuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public CommonResult delete(@PathVariable Long id){
        //调用GoodSkuService实现根据主键删除
        goodSkuService.delete(id);
        return new CommonResult(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改GoodSku数据
     * @param goodSku
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodSku根据ID修改",notes = "根据ID修改GoodSku方法详情",tags = {"GoodSkuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public CommonResult update(@RequestBody @ApiParam(name = "GoodSku对象",value = "传入JSON数据",required = false) GoodSku goodSku,@PathVariable Long id){
        //设置主键值
        goodSku.setId(id);
        //调用GoodSkuService实现修改GoodSku
        goodSkuService.update(goodSku);
        return new CommonResult(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增GoodSku数据
     * @param goodSku
     * @return
     */
    @ApiOperation(value = "GoodSku添加",notes = "添加GoodSku方法详情",tags = {"GoodSkuController"})
    @PostMapping
    public CommonResult add(@RequestBody  @ApiParam(name = "GoodSku对象",value = "传入JSON数据",required = true) GoodSku goodSku){
        //调用GoodSkuService实现添加GoodSku
        goodSkuService.add(goodSku);
        return new CommonResult(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询GoodSku数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodSku根据ID查询",notes = "根据ID查询GoodSku方法详情",tags = {"GoodSkuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public CommonResult<GoodSku> findById(@PathVariable Long id){
        //调用GoodSkuService实现根据主键查询GoodSku
        GoodSku goodSku = goodSkuService.findById(id);
        return new CommonResult<GoodSku>(true,StatusCode.OK,"查询成功",goodSku);
    }

    /***
     * 查询GoodSku全部数据
     * @return
     */
    @ApiOperation(value = "查询所有GoodSku",notes = "查询所GoodSku有方法详情",tags = {"GoodSkuController"})
    @GetMapping
    public CommonResult<List<GoodSku>> findAll(){
        //调用GoodSkuService实现查询所有GoodSku
        List<GoodSku> list = goodSkuService.findAll();
        return new CommonResult<List<GoodSku>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
