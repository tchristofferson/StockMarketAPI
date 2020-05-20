package com.tchristofferson.stocks.api;

import com.tchristofferson.stocks.api.core.IStockData;
import com.tchristofferson.stocks.api.core.IStockStorage;

import java.util.List;
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

    /**
     * Get the stock storage where {@link com.tchristofferson.stocks.api.core.IPlayerStockData} is saved
     * @return The stock storage
     */
    public static IStockStorage getStockStorage() {
        return implementation.getStockStorage();
    }

    /**
     * Performs a web request and retrieves data for the specified symbol
     * @param symbol The symbol to retrieve data for
     * @return The stock data
     */
    public static Future<IStockData> getStockData(String symbol) {
        return implementation.getStockData(symbol);
    }

    /**
     * Performs a web request and retrieves data for the specified symbols
     * @param symbols The symbols to retrieve data for
     * @return The stock data
     */
    public static Future<IStockData[]> getStockData(String... symbols) {
        return implementation.getStockData(symbols);
    }

    /**
     * Performs a web request and retrieves data for the specified symbols
     * @param symbols The symbols to retrieve data for
     * @return The stock data
     */
    public static Future<IStockData[]> getStockData(List<String> symbols) {
        return implementation.getStockData(symbols);
    }

    /**
     * Gets the popular stocks' symbols
     * @return The popular stocks
     */
    public static String[] getPopularStocks() {
        return implementation.getPopularStocks();
    }

    /**
     * Get weather or not the stock market is open
     * @return {@code true} if the stock market is open or if the plugin is setup to always be open, {@code false} otherwise
     */
    public static boolean isStockMarketClosed() {
        return implementation.isStockMarketClosed();
    }

    /**
     * Get the cooldown specified in the config
     * @return The cooldown in minutes
     */
    public static int getCooldown() {
        return implementation.getCooldown();
    }

    /**
     * The tax rate, ex 0.05 = 5%
     * @return The tax rate
     */
    public static double getTax() {
        return implementation.getTax();
    }

    /**
     * Get the price multiplier for stock prices, ex. 0.5 = half priced
     * @return The price multiplier
     */
    public static double getPriceMultiplier() {
        return implementation.getPriceMultiplier();
    }

    /**
     * Check if the server allows this stock to be traded by checking the whitelist and blacklist
     * @param symbol The symbol to check
     * @return {@code true} if trading is allowed for the specified symbol, {@code false} otherwise
     */
    public static boolean isTradable(String symbol) {
        return implementation.isTradable(symbol);
    }
}
