package com.tchristofferson.stocks.api.events;

import com.tchristofferson.stocks.api.core.IStock;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class PlayerPreSellAllSharesEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final IStock[] IStocks;
    private boolean canceled;

    public PlayerPreSellAllSharesEvent(IStock[] IStocks) {
        super(Bukkit.getPlayer(IStocks[0].getOwner()));
        this.IStocks = IStocks;
    }

    public IStock[] getStocks() {
        return IStocks;
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
