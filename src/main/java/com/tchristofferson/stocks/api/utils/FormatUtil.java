package com.tchristofferson.stocks.api.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FormatUtil {

    public static final RoundingMode ROUNDING_MODE = RoundingMode.DOWN;
    public static final int SHARES_DECIMALS = 3;
    public static final int MONEY_DECIMALS = 2;

    public static String formatSymbol(String symbol) {
        if (symbol == null || symbol.isEmpty())
            return "";

        return symbol.trim().toUpperCase();
    }

    public static double formatShares(double shares) {
        return format(shares, SHARES_DECIMALS);
    }

    public static double formatMoney(double amount) {
        return format(amount, MONEY_DECIMALS);
    }

    private static double format(double d, int scale) {
        return BigDecimal.valueOf(d).setScale(scale, ROUNDING_MODE).doubleValue();
    }

    public static double getMinSupportedMoney() {
        return Math.pow(10, MONEY_DECIMALS * -1);
    }

}
