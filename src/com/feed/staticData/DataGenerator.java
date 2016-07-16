package com.feed.staticData;

import com.feed.dto.FeedObj;
import com.feed.dto.MilkObj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by kasun on 7/16/16.
 */
public class DataGenerator {

    private static DataGeneratorHelper helper = new DataGeneratorHelper();

    public static void main(String args []) {

        Map<Integer, MilkObj> standardNutritionThreeToThreePointFive= helper.getStandardNutritionThreeToThreePointFive();
        Map<Integer, MilkObj> standardNutritionThreePointFiveToFour= helper.getStandardNutritionThreePointFiveToFour();
        Map<Integer, MilkObj> standardNutritionFourToFourPointFive= helper.getStandardNutritionFourToFourPointFive();

        Map<String, FeedObj> feedNutritionCatOne = helper.getFeedNutritionCatOne();
        Map<String, FeedObj> feedNutritionCatTwo = helper.getFeedNutritionCatTwo();
        Map<String, FeedObj> feedNutritionCatThree = helper.getFeedNutritionCatThree();

        Double standardWeightFor300kgAnimal = 300D;
        Double standardTdnVariationFor50kg = 300D;

        Double bodyWeight = 200D;
        Double milkYield = 6D;
        Double fatPercentage = 3.5D;

        List<String> bulkForage = new ArrayList<>(Arrays.asList("co3","gunia"));

        MilkObj relatedMilkObj = standardNutritionThreePointFiveToFour.get(milkYield.intValue());
        Double tdnValue = relatedMilkObj.getTdn();

        Double bodyWeightDiff = bodyWeight - standardWeightFor300kgAnimal;

        Double tdnValueForCow = tdnValue + bodyWeightDiff * ( standardTdnVariationFor50kg / 50 );

        if (bulkForage.size() > 1) {

        }








        printStandardNutrition(standardNutritionThreeToThreePointFive);
        System.out.println();
        printStandardNutrition(standardNutritionThreePointFiveToFour);
        System.out.println();
        printStandardNutrition(standardNutritionFourToFourPointFive);

        System.out.println();
        System.out.println();
        System.out.println();

        printFeedNutrition(feedNutritionCatOne);
        System.out.println();
        printFeedNutrition(feedNutritionCatTwo);
        System.out.println();
        printFeedNutrition(feedNutritionCatThree);

    }

    private static void printFeedNutrition(Map<String, FeedObj> feedNutrition) {

        for (Map.Entry<String, FeedObj> entry : feedNutrition.entrySet()) {

            String food = entry.getKey();
            Double tdn = entry.getValue().getTdn();
            Double dm = entry.getValue().getDm();
            System.out.print(food + " TDN : " + tdn + " DM : " + dm);
            System.out.println();
        }
    }

    private static void printStandardNutrition(Map<Integer, MilkObj> standardNutrition) {

        for (Map.Entry<Integer, MilkObj> entry : standardNutrition.entrySet()) {

            Integer liters = entry.getKey();
            Double tdn = entry.getValue().getTdn();
            Double dcp = entry.getValue().getDcp();
            System.out.print(liters + " TDN : " + tdn + " DCP : " + dcp);
            System.out.println("");
        }
    }

}
