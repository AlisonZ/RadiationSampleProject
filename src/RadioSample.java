public class RadioSample {
    private String date;
    private int count;


    public RadioSample(String dateTime, int countsPerMin) {
        date = dateTime;
        count = countsPerMin;
    }

    public String getDate() {
        return date;
    }

    public int getCount() {
        return count;
    }
}
