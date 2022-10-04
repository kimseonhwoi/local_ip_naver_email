package shop.shlove.naveremail.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import shop.shlove.naveremail.runner.NaverMailSenderRunner;

@Component
public class EmailSandScheduler {

    @Autowired
    private NaverMailSenderRunner naverMailSenderRunner;

    // 매일 00시 00 분 실행
    @Scheduled(cron = "0 0 0 * * *")
    public void cronJobSch() throws Exception{
        naverMailSenderRunner.sand();
    }
}
