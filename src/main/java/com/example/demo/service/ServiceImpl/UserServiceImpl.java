package com.example.demo.service.ServiceImpl;

import com.example.demo.exceptions.InvalidUsernameOrPasswordException;
import com.example.demo.exceptions.PasswordsDoNotMatchException;
import com.example.demo.exceptions.UsernameAlreadyExistsException;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) {
        return userRepository.findByUsername(s)
                .orElseThrow(()->new UsernameNotFoundException(s));
    }


//    @Override
//    public User register(Integer user_id, String user_username, String user_password, String user_repeatedPassword,
//                         String user_phone_number, String user_email, String user_name, String user_surname, Role user_role)
//    {
//        User user = new User(user_id,user_username,user_password,user_repeatedPassword,user_phone_number,user_email,user_name,user_surname,user_role);
//        return userRepository.save(user);
//
//    }

    @Override
    public User register(Integer user_id, String user_username, String user_password, String user_repeatedPassword,
                         String user_phone_number, String user_email, String user_name, String user_surname, Role user_role)
    {
        if (user_username==null || user_username.isEmpty()  || user_password==null || user_password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!user_password.equals(user_repeatedPassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(user_username).isPresent())
            throw new UsernameAlreadyExistsException(user_username);
        User user = new User(user_username,passwordEncoder.encode(user_password),user_phone_number,user_email,user_name,user_surname,user_role);
          return userRepository.save(user);
    }

}
