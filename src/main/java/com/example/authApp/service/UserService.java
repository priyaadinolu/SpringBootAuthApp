package com.example.authApp.service;

import com.example.authApp.entity.User;
import com.example.authApp.repository.UserRepository;
import com.example.authApp.util.RegistrationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<RegistrationMessage> register(User user){
        RegistrationMessage msg = new RegistrationMessage();
        User userRegistered= repository.save(user);
        if(userRegistered!= null){
            msg.setMsg("Registration success");
            msg.setStatus("success");
        }
        else {
            msg.setMsg("Registration failed");
            msg.setStatus("failed");
        }
        return List.of(msg);
    }
   /* public List<User> update(User user){
        //JSONObject jsonObject= new JSONObject();
        User existing= repository.findAllById(user.getId());
        if (existing == null) {
            jsonObject.put("status","failed");
            jsonObject.put("message","user does not exists");
        } else {
            existing.setName(user.getName());
            existing.setEmail(user.getEmail());
            existing.setPassword(user.getPassword());
            User userRegistered= repository.save(existing);
            jsonObject.put("status","success");
            jsonObject.put("id",""+existing.getId());
            jsonObject.put("name",existing.getName());
            jsonObject.put("email",existing.getEmail());
            jsonObject.put("password",existing.getPassword());
        }


        return jsonObject.toJSONString();
    }

*/
    /*
    public String delete(User user){
        JSONObject jsonObject= new JSONObject();
        if(repository.findAllById(user.getId())==null) {
            jsonObject.put("status","failed");
            jsonObject.put("message","User not found");
        }else{
            repository.delete(user);
            jsonObject.put("status","success");
        }
        return jsonObject.toJSONString();
    }
*/
    public List<User> all_users(){
        List lst= repository.findAll();

        return lst;
    }
    public List login(User user){
        User existing = repository.findAllByEmail(user.getEmail());

        if (existing == null){
            RegistrationMessage message = new RegistrationMessage();
            message.setStatus("failed");
            message.setMsg("No user found");
            return List.of(message);
        }
        else{
            return List.of(existing);
        }
    }

}
