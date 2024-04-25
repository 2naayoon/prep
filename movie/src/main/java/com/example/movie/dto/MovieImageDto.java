package com.example.movie.dto;

import com.example.movie.entity.Movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class MovieImageDto {
    private Long inum;
    private String uuid;
    private String imgName;
    private String path;

    private Movie movie;
}
