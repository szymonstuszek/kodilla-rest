package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {
    private static final String SUBJECT = "Tasks: Once a day email";

    @Autowired
    private SimpleMailService simpleMailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

//    @Scheduled(cron = "*/10 * * * * *")
//    @Scheduled(fixedDelay = 10000)
    public void sendInformationMail() {
        long size = taskRepository.count();
        String message = getCountOfTasksMessage(size);

        simpleMailService.sendReminder(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                message
        ));
    }

    private String getCountOfTasksMessage(long size) {
        String message = "Currently in the database you have: " + size + " task";

        if(size == 0 || size > 1) {
            message += "s";
        }

        return message;
    }
}
