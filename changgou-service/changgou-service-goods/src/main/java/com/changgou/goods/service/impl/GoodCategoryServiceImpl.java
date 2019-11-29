package com.changgou.goods.service.impl;

import com.changgou.goods.mapper.GoodCategoryMapper;
import com.changgou.goods.pojo.GoodCategory;
import com.changgou.goods.service.GoodCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodCategory业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class GoodCategoryServiceImpl implements GoodCategoryService {

    @Autowired
    private GoodCategoryMapper goodCategoryMapper;


    /**
     * GoodCategory条件+分页查询
     * @param goodCategory 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<GoodCategory> findPage(GoodCategory goodCategory, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(goodCategory);
        //执行搜索
        return new PageInfo<GoodCategory>(goodCategoryMapper.selectByExample(example));
    }

    /**
     * GoodCategory分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<GoodCategory> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<GoodCategory>(goodCategoryMapper.selectAll());
    }

    /**
     * GoodCategory条件查询
     * @param goodCategory
     * @return
     */
    @Override
    public List<GoodCategory> findList(GoodCategory goodCategory){
        //构建查询条件
        Example example = createExample(goodCategory);
        //根据构建的条件查询数据
        return goodCategoryMapper.selectByExample(example);
    }


    /**
     * GoodCategory构建查询对象
     * @param goodCategory
     * @return
     */
    public Example createExample(GoodCategory goodCategory){
        Example example=new Example(GoodCategory.class);
        Example.Criteria criteria = example.createCriteria();
        if(goodCategory!=null){
            // 分类ID
            if(!StringUtils.isEmpty(goodCategory.getId())){
                    criteria.andEqualTo("id",goodCategory.getId());
            }
            // 分类名称
            if(!StringUtils.isEmpty(goodCategory.getName())){
                    criteria.andLike("name","%"+goodCategory.getName()+"%");
            }
            // 商品数量
            if(!StringUtils.isEmpty(goodCategory.getGoodsNum())){
                    criteria.andEqualTo("goodsNum",goodCategory.getGoodsNum());
            }
            // 是否显示
            if(!StringUtils.isEmpty(goodCategory.getIsShow())){
                    criteria.andEqualTo("isShow",goodCategory.getIsShow());
            }
            // 是否导航
            if(!StringUtils.isEmpty(goodCategory.getIsMenu())){
                    criteria.andEqualTo("isMenu",goodCategory.getIsMenu());
            }
            // 排序
            if(!StringUtils.isEmpty(goodCategory.getSeq())){
                    criteria.andEqualTo("seq",goodCategory.getSeq());
            }
            // 上级ID
            if(!StringUtils.isEmpty(goodCategory.getParentId())){
                    criteria.andEqualTo("parentId",goodCategory.getParentId());
            }
            // 模板ID
            if(!StringUtils.isEmpty(goodCategory.getTemplateId())){
                    criteria.andEqualTo("templateId",goodCategory.getTemplateId());
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
        goodCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改GoodCategory
     * @param goodCategory
     */
    @Override
    public void update(GoodCategory goodCategory){
        goodCategoryMapper.updateByPrimaryKey(goodCategory);
    }

    /**
     * 增加GoodCategory
     * @param goodCategory
     */
    @Override
    public void add(GoodCategory goodCategory){
        goodCategoryMapper.insert(goodCategory);
    }

    /**
     * 根据ID查询GoodCategory
     * @param id
     * @return
     */
    @Override
    public GoodCategory findById(Integer id){
        return  goodCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询GoodCategory全部数据
     * @return
     */
    @Override
    public List<GoodCategory> findAll() {
        return goodCategoryMapper.selectAll();
    }
}
