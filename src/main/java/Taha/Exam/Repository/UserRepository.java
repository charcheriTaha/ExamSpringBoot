package Taha.Exam.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import Taha.Exam.Entity.User;

public interface UserRepository extends JpaRepository<User,String>{
	default User findOne(String id) { 
        return (User) findById(id).orElse(null); 
    } 

}
