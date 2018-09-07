package xyz.smallmuou.entity;

import javax.xml.transform.Result;

/**
 * Created by smou on 7/9/2018.
 */
public class ResponseResult {
    private Integer status;

    private Object result;

    public Integer getStatus() {
        return status;
    }

    public Object getResult() {
        return result;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
