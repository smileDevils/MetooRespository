package com.koala.foundation.service.impl;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import com.koala.core.query.PageObject;
import com.koala.core.query.support.IPageList;
import com.koala.core.query.support.IQueryObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.koala.core.dao.IGenericDAO;
import com.koala.core.query.GenericPageList;
import com.koala.foundation.domain.GoodsFloor;
import com.koala.foundation.service.IGoodsFloorService;

@Service
@Transactional
public class GoodsFloorServiceImpl implements IGoodsFloorService{
	@Resource(name = "goodsFloorDAO")
	private IGenericDAO<GoodsFloor> goodsFloorDao;
	
	public boolean save(GoodsFloor goodsFloor) {
		/**
		 * init other field here
		 */
		try {
			this.goodsFloorDao.save(goodsFloor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public GoodsFloor getObjById(Long id) {
		GoodsFloor goodsFloor = this.goodsFloorDao.get(id);
		if (goodsFloor != null) {
			return goodsFloor;
		}
		return null;
	}
	
	public boolean delete(Long id) {
		try {
			this.goodsFloorDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean batchDelete(List<Serializable> goodsFloorIds) {
		// TODO Auto-generated method stub
		for (Serializable id : goodsFloorIds) {
			delete((Long) id);
		}
		return true;
	}
	
	public IPageList list(IQueryObject properties) {
		if (properties == null) {
			return null;
		}
		String query = properties.getQuery();
		String construct = properties.getConstruct();
		Map params = properties.getParameters();
		GenericPageList pList = new GenericPageList(GoodsFloor.class,construct, query,
				params, this.goodsFloorDao);
		if (properties != null) {
			PageObject pageObj = properties.getPageObj();
			if (pageObj != null)
				pList.doList(pageObj.getCurrentPage() == null ? 0 : pageObj
						.getCurrentPage(), pageObj.getPageSize() == null ? 0
						: pageObj.getPageSize());
		} else
			pList.doList(0, -1);
		return pList;
	}
	
	public boolean update(GoodsFloor goodsFloor) {
		try {
			this.goodsFloorDao.update( goodsFloor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
	public List<GoodsFloor> query(String query, Map params, int begin, int max){
		return this.goodsFloorDao.query(query, params, begin, max);
		
	}
}
