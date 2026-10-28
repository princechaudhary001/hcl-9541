package org.example.hrmsdatabase.service;

import org.example.hrmsdatabase.model.Attendance;
import org.example.hrmsdatabase.repository.AttendanceRepository;
import org.example.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service


public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    public String markAttendance(Attendance attendance) {
        long id = attendance.getEmployee().getId();
        if (employeeRepository.existsById(id)) {
            attendanceRepository.save(attendance);
        }
        return "";
    }

}
