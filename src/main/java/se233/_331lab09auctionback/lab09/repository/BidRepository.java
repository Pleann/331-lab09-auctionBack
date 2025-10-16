package se233._331lab09auctionback.lab09.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import se233._331lab09auctionback.lab09.entity.Bid;

public interface BidRepository  extends JpaRepository<Bid, Long> {
}