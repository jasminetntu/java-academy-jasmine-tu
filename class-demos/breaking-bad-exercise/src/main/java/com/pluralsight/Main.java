package com.pluralsight;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Chemist> arrayList = new ArrayList<>();
        arrayList.add(new WalterWhite());
        arrayList.add(new JessePinkman());

        for (Chemist c : arrayList) {
            c.cook();
        }
    }
}
