package org.ru.daniil_101.atm.data;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class MoneyBox {
    private int denomination10;
    private int denomination50;
    private int denomination100;
    private int denomination200;
    private int denomination500;
    private int denomination1000;
    private int denomination2000;
    private int denomination5000;
    private HashMap<Integer, Integer> banknotes = new HashMap<>();

    public MoneyBox(int denomination10, int denomination50, int denomination100, int denomination200,
                    int denomination500, int denomination1000, int denomination2000, int denomination5000) {
        banknotes.put(10, this.denomination10 = denomination10);
        banknotes.put(50, this.denomination50 = denomination50);
        banknotes.put(100, this.denomination100 = denomination100);
        banknotes.put(200, this.denomination200 = denomination200);
        banknotes.put(500, this.denomination500 = denomination500);
        banknotes.put(1000, this.denomination1000 = denomination1000);
        banknotes.put(2000, this.denomination2000 = denomination2000);
        banknotes.put(5000, this.denomination5000 = denomination5000);
    }
}
