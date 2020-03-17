package com.tchristofferson.stocks.api.storage;

import com.tchristofferson.persistentstorageapi.SingleStorage;
import com.tchristofferson.stocks.api.core.IPlayerStockData;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface NameGettableStorage extends SingleStorage<IPlayerStockData, UUID> {

    /**
     * Get {@link IPlayerStockData} using a player's name
     * @param name The player's name returned from {@link Player#getName()}
     * @return The player's name
     */
    IPlayerStockData getUsingName(String name) throws Exception;

}
