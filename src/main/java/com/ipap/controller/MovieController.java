package com.ipap.controller;

import com.ipap.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final Logger log = LoggerFactory.getLogger(MovieController.class.getName());

    private final RestTemplate restTemplate;

    public MovieController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{genre}")
    public ResponseEntity<Movie[]> getMovies(@PathVariable String genre) {
        ResponseEntity<Movie[]> response =
                restTemplate.getForEntity("https://api.sampleapis.com/movies/" + genre, Movie[].class);
        log.debug(Arrays.toString(response.getBody()));
        return response;
    }
}
