package com.northwind.web.dto;

import com.northwind.domain.Product;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class ProductPhotoDto {
    private Long    pphoId;
    private String  pphoFilename;
    private String  pphoFiletype;
    private Integer pphoFileSize;
    private String  pphoFileUrl;
}
