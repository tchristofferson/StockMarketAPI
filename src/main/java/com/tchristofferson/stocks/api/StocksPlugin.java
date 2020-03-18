package com.tchristofferson.stocks.api;

import com.tchristofferson.stocks.api.core.IStockStorage;
import org.bukkit.plugin.Plugin;
import pl.zankowski.iextrading4j.api.stocks.Quote;

import java.util.concurrent.Future;

public interface StocksPlugin extends Plugin {

    IStockStorage getStockStorage();

    Future<Quote> getStockPrice(String symbol);

}
