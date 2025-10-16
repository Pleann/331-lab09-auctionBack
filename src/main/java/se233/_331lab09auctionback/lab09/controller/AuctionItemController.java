package se233._331lab09auctionback.lab09.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se233._331lab09auctionback.lab09.dto.AuctionItemDto;
import se233._331lab09auctionback.lab09.entity.AuctionItem;
import se233._331lab09auctionback.lab09.service.AuctionItemService;
import se233._331lab09auctionback.lab09.util.LabMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuctionItemController {
    final AuctionItemService auctionItemService;

    @GetMapping("/auction-items")
    public ResponseEntity<?> getAuctionItems(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "q", required = false) String q,
            @RequestParam(value = "type", required = false) String type){

        perPage = perPage == null ? 10 : perPage;
        page = page == null ? 1 : page;

        Page<AuctionItem> pageOutput;
        if (q != null && !q.isBlank()) {
            pageOutput = auctionItemService.getAuctionItems(q, q,PageRequest.of(page - 1, perPage));
        } else if (description != null || type != null) {
            pageOutput = auctionItemService.getAuctionItems(description,type, PageRequest.of(page - 1, perPage));
        } else {
            pageOutput = auctionItemService.getAuctionItems(perPage, page);
        }

        List<AuctionItemDto> auctionItemDtos = LabMapper.INSTANCE.getAuctionItemDtos(pageOutput.getContent());

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(auctionItemDtos, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/auction-items/{id}")
    public ResponseEntity<?> getAuctionItem(@PathVariable("id") Long id) {
        AuctionItem output = auctionItemService.getAuctionItem(id);
        if (output != null) {
            AuctionItemDto auctionItemDto = LabMapper.INSTANCE.getAuctionItemDto(output);
            return ResponseEntity.ok(auctionItemDto);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/auction-items")
    public ResponseEntity<?> addAuctionItem(@RequestBody AuctionItem auctionItem) {
        AuctionItem output = auctionItemService.save(auctionItem);
        AuctionItemDto auctionItemDto = LabMapper.INSTANCE.getAuctionItemDto(output);
        return ResponseEntity.status(HttpStatus.CREATED).body(auctionItemDto);
    }

    @GetMapping("/under")
    public ResponseEntity<?> getAuctionItemsUnder(
            @RequestParam("maxBid") Double maxBid,
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page) {

        perPage = perPage == null ? 10 : perPage;
        page = page == null ? 1 : page;

        Page<AuctionItem> pageOutput =
                auctionItemService.getAuctionItemsUnderMaxBid(maxBid, PageRequest.of(page - 1, perPage));

        List<AuctionItemDto> dtoList = LabMapper.INSTANCE.getAuctionItemDtos(pageOutput.getContent());

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(dtoList, headers, HttpStatus.OK);
    }
}