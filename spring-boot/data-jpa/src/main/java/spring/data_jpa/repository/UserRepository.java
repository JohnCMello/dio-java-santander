package spring.data_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.data_jpa.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Integer> {

}
