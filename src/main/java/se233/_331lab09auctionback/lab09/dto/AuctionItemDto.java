package se233._331lab09auctionback.lab09.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItemDto
{
    Long id;
    String description;
    String type;
    List<BidDto> bids = new ArrayList<>();
    BidDto successfulBid;
}