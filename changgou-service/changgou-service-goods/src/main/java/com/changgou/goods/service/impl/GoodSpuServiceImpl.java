package com.changgou.goods.service.impl;

import com.changgou.goods.mapper.GoodSpuMapper;
import com.changgou.goods.pojo.GoodSpu;
import com.changgou.goods.service.GoodSpuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodSpu业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class GoodSpuServiceImpl implements GoodSpuService {

    @Autowired
    private GoodSpuMapper goodSpuMapper;


    /**
     * GoodSpu条件+分页查询
     * @param goodSpu 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<GoodSpu> findPage(GoodSpu goodSpu, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(goodSpu);
        //执行搜索
        return new PageInfo<GoodSpu>(goodSpuMapper.selectByExample(example));
    }

    /**
     * GoodSpu分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<GoodSpu> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<GoodSpu>(goodSpuMapper.selectAll());
    }

    /**
     * GoodSpu条件查询
     * @param goodSpu
     * @return
     */
    @Override
    public List<GoodSpu> findList(GoodSpu goodSpu){
        //构建查询条件
        Example example = createExample(goodSpu);
        //根据构建的条件查询数据
        return goodSpuMapper.selectByExample(example);
    }


    /**
     * GoodSpu构建查询对象
     * @param goodSpu
     * @return
     */
    public Example createExample(GoodSpu goodSpu){
        Example example=new Example(GoodSpu.class);
        Example.Criteria criteria = example.createCriteria();
        if(goodSpu!=null){
            // 主键
            if(!StringUtils.isEmpty(goodSpu.getId())){
                    criteria.andEqualTo("id",goodSpu.getId());
            }
            // 货号
            if(!StringUtils.isEmpty(goodSpu.getSn())){
                    criteria.andEqualTo("sn",goodSpu.getSn());
            }
            // SPU名
            if(!StringUtils.isEmpty(goodSpu.getName())){
                    criteria.andLike("name","%"+goodSpu.getName()+"%");
            }
            // 副标题
            if(!StringUtils.isEmpty(goodSpu.getCaption())){
                    criteria.andEqualTo("caption",goodSpu.getCaption());
            }
            // 品牌ID
            if(!StringUtils.isEmpty(goodSpu.getBrandId())){
                    criteria.andEqualTo("brandId",goodSpu.getBrandId());
            }
            // 一级分类
            if(!StringUtils.isEmpty(goodSpu.getCategory1Id())){
                    criteria.andEqualTo("category1Id",goodSpu.getCategory1Id());
            }
            // 二级分类
            if(!StringUtils.isEmpty(goodSpu.getCategory2Id())){
                    criteria.andEqualTo("category2Id",goodSpu.getCategory2Id());
            }
            // 三级分类
            if(!StringUtils.isEmpty(goodSpu.getCategory3Id())){
                    criteria.andEqualTo("category3Id",goodSpu.getCategory3Id());
            }
            // 模板ID
            if(!StringUtils.isEmpty(goodSpu.getTemplateId())){
                    criteria.andEqualTo("templateId",goodSpu.getTemplateId());
            }
            // 运费模板id
            if(!StringUtils.isEmpty(goodSpu.getFreightId())){
                    criteria.andEqualTo("freightId",goodSpu.getFreightId());
            }
            // 图片
            if(!StringUtils.isEmpty(goodSpu.getImage())){
                    criteria.andEqualTo("image",goodSpu.getImage());
            }
            // 图片列表
            if(!StringUtils.isEmpty(goodSpu.getImages())){
                    criteria.andEqualTo("images",goodSpu.getImages());
            }
            // 售后服务
            if(!StringUtils.isEmpty(goodSpu.getSaleService())){
                    criteria.andEqualTo("saleService",goodSpu.getSaleService());
            }
            // 介绍
            if(!StringUtils.isEmpty(goodSpu.getIntroduction())){
                    criteria.andEqualTo("introduction",goodSpu.getIntroduction());
            }
            // 规格列表
            if(!StringUtils.isEmpty(goodSpu.getSpecItems())){
                    criteria.andEqualTo("specItems",goodSpu.getSpecItems());
            }
            // 参数列表
            if(!StringUtils.isEmpty(goodSpu.getParaItems())){
                    criteria.andEqualTo("paraItems",goodSpu.getParaItems());
            }
            // 销量
            if(!StringUtils.isEmpty(goodSpu.getSaleNum())){
                    criteria.andEqualTo("saleNum",goodSpu.getSaleNum());
            }
            // 评论数
            if(!StringUtils.isEmpty(goodSpu.getCommentNum())){
                    criteria.andEqualTo("commentNum",goodSpu.getCommentNum());
            }
            // 是否上架
            if(!StringUtils.isEmpty(goodSpu.getIsMarketable())){
                    criteria.andEqualTo("isMarketable",goodSpu.getIsMarketable());
            }
            // 是否启用规格
            if(!StringUtils.isEmpty(goodSpu.getIsEnableSpec())){
                    criteria.andEqualTo("isEnableSpec",goodSpu.getIsEnableSpec());
            }
            // 是否删除
            if(!StringUtils.isEmpty(goodSpu.getIsDelete())){
                    criteria.andEqualTo("isDelete",goodSpu.getIsDelete());
            }
            // 审核状态
            if(!StringUtils.isEmpty(goodSpu.getStatus())){
                    criteria.andEqualTo("status",goodSpu.getStatus());
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
        goodSpuMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改GoodSpu
     * @param goodSpu
     */
    @Override
    public void update(GoodSpu goodSpu){
        goodSpuMapper.updateByPrimaryKey(goodSpu);
    }

    /**
     * 增加GoodSpu
     * @param goodSpu
     */
    @Override
    public void add(GoodSpu goodSpu){
        goodSpuMapper.insert(goodSpu);
    }

    /**
     * 根据ID查询GoodSpu
     * @param id
     * @return
     */
    @Override
    public GoodSpu findById(Long id){
        return  goodSpuMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询GoodSpu全部数据
     * @return
     */
    @Override
    public List<GoodSpu> findAll() {
        return goodSpuMapper.selectAll();
    }
}
