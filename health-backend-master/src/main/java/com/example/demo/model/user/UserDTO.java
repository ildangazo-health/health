package com.example.demo.model.user;

import com.example.demo.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {
    private String id; // 이게 id
    private String password;
    private String email;
    private String name;
    private String loginMessage;

    public String getLoginMessage() {
        return loginMessage;
    }
    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }

    public static UserDTO toUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        return userDTO;
    }
}
