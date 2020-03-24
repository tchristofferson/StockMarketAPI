package com.tchristofferson.stocks.api.events;

import org.apache.commons.lang.Validate;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.HandlerList;

public class StockEvent extends OwnerableStockEvent {

    private static final HandlerList handlers = new HandlerList();
    private final String symbol;
    private int shares;
    private boolean canceled;

    protected StockEvent(OfflinePlayer owner, String symbol, int shares) {
        super(owner);
        this.symbol = symbol.trim().toUpperCase();
        this.shares = shares;
        this.canceled = false;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        Validate.isTrue(shares > 0, "shares must be > 0");
        this.shares = shares;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return canceled;
    }

    @Override
    public void setCancelled(boolean b) {
        canceled = b;
    }
}
