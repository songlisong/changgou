package com.changgou.goods.feign;

import com.changgou.goods.pojo.GoodCategoryBrand;
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
@RequestMapping("/goodCategoryBrand")
public interface GoodCategoryBrandFeign {

    /***
     * GoodCategoryBrand分页条件搜索实现
     * @param goodCategoryBrand
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@RequestBody(required = false) GoodCategoryBrand goodCategoryBrand, @PathVariable int page, @PathVariable int size);

    /***
     * GoodCategoryBrand分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param goodCategoryBrand
     * @return
     */
    @PostMapping(value = "/search" )
    CommonResult<List<GoodCategoryBrand>> findList(@RequestBody(required = false) GoodCategoryBrand goodCategoryBrand);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    CommonResult delete(@PathVariable Integer id);

    /***
     * 修改GoodCategoryBrand数据
     * @param goodCategoryBrand
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    CommonResult update(@RequestBody GoodCategoryBrand goodCategoryBrand, @PathVariable Integer id);

    /***
     * 新增GoodCategoryBrand数据
     * @param goodCategoryBrand
     * @return
     */
    @PostMapping
    CommonResult add(@RequestBody GoodCategoryBrand goodCategoryBrand);

    /***
     * 根据ID查询GoodCategoryBrand数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    CommonResult<GoodCategoryBrand> findById(@PathVariable Integer id);

    /***
     * 查询GoodCategoryBrand全部数据
     * @return
     */
    @GetMapping
    CommonResult<List<GoodCategoryBrand>> findAll();
}