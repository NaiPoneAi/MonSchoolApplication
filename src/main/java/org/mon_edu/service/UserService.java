package org.mon_edu.service;

import org.mon_edu.model.User;

public interface UserService
{

    boolean authenticate(String email, String password);

    User findByEmail(String email);

}
