package com.feed.staticData;

import com.feed.dto.FeedObj;
import com.feed.dto.MilkObj;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kasun on 7/16/16.
 */
public class DataGeneratorHelper {

    protected static Map<String, FeedObj> getFeedNutritionCatThree() {

        Map<String, FeedObj> feedNutrition = new HashMap<>();
        feedNutrition.put("coconut poonac", new FeedObj("coconut poonac", 683D, 923D));
        feedNutrition.put("rice bran", new FeedObj("rice bran", 628D, 884D));
        feedNutrition.put("rice bran_coconut poonac", new FeedObj("rice bran_coconut poonac", 655.5D, 903D));
        return feedNutrition;
    }

    protected static Map<String, FeedObj> getFeedNutritionCatTwo() {

        Map<String, FeedObj> feedNutrition = new HashMap<>();
        feedNutrition.put("gliricidia", new FeedObj("gliricidia", 142D, 226D));
        feedNutrition.put("ipil", new FeedObj("ipil", 154D, 227D));
        feedNutrition.put("albezia", new FeedObj("albezia", 227D, 353D));
        feedNutrition.put("gliricidia_ipil", new FeedObj("gliricidia_ipil", 148D, 226.5D));
        feedNutrition.put("gliricidia_albezia", new FeedObj("gliricidia_albezia", 184.5D, 289.5D));
        feedNutrition.put("albezia_ipil", new FeedObj("albezia_ipil", 190D, 290D));
        feedNutrition.put("gliricidia_albezia_ipil", new FeedObj("gliricidia_albezia_ipil", 174D, 268D));
        return feedNutrition;
    }

    protected static Map<String, FeedObj> getFeedNutritionCatOne() {

        Map<String, FeedObj> feedNutrition = new HashMap<>();
        feedNutrition.put("co3", new FeedObj("co3", 107D, 210D));
        feedNutrition.put("gunia", new FeedObj("gunia", 116D, 200D));
        feedNutrition.put("seteria", new FeedObj("seteria", 67D, 139D));
        feedNutrition.put("co3_gunia", new FeedObj("co3_gunia", 111.5D, 205D));
        feedNutrition.put("co3_seteria", new FeedObj("co3_seteria", 87D, 174.5D));
        feedNutrition.put("gunia_seteria", new FeedObj("gunia_seteria", 91.5D, 169.5D));
        feedNutrition.put("co3_gunia_seteria", new FeedObj("co3_gunia_seteria", 145D, 274.5D));
        return feedNutrition;
    }

    protected static Map<Integer, MilkObj> getStandardNutritionFourToFourPointFive() {

        Map<Integer, MilkObj> standardNutrition = new HashMap<>();

        standardNutrition.put(1, getMilkObj(1, 4030D, 520D));
        standardNutrition.put(2, getMilkObj(2, 4360D, 580D));
        standardNutrition.put(3, getMilkObj(3, 4690D, 640D));
        standardNutrition.put(4, getMilkObj(4, 3990D, 510D));
        standardNutrition.put(5, getMilkObj(5, 4220D, 560D));
        standardNutrition.put(6, getMilkObj(6, 4570D, 610D));
        standardNutrition.put(7, getMilkObj(7, 3990D, 510D));
        standardNutrition.put(8, getMilkObj(8, 4220D, 560D));
        standardNutrition.put(9, getMilkObj(9, 4570D, 610D));
        standardNutrition.put(10, getMilkObj(10, 3990D, 510D));
        standardNutrition.put(11, getMilkObj(11, 4220D, 560D));
        standardNutrition.put(12, getMilkObj(12, 4570D, 610D));
        standardNutrition.put(13, getMilkObj(13, 3990D, 510D));
        standardNutrition.put(14, getMilkObj(14, 4220D, 560D));

        return standardNutrition;
    }

    protected static Map<Integer, MilkObj> getStandardNutritionThreePointFiveToFour() {

        Map<Integer, MilkObj> standardNutrition = new HashMap<>();

        standardNutrition.put(1, getMilkObj(1, 4000D, 515D));
        standardNutrition.put(2, getMilkObj(2, 4300D, 570D));
        standardNutrition.put(3, getMilkObj(3, 4600D, 625D));
        standardNutrition.put(4, getMilkObj(4, 4900D, 680D));
        standardNutrition.put(5, getMilkObj(5, 5200D, 735D));
        standardNutrition.put(6, getMilkObj(6, 5500D, 790D));
        standardNutrition.put(7, getMilkObj(7, 5800D, 845D));
        standardNutrition.put(8, getMilkObj(8, 6100D, 900D));

        standardNutrition.put(10, getMilkObj(10, 6700D, 1010D));

        standardNutrition.put(12, getMilkObj(12, 7300D, 1120D));

        standardNutrition.put(14, getMilkObj(14, 7900D, 1230D));

        return standardNutrition;
    }

    protected static Map<Integer, MilkObj> getStandardNutritionThreeToThreePointFive() {

        Map<Integer, MilkObj> standardNutrition = new HashMap<>();

        standardNutrition.put(1, getMilkObj(1, 3990D, 510D));
        standardNutrition.put(2, getMilkObj(2, 4280D, 560D));
        standardNutrition.put(3, getMilkObj(3, 4570D, 610D));
        standardNutrition.put(4, getMilkObj(4, 4860D, 660D));
        standardNutrition.put(5, getMilkObj(5, 5150D, 710D));
        standardNutrition.put(6, getMilkObj(6, 5440D, 760D));
        standardNutrition.put(7, getMilkObj(7, 5730D, 810D));
        standardNutrition.put(8, getMilkObj(8, 6020D, 860D));

        standardNutrition.put(10, getMilkObj(10, 6600D, 960D));

        standardNutrition.put(12, getMilkObj(12, 7180D, 1060D));

        standardNutrition.put(14, getMilkObj(14, 7760D, 1160D));

        return standardNutrition;
    }

    private static MilkObj getMilkObj(int liters, double tdn, double dcp) {

        return new MilkObj(liters, tdn, dcp);
    }

}
