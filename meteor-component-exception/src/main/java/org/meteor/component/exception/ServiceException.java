package org.meteor.component.exception;

/**
 * 业务逻辑异常 Exception
 */
public final class ServiceException extends RuntimeException {

    /**
     * 业务错误码
     *
     */
    private final Integer code;
    /**
     * 错误提示
     */
    private final String message;

    public ServiceException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

    public ServiceException(Integer code, String message) {
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
