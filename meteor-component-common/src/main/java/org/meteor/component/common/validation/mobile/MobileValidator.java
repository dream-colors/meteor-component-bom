package org.meteor.component.common.validation.mobile;

import org.meteor.component.common.util.validation.ValidationUtils;
import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author 钟宗兵
 * @date 2023/1/15
 * @since 1.0
 **/
public class MobileValidator implements ConstraintValidator<Mobile, String> {

    @Override
    public void initialize(Mobile annotation) {
        // pass
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 如果手机号为空，默认不校验，即校验通过
        if (ObjectUtils.isEmpty(value)) {
            return true;
        }
        // 校验手机
        return ValidationUtils.isMobile(value);
    }

}
