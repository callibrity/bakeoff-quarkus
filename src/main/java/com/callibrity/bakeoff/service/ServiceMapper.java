package com.callibrity.bakeoff.service;

import com.callibrity.bakeoff.domain.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface ServiceMapper {
    List<ArtistDto> toDtoList(List<Artist> artists);
    ArtistDto toDto(Artist artist);
    Artist toEntity(ArtistDto dto);
    void updateEntity(ArtistDto dto, @MappingTarget Artist entity);
}
