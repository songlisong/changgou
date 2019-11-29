package com.changgou.goods.service.impl;

import com.changgou.goods.mapper.GoodSkuMapper;
import com.changgou.goods.pojo.GoodSku;
import com.changgou.goods.service.GoodSkuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodSku业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class GoodSkuServiceImpl implements GoodSkuService {

    @Autowired
    private GoodSkuMapper goodSkuMapper;


    /**
     * GoodSku条件+分页查询
     * @param goodSku 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<GoodSku> findPage(GoodSku goodSku, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(goodSku);
        //执行搜索
        return new PageInfo<GoodSku>(goodSkuMapper.selectByExample(example));
    }

    /**
     * GoodSku分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<GoodSku> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<GoodSku>(goodSkuMapper.selectAll());
    }

    /**
     * GoodSku条件查询
     * @param goodSku
     * @return
     */
    @Override
    public List<GoodSku> findList(GoodSku goodSku){
        //构建查询条件
        Example example = createExample(goodSku);
        //根据构建的条件查询数据
        return goodSkuMapper.selectByExample(example);
    }


    /**
     * GoodSku构建查询对象
     * @param goodSku
     * @return
     */
    public Example createExample(GoodSku goodSku){
        Example example=new Example(GoodSku.class);
        Example.Criteria criteria = example.createCriteria();
        if(goodSku!=null){
            // 商品id
            if(!StringUtils.isEmpty(goodSku.getId())){
                    criteria.andEqualTo("id",goodSku.getId());
            }
            // 商品条码
            if(!StringUtils.isEmpty(goodSku.getSn())){
                    criteria.andEqualTo("sn",goodSku.getSn());
            }
            // SKU名称
            if(!StringUtils.isEmpty(goodSku.getName())){
                    criteria.andLike("name","%"+goodSku.getName()+"%");
            }
            // 价格（分）
            if(!StringUtils.isEmpty(goodSku.getPrice())){
                    criteria.andEqualTo("price",goodSku.getPrice());
            }
            // 库存数量
            if(!StringUtils.isEmpty(goodSku.getNum())){
                    criteria.andEqualTo("num",goodSku.getNum());
            }
            // 库存预警数量
            if(!StringUtils.isEmpty(goodSku.getAlertNum())){
                    criteria.andEqualTo("alertNum",goodSku.getAlertNum());
            }
            // 商品图片
            if(!StringUtils.isEmpty(goodSku.getImage())){
                    criteria.andEqualTo("image",goodSku.getImage());
            }
            // 商品图片列表
            if(!StringUtils.isEmpty(goodSku.getImages())){
                    criteria.andEqualTo("images",goodSku.getImages());
            }
            // 重量（克）
            if(!StringUtils.isEmpty(goodSku.getWeight())){
                    criteria.andEqualTo("weight",goodSku.getWeight());
            }
            // 创建时间
            if(!StringUtils.isEmpty(goodSku.getCreateTime())){
                    criteria.andEqualTo("createTime",goodSku.getCreateTime());
            }
            // 更新时间
            if(!StringUtils.isEmpty(goodSku.getUpdateTime())){
                    criteria.andEqualTo("updateTime",goodSku.getUpdateTime());
            }
            // SPUID
            if(!StringUtils.isEmpty(goodSku.getSpuId())){
                    criteria.andEqualTo("spuId",goodSku.getSpuId());
            }
            // 类目ID
            if(!StringUtils.isEmpty(goodSku.getCategoryId())){
                    criteria.andEqualTo("categoryId",goodSku.getCategoryId());
            }
            // 类目名称
            if(!StringUtils.isEmpty(goodSku.getCategoryName())){
                    criteria.andEqualTo("categoryName",goodSku.getCategoryName());
            }
            // 品牌名称
            if(!StringUtils.isEmpty(goodSku.getBrandName())){
                    criteria.andEqualTo("brandName",goodSku.getBrandName());
            }
            // 规格
            if(!StringUtils.isEmpty(goodSku.getSpec())){
                    criteria.andEqualTo("spec",goodSku.getSpec());
            }
            // 销量
            if(!StringUtils.isEmpty(goodSku.getSaleNum())){
                    criteria.andEqualTo("saleNum",goodSku.getSaleNum());
            }
            // 评论数
            if(!StringUtils.isEmpty(goodSku.getCommentNum())){
                    criteria.andEqualTo("commentNum",goodSku.getCommentNum());
            }
            // 商品状态 1-正常，2-下架，3-删除
            if(!StringUtils.isEmpty(goodSku.getStatus())){
                    criteria.andEqualTo("status",goodSku.getStatus());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Long id){
        goodSkuMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改GoodSku
     * @param goodSku
     */
    @Override
    public void update(GoodSku goodSku){
        goodSkuMapper.updateByPrimaryKey(goodSku);
    }

    /**
     * 增加GoodSku
     * @param goodSku
     */
    @Override
    public void add(GoodSku goodSku){
        goodSkuMapper.insert(goodSku);
    }

    /**
     * 根据ID查询GoodSku
     * @param id
     * @return
     */
    @Override
    public GoodSku findById(Long id){
        return  goodSkuMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询GoodSku全部数据
     * @return
     */
    @Override
    public List<GoodSku> findAll() {
        return goodSkuMapper.selectAll();
    }
}
