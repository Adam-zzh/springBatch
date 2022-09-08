package com.sfbest.optimize.batch.batch.write;

import com.sfbest.optimize.batch.mapper.db1.GfmChannelCommissionDetailMapper;
import com.sfbest.optimize.batch.model.GfmChannelCommissionDetail;
import com.sfbest.optimize.batch.utils.NumberUtils;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 渠道佣金明细
 */
@Component("commissionDetailWriter")
public class CommissionDetailWriter implements ItemWriter<GfmChannelCommissionDetail> {

	@Autowired
	private GfmChannelCommissionDetailMapper gfmChannelCommissionDetailMapper;

	@Override
	public void write(List<? extends GfmChannelCommissionDetail> list) throws Exception {
		for (GfmChannelCommissionDetail gfmChannelCommissionDetail : list) {
			if (gfmChannelCommissionDetail.getOrderType() == 3) {
				GfmChannelCommissionDetail temp = gfmChannelCommissionDetailMapper.existSalesCommistionDetail(gfmChannelCommissionDetail.getSalesOrderId());
				if (temp == null) {
					continue;
				}
			}
			gfmChannelCommissionDetail.setCommissionMoney(NumberUtils.bigdecimalFen(gfmChannelCommissionDetail.getCommissionMoney()));
			gfmChannelCommissionDetailMapper.insertSelective(gfmChannelCommissionDetail);
		}
	}

}
