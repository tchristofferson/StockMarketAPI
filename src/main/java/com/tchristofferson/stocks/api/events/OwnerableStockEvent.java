package com.tchristofferson.stocks.api.events;

import org.bukkit.OfflinePlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class OwnerableStockEvent extends Event implements IStockEvent {
    private static final HandlerList handlers = new HandlerList();
    private final OfflinePlayer owner;
    private boolean canceled;

    protected OwnerableStockEvent(OfflinePlayer owner) {
        this.owner = owner;
        this.canceled = false;
    }

    @Override
    public OfflinePlayer getOwner() {
        return owner;
    }

    @Override
    public boolean isCancelled() {
        return canceled;
    }

    @Override
    public void setCancelled(boolean b) {
        canceled = b;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
