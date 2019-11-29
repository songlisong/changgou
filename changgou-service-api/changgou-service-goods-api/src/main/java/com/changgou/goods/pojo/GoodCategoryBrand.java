package com.changgou.goods.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:GoodCategoryBrand构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "GoodCategoryBrand",value = "GoodCategoryBrand")
@Table(name="good_category_brand")
@Data
public class GoodCategoryBrand implements Serializable{

	@ApiModelProperty(value = "分类ID",required = false)
	@Id
    @Column(name = "category_id")
	private Integer categoryId;//分类ID

	@ApiModelProperty(value = "品牌ID",required = false)
    @Column(name = "brand_id")
	private Integer brandId;//品牌ID




}
