import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String dataFile = "./src/7_14_2019.txt";

        int maxCount = 0;
        List<RadioSample> radioSampleList = new ArrayList<>();
        List<RadioSample> radioSampleListToDisplay = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(dataFile));) {
            while(scanner.hasNextLine()) {
                String tempData = scanner.nextLine();
                if(tempData.contains("Every Minute")) {
                    //TODO: This regex was found on this StackOverflow answer: https://stackoverflow.com/questions/7488643/how-to-convert-comma-separated-string-to-list
                    List<String> tempDataArray = Arrays.asList(tempData.split("\\s*,\\s*"));

                    String tempDate = tempData.substring(0, tempData.indexOf(" "));
                    int tempCount = Integer.parseInt(tempDataArray.get(tempDataArray.size()-1));

                    if(tempCount > maxCount) {
                        maxCount = tempCount;
                    }


                    RadioSample tempRadioSample = new RadioSample(tempDate, tempCount);
                    radioSampleList.add(tempRadioSample);

                }
            }
        }

        //loop over array and find values that are within the range
        //should this be a method?
            for (RadioSample sample : radioSampleList) {
                int tempSampleCount = sample.getCount();
                int minRange = maxCount - 5;
                int maxRange = maxCount + 5;

                if (tempSampleCount >= minRange && tempSampleCount <= maxRange) {
                    radioSampleListToDisplay.add(sample);
                }

            }

        System.out.printf("Date");
        System.out.printf(" ".repeat(20));
        System.out.printf("Counts per minute");
        System.out.println();
        System.out.println("_".repeat(45));

        //should this also be a method?
        for (RadioSample sampleToDisplay: radioSampleListToDisplay) {
            System.out.printf(sampleToDisplay.getDate());
            System.out.printf(" ".repeat(20));

            System.out.println(sampleToDisplay.getCount());

        }
    }
}
