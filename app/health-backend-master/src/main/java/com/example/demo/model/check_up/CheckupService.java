package com.example.demo.model.check_up;

import com.example.demo.model.user.User;
import com.example.demo.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckupService {
    @Autowired
    private CheckupRepository checkupRepository;

    public Checkup save(Checkup checkup){
        return checkupRepository.save(checkup);
    }
    public List<Checkup> getAllUCheckups(){
        List<Checkup> checkups=new ArrayList<>();
        Streamable.of(checkupRepository.findAll()).
                forEach(checkups::add);


        return checkups;
    }

}
