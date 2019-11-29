package com.changgou.goods.service;

import com.changgou.goods.pojo.GoodCategory;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodCategory业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface GoodCategoryService {

    /***
     * GoodCategory多条件分页查询
     * @param goodCategory
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodCategory> findPage(GoodCategory goodCategory, int page, int size);

    /***
     * GoodCategory分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodCategory> findPage(int page, int size);

    /***
     * GoodCategory多条件搜索方法
     * @param goodCategory
     * @return
     */
    List<GoodCategory> findList(GoodCategory goodCategory);

    /***
     * 删除GoodCategory
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改GoodCategory数据
     * @param goodCategory
     */
    void update(GoodCategory goodCategory);

    /***
     * 新增GoodCategory
     * @param goodCategory
     */
    void add(GoodCategory goodCategory);

    /**
     * 根据ID查询GoodCategory
     * @param id
     * @return
     */
     GoodCategory findById(Integer id);

    /***
     * 查询所有GoodCategory
     * @return
     */
    List<GoodCategory> findAll();
}
