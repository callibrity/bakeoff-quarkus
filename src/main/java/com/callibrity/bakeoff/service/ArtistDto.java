package com.callibrity.bakeoff.service;

import com.callibrity.bakeoff.value.Genre;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ArtistDto {
    String id;
    String name;
    Genre genre;
}
