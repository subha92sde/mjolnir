package com.mjolnir;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Year;

@Entity
@Table(name = "movie", schema = "mjolnir")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", unique = true)
    @NotNull
    private String title;

    @Column(name = "imdb_rating")
    @NotNull
    private BigDecimal imdbRating;

    @Column(name = "year_of_release", columnDefinition = "smallint")
    @Convert(converter = YearAttributeConverter.class)
    @NotNull
    private Year yearOfRelease;
}
