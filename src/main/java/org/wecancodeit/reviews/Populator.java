package org.wecancodeit.reviews;

import org.wecancodeit.reviews.models.Category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviews.storage.CategoryStorage;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.storage.HashtagStorage;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.ReviewStorage;



@Component
public class Populator implements CommandLineRunner{

    private CategoryStorage categoryStorage;
    private ReviewStorage reviewStorage;
    private HashtagStorage hashtagStorage;

    public Populator(ReviewStorage reviewStorage, CategoryStorage categoryStorage, HashtagStorage hashtagStorage){
        this.categoryStorage = categoryStorage;
        this.reviewStorage = reviewStorage;
        this.hashtagStorage = hashtagStorage;
    }

    @Override
    public void run(String... args){
        Category sedan = new Category("Sedan");
        categoryStorage.store(sedan);
        Category coupe = new Category("Coupe");
        categoryStorage.store(coupe);
        Hashtag hashtag1 = new Hashtag("TotallyWorthIt");
        Hashtag hashtag2 = new Hashtag("HolyCow");
        Hashtag hashtag3 = new Hashtag("Dud");
        Hashtag hashtag4 = new Hashtag("Cool");
        Hashtag hashtag5 = new Hashtag("BitchinRide");
        Hashtag hashtag6 = new Hashtag("Super");
        Hashtag hashtag7 = new Hashtag("Fast");
        Hashtag hashtag8 = new Hashtag("BMW");
        Hashtag hashtag9 = new Hashtag("WorseThanCorona");
        Hashtag hashtag10 = new Hashtag("MyHappySpot");
        Hashtag hashtag11 = new Hashtag("BurnsOil");
        Hashtag hashtag12 = new Hashtag("NotCool");
        Hashtag hashtag13 = new Hashtag("Junk");
        Hashtag hashtag14 = new Hashtag("GasGuzzler");
        Hashtag hashtag15 = new Hashtag("Slow");
        Hashtag hashtag16 = new Hashtag("Pricey");
        Hashtag hashtag17 = new Hashtag("Forever");

        hashtagStorage.store(hashtag1);
        hashtagStorage.store(hashtag2);
        hashtagStorage.store(hashtag3);
        hashtagStorage.store(hashtag4);
        hashtagStorage.store(hashtag5);
        hashtagStorage.store(hashtag6);
        hashtagStorage.store(hashtag7);
        hashtagStorage.store(hashtag8);
        hashtagStorage.store(hashtag9);
        hashtagStorage.store(hashtag10);
        hashtagStorage.store(hashtag11);
        hashtagStorage.store(hashtag12);
        hashtagStorage.store(hashtag13);
        hashtagStorage.store(hashtag14);
        hashtagStorage.store(hashtag15);
        hashtagStorage.store(hashtag16);
        hashtagStorage.store(hashtag17);

        Review review1 = new Review(sedan, "Viagra on wheels", "Absolutely amazing car. Very quick, great " +
                "styling, and really makes a statement when I come to a stop at a red light. " +
                "This car is like Viagra on wheels", hashtag1);
        Review review2 = new Review(coupe, "Holy Cow!!!!", "I got a really great deal on this car, " +
                "so I didn't expect it to loose that much. The KBB rating is less than half what the MSRP was, " +
                "and about 50% of what I paid. Other than that, I have had a few problems with it. Driver power window," +
                " which they \"couldn't find the problem with it\" the two times I had it in for service. Finally," +
                " the window totally came out of the frame on a rainy night. The electronics are, well, not that good. " +
                "Navigation and voice recognition are the worst. I do like the performance and " +
                "handling, but the biggest rush of adrenaline I got was seeing" +
                " how far upside down I was, even at 0% financing!" , hashtag2);
        Review review3 = new Review(sedan, "Best Car Ever Made","The Civic is a great value. It has a very " +
                "comfortable ride, gets great mileage and is very cost effective. Very reasonable in the maintenance area and " +
                "very stable in the highway. I have had three of them and will be getting another in the future.", hashtag5, hashtag7, hashtag10);
        Review review4 = new Review(sedan, "Worst Car Ever Made", "purchased a Honda Civic. I thought this was a reliable car. " +
                "I have less than 13,000 miles and have had three batteries. (The one it came with and two more.) I had to take it in because " +
                "it would hesitate when I would turn right. They were unable to duplicate. The module display went bad and it had to be replaced." +
                " When I asked why so many batteries the service department said, \"I don’t know.\" I called the Corporate office and they said I " +
                "don’t drive the car enough. I will never ever buy or suggest that anyone buy a Honda. I feel I have a lemon and Honda has not" +
                " been helpful at all. Please do not buy, if you have a problem with the car you are on your own.", hashtag3, hashtag13, hashtag9);
        Review review5 = new Review(sedan, "Runs Forever", " This is one of those cars that you will hate. Why because it may out " +
                "live you. You will just get sick of it being so trustworthy and reliable. For gosh sake Toyota give me something to talk about " +
                "other that oil changes and new tires. Not even a squeaky belt after 100,000 miles. I drive 25-28k per year and this car it the " +
                "best vehicle I have ever owned.", hashtag6, hashtag17);
        Review review6 = new Review(sedan, "Not much bang for buck", "They say you get what you pay for, and that couldn't be " +
                "any more true. Overall, I give this 2 out of 5 stars, for the simple fact that it \"looks cute\" and I'm not dead from driving it" +
                " yet... I purchased mine new in 2017, and as of 2020, I still have under 30,000 miles. So far, I've had the following issues:" +
                " front and rear brakes needed to be changed rear shocks needed to be changed cracked engine mount battery completely died and" +
                " needed to be replaced alignment needed to be fixed needed two new front tires due to said alignment Way too many issues if you" +
                " ask me for such a \"young\" car. Definitely not worth the lower cost, it'll cost you more in the long run for repairs. I also " +
                "feel a shake/jolt which I think could be a transmission issue... Would NOT recommend.", hashtag11, hashtag13);
        Review review7 = new Review(coupe, "Expensive junk", "Thought I was buying a reliable, state-of-the-art, piece of engineering perfection. Instead, my M3" +
                " has been nothing short of an empty pit to throw money at. Wheel bearings, tie-rods, misfiring; you name it, I’ve had it " +
                "repaired. I can’t wait to get rid of it once my lease runs out.", hashtag3, hashtag8, hashtag13);
        Review review8 = new Review(coupe, "Love my ride", "Great ride. The performance is perfect for my long-daily commutes to" +
                " work. Smooth on the road, and has just enough “oomph” to make the drive fun. Good gas mileage, and has been low maintenance the " +
                "entire time I’ve had it. The interior is spacious, and the seating is comfortable.", hashtag5, hashtag1, hashtag7, hashtag10);
        Review review9 = new Review(coupe, "Don't drink and buy", "Fred Flintstone’s car has more perks than my Azera." +
                " I must have been on a three-day bender when I bought this “block on wheels”. I guess I should be happy it has an engine and" +
                " wheels, cause there isn’t much more to brag about other than this. And don’t get me started on it’s reliability --- " +
                "it’s non-existent! I should’ve skipped buying the car, and just lit my money on fire each money. At least I could " +
                "toast marsh mellows when doing so",hashtag3, hashtag9, hashtag12);
        reviewStorage.store(review1);
        reviewStorage.store(review2);
        reviewStorage.store(review3);
        reviewStorage.store(review4);
        reviewStorage.store(review5);
        reviewStorage.store(review6);
        reviewStorage.store(review7);
        reviewStorage.store(review8);
        reviewStorage.store(review9);
        
    }
}
