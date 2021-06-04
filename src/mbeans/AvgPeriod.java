package mbeans;

import java.util.ArrayList;
import java.util.List;

//todo refactor names
public class AvgPeriod implements AvgPeriodMBean{
    private long time;
    private List<Long> periods;

    public AvgPeriod() {
        time = System.currentTimeMillis();
        periods = new ArrayList<>();
    }

    @Override
    public void addPoint() {
        long currentShotTime = System.currentTimeMillis();
        periods.add(currentShotTime - time);
        time = currentShotTime;
    }

    @Override
    public String getAverageTime() {
        long time = 0;

        for (long period : periods) {
            time += period;
        }

        return time / (periods.size()) + " milliseconds";
    }
}
