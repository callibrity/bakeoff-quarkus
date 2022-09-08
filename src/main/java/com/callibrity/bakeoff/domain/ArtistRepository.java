package com.callibrity.bakeoff.domain;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArtistRepository implements PanacheRepositoryBase<Artist, String> {
}
