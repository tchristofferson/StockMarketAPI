package com.tchristofferson.stocks.api.core;

import java.util.UUID;

public interface IStock extends Cloneable {

    /**
     * Get the stock symbol
     * @return The symbol for this stock
     */
    String getSymbol();

    /**
     * Get the {@link UUID} of the player that owns the stock
     * @return The {@link UUID} of the player this stock belongs to
     */
    UUID getOwner();

    /**
     * Get the number of shares the player owns of this stock
     * @return How many shares of this stock the owning player owns
     */
    double getShares();

    /**
     * Get how much the player has paid to buy all shares of the stock
     * @return How much has been invested in this stock
     */
    double getInvested();

    /**
     * Set how many shares the owning player owns
     * @param shares The new amount of shares
     */
    void setShares(double shares);

    /**
     * Set how much the owning player has invested into this stock
     * @param invested The new invested amount
     */
    void setInvested(double invested);

    /**
     * Set a cooldown for the stock.
     * Set wait to 0 to remove a cooldown
     * @param wait How long the cooldown should last in milliseconds
     */
    void setCooldown(long wait);

    /**
     * Get the time when player can sell shares
     * @return The time the player can sell shares in millis
     */
    long getCooldown();

    /**
     * Get if the player has a cooldown for the specified stock
     * @return {@code true} if they have a cooldown, {@code false} otherwise
     */
    default boolean hasCooldown() {
        return getCooldown() != 0;
    }

    /**
     * Get the last time shares of this stock were purchased
     * @return last purchase time
     */
    long getLastPurchaseTime();

    /**
     * Set the last time shares of this stock were purchased to the current time
     */
    void setLastPurchaseTime();

}
