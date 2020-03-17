package com.tchristofferson.stocks.api.events;

import com.tchristofferson.stocks.api.core.IStock;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class PlayerGiveSharesEvent extends PlayerTakeSharesEvent {

    private static final HandlerList handlers = new HandlerList();

    public PlayerGiveSharesEvent(Player giver, IStock IStock, int shares) {
        super(giver, IStock, shares);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
