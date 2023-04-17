package RestuarantApp.Restuarant.controller;

import RestuarantApp.Restuarant.Service.UserService;
import RestuarantApp.Restuarant.Service.UserServiceImpl;
import RestuarantApp.Restuarant.dto.UserDto;
import RestuarantApp.Restuarant.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class AuthController {
    @Autowired
    private UserService userService;
    @PostMapping("/register/save")
    public ResponseEntity<String> registration(@RequestBody UserDto userDto){
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            return new ResponseEntity<>("Email id already  exist", HttpStatus.BAD_GATEWAY);
        }



        userService.saveUser(userDto);
        return new ResponseEntity<>("User added Successfully",HttpStatus.CREATED);

    }

    // handler method to handle list of users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.findAllUsers();

        return new ResponseEntity<>(users,HttpStatus.FOUND);
    }
}
