package com.tcs.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.demo.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    Optional<Loan> findByApplicantNameAndStatus(String applicantName, String status);

}