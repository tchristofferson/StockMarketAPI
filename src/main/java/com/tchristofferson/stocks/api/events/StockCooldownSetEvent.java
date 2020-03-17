package com.tchristofferson.stocks.api.events;

import com.tchristofferson.stocks.api.core.IStock;
import org.apache.commons.lang.Validate;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class StockCooldownSetEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final IStock stock;
    private long wait;

    public StockCooldownSetEvent(IStock stock, long wait) {
        this.stock = stock;
        this.wait = wait;
    }

    public IStock getStock() {
        return stock;
    }

    public long getWait() {
        return wait;
    }

    public void setWait(long wait) {
        Validate.isTrue(wait >= 0, "wait must be >= 0");
        this.wait = wait;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
