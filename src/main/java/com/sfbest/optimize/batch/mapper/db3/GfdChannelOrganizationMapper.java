package com.sfbest.optimize.batch.mapper.db3;


import com.sfbest.optimize.batch.model.GfdChannelOrganization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 01061941 on 2017/5/31.
 */
@Mapper
public interface GfdChannelOrganizationMapper {

    GfdChannelOrganization getChannelOrganizationByStoreCode(@Param("storeCode") String storeCode);

    GfdChannelOrganization getCompanyName(@Param("companyCode") String companyCode);

    List<GfdChannelOrganization> queryOrganizationListByStoreCodes(@Param("storeCodes") String storeCodes);

    List<GfdChannelOrganization> selectCompanyList();

    List<GfdChannelOrganization> selectStoreList(String companyName);

}
