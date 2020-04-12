package com.project.ourspace.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String userId;
    private String displayName;
    private String userEmail;

    public LoggedInUser(String userId, String displayName, String userEmail) {
        this.userId = userId;
        this.displayName = displayName;
        this.userEmail = userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getUserEmail() { return userEmail; }
}