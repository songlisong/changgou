package com.changgou.goods.feign;

import com.changgou.goods.pojo.GoodStockBack;
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
@RequestMapping("/goodStockBack")
public interface GoodStockBackFeign {

    /***
     * GoodStockBack分页条件搜索实现
     * @param goodStockBack
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@RequestBody(required = false) GoodStockBack goodStockBack, @PathVariable int page, @PathVariable int size);

    /***
     * GoodStockBack分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param goodStockBack
     * @return
     */
    @PostMapping(value = "/search" )
    CommonResult<List<GoodStockBack>> findList(@RequestBody(required = false) GoodStockBack goodStockBack);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    CommonResult delete(@PathVariable String id);

    /***
     * 修改GoodStockBack数据
     * @param goodStockBack
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    CommonResult update(@RequestBody GoodStockBack goodStockBack, @PathVariable String id);

    /***
     * 新增GoodStockBack数据
     * @param goodStockBack
     * @return
     */
    @PostMapping
    CommonResult add(@RequestBody GoodStockBack goodStockBack);

    /***
     * 根据ID查询GoodStockBack数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    CommonResult<GoodStockBack> findById(@PathVariable String id);

    /***
     * 查询GoodStockBack全部数据
     * @return
     */
    @GetMapping
    CommonResult<List<GoodStockBack>> findAll();
}