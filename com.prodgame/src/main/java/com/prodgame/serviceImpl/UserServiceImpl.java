package com.prodgame.serviceImpl;

import com.prodgame.constants.ProdgameConstants;
import com.prodgame.service.UserService;
import com.prodgame.utils.ProdgameUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside SignUp: {}", requestMap);
        if (validateSignUpMap(requestMap)) {

        } else {
            return ProdgameUtils.getResponseEntity(ProdgameConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    private boolean validateSignUpMap(Map<String, String> requestMap) {
        if (requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
            && requestMap.containsKey("email") && requestMap.containsKey("password")) {
            return true;
        }
        return false;
    }
}
