package com.tchristofferson.stocks.api.core;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public interface IPlayerStockData {

    /**
     * Get the {@link UUID} of the player this data represents
     * @return The player's {@link UUID}
     */
    UUID getUuid();

    /**
     * Get the username of the player this data represents
     * @return The player's name
     */
    String getName();

    /**
     * Get a player's {@link IStock}
     * @param symbol The stock symbol
     * @return The player's {@link IStock}, or {@code null} if the player doesn't own any shares of the stock
     */
    IStock getStock(String symbol);

    /**
     * Get all of the player's stocks
     * @return A list of the player's stocks
     */
    List<IStock> getStocks();

    /**
     * Get a player's stocks matching the predicate
     * @param predicate The predicate
     * @return A player's stocks matching the predicate
     */
    List<IStock> getStocks(Predicate<IStock> predicate);

    /**
     * Get all of the player's stock symbols
     * @return A list of the player's stock symbols
     */
    List<String> getStockSymbols();

    /**
     * Get a player's stock symbols matching the predicate
     * @param predicate The predicate
     * @return A list of the player's stock symbols matching the predicate
     */
    List<String> getStockSymbols(Predicate<IStock> predicate);

    /**
     * Check if a player has shares of the given stock
     * @param symbol The stock symbol
     * @return {@code true} if the player owns shares of the stock, {@code false} otherwise
     */
    default boolean hasStock(String symbol) {
        return hasStock(symbol, 1);
    }

    /**
     * Check if a player has the specified number of shares of the specified stock
     * @param symbol The stock symbol
     * @param shares How many shares to check that they have
     * @return {@code true} if the player has the specified number of shares of the specified stock, {@code false} otherwise
     */
    default boolean hasStock(String symbol, int shares) {
        IStock stock = getStock(symbol);
        return stock != null && stock.getShares() >= shares;
    }

    /**
     * Give a player a specified amount of shares of the specified stock.
     * If the player already owns shares of this stock, it will be added
     * @param symbol The stock symbol
     * @param shares The amount of shares to give
     * @param invested The amount of money the player has invested in the specified stock
     * @return The {@link IStock} just added
     */
    IStock addStock(String symbol, double shares, double invested);

    /**
     * Takes all shares of the specified stock from the player
     * @param symbol The stock symbol
     * @return The {@link IStock} removed retaining how many shares the player had before removing
     */
    IStock removeStock(String symbol);

}
