package com.sfbest.optimize.batch.mapper.db1;


import com.sfbest.optimize.batch.model.GfmChannelCommissionDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * 渠道佣金明细
 */
@Mapper
public interface GfmChannelCommissionDetailMapper {

	/**
	 *
	 */
	int insertSelective(GfmChannelCommissionDetail record);


	/**
	 * 查询是否存在销售订单佣金
	 */
	GfmChannelCommissionDetail existSalesCommistionDetail(Integer salesOrderId);

}