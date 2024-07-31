//package com.ood2.optionals.springboot_example;
//
//import java.util.Optional;
//
////@Service
//public class UserService {
//	
//	// @Autowired
//	private UserRepository userRepository;
//	
//	public boolean registerNewUser(User user) {
//		// Check if the user already exists:
//		Optional<User> returnedUser = userRepository.findByUsername(user.getUsername());
//		
//		// If not, then save to the DB, otherwise fail
//		if (returnedUser.isEmpty()) {
//			userRepository.save(user);
//			return true;
//		} else {
//			return false;
//		}
//	}
//}
