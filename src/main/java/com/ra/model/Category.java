package com.ra.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long cateId;
    @Column(nullable = false,columnDefinition = "varchar(150)")
    String cateName;
    String description;
    Boolean status;
 @OneToMany(mappedBy = "category",
 cascade = CascadeType.ALL,
 fetch = FetchType.LAZY,
 orphanRemoval = true)
private List<Book> books = new ArrayList<>();
}
