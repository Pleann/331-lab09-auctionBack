package se233._331lab09auctionback.lab09.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se233._331lab09auctionback.lab09.dto.AuctionItemDto;
import se233._331lab09auctionback.lab09.dto.BidDto;
import se233._331lab09auctionback.lab09.entity.AuctionItem;
import se233._331lab09auctionback.lab09.entity.Bid;


import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    // Map AuctionItem to AuctionItemDTO
    AuctionItemDto getAuctionItemDto(AuctionItem auctionItem);
    List<AuctionItemDto> getAuctionItemDtos(List<AuctionItem> auctionItems);

    // Map Bid to BidDTO with custom mapping for itemId
    @Mapping(source = "item.id", target = "itemId")
    BidDto getBidDto(Bid bid);
    List<BidDto> getBidDtos(List<Bid> bids);
}