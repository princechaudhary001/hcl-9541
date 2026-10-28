package org.example.hrmsdatabase.controller;

import org.example.hrmsdatabase.model.Attendance;
import org.example.hrmsdatabase.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/attendance")
@CrossOrigin(origins = "http://localhost:5173")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping({"/check-in/{empId}", "/checkin/{empId}"})
    public ResponseEntity<?> checkIn(@PathVariable Long empId) {
        try {
            Attendance attendance = attendanceService.checkIn(empId);
            return ResponseEntity.ok(attendance);
        } catch (Exception e) {
            Map<String, String> err = new HashMap<>();
            err.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(err);
        }
    }

    @PostMapping({"/check-out/{empId}", "/checkout/{empId}"})
    public ResponseEntity<?> checkOut(@PathVariable Long empId) {
        try {
            Attendance attendance = attendanceService.checkOut(empId);
            return ResponseEntity.ok(attendance);
        } catch (Exception e) {
            Map<String, String> err = new HashMap<>();
            err.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(err);
        }
    }

    @GetMapping("/today/{empId}")
    public ResponseEntity<?> getTodayAttendance(@PathVariable Long empId) {
        try {
            Attendance attendance = attendanceService.getTodayAttendance(empId);
            return ResponseEntity.ok(attendance);
        } catch (Exception e) {
            Map<String, String> err = new HashMap<>();
            err.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(err);
        }
    }

    @GetMapping("/history/{empId}")
    public ResponseEntity<?> getAttendanceHistory(@PathVariable Long empId) {
        try {
            List<Attendance> history = attendanceService.getAttendanceHistory(empId);
            return ResponseEntity.ok(history);
        } catch (Exception e) {
            Map<String, String> err = new HashMap<>();
            err.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(err);
        }
    }

    @GetMapping("/all")
    public List<Attendance> getAll() {
        return attendanceService.getAllAttendance();
    }
}
