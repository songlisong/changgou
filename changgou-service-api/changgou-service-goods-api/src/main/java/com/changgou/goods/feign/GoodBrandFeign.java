package com.changgou.goods.feign;

import com.changgou.goods.pojo.GoodBrand;
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
@RequestMapping("/goodBrand")
public interface GoodBrandFeign {

    /***
     * GoodBrand分页条件搜索实现
     * @param goodBrand
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@RequestBody(required = false) GoodBrand goodBrand, @PathVariable int page, @PathVariable int size);

    /***
     * GoodBrand分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param goodBrand
     * @return
     */
    @PostMapping(value = "/search" )
    CommonResult<List<GoodBrand>> findList(@RequestBody(required = false) GoodBrand goodBrand);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    CommonResult delete(@PathVariable Integer id);

    /***
     * 修改GoodBrand数据
     * @param goodBrand
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    CommonResult update(@RequestBody GoodBrand goodBrand, @PathVariable Integer id);

    /***
     * 新增GoodBrand数据
     * @param goodBrand
     * @return
     */
    @PostMapping
    CommonResult add(@RequestBody GoodBrand goodBrand);

    /***
     * 根据ID查询GoodBrand数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    CommonResult<GoodBrand> findById(@PathVariable Integer id);

    /***
     * 查询GoodBrand全部数据
     * @return
     */
    @GetMapping
    CommonResult<List<GoodBrand>> findAll();
}