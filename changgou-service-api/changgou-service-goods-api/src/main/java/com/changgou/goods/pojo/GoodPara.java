package com.changgou.goods.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:GoodPara构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "GoodPara",value = "GoodPara")
@Table(name="good_para")
@Data
public class GoodPara implements Serializable{

	@ApiModelProperty(value = "id",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//id

	@ApiModelProperty(value = "名称",required = false)
    @Column(name = "name")
	private String name;//名称

	@ApiModelProperty(value = "选项",required = false)
    @Column(name = "options")
	private String options;//选项

	@ApiModelProperty(value = "排序",required = false)
    @Column(name = "seq")
	private Integer seq;//排序

	@ApiModelProperty(value = "模板ID",required = false)
    @Column(name = "template_id")
	private Integer templateId;//模板ID





}
