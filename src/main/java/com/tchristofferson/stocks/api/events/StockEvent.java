package com.tchristofferson.stocks.api.events;

import com.tchristofferson.stocks.api.core.IStock;
import com.tchristofferson.stocks.api.utils.FormatUtil;
import org.apache.commons.lang.Validate;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.HandlerList;

public class StockEvent extends OwnerableStockEvent {

    private static final HandlerList handlers = new HandlerList();
    private final IStock stock;
    private double shares;
    private boolean canceled;

    protected StockEvent(OfflinePlayer owner, IStock stock, double shares) {
        super(owner);
        this.stock = stock;
        this.shares = FormatUtil.formatShares(shares);
        this.canceled = false;
    }

    public IStock getStock() {
        return stock;
    }

    public double getShares() {
        return shares;
    }

    public void setShares(double shares) {
        shares = FormatUtil.formatShares(shares);
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
