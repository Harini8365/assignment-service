package com.wastewise.assignmentservice.controller;

import com.wastewise.assignmentservice.dto.AssignmentDTO;
import com.wastewise.assignmentservice.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
@RequiredArgsConstructor
@Slf4j
public class AssignmentController {

    private final AssignmentService assignmentService;

    @PostMapping
    public ResponseEntity<AssignmentDTO> create(@RequestBody AssignmentDTO dto) {
        log.info("Creating new assignment");
        return ResponseEntity.status(HttpStatus.CREATED).body(assignmentService.createAssignment(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssignmentDTO> getById(@PathVariable String id) {
        log.info("Fetching assignment with ID: {}", id);
        return ResponseEntity.ok(assignmentService.getAssignmentById(id));
    }

    @GetMapping
    public ResponseEntity<List<AssignmentDTO>> getAll() {
        log.info("Fetching all assignments");
        return ResponseEntity.ok(assignmentService.getAllAssignments());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        log.info("Deleting assignment with ID: {}", id);
        assignmentService.deleteAssignment(id);
        return ResponseEntity.ok("Assignment deleted successfully.");
    }
    @PutMapping("/{id}")
    public ResponseEntity<AssignmentDTO> update(@PathVariable String id, @RequestBody AssignmentDTO dto) {
        log.info("Updating assignment with ID: {}", id);
        return ResponseEntity.ok(assignmentService.updateAssignment(id, dto));
    }
}

