package com.ra.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.catalog.Catalog;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "book_id")
    Long id;
    @Column(columnDefinition = "varchar(100)")
    String title;
    @Column(columnDefinition = "varchar(100)")
    String author;
    @Column(nullable = false)
    Double price;
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "cateId",nullable = false)
    private Category category;



}
