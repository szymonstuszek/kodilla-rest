package com.crud.tasks.controller;

import com.crud.tasks.client.TrelloClient;
import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public void getTrelloBoards() {
        Optional<List<TrelloBoardDto>> trelloBoards = trelloClient.getTrelloBoards();

        if(trelloBoards.isPresent()) {
            List<TrelloBoardDto> boardsToDisplay = trelloBoards.get();
            displayBoardInfo(boardsToDisplay);
        }
    }

    private void displayBoardInfo(List<TrelloBoardDto> trelloBoards) {
        List<TrelloBoardDto> kodillaBoards = trelloBoards.stream()
                .filter(board -> board.getId() != null && board.getName() != null)
                .filter(board -> board.getName().contains("Kodilla"))
                .collect(Collectors.toList());

        kodillaBoards.forEach(board -> {
            System.out.println(board.getName() + " - " + board.getId());
            System.out.println("This board contains lists: ");

            board.getLists().forEach(list ->
                    System.out.println(list.getName() + " - " + list.getId() + " - " + list.isClosed()));
        });
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloClient.createNewCard(trelloCardDto);
    }
}
