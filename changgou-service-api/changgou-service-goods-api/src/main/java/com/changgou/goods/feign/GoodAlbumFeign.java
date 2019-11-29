package com.changgou.goods.feign;

import com.changgou.goods.pojo.GoodAlbum;
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
@RequestMapping("/goodAlbum")
public interface GoodAlbumFeign {

    /***
     * GoodAlbum分页条件搜索实现
     * @param goodAlbum
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@RequestBody(required = false) GoodAlbum goodAlbum, @PathVariable int page, @PathVariable int size);

    /***
     * GoodAlbum分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    CommonResult<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param goodAlbum
     * @return
     */
    @PostMapping(value = "/search" )
    CommonResult<List<GoodAlbum>> findList(@RequestBody(required = false) GoodAlbum goodAlbum);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    CommonResult delete(@PathVariable Long id);

    /***
     * 修改GoodAlbum数据
     * @param goodAlbum
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    CommonResult update(@RequestBody GoodAlbum goodAlbum, @PathVariable Long id);

    /***
     * 新增GoodAlbum数据
     * @param goodAlbum
     * @return
     */
    @PostMapping
    CommonResult add(@RequestBody GoodAlbum goodAlbum);

    /***
     * 根据ID查询GoodAlbum数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    CommonResult<GoodAlbum> findById(@PathVariable Long id);

    /***
     * 查询GoodAlbum全部数据
     * @return
     */
    @GetMapping
    CommonResult<List<GoodAlbum>> findAll();
}