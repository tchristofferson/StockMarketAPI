package com.tchristofferson.stocks.api.events;

import org.apache.commons.lang.Validate;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.HandlerList;

public class StockCooldownSetEvent extends OwnerableStockEvent {

    private static final HandlerList handlers = new HandlerList();
    private final String symbol;
    private long expire;

    public StockCooldownSetEvent(OfflinePlayer owner, String symbol, long expire) {
        super(owner);
        this.symbol = symbol;
        this.expire = expire;
    }

    public String getSymbol() {
        return symbol;
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
