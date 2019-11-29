package com.changgou.goods.service.impl;

import com.changgou.goods.mapper.GoodParaMapper;
import com.changgou.goods.pojo.GoodPara;
import com.changgou.goods.service.GoodParaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodPara业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class GoodParaServiceImpl implements GoodParaService {

    @Autowired
    private GoodParaMapper goodParaMapper;


    /**
     * GoodPara条件+分页查询
     * @param goodPara 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<GoodPara> findPage(GoodPara goodPara, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(goodPara);
        //执行搜索
        return new PageInfo<GoodPara>(goodParaMapper.selectByExample(example));
    }

    /**
     * GoodPara分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<GoodPara> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<GoodPara>(goodParaMapper.selectAll());
    }

    /**
     * GoodPara条件查询
     * @param goodPara
     * @return
     */
    @Override
    public List<GoodPara> findList(GoodPara goodPara){
        //构建查询条件
        Example example = createExample(goodPara);
        //根据构建的条件查询数据
        return goodParaMapper.selectByExample(example);
    }


    /**
     * GoodPara构建查询对象
     * @param goodPara
     * @return
     */
    public Example createExample(GoodPara goodPara){
        Example example=new Example(GoodPara.class);
        Example.Criteria criteria = example.createCriteria();
        if(goodPara!=null){
            // id
            if(!StringUtils.isEmpty(goodPara.getId())){
                    criteria.andEqualTo("id",goodPara.getId());
            }
            // 名称
            if(!StringUtils.isEmpty(goodPara.getName())){
                    criteria.andLike("name","%"+goodPara.getName()+"%");
            }
            // 选项
            if(!StringUtils.isEmpty(goodPara.getOptions())){
                    criteria.andEqualTo("options",goodPara.getOptions());
            }
            // 排序
            if(!StringUtils.isEmpty(goodPara.getSeq())){
                    criteria.andEqualTo("seq",goodPara.getSeq());
            }
            // 模板ID
            if(!StringUtils.isEmpty(goodPara.getTemplateId())){
                    criteria.andEqualTo("templateId",goodPara.getTemplateId());
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
        goodParaMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改GoodPara
     * @param goodPara
     */
    @Override
    public void update(GoodPara goodPara){
        goodParaMapper.updateByPrimaryKey(goodPara);
    }

    /**
     * 增加GoodPara
     * @param goodPara
     */
    @Override
    public void add(GoodPara goodPara){
        goodParaMapper.insert(goodPara);
    }

    /**
     * 根据ID查询GoodPara
     * @param id
     * @return
     */
    @Override
    public GoodPara findById(Integer id){
        return  goodParaMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询GoodPara全部数据
     * @return
     */
    @Override
    public List<GoodPara> findAll() {
        return goodParaMapper.selectAll();
    }
}
