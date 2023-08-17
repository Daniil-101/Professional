package org.ru.daniil_101.atm;

public class IOStreamService implements IOService{
    @Override
    public void writeDown(String text) {
        System.out.println(text);
    }
}
