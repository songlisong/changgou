package com.changgou.goods.feign;

import com.changgou.goods.pojo.GoodPref;
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
@RequestMapping("/goodPref")
public interface GoodPrefFeign {

    /***
     * GoodPref分页条件搜索实现
     * @param goodPref
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@RequestBody(required = false) GoodPref goodPref, @PathVariable int page, @PathVariable int size);

    /***
     * GoodPref分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param goodPref
     * @return
     */
    @PostMapping(value = "/search" )
    CommonResult<List<GoodPref>> findList(@RequestBody(required = false) GoodPref goodPref);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    CommonResult delete(@PathVariable Integer id);

    /***
     * 修改GoodPref数据
     * @param goodPref
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    CommonResult update(@RequestBody GoodPref goodPref, @PathVariable Integer id);

    /***
     * 新增GoodPref数据
     * @param goodPref
     * @return
     */
    @PostMapping
    CommonResult add(@RequestBody GoodPref goodPref);

    /***
     * 根据ID查询GoodPref数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    CommonResult<GoodPref> findById(@PathVariable Integer id);

    /***
     * 查询GoodPref全部数据
     * @return
     */
    @GetMapping
    CommonResult<List<GoodPref>> findAll();
}