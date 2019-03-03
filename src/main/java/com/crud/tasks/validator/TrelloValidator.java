package com.crud.tasks.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.dto.CreatedTrelloCardDto;
import com.crud.tasks.domain.dto.TrelloBoardDto;
import com.crud.tasks.domain.dto.TrelloCardDto;
import com.crud.tasks.mapper.TrelloMapper;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.facade.TrelloFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrelloValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrelloFacade.class);

    public List<TrelloBoard> validateTrelloBoards(final List<TrelloBoard> trelloBoards) {
        LOGGER.info("Filtering boards...");
        List<TrelloBoard> filteredBoards = trelloBoards.stream()
                .filter(board -> !board.getName().equalsIgnoreCase("test"))
                .collect(Collectors.toList());
        LOGGER.info("Boards have been filtered. Current list size: " + filteredBoards.size());
        return filteredBoards;
    }

    public void validateCard(final TrelloCard trelloCard) {
        if(trelloCard.getName().contains("test")) {
            LOGGER.info("Application testing.");
        } else {
            LOGGER.info("Application processing");
        }
    }
}
