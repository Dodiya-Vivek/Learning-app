package com.example.skillupnow;

public class Users {
    private String profilePic,mail,userName,password,userId;
    private String UserName;
    public Users() {
    }


    public Users(String userName , String mail, String password) {
        this.mail = mail;
        this.userName = userName;
        this.password = password;
    }

    public Users(String profilePic, String mail, String userName, String password, String userId) {
        this.profilePic = profilePic;
        this.mail = mail;
        this.userName = userName;
        this.password = password;
        this.userId = userId;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
