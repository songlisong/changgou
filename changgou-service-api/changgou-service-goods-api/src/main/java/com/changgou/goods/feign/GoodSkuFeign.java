package com.changgou.goods.feign;

import com.changgou.goods.pojo.GoodSku;
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
@RequestMapping("/goodSku")
public interface GoodSkuFeign {

    /***
     * GoodSku分页条件搜索实现
     * @param goodSku
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@RequestBody(required = false) GoodSku goodSku, @PathVariable int page, @PathVariable int size);

    /***
     * GoodSku分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param goodSku
     * @return
     */
    @PostMapping(value = "/search" )
    CommonResult<List<GoodSku>> findList(@RequestBody(required = false) GoodSku goodSku);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    CommonResult delete(@PathVariable Long id);

    /***
     * 修改GoodSku数据
     * @param goodSku
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    CommonResult update(@RequestBody GoodSku goodSku, @PathVariable Long id);

    /***
     * 新增GoodSku数据
     * @param goodSku
     * @return
     */
    @PostMapping
    CommonResult add(@RequestBody GoodSku goodSku);

    /***
     * 根据ID查询GoodSku数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    CommonResult<GoodSku> findById(@PathVariable Long id);

    /***
     * 查询GoodSku全部数据
     * @return
     */
    @GetMapping
    CommonResult<List<GoodSku>> findAll();
}