package com.tchristofferson.stocks.api.core;

import java.util.Map;

public interface IStockDataRequester {

    /**
     * <b>Method will perform blocking web request!</b><br>
     * Get stocks' data
     * @return An array of stock data
     */
    IStockData[] requestStockData();

    /**
     * <b>Method will perform a blocking web request!</b><br>
     * Get stocks' data
     * @param requireLive If {@code false}, the data returned will be from the cache if it exists, otherwise it will fetch from the internet
     * @return An array of stock data
     */
    IStockData[] requestStockData(boolean requireLive);

    /**
     * <b>Method will perform a blocking web request!</b><br>
     * Get stocks' data
     * @param requireLive If {@code false}, the data returned will be from the cache if it exists, otherwise it will fetch from the internet
     * @return A map of stock data where the key is the symbol
     */
    Map<String, IStockData> requestStockDataMap(boolean requireLive);

    /**
     * <b>Method will perform blocking web request!</b><br>
     * Get stocks' split data
     * @return An array of stock data
     */
    IStockData[] requestStockSplits();

    /**
     * <b>Method will perform blocking web request!</b><br>
     * Get stocks' split data
     * @return A map of stock data where the key is the symbol
     */
    Map<String, IStockData> requestStockSplitsMap();

    /**
     * <b>Method will perform blocking web request!</b><br>
     * Get stocks' data with split data
     * @return An array of stock data
     */
    IStockData[] requestStockDataAndSplits();

    /**
     * <b>Method will perform blocking web request!</b><br>
     * Get stocks' data with split data
     * @return A map of stock data where the key is the symbol
     */
    Map<String, IStockData> requestStockDataAndSplitsMap();

}
