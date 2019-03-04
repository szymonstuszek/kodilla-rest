package com.crud.tasks.domain;

import com.crud.tasks.domain.dto.CreatedTrelloCardDto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DomainTestSuite {

    @Test
    public void testTrello() {
        //Given
        Trello trello = new Trello(2,4);
        Trello emptyTrello = new Trello();
        AttachmentsByType attachments = new AttachmentsByType(trello);
        Badges badges = new Badges(3, attachments);
        Badges emptyBadges = new Badges();
        CreatedTrelloCardDto createdCardDto = new CreatedTrelloCardDto("123", "Created card",
                "http://test.com", badges);

        //When

        //Then
        assertEquals(2, trello.getBoard());
        assertEquals(4, trello.getCard());
        assertEquals(3, badges.getVotes());
        assertNotNull(badges.getAttachments());
        assertEquals("123", createdCardDto.getId());
        assertEquals("Created card", createdCardDto.getName());
        assertEquals("http://test.com", createdCardDto.getShortUrl());
        assertNotNull(createdCardDto.getBadges());
        assertNotNull(attachments.getTrello());
        assertNotNull(emptyTrello);
        assertNotNull(emptyBadges);


    }
}
