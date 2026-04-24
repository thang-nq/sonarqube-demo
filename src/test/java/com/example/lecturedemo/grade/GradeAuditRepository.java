package com.example.lecturedemo.grade;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeAuditRepository extends JpaRepository<GradeAuditRecord, Long> {
    List<GradeAuditRecord> findByStudentName(String studentName);
}

