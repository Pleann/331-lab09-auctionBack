package se233._331lab09auctionback.lab09.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se233._331lab09auctionback.lab09.entity.Bid;

public interface BidDao {
    Integer getBidSize();
    Page<Bid> getBids(Pageable pageable);
    Bid getBid(Long id);
    Bid save(Bid bid);
}