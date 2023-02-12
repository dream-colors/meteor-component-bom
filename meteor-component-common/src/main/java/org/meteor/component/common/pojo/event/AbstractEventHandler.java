package org.meteor.component.common.pojo.event;

import org.meteor.component.common.util.json.JacksonUtil;

/**
 * @author 钟宗兵
 * @since 1.0
 **/
public abstract class AbstractEventHandler<T extends BaseEvent> {
    private T event;

    /**
     * 处理用户事件
     * @param userEvent /
     */
    public void handle(T userEvent) {
        this.event = userEvent;
        doHandle(event);
    }

    /**
     * 事件处理执行方法
     * @param userEvent /
     */
    protected abstract void doHandle(T userEvent);

    /**
     * 获取事件数据
     * @param tClass /
     * @return /
     * @param <E> /
     */
    protected <E> E getData(Class<E> tClass) {
        if (event == null) {
            return null;
        }
        Object data = event.getData();
        return JacksonUtil.toJavaObject(data, tClass);
    }

}
