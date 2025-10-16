package se233._331lab09auctionback.lab09.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bid")
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;

    Double amount;
    LocalDateTime datetime;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private AuctionItem item;
}