package se233._331lab09auctionback.lab09.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se233._331lab09auctionback.lab09.dto.BidDto;
import se233._331lab09auctionback.lab09.entity.Bid;
import se233._331lab09auctionback.lab09.service.BidService;
import se233._331lab09auctionback.lab09.util.LabMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BidController {
    final BidService bidService;

    @GetMapping("/bids")
    public ResponseEntity<?> getBids(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page) {

        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;

        Page<Bid> pageOutput = bidService.getBids(PageRequest.of(page - 1, perPage));

        List<BidDto> bidDtos = LabMapper.INSTANCE.getBidDtos(pageOutput.getContent());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(bidDtos, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/bids/{id}")
    public ResponseEntity<?> getBid(@PathVariable("id") Long id) {
        Bid output = bidService.getBid(id);
        if (output != null) {
            BidDto bidDto = LabMapper.INSTANCE.getBidDto(output);
            return ResponseEntity.ok(bidDto);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/bids")
    public ResponseEntity<?> addBid(@RequestBody Bid bid) {
        Bid output = bidService.save(bid);
        BidDto bidDto = LabMapper.INSTANCE.getBidDto(output);
        return ResponseEntity.status(HttpStatus.CREATED).body(bidDto);
    }
}