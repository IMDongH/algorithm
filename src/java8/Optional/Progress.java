package java8.Optional;

import java.time.Duration;

public class Progress {
    private Duration studyDuration;
    private boolean finished;

    public Progress(Duration studyDuration, boolean finished) {
        this.studyDuration = studyDuration;
        this.finished = finished;
    }
}
