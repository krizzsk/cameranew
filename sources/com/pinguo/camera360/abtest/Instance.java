package com.pinguo.camera360.abtest;

import java.util.Collection;
import java.util.List;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: ABTestDataModel.kt */
/* loaded from: classes3.dex */
public final class Instance implements NoProguard {
    private long endTime;
    private float percent;
    private final List<Plan> plan;
    private long startTime;
    private final String tid;
    private final String tname;

    public Instance(String str, String str2, float f2, List<Plan> list, long j2, long j3) {
        this.tname = str;
        this.tid = str2;
        this.percent = f2;
        this.plan = list;
        this.startTime = j2;
        this.endTime = j3;
        this.percent = 0.0f;
        this.startTime = 0L;
        this.endTime = 0L;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final float getPercent() {
        return this.percent;
    }

    public final List<Plan> getPlan() {
        return this.plan;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final String getTid() {
        return this.tid;
    }

    public final String getTname() {
        return this.tname;
    }

    public final boolean isOK() {
        List<Plan> list;
        boolean z;
        if (this.tid != null) {
            float f2 = this.percent;
            if (f2 < 1.0E-7f || f2 > 1.0f || (list = this.plan) == null) {
                return false;
            }
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (Plan plan : list) {
                    if (!plan.isOK()) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            return z;
        }
        return false;
    }

    public final void setEndTime(long j2) {
        this.endTime = j2;
    }

    public final void setPercent(float f2) {
        this.percent = f2;
    }

    public final void setStartTime(long j2) {
        this.startTime = j2;
    }
}
