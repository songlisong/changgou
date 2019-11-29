package com.changgou.goods.service;

import com.changgou.goods.pojo.GoodSpu;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodSpu业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface GoodSpuService {

    /***
     * GoodSpu多条件分页查询
     * @param goodSpu
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodSpu> findPage(GoodSpu goodSpu, int page, int size);

    /***
     * GoodSpu分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<GoodSpu> findPage(int page, int size);

    /***
     * GoodSpu多条件搜索方法
     * @param goodSpu
     * @return
     */
    List<GoodSpu> findList(GoodSpu goodSpu);

    /***
     * 删除GoodSpu
     * @param id
     */
    void delete(Long id);

    /***
     * 修改GoodSpu数据
     * @param goodSpu
     */
    void update(GoodSpu goodSpu);

    /***
     * 新增GoodSpu
     * @param goodSpu
     */
    void add(GoodSpu goodSpu);

    /**
     * 根据ID查询GoodSpu
     * @param id
     * @return
     */
     GoodSpu findById(Long id);

    /***
     * 查询所有GoodSpu
     * @return
     */
    List<GoodSpu> findAll();
}
