package com.springnetflix.authentication.api;

import com.springnetflix.authentication.api.entities.Permission;
import com.springnetflix.authentication.api.entities.User;
import com.springnetflix.authentication.api.repositories.PermissionRepository;
import com.springnetflix.authentication.api.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

//  Inital user with "Admin" permission (mock admin)
	@Bean
	CommandLineRunner init(UserRepository userRepository, PermissionRepository permissionRepository,
						   BCryptPasswordEncoder passwordEncoder) {
		return args -> {
			init(userRepository, permissionRepository, passwordEncoder);
		};
	}

	private void initUsers(UserRepository userRepository, PermissionRepository permissionRepository,
						   BCryptPasswordEncoder passwordEncoder) {
		Permission permission = null;
		Permission findPermission = permissionRepository.findByDescription("Admin");

		if(findPermission != null) {
			permission = new Permission();
			permission.setDescription("Admin");
			permission = permissionRepository.save(permission);
		} else {
			permission = findPermission;
		}

		User admin = new User();
		admin.setUserName("guilhermebeneti");
		admin.setAccountNonExpired(true);
		admin.setAccountNonLocker(true);
		admin.setCredentialsNonExpired(true);
		admin.setEnabled(true);
		admin.setPassword(passwordEncoder.encode("12345678"));
		admin.setPermissions(Arrays.asList(permission));

		User find = userRepository.findByUserName("guilhermebeneti");

		if(find != null) {
			userRepository.save(admin);
		}
	}

}
