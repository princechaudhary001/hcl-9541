package org.example.hrmsdatabase.repository;

import org.example.hrmsdatabase.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByEmployee_IdOrderByAttendanceIdDesc(Long empId);
    Optional<Attendance> findTopByEmployee_IdAndAttendancedateOrderByAttendanceIdDesc(Long empId, LocalDate attendancedate);
}
