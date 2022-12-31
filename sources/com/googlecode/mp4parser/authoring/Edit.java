package com.googlecode.mp4parser.authoring;
/* loaded from: classes2.dex */
public class Edit {
    private double mediaRate;
    private long mediaTime;
    private double segmentDuration;
    private long timeScale;

    public Edit(long j2, long j3, double d2, double d3) {
        this.timeScale = j3;
        this.segmentDuration = d3;
        this.mediaTime = j2;
        this.mediaRate = d2;
    }

    public double getMediaRate() {
        return this.mediaRate;
    }

    public long getMediaTime() {
        return this.mediaTime;
    }

    public double getSegmentDuration() {
        return this.segmentDuration;
    }

    public long getTimeScale() {
        return this.timeScale;
    }
}
