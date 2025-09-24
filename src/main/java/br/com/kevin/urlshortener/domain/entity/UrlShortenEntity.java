package br.com.kevin.urlshortener.domain.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "urls")
public class UrlShortenEntity {

    @Id
    private String id;
    private String url;
    @CreatedDate
    private Instant  createdAt;
    @Indexed(expireAfter = "0s")
    private Instant expiresAt;

    public UrlShortenEntity(String id, String url, Instant createdAt, Instant expiresAt) {
        this.url = url;
        this.id = id;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
    }

    public UrlShortenEntity() {
    }

    public String getUrl() {
        return url;
    }

    public String getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getExpiresAt() {
        return expiresAt;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
