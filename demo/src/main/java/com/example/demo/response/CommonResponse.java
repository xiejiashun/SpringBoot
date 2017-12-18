package com.example.demo.response;


/**
 * Created by Administrator on 2016-06-12.
 */
public class CommonResponse
{
    /**
     * 0:正常；其他值为错误码
     */
    protected int result;

    protected Object content;

    /**
     * 正常的时候为空串；其他情况为错误消息
     */
    protected String errmsg;

    //空的构造函数，给json转换使用
    public CommonResponse() {

    }

    public CommonResponse(int result, String errmsg)
    {
        this.result = result;
        this.errmsg = errmsg;
    }

    public CommonResponse(int result, String errmsg, Object content)
    {
        this.result = result;
        this.errmsg = errmsg;

        this.content = content;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
