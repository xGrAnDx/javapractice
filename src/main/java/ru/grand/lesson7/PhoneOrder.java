package ru.grand.lesson7;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PhoneOrder {
    public String lastName;
    public String phone;

    @Override
    public String toString()
    {
        return String.format("Фамилия: [%s] Телефон:[%s]", lastName, phone);
    }
}
