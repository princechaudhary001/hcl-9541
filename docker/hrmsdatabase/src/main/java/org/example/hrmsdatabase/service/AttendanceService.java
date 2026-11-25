package org.example.hrmsdatabase.service;

import org.example.hrmsdatabase.model.Attendance;
import org.example.hrmsdatabase.model.Employee;
import org.example.hrmsdatabase.repository.AttendanceRepository;
import org.example.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee resolveEmployee(Long empId) {
        return employeeRepository.findById(empId)
                .or(() -> employeeRepository.findByEmpCode(String.valueOf(empId)))
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + empId));
    }

    public Attendance checkIn(Long empId) {
        Employee employee = resolveEmployee(empId);
        LocalDate today = LocalDate.now();

        Optional<Attendance> existing = attendanceRepository
                .findTopByEmployee_IdAndAttendancedateOrderByAttendanceIdDesc(employee.getId(), today);

        if (existing.isPresent()) {
            Attendance att = existing.get();
            if (att.getOutTime() == null) {
                throw new RuntimeException("Already checked in today at " + att.getInTime());
            } else {
                throw new RuntimeException("Attendance already completed for today");
            }
        }

        Attendance attendance = new Attendance();
        attendance.setEmployee(employee);
        attendance.setAttendancedate(today);
        attendance.setInTime(LocalDateTime.now());
        attendance.setStatus("Checked in");
        return attendanceRepository.save(attendance);
    }

    public Attendance checkOut(Long empId) {
        Employee employee = resolveEmployee(empId);
        LocalDate today = LocalDate.now();

        Optional<Attendance> existing = attendanceRepository
                .findTopByEmployee_IdAndAttendancedateOrderByAttendanceIdDesc(employee.getId(), today);

        if (existing.isEmpty()) {
            throw new RuntimeException("No check-in record found for today. Please check in first.");
        }

        Attendance attendance = existing.get();
        if (attendance.getOutTime() != null) {
            throw new RuntimeException("Already checked out today at " + attendance.getOutTime());
        }

        attendance.setOutTime(LocalDateTime.now());
        attendance.setStatus("Completed");
        return attendanceRepository.save(attendance);
    }

    public Attendance getTodayAttendance(Long empId) {
        Employee employee = resolveEmployee(empId);
        LocalDate today = LocalDate.now();
        return attendanceRepository
                .findTopByEmployee_IdAndAttendancedateOrderByAttendanceIdDesc(employee.getId(), today)
                .orElse(null);
    }

    public List<Attendance> getAttendanceHistory(Long empId) {
        Employee employee = resolveEmployee(empId);
        return attendanceRepository.findByEmployee_IdOrderByAttendanceIdDesc(employee.getId());
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }
}
