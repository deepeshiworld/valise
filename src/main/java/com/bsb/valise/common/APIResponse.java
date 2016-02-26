package com.bsb.valise.common;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created with IntelliJ IDEA.
 * User: dhruva
 * Date: 27/04/14
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class APIResponse<T> implements Jsonable{
    private String status;
    private String responseCode;
    private String errorMsg;
    private T data;

    private static Logger logger = LoggerFactory.getLogger(APIResponse.class.getCanonicalName());
    
    public APIResponse() {
    }

    public APIResponse(String status, String responseCode, String errorMsg, T data) {
        this.status = status;
        this.responseCode = responseCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public APIResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public APIResponse setResponseCode(String responseCode) {
        this.responseCode = responseCode;
        return this;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public APIResponse setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public T getData() {
        return data;
    }

    public APIResponse setData(T data) {
        this.data = data;
        return this;
    }

    public static <T> APIResponse<T> getSuccessResponse(T data) {
        return new APIResponse<T>("success", "0", null, data);
    }

    public static APIResponse getSuccessResponse(Jsonable data) {
        return new APIResponse("success", "0", null, data);
    }
    
    public static APIResponse getSuccessResponseForList(List<Jsonable> data) {
        return new APIResponse("success", "0", null, data);
    }
    
    public static <T> APIResponse<T> getErrorResponse(String responseCode, String message, T data) {
        return new APIResponse<T>("failure", responseCode, message, data);
    }

    public boolean isSuccess() {
        return "success".equals(status);
    }

    public boolean isFailure() {
        return "failure".equals(status);
    }

    @SuppressWarnings("unchecked")
	public JSONObject toJSONObject(){
    	JSONObject json = new JSONObject();
    	json.put("status", status);
    	json.put("responseCode", responseCode);
    	json.put("errorMsg", errorMsg);
		if (data == null) {
			json.put("data", null);
		} else if(data instanceof List){
			List<Jsonable> list = (List<Jsonable>)data;
			JSONArray jsonArray = new JSONArray();
			for(Jsonable obj: list){
				if(obj==null){
					logger.warn("Illegal state of data object: {}, list:[]",obj,list);
					continue;
				}
				jsonArray.add(obj.toJSONObject());
			}
			json.put("data", jsonArray);
		}else if(data instanceof Jsonable){
			json.put("data", ((Jsonable) data).toJSONObject());
		}else if(data instanceof JSONObject){
			json.put("data", ((JSONObject) data));
		}
    	return json;
    }
    
	@Override
	public String toString() {
		return "APIResponse [status=" + status + ", responseCode="
				+ responseCode + ", errorMsg=" + errorMsg + ", data=" + data
				+ "]";
	}
    
}
