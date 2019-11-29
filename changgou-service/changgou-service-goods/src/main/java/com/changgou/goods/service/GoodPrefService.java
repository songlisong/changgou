package com.changgou.goods.service;

import com.changgou.goods.pojo.GoodPref;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodPref业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface GoodPrefService {

    /***
     * GoodPref多条件分页查询
     * @param goodPref
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodPref> findPage(GoodPref goodPref, int page, int size);

    /***
     * GoodPref分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodPref> findPage(int page, int size);

    /***
     * GoodPref多条件搜索方法
     * @param goodPref
     * @return
     */
    List<GoodPref> findList(GoodPref goodPref);

    /***
     * 删除GoodPref
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改GoodPref数据
     * @param goodPref
     */
    void update(GoodPref goodPref);

    /***
     * 新增GoodPref
     * @param goodPref
     */
    void add(GoodPref goodPref);

    /**
     * 根据ID查询GoodPref
     * @param id
     * @return
     */
     GoodPref findById(Integer id);

    /***
     * 查询所有GoodPref
     * @return
     */
    List<GoodPref> findAll();
}
