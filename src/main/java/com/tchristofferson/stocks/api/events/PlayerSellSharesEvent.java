package com.tchristofferson.stocks.api.events;

import org.bukkit.OfflinePlayer;
import org.bukkit.event.HandlerList;

public class PlayerSellSharesEvent extends PriceableStockEvent {

    private static final HandlerList handlers = new HandlerList();

    public PlayerSellSharesEvent(OfflinePlayer owner, String symbol, int shares, double price) {
        super(owner, symbol, shares, price);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
