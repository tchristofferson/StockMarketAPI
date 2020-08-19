package com.tchristofferson.stocks.api.core;

import java.util.Map;

public interface ISplitData {

    /**
     * Get the symbol who's splits this represents
     * @return The symbol
     */
    String getSymbol();

    /**
     * Get the stock's split data.
     * The key is a date represented as yyyy-mm-dd.
     * The value is the ratio of the stock split.
     * A ratio of 2 means player's stocks would multiply by 2 if applied.
     * A Ratio of 0.5 means a players stocks would be cut in half if applied.
     * @return The split data
     */
    Map<String, Double> getData();

}
