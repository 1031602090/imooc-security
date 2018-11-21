package com.imooc.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.exception.UserNotExistException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hang
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping()
    public List<User> query(@RequestParam(value = "username",defaultValue = "zhangsan") String username){
        List<User> list = new ArrayList<>();
        list.add(new User());
        list.add(new User());
        list.add(new User());
        return list;
    }
    @PostMapping()
    public User create(@RequestBody @Valid User user){
//        if(error.hasErrors()){
//            error.getAllErrors().forEach(m-> System.out.println(m.getDefaultMessage()));
//        }
        System.out.println(user);
        return new User(user.getUsername(),user.getPassword(),"1",user.getDate());
    }

    @PutMapping("/{id}")
    public User update(@RequestBody @Valid User user, BindingResult error, @PathVariable String id){
        if(error.hasErrors()){
            error.getAllErrors().forEach(m-> System.out.println(m.getDefaultMessage()));
        }
        System.out.println(user);
        return new User(user.getUsername(),user.getPassword(),"1",user.getDate());
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){
        System.out.println(id);
        return id;
    }
    @GetMapping("/myInfo/{id}")
    public User myInfo(@PathVariable String id){
        return new User("tom","123","1",new Date());
    }

    @GetMapping("/simple")
    @JsonView(User.SimpleView.class)
    public User simple(){
        return new User("tom","123456","1",new Date());
    }
    @GetMapping("/detail")
    @JsonView(User.DetailView.class)
    public User detail(){
        return new User("tom","123456","1",new Date());
    }
}
