package com.changgou.goods.handler;

import com.changgou.vo.CommonResult;
import com.changgou.vo.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 * Created by song on 2019-11-26
 */
@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResult error(Exception e) {
        //e.printStackTrace();
        log.error(e.getMessage());
        return new CommonResult(false, StatusCode.ERROR, e.getMessage(),null);
    }

}
