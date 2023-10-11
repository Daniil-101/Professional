package org.ru.daniil_101.atm.service;

public interface MoneyBoxService {
    void putTheBalance(int denomination10, int denomination50, int denomination100,
                       int denomination200, int denomination500, int denomination1000,
                       int denomination2000, int denomination5000);

    String withDrawCash(int sum);

    int requestABalance();
}
