package org.meteor.component.common.pojo;

/**
 * @author 钟宗兵
 * @date 2023/1/15
 * @since 1.0
 **/
public class SingleResponse<T> extends Response {

    private static final long serialVersionUID = 1L;

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static SingleResponse<Void> buildSuccess() {
        SingleResponse<Void> response = new SingleResponse<>();
        response.setSuccess(true);
        return response;
    }

    public static SingleResponse<Void> buildFailure(int errCode, String errMessage) {
        SingleResponse<Void> response = new SingleResponse<>();
        response.setSuccess(false);
        response.setCode(errCode);
        response.setErrMessage(errMessage);
        return response;
    }

    public static <T> SingleResponse<T> of(T data) {
        SingleResponse<T> response = new SingleResponse<>();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

}
