package us.pinguo.repository2020.database.background;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: BackgroundDisplay.kt */
/* loaded from: classes6.dex */
public final class BackgroundCategory implements NoProguard {
    private final String name;
    private final long off_time;
    private final long onsale_time;
    private final String[] pids;
    private final int priority;
    private final String tid;

    public BackgroundCategory(String tid, String name, String[] pids, int i2, long j2, long j3) {
        s.h(tid, "tid");
        s.h(name, "name");
        s.h(pids, "pids");
        this.tid = tid;
        this.name = name;
        this.pids = pids;
        this.priority = i2;
        this.onsale_time = j2;
        this.off_time = j3;
    }

    public final String component1() {
        return this.tid;
    }

    public final String component2() {
        return this.name;
    }

    public final String[] component3() {
        return this.pids;
    }

    public final int component4() {
        return this.priority;
    }

    public final long component5() {
        return this.onsale_time;
    }

    public final long component6() {
        return this.off_time;
    }

    public final BackgroundCategory copy(String tid, String name, String[] pids, int i2, long j2, long j3) {
        s.h(tid, "tid");
        s.h(name, "name");
        s.h(pids, "pids");
        return new BackgroundCategory(tid, name, pids, i2, j2, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(BackgroundCategory.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.database.background.BackgroundCategory");
            BackgroundCategory backgroundCategory = (BackgroundCategory) obj;
            return s.c(this.tid, backgroundCategory.tid) && s.c(this.name, backgroundCategory.name) && Arrays.equals(this.pids, backgroundCategory.pids) && this.priority == backgroundCategory.priority && this.onsale_time == backgroundCategory.onsale_time && this.off_time == backgroundCategory.off_time;
        }
        return false;
    }

    public final String getName() {
        return this.name;
    }

    public final long getOff_time() {
        return this.off_time;
    }

    public final long getOnsale_time() {
        return this.onsale_time;
    }

    public final String[] getPids() {
        return this.pids;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getTid() {
        return this.tid;
    }

    public int hashCode() {
        return (((((((((this.tid.hashCode() * 31) + this.name.hashCode()) * 31) + Arrays.hashCode(this.pids)) * 31) + this.priority) * 31) + c.a(this.onsale_time)) * 31) + c.a(this.off_time);
    }

    public final boolean isValid(long j2) {
        if (j2 != 0) {
            long j3 = this.onsale_time;
            if (j3 > 0) {
                long j4 = this.off_time;
                if (j4 > 0) {
                    long j5 = 1000;
                    if (j2 < j3 * j5 || j2 > j4 * j5) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public String toString() {
        return "BackgroundCategory(tid=" + this.tid + ", name=" + this.name + ", pids=" + Arrays.toString(this.pids) + ", priority=" + this.priority + ", onsale_time=" + this.onsale_time + ", off_time=" + this.off_time + ')';
    }
}
