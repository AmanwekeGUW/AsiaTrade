package org.example.repository;

import org.example.entity.Logger_Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends JpaRepository<Logger_Table, Long> {
}
