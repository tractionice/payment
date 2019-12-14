package com.payment.order.pojo;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name="my_price")
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String name;
    private Long price;
}
