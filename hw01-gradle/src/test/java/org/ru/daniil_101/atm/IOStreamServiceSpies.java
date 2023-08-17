package org.ru.daniil_101.atm;

public class IOStreamServiceSpies implements IOService{
    private String resultOfChecking = "";
    @Override
    public void writeDown(String text) {
        resultOfChecking = text;
    }

    public String getResultOfChecking() {
        return resultOfChecking;
    }
}
