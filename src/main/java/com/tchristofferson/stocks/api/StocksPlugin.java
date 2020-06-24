package com.tchristofferson.stocks.api;

import com.tchristofferson.stocks.api.core.IStockData;
import com.tchristofferson.stocks.api.core.IStockStorage;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

public interface StocksPlugin extends Plugin {

    IStockStorage getStockStorage();

    Future<IStockData> getStockData(String symbol);

    Future<IStockData[]> getStockData(List<String> symbols);

    default Future<IStockData[]> getStockData(String... symbols) {
        return getStockData(Arrays.asList(symbols));
    }

    String[] getPopularStocks();

    boolean isStockMarketClosed();

    boolean isCooldownsEnabled();

    //Minutes
    int getCooldown();

    double getTax();

    double getPriceMultiplier();

    boolean isTradable(String symbol);

    double getMaxTradeAmount();
}
