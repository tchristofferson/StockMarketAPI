package com.tchristofferson.stocks.api.events;

import com.tchristofferson.stocks.api.core.IStock;
import org.apache.commons.lang.Validate;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.HandlerList;

public class StockCooldownSetEvent extends OwnerableStockEvent {

    private static final HandlerList handlers = new HandlerList();
    private final IStock stock;
    private long expire;

    public StockCooldownSetEvent(OfflinePlayer owner, IStock stock, long expire) {
        super(owner);
        this.stock = stock;
        this.expire = expire;
    }

    public IStock getStock() {
        return stock;
    }

    public long getExpire() {
        return expire;
    }

    public void setCooldown(long wait) {
        Validate.isTrue(wait >= 0, "waitTime must be >= 0");

        if (wait == 0)
            expire = 0;
        else
            expire = System.currentTimeMillis() + wait;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
