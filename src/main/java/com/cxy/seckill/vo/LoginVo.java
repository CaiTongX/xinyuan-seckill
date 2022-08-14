package com.cxy.seckill.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.cxy.seckill.vaildator.IsMobile;

import lombok.Data;

/**
 * 
 * @author 53429 传递登录参数
 *
 */
@Data // 不好用
public class LoginVo {
	@NotNull
	@IsMobile
	private String mobile;
	@NotNull
	@Length(min = 32)
	private String password;

	public String toString() {
		return "LoginVo{" + "mobile='" + mobile + '\'' + ", password='" + password + '\'' + '}';
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
