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
        assertEquals(TrelloBoard.class, convertedList.get(0).getClass());
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
        assertEquals(TrelloBoardDto.class, convertedList.get(0).getClass());
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
        assertEquals(TrelloList.class, convertedList.get(0).getClass());
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
        assertEquals(TrelloListDto.class, convertedList.get(0).getClass());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard card = new TrelloCard("New card", "Simple task", "bottom", "1234");

        //When
        TrelloCardDto cardDto = trelloMapper.mapCardToDto(card);

        //Then
        assertEquals(TrelloCardDto.class, cardDto.getClass());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto cardDto = new TrelloCardDto("New card", "Simple task", "bottom", "1234");

        //When
        TrelloCard card = trelloMapper.mapToCard(cardDto);

        //Then
        assertEquals(TrelloCard.class, card.getClass());
    }
}