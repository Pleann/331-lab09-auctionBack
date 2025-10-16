package se233._331lab09auctionback.lab09.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se233._331lab09auctionback.lab09.dao.BidDao;
import se233._331lab09auctionback.lab09.entity.Bid;

@Service
@RequiredArgsConstructor
public class BidServiceImpl implements BidService {
    final BidDao bidDao;

    @Override
    public Integer getBidSize() {
        return bidDao.getBidSize();
    }

    @Override
    public Page<Bid> getBids(Integer pageSize, Integer page) {
        return bidDao.getBids(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Page<Bid> getBids(Pageable pageable) {
        return bidDao.getBids(pageable);
    }

    @Override
    public Bid getBid(Long id) {
        return bidDao.getBid(id);
    }

    @Override
    public Bid save(Bid bid) {
        return bidDao.save(bid);
    }
}