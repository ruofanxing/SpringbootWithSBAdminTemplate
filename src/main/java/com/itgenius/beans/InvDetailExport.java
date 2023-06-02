package com.itgenius.beans;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class InvDetailExport implements Serializable {
    private Long id;
    private String batchCode;
    private String name;
    private String type;
    private String area;
    private String barcode;
    private String code;
    private String status;
    private Date updatetime;
}
