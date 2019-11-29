package com.changgou.goods.service.impl;

import com.changgou.goods.mapper.GoodCategoryBrandMapper;
import com.changgou.goods.pojo.GoodCategoryBrand;
import com.changgou.goods.service.GoodCategoryBrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodCategoryBrand业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class GoodCategoryBrandServiceImpl implements GoodCategoryBrandService {

    @Autowired
    private GoodCategoryBrandMapper goodCategoryBrandMapper;


    /**
     * GoodCategoryBrand条件+分页查询
     * @param goodCategoryBrand 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<GoodCategoryBrand> findPage(GoodCategoryBrand goodCategoryBrand, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(goodCategoryBrand);
        //执行搜索
        return new PageInfo<GoodCategoryBrand>(goodCategoryBrandMapper.selectByExample(example));
    }

    /**
     * GoodCategoryBrand分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<GoodCategoryBrand> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<GoodCategoryBrand>(goodCategoryBrandMapper.selectAll());
    }

    /**
     * GoodCategoryBrand条件查询
     * @param goodCategoryBrand
     * @return
     */
    @Override
    public List<GoodCategoryBrand> findList(GoodCategoryBrand goodCategoryBrand){
        //构建查询条件
        Example example = createExample(goodCategoryBrand);
        //根据构建的条件查询数据
        return goodCategoryBrandMapper.selectByExample(example);
    }


    /**
     * GoodCategoryBrand构建查询对象
     * @param goodCategoryBrand
     * @return
     */
    public Example createExample(GoodCategoryBrand goodCategoryBrand){
        Example example=new Example(GoodCategoryBrand.class);
        Example.Criteria criteria = example.createCriteria();
        if(goodCategoryBrand!=null){
            // 分类ID
            if(!StringUtils.isEmpty(goodCategoryBrand.getCategoryId())){
                    criteria.andEqualTo("categoryId",goodCategoryBrand.getCategoryId());
            }
            // 品牌ID
            if(!StringUtils.isEmpty(goodCategoryBrand.getBrandId())){
                    criteria.andEqualTo("brandId",goodCategoryBrand.getBrandId());
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
        goodCategoryBrandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改GoodCategoryBrand
     * @param goodCategoryBrand
     */
    @Override
    public void update(GoodCategoryBrand goodCategoryBrand){
        goodCategoryBrandMapper.updateByPrimaryKey(goodCategoryBrand);
    }

    /**
     * 增加GoodCategoryBrand
     * @param goodCategoryBrand
     */
    @Override
    public void add(GoodCategoryBrand goodCategoryBrand){
        goodCategoryBrandMapper.insert(goodCategoryBrand);
    }

    /**
     * 根据ID查询GoodCategoryBrand
     * @param id
     * @return
     */
    @Override
    public GoodCategoryBrand findById(Integer id){
        return  goodCategoryBrandMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询GoodCategoryBrand全部数据
     * @return
     */
    @Override
    public List<GoodCategoryBrand> findAll() {
        return goodCategoryBrandMapper.selectAll();
    }
}
