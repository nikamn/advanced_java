package in.nikamn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nikamn.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
