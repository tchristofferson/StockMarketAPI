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
     * @return The name of the company
     */
    String getCompanyName();

    /**
     * Get the price of the stock when the stock market opened
     * @return The price when the stock market opened
     */
    BigDecimal getOpenPrice();

    /**
     * Get the price of the stock when the stock market closed
     * @return The price when the stock market closed
     */
    BigDecimal getClosePrice();

    /**
     * Get the latest price of the stock
     * @return The latest price
     */
    BigDecimal getLatestPrice();

    /**
     * Get the highest price for the last 52 weeks
     * @return The highest price for the last 52 weeks
     */
    BigDecimal getYearHigh();

    /**
     * Get the lowest price for the last 52 weeks
     * @return The lowest price for the last 52 weeks
     */
    BigDecimal getYearLow();

    /**
     * Get the market-wide highest price from the SIP
     * @return The market-wide highest price
     */
    BigDecimal getHighPrice();

    /**
     * Get the market-wide lowest price from the SIP
     * @return The market-wide lowest price
     */
    BigDecimal getLowPrice();

    /**
     * Get if the data was retrieved successfully.
     * If failed to retrieve data most methods will return {@code null}, except for {@link IStockData#getMessage()}
     * @return {@code true} if data was successfully retrieved, {@code false} otherwise
     */
    boolean wasSuccessful();

    /**
     * Get the error message if the data failed to be retrieved
     * @return The error message if {@link IStockData#wasSuccessful()} returns false, {@code null} otherwise
     */
    String getMessage();

}
