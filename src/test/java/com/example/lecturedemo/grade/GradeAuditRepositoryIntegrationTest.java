package com.example.lecturedemo.grade;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class GradeAuditRepositoryIntegrationTest {

    @Autowired
    private GradeAuditRepository gradeAuditRepository;

    @Test
    void saveThenReadByIdPersistsData() {
        GradeAuditRecord saved = gradeAuditRepository.save(new GradeAuditRecord("Victor", 91));

        GradeAuditRecord loaded = gradeAuditRepository.findById(saved.getId()).orElseThrow();

        assertEquals("Victor", loaded.getStudentName());
        assertEquals(91, loaded.getScore());
    }

    @Test
    void updateAndQueryByStudentNameReflectsLatestValue() {
        GradeAuditRecord saved = gradeAuditRepository.save(new GradeAuditRecord("Rose", 78));
        saved.setScore(82);
        gradeAuditRepository.save(saved);

        List<GradeAuditRecord> records = gradeAuditRepository.findByStudentName("Rose");

        assertEquals(1, records.size());
        assertEquals(82, records.getFirst().getScore());
        assertTrue(records.getFirst().getId() > 0);
    }
}



