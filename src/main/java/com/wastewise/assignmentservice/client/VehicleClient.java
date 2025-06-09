package com.wastewise.assignmentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "vehicle-service", url = "http://localhost:8081")
public interface VehicleClient {
    @GetMapping("/wastewise/admin/vehicle-assignments/{id}")
    Object getVehicleById(@PathVariable("id") String vehicleId);
}
