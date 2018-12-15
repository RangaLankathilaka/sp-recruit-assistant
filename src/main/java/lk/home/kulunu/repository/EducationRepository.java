package lk.home.kulunu.repository;

import lk.home.kulunu.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Document,Integer> {
}
