package RestuarantApp.Restuarant.Service;

import RestuarantApp.Restuarant.dto.UserDto;
import RestuarantApp.Restuarant.entity.User;
import java.util.List;
public interface UserService {
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<User> findAllUsers();

}
