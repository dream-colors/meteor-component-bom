package org.meteor.component.common.pojo.event;

import cn.hutool.core.util.RandomUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

/**
 * @author 钟宗兵
 * @since 1.0
 **/
@Setter
@Getter
public abstract class BaseEvent extends ApplicationEvent implements Serializable {
    private String id;
    private transient Object data;
    private transient EventType eventType;

    protected BaseEvent(Object source, EventType eventType) {
        super(source);
        this.eventType = eventType;
        this.id = UUID.randomUUID().toString().replace("-", "");
    }
}
