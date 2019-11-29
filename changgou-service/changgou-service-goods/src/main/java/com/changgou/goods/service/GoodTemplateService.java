package com.changgou.goods.service;

import com.changgou.goods.pojo.GoodTemplate;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodTemplate业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface GoodTemplateService {

    /***
     * GoodTemplate多条件分页查询
     * @param goodTemplate
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodTemplate> findPage(GoodTemplate goodTemplate, int page, int size);

    /***
     * GoodTemplate分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodTemplate> findPage(int page, int size);

    /***
     * GoodTemplate多条件搜索方法
     * @param goodTemplate
     * @return
     */
    List<GoodTemplate> findList(GoodTemplate goodTemplate);

    /***
     * 删除GoodTemplate
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改GoodTemplate数据
     * @param goodTemplate
     */
    void update(GoodTemplate goodTemplate);

    /***
     * 新增GoodTemplate
     * @param goodTemplate
     */
    void add(GoodTemplate goodTemplate);

    /**
     * 根据ID查询GoodTemplate
     * @param id
     * @return
     */
     GoodTemplate findById(Integer id);

    /***
     * 查询所有GoodTemplate
     * @return
     */
    List<GoodTemplate> findAll();
}
