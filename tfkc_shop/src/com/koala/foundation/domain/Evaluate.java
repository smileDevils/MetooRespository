package com.koala.foundation.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.koala.core.constant.Globals;
import com.koala.core.domain.IdEntity;
import com.koala.manage.admin.tools.HtmlFilterTools;

/**
 * 
 * <p>
 * Title: Evaluate.java
 * </p>
 * 
 * <p>
 * Description:
 * 评价管理类,用户订单完成后，可以对订单商品进行打分评价，同时卖家也可以对买家进行评价，评价打分信息系统自动计算，以此显示店铺信用信息
 * 、商品描述相符信息及用户的购买信用信息
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
 * @author erikzhang
 * 
 * @date 2014-4-25
 * 
 * @version koala_b2b2c v2.0 2015版
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = Globals.DEFAULT_TABLE_SUFFIX + "evaluate")
public class Evaluate extends IdEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	private Goods evaluate_goods;// 评价对应的商品
	private int goods_num;// 购买的数量
	private String goods_price;// 成交时的价格
	@Lob
	@Column(columnDefinition = "LongText")
	private String goods_spec;// 商品属性值
	@ManyToOne(fetch = FetchType.LAZY)
	private OrderForm of;// 评价对应的订单
	private String evaluate_type;// 评价商品 goods
	private int evaluate_buyer_val;// 买家评价，评价类型，1为好评，0为中评，-1为差评
	@Column(precision = 12, scale = 2)
	private BigDecimal description_evaluate; // 描述相符评价
	@Column(precision = 12, scale = 2)
	private BigDecimal service_evaluate; // 服务态度评价
	@Column(precision = 12, scale = 2)
	private BigDecimal ship_evaluate; // 发货速度评价
	@Column(columnDefinition = "LongText")
	private String evaluate_info;// 买家评价信息
	@ManyToOne(fetch = FetchType.LAZY)
	private User evaluate_user;// 评价人
	private int evaluate_status;// 0为正常，1为禁止显示，2为取消评价
	@Column(columnDefinition = "LongText")
	private String evaluate_admin_info;// 管理员操作备注信息
	@Column(columnDefinition = "LongText")
	private String evaluate_photos;// 晒单图片，json管理，单个商品最多五张
	@Column(columnDefinition = "LongText")
	private String reply;// 评价的回复
	@Column(columnDefinition = "int default 0")
	private int reply_status;// 评价回复的状态默认为0未回复 已回复为1；
	@Column(columnDefinition = "int default 0")
	private int addeva_status;// 追加评价的状态默认为0未追加 已追加为1；
	@Column(columnDefinition = "LongText")
	private String addeva_info;// 追加的评价
	@Column(columnDefinition = "LongText")
	private String addeva_photos;// 追加的晒单图片，json管理，单个商品最多五张
	@Temporal(TemporalType.TIMESTAMP)
	private Date addeva_time;// 追加评论的时间

	public Evaluate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evaluate(Long id, Date addTime) {
		super(id, addTime);
		// TODO Auto-generated constructor stub
	}

	public String getAddeva_photos() {
		return addeva_photos;
	}

	public void setAddeva_photos(String addeva_photos) {
		this.addeva_photos = addeva_photos;
	}

	public int getAddeva_status() {
		return addeva_status;
	}

	public void setAddeva_status(int addeva_status) {
		this.addeva_status = addeva_status;
	}

	public String getAddeva_info() {
		return addeva_info;
	}

	public void setAddeva_info(String addeva_info) {
		this.addeva_info = addeva_info;
	}

	public Date getAddeva_time() {
		return addeva_time;
	}

	public void setAddeva_time(Date addeva_time) {
		this.addeva_time = addeva_time;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		reply = HtmlFilterTools.delAllTag(reply);
		this.reply = reply;
	}

	public int getReply_status() {
		return reply_status;
	}

	public void setReply_status(int reply_status) {
		this.reply_status = reply_status;
	}

	public String getEvaluate_photos() {
		return evaluate_photos;
	}

	public void setEvaluate_photos(String evaluate_photos) {
		this.evaluate_photos = evaluate_photos;
	}

	public int getGoods_num() {
		return goods_num;
	}

	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}

	public String getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(String goods_price) {
		this.goods_price = goods_price;
	}

	public int getEvaluate_status() {
		return evaluate_status;
	}

	public void setEvaluate_status(int evaluate_status) {
		this.evaluate_status = evaluate_status;
	}

	public User getEvaluate_user() {
		return evaluate_user;
	}

	public void setEvaluate_user(User evaluate_user) {
		this.evaluate_user = evaluate_user;
	}

	public Goods getEvaluate_goods() {
		return evaluate_goods;
	}

	public void setEvaluate_goods(Goods evaluate_goods) {
		this.evaluate_goods = evaluate_goods;
	}

	public OrderForm getOf() {
		return of;
	}

	public void setOf(OrderForm of) {
		this.of = of;
	}

	public String getEvaluate_info() {
		return evaluate_info;
	}

	public void setEvaluate_info(String evaluate_info) {
		evaluate_info = HtmlFilterTools.delAllTag(evaluate_info);
		this.evaluate_info = evaluate_info;
	}

	public String getEvaluate_type() {
		return evaluate_type;
	}

	public void setEvaluate_type(String evaluate_type) {
		this.evaluate_type = evaluate_type;
	}

	public String getGoods_spec() {
		return goods_spec;
	}

	public void setGoods_spec(String goods_spec) {
		this.goods_spec = goods_spec;
	}

	public int getEvaluate_buyer_val() {
		return evaluate_buyer_val;
	}

	public void setEvaluate_buyer_val(int evaluate_buyer_val) {
		this.evaluate_buyer_val = evaluate_buyer_val;
	}

	public String getEvaluate_admin_info() {
		return evaluate_admin_info;
	}

	public void setEvaluate_admin_info(String evaluate_admin_info) {
		this.evaluate_admin_info = evaluate_admin_info;
	}

	public BigDecimal getDescription_evaluate() {
		return description_evaluate;
	}

	public void setDescription_evaluate(BigDecimal description_evaluate) {
		this.description_evaluate = description_evaluate;
	}

	public BigDecimal getService_evaluate() {
		return service_evaluate;
	}

	public void setService_evaluate(BigDecimal service_evaluate) {
		this.service_evaluate = service_evaluate;
	}

	public BigDecimal getShip_evaluate() {
		return ship_evaluate;
	}

	public void setShip_evaluate(BigDecimal ship_evaluate) {
		this.ship_evaluate = ship_evaluate;
	}
}
