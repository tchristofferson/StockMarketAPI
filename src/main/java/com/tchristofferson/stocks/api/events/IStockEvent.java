package com.tchristofferson.stocks.api.events;

import org.bukkit.OfflinePlayer;
import org.bukkit.event.Cancellable;

public interface IStockEvent extends Cancellable {

    /**
     * Get the player affected by the event (the player that owns the stock)
     * @return The {@link OfflinePlayer} that owns the stock
     */
    OfflinePlayer getOwner();

}
