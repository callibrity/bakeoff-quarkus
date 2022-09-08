package com.callibrity.bakeoff.service;

import com.callibrity.bakeoff.domain.Artist;
import com.callibrity.bakeoff.domain.ArtistRepository;
import com.callibrity.bakeoff.value.Genre;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
@Slf4j
public class ArtistService {
    private final ArtistRepository repository;
    private final ServiceMapper mapper;

    @Transactional
    public ArtistDto createArtist(String name, Genre genre) {

        Artist artist = new Artist();
        artist.setName(name);
        artist.setGenre(genre);
        repository.persist(artist);
        return mapper.toDto(artist);
    }

    public Optional<ArtistDto> findArtistById(String id) {
        return repository.findByIdOptional(id).map(mapper::toDto);
    }

    public List<ArtistDto> findAllArtists() {
        return mapper.toDtoList(repository.listAll());
    }

    @Transactional
    public void deleteArtist(String id) {
        repository.deleteById(id);
    }

    @Transactional
    public Optional<ArtistDto> updateArtist(String id, String name, Genre genre) {
        return repository.findByIdOptional(id)
                .map(artist -> {
                    artist.setName(name);
                    artist.setGenre(genre);
                    repository.persist(artist);
                    return mapper.toDto(artist);
                });
    }

}
