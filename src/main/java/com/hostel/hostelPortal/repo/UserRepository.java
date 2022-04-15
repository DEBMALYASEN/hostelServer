package com.hostel.hostelPortal.repo;

import com.hostel.hostelPortal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{
    //Long data type is related to id of User class

    User findByUserName(String username);
}
