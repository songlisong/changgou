package com.changgou.goods.service;

import com.changgou.goods.pojo.GoodAlbum;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodAlbum业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface GoodAlbumService {

    /***
     * GoodAlbum多条件分页查询
     * @param goodAlbum
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodAlbum> findPage(GoodAlbum goodAlbum, int page, int size);

    /***
     * GoodAlbum分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodAlbum> findPage(int page, int size);

    /***
     * GoodAlbum多条件搜索方法
     * @param goodAlbum
     * @return
     */
    List<GoodAlbum> findList(GoodAlbum goodAlbum);

    /***
     * 删除GoodAlbum
     * @param id
     */
    void delete(Long id);

    /***
     * 修改GoodAlbum数据
     * @param goodAlbum
     */
    void update(GoodAlbum goodAlbum);

    /***
     * 新增GoodAlbum
     * @param goodAlbum
     */
    void add(GoodAlbum goodAlbum);

    /**
     * 根据ID查询GoodAlbum
     * @param id
     * @return
     */
     GoodAlbum findById(Long id);

    /***
     * 查询所有GoodAlbum
     * @return
     */
    List<GoodAlbum> findAll();
}
