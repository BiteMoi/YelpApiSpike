package com.thoughtworks.bitemoi.javayelp;

import com.google.gson.Gson;
import com.thoughtworks.bitemoi.javayelp.proxies.YelpProxy;
import com.thoughtworks.bitemoi.javayelp.wiretypes.SearchWireType;
import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class YelpApiSpikeIntegrationTest {
    @Test
    public void shouldSearchYelp() throws Exception {
        // Given
        Gson gson = new Gson();
        InputStream yelpPropertiesStream = getClass().getClassLoader().getResourceAsStream("yelp.properties");
        Properties properties = new Properties();
        properties.load(yelpPropertiesStream);

        YelpProxy api = new YelpProxy(
                properties.getProperty("consumer.key"),
                properties.getProperty("consumer.secret"),
                properties.getProperty("token.key"),
                properties.getProperty("token.secret"));

        // When
        String searchResultsJson = api.search("burritos", 37.7914, -122.4020);

        // Then
        SearchWireType searchResults = gson
                .fromJson(searchResultsJson, SearchWireType.class);
        assertThat(searchResults.getBusinesses(), hasSize(greaterThan(0)));
    }
}
