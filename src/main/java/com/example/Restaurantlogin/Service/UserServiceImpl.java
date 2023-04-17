package RestuarantApp.Restuarant.Service;

import RestuarantApp.Restuarant.dto.UserDto;
import RestuarantApp.Restuarant.entity.User;
import RestuarantApp.Restuarant.enums.Role;
import RestuarantApp.Restuarant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserDto userDto) {
       User user = new User();
       user.setFirstName(userDto.getFirstName());
       user.setLastName(userDto.getLastName());
       user.setEmail(userDto.getEmail());
       user.setPassword(passwordEncoder.encode(userDto.getPassword()));
       user.setRole(Role.USER);
       user.setGender(userDto.getGender());
       userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll().stream().toList();
        return users;
    }
}
