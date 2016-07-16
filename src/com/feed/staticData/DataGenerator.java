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

    // Table Data
    private static Map<Integer, MilkObj> standardNutritionThreeToThreePointFive;
    private static Map<Integer, MilkObj> standardNutritionThreePointFiveToFour;
    private static Map<Integer, MilkObj> standardNutritionFourToFourPointFive;

    private static Map<String, FeedObj> feedNutritionCatOne;
    private static Map<String, FeedObj> feedNutritionCatTwo;
    private static Map<String, FeedObj> feedNutritionCatThree;

    // Standard Values
    private static Double standardWeightForCaw = 300D;
    private static Double standardTdnVariationFor50kg = 300D;
    private static Double maximumDMIntake = 2.5D;

    private static DataGeneratorHelper helper = new DataGeneratorHelper();

    public static void main(String args []) {

        standardNutritionThreeToThreePointFive = helper.getStandardNutritionThreeToThreePointFive();
        standardNutritionThreePointFiveToFour= helper.getStandardNutritionThreePointFiveToFour();
        standardNutritionFourToFourPointFive = helper.getStandardNutritionFourToFourPointFive();

        feedNutritionCatOne = helper.getFeedNutritionCatOne();
        feedNutritionCatTwo = helper.getFeedNutritionCatTwo();
        feedNutritionCatThree = helper.getFeedNutritionCatThree();

        // Out puts
        String bulkForageToGive = "";
        String supplementaryForageToGive = "";

        //Main Inputs
        Double bodyWeight = 200D;
        Double milkYield = 6D;
        Double fatPercentage = 3.5D;

        // Input
        List<String> selectedBulkForage = new ArrayList<>(Arrays.asList("co3","gunia"));

        //Input
        List<String> selectedSupplementary = new ArrayList<>(Arrays.asList("albezia", "ipil"));

        //Input
        List<String> concentrateForage = new ArrayList<>(Arrays.asList("ricebran"));

        List<Integer> trialSupplementaryForage = new ArrayList<>();
        addTrialValueToTrialSupplementaryForage(trialSupplementaryForage);

        MilkObj relatedMilkObj = getRelatedMilkObjFromTableData(milkYield, fatPercentage);

        Double tdnValue = relatedMilkObj.getTdn();

        Double bodyWeightDiff = bodyWeight - standardWeightForCaw;

        Double tdnValueForCow = tdnValue + bodyWeightDiff * ( standardTdnVariationFor50kg / 50 );

        String bulkForageKey = generateKeyForGivenData(selectedBulkForage);

        FeedObj feedObj = feedNutritionCatOne.get(bulkForageKey);

        Double relatedDM = feedObj.getDm();

        Double relatedTDN = feedObj.getTdn();

        Double eatableDM = bodyWeight * maximumDMIntake / 100 ;

        Double eatableBulkForageKG = eatableDM * 1000 / relatedDM;

        String supplementaryKey = generateKeyForGivenData(selectedSupplementary);
        FeedObj supplementaryFeed = feedNutritionCatTwo.get(supplementaryKey);

        Double concentrateAmount = 0D;
        int attempts = 0;
        Double trialBulkForage = 0D;

        String concentrateKey = "";

        for (Integer trialSupplementary : trialSupplementaryForage) {

            trialBulkForage = eatableBulkForageKG - trialSupplementary;

            Double totalTDN = ( trialBulkForage * relatedTDN ) + ( supplementaryFeed.getTdn() * trialSupplementary );

            if ( totalTDN - tdnValueForCow >= 0) {

                bulkForageToGive = trialBulkForage.toString();
                supplementaryForageToGive = trialSupplementary.toString();
                break;

            } else {

                if (attempts >= trialSupplementaryForage.size() - 1) {

                    bulkForageToGive = trialBulkForage.toString();
                    supplementaryForageToGive = trialSupplementary.toString();
                    concentrateKey = generateKeyForGivenData(concentrateForage);
                    FeedObj concentrateFeed = feedNutritionCatThree.get(concentrateKey);
                    concentrateAmount = (totalTDN - tdnValueForCow) / concentrateFeed.getTdn();
                    break;
                }
                attempts += 1;
            }
        }


        System.out.println(" Bulk Forage : " + bulkForageKey + " = " + round(Double.parseDouble(bulkForageToGive), 2) + " kg");
        System.out.println(" Supplementary Forage : " + supplementaryKey + " = " + round(Double.parseDouble(supplementaryForageToGive), 2) + " kg");
        System.out.println(" Concentrate : " + concentrateKey + " = " + round(concentrateAmount, 2) + " kg");


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

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    private static String generateKeyForGivenData(List<String> selectedBulkForage) {
        String bulkForageKey = "";

        if (selectedBulkForage != null && selectedBulkForage.size() == 1) {
            bulkForageKey = selectedBulkForage.get(0);

        } else if (selectedBulkForage.size() == 2) {
            bulkForageKey = selectedBulkForage.get(0) + "_" + selectedBulkForage.get(1);
        }
        return bulkForageKey;
    }

    private static MilkObj getRelatedMilkObjFromTableData(Double milkYield, Double fatPercentage) {

        MilkObj relatedMilkObj = null;

        if ( fatPercentage >= 3D && fatPercentage < 3.5D) {
            relatedMilkObj = standardNutritionThreeToThreePointFive.get(milkYield.intValue());
        } else if ( fatPercentage >= 3.5D && fatPercentage < 4D ) {
            relatedMilkObj = standardNutritionThreePointFiveToFour.get(milkYield.intValue());
        }else if ( fatPercentage >= 4D && fatPercentage < 4.5D ) {
            relatedMilkObj = standardNutritionFourToFourPointFive.get(milkYield.intValue());
        }
        return relatedMilkObj;
    }

    private static String getConcentrate(List<String> concentrateForage) {

        if (concentrateForage != null ) {

            if (concentrateForage.size() == 1) {
                return concentrateForage.get(0);
            } else if (concentrateForage.size() == 2) {
                return concentrateForage.get(1);
            }
        }
        return null;
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
