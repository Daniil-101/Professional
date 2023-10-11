package org.ru.daniil_101.atm.service.impl;

import org.ru.daniil_101.atm.data.MoneyBox;
import org.ru.daniil_101.atm.service.MoneyBoxService;

import java.util.ArrayList;
import java.util.Arrays;

public class MoneyBoxServiceImpl implements MoneyBoxService {
    private final MoneyBox moneyBox;
    final int[] denominationsOfBanknotes = {10, 50, 100, 200, 500, 1000, 2000, 5000};

    public MoneyBoxServiceImpl(MoneyBox moneyBox) {
        this.moneyBox = moneyBox;
    }

    @Override
    public void putTheBalance(int denomination10, int denomination50, int denomination100,
                              int denomination200, int denomination500, int denomination1000,
                              int denomination2000, int denomination5000) {
        moneyBox.getBanknotes().put(10, moneyBox.getDenomination10() + denomination10);
        moneyBox.getBanknotes().put(50, moneyBox.getDenomination50() + denomination50);
        moneyBox.getBanknotes().put(100, moneyBox.getDenomination100() + denomination100);
        moneyBox.getBanknotes().put(200, moneyBox.getDenomination200() + denomination200);
        moneyBox.getBanknotes().put(500, moneyBox.getDenomination500() + denomination500);
        moneyBox.getBanknotes().put(1000, moneyBox.getDenomination1000() + denomination1000);
        moneyBox.getBanknotes().put(2000, moneyBox.getDenomination2000() + denomination2000);
        moneyBox.getBanknotes().put(5000, moneyBox.getDenomination5000() + denomination5000);
    }

    @Override
    public String withDrawCash(int sum) {
        ArrayList<Integer> cells = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0));
        int charged, required, counter = denominationsOfBanknotes.length - 1;
        String result = "";
        try {
            while (sum > 0) {
                if (sum > requestABalance() || counter < 0) throw new RuntimeException("Not enough money in the ATM");
                if (sum % 10 != 0) throw new IllegalStateException("Can't charge the required sum");
                if (sum >= denominationsOfBanknotes[counter]) {
                    required = sum / denominationsOfBanknotes[counter];
                    if (required <= moneyBox.getBanknotes().get(denominationsOfBanknotes[counter])) {
                        charged = required;
                    } else {
                        charged = moneyBox.getBanknotes().get(denominationsOfBanknotes[counter]);
                    }
                    sum -= charged * denominationsOfBanknotes[counter];
                    moneyBox.getBanknotes()
                            .put(denominationsOfBanknotes[counter],
                                    moneyBox.getBanknotes().get(denominationsOfBanknotes[counter]) - charged);
                } else {
                    counter--;
                    continue;
                }
                cells.set(counter, charged);
                counter--;
            }
            result += getTheNumberOfBanknotesOfEachDenomination(cells);
        } catch (Exception e) {
            result += e.getMessage();
        }
        return result;
    }

    @Override
    public int requestABalance() {
        int result = 0;
        for (int i = denominationsOfBanknotes.length - 1; i >= 0; i--) {
            int banknoteDenomination = denominationsOfBanknotes[i];
            result += moneyBox.getBanknotes().get(banknoteDenomination) * banknoteDenomination;
        }
        return result;
    }

    private String getTheNumberOfBanknotesOfEachDenomination(ArrayList<Integer> cells) {
        StringBuilder result = new StringBuilder("Cash issued: ");
        for (int i = denominationsOfBanknotes.length - 1; i >= 0; i--) {
            if (cells.get(i) != 0) {
                result.append(denominationsOfBanknotes[i]).append(" - ").append(cells.get(i)).append("\n");
            }
        }
        return result.toString();
    }
}
