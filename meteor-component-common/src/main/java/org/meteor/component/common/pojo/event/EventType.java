package org.meteor.component.common.pojo.event;

import java.io.Serializable;

/**
 * @author 钟宗兵
 * @since 1.0
 **/
public interface EventType extends Serializable {

    /**
     * 获取事件id，用于获取事件处理器
     * @return /
     */
    String getEventId();

    /**
     * 获取事件描述,用于日志打印
     * @return /
     */
    String getEventLogPrefix();
}