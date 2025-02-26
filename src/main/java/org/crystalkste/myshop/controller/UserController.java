package org.crystalkste.myshop.controller;


import org.crystalkste.myshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userApi")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/payment")
    public ResponseEntity<String> transferMoney(@RequestParam Long fromUserId, @RequestParam Long toUserId, @RequestParam Double amount) {
        userService.transForMoney(fromUserId, toUserId, amount);
        return ResponseEntity.ok("Transfer successful");
    }
}
