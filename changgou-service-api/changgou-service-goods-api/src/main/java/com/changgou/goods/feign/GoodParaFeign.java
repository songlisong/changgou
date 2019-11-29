package com.changgou.goods.feign;

import com.changgou.goods.pojo.GoodPara;
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
@RequestMapping("/goodPara")
public interface GoodParaFeign {

    /***
     * GoodPara分页条件搜索实现
     * @param goodPara
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@RequestBody(required = false) GoodPara goodPara, @PathVariable int page, @PathVariable int size);

    /***
     * GoodPara分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param goodPara
     * @return
     */
    @PostMapping(value = "/search" )
    CommonResult<List<GoodPara>> findList(@RequestBody(required = false) GoodPara goodPara);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    CommonResult delete(@PathVariable Integer id);

    /***
     * 修改GoodPara数据
     * @param goodPara
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    CommonResult update(@RequestBody GoodPara goodPara, @PathVariable Integer id);

    /***
     * 新增GoodPara数据
     * @param goodPara
     * @return
     */
    @PostMapping
    CommonResult add(@RequestBody GoodPara goodPara);

    /***
     * 根据ID查询GoodPara数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    CommonResult<GoodPara> findById(@PathVariable Integer id);

    /***
     * 查询GoodPara全部数据
     * @return
     */
    @GetMapping
    CommonResult<List<GoodPara>> findAll();
}