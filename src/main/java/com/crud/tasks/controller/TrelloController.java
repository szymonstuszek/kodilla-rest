package com.crud.tasks.controller;

import com.crud.tasks.client.TrelloClient;
import com.crud.tasks.domain.TrelloBoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

        kodillaBoards.forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));
    }
}
