package org.meteor.component.common.pojo.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 钟宗兵
 * @since 1.0
 **/
public abstract class AbstractEventListener<T extends BaseEvent> {
    private final Logger logger = LoggerFactory.getLogger(AbstractEventListener.class);
    protected final Map<String, AbstractEventHandler<T>> eventHandlerMap = new HashMap<>(16);

    protected AbstractEventListener(Map<String, AbstractEventHandler<T>> eventHandlerMap) {
        this.eventHandlerMap.putAll(eventHandlerMap);
    }

    public void handleEvent(T event) {
        EventType eventType = event.getEventType();
        // 获取事件处理器
        AbstractEventHandler<T> eventHandler = eventHandlerMap.get(eventType.getEventId());
        if (eventHandler == null) {
            String eventLog = eventType.getEventLogPrefix() + "未获取到事件处理器：{}";
            logger.warn(eventLog, eventType.getEventId());
            return;
        }
        eventHandler.handle(event);
    }
}
