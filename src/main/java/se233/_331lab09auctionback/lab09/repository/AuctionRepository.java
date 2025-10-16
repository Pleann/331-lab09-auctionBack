package se233._331lab09auctionback.lab09.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se233._331lab09auctionback.lab09.entity.AuctionItem;

public interface AuctionRepository  extends JpaRepository<AuctionItem, Long> {
    Page<AuctionItem> findByDescriptionContainingOrTypeContaining(String description,String type ,Pageable pageable);

    @Query("select a from AuctionItem a " +
            "where a.successfulBid is null or a.successfulBid.amount < :maxBid")
    Page<AuctionItem> findUnderMaxBid(@Param("maxBid") Double maxBid, Pageable pageable);

}