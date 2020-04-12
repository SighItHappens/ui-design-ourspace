package com.project.ourspace.ui.login;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private String displayName;
    private String userEmail;

    LoggedInUserView(String displayName, String userEmail) {
        this.displayName = displayName;
        this.userEmail = userEmail;
    }

    String getDisplayName() {
        return displayName;
    }

    String getUserEmail() { return userEmail; }
}
