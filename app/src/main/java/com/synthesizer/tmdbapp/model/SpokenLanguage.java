package com.synthesizer.tmdbapp.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpokenLanguage implements Serializable {
    private String iso_639_1;
    private String name;
}
