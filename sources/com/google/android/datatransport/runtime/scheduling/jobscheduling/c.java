package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Map;
import java.util.Objects;
/* compiled from: AutoValue_SchedulerConfig.java */
/* loaded from: classes2.dex */
final class c extends SchedulerConfig {
    private final com.google.android.datatransport.runtime.x.a a;
    private final Map<Priority, SchedulerConfig.b> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.android.datatransport.runtime.x.a aVar, Map<Priority, SchedulerConfig.b> map) {
        Objects.requireNonNull(aVar, "Null clock");
        this.a = aVar;
        Objects.requireNonNull(map, "Null values");
        this.b = map;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    com.google.android.datatransport.runtime.x.a e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SchedulerConfig) {
            SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
            return this.a.equals(schedulerConfig.e()) && this.b.equals(schedulerConfig.h());
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    Map<Priority, SchedulerConfig.b> h() {
        return this.b;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.a + ", values=" + this.b + "}";
    }
}
