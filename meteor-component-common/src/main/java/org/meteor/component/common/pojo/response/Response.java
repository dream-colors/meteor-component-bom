package org.meteor.component.common.pojo.response;

import org.meteor.component.common.enums.SysErrorCodeEnum;
import org.meteor.component.common.pojo.command.Dto;
import org.meteor.component.exception.ErrorCode;
import org.meteor.component.exception.ServiceException;

/**
 * @author 钟宗兵
 * @date 2023/1/15
 * @since 1.0
 **/
public class Response extends Dto {

    private static final long serialVersionUID = 1L;

    private boolean success;

    private int code;

    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrMessage() {
        return message;
    }

    public void setErrMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Response [success=" + success + ", code=" + code + ", message=" + message + "]";
    }

    public void checkError() {
        if (success) {
            return;
        }
        throw new ServiceException(code, message);
    }

    public static Response success() {
        Response response = new Response();
        response.setSuccess(true);
        return response;
    }

    public static Response failure(SysErrorCodeEnum errorCode) {
        Response response = new Response();
        response.setSuccess(false);
        response.setCode(errorCode.getCode());
        response.setErrMessage(errorCode.getDesc());
        return response;
    }

    public static Response failure(ServiceException serviceException) {
        Response response = new Response();
        response.setSuccess(false);
        response.setCode(serviceException.getCode());
        response.setErrMessage(serviceException.getMessage());
        return response;
    }

    public static Response failure(ErrorCode errorCode) {
        Response response = new Response();
        response.setSuccess(false);
        response.setCode(errorCode.getCode());
        response.setErrMessage(errorCode.getMsg());
        return response;
    }

    public static Response failure(int code, String message) {
        Response response = new Response();
        response.setSuccess(false);
        response.setCode(code);
        response.setErrMessage(message);
        return response;
    }

}