package com.ipap.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private int id;
    private String title;
    private String posterURL;
    private String imdbId;

}

