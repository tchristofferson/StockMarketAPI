package com.tchristofferson.stocks.api.events;

import com.tchristofferson.stocks.api.core.IStock;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.HandlerList;

public class TakeSharesEvent extends StockEvent {
    private static final HandlerList handlers = new HandlerList();

    public TakeSharesEvent(OfflinePlayer owner, IStock stock, double shares) {
        super(owner, stock, shares);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
