package com.sfbest.optimize.batch.controller;

import com.sfbest.optimize.batch.mapper.db1.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ZZH
 * @create 2022/9/7
 * @since 1.0.0
 */
@RequestMapping("test")
@RestController
@Slf4j
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    JobLauncher launcher;

    @Qualifier("commissionDetailJob")
    @Autowired
    Job commissionDetailJob;

    @PostMapping("batchJob")
    public void batchJob(@RequestParam(required = false) Long startTime, @RequestParam(required = false) Long endTime) throws Exception {
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        jobParametersBuilder.addLong("startTime", startTime);
        jobParametersBuilder.addLong("endTime", endTime);
        log.info("执行IOOrderProcess：startTime:{},endTime:{},newtime{}",startTime, endTime);
        launcher.run(commissionDetailJob, jobParametersBuilder.toJobParameters());
    }

    @GetMapping("testDb1")
    public void testDb1(){
        userMapper.select();
    }
}