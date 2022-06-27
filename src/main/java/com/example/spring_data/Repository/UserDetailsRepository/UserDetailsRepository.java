package com.example.spring_data.Repository.UserDetailsRepository;

import com.example.spring_data.model.User;
import com.example.spring_data.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;
@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
    public List<UserDetails> findAllByFirstNameContainsIgnoreCase(String fname);
    public List<UserDetails> findAllByEmailContainsIgnoreCase(String email);
    public List<UserDetails> findAllByPhoneNumberContainsIgnoreCase(String phone);
}
