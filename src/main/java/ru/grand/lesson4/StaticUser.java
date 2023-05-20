package ru.grand.lesson4;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StaticUser {
    private String login;
    private String password;

    static class Query{
        static void printToLog(String login, String password)
        {
            System.out.format("User %s with password %s has logged in.\n", login, password);
        }
    }

    public void createQuery() {
        StaticUser.Query.printToLog(this.login, this.password);
    }
}
