package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Objects;
import java.util.Set;
/* compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
/* loaded from: classes2.dex */
final class d extends SchedulerConfig.b {
    private final long a;
    private final long b;
    private final Set<SchedulerConfig.Flag> c;

    /* compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
    /* loaded from: classes2.dex */
    static final class b extends SchedulerConfig.b.a {
        private Long a;
        private Long b;
        private Set<SchedulerConfig.Flag> c;

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b a() {
            String str = "";
            if (this.a == null) {
                str = " delta";
            }
            if (this.b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new d(this.a.longValue(), this.b.longValue(), this.c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a b(long j2) {
            this.a = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a c(Set<SchedulerConfig.Flag> set) {
            Objects.requireNonNull(set, "Null flags");
            this.c = set;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a d(long j2) {
            this.b = Long.valueOf(j2);
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    long b() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    Set<SchedulerConfig.Flag> c() {
        return this.c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    long d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SchedulerConfig.b) {
            SchedulerConfig.b bVar = (SchedulerConfig.b) obj;
            return this.a == bVar.b() && this.b == bVar.d() && this.c.equals(bVar.c());
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.a;
        long j3 = this.b;
        return this.c.hashCode() ^ ((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.a + ", maxAllowedDelay=" + this.b + ", flags=" + this.c + "}";
    }

    private d(long j2, long j3, Set<SchedulerConfig.Flag> set) {
        this.a = j2;
        this.b = j3;
        this.c = set;
    }
}
