package com.growingio.android.sdk.utils;

import android.os.Handler;
import android.os.SystemClock;
/* loaded from: classes2.dex */
public class TimerToggler implements Runnable {
    private final Runnable mAction;
    private long mDelayTime;
    private boolean mFirstTimeDelay;
    private long mFirstToggleTime;
    private final Handler mHandler;
    private long mMaxDelayTime;

    /* loaded from: classes2.dex */
    public static class Builder {
        private Runnable action;
        private long delayTime = 50;
        private long maxDelayTime = 600;
        private boolean firstTimeDelay = true;

        public Builder(Runnable runnable) {
            this.action = runnable;
        }

        public TimerToggler build() {
            TimerToggler timerToggler = new TimerToggler(this.action);
            timerToggler.mMaxDelayTime = this.maxDelayTime;
            timerToggler.mDelayTime = this.delayTime;
            timerToggler.mFirstTimeDelay = this.firstTimeDelay;
            return timerToggler;
        }

        public Builder delayTime(long j2) {
            this.delayTime = j2;
            return this;
        }

        public Builder firstTimeDelay(boolean z) {
            this.firstTimeDelay = z;
            return this;
        }

        public Builder maxDelayTime(long j2) {
            this.maxDelayTime = j2;
            return this;
        }
    }

    public void reset() {
        this.mFirstToggleTime = -1L;
        this.mHandler.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        takeAction();
    }

    void takeAction() {
        this.mHandler.removeCallbacks(this);
        this.mFirstToggleTime = 0L;
        this.mAction.run();
    }

    public void toggle() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mDelayTime == 0) {
            takeAction();
            return;
        }
        long j2 = this.mFirstToggleTime;
        if (j2 == -1 && !this.mFirstTimeDelay) {
            takeAction();
        } else if (j2 > 0 && uptimeMillis - j2 >= this.mMaxDelayTime) {
            takeAction();
        } else {
            if (j2 <= 0) {
                this.mFirstToggleTime = uptimeMillis;
            }
            this.mHandler.removeCallbacks(this);
            this.mHandler.postAtTime(this, Math.min(this.mFirstToggleTime + this.mMaxDelayTime, uptimeMillis + this.mDelayTime));
        }
    }

    private TimerToggler(Runnable runnable) {
        this.mFirstToggleTime = -1L;
        this.mHandler = new Handler();
        this.mAction = runnable;
    }
}
