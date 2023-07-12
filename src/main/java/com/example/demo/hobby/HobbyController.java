package com.example.demo.hobby;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hobbies")
@RequiredArgsConstructor
public class HobbyController {
    private final HobbyService service;

    @PostMapping
    public void save(@RequestBody HobbyRequest request) {
        service.save(request);
    }

    @PostMapping("/connect")
    public void connect(@RequestBody ConnectRequest request) {
        service.createMemberHobby(request.getMemberId(), request.getHobbyId());
    }

    @GetMapping
    public ResponseEntity<List<HobbyResponse>> findMemberContainsHobby(@RequestParam String name) {
        List<HobbyResponse> result = service.findMemberContainsHobby(name);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping
    public List<HobbyResponse> getHobbyList(@RequestParam(value="name", required = false, defaultValue ="")String name)
    {
        System.out.println(name);
        return service.findByLikeName(name);
    }

}
