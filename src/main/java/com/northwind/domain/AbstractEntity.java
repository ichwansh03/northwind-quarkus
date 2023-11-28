package com.northwind.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity {

    @Column(name="createddate", nullable = false)
    private Instant createdDate = Instant.now();
}
