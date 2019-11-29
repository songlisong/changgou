package com.changgou.goods.service.impl;

import com.changgou.goods.mapper.GoodTemplateMapper;
import com.changgou.goods.pojo.GoodTemplate;
import com.changgou.goods.service.GoodTemplateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodTemplate业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class GoodTemplateServiceImpl implements GoodTemplateService {

    @Autowired
    private GoodTemplateMapper goodTemplateMapper;


    /**
     * GoodTemplate条件+分页查询
     * @param goodTemplate 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<GoodTemplate> findPage(GoodTemplate goodTemplate, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(goodTemplate);
        //执行搜索
        return new PageInfo<GoodTemplate>(goodTemplateMapper.selectByExample(example));
    }

    /**
     * GoodTemplate分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<GoodTemplate> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<GoodTemplate>(goodTemplateMapper.selectAll());
    }

    /**
     * GoodTemplate条件查询
     * @param goodTemplate
     * @return
     */
    @Override
    public List<GoodTemplate> findList(GoodTemplate goodTemplate){
        //构建查询条件
        Example example = createExample(goodTemplate);
        //根据构建的条件查询数据
        return goodTemplateMapper.selectByExample(example);
    }


    /**
     * GoodTemplate构建查询对象
     * @param goodTemplate
     * @return
     */
    public Example createExample(GoodTemplate goodTemplate){
        Example example=new Example(GoodTemplate.class);
        Example.Criteria criteria = example.createCriteria();
        if(goodTemplate!=null){
            // ID
            if(!StringUtils.isEmpty(goodTemplate.getId())){
                    criteria.andEqualTo("id",goodTemplate.getId());
            }
            // 模板名称
            if(!StringUtils.isEmpty(goodTemplate.getName())){
                    criteria.andLike("name","%"+goodTemplate.getName()+"%");
            }
            // 规格数量
            if(!StringUtils.isEmpty(goodTemplate.getSpecNum())){
                    criteria.andEqualTo("specNum",goodTemplate.getSpecNum());
            }
            // 参数数量
            if(!StringUtils.isEmpty(goodTemplate.getParaNum())){
                    criteria.andEqualTo("paraNum",goodTemplate.getParaNum());
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
        goodTemplateMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改GoodTemplate
     * @param goodTemplate
     */
    @Override
    public void update(GoodTemplate goodTemplate){
        goodTemplateMapper.updateByPrimaryKey(goodTemplate);
    }

    /**
     * 增加GoodTemplate
     * @param goodTemplate
     */
    @Override
    public void add(GoodTemplate goodTemplate){
        goodTemplateMapper.insert(goodTemplate);
    }

    /**
     * 根据ID查询GoodTemplate
     * @param id
     * @return
     */
    @Override
    public GoodTemplate findById(Integer id){
        return  goodTemplateMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询GoodTemplate全部数据
     * @return
     */
    @Override
    public List<GoodTemplate> findAll() {
        return goodTemplateMapper.selectAll();
    }
}
