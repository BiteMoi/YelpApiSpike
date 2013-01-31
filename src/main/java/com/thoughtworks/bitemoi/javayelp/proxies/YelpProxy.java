package com.thoughtworks.bitemoi.javayelp.proxies;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class YelpProxy {
    private final OAuthService oAuthService;
    private final Token token;

    public YelpProxy(
            String consumerKey,
            String consumerSecret,
            String token,
            String tokenSecret) {
        this.oAuthService = new ServiceBuilder()
                .apiKey(consumerKey)
                .apiSecret(consumerSecret)
                .provider(YelpApiService.class)
                .build();
        this.token = new Token(token, tokenSecret);
    }

    public String search(String term, double latitude, double longitude) {
        OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.yelp.com/v2/search");
        request.addQuerystringParameter("term", term);
        request.addQuerystringParameter("ll", latitude + "," + longitude);
        oAuthService.signRequest(token, request);
        Response response = request.send();
        return response.getBody();
    }
}
