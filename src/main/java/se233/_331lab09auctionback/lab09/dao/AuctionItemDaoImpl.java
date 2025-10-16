package se233._331lab09auctionback.lab09.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se233._331lab09auctionback.lab09.entity.AuctionItem;
import se233._331lab09auctionback.lab09.repository.AuctionRepository;

@Repository
@RequiredArgsConstructor
public class AuctionItemDaoImpl implements AuctionItemDao {
    final AuctionRepository auctionItemRepository;

    @Override
    public Integer getAuctionItemSize() {
        return Math.toIntExact(auctionItemRepository.count());
    }

    @Override
    public Page<AuctionItem> getAuctionItems(Pageable pageable) {
        return auctionItemRepository.findAll(pageable);
    }

    @Override
    public AuctionItem getAuctionItem(Long id) {
        return auctionItemRepository.findById(id).orElse(null);
    }

    @Override
    public AuctionItem save(AuctionItem auctionItem) {
        return auctionItemRepository.save(auctionItem);
    }

    @Override
    public  Page<AuctionItem> getAuctionItems(String description , String type , Pageable pageable){
        return auctionItemRepository.findByDescriptionContainingOrTypeContaining(description,type,pageable);
    }

    @Override
    public Page<AuctionItem> getAuctionItemsUnderMaxBid(Double maxBid, Pageable pageable) {
        return auctionItemRepository.findUnderMaxBid(maxBid, pageable);
    }



}