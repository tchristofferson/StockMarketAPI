package com.tchristofferson.stocks.api.core;

import com.tchristofferson.stocks.api.utils.FormatUtil;
import org.apache.commons.lang.Validate;

import java.util.List;
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
     * Get a list of records for this stock
     * @return A list of records
     */
    List<IRecord> getRecords();

    /**
     * Get a list of records for the specified number of shares
     * @param shares The number of shares to find records for
     * @return A list of records
     */
    List<IRecord> getRecords(double shares);

    /**
     * Set the list of records for this stock
     * @param records A list of records
     */
    void setRecords(List<IRecord> records);

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
     * Split the stock with the specified divisor
     * @param divisor Current shares are divided by the divisor
     */
    void split(double divisor);

//    /**
//     * Set how many shares the owning player owns
//     * @param shares The new amount of shares
//     * @param price The price for ONE share. Only applies when the share count is being increased
//     * @param fifo Stands for first in first out. Only applies when the share count is being lowered<br>
//     *             If {@code true} shares from the oldest record will be subtracted, otherwise the newest.<br>
//     *             When a player sells shares the plugin uses {@code true}
//     */
//    default void setShares(double shares, double price, boolean fifo) {
//        shares = FormatUtil.formatShares(shares);
//        Validate.isTrue(shares > 0, "shares must be > 0");
//
//        synchronized (this) {
//            if (getShares() > shares) {
//                subShares(shares, fifo);
//            } else if (getShares() < shares) {
//                addShares(shares, price);
//            }
//        }
//    }

    /**
     * Add shares. Will also be added to the stock record with a price of 0
     * @param shares The number of shares to add
     * @param price The price for one share
     */
    default void addShares(double shares, double price) {
        addShares(shares, price, System.currentTimeMillis());
    }

    void addShares(double shares, double price, long time);

    /**
     * Subtract shares. Will also be taken from the end of the stock record
     * @param shares The number of shares to subtract
     * @param fifo Stands for first in first out.<br>
     *             If {@code true} shares from the oldest record will be subtracted, otherwise the newest.<br>
     *             When a player sells shares the plugin uses {@code true}
     *
     */
    void subShares(double shares, boolean fifo);

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
