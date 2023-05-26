package org.example;

public class IOStreamService implements IOService{
    @Override
    public void writeDown(String text) {
        System.out.println(text);
    }
}
