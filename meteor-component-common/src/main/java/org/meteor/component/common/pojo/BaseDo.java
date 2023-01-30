package org.meteor.component.common.pojo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础实体对象
 *
 * @author 芋道源码
 */
@Data
public abstract class BaseDo implements Serializable {

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 最后更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 创建者，目前使用 SysUser 的 id 编号
     *
     */
    private String creator;
    /**
     * 更新者，目前使用 SysUser 的 id 编号
     *
     */
    private String updater;
}
