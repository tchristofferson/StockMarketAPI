package com.tchristofferson.stocks.api;

import com.tchristofferson.stocks.api.core.IStockData;
import com.tchristofferson.stocks.api.core.IStockStorage;

import java.util.concurrent.Future;

public class StockMarketAPI {

    private static StocksPlugin implementation = null;

    private StockMarketAPI(){
    }

    public static void setImplementation(StocksPlugin implementation) {
        if (StockMarketAPI.implementation != null)
            throw new IllegalStateException("Implementation already set!");
        StockMarketAPI.implementation = implementation;
    }

    public static IStockStorage getStockStorage() {
        return implementation.getStockStorage();
    }

    public static Future<IStockData> getStockData(String symbol) {
        return implementation.getStockData(symbol);
    }

    public static Future<IStockData[]> getStockData(String... symbols) {
        return implementation.getStockData(symbols);
    }
}
