package com.sfbest.optimize.batch.batch.reader;

import com.sfbest.optimize.batch.model.GshopOrderModel;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created
 * User:lxy
 * Data:2020/9/3
 */
@Component
@StepScope
public class RefuseCommissionDetailReader extends MyBatisPagingItemReader<GshopOrderModel>{

        Logger logger= LoggerFactory.getLogger(RefuseCommissionDetailReader.class);

        @Value("com.sfbest.optimize.batch.mapper.db2.GshopOrderMapper.queryChannelRefuseOrder")
        @Override
        public void setQueryId(String queryId) {
            try {
                logger.info("查询差异表数据.....");
                super.setQueryId(queryId);
            }
            catch (Exception e){
                logger.info("查询差异表数据异常---" + e.getMessage());
            }

        }

        @Override
        @Autowired
        public void setSqlSessionFactory(@Qualifier("gshopSqlSessionFactory")SqlSessionFactory gshopSqlSessionFactory) {
            super.setSqlSessionFactory(gshopSqlSessionFactory);
        }



        @Value("1000")
        @Override
        public void setPageSize(int pageSize) {
            super.setPageSize(pageSize);
        }

        @Override
        @Value("#{jobParameters}")
        public void setParameterValues(Map parameterValues) {
            super.setParameterValues(parameterValues);
        }
}
