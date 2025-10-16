package se233._331lab09auctionback.lab09.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se233._331lab09auctionback.lab09.entity.AuctionItem;

public interface AuctionItemDao {
    Integer getAuctionItemSize();
    Page<AuctionItem> getAuctionItems(Pageable pageable);
    AuctionItem getAuctionItem(Long id);
    AuctionItem save(AuctionItem auctionItem);
    Page<AuctionItem> getAuctionItems(String description,String type, Pageable pageable);

    Page<AuctionItem> getAuctionItemsUnderMaxBid(Double maxBid, Pageable pageable);

}