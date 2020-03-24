package com.tchristofferson.stocks.api.events;

import org.bukkit.OfflinePlayer;
import org.bukkit.event.HandlerList;

public class GiveSharesEvent extends StockEvent {
    private static final HandlerList handlers = new HandlerList();

    public GiveSharesEvent(OfflinePlayer owner, String symbol, int shares) {
        super(owner, symbol, shares);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
