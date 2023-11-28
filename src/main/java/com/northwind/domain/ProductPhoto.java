package com.northwind.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "product_photos")
public class ProductPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ppho_id")
    private Long pphoId;

    @Column(name="ppho_filename")
    private String pphoFilename;

    @Column(name="ppho_filetype")
    private  String pphoFiletype;

    @Column(name="ppho_filesize")
    private  Integer pphoFileSize;

    @Column(name="ppho_fileurl")
    private String pphoFileUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="ppho_product_id")
    private Product product;

}
