package com.javarush.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


public interface  BaseEntity<T extends Serializable> {
    void setId(T id);

    T getId();
}
