package com.javarush.domain;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
public abstract class AuditUpdateEntity<T extends Serializable> implements BaseEntity<T>{

    @UpdateTimestamp
    private LocalDateTime last_update;
}
