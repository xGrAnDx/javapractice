package ru.grand.lesson4;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LocalUser {
    private String login;
    private String password;

    public void createQuery()
    {
        class Query
        {
            void printToLog()
            {
                System.out.format("User %s with password %s has logged in.\n", login, password);
            }
        }

        var q = new Query();
        q.printToLog();
    }
}
