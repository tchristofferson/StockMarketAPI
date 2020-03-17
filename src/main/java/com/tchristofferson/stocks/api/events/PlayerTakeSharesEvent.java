package com.tchristofferson.stocks.api.events;

import com.tchristofferson.stocks.api.core.IStock;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class PlayerTakeSharesEvent extends StockEvent {

    private static final HandlerList handlers = new HandlerList();

    public PlayerTakeSharesEvent(Player taker, IStock IStock, int shares) {
        super(taker, IStock, shares);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
