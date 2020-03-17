package com.tchristofferson.stocks.api.events;

import com.tchristofferson.stocks.api.core.IStock;
import org.bukkit.event.HandlerList;

public class PlayerSellSharesEvent extends StockEvent {

    private static final HandlerList handlers = new HandlerList();

    public PlayerSellSharesEvent(IStock IStock, int shares, double price) {
        super(IStock, shares, price);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
