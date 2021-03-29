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
public class ProductionCountry implements Serializable {
    private String iso_3166_1;
    private String name;
}
