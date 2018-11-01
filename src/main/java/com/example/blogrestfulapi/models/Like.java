package com.example.blogrestfulapi.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Likes")
public class Like {
    @Id
    @GeneratedValue
    private long id;
    private Boolean liked;
}
