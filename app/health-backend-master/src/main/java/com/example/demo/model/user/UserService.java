package com.example.demo.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService { // auto-writing / Data Access Object
    @Autowired
    private UserRepository repository;


    public User save(User user){


        return repository.save(user); // repository 함수가 다 자동으로 해줌
    }

    public List<User> getAllUsers(){
        List<User> users=new ArrayList<>();
        Streamable.of(repository.findAll()).
                forEach(users::add);


        return users;
    }
    public UserDTO login(UserDTO userDTO) {
        /*
            1. 회원이 입력한 이메일로 DB에서 조회를 함
            2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
         */
        Optional<User> byUserId = repository.findById(userDTO.getId());
        if(byUserId.isPresent()){
            //조회 결과가 있다(해당 이메일을 가진 회원 정보가 있다)
            User user = byUserId.get();
            if(user.getPassword().equals(userDTO.getPassword())){
                //비밀번호 일치
                //entity -> dto변환 후 리턴
                UserDTO dto = UserDTO.toUserDTO(user);
                return dto;
            }
            else{
                return null;
            }

        }
        else{
            //조회 결과가 없다(해당 이메일을 가진 회원이 없다
            return null;
        }
    }



    public void delete(User user){
        repository.delete(user);
    }

    public void deleyeByid(String id){
        repository.deleteById(id);
    }

}
