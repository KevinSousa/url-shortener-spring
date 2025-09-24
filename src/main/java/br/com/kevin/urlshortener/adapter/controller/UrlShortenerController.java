package br.com.kevin.urlshortener.adapter.controller;

import br.com.kevin.urlshortener.domain.dto.UrlShortenDto;
import br.com.kevin.urlshortener.domain.service.UrlShortenService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping()
public class UrlShortenerController {

    private UrlShortenService service;

    public UrlShortenerController(UrlShortenService service) {
        this.service = service;
    }

    @PostMapping(value = "shorten-url")
    public ResponseEntity<UrlShortenDto> shortenUrl(@RequestBody UrlShortenDto dto, HttpServletRequest servletRequest) {
        String id = RandomStringUtils.random(10, true, true);
        UrlShortenDto result = this.service.createUrlShorten(dto);
        var redirect = servletRequest.getRequestURL().toString().replace("shorten-url", result.url());
        return ResponseEntity.ok(new UrlShortenDto(redirect));
    }

    @GetMapping("{id}")
    public ResponseEntity<UrlShortenDto> shortenUrl(@PathVariable String id) {
        var result = this.service.findById(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(result));
        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }

}
