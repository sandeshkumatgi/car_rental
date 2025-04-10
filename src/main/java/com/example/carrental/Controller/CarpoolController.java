package com.example.carrental.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.carrental.model.Carpool;
import com.example.carrental.Service.CarpoolService;
import java.util.List;

@RestController
@RequestMapping("/carpools")
public class CarpoolController {
    @Autowired
    private CarpoolService carpoolService;

    @PostMapping("/create")
    public Carpool createCarpool(@RequestBody Carpool carpool) {
        return carpoolService.createCarpool(carpool);
    }

    @GetMapping("/all")
    public List<Carpool> getAllCarpools() {
        return carpoolService.getAllCarpools();
    }

    @GetMapping("/active")
    public List<Carpool> getActiveCarpools() {
        return carpoolService.getActiveCarpools();
    }

    @GetMapping("/created/{userId}")
    public List<Carpool> getUserCreatedCarpools(@PathVariable String userId) {
        return carpoolService.getUserCreatedCarpools(userId);
    }

    @GetMapping("/joined/{userId}")
    public List<Carpool> getUserJoinedCarpools(@PathVariable String userId) {
        return carpoolService.getUserJoinedCarpools(userId);
    }

    @PostMapping("/{carpoolId}/join/{userId}")
    public Carpool joinCarpool(@PathVariable String carpoolId, @PathVariable String userId) {
        return carpoolService.joinCarpool(carpoolId, userId);
    }

    @PostMapping("/{carpoolId}/leave/{userId}")
    public Carpool leaveCarpool(@PathVariable String carpoolId, @PathVariable String userId) {
        return carpoolService.leaveCarpool(carpoolId, userId);
    }

    @PutMapping("/{carpoolId}/status")
    public Carpool updateCarpoolStatus(@PathVariable String carpoolId, @RequestParam String status) {
        return carpoolService.updateCarpoolStatus(carpoolId, status);
    }
}