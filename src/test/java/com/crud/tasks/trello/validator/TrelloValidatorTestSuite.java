package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.validator.TrelloValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TrelloValidatorTestSuite {

    @Autowired
    private TrelloValidator trelloValidator;

    @Test
    public void testValidateTrelloBoards() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();

        List<TrelloList> trelloLists = new ArrayList<>();
        TrelloList trelloList = new TrelloList("123", "My list", false);
        trelloLists.add(trelloList);

        TrelloBoard board = new TrelloBoard("1", "Test", trelloLists);

        //When
        List<TrelloBoard> filteredBoards = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertEquals(0, filteredBoards.size());
    }
}