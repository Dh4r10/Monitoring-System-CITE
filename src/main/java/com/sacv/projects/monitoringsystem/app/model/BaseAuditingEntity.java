package com.sacv.projects.monitoringsystem.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@SQLRestriction("status = true")
@SoftDelete(columnName = "status",strategy = SoftDeleteType.ACTIVE)
@Getter
@Setter
public abstract class BaseAuditingEntity<DomainID> {


    private DomainID id;


    @Column(name = "status",insertable = false,updatable = false)
    private Boolean status=true;
    @CreatedDate
    @Column(name = "created")
    private OffsetDateTime created;
    @LastModifiedDate
    @Column(name="updated")
    private OffsetDateTime updated;

    @CreatedBy
    @Column(name="created_by")
    private String createdBy;
    @LastModifiedBy
    @Column(name="updated_by")
    private String updatedBy;

    public abstract void setDomainID(DomainID id);


}
