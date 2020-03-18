package com.tchristofferson.stocks.api;

import com.tchristofferson.stocks.api.core.IStockStorage;
import pl.zankowski.iextrading4j.api.stocks.Quote;

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

    public static Future<Quote> getStockPrice(String symbol) {
        return implementation.getStockPrice(symbol);
    }

}
