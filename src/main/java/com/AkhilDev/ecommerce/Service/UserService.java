package com.AkhilDev.ecommerce.Service;

import com.AkhilDev.ecommerce.Dto.SignUpDto;
import com.AkhilDev.ecommerce.Dto.User.SignUpResponse;
import com.AkhilDev.ecommerce.Entity.UserEntity;
import com.AkhilDev.ecommerce.Exceptions.CustomExceptions;
import com.AkhilDev.ecommerce.Repository.UserRepository;
import com.AkhilDev.ecommerce.enums.ResponseStatus;
import com.AkhilDev.ecommerce.enums.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.AkhilDev.ecommerce.Config.MessageStrings.USER_CREATED;


@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;
    public SignUpResponse signUp(SignUpDto signUpDto) {

        if(userRepository.findByEmail(signUpDto.getEmail())!=null) throw new CustomExceptions("already exists");
        log.error("already exists");



        UserEntity userEntity = new UserEntity(signUpDto.getFirstName(), signUpDto.getLastName(), signUpDto.getEmail(), signUpDto.getPassword(),signUpDto.getPhone(), Role.user);

        userRepository.save(userEntity);
        log.info(userEntity+"values");
        return new SignUpResponse(ResponseStatus.success.toString(), USER_CREATED);


    }
}
