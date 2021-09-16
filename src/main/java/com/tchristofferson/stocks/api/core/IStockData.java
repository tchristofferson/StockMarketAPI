package com.tchristofferson.stocks.api.core;

import java.math.BigDecimal;

public interface IStockData {

    /**
     * Get the stock symbol
     * @return The stock symbol
     */
    String getSymbol();

    /**
     * Get the company name
     * @return The name of the company or null
     */
    String getCompanyName();

    /**
     * Get the percent change in price between the latest price and the last close price
     * @return The percent change or null
     */
    BigDecimal getChangePercent();

    /**
     * Get the price of the stock when the stock market opened
     * @return The price when the stock market opened or null
     */
    BigDecimal getOpenPrice();

    /**
     * Get the price of the stock when the stock market closed
     * @return The price when the stock market closed or null
     */
    BigDecimal getClosePrice();

    /**
     * Get the latest price of the stock
     * @return The latest price or null
     */
    BigDecimal getLatestPrice();

    /**
     * Get the highest price for the last 52 weeks
     * @return The highest price for the last 52 weeks or null
     */
    BigDecimal getYearHigh();

    /**
     * Get the lowest price for the last 52 weeks
     * @return The lowest price for the last 52 weeks or null
     */
    BigDecimal getYearLow();

    /**
     * Get the market-wide highest price from the SIP
     * @return The market-wide highest price or null
     */
    BigDecimal getHighPrice();

    /**
     * Get the market-wide lowest price from the SIP
     * @return The market-wide lowest price or null
     */
    BigDecimal getLowPrice();

    /**
     * Get if the US market is currently open
     * @return {@code true} if the US market is open, {@code false} otherwise (or null)
     */
    Boolean isMarketOpen();

    /**
     * Get the split data
     * @return The split data or null
     */
    ISplitData getSplits();

    /**
     * Get if the data was retrieved successfully.
     * If failed to retrieve data all methods will return {@code null}, except for {@link IStockData#getMessage()}
     * @return {@code true} if data was successfully retrieved, {@code false} otherwise
     */
    boolean wasSuccessful();

    /**
     * Get the error message if the data failed to be retrieved
     * @return The error message if {@link IStockData#wasSuccessful()} returns false, {@code null} otherwise
     */
    String getMessage();

}
