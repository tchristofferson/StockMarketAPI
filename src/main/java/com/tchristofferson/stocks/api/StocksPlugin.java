package com.tchristofferson.stocks.api;

import com.tchristofferson.stocks.api.core.IStock;
import com.tchristofferson.stocks.api.core.IStockData;
import com.tchristofferson.stocks.api.core.IStockDataRequester;
import com.tchristofferson.stocks.api.core.IStockStorage;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

public interface StocksPlugin extends Plugin {

    IStockStorage getStockStorage();

    Future<IStockData> getStockData(String symbol);

    Future<IStockData> getStockData(String symbol, boolean requireLive);

    Future<IStockData[]> getStockData(List<String> symbols);

    Future<IStockData[]> getStockData(List<String> symbols, boolean requireLive);

    default Future<IStockData[]> getStockData(String... symbols) {
        return getStockData(Arrays.asList(symbols));
    }

    default Future<IStockData[]> getStockData(boolean requireLive, String... symbols) {
        return getStockData(Arrays.asList(symbols), requireLive);
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
