package com.vinicius.school.repositories;

import com.vinicius.school.entities.Deliver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeliverRepository extends JpaRepository<Deliver, Long> {

}