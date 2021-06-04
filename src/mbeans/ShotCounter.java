package mbeans;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class ShotCounter extends NotificationBroadcasterSupport implements ShotCounterMBean {
    private int shots;
    private int misses;
    private int seqNum;
    private int missesRow;

    public ShotCounter() {
        this.shots = 0;
        this.misses = 0;
        this.seqNum = 0;
        this.misses = 0;
    }

    @Override
    public int getAllShots() {
        return shots;
    }

    @Override
    public int getAllMisses() {
        return misses;
    }
    public void increment(boolean hit) {
        shots++;
        if (!hit) {
            misses++;
            missesRow++;
            if (missesRow == 2) theSecondMiss();
        } else {
            missesRow = 0;
        }
    }

    public void theSecondMiss() {
        missesRow = 0;
        sendNotification(new Notification(
                "miss_detector",
                this,
                seqNum++,
                System.currentTimeMillis(),
                "You have missed twice!")
        );
    }
}
