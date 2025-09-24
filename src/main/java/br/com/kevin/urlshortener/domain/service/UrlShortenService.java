package br.com.kevin.urlshortener.domain.service;

import br.com.kevin.urlshortener.domain.dto.UrlShortenDto;
import br.com.kevin.urlshortener.domain.entity.UrlShortenEntity;
import br.com.kevin.urlshortener.domain.repository.UrlShortenRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class UrlShortenService {

    private final UrlShortenRepository repository;

    public UrlShortenService(UrlShortenRepository repository) {
        this.repository = repository;
    }

    public UrlShortenDto createUrlShorten(UrlShortenDto dto){
        String id;
        do {
            id = RandomStringUtils.randomAlphanumeric(5, 10);
        } while (repository.existsById(id));

        UrlShortenEntity resultUrl = this.repository.save(new UrlShortenEntity(id, dto.url(), Instant.now(), Instant.now().plusSeconds(60)));

        return new UrlShortenDto(resultUrl.getId());
    }

    public String findById(String id) {
        return this.repository.findById(id)
                .map(UrlShortenEntity::getUrl)
                .orElse(null);
    }

}
