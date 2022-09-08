/**
 * @FileName: MerchantCommissionDetailMapper.java
 * @Package com.sfbest.fss.dao.gshop
 * 
 * @author Administrator
 * @created 2015年6月17日 下午2:15:01
 * 
 * Copyright 2011-2015 顺丰优选 版权所有
 */
package com.sfbest.optimize.batch.mapper.db2;


import com.sfbest.optimize.batch.model.GshopOrderModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;


/**
 * <p>订单相关查询接口</p>
 */
@Mapper
public interface GshopOrderMapper {
 
	/**
	 * 抽取渠道的销售订单
	 */
	List<GshopOrderModel> queryChannelSalesOrder(Map<String, Object> params);

	List<GshopOrderModel> queryChannelRefuseOrder(Map<String,Object> params);

	List<GshopOrderModel> queryChannelReturnOrder(Map<String,Object> params);

}
