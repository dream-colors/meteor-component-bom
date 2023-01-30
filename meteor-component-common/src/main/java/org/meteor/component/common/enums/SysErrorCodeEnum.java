package org.meteor.component.common.enums;

import lombok.Getter;

/**
 * @author 钟宗兵
 * @date 2023/1/15
 * @since 1.0
 **/
@Getter
public enum SysErrorCodeEnum {
    /**
     *
     */
    SUCCESS(0, "成功"),
    BAD_REQUEST(400, "请求参数不正确"),
    DEMO_DENY(901, "演示模式，禁止写入操作")
    ;

    private final int code;
    private final String desc;

    SysErrorCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static SysErrorCodeEnum of(int code) {
        for (SysErrorCodeEnum value : values()) {
            if(code == value.code) {
                return value;
            }
        }
        return null;
    }

}
