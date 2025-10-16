package se233._331lab09auctionback.lab09.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se233._331lab09auctionback.lab09.entity.Bid;
import se233._331lab09auctionback.lab09.repository.BidRepository;

@Repository
@RequiredArgsConstructor
public class BidDaoDbImpl implements BidDao {
    final BidRepository bidRepository;

    @Override
    public Integer getBidSize() {
        return Math.toIntExact(bidRepository.count());
    }

    @Override
    public Page<Bid> getBids(Pageable pageable) {
        return bidRepository.findAll(pageable);
    }

    @Override
    public Bid getBid(Long id) {
        return bidRepository.findById(id).orElse(null);
    }

    @Override
    public Bid save(Bid bid) {
        return bidRepository.save(bid);
    }
}