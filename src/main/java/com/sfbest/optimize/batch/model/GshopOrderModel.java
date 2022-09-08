/**
 * @FileName: GshopOrder.java
 * @Package com.sfbest.fss.dao.gshop.read
 * 
 * @author Administrator
 * @created 2015年6月17日 下午2:17:35
 * 
 * Copyright 2011-2015 顺丰优选 版权所有
 */
package com.sfbest.optimize.batch.model;

import java.io.Serializable;

/**
 * <p>gshop_db.gshop_order实体</p>
 * 
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 * 
 * @author 738803 董玉帅
 * @since 1.0
 * @version 1.0
 */
public class GshopOrderModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3995806855300715393L;
	//订单ID
	private Integer orderId;
	private Integer id;
	//订单号
	private String orderSn;
	private Integer payId;
	private Integer orderAmount;
	private Integer productAmount;
	private Integer discount;
	private Integer balance;
	private Integer moneyPaid;
	private Integer couponMoney;
	private Integer giftCardMoney;
	private Integer payTime;
	private Integer shippingTime;
	private Integer receivedTime;
	private Integer couponId;
	private Integer shippingFee;
	private Integer orderStatus;

	private String resourceSn;
	private Integer returnType;
	
	//adds 
	private Integer orderSource;
	private Integer parentOrderId;
	private String  parentOrderSn;
	private Integer payFee;
	private Integer integralMoney;
	private Integer addTime;
	private Integer onlinePlat;
	private Integer userId;
	//adds 2015-08-27 order_ext
	private String storeCode;
	
	private Integer orderBelong;
	
	private String payWorkCode;	  
	private String payStoreCode;  
	private String userMdid ;
	private String orderBelongMdid;
	private String orderBelongHbid;
	private String storeManagerCode;
	private String storeManagerName;
	
	
	private String receiverName;
	private String receiverCode;
	
	
	private String shippingSn;

	//20160615 add
	private Integer couponType;
    //20160901 add
    private Integer orderType;
    private String warehouseSn;
    private Integer opencityId;
    private String outerId;
    private Integer province;
    private Integer city;
    private Integer district;
    private String areaNumber;
    private String giftCard;
    private Integer orderSort;
	private Integer shippingId;
	
	
	//20181219 add
	private String  mealcardBukrs;
	private Integer merchantNumber;
	private Integer mealcardMoney;
	private Integer rufundMealcardMoney;
	private Integer cash;
	private String  innerStaffNo;
	private String  warehouseStoreCode;
	
	
	
	public Integer getCash() {
		return cash;
	}
	public void setCash(Integer cash) {
		this.cash = cash;
	}
	public Integer getRufundMealcardMoney() {
		return rufundMealcardMoney;
	}
	public void setRufundMealcardMoney(Integer rufundMealcardMoney) {
		this.rufundMealcardMoney = rufundMealcardMoney;
	}
	public Integer getMerchantNumber() {
		return merchantNumber;
	}
	public void setMerchantNumber(Integer merchantNumber) {
		this.merchantNumber = merchantNumber;
	}
	public Integer getMealcardMoney() {
		return mealcardMoney;
	}
	public void setMealcardMoney(Integer mealcardMoney) {
		this.mealcardMoney = mealcardMoney;
	}
	public String getInnerStaffNo() {
		return innerStaffNo;
	}
	public void setInnerStaffNo(String innerStaffNo) {
		this.innerStaffNo = innerStaffNo;
	}
	public String getMealcardBukrs() {
		return mealcardBukrs;
	}
	public void setMealcardBukrs(String mealcardBukrs) {
		this.mealcardBukrs = mealcardBukrs;
	}
	
	public String getShippingSn() {
		return shippingSn;
	}
	public void setShippingSn(String shippingSn) {
		this.shippingSn = shippingSn;
	}
	public Integer getOrderSource() {
		return orderSource;
	}
	public void setOrderSource(Integer orderSource) {
		this.orderSource = orderSource;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverCode() {
		return receiverCode;
	}
	public void setReceiverCode(String receiverCode) {
		this.receiverCode = receiverCode;
	}
	public String getPayWorkCode() {
		return payWorkCode;
	}
	public void setPayWorkCode(String payWorkCode) {
		this.payWorkCode = payWorkCode;
	}
	public String getPayStoreCode() {
		return payStoreCode;
	}
	public void setPayStoreCode(String payStoreCode) {
		this.payStoreCode = payStoreCode;
	}
	public String getUserMdid() {
		return userMdid;
	}
	public void setUserMdid(String userMdid) {
		this.userMdid = userMdid;
	}
	public String getOrderBelongMdid() {
		return orderBelongMdid;
	}
	public void setOrderBelongMdid(String orderBelongMdid) {
		this.orderBelongMdid = orderBelongMdid;
	}
	public String getOrderBelongHbid() {
		return orderBelongHbid;
	}
	public void setOrderBelongHbid(String orderBelongHbid) {
		this.orderBelongHbid = orderBelongHbid;
	}
	public String getStoreManagerCode() {
		return storeManagerCode;
	}
	public void setStoreManagerCode(String storeManagerCode) {
		this.storeManagerCode = storeManagerCode;
	}
	public String getStoreManagerName() {
		return storeManagerName;
	}
	public void setStoreManagerName(String storeManagerName) {
		this.storeManagerName = storeManagerName;
	}
	public Integer getOrderBelong() {
		return orderBelong;
	}
	public void setOrderBelong(Integer orderBelong) {
		this.orderBelong = orderBelong;
	}
	public Integer getOnlinePlat() {
		return onlinePlat;
	}
	public void setOnlinePlat(Integer onlinePlat) {
		this.onlinePlat = onlinePlat;
	}
	public Integer getParentOrderId() {
		return parentOrderId;
	}
	public void setParentOrderId(Integer parentOrderId) {
		this.parentOrderId = parentOrderId;
	}
	public String getParentOrderSn() {
		return parentOrderSn;
	}
	public void setParentOrderSn(String parentOrderSn) {
		this.parentOrderSn = parentOrderSn;
	}
	public Integer getPayFee() {
		return payFee;
	}
	public void setPayFee(Integer payFee) {
		this.payFee = payFee;
	}
	public Integer getIntegralMoney() {
		return integralMoney;
	}
	public void setIntegralMoney(Integer integralMoney) {
		this.integralMoney = integralMoney;
	}
	public Integer getAddTime() {
		return addTime;
	}
	public void setAddTime(Integer addTime) {
		this.addTime = addTime;
	}
	
	/**
	 * @return the orderId
	 */
	public Integer getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the orderSn
	 */
	public String getOrderSn() {
		return orderSn;
	}
	/**
	 * @param orderSn the orderSn to set
	 */
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
	/**
	 * @return the payId
	 */
	public Integer getPayId() {
		return payId;
	}
	/**
	 * @param payId the payId to set
	 */
	public void setPayId(Integer payId) {
		this.payId = payId;
	}
	/**
	 * @return the orderAmount
	 */
	public Integer getOrderAmount() {
		return orderAmount;
	}
	/**
	 * @param orderAmount the orderAmount to set
	 */
	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}
	/**
	 * @return the productAmount
	 */
	public Integer getProductAmount() {
		return productAmount;
	}
	/**
	 * @param productAmount the productAmount to set
	 */
	public void setProductAmount(Integer productAmount) {
		this.productAmount = productAmount;
	}
	/**
	 * @return the discount
	 */
	public Integer getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	/**
	 * @return the balance
	 */
	public Integer getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	/**
	 * @return the moneyPaid
	 */
	public Integer getMoneyPaid() {
		return moneyPaid;
	}
	/**
	 * @param moneyPaid the moneyPaid to set
	 */
	public void setMoneyPaid(Integer moneyPaid) {
		this.moneyPaid = moneyPaid;
	}
	/**
	 * @return the couponMoney
	 */
	public Integer getCouponMoney() {
		return couponMoney;
	}
	/**
	 * @param couponMoney the couponMoney to set
	 */
	public void setCouponMoney(Integer couponMoney) {
		this.couponMoney = couponMoney;
	}
	/**
	 * @return the giftCardMoney
	 */
	public Integer getGiftCardMoney() {
		return giftCardMoney;
	}
	/**
	 * @param giftCardMoney the giftCardMoney to set
	 */
	public void setGiftCardMoney(Integer giftCardMoney) {
		this.giftCardMoney = giftCardMoney;
	}
	/**
	 * @return the payTime
	 */
	public Integer getPayTime() {
		return payTime;
	}
	/**
	 * @param payTime the payTime to set
	 */
	public void setPayTime(Integer payTime) {
		this.payTime = payTime;
	}
	/**
	 * @return the shippingTime
	 */
	public Integer getShippingTime() {
		return shippingTime;
	}
	/**
	 * @param shippingTime the shippingTime to set
	 */
	public void setShippingTime(Integer shippingTime) {
		this.shippingTime = shippingTime;
	}
	/**
	 * @return the receivedTime
	 */
	public Integer getReceivedTime() {
		return receivedTime;
	}
	/**
	 * @param receivedTime the receivedTime to set
	 */
	public void setReceivedTime(Integer receivedTime) {
		this.receivedTime = receivedTime;
	}
	/**
	 * @return the couponId
	 */
	public Integer getCouponId() {
		return couponId;
	}
	/**
	 * @param couponId the couponId to set
	 */
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	/**
	 * @return the shippingFee
	 */
	public Integer getShippingFee() {
		return shippingFee;
	}
	/**
	 * @param shippingFee the shippingFee to set
	 */
	public void setShippingFee(Integer shippingFee) {
		this.shippingFee = shippingFee;
	}
	/**
	 * @return the orderStatus
	 */
	public Integer getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public Integer getCouponType() {
		return couponType;
	}

	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getWarehouseSn() {
        return warehouseSn;
    }

    public void setWarehouseSn(String warehouseSn) {
        this.warehouseSn = warehouseSn;
    }

    public Integer getOpencityId() {
        return opencityId;
    }

    public void setOpencityId(Integer opencityId) {
        this.opencityId = opencityId;
    }

    public String getOuterId() {
        return outerId;
    }

    public void setOuterId(String outerId) {
        this.outerId = outerId;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public String getAreaNumber() {
        return areaNumber;
    }

    public void setAreaNumber(String areaNumber) {
        this.areaNumber = areaNumber;
    }

    public String getGiftCard() {
        return giftCard;
    }

    public void setGiftCard(String giftCard) {
        this.giftCard = giftCard;
    }

    public Integer getOrderSort() {
        return orderSort;
    }

    public void setOrderSort(Integer orderSort) {
        this.orderSort = orderSort;
    }

	public String getResourceSn() {
		return resourceSn;
	}

	public void setResourceSn(String resourceSn) {
		this.resourceSn = resourceSn;
	}

	public Integer getReturnType() {
		return returnType;
	}

	public void setReturnType(Integer returnType) {
		this.returnType = returnType;
	}

	public Integer getShippingId() {
		return shippingId;
	}

	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}
	public String getWarehouseStoreCode() {
		return warehouseStoreCode;
	}
	public void setWarehouseStoreCode(String warehouseStoreCode) {
		this.warehouseStoreCode = warehouseStoreCode;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
