package com.tchristofferson.stocks.api.events;

import com.tchristofferson.stocks.api.core.IStock;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class StockEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final IStock IStock;
    private int shares;
    private double price;
    private boolean canceled;

    public StockEvent(IStock IStock, int shares, double price) {
        this(Bukkit.getPlayer(IStock.getOwner()), IStock, shares, price);
    }

    protected StockEvent(Player player, IStock IStock, int shares) {
        this(player, IStock, shares, 0);
    }

    private StockEvent(Player player, IStock IStock, int shares, double price) {
        super(player);
        this.IStock = IStock;
        this.shares = shares;
        this.price = price;
    }

    public IStock getStock() {
        return IStock;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        Validate.isTrue(shares > 0, "shares must be > 0");
        this.shares = shares;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        Validate.isTrue(price >= 0, "price must be >= 0");
        this.price = price;
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
