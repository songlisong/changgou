package com.changgou.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 返回结果实体类
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private boolean flag;//是否成功
    private Integer code;//返回码
    private String message;//返回消息

    private T data;//返回数据


    public CommonResult(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }







}
