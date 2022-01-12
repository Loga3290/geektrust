package com.example.geektrust.util;

import com.example.geektrust.exception.WaterManagementException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static Double getLitres(String ratio, int totalWaterConsumed, int index) {
        List<Integer> ratios;
        Integer sum;
        try {
            ratios = Arrays.stream(ratio.split(":")).map(Integer::parseInt).collect(Collectors.toList());
            if (ratios.size() != 2) {
                throw new WaterManagementException("Invalid Ratio");
            }
            sum = ratios.stream().mapToInt(Integer::intValue).sum();
        }catch (Exception ex){
            throw new WaterManagementException("Invalid Ratio");
        }

        return Double.valueOf(Double.valueOf(totalWaterConsumed) / Double.valueOf(sum) * Double.valueOf(ratios.get(index)));
    }
}
