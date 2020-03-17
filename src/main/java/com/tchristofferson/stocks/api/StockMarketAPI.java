package com.tchristofferson.stocks.api;

import com.tchristofferson.stocks.api.core.IStockStorage;

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

}
