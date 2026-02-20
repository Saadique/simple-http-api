package com.java.assesment.simplehttpapi.api;

import com.java.assesment.simplehttpapi.response.ApiResponse;
import com.java.assesment.simplehttpapi.response.GreetingResponse;
import com.java.assesment.simplehttpapi.response.InvalidInputResponse;
import com.java.assesment.simplehttpapi.service.NameRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private final NameRuleService nameRuleService;

    public GreetingController(NameRuleService nameRuleService) {
        this.nameRuleService = nameRuleService;
    }

    @GetMapping("/hello-world")
    public ResponseEntity<ApiResponse> getGreeting(@RequestParam(value = "name", required = false) String name) {

        if (!nameRuleService.isValidName(name)) {
            return ResponseEntity.badRequest().body(new InvalidInputResponse("Invalid Input"));
        }

        String greeting = nameRuleService.buildGreeting(name);

        return ResponseEntity.ok(new GreetingResponse(greeting));
    }
}