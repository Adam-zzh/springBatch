package com.sfbest.optimize.batch.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 渠道佣金明细
 */
public class GfmChannelCommissionDetail {

	/**
	 * ID
	 */
	private Integer id;

	/**
	 * 门店汇总表ID
	 */
	private Integer storeSummaryId;

	/**
	 * 凭证汇总表ID
	 */
	private Integer voucherSummaryId;

	/**
	 * 账套号
	 */
	private String accountNumber;

	/**
	 * 账期
	 */
	private String accountPeriod;

	/**
	 * 渠道类型（1：内部 2：外部）
	 */
	private Integer channelType;

	/**
	 * 销售渠道（1：SY01 2：其它）
	 */
	private Integer salesChannel;

	/**
	 * 分佣类型（1：优选订单 2：海淘订单）
	 */
	private Integer commissionType;

	/**
	 * 分公司编码
	 */
	private String companyCode;

	/**
	 * 分公司名称
	 */
	private String companyName;

	/**
	 * 门店编码
	 */
	private String storeCode;

	/**
	 * 门店名称
	 */
	private String storeName;

	/**
	 * 销售订单ID
	 */
	private Integer salesOrderId;

	/**
	 * 订单号（1：销售订单号 2：退货订单号 3：拒收订单号）
	 */
	private String orderSn;

	/**
	 * 订单类型（1：销售订单 2：退货订单 3：拒收订单）
	 */
	private Integer orderType;

	/**
	 * 订单时间（1：销售订单妥投时间 2：退货订单完成时间 3：拒收订单完成时间）
	 */
	private Integer orderTime;

	/**
	 * 销售金额
	 */
	private BigDecimal salesMoney;

	/**
	 * 运费金额
	 */
	private BigDecimal freightMoney;

	/**
	 * 折扣金额
	 */
	private BigDecimal discountMoney;

	/**
	 * 优惠券抵扣金额
	 */
	private BigDecimal couponMoney;

	/**
	 * 积分抵扣金额
	 */
	private BigDecimal integralMoney;

	/**
	 * 实际支付金额
	 */
	private BigDecimal actualMoney;

	/**
	 * 佣金率
	 */
	private BigDecimal commissionRate;

	/**
	 * 佣金金额
	 */
	private BigDecimal commissionMoney;

	/**
	 * 添加时间
	 */
	private Integer addTime;

	/**
	 * 更新时间
	 */
	private Date modifiedTime;

	/**
	 * 是否删除（0：未删除、1：已删除）
	 */
	private Integer isDeleted;

	/**
	 *
	 */
	public Integer getId() {
		return id;
	}

	/**
	 *
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 *
	 */
	public Integer getStoreSummaryId() {
		return storeSummaryId;
	}

	/**
	 *
	 */
	public void setStoreSummaryId(Integer storeSummaryId) {
		this.storeSummaryId = storeSummaryId;
	}

	/**
	 *
	 */
	public Integer getVoucherSummaryId() {
		return voucherSummaryId;
	}

	/**
	 *
	 */
	public void setVoucherSummaryId(Integer voucherSummaryId) {
		this.voucherSummaryId = voucherSummaryId;
	}

	/**
	 *
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 *
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 *
	 */
	public String getAccountPeriod() {
		return accountPeriod;
	}

	/**
	 *
	 */
	public void setAccountPeriod(String accountPeriod) {
		this.accountPeriod = accountPeriod;
	}

	/**
	 *
	 */
	public Integer getChannelType() {
		return channelType;
	}

	/**
	 *
	 */
	public void setChannelType(Integer channelType) {
		this.channelType = channelType;
	}

	/**
	 *
	 */
	public Integer getSalesChannel() {
		return salesChannel;
	}

	/**
	 *
	 */
	public void setSalesChannel(Integer salesChannel) {
		this.salesChannel = salesChannel;
	}

	/**
	 *
	 */
	public Integer getCommissionType() {
		return commissionType;
	}

	/**
	 *
	 */
	public void setCommissionType(Integer commissionType) {
		this.commissionType = commissionType;
	}

	/**
	 *
	 */
	public String getCompanyCode() {
		return companyCode;
	}

	/**
	 *
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	/**
	 *
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 *
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 *
	 */
	public String getStoreCode() {
		return storeCode;
	}

	/**
	 *
	 */
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	/**
	 *
	 */
	public String getStoreName() {
		return storeName;
	}

	/**
	 *
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	/**
	 *
	 */
	public Integer getSalesOrderId() {
		return salesOrderId;
	}

	/**
	 *
	 */
	public void setSalesOrderId(Integer salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	/**
	 *
	 */
	public String getOrderSn() {
		return orderSn;
	}

	/**
	 *
	 */
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	/**
	 *
	 */
	public Integer getOrderType() {
		return orderType;
	}

	/**
	 *
	 */
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	/**
	 *
	 */
	public Integer getOrderTime() {
		return orderTime;
	}

	/**
	 *
	 */
	public void setOrderTime(Integer orderTime) {
		this.orderTime = orderTime;
	}

	/**
	 *
	 */
	public BigDecimal getSalesMoney() {
		return salesMoney;
	}

	/**
	 *
	 */
	public void setSalesMoney(BigDecimal salesMoney) {
		this.salesMoney = salesMoney;
	}

	/**
	 *
	 */
	public BigDecimal getFreightMoney() {
		return freightMoney;
	}

	/**
	 *
	 */
	public void setFreightMoney(BigDecimal freightMoney) {
		this.freightMoney = freightMoney;
	}

	/**
	 *
	 */
	public BigDecimal getDiscountMoney() {
		return discountMoney;
	}

	/**
	 *
	 */
	public void setDiscountMoney(BigDecimal discountMoney) {
		this.discountMoney = discountMoney;
	}

	/**
	 *
	 */
	public BigDecimal getCouponMoney() {
		return couponMoney;
	}

	/**
	 *
	 */
	public void setCouponMoney(BigDecimal couponMoney) {
		this.couponMoney = couponMoney;
	}

	/**
	 *
	 */
	public BigDecimal getIntegralMoney() {
		return integralMoney;
	}

	/**
	 *
	 */
	public void setIntegralMoney(BigDecimal integralMoney) {
		this.integralMoney = integralMoney;
	}

	/**
	 *
	 */
	public BigDecimal getActualMoney() {
		return actualMoney;
	}

	/**
	 *
	 */
	public void setActualMoney(BigDecimal actualMoney) {
		this.actualMoney = actualMoney;
	}

	/**
	 *
	 */
	public BigDecimal getCommissionRate() {
		return commissionRate;
	}

	/**
	 *
	 */
	public void setCommissionRate(BigDecimal commissionRate) {
		this.commissionRate = commissionRate;
	}

	/**
	 *
	 */
	public BigDecimal getCommissionMoney() {
		return commissionMoney;
	}

	/**
	 *
	 */
	public void setCommissionMoney(BigDecimal commissionMoney) {
		this.commissionMoney = commissionMoney;
	}

	/**
	 *
	 */
	public Integer getAddTime() {
		return addTime;
	}

	/**
	 *
	 */
	public void setAddTime(Integer addTime) {
		this.addTime = addTime;
	}

	/**
	 *
	 */
	public Date getModifiedTime() {
		return modifiedTime;
	}

	/**
	 *
	 */
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	/**
	 *
	 */
	public Integer getIsDeleted() {
		return isDeleted;
	}

	/**
	 *
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

}