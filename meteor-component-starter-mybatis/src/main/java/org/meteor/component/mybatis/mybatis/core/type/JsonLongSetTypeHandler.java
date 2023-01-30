package org.meteor.component.mybatis.mybatis.core.type;

import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;
import org.meteor.component.common.util.json.JacksonUtil;

/**
 * 参考 {@link com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler} 实现
 * 在我们将字符串反序列化为 Set 并且泛型为 Long 时，如果每个元素的数值太小，会被处理成 Integer 类型，导致可能存在隐性的 BUG。
 *
 * 例如说哦，SysUserDO 的 postIds 属性
 *
 * @author 芋道源码
 */
public class JsonLongSetTypeHandler extends AbstractJsonTypeHandler<Object> {

    @Override
    protected Object parse(String json) {
        return JacksonUtil.toJavaObjectList(json, Long.class);
    }

    @Override
    protected String toJson(Object obj) {
        return JacksonUtil.toJsonString(obj);
    }

}
