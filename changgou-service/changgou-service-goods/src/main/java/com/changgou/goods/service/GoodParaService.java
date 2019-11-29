package com.changgou.goods.service;

import com.changgou.goods.pojo.GoodPara;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodPara业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface GoodParaService {

    /***
     * GoodPara多条件分页查询
     * @param goodPara
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodPara> findPage(GoodPara goodPara, int page, int size);

    /***
     * GoodPara分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodPara> findPage(int page, int size);

    /***
     * GoodPara多条件搜索方法
     * @param goodPara
     * @return
     */
    List<GoodPara> findList(GoodPara goodPara);

    /***
     * 删除GoodPara
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改GoodPara数据
     * @param goodPara
     */
    void update(GoodPara goodPara);

    /***
     * 新增GoodPara
     * @param goodPara
     */
    void add(GoodPara goodPara);

    /**
     * 根据ID查询GoodPara
     * @param id
     * @return
     */
     GoodPara findById(Integer id);

    /***
     * 查询所有GoodPara
     * @return
     */
    List<GoodPara> findAll();
}
