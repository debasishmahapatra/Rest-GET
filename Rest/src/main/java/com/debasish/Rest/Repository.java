package com.debasish.Rest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository extends JpaRepository<Result, Integer> {
    List<Result> findAll();
    Result findById(int id);
    int deleteById(int id);
}


