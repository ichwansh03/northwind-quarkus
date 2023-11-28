package com.northwind.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name="categories")
public class Category{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence")
    @SequenceGenerator(name="sequence", sequenceName="categories_category_id_seq", allocationSize=1)
    @Column(name="category_id")
    private Long categoryId;

    @NotNull
    @Column(name="category_name")
    private String categoryName;

    @Column(name="description")
    private String description;


}
