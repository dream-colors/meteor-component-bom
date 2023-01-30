package org.meteor.component.common.enums;

import lombok.Getter;

/**
 * @author 钟宗兵
 * @date 2023/1/14
 * @since 1.0
 **/
@Getter
public enum SwitchStatus {
    /** 通用状态 */
    NOT_AVAILABLE(-1, "不可用"),
    OPEN(1, "开启"),
    CLOSE(0, "关闭");

    private final int code;
    private final String desc;

    SwitchStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static SwitchStatus of(int code) {
        for (SwitchStatus value : values()) {
            if(code == value.code) {
                return value;
            }
        }
        return null;
    }
}
