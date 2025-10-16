package se233._331lab09auctionback.lab09.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se233._331lab09auctionback.lab09.entity.AuctionItem;
import se233._331lab09auctionback.lab09.entity.Bid;
import se233._331lab09auctionback.lab09.repository.AuctionRepository;
import se233._331lab09auctionback.lab09.repository.BidRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final AuctionRepository auctionItemRepository;
    final BidRepository bidRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        // Create AuctionItems
        AuctionItem item1 = AuctionItem.builder()
                .description("Toys")
                .type("Collectible")
                .bids(new ArrayList<>())
                .build();

        AuctionItem item2 = AuctionItem.builder()
                .description("Cup")
                .type("Home Decor")
                .bids(new ArrayList<>())
                .build();

        AuctionItem item3 = AuctionItem.builder()
                .description("Computer")
                .type("Electronics")
                .bids(new ArrayList<>())
                .build();

        AuctionItem item4 = AuctionItem.builder()
                .description("Necklace")
                .type("Jewelry")
                .bids(new ArrayList<>())
                .build();

        AuctionItem item5 = AuctionItem.builder()
                .description("guitar")
                .type("Instrument")
                .bids(new ArrayList<>())
                .build();

        auctionItemRepository.save(item1);
        auctionItemRepository.save(item2);
        auctionItemRepository.save(item3);
        auctionItemRepository.save(item4);
        auctionItemRepository.save(item5);

        // Create Bids for item1
        Bid bid1_1 = Bid.builder()
                .amount(100.0)
                .datetime(LocalDateTime.now().minusDays(2))
                .item(item1)
                .build();

        Bid bid1_2 = Bid.builder()
                .amount(150.0)
                .datetime(LocalDateTime.now().minusDays(1))
                .item(item1)
                .build();

        Bid bid1_3 = Bid.builder()
                .amount(200.0)
                .datetime(LocalDateTime.now())
                .item(item1)
                .build();

        bidRepository.save(bid1_1);
        bidRepository.save(bid1_2);
        bidRepository.save(bid1_3);

        item1.getBids().add(bid1_1);
        item1.getBids().add(bid1_2);
        item1.getBids().add(bid1_3);
        item1.setSuccessfulBid(bid1_3); // Set successful bid for item1
        auctionItemRepository.save(item1);

        // Create Bids for item2
        Bid bid2_1 = Bid.builder()
                .amount(50.0)
                .datetime(LocalDateTime.now().minusDays(3))
                .item(item2)
                .build();

        Bid bid2_2 = Bid.builder()
                .amount(75.0)
                .datetime(LocalDateTime.now().minusDays(2))
                .item(item2)
                .build();

        Bid bid2_3 = Bid.builder()
                .amount(100.0)
                .datetime(LocalDateTime.now().minusDays(1))
                .item(item2)
                .build();

        bidRepository.save(bid2_1);
        bidRepository.save(bid2_2);
        bidRepository.save(bid2_3);

        item2.getBids().add(bid2_1);
        item2.getBids().add(bid2_2);
        item2.getBids().add(bid2_3);
        item2.setSuccessfulBid(bid2_3); // Set successful bid for item2
        auctionItemRepository.save(item2);

        // Create Bids for item3
        Bid bid3_1 = Bid.builder()
                .amount(300.0)
                .datetime(LocalDateTime.now().minusDays(4))
                .item(item3)
                .build();

        Bid bid3_2 = Bid.builder()
                .amount(320.0)
                .datetime(LocalDateTime.now().minusDays(3))
                .item(item3)
                .build();

        Bid bid3_3 = Bid.builder()
                .amount(350.0)
                .datetime(LocalDateTime.now().minusDays(2))
                .item(item3)
                .build();

        bidRepository.save(bid3_1);
        bidRepository.save(bid3_2);
        bidRepository.save(bid3_3);

        item3.getBids().add(bid3_1);
        item3.getBids().add(bid3_2);
        item3.getBids().add(bid3_3);
        item3.setSuccessfulBid(bid3_3); // Set successful bid for item3
        auctionItemRepository.save(item3);

        // Create Bids for item4
        Bid bid4_1 = Bid.builder()
                .amount(1000.0)
                .datetime(LocalDateTime.now().minusDays(5))
                .item(item4)
                .build();

        Bid bid4_2 = Bid.builder()
                .amount(1200.0)
                .datetime(LocalDateTime.now().minusDays(4))
                .item(item4)
                .build();

        Bid bid4_3 = Bid.builder()
                .amount(1500.0)
                .datetime(LocalDateTime.now().minusDays(3))
                .item(item4)
                .build();

        bidRepository.save(bid4_1);
        bidRepository.save(bid4_2);
        bidRepository.save(bid4_3);

        item4.getBids().add(bid4_1);
        item4.getBids().add(bid4_2);
        item4.getBids().add(bid4_3);
        // No successful bid for item4
        auctionItemRepository.save(item4);

        // Create Bids for item5
        Bid bid5_1 = Bid.builder()
                .amount(250.0)
                .datetime(LocalDateTime.now().minusDays(6))
                .item(item5)
                .build();

        Bid bid5_2 = Bid.builder()
                .amount(275.0)
                .datetime(LocalDateTime.now().minusDays(5))
                .item(item5)
                .build();

        Bid bid5_3 = Bid.builder()
                .amount(300.0)
                .datetime(LocalDateTime.now().minusDays(4))
                .item(item5)
                .build();

        bidRepository.save(bid5_1);
        bidRepository.save(bid5_2);
        bidRepository.save(bid5_3);

        item5.getBids().add(bid5_1);
        item5.getBids().add(bid5_2);
        item5.getBids().add(bid5_3);
        // No successful bid for item5
        auctionItemRepository.save(item5);
    }
}