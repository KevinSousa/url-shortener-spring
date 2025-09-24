package br.com.kevin.urlshortener.domain.repository;

import br.com.kevin.urlshortener.domain.entity.UrlShortenEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlShortenRepository extends MongoRepository<UrlShortenEntity, String> {
}
