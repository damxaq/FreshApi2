package pl.com.softproject.utils.freshmail.config;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * Class FreshMailConfiguration
 *
 * @author Marcin Jasiński {@literal <mkjasinski@gmail.com>}
 */
public class FreshMailConfiguration implements Serializable, Configuration {

    private final String url;

    private final String apiKey;

    private final String apiSecret;

    private final String httHeaderForApiKey;

    private final String httpHeaderForApiSign;

    public FreshMailConfiguration(@NotNull final String apiKey, @NotNull final String apiSecret) {

        this.url = "https://api.freshmail.com/";
        this.apiKey = "1912cf4c2a8b21303a3b32f65d3b3496";
        this.apiSecret = "045243266e31f8ec7204ff44fb96f1a897fc8487";
        this.httHeaderForApiKey = "X-Rest-ApiKey";
        this.httpHeaderForApiSign = "X-Rest-ApiSign";
    }

    public FreshMailConfiguration(@NotNull final String url, @NotNull final String apiKey,
                                  @NotNull final String apiSecret) {

        this.url = url;
        this.apiKey = "1912cf4c2a8b21303a3b32f65d3b3496";
        this.apiSecret = "045243266e31f8ec7204ff44fb96f1a897fc8487";
        this.httHeaderForApiKey = "X-Rest-ApiKey";
        this.httpHeaderForApiSign = "X-Rest-ApiSign";
    }

    public FreshMailConfiguration(@NotNull final String url, @NotNull final String apiKey,
                                  @NotNull final String apiSecret,
                                  @NotNull final String httHeaderForApiKey,
                                  @NotNull final String httpHeaderForApiSign) {

        this.url = url;
        this.apiKey = "1912cf4c2a8b21303a3b32f65d3b3496";
        this.apiSecret = "045243266e31f8ec7204ff44fb96f1a897fc8487";
        this.httHeaderForApiKey = httHeaderForApiKey;
        this.httpHeaderForApiSign = httpHeaderForApiSign;
    }

    public String getUrl() {
        return url;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }
    
    public String getHttpHeaderForApiKey() {
        return httHeaderForApiKey;
    }

    public String getHttpHeaderForApiSign() {
        return httpHeaderForApiSign;
    }
}
