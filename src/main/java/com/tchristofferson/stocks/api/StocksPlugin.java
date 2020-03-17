package com.tchristofferson.stocks.api;

import com.tchristofferson.stocks.api.core.IStockStorage;

public interface StocksPlugin {

    IStockStorage getStockStorage();

}
