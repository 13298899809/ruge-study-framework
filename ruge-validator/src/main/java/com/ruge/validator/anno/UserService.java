package com.ruge.validator.anno;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruge.wu
 * @Description //TODO $
 * @Date 2021/1/28 15:38
 **/
@Slf4j
@RestController
public class UserService {
    @Value("${useroperation.user.userCancellationCron}")
    private String userCancellationCron;
    @Value("${useroperation.user.userCancellationJob.dateNum}")
    private String dateNum;
    @Value("${userCancellationCron}")
    private String userCancellationCron1;
    @Value("${userCancellationJob.dateNum}")
    private String dateNum1;
    @Value("${useroperation.user.userUpdateMobileCron}")
    private String userUpdateMobileCron;
    @GetMapping("init")
    public void init()
    {
        log.info("userCancellationCron:{}",userCancellationCron);
        log.info("dateNum:{}",dateNum);
        log.info("userCancellationCron1:{}",userCancellationCron1);
        log.info("dateNum1:{}",dateNum1);
        log.info("userUpdateMobileCron:{}",userUpdateMobileCron);
    }

}
