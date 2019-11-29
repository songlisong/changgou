package com.changgou.goods.controller;

import com.changgou.goods.pojo.GoodAlbum;
import com.changgou.goods.service.GoodAlbumService;
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
@Api(value = "GoodAlbumController")
@RestController
@RequestMapping("/goodAlbum")
@CrossOrigin
public class GoodAlbumController {

    @Autowired
    private GoodAlbumService goodAlbumService;

    /***
     * GoodAlbum分页条件搜索实现
     * @param goodAlbum
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "GoodAlbum条件分页查询",notes = "分页条件查询GoodAlbum方法详情",tags = {"GoodAlbumController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "GoodAlbum对象",value = "传入JSON数据",required = false) GoodAlbum goodAlbum, @PathVariable  int page, @PathVariable  int size){
        //调用GoodAlbumService实现分页条件查询GoodAlbum
        PageInfo<GoodAlbum> pageInfo = goodAlbumService.findPage(goodAlbum, page, size);
        return new CommonResult(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * GoodAlbum分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "GoodAlbum分页查询",notes = "分页查询GoodAlbum方法详情",tags = {"GoodAlbumController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public CommonResult<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用GoodAlbumService实现分页查询GoodAlbum
        PageInfo<GoodAlbum> pageInfo = goodAlbumService.findPage(page, size);
        return new CommonResult<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param goodAlbum
     * @return
     */
    @ApiOperation(value = "GoodAlbum条件查询",notes = "条件查询GoodAlbum方法详情",tags = {"GoodAlbumController"})
    @PostMapping(value = "/search" )
    public CommonResult<List<GoodAlbum>> findList(@RequestBody(required = false) @ApiParam(name = "GoodAlbum对象",value = "传入JSON数据",required = false) GoodAlbum goodAlbum){
        //调用GoodAlbumService实现条件查询GoodAlbum
        List<GoodAlbum> list = goodAlbumService.findList(goodAlbum);
        return new CommonResult<List<GoodAlbum>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodAlbum根据ID删除",notes = "根据ID删除GoodAlbum方法详情",tags = {"GoodAlbumController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public CommonResult delete(@PathVariable Long id){
        //调用GoodAlbumService实现根据主键删除
        goodAlbumService.delete(id);
        return new CommonResult(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改GoodAlbum数据
     * @param goodAlbum
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodAlbum根据ID修改",notes = "根据ID修改GoodAlbum方法详情",tags = {"GoodAlbumController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public CommonResult update(@RequestBody @ApiParam(name = "GoodAlbum对象",value = "传入JSON数据",required = false) GoodAlbum goodAlbum,@PathVariable Long id){
        //设置主键值
        goodAlbum.setId(id);
        //调用GoodAlbumService实现修改GoodAlbum
        goodAlbumService.update(goodAlbum);
        return new CommonResult(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增GoodAlbum数据
     * @param goodAlbum
     * @return
     */
    @ApiOperation(value = "GoodAlbum添加",notes = "添加GoodAlbum方法详情",tags = {"GoodAlbumController"})
    @PostMapping
    public CommonResult add(@RequestBody  @ApiParam(name = "GoodAlbum对象",value = "传入JSON数据",required = true) GoodAlbum goodAlbum){
        //调用GoodAlbumService实现添加GoodAlbum
        goodAlbumService.add(goodAlbum);
        return new CommonResult(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询GoodAlbum数据
     * @param id
     * @return
     */
    @ApiOperation(value = "GoodAlbum根据ID查询",notes = "根据ID查询GoodAlbum方法详情",tags = {"GoodAlbumController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public CommonResult<GoodAlbum> findById(@PathVariable Long id){
        //调用GoodAlbumService实现根据主键查询GoodAlbum
        GoodAlbum goodAlbum = goodAlbumService.findById(id);
        return new CommonResult<GoodAlbum>(true,StatusCode.OK,"查询成功",goodAlbum);
    }

    /***
     * 查询GoodAlbum全部数据
     * @return
     */
    @ApiOperation(value = "查询所有GoodAlbum",notes = "查询所GoodAlbum有方法详情",tags = {"GoodAlbumController"})
    @GetMapping
    public CommonResult<List<GoodAlbum>> findAll(){
        //调用GoodAlbumService实现查询所有GoodAlbum
        List<GoodAlbum> list = goodAlbumService.findAll();
        return new CommonResult<List<GoodAlbum>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
