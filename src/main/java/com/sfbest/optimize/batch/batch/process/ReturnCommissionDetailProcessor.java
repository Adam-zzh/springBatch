package com.sfbest.optimize.batch.batch.process;

import com.sfbest.optimize.batch.cache.ChannelOrganizationCache;
import com.sfbest.optimize.batch.model.GfdChannelOrganization;
import com.sfbest.optimize.batch.model.GfmChannelCommissionDetail;
import com.sfbest.optimize.batch.model.GshopOrderModel;
import com.sfbest.optimize.batch.utils.DateTimeUtils;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 渠道退货订单的佣金明细
 */
@Component("returnCommissionDetailProcessor")
public class ReturnCommissionDetailProcessor implements ItemProcessor<GshopOrderModel, GfmChannelCommissionDetail> {

	@Autowired
	private ChannelOrganizationCache channelOrganizationCache;

	@Override
	public GfmChannelCommissionDetail process(GshopOrderModel gshopOrderModel) throws Exception {
		GfmChannelCommissionDetail channelCommissionDetail = new GfmChannelCommissionDetail();
		//账套号
		GfdChannelOrganization channelOrganization = channelOrganizationCache.getCache().get(gshopOrderModel.getStoreCode());
		channelCommissionDetail.setAccountNumber(channelOrganization != null ? channelOrganization.getAccountBookCode():"");
		//账期
		String accountPeriod = getAccountPeriod();
		channelCommissionDetail.setAccountPeriod(accountPeriod);
		//渠道类型
		if (gshopOrderModel.getOrderSource() == 18 || gshopOrderModel.getOrderSource() == 20 || gshopOrderModel.getOrderSource() == 33) {
			channelCommissionDetail.setChannelType(1);
		} else {
			channelCommissionDetail.setChannelType(2);
		}
		//销售渠道
		if (channelCommissionDetail.getChannelType() == 1) {
			channelCommissionDetail.setSalesChannel(1);
		} else {
			channelCommissionDetail.setSalesChannel(2);
		}
		//分佣类型
		if (gshopOrderModel.getOrderSort() == 3) {
			channelCommissionDetail.setCommissionType(2);
		} else {
			channelCommissionDetail.setCommissionType(1);
		}
		//分公司编码
		channelCommissionDetail.setCompanyCode(channelOrganization.getCompanyCode());
		//分公司名称
		channelCommissionDetail.setCompanyName(channelOrganization.getCompanyName());
		//门店编码
		channelCommissionDetail.setStoreCode(channelOrganization.getStoreCode());
		//门店名称
		channelCommissionDetail.setStoreName(channelOrganization.getStoreName());
		//销售订单ID
		channelCommissionDetail.setSalesOrderId(gshopOrderModel.getOrderId());
		//订单号
		channelCommissionDetail.setOrderSn(gshopOrderModel.getOrderSn());
		//订单类型
		channelCommissionDetail.setOrderType(2);
		//订单时间
		channelCommissionDetail.setOrderTime(gshopOrderModel.getReceivedTime());
		//销售金额
		channelCommissionDetail.setSalesMoney(new BigDecimal(-gshopOrderModel.getOrderAmount()));
		//运费金额
		channelCommissionDetail.setFreightMoney(new BigDecimal(gshopOrderModel.getShippingFee()));
		//折扣金额
		channelCommissionDetail.setDiscountMoney(new BigDecimal(-gshopOrderModel.getDiscount()));
		//优惠券抵扣金额
		channelCommissionDetail.setCouponMoney(new BigDecimal(-gshopOrderModel.getCouponMoney()));
		//积分抵扣金额
		channelCommissionDetail.setIntegralMoney(new BigDecimal(-gshopOrderModel.getIntegralMoney()));
		//实际支付金额
		BigDecimal actualMoney = channelCommissionDetail.getSalesMoney().subtract(channelCommissionDetail.getDiscountMoney());
		actualMoney = actualMoney.subtract(channelCommissionDetail.getCouponMoney()).subtract(channelCommissionDetail.getIntegralMoney());
		channelCommissionDetail.setActualMoney(actualMoney);
		//佣金率
		if (channelCommissionDetail.getCommissionType() == 2) {
			channelCommissionDetail.setCommissionRate(new BigDecimal(5.0));
		} else {
			channelCommissionDetail.setCommissionRate(new BigDecimal(2.5));
		}
		//佣金金额
		BigDecimal commissionMoney = channelCommissionDetail.getActualMoney().multiply(channelCommissionDetail.getCommissionRate());
		channelCommissionDetail.setCommissionMoney(commissionMoney.multiply(new BigDecimal(0.01)));
		//添加时间
		channelCommissionDetail.setAddTime(DateTimeUtils.getCurrentSecond());
		return channelCommissionDetail;
	}

	private String getAccountPeriod() {
		String dateNo = "";
		Date d = DateTimeUtils.getLastTimeOfYesterday();
		String year = d.getYear() + 1900 + "";
		String month = d.getMonth() + 1 + "";
		if (month.equals("10") || month.equals("11") || month.equals("12")) {
			dateNo = year + "-" + month;
		} else {
			dateNo = year + "-0" + month;
		}
		return dateNo;
	}

}
