package org.monedu.service;

import org.monedu.model.User;

public interface UserService
{

    boolean authenticate(String email, String password);

    User findByEmail(String email);

}
