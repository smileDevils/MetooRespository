package com.koala.module.chatting.domain.query;
import org.springframework.web.servlet.ModelAndView;

import com.koala.core.query.QueryObject;

public class ChattingConfigQueryObject extends QueryObject {
	public ChattingConfigQueryObject(String currentPage, ModelAndView mv,
			String orderBy, String orderType) {
		super(currentPage, mv, orderBy, orderType);
		// TODO Auto-generated constructor stub
	}
	public ChattingConfigQueryObject() {
		super();
		// TODO Auto-generated constructor stub
	}
}
