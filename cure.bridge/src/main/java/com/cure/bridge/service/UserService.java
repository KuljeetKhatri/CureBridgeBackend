package com.cure.bridge.service;

import com.cure.bridge.entity.Role;
import com.cure.bridge.entity.User;
import com.cure.bridge.repo.UserRepo;
import com.cure.bridge.response.Response;
import com.cure.bridge.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public Response getAllUsers(){
        Response response = new Response();
        try{
            List<User> userlist = userRepo.findAllByRoleIn(List.of(Role.DOCTOR, Role.PATIENT));
            if(userlist.isEmpty()){
                response.setResponseCode(Constants.DATA_NOT_FOUND_CODE);
                response.setResponseMessage(Constants.DATA_NOT_FOUND_MESSAGE);
            }else{
                response.setResponseCode(Constants.SUCCESS_CODE);
                response.setResponseMessage(Constants.SUCCESS_MESSAGE);
                Map<String,List> map = new HashMap<>();
                map.put("users",userlist);
                response.setData(map);
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

        return response;
    }


}
