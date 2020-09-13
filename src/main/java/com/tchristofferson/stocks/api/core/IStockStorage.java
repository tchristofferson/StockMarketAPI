package com.tchristofferson.stocks.api.core;

import org.bukkit.entity.Player;

import java.time.ZonedDateTime;
import java.util.UUID;
import java.util.concurrent.Future;

public interface IStockStorage {

    /**
     * Get all online player data
     * @return An array of {@link IPlayerStockData} for all online players
     */
    IPlayerStockData[] getAllPlayerData();

    /**
     * Get an online player's data
     * @param uuid The {@link UUID} of the player
     * @return The player's {@link IPlayerStockData}
     */
    IPlayerStockData getPlayerData(UUID uuid);

    /**
     * Get an online player's data
     * @param playerName The name of the player, returned from {@link Player#getName()}
     * @return the player's {@link IPlayerStockData}
     */
    IPlayerStockData getPlayerData(String playerName);

    /**
     * Save an instance of {@link IPlayerStockData} for a player.
     * The {@link Future#isDone()} will return {@code true} immediately if using flat file
     * @param playerStockData The player data to save for the player
     * @return {@code true} if successful, {@code false} otherwise
     */
    Future<Boolean> savePlayerData(IPlayerStockData playerStockData);

    /**
     * Get an offline player's {@link IPlayerStockData}.
     * The {@link Future#isDone()} will return {@code true} immediately if using flat file or if it is still cached
     * @param uuid The {@link UUID} of the player
     * @return A {@link Future<IPlayerStockData>} which will return the {@link IPlayerStockData} or {@code null} if none exists
     */
    Future<IPlayerStockData> getOfflinePlayerData(UUID uuid);

    /**
     * Get an offline player's {@link IPlayerStockData}.
     * The {@link Future#isDone()} will return {@code true} immediately if using flat file or if it is still cached
     * @param name The player's username
     * @return A {@link Future<IPlayerStockData>} which will return the {@link IPlayerStockData} or {@code null} if none exists
     */
    Future<IPlayerStockData> getOfflinePlayerData(String name);

    /**
     * Get the date of the last time the server split the specified stock
     * @param symbol The stock symbol
     * @return A ZonedDateTime of when the stock was last split on the server, or {@code null} if never
     */
    Future<ZonedDateTime> getLastSplit(String symbol);

    /**
     * Get the date of the last time the server checked for a split for the specified stock
     * @param symbol The stock symbol
     * @return The ZonedDateTime of when the stock was last checked for a split, or {@code null} if never
     */
    Future<ZonedDateTime> getLastSplitCheck(String symbol);

    /**
     * Split a stock given the divisor. This will effect every player that owns the specified stock.
     * @param symbol The symbol of the stock to be split
     * @param divisor The number the shares will be divided by
     */
    void splitStock(String symbol, double divisor);
}
