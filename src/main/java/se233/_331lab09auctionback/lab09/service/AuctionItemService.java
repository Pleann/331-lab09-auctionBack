package se233._331lab09auctionback.lab09.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se233._331lab09auctionback.lab09.entity.AuctionItem;

public interface AuctionItemService {
    Integer getAuctionItemSize();
    Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page);
    Page<AuctionItem> getAuctionItems(String title,String type, Pageable pageable);
    Page<AuctionItem> getAuctionItemsUnderMaxBid(Double maxBid, Pageable pageable);
    AuctionItem getAuctionItem(Long id);
    AuctionItem save(AuctionItem auctionItem);


}