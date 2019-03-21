package com.crud.tasks.service;

import com.crud.tasks.trello.client.TrelloClient;
import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.dto.CreatedTrelloCardDto;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.domain.dto.TrelloBoardDto;
import com.crud.tasks.domain.dto.TrelloCardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class TrelloService {
    private static final String SUBJECT = "Tasks: New Trello Card";

    @Autowired
    private TrelloClient trelloClient;

    @Autowired
    private SimpleMailService mailService;

    @Autowired
    private AdminConfig adminConfig;

    public List<TrelloBoardDto> fetchTrelloBoards() {
        return trelloClient.getTrelloBoards();
    }

    public CreatedTrelloCardDto createTrelloCard(final TrelloCardDto trelloCardDto) {
        CreatedTrelloCardDto newCard = trelloClient.createNewCard(trelloCardDto);

        ofNullable(newCard).ifPresent(card -> mailService.sendCardCreatedMessage(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                "New card: " + trelloCardDto.getName() + " has been created on your Trello account")));

        return newCard;
    }
}
