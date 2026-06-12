package org.tk.lunarchat.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.tk.lunarchat.DTO.GenericMessage;
import org.tk.lunarchat.DTO.UserCreateParams;
import org.tk.lunarchat.Database.Config.UserRepo;
import org.tk.lunarchat.Database.Model.User;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserRepo userRepo;
    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    @ExceptionHandler()
    @GetMapping("/api/create")
    public GenericMessage createUser(@RequestParam UserCreateParams user){
        if(user.username() == null){
            return new GenericMessage("Invalid user parameters", HttpStatus.FORBIDDEN);
        }else {
            User tempUser = userRepo.findByUsername(user.username());
            if(tempUser == null){
                User createdUser = new User(user.username());
                userRepo.save(createdUser);
                return new GenericMessage("User is been added", HttpStatus.OK);
            }else {
                return new GenericMessage("Invalid user parameters", HttpStatus.FORBIDDEN);
            }
            
        }
    }
}
