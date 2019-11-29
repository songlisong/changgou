package com.changgou.goods.service.impl;

import com.changgou.goods.mapper.GoodAlbumMapper;
import com.changgou.goods.pojo.GoodAlbum;
import com.changgou.goods.service.GoodAlbumService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:GoodAlbum业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class GoodAlbumServiceImpl implements GoodAlbumService {

    @Autowired
    private GoodAlbumMapper goodAlbumMapper;


    /**
     * GoodAlbum条件+分页查询
     * @param goodAlbum 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<GoodAlbum> findPage(GoodAlbum goodAlbum, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(goodAlbum);
        //执行搜索
        return new PageInfo<GoodAlbum>(goodAlbumMapper.selectByExample(example));
    }

    /**
     * GoodAlbum分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<GoodAlbum> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<GoodAlbum>(goodAlbumMapper.selectAll());
    }

    /**
     * GoodAlbum条件查询
     * @param goodAlbum
     * @return
     */
    @Override
    public List<GoodAlbum> findList(GoodAlbum goodAlbum){
        //构建查询条件
        Example example = createExample(goodAlbum);
        //根据构建的条件查询数据
        return goodAlbumMapper.selectByExample(example);
    }


    /**
     * GoodAlbum构建查询对象
     * @param goodAlbum
     * @return
     */
    public Example createExample(GoodAlbum goodAlbum){
        Example example=new Example(GoodAlbum.class);
        Example.Criteria criteria = example.createCriteria();
        if(goodAlbum!=null){
            // 编号
            if(!StringUtils.isEmpty(goodAlbum.getId())){
                    criteria.andEqualTo("id",goodAlbum.getId());
            }
            // 相册名称
            if(!StringUtils.isEmpty(goodAlbum.getTitle())){
                    criteria.andLike("title","%"+goodAlbum.getTitle()+"%");
            }
            // 相册封面
            if(!StringUtils.isEmpty(goodAlbum.getImage())){
                    criteria.andEqualTo("image",goodAlbum.getImage());
            }
            // 图片列表
            if(!StringUtils.isEmpty(goodAlbum.getImageItems())){
                    criteria.andEqualTo("imageItems",goodAlbum.getImageItems());
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
        goodAlbumMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改GoodAlbum
     * @param goodAlbum
     */
    @Override
    public void update(GoodAlbum goodAlbum){
        goodAlbumMapper.updateByPrimaryKey(goodAlbum);
    }

    /**
     * 增加GoodAlbum
     * @param goodAlbum
     */
    @Override
    public void add(GoodAlbum goodAlbum){
        goodAlbumMapper.insert(goodAlbum);
    }

    /**
     * 根据ID查询GoodAlbum
     * @param id
     * @return
     */
    @Override
    public GoodAlbum findById(Long id){
        return  goodAlbumMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询GoodAlbum全部数据
     * @return
     */
    @Override
    public List<GoodAlbum> findAll() {
        return goodAlbumMapper.selectAll();
    }
}
