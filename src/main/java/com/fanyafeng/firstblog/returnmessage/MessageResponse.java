package com.fanyafeng.firstblog.returnmessage;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * Author： fanyafeng
 * Data： 2019-03-03 19:41
 * Email: fanyafeng@live.cn
 */
public class MessageResponse {
    private int code;
    private boolean success;
    private Map<String, Object> data = new HashMap<>();

    public static MessageResponse success() {
        MessageResponse response = new MessageResponse();
        response.setCode(200);
        response.setSuccess(true);
        return response;
    }

    public static MessageResponse fail() {
        MessageResponse response = new MessageResponse();
        response.setCode(400);
        response.setSuccess(false);
        return response;
    }

    public MessageResponse add(String data, Object dataContent) {
        this.data.put(data, dataContent);
        return this;
    }

    public MessageResponse add(Object dataContent) {
        this.data.put("data", dataContent);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
