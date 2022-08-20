package com.li.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

@Slf4j
@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void stopWatchTets(){
        StopWatch sw = new StopWatch();
        sw.start("task_1");
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("当前任务名称:{}",sw.currentTaskName());
        sw.stop();
        sw.start("task_2");
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("当前任务名称:{}",sw.currentTaskName());
        sw.stop();

        log.info("任务总耗时:{}ms",sw.getTotalTimeMillis());
        log.info("任务总数:{}",sw.getTaskCount());
        StopWatch.TaskInfo[] taskInfo = sw.getTaskInfo();
        for (int i = 0; i < taskInfo.length; i++) {
            StopWatch.TaskInfo taskInfo1 = taskInfo[i];
            log.info("任务名称:{},耗时:{}ms",taskInfo1.getTaskName(),taskInfo1.getTimeMillis());
        }
    }

}
