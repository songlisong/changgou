package com.changgou.goods.feign;

import com.changgou.goods.pojo.GoodSpec;
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
@RequestMapping("/goodSpec")
public interface GoodSpecFeign {

    /***
     * GoodSpec分页条件搜索实现
     * @param goodSpec
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@RequestBody(required = false) GoodSpec goodSpec, @PathVariable int page, @PathVariable int size);

    /***
     * GoodSpec分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param goodSpec
     * @return
     */
    @PostMapping(value = "/search" )
    CommonResult<List<GoodSpec>> findList(@RequestBody(required = false) GoodSpec goodSpec);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    CommonResult delete(@PathVariable Integer id);

    /***
     * 修改GoodSpec数据
     * @param goodSpec
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    CommonResult update(@RequestBody GoodSpec goodSpec, @PathVariable Integer id);

    /***
     * 新增GoodSpec数据
     * @param goodSpec
     * @return
     */
    @PostMapping
    CommonResult add(@RequestBody GoodSpec goodSpec);

    /***
     * 根据ID查询GoodSpec数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    CommonResult<GoodSpec> findById(@PathVariable Integer id);

    /***
     * 查询GoodSpec全部数据
     * @return
     */
    @GetMapping
    CommonResult<List<GoodSpec>> findAll();
}