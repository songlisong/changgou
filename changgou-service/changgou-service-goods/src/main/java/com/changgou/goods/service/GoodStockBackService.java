package com.changgou.goods.service;

import com.changgou.goods.pojo.GoodStockBack;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodStockBack业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface GoodStockBackService {

    /***
     * GoodStockBack多条件分页查询
     * @param goodStockBack
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodStockBack> findPage(GoodStockBack goodStockBack, int page, int size);

    /***
     * GoodStockBack分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodStockBack> findPage(int page, int size);

    /***
     * GoodStockBack多条件搜索方法
     * @param goodStockBack
     * @return
     */
    List<GoodStockBack> findList(GoodStockBack goodStockBack);

    /***
     * 删除GoodStockBack
     * @param id
     */
    void delete(String id);

    /***
     * 修改GoodStockBack数据
     * @param goodStockBack
     */
    void update(GoodStockBack goodStockBack);

    /***
     * 新增GoodStockBack
     * @param goodStockBack
     */
    void add(GoodStockBack goodStockBack);

    /**
     * 根据ID查询GoodStockBack
     * @param id
     * @return
     */
     GoodStockBack findById(String id);

    /***
     * 查询所有GoodStockBack
     * @return
     */
    List<GoodStockBack> findAll();
}
