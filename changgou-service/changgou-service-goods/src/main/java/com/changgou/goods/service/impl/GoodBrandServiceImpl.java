package com.changgou.goods.service.impl;

import com.changgou.goods.mapper.GoodBrandMapper;
import com.changgou.goods.pojo.GoodBrand;
import com.changgou.goods.service.GoodBrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodBrand业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class GoodBrandServiceImpl implements GoodBrandService {

    @Autowired
    private GoodBrandMapper goodBrandMapper;


    /**
     * GoodBrand条件+分页查询
     * @param goodBrand 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<GoodBrand> findPage(GoodBrand goodBrand, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(goodBrand);
        //执行搜索
        return new PageInfo<GoodBrand>(goodBrandMapper.selectByExample(example));
    }

    /**
     * GoodBrand分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<GoodBrand> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<GoodBrand>(goodBrandMapper.selectAll());
    }

    /**
     * GoodBrand条件查询
     * @param goodBrand
     * @return
     */
    @Override
    public List<GoodBrand> findList(GoodBrand goodBrand){
        //构建查询条件
        Example example = createExample(goodBrand);
        //根据构建的条件查询数据
        return goodBrandMapper.selectByExample(example);
    }


    /**
     * GoodBrand构建查询对象
     * @param goodBrand
     * @return
     */
    public Example createExample(GoodBrand goodBrand){
        Example example=new Example(GoodBrand.class);
        Example.Criteria criteria = example.createCriteria();
        if(goodBrand!=null){
            // 品牌id
            if(!StringUtils.isEmpty(goodBrand.getId())){
                    criteria.andEqualTo("id",goodBrand.getId());
            }
            // 品牌名称
            if(!StringUtils.isEmpty(goodBrand.getName())){
                    criteria.andLike("name","%"+goodBrand.getName()+"%");
            }
            // 品牌图片地址
            if(!StringUtils.isEmpty(goodBrand.getImage())){
                    criteria.andEqualTo("image",goodBrand.getImage());
            }
            // 品牌的首字母
            if(!StringUtils.isEmpty(goodBrand.getLetter())){
                    criteria.andEqualTo("letter",goodBrand.getLetter());
            }
            // 排序
            if(!StringUtils.isEmpty(goodBrand.getSeq())){
                    criteria.andEqualTo("seq",goodBrand.getSeq());
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
        goodBrandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改GoodBrand
     * @param goodBrand
     */
    @Override
    public void update(GoodBrand goodBrand){
        goodBrandMapper.updateByPrimaryKey(goodBrand);
    }

    /**
     * 增加GoodBrand
     * @param goodBrand
     */
    @Override
    public void add(GoodBrand goodBrand){
        goodBrandMapper.insert(goodBrand);
    }

    /**
     * 根据ID查询GoodBrand
     * @param id
     * @return
     */
    @Override
    public GoodBrand findById(Integer id){
        return  goodBrandMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询GoodBrand全部数据
     * @return
     */
    @Override
    public List<GoodBrand> findAll() {
        return goodBrandMapper.selectAll();
    }
}
