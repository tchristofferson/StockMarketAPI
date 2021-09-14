package com.tchristofferson.stocks.api;

import com.tchristofferson.stocks.api.core.IStockData;
import com.tchristofferson.stocks.api.core.IStockDataRequester;
import com.tchristofferson.stocks.api.core.IStockStorage;

import java.util.Arrays;
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
     * Potentially performs a web request and retrieves data for the specified symbol
     * @param symbol The symbol to retrieve data for
     * @return The stock data
     */
    public static Future<IStockData> getStockData(String symbol) {
        return implementation.getStockData(symbol);
    }

    /**
     * Potentially performs a web request and retrieves data for the specified symbol
     * @param symbol The symbol to retrieve data for
     * @param requireLive If {@code false}, the data will be retrieved from cache if it exists, otherwise it will be fetched over internet
     * @return The stock data
     */
    public static Future<IStockData> getStockData(String symbol, boolean requireLive) {
        return implementation.getStockData(symbol, requireLive);
    }

    /**
     * Potentially performs a web request and retrieves data for the specified symbols
     * @param symbols The symbols to retrieve data for
     * @return The stock data
     */
    public static Future<IStockData[]> getStockData(String... symbols) {
        return implementation.getStockData(symbols);
    }

    /**
     * Potentially performs a web request and retrieves data for the specified symbols
     * @param requireLive If {@code false}, the data will be retrieved from cache if it exists, otherwise it will be fetched over internet
     * @param symbols The symbols to retrieve data for
     * @return The stock data
     */
    public static Future<IStockData[]> getStockData(boolean requireLive, String... symbols) {
        return implementation.getStockData(requireLive, symbols);
    }

    /**
     * Potentially performs a web request and retrieves data for the specified symbols
     * @param symbols The symbols to retrieve data for
     * @return The stock data
     */
    public static Future<IStockData[]> getStockData(List<String> symbols) {
        return implementation.getStockData(symbols);
    }

    /**
     * Get a stock data requester to retrieve stock data
     * @param symbols The stock symbols you will be retrieving data for
     * @return An IStockDataRequester with the specified stock symbols
     */
    public IStockDataRequester getRequester(String... symbols) {
        return implementation.getRequester(Arrays.asList(symbols));
    }

    /**
     * Get a stock data requester to retrieve stock data
     * @param symbols The stock symbols you will be retrieving data for
     * @return An IStockDataRequester with the specified stock symbols
     */
    public IStockDataRequester getRequester(List<String> symbols) {
        return implementation.getRequester(symbols);
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
     * Gets weather or not cooldowns are enabled
     * @return {@code true} if cooldowns are enabled, {@code false} otherwise
     */
    public static boolean isCooldownsEnabled() {
        return implementation.isCooldownsEnabled();
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

    /**
     * Gte the max amount of money allowed in a transaction
     * @return The max amount of money
     */
    public static double getMaxTradeAmount() {
        return implementation.getMaxTradeAmount();
    }
}
