package com.changgou.goods.service;

import com.changgou.goods.pojo.GoodSpec;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodSpec业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface GoodSpecService {

    /***
     * GoodSpec多条件分页查询
     * @param goodSpec
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodSpec> findPage(GoodSpec goodSpec, int page, int size);

    /***
     * GoodSpec分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodSpec> findPage(int page, int size);

    /***
     * GoodSpec多条件搜索方法
     * @param goodSpec
     * @return
     */
    List<GoodSpec> findList(GoodSpec goodSpec);

    /***
     * 删除GoodSpec
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改GoodSpec数据
     * @param goodSpec
     */
    void update(GoodSpec goodSpec);

    /***
     * 新增GoodSpec
     * @param goodSpec
     */
    void add(GoodSpec goodSpec);

    /**
     * 根据ID查询GoodSpec
     * @param id
     * @return
     */
     GoodSpec findById(Integer id);

    /***
     * 查询所有GoodSpec
     * @return
     */
    List<GoodSpec> findAll();
}
