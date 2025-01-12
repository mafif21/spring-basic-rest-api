package muhammadafif.restapi.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import muhammadafif.restapi.model.dao.User;
import muhammadafif.restapi.model.dto.RegisterUserRequest;
import muhammadafif.restapi.repository.UserRepository;
import muhammadafif.restapi.security.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

    @Transactional
    public void Register(RegisterUserRequest request){
        Set<ConstraintViolation<RegisterUserRequest>> validate = validator.validate(request);
        if(!validate.isEmpty()){
            throw new ConstraintViolationException(validate);
        }

        if(userRepository.existsById(request.getUsername())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setName(request.getName());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        userRepository.save(user);
    }
}
