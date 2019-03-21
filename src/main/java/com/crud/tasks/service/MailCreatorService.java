package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account.");
        functionality.add("Application allows sending tasks to Trello.");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/tasks_frontend");
        context.setVariable("button", "Visit website");
        context.setVariable("goodbye", "Thanks for using tasks app!");
        context.setVariable("admin_config", adminConfig);
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        context.setVariable("application_functionality", functionality);

        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildReminderEmail(String message) {
        Context context = new Context();
        context.setVariable("tasks_url", "http://localhost:8888/tasks_frontend");
        context.setVariable("button", "Visit website");
        context.setVariable("message", message);
        context.setVariable("goodbye", "Thanks for using tasks app!");
        context.setVariable("admin_config", adminConfig);
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        return templateEngine.process("mail/reminder", context);
    }
}
