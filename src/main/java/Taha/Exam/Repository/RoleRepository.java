package Taha.Exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Taha.Exam.Entity.Role;

public interface RoleRepository extends JpaRepository<Role,String>{
	default Role findOne(String id) { 
        return (Role) findById(id).orElse(null); 
    } 

}
