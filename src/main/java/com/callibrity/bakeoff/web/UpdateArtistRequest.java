package com.callibrity.bakeoff.web;

import com.callibrity.bakeoff.value.Genre;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UpdateArtistRequest {
    @NotEmpty
    String name;
    @NotNull
    Genre genre;
}
