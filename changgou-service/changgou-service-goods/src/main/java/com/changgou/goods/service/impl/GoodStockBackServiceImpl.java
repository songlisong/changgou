package com.changgou.goods.service.impl;

import com.changgou.goods.mapper.GoodStockBackMapper;
import com.changgou.goods.pojo.GoodStockBack;
import com.changgou.goods.service.GoodStockBackService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodStockBack业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class GoodStockBackServiceImpl implements GoodStockBackService {

    @Autowired
    private GoodStockBackMapper goodStockBackMapper;


    /**
     * GoodStockBack条件+分页查询
     * @param goodStockBack 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<GoodStockBack> findPage(GoodStockBack goodStockBack, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(goodStockBack);
        //执行搜索
        return new PageInfo<GoodStockBack>(goodStockBackMapper.selectByExample(example));
    }

    /**
     * GoodStockBack分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<GoodStockBack> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<GoodStockBack>(goodStockBackMapper.selectAll());
    }

    /**
     * GoodStockBack条件查询
     * @param goodStockBack
     * @return
     */
    @Override
    public List<GoodStockBack> findList(GoodStockBack goodStockBack){
        //构建查询条件
        Example example = createExample(goodStockBack);
        //根据构建的条件查询数据
        return goodStockBackMapper.selectByExample(example);
    }


    /**
     * GoodStockBack构建查询对象
     * @param goodStockBack
     * @return
     */
    public Example createExample(GoodStockBack goodStockBack){
        Example example=new Example(GoodStockBack.class);
        Example.Criteria criteria = example.createCriteria();
        if(goodStockBack!=null){
            // 订单id
            if(!StringUtils.isEmpty(goodStockBack.getOrderId())){
                    criteria.andEqualTo("orderId",goodStockBack.getOrderId());
            }
            // SKU的id
            if(!StringUtils.isEmpty(goodStockBack.getSkuId())){
                    criteria.andEqualTo("skuId",goodStockBack.getSkuId());
            }
            // 回滚数量
            if(!StringUtils.isEmpty(goodStockBack.getNum())){
                    criteria.andEqualTo("num",goodStockBack.getNum());
            }
            // 回滚状态
            if(!StringUtils.isEmpty(goodStockBack.getStatus())){
                    criteria.andEqualTo("status",goodStockBack.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(goodStockBack.getCreateTime())){
                    criteria.andEqualTo("createTime",goodStockBack.getCreateTime());
            }
            // 回滚时间
            if(!StringUtils.isEmpty(goodStockBack.getBackTime())){
                    criteria.andEqualTo("backTime",goodStockBack.getBackTime());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(String id){
        goodStockBackMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改GoodStockBack
     * @param goodStockBack
     */
    @Override
    public void update(GoodStockBack goodStockBack){
        goodStockBackMapper.updateByPrimaryKey(goodStockBack);
    }

    /**
     * 增加GoodStockBack
     * @param goodStockBack
     */
    @Override
    public void add(GoodStockBack goodStockBack){
        goodStockBackMapper.insert(goodStockBack);
    }

    /**
     * 根据ID查询GoodStockBack
     * @param id
     * @return
     */
    @Override
    public GoodStockBack findById(String id){
        return  goodStockBackMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询GoodStockBack全部数据
     * @return
     */
    @Override
    public List<GoodStockBack> findAll() {
        return goodStockBackMapper.selectAll();
    }
}
