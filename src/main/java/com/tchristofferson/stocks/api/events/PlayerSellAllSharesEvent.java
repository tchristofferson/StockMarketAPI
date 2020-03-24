package com.tchristofferson.stocks.api.events;

import org.apache.commons.lang.Validate;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.HandlerList;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PlayerSellAllSharesEvent extends OwnerableStockEvent {

    private static final HandlerList handlers = new HandlerList();
    private final Map<String, Integer> shares;
    private final Map<String, Double> prices;
    private double total;

    public PlayerSellAllSharesEvent(OfflinePlayer owner, Map<String, Integer> shares, Map<String, Double> prices) {
        super(owner);

        Validate.isTrue(shares.size() == prices.size(), "shares and prices have different sizes");
        Validate.isTrue(shares.keySet().equals(prices.keySet()), "shares and prices have mismatched symbols");

        this.shares = new HashMap<>(shares);
        this.prices = new HashMap<>(prices);

        BigDecimal total = new BigDecimal(0).setScale(2, BigDecimal.ROUND_DOWN);
        for (Map.Entry<String, Integer> entry : shares.entrySet()) {
            total = total.add(BigDecimal.valueOf(entry.getValue() * prices.get(entry.getKey())));
        }

        this.total = total.doubleValue();
    }

    public Map<String, Integer> getShares() {
        return shares;
    }

    public Map<String, Double> getPrices() {
        return prices;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        Validate.isTrue(total >= 0, "total must be >= 0");
        this.total = total;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
