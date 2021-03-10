package com.tchristofferson.stocks.api.events;

import com.tchristofferson.stocks.api.core.IStock;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.HandlerList;

public class PlayerSellSharesEvent extends PriceableStockEvent {

    private static final HandlerList handlers = new HandlerList();

    public PlayerSellSharesEvent(OfflinePlayer owner, IStock stock, double shares, double price) {
        super(owner, stock, shares, price);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
