package com.changgou.goods.service.impl;

import com.changgou.goods.mapper.GoodSpecMapper;
import com.changgou.goods.pojo.GoodSpec;
import com.changgou.goods.service.GoodSpecService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodSpec业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class GoodSpecServiceImpl implements GoodSpecService {

    @Autowired
    private GoodSpecMapper goodSpecMapper;


    /**
     * GoodSpec条件+分页查询
     * @param goodSpec 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<GoodSpec> findPage(GoodSpec goodSpec, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(goodSpec);
        //执行搜索
        return new PageInfo<GoodSpec>(goodSpecMapper.selectByExample(example));
    }

    /**
     * GoodSpec分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<GoodSpec> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<GoodSpec>(goodSpecMapper.selectAll());
    }

    /**
     * GoodSpec条件查询
     * @param goodSpec
     * @return
     */
    @Override
    public List<GoodSpec> findList(GoodSpec goodSpec){
        //构建查询条件
        Example example = createExample(goodSpec);
        //根据构建的条件查询数据
        return goodSpecMapper.selectByExample(example);
    }


    /**
     * GoodSpec构建查询对象
     * @param goodSpec
     * @return
     */
    public Example createExample(GoodSpec goodSpec){
        Example example=new Example(GoodSpec.class);
        Example.Criteria criteria = example.createCriteria();
        if(goodSpec!=null){
            // ID
            if(!StringUtils.isEmpty(goodSpec.getId())){
                    criteria.andEqualTo("id",goodSpec.getId());
            }
            // 名称
            if(!StringUtils.isEmpty(goodSpec.getName())){
                    criteria.andLike("name","%"+goodSpec.getName()+"%");
            }
            // 规格选项
            if(!StringUtils.isEmpty(goodSpec.getOptions())){
                    criteria.andEqualTo("options",goodSpec.getOptions());
            }
            // 排序
            if(!StringUtils.isEmpty(goodSpec.getSeq())){
                    criteria.andEqualTo("seq",goodSpec.getSeq());
            }
            // 模板ID
            if(!StringUtils.isEmpty(goodSpec.getTemplateId())){
                    criteria.andEqualTo("templateId",goodSpec.getTemplateId());
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
        goodSpecMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改GoodSpec
     * @param goodSpec
     */
    @Override
    public void update(GoodSpec goodSpec){
        goodSpecMapper.updateByPrimaryKey(goodSpec);
    }

    /**
     * 增加GoodSpec
     * @param goodSpec
     */
    @Override
    public void add(GoodSpec goodSpec){
        goodSpecMapper.insert(goodSpec);
    }

    /**
     * 根据ID查询GoodSpec
     * @param id
     * @return
     */
    @Override
    public GoodSpec findById(Integer id){
        return  goodSpecMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询GoodSpec全部数据
     * @return
     */
    @Override
    public List<GoodSpec> findAll() {
        return goodSpecMapper.selectAll();
    }
}
