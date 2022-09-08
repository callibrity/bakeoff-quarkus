package com.callibrity.bakeoff.domain;

import com.callibrity.bakeoff.value.Genre;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(of = "id")
public class Artist {
    @Id
    private String id = UUID.randomUUID().toString();

    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;
}
