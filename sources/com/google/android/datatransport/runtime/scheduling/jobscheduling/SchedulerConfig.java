package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import androidx.annotation.RequiresApi;
import androidx.work.WorkRequest;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.d;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
@AutoValue
/* loaded from: classes2.dex */
public abstract class SchedulerConfig {

    /* loaded from: classes2.dex */
    public enum Flag {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.google.android.datatransport.runtime.x.a a;
        private Map<Priority, b> b = new HashMap();

        public a a(Priority priority, b bVar) {
            this.b.put(priority, bVar);
            return this;
        }

        public SchedulerConfig b() {
            Objects.requireNonNull(this.a, "missing required property: clock");
            if (this.b.keySet().size() >= Priority.values().length) {
                Map<Priority, b> map = this.b;
                this.b = new HashMap();
                return SchedulerConfig.d(this.a, map);
            }
            throw new IllegalStateException("Not all priorities have been configured");
        }

        public a c(com.google.android.datatransport.runtime.x.a aVar) {
            this.a = aVar;
            return this;
        }
    }

    @AutoValue
    /* loaded from: classes2.dex */
    public static abstract class b {

        @AutoValue.Builder
        /* loaded from: classes2.dex */
        public static abstract class a {
            public abstract b a();

            public abstract a b(long j2);

            public abstract a c(Set<Flag> set);

            public abstract a d(long j2);
        }

        public static a a() {
            d.b bVar = new d.b();
            bVar.c(Collections.emptySet());
            return bVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long b();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Set<Flag> c();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long d();
    }

    private long a(int i2, long j2) {
        int i3;
        return (long) (Math.pow(3.0d, i2 - 1) * j2 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j2 > 1 ? j2 : 2L) * i3)));
    }

    public static a b() {
        return new a();
    }

    static SchedulerConfig d(com.google.android.datatransport.runtime.x.a aVar, Map<Priority, b> map) {
        return new c(aVar, map);
    }

    public static SchedulerConfig f(com.google.android.datatransport.runtime.x.a aVar) {
        a b2 = b();
        Priority priority = Priority.DEFAULT;
        b.a a2 = b.a();
        a2.b(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        a2.d(AdvTimeUtils.MILLIS_OF_A_DAY);
        b2.a(priority, a2.a());
        Priority priority2 = Priority.HIGHEST;
        b.a a3 = b.a();
        a3.b(1000L);
        a3.d(AdvTimeUtils.MILLIS_OF_A_DAY);
        b2.a(priority2, a3.a());
        Priority priority3 = Priority.VERY_LOW;
        b.a a4 = b.a();
        a4.b(AdvTimeUtils.MILLIS_OF_A_DAY);
        a4.d(AdvTimeUtils.MILLIS_OF_A_DAY);
        a4.c(i(Flag.NETWORK_UNMETERED, Flag.DEVICE_IDLE));
        b2.a(priority3, a4.a());
        b2.c(aVar);
        return b2.b();
    }

    private static <T> Set<T> i(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }

    @RequiresApi(api = 21)
    private void j(JobInfo.Builder builder, Set<Flag> set) {
        if (set.contains(Flag.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(Flag.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(Flag.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    @RequiresApi(api = 21)
    public JobInfo.Builder c(JobInfo.Builder builder, Priority priority, long j2, int i2) {
        builder.setMinimumLatency(g(priority, j2, i2));
        j(builder, h().get(priority).c());
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract com.google.android.datatransport.runtime.x.a e();

    public long g(Priority priority, long j2, int i2) {
        long a2 = j2 - e().a();
        b bVar = h().get(priority);
        return Math.min(Math.max(a(i2, bVar.b()), a2), bVar.d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Map<Priority, b> h();
}
