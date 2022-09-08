package com.sfbest.optimize.batch.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sfbest.optimize.batch.mapper.db3.GfdChannelOrganizationMapper;
import com.sfbest.optimize.batch.model.GfdChannelOrganization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by 01239875 on 2017/5/26.
 */
@Component
@Scope("singleton")
public class ChannelOrganizationCache {

	private final Logger logger = LoggerFactory.getLogger(ChannelOrganizationCache.class);

	private static volatile LoadingCache<String,GfdChannelOrganization> loadingCache = null;

	@Autowired
	private GfdChannelOrganizationMapper channelOrganizationMapper;

	public LoadingCache<String, GfdChannelOrganization> getCache() {
		if (loadingCache == null) {
			synchronized (ChannelOrganizationCache.class) {
				if (loadingCache == null) {
                    loadingCache = CacheBuilder.newBuilder()
							.maximumSize(5000)
							.expireAfterWrite(1, TimeUnit.DAYS)
							.removalListener(new CacheRemoveLisener())
							.build(new CacheLoader<String, GfdChannelOrganization>() {
                                @Override
								public GfdChannelOrganization load(String key)   {
									if (StringUtils.isEmpty(key)) {
                                        return null;
                                    }
									GfdChannelOrganization channelOrganization = null;
									try {
										channelOrganization = channelOrganizationMapper.getChannelOrganizationByStoreCode(key);
										if (channelOrganization != null ) {
											return channelOrganization;
										}
									} catch (Exception e) {
                                        if (logger.isErrorEnabled()){
                                            logger.error("门店缓存出现错误: {}", e);
                                        }
                                    }
									GfdChannelOrganization  nullChannelOrganization = new GfdChannelOrganization();
									nullChannelOrganization.setStoreCode(key);
									nullChannelOrganization.setStoreName("");
									return nullChannelOrganization;
								}
							});
				}
			}
		}
		return loadingCache;
	}
}
