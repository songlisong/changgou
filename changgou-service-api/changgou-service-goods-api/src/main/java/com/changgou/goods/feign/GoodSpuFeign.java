package com.changgou.goods.feign;

import com.changgou.goods.pojo.GoodSpu;
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
@RequestMapping("/goodSpu")
public interface GoodSpuFeign {

    /***
     * GoodSpu分页条件搜索实现
     * @param goodSpu
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@RequestBody(required = false) GoodSpu goodSpu, @PathVariable int page, @PathVariable int size);

    /***
     * GoodSpu分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param goodSpu
     * @return
     */
    @PostMapping(value = "/search" )
    CommonResult<List<GoodSpu>> findList(@RequestBody(required = false) GoodSpu goodSpu);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    CommonResult delete(@PathVariable Long id);

    /***
     * 修改GoodSpu数据
     * @param goodSpu
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    CommonResult update(@RequestBody GoodSpu goodSpu, @PathVariable Long id);

    /***
     * 新增GoodSpu数据
     * @param goodSpu
     * @return
     */
    @PostMapping
    CommonResult add(@RequestBody GoodSpu goodSpu);

    /***
     * 根据ID查询GoodSpu数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    CommonResult<GoodSpu> findById(@PathVariable Long id);

    /***
     * 查询GoodSpu全部数据
     * @return
     */
    @GetMapping
    CommonResult<List<GoodSpu>> findAll();
}