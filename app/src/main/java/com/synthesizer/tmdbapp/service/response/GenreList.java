package com.synthesizer.tmdbapp.service.response;

import com.synthesizer.tmdbapp.model.Genre;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenreList implements Serializable {
    private List<Genre> genres;
}
