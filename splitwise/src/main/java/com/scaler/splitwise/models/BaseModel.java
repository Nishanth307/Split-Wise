package com.scaler.splitwise.models;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;


@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) //for auto generating updated values
public class BaseModel {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @CreatedDate
      @Temporal(TemporalType.TIMESTAMP)
      private Date createdAt;

      @LastModifiedBy
      @Temporal(TemporalType.TIMESTAMP)
      private Date updatedAt;
}
