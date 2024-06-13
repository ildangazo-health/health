package com.example.demo.controller;

import com.example.demo.model.user.User;
import com.example.demo.model.user.UserDTO;
import com.example.demo.model.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/get-all") // 나중에 android에서 요청할 때
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    // android에서 새로운 정보를 입력받는다면
    @PostMapping("/user/save")
    public User save(@RequestBody User user){ // @RequestBody로 data 받아옴
        return userService.save(user);
    }

    @PostMapping ("/user/login")
    public UserDTO login(@RequestBody UserDTO userDTO, HttpSession session){
        UserDTO loginResult = userService.login(userDTO);
        if(loginResult!=null){
            //login 성공
            session.setAttribute("loginName", loginResult.getId());
            loginResult.setLoginMessage("Login successful");
            return loginResult;

        }
        else {
            //login 실패
            UserDTO failedResult = new UserDTO();
            failedResult.setLoginMessage("Login failed: Invalid username or password");
            return failedResult;
        }
    }
}
