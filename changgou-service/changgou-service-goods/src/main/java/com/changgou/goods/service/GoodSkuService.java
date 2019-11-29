package com.changgou.goods.service;

import com.changgou.goods.pojo.GoodSku;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodSku业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface GoodSkuService {

    /***
     * GoodSku多条件分页查询
     * @param goodSku
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodSku> findPage(GoodSku goodSku, int page, int size);

    /***
     * GoodSku分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodSku> findPage(int page, int size);

    /***
     * GoodSku多条件搜索方法
     * @param goodSku
     * @return
     */
    List<GoodSku> findList(GoodSku goodSku);

    /***
     * 删除GoodSku
     * @param id
     */
    void delete(Long id);

    /***
     * 修改GoodSku数据
     * @param goodSku
     */
    void update(GoodSku goodSku);

    /***
     * 新增GoodSku
     * @param goodSku
     */
    void add(GoodSku goodSku);

    /**
     * 根据ID查询GoodSku
     * @param id
     * @return
     */
     GoodSku findById(Long id);

    /***
     * 查询所有GoodSku
     * @return
     */
    List<GoodSku> findAll();
}
