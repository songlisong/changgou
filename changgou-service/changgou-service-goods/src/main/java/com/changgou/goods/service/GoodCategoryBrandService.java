package com.changgou.goods.service;

import com.changgou.goods.pojo.GoodCategoryBrand;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodCategoryBrand业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface GoodCategoryBrandService {

    /***
     * GoodCategoryBrand多条件分页查询
     * @param goodCategoryBrand
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodCategoryBrand> findPage(GoodCategoryBrand goodCategoryBrand, int page, int size);

    /***
     * GoodCategoryBrand分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodCategoryBrand> findPage(int page, int size);

    /***
     * GoodCategoryBrand多条件搜索方法
     * @param goodCategoryBrand
     * @return
     */
    List<GoodCategoryBrand> findList(GoodCategoryBrand goodCategoryBrand);

    /***
     * 删除GoodCategoryBrand
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改GoodCategoryBrand数据
     * @param goodCategoryBrand
     */
    void update(GoodCategoryBrand goodCategoryBrand);

    /***
     * 新增GoodCategoryBrand
     * @param goodCategoryBrand
     */
    void add(GoodCategoryBrand goodCategoryBrand);

    /**
     * 根据ID查询GoodCategoryBrand
     * @param id
     * @return
     */
     GoodCategoryBrand findById(Integer id);

    /***
     * 查询所有GoodCategoryBrand
     * @return
     */
    List<GoodCategoryBrand> findAll();
}
