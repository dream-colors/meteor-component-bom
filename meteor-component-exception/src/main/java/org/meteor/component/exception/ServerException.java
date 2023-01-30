package org.meteor.component.exception;

import org.meteor.component.exception.constants.GlobalErrorCodeConstants;

/**
 * 服务器异常 Exception
 */
public final class ServerException extends RuntimeException {

    /**
     * 全局错误码
     *
     * @see GlobalErrorCodeConstants
     */
    private final Integer code;
    /**
     * 错误提示
     */
    private final String message;

    public ServerException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

    public ServerException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
