package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.dto.TrelloBoardDto;
import com.crud.tasks.domain.dto.TrelloCardDto;
import com.crud.tasks.domain.dto.TrelloListDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        TrelloBoardDto boardDto = new TrelloBoardDto(
                "123",
                "Test Board",
                new ArrayList<>());

        trelloBoardDtoList.add(boardDto);

        //When
        List<TrelloBoard> convertedList = trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        assertEquals(convertedList.get(0).getId(), "123");
        assertEquals(convertedList.get(0).getName(), "Test Board");
        assertEquals(convertedList.get(0).getLists().size(), 0);
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        TrelloBoard board = new TrelloBoard(
                "123",
                "Test Board",
                new ArrayList<>());

        trelloBoardList.add(board);

        //When
        List<TrelloBoardDto> convertedList = trelloMapper.mapToBoardsDto(trelloBoardList);

        //Then
        assertEquals(convertedList.get(0).getId(), "123");
        assertEquals(convertedList.get(0).getName(), "Test Board");
        assertEquals(convertedList.get(0).getLists().size(), 0);
    }

    @Test
    public void testMapToList() {
        //Given
        List<TrelloListDto> trelloLists = new ArrayList<>();
        TrelloListDto list = new TrelloListDto(
                "123",
                "My list",
                false);

        trelloLists.add(list);

        //When
        List<TrelloList> convertedList = trelloMapper.mapToList(trelloLists);

        //Then
        assertEquals(convertedList.get(0).getId(), "123");
        assertEquals(convertedList.get(0).getName(), "My list");
        assertFalse(convertedList.get(0).isClosed());
    }

    @Test
    public void testMapToListDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        TrelloList list = new TrelloList(
                "123",
                "My list",
                false);

        trelloLists.add(list);

        //When
        List<TrelloListDto> convertedList = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertEquals(convertedList.get(0).getId(), "123");
        assertEquals(convertedList.get(0).getName(), "My list");
        assertFalse(convertedList.get(0).isClosed());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard card = new TrelloCard("New card", "Simple task", "bottom", "1234");

        //When
        TrelloCardDto cardDto = trelloMapper.mapCardToDto(card);

        //Then
        assertEquals(cardDto.getName(), "New card");
        assertEquals(cardDto.getDescription(), "Simple task");
        assertEquals(cardDto.getPos(), "bottom");
        assertEquals(cardDto.getListId(), "1234");
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto cardDto = new TrelloCardDto("New card", "Simple task", "bottom", "1234");

        //When
        TrelloCard card = trelloMapper.mapToCard(cardDto);

        //Then
        assertEquals(card.getName(), "New card");
        assertEquals(card.getDescription(), "Simple task");
        assertEquals(card.getPos(), "bottom");
        assertEquals(card.getListId(), "1234");
    }
}