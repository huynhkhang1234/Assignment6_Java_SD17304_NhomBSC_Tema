//package com.poly.service;
//
//import java.util.Optional;
//
//import org.mindrot.jbcrypt.BCrypt;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.poly.DAO.UsersDAO;
//import com.poly.Entities.Users;
//
//@Service
//public class UserService {
//	@Autowired
//    private UsersDAO userRepository;
//
//    public boolean authenticate(String email, String password) {
//        Optional<Users> user = userRepository.findByUsername(email);
//        if (!user.isPresent()) {
//            return false;
//        }
//        return BCrypt.checkpw(password, "123");
//    }
//}
