package com.changgou.goods.controller;

import com.changgou.goods.pojo.GoodSpu;
import com.changgou.goods.service.GoodSpuService;
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
@Api(value = "GoodSpuController")
@RestController
@RequestMapping("/goodSpu")
@CrossOrigin
public class GoodSpuController {

    @Autowired
    private GoodSpuService goodSpuService;

    /***
     * GoodSpu分页条件搜索实现
     * @param goodSpu
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "GoodSpu条件分页查询",notes = "分页条件查询GoodSpu方法详情",tags = {"GoodSpuController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "GoodSpu对象",value = "传入JSON数据",required = false) GoodSpu goodSpu, @PathVariable  int page, @PathVariable  int size){
        //调用GoodSpuService实现分页条件查询GoodSpu
        PageInfo<GoodSpu> pageInfo = goodSpuService.findPage(goodSpu, page, size);
        return new CommonResult(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * GoodSpu分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "GoodSpu分页查询",notes = "分页查询GoodSpu方法详情",tags = {"GoodSpuController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用GoodSpuService实现分页查询GoodSpu
        PageInfo<GoodSpu> pageInfo = goodSpuService.findPage(page, size);
        return new CommonResult<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param goodSpu
     * @return
     */
    @ApiOperation(value = "GoodSpu条件查询",notes = "条件查询GoodSpu方法详情",tags = {"GoodSpuController"})
    @PostMapping(value = "/search" )
    public CommonResult<List<GoodSpu>> findList(@RequestBody(required = false) @ApiParam(name = "GoodSpu对象",value = "传入JSON数据",required = false) GoodSpu goodSpu){
        //调用GoodSpuService实现条件查询GoodSpu
        List<GoodSpu> list = goodSpuService.findList(goodSpu);
        return new CommonResult<List<GoodSpu>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodSpu根据ID删除",notes = "根据ID删除GoodSpu方法详情",tags = {"GoodSpuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public CommonResult delete(@PathVariable Long id){
        //调用GoodSpuService实现根据主键删除
        goodSpuService.delete(id);
        return new CommonResult(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改GoodSpu数据
     * @param goodSpu
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodSpu根据ID修改",notes = "根据ID修改GoodSpu方法详情",tags = {"GoodSpuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public CommonResult update(@RequestBody @ApiParam(name = "GoodSpu对象",value = "传入JSON数据",required = false) GoodSpu goodSpu,@PathVariable Long id){
        //设置主键值
        goodSpu.setId(id);
        //调用GoodSpuService实现修改GoodSpu
        goodSpuService.update(goodSpu);
        return new CommonResult(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增GoodSpu数据
     * @param goodSpu
     * @return
     */
    @ApiOperation(value = "GoodSpu添加",notes = "添加GoodSpu方法详情",tags = {"GoodSpuController"})
    @PostMapping
    public CommonResult add(@RequestBody  @ApiParam(name = "GoodSpu对象",value = "传入JSON数据",required = true) GoodSpu goodSpu){
        //调用GoodSpuService实现添加GoodSpu
        goodSpuService.add(goodSpu);
        return new CommonResult(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询GoodSpu数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodSpu根据ID查询",notes = "根据ID查询GoodSpu方法详情",tags = {"GoodSpuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public CommonResult<GoodSpu> findById(@PathVariable Long id){
        //调用GoodSpuService实现根据主键查询GoodSpu
        GoodSpu goodSpu = goodSpuService.findById(id);
        return new CommonResult<GoodSpu>(true,StatusCode.OK,"查询成功",goodSpu);
    }

    /***
     * 查询GoodSpu全部数据
     * @return
     */
    @ApiOperation(value = "查询所有GoodSpu",notes = "查询所GoodSpu有方法详情",tags = {"GoodSpuController"})
    @GetMapping
    public CommonResult<List<GoodSpu>> findAll(){
        //调用GoodSpuService实现查询所有GoodSpu
        List<GoodSpu> list = goodSpuService.findAll();
        return new CommonResult<List<GoodSpu>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
