package pl.portofilm.project.user;

import org.springframework.stereotype.Service;
import pl.portofilm.project.user.UserDto.UserCredentialsDto;
import pl.portofilm.project.user.UserDto.UserCredentialsDtoMapper;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

     public Optional<UserCredentialsDto> findCredentialsByEmail(String email) {
            return userRepository.findByEmail(email).map(UserCredentialsDtoMapper::map);

    }
}
