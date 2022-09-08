package com.sfbest.optimize.batch.cache;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用于记录缓存删除情况，以及可以进行一些处理化，此
 */
public class CacheRemoveLisener implements RemovalListener<Object,Object> {

    private static final Logger logger = LoggerFactory.getLogger(CacheRemoveLisener.class);

    @Override
    public void onRemoval(RemovalNotification<Object,Object> removalNotification) {
        logger.debug("缓存被删除："+removalNotification.getKey());
        
    }
}
