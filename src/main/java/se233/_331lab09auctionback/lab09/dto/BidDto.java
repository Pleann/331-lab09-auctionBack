package se233._331lab09auctionback.lab09.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidDto {
    Long id;
    Double amount;
    LocalDateTime datetime;
    // We don't include the entire item here, just the ID to break the cycle
    Long itemId;
}