package com.example.infra.database.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Version;

@MappedSuperclass
@Data
public abstract class BaseEntity {
  @Column(name = "creation_date")
  @CreationTimestamp
  private Timestamp createDate;
  @Column(name = "change_date")
  @UpdateTimestamp
  private Timestamp changeDate;
  @Version
  private  int version ;

}
