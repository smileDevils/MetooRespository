package com.koala.module.sns.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.koala.core.constant.Globals;
import com.koala.core.domain.IdEntity;
import com.koala.foundation.domain.User;

/**
 * 
 * <p>
 * Title: SnsAttention.java
 * </p>
 * 
 * <p>
 * Description:sns功能中的粉丝与关注
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 沈阳网之商科技有限公司 www.koala.com
 * </p>
 * 
 * @author jinxinzhe
 * 
 * @date 2014-4-25
 * 
 * @version koala_b2b2c v2.0 2015版
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = Globals.DEFAULT_TABLE_SUFFIX + "sns_attention")
public class SnsAttention extends IdEntity {
	@ManyToOne
	private User fromUser;// 关注者
	@ManyToOne
	private User toUser;// 被关注者

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

}
