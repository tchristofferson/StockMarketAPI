package com.tchristofferson.stocks.api.events;

import com.tchristofferson.stocks.api.core.IStock;
import org.apache.commons.lang.Validate;
import org.bukkit.event.HandlerList;

public class PlayerSellAllSharesEvent extends PlayerPreSellAllSharesEvent {

    private static final HandlerList handlers = new HandlerList();
    private double price;

    public PlayerSellAllSharesEvent(IStock[] IStocks, double price) {
        super(IStocks);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        Validate.isTrue(price > 0, "price must be > 0");
        this.price = price;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
