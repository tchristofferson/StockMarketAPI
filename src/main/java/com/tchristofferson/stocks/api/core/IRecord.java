package com.tchristofferson.stocks.api.core;

/**
 * Used to keep track of how much shares were bought for. Shares in this record will decrease when a player sells.
 */
public interface IRecord extends Cloneable {

    /**
     * Get the time, in millis, when the shares were purchased
     * @return The time the shares were purchased
     */
    long getPurchaseTime();

    /**
     * Get the price of a single share.
     * @return The price of a single share
     */
    double getPrice();

    /**
     * Get the price of all the shares in this record ({@link IRecord#getShares()} * {@link IRecord#getPrice()})
     * @return The price for all the shares in this record
     */
    double getTotal();

    /**
     * Get the number of shares in this record
     * @return The number of shares in this record
     */
    double getShares();

}
