package ru.grand.lesson4;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {
    private String login;
    private String password;

    public void createQuery()
    {
        var q = new Query();
        q.printToLog();
    }
    public class Query
    {
        public void printToLog()
        {
            System.out.format("User %s with password %s has logged in.\n", login, password);
        }
    }
}
