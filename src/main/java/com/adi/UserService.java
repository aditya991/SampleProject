package com.adi;

public interface UserService
{
    public User findUser(String email);
    public void insertUser( String name, String email);
    public void RemoveUser(User u);
    public boolean findUserExistence(String email);
//    public void deleteTok(String email);
//    public void validateTok(String email, int tok);
}
