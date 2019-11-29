package com.changgou.goods.feign;

import com.changgou.goods.pojo.GoodTemplate;
import com.changgou.vo.CommonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="goods")
@RequestMapping("/goodTemplate")
public interface GoodTemplateFeign {

    /***
     * GoodTemplate分页条件搜索实现
     * @param goodTemplate
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@RequestBody(required = false) GoodTemplate goodTemplate, @PathVariable int page, @PathVariable int size);

    /***
     * GoodTemplate分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param goodTemplate
     * @return
     */
    @PostMapping(value = "/search" )
    CommonResult<List<GoodTemplate>> findList(@RequestBody(required = false) GoodTemplate goodTemplate);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    CommonResult delete(@PathVariable Integer id);

    /***
     * 修改GoodTemplate数据
     * @param goodTemplate
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    CommonResult update(@RequestBody GoodTemplate goodTemplate, @PathVariable Integer id);

    /***
     * 新增GoodTemplate数据
     * @param goodTemplate
     * @return
     */
    @PostMapping
    CommonResult add(@RequestBody GoodTemplate goodTemplate);

    /***
     * 根据ID查询GoodTemplate数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    CommonResult<GoodTemplate> findById(@PathVariable Integer id);

    /***
     * 查询GoodTemplate全部数据
     * @return
     */
    @GetMapping
    CommonResult<List<GoodTemplate>> findAll();
}