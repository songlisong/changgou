package com.changgou.goods.controller;

import com.changgou.goods.pojo.GoodStockBack;
import com.changgou.goods.service.GoodStockBackService;
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
@Api(value = "GoodStockBackController")
@RestController
@RequestMapping("/goodStockBack")
@CrossOrigin
public class GoodStockBackController {

    @Autowired
    private GoodStockBackService goodStockBackService;

    /***
     * GoodStockBack分页条件搜索实现
     * @param goodStockBack
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "GoodStockBack条件分页查询",notes = "分页条件查询GoodStockBack方法详情",tags = {"GoodStockBackController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "GoodStockBack对象",value = "传入JSON数据",required = false) GoodStockBack goodStockBack, @PathVariable  int page, @PathVariable  int size){
        //调用GoodStockBackService实现分页条件查询GoodStockBack
        PageInfo<GoodStockBack> pageInfo = goodStockBackService.findPage(goodStockBack, page, size);
        return new CommonResult(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * GoodStockBack分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "GoodStockBack分页查询",notes = "分页查询GoodStockBack方法详情",tags = {"GoodStockBackController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用GoodStockBackService实现分页查询GoodStockBack
        PageInfo<GoodStockBack> pageInfo = goodStockBackService.findPage(page, size);
        return new CommonResult<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param goodStockBack
     * @return
     */
    @ApiOperation(value = "GoodStockBack条件查询",notes = "条件查询GoodStockBack方法详情",tags = {"GoodStockBackController"})
    @PostMapping(value = "/search" )
    public CommonResult<List<GoodStockBack>> findList(@RequestBody(required = false) @ApiParam(name = "GoodStockBack对象",value = "传入JSON数据",required = false) GoodStockBack goodStockBack){
        //调用GoodStockBackService实现条件查询GoodStockBack
        List<GoodStockBack> list = goodStockBackService.findList(goodStockBack);
        return new CommonResult<List<GoodStockBack>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodStockBack根据ID删除",notes = "根据ID删除GoodStockBack方法详情",tags = {"GoodStockBackController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public CommonResult delete(@PathVariable String id){
        //调用GoodStockBackService实现根据主键删除
        goodStockBackService.delete(id);
        return new CommonResult(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改GoodStockBack数据
     * @param goodStockBack
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodStockBack根据ID修改",notes = "根据ID修改GoodStockBack方法详情",tags = {"GoodStockBackController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public CommonResult update(@RequestBody @ApiParam(name = "GoodStockBack对象",value = "传入JSON数据",required = false) GoodStockBack goodStockBack,@PathVariable String id){
        //设置主键值
        goodStockBack.setSkuId(id);
        //调用GoodStockBackService实现修改GoodStockBack
        goodStockBackService.update(goodStockBack);
        return new CommonResult(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增GoodStockBack数据
     * @param goodStockBack
     * @return
     */
    @ApiOperation(value = "GoodStockBack添加",notes = "添加GoodStockBack方法详情",tags = {"GoodStockBackController"})
    @PostMapping
    public CommonResult add(@RequestBody  @ApiParam(name = "GoodStockBack对象",value = "传入JSON数据",required = true) GoodStockBack goodStockBack){
        //调用GoodStockBackService实现添加GoodStockBack
        goodStockBackService.add(goodStockBack);
        return new CommonResult(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询GoodStockBack数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodStockBack根据ID查询",notes = "根据ID查询GoodStockBack方法详情",tags = {"GoodStockBackController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public CommonResult<GoodStockBack> findById(@PathVariable String id){
        //调用GoodStockBackService实现根据主键查询GoodStockBack
        GoodStockBack goodStockBack = goodStockBackService.findById(id);
        return new CommonResult<GoodStockBack>(true,StatusCode.OK,"查询成功",goodStockBack);
    }

    /***
     * 查询GoodStockBack全部数据
     * @return
     */
    @ApiOperation(value = "查询所有GoodStockBack",notes = "查询所GoodStockBack有方法详情",tags = {"GoodStockBackController"})
    @GetMapping
    public CommonResult<List<GoodStockBack>> findAll(){
        //调用GoodStockBackService实现查询所有GoodStockBack
        List<GoodStockBack> list = goodStockBackService.findAll();
        return new CommonResult<List<GoodStockBack>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
