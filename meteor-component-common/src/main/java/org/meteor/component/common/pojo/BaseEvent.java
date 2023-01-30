package org.meteor.component.common.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

/**
 * @author 钟宗兵
 * @date 2023/1/26
 * @since 1.0
 **/
@Setter
@Getter
public abstract class BaseEvent extends ApplicationEvent implements Serializable {
    private String id;
    private String data;

    protected BaseEvent(Object source) {
        super(source);
    }
}
