package com.gsb.dao.repository;
import com.gsb.dao.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OperationRepository extends JpaRepository<Operation, Long> {}