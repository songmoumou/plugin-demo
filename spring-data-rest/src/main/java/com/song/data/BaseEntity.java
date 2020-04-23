package com.song.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author AJohn
 */
@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @UpdateTimestamp
  @Column(nullable = false)
  private Date updateTime;

  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  private Date createTime;

  @Version
  private Long version;

  @NotNull
  private Boolean deleted = false;

}