package com.itgenius.beans;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="tb_inv_detail")
public class InvDetail implements Serializable {
    @Id
    @GeneratedValue(generator = "increment")
    private Long id;
    private long invId;
    private long prodId;
    private String status;
    private Date updatetime;
}
