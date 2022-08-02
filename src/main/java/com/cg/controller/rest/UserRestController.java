package com.cg.controller.rest;

import com.cg.exception.DataInputException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.User;
import com.cg.model.dto.UserDTO;
import com.cg.service.jwt.JwtService;
import com.cg.service.role.IRoleService;
import com.cg.service.user.IUserService;
import com.cg.util.AppUtil;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private AppUtil appUtil;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private JwtService jwtService;


    @GetMapping
    public ResponseEntity<?> showListUser() {
        List<UserDTO> userDTOS = userService.findAllUserDTOByDeletedIsFailse();
        return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        Optional<UserDTO> userDTO = userService.findByUserId(id);
        if(userDTO.isPresent()){
            return new ResponseEntity<>(userDTO.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<?> doUpdate(@RequestBody UserDTO userDTO,BindingResult bindingResult){
            if(bindingResult.hasErrors()){
            return appUtil.mapErrorToResponse(bindingResult);
        }

        User user = userService.saveWithOutPassword(userDTO.toUser());
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }
}

