package com.callibrity.bakeoff.web;

import com.callibrity.bakeoff.value.Genre;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreateArtistRequest {
    @NotEmpty
    String name;
    @NotNull
    Genre genre;
}
