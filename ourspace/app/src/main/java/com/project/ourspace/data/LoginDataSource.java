package com.project.ourspace.data;

import com.project.ourspace.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {
        try {

            if ("admin".equalsIgnoreCase(username) && "admin".equals(password)) {
                LoggedInUser fakeUser =
                        new LoggedInUser(
                                java.util.UUID.randomUUID().toString(),
                                "Jane",
                                "jane.doe@umn.edu");
                return new Result.Success<>(fakeUser);
            } else {
                return new Result.Error(new IOException("Error logging in"));
            }
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
