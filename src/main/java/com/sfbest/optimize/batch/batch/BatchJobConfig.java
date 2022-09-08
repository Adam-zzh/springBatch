package com.sfbest.optimize.batch.batch;

import com.sfbest.optimize.batch.batch.process.RefuseCommissionDetailProcessor;
import com.sfbest.optimize.batch.batch.process.ReturnCommissionDetailProcessor;
import com.sfbest.optimize.batch.batch.process.SalesCommissionDetailProcessor;
import com.sfbest.optimize.batch.batch.reader.RefuseCommissionDetailReader;
import com.sfbest.optimize.batch.batch.reader.ReturnCommissionDetailReader;
import com.sfbest.optimize.batch.batch.reader.SalesCommissionDetailReader;
import com.sfbest.optimize.batch.batch.write.CommissionDetailWriter;
import com.sfbest.optimize.batch.model.GfmChannelCommissionDetail;
import com.sfbest.optimize.batch.model.GshopOrderModel;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created
 * User:lxy
 * Data:2020/9/3
 */

@Configuration
public class BatchJobConfig {
    @Resource
    private JobBuilderFactory jobBuilderFactory;
    @Resource
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job commissionDetailJob(@Qualifier("salesCommissionDetailStep") Step salesCommissionDetailStep,
                                   @Qualifier("refuseCommissionDetailStep") Step refuseCommissionDetailStep,
                                   @Qualifier("returnCommissionDetailStep") Step returnCommissionDetailStep) {
        return jobBuilderFactory.get("commissionDetailJob")
                .start(salesCommissionDetailStep)
                .next(refuseCommissionDetailStep)
                .next(returnCommissionDetailStep)
                .build();
    }

    @Bean
    public Step salesCommissionDetailStep(@Autowired SalesCommissionDetailReader reader, @Autowired SalesCommissionDetailProcessor processor, @Autowired CommissionDetailWriter writer, @Autowired @Qualifier("financialTm") PlatformTransactionManager financialTm) {
        return stepBuilderFactory.get("salesCommissionDetailStep").<GshopOrderModel, GfmChannelCommissionDetail>chunk(1000).reader(reader).processor(processor).writer(writer).transactionManager(financialTm).build();
//            return stepBuilderFactory.get("salesCommissionDetailStep").<GshopOrderModel, GfmChannelCommissionDetail>chunk(1000).reader(reader).processor(processor).writer(writer).build();
    }

    @Bean
    public Step refuseCommissionDetailStep(@Autowired RefuseCommissionDetailReader reader, @Autowired RefuseCommissionDetailProcessor processor, @Autowired CommissionDetailWriter writer, @Autowired @Qualifier("financialTm") PlatformTransactionManager financialTm) {
        return stepBuilderFactory.get("refuseCommissionDetailStep").<GshopOrderModel, GfmChannelCommissionDetail>chunk(1000).reader(reader).processor(processor).writer(writer).transactionManager(financialTm).build();
//                return stepBuilderFactory.get("refuseCommissionDetailStep").<GshopOrderModel, GfmChannelCommissionDetail>chunk(1000).reader(reader).processor(processor).writer(writer).build();
    }

    @Bean
    public Step returnCommissionDetailStep(@Autowired ReturnCommissionDetailReader reader, @Autowired ReturnCommissionDetailProcessor processor, @Autowired CommissionDetailWriter writer, @Autowired @Qualifier("financialTm") PlatformTransactionManager financialTm) {
        return stepBuilderFactory.get("refuseCommissionDetailStep").<GshopOrderModel, GfmChannelCommissionDetail>chunk(1000).reader(reader).processor(processor).writer(writer).transactionManager(financialTm).build();
//                return stepBuilderFactory.get("refuseCommissionDetailStep").<GshopOrderModel, GfmChannelCommissionDetail>chunk(1000).reader(reader).processor(processor).writer(writer).build();
    }
}
