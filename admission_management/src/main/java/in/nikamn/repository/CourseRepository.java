package in.nikamn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nikamn.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
