package com.crud.tasks.client;

import com.crud.tasks.domain.TrelloBoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class TrelloClient {

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;

    @Value("${trello.app.key}")
    private String trelloAppKey;

    @Value("${trello.app.username}")
    private String username;

    @Value("${trello.app.token}")
    private String trelloToken;



    @Autowired
    private RestTemplate restTemplate;

    public Optional<List<TrelloBoardDto>> getTrelloBoards() {
        URI url = buildTrelloUrl();

        TrelloBoardDto[] boardsResponse = restTemplate.getForObject(url, TrelloBoardDto[].class);
        List<TrelloBoardDto> trelloBoardList = Arrays.asList(boardsResponse);

        return Optional.ofNullable(trelloBoardList);
    }

    private URI buildTrelloUrl() {
        return UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + username)
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("fields", "name,id").build().encode().toUri();
    }
}
