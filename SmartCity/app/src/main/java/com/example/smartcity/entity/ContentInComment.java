package com.example.smartcity.entity;

public class ContentInComment implements CommentItem {
    @Override
    public String getItem() {
        return randomComments[(int) (Math.random() * randomComments.length)];
    }

    String[] randomComments = {
            "Great food! The flavors were absolutely delightful, and I couldn't have asked for a better dining experience.",
            "Amazing service! The staff was incredibly attentive and made sure we had everything we needed throughout our meal.",
            "Would definitely come again! The atmosphere was perfect for a night out with friends or a romantic dinner.",
            "A bit expensive. While the food was good, I felt that the prices were not justified for the portion sizes.",
            "I love it! The unique dishes and creative presentations made this restaurant a standout in the area.",
            "The food was mediocre at best. I expected more based on the reviews, but it fell short of my expectations.",
            "The wait time was excessively long, and it really dampened my overall experience at this restaurant.",
            "The portion sizes were quite small for the price we paid, which left me feeling unsatisfied and disappointed.",
            "The dessert was outstanding! It was the highlight of the meal and left a lasting impression on me.",
            "The ambiance was nice, but the noise level made it difficult to have a conversation with my dining companions.",
            "I had high hopes for this place, but the flavors were bland, and I was left feeling unsatisfied with my meal.",
            "The service was slow and unresponsive. It took forever to get our orders taken and our food served.",
            "I really appreciated the fresh ingredients used in the dishes; it made everything taste vibrant and delicious.",
            "Unfortunately, the restaurant was understaffed, which led to a chaotic dining experience and a long wait for service.",
            "While the appetizers were delightful, the main course did not live up to the same standards, which was quite disappointing."
    };
}
