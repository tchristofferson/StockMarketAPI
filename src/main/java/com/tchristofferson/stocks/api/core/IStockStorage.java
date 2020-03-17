package com.tchristofferson.stocks.api.core;

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

}
