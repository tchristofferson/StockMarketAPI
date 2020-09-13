package com.tchristofferson.stocks.api.core;

public interface IStockDataRequester {

    /**
     * <b>Method will perform blocking web request!</b><br>
     * Get stocks' data
     * @return An array of stock data
     */
    IStockData[] requestStockData();

    /**
     * <b>Method will perform blocking web request!</b><br>
     * Get stocks' split data
     * @return An array of stock data
     */
    IStockData[] requestStockSplits();

    /**
     * <b>Method will perform blocking web request!</b><br>
     * Get stocks' data with split data
     * @return An array of stock data
     */
    IStockData[] requestStockDataAndSplits();

}
