package com.cxy.seckill.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author cxy
 * @since 2022-08-13
 */
@Data//我的电脑上lombok不好使
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String nickname;

    private String pssword;

    private String slat;

    private String head;

    private Date registerDate;

    private Date lastLoginDate;

    private String loginCount;

	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", pssword=" + pssword + ", slat=" + slat + ", head="
				+ head + ", registerDate=" + registerDate + ", lastLoginDate=" + lastLoginDate + ", loginCount="
				+ loginCount + "]";
	}

	public User() {
		super();
	}

	public User(String id, String nickname, String pssword, String slat, String head, Date registerDate,
			Date lastLoginDate, String loginCount) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.pssword = pssword;
		this.slat = slat;
		this.head = head;
		this.registerDate = registerDate;
		this.lastLoginDate = lastLoginDate;
		this.loginCount = loginCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPssword() {
		return pssword;
	}

	public void setPssword(String pssword) {
		this.pssword = pssword;
	}

	public String getSlat() {
		return slat;
	}

	public void setSlat(String slat) {
		this.slat = slat;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(String loginCount) {
		this.loginCount = loginCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
