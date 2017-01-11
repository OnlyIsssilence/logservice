package com.onlyisssilence.muya.dto;

/**
 * Author: MuYa
 * Date  : 2017/1/10
 * Description:
 */
/**
 * 封装json对象，所有返回结果都使用它
 */
public class Result<T> {

    // 返回码，0表示成功，非0表示失败
    private int resultCode;

    // 返回消息，成功为"success"，失败为具体失败信息
    private String resultMessage;

    // 成功时返回的数据
    private T data;

    public Result() {
    }

    public Result(int resultCode, String resultMessage, T data) {
        this.data = data;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public Result(int resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
