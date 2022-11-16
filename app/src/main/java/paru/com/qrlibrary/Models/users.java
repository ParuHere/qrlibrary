package paru.com.qrlibrary.Models;

public class users {
    String UserID,Username,ProfilePic,Email;

    public users(String userid,String username,String profilepic,String email){
        UserID = userid;
        Username = username;
        Email = email;
        ProfilePic = profilepic;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getProfilePic() {
        return ProfilePic;
    }

    public void setProfilePic(String profilePic) {
        ProfilePic = profilePic;
    }
    public users(){}
}
