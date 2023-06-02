package com.itgenius.beans;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="tb_prod")
public class Product implements Serializable {
    @Id
    @GeneratedValue(generator = "increment") //o JPA irá gerar o identificador
    private Long id;
    private String name;
    private String type;
    private String area;
    private String barcode;
    private String code;

}
