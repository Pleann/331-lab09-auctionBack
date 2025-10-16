package se233._331lab09auctionback.lab09.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se233._331lab09auctionback.lab09.dao.AuctionItemDao;
import se233._331lab09auctionback.lab09.entity.AuctionItem;

@Service
@RequiredArgsConstructor
public class AuctionItemServiceImpl implements AuctionItemService {
    final AuctionItemDao auctionItemDao;

    @Override
    public Integer getAuctionItemSize() {
        return auctionItemDao.getAuctionItemSize();
    }

    @Override
    public Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page) {
        return auctionItemDao.getAuctionItems(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Page<AuctionItem> getAuctionItems(String name ,String type, Pageable pageable) {
        return auctionItemDao.getAuctionItems(name, type, pageable);
    }

    @Override
    public AuctionItem getAuctionItem(Long id) {
        return auctionItemDao.getAuctionItem(id);
    }

    @Override
    public AuctionItem save(AuctionItem auctionItem) {
        return auctionItemDao.save(auctionItem);
    }

    @Override
    public Page<AuctionItem> getAuctionItemsUnderMaxBid(Double maxBid, Pageable pageable) {
        return auctionItemDao.getAuctionItemsUnderMaxBid(maxBid, pageable);
    }
}