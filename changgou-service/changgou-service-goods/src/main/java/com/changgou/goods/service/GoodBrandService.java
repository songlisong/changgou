package com.changgou.goods.service;

import com.changgou.goods.pojo.GoodBrand;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodBrand业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface GoodBrandService {

    /***
     * GoodBrand多条件分页查询
     * @param goodBrand
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodBrand> findPage(GoodBrand goodBrand, int page, int size);

    /***
     * GoodBrand分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodBrand> findPage(int page, int size);

    /***
     * GoodBrand多条件搜索方法
     * @param goodBrand
     * @return
     */
    List<GoodBrand> findList(GoodBrand goodBrand);

    /***
     * 删除GoodBrand
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改GoodBrand数据
     * @param goodBrand
     */
    void update(GoodBrand goodBrand);

    /***
     * 新增GoodBrand
     * @param goodBrand
     */
    void add(GoodBrand goodBrand);

    /**
     * 根据ID查询GoodBrand
     * @param id
     * @return
     */
     GoodBrand findById(Integer id);

    /***
     * 查询所有GoodBrand
     * @return
     */
    List<GoodBrand> findAll();
}
