package com.tchristofferson.stocks.api.storage;

import com.tchristofferson.stocks.api.core.IPlayerStockData;

import java.util.UUID;

public interface CacheStorage extends NameGettableStorage {

    /**
     * {@inheritDoc}
     */
    @Override
    IPlayerStockData getUsingName(String name);

    /**
     * {@inheritDoc}
     */
    @Override
    IPlayerStockData get(UUID identifier);

    /**
     * {@inheritDoc}
     */
    @Override
    void update(UUID identifier, IPlayerStockData newObj);

    /**
     * {@inheritDoc}
     */
    @Override
    void delete(UUID identifier);

    /**
     * {@inheritDoc}
     */
    @Override
    void save(IPlayerStockData obj);

    /**
     * Save the cache to persistent storage
     */
    void saveCache();
}
