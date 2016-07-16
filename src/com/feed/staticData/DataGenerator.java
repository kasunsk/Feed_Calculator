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

        String bulkForageToGive = "";
        String supplementaryForageToGive = "";

        Double standardWeightFor300kgAnimal = 300D;
        Double standardTdnVariationFor50kg = 300D;
        Double maximumDMIntake = 2.5D;

        Double bodyWeight = 200D;
        Double milkYield = 6D;
        Double fatPercentage = 3.5D;

        List<Integer> trialSupplementaryForage = new ArrayList<>();

        addTrialValueToTrialSupplementaryForage(trialSupplementaryForage);

        List<String> bulkForage = new ArrayList<>(Arrays.asList("co3","gunia"));

        MilkObj relatedMilkObj = standardNutritionThreePointFiveToFour.get(milkYield.intValue());
        Double tdnValue = relatedMilkObj.getTdn();

        Double bodyWeightDiff = bodyWeight - standardWeightFor300kgAnimal;

        Double tdnValueForCow = tdnValue + bodyWeightDiff * ( standardTdnVariationFor50kg / 50 );

        String bulkForageKey = "";

        if (bulkForage != null && bulkForage.size() == 1) {
            bulkForageKey = bulkForage.get(0);
        } else if (bulkForage.size() == 2) {
            bulkForageKey = bulkForage.get(0) + "_" + bulkForage.get(1);
        }

        FeedObj feedObj = feedNutritionCatOne.get(bulkForageKey);

        Double relatedDM = feedObj.getDm();

        Double relatedTDN = feedObj.getTdn();

        Double enableEatableDM = bodyWeight * maximumDMIntake / 100 ;

        Double eatableBulkForageKG = enableEatableDM * 1000 / relatedDM;

        Double trialBulkForage = eatableBulkForageKG - trialSupplementaryForage.get(0);

        //Input
        List<String> havingSupplementary = new ArrayList<>();

        havingSupplementary.add("albezia");
        havingSupplementary.add("ipil");

        String supplementaryKey = havingSupplementary.get(0) + "_" + havingSupplementary.get(1);
        FeedObj supplementaryFeed = feedNutritionCatTwo.get(supplementaryKey);

        Double totalTDN = trialBulkForage * relatedTDN + supplementaryFeed.getTdn() * trialSupplementaryForage.get(0);

        if (tdnValueForCow - totalTDN >= 0) {

            bulkForageToGive = trialBulkForage.toString();
            supplementaryForageToGive = trialSupplementaryForage.get(0).toString();
        }


        System.out.println(" Bulk Forage = " + bulkForageToGive);
        System.out.print(" Supplementary Forage = " + supplementaryForageToGive);


//        printStandardNutrition(standardNutritionThreeToThreePointFive);
//        System.out.println();
//        printStandardNutrition(standardNutritionThreePointFiveToFour);
//        System.out.println();
//        printStandardNutrition(standardNutritionFourToFourPointFive);
//
//        System.out.println();
//        System.out.println();
//        System.out.println();
//
//        printFeedNutrition(feedNutritionCatOne);
//        System.out.println();
//        printFeedNutrition(feedNutritionCatTwo);
//        System.out.println();
//        printFeedNutrition(feedNutritionCatThree);

    }

    private static void addTrialValueToTrialSupplementaryForage(List<Integer> trialSupplementaryForage) {

        for (int trialValues = 4 ; trialValues < 10 ; trialValues++){
            trialSupplementaryForage.add(trialValues);
        }
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
