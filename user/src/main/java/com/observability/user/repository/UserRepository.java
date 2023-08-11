package com.observability.user.repository;

import com.observability.user.model.*;
import org.springframework.data.jpa.repository.*;

/**
 * @author Krishna Chaitanya
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
