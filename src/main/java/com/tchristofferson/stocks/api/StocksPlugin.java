package com.tchristofferson.stocks.api;

import com.tchristofferson.stocks.api.core.IStockData;
import com.tchristofferson.stocks.api.core.IStockStorage;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

public interface StocksPlugin extends Plugin {

    /**
     * Get the stock storage
     * @return The stock storage where player's stocks are stored
     */
    IStockStorage getStockStorage();

    /**
     * Get {@link IStockData} for specified stock
     * @param symbol The stock symbol
     * @return The {@link IStockData} for the stock
     */
    Future<IStockData> getStockData(String symbol);

    Future<IStockData[]> getStockData(List<String> symbols);

    default Future<IStockData[]> getStockData(String... symbols) {
        return getStockData(Arrays.asList(symbols));
    }

}
