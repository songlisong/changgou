package com.changgou.goods.service.impl;

import com.changgou.goods.mapper.GoodPrefMapper;
import com.changgou.goods.pojo.GoodPref;
import com.changgou.goods.service.GoodPrefService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodPref业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class GoodPrefServiceImpl implements GoodPrefService {

    @Autowired
    private GoodPrefMapper goodPrefMapper;


    /**
     * GoodPref条件+分页查询
     * @param goodPref 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<GoodPref> findPage(GoodPref goodPref, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(goodPref);
        //执行搜索
        return new PageInfo<GoodPref>(goodPrefMapper.selectByExample(example));
    }

    /**
     * GoodPref分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<GoodPref> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<GoodPref>(goodPrefMapper.selectAll());
    }

    /**
     * GoodPref条件查询
     * @param goodPref
     * @return
     */
    @Override
    public List<GoodPref> findList(GoodPref goodPref){
        //构建查询条件
        Example example = createExample(goodPref);
        //根据构建的条件查询数据
        return goodPrefMapper.selectByExample(example);
    }


    /**
     * GoodPref构建查询对象
     * @param goodPref
     * @return
     */
    public Example createExample(GoodPref goodPref){
        Example example=new Example(GoodPref.class);
        Example.Criteria criteria = example.createCriteria();
        if(goodPref!=null){
            // ID
            if(!StringUtils.isEmpty(goodPref.getId())){
                    criteria.andEqualTo("id",goodPref.getId());
            }
            // 分类ID
            if(!StringUtils.isEmpty(goodPref.getCateId())){
                    criteria.andEqualTo("cateId",goodPref.getCateId());
            }
            // 消费金额
            if(!StringUtils.isEmpty(goodPref.getBuyMoney())){
                    criteria.andEqualTo("buyMoney",goodPref.getBuyMoney());
            }
            // 优惠金额
            if(!StringUtils.isEmpty(goodPref.getPreMoney())){
                    criteria.andEqualTo("preMoney",goodPref.getPreMoney());
            }
            // 活动开始日期
            if(!StringUtils.isEmpty(goodPref.getStartTime())){
                    criteria.andEqualTo("startTime",goodPref.getStartTime());
            }
            // 活动截至日期
            if(!StringUtils.isEmpty(goodPref.getEndTime())){
                    criteria.andEqualTo("endTime",goodPref.getEndTime());
            }
            // 类型,1:普通订单，2：限时活动
            if(!StringUtils.isEmpty(goodPref.getType())){
                    criteria.andEqualTo("type",goodPref.getType());
            }
            // 状态,1:有效，0：无效
            if(!StringUtils.isEmpty(goodPref.getState())){
                    criteria.andEqualTo("state",goodPref.getState());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        goodPrefMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改GoodPref
     * @param goodPref
     */
    @Override
    public void update(GoodPref goodPref){
        goodPrefMapper.updateByPrimaryKey(goodPref);
    }

    /**
     * 增加GoodPref
     * @param goodPref
     */
    @Override
    public void add(GoodPref goodPref){
        goodPrefMapper.insert(goodPref);
    }

    /**
     * 根据ID查询GoodPref
     * @param id
     * @return
     */
    @Override
    public GoodPref findById(Integer id){
        return  goodPrefMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询GoodPref全部数据
     * @return
     */
    @Override
    public List<GoodPref> findAll() {
        return goodPrefMapper.selectAll();
    }
}
