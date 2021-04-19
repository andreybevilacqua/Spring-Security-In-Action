package com.abevilacqua.ch6smallsecuredwebapp.repo;

import com.abevilacqua.ch6smallsecuredwebapp.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
