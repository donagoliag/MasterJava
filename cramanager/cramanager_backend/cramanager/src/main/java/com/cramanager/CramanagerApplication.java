package com.cramanager;

import com.cramanager.entity.User;
import com.cramanager.enumeration.Contrat;
import com.cramanager.enumeration.Seniorite;
import com.cramanager.enumeration.StatutContrat;
import com.cramanager.enumeration.UserRoles;
import com.cramanager.repository.UserRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class CramanagerApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CramanagerApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Optional<User> compteadmin = userRepository.findByRole(UserRoles.SYSADMIN);
		if (compteadmin.isEmpty()){
			User user = new User();

			user.setEmail("admin@gmail.com");
			user.setRole(UserRoles.SYSADMIN);
			user.setPrenom("admin");
			user.setNom("admin");
			user.setActive(true);
			user.setContrat(Contrat.CDI);
			user.setSeniorite(Seniorite.EXPERT);
			user.setStatut(StatutContrat.MISSION);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);
		}
	}
}
