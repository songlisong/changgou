package com.changgou.goods.feign;

import com.changgou.goods.pojo.GoodCategory;
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
@RequestMapping("/goodCategory")
public interface GoodCategoryFeign {

    /***
     * GoodCategory分页条件搜索实现
     * @param goodCategory
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@RequestBody(required = false) GoodCategory goodCategory, @PathVariable int page, @PathVariable int size);

    /***
     * GoodCategory分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param goodCategory
     * @return
     */
    @PostMapping(value = "/search" )
    CommonResult<List<GoodCategory>> findList(@RequestBody(required = false) GoodCategory goodCategory);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    CommonResult delete(@PathVariable Integer id);

    /***
     * 修改GoodCategory数据
     * @param goodCategory
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    CommonResult update(@RequestBody GoodCategory goodCategory, @PathVariable Integer id);

    /***
     * 新增GoodCategory数据
     * @param goodCategory
     * @return
     */
    @PostMapping
    CommonResult add(@RequestBody GoodCategory goodCategory);

    /***
     * 根据ID查询GoodCategory数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    CommonResult<GoodCategory> findById(@PathVariable Integer id);

    /***
     * 查询GoodCategory全部数据
     * @return
     */
    @GetMapping
    CommonResult<List<GoodCategory>> findAll();
}