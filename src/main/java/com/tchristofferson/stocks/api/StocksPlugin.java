package com.tchristofferson.stocks.api;

import com.tchristofferson.stocks.api.core.IStockData;
import com.tchristofferson.stocks.api.core.IStockDataRequester;
import com.tchristofferson.stocks.api.core.IStockStorage;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

public interface StocksPlugin extends Plugin {

    IStockStorage getStockStorage();

    @Deprecated
    Future<IStockData> getStockData(String symbol);

    @Deprecated
    Future<IStockData[]> getStockData(List<String> symbols);

    @Deprecated
    default Future<IStockData[]> getStockData(String... symbols) {
        return getStockData(Arrays.asList(symbols));
    }

    IStockDataRequester getRequester(List<String> symbols);

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
