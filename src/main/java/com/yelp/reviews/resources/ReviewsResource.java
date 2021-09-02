package com.yelp.reviews.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yelp.reviews.models.Review;
import com.yelp.reviews.models.ReviewsData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import okhttp3.*;
import okhttp3.Request.Builder;

@RestController
@RequestMapping("/reviews")
public class ReviewsResource {

    @RequestMapping("/{businessId}")
    public List<Review> getReviews(@PathVariable("businessId") String businessId) throws IOException {

        String apiKey="QK1l9mHAaGHhqb88IhWq1rToI_5rq43JgM2iJTiFfXjAFYNzTHN8E7oTG-XuInFnCSsBRNqlF6L8ZOlRQt23TdykDIpRTY8wygdll3k47lbaGNGppOJ6-4vADEEtYXYx";

        OkHttpClient client = new OkHttpClient();
        Request request = new Builder()
                .url("https://api.yelp.com/v3/businesses/" + businessId + "/reviews")
                .get()
                .addHeader("authorization", "Bearer" + " " + apiKey)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseBody responseBody = client.newCall(request).execute().body();
        ReviewsData reviewsData = objectMapper.readValue(responseBody.string(), ReviewsData.class);

        return reviewsData.getReviews();
    }
}
