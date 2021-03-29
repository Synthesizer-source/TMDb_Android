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
public class ProductionCompany implements Serializable {
    private int id;
    private String logo_path;
    private String name;
    private String origin_country;
}
