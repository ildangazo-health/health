package com.example.demo.model.check_up;

import com.example.demo.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheckupRepository extends CrudRepository<Checkup, String> {

    @Override
    Optional<Checkup> findById(String s);
}
