package com.isc.asg.iscdemo.repo;

import com.isc.asg.iscdemo.model.Issuer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuerRepository extends JpaRepository<Issuer, Long> {
}