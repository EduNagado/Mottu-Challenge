package com.projectMottu.gef.repository;


import com.projectMottu.gef.model.Patio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatioRepository extends JpaRepository<Patio, Long> {
}
