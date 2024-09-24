package com.sacv.projects.monitoringsystem.app.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<Domain,ID>  extends CrudRepository<Domain, ID>, JpaSpecificationExecutor<Domain> {
}
