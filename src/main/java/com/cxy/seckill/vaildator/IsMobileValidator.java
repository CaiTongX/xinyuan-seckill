package com.cxy.seckill.vaildator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.thymeleaf.util.StringUtils;

import com.cxy.seckill.utils.ValidatorUtil;
/**
 * 
 * @author 53429
 *手机号码校验规则
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

	private boolean required = false;
	//判断是否为必填
	@Override
    public void initialize(IsMobile constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
        required = constraintAnnotation.required();
    }
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		//如果不为必填
		if (required) {
			//返回并校验
            return ValidatorUtil.isMobile(value);
        } else {
        	//如果为空则返回必填
            if (StringUtils.isEmpty(value)) {
                return true;
            } else {
            	//不为空则校验
                return ValidatorUtil.isMobile(value);
            }
        }
	}


}
