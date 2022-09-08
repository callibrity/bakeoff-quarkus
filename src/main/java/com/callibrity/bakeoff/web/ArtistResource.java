package com.callibrity.bakeoff.web;

import com.callibrity.bakeoff.service.ArtistDto;
import com.callibrity.bakeoff.service.ArtistService;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/api/artists")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@RequiredArgsConstructor
public class ArtistResource {

    private final ArtistService service;

    @POST
    public ArtistDto create(@Valid CreateArtistRequest request) {
        return service.createArtist(request.getName(), request.getGenre());
    }

    @GET
    @Path("/{id}")
    public ArtistDto get(@PathParam("id") String id) {
        return service.findArtistById(id).orElseThrow(() -> new NotFoundException(String.format("Artist with id %s not found.", id)));
    }

    @GET
    public List<ArtistDto> list() {
        return service.findAllArtists();
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id) {
        service.deleteArtist(id);
    }

    @PUT
    @Path("/{id}")
    public ArtistDto update(@PathParam("id") String id, @Valid UpdateArtistRequest request) {
        return service.updateArtist(id, request.getName(), request.getGenre())
                .orElseThrow(() -> new NotFoundException(String.format("Artist with id %s not found.", id)));
    }
}
