package org.ru.daniil_101.atm;

import org.ru.daniil_101.atm.data.MoneyBox;
import org.ru.daniil_101.atm.service.MoneyBoxService;
import org.ru.daniil_101.atm.service.impl.MoneyBoxServiceImpl;

public class Main {
    public static void main(String[] args) {
        MoneyBox moneyBox = new MoneyBox(1,1,1,1,1,
                1,1,1);
        MoneyBoxService boxService = new MoneyBoxServiceImpl(moneyBox);
        System.out.println(boxService.requestABalance());

        boxService.putTheBalance(0,0,0,0,0,
                0,1,1);
        System.out.println(boxService.requestABalance());

        System.out.println(boxService.withDrawCash(7750));
    }
}