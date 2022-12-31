package us.pinguo.bigdata.config;

import kotlin.jvm.internal.s;
/* compiled from: SamplingStrategy.kt */
/* loaded from: classes3.dex */
public final class Strategy {
    private final String name;
    private final Float threshold;

    public Strategy(String str, Float f2) {
        this.name = str;
        this.threshold = f2;
    }

    public static /* synthetic */ Strategy copy$default(Strategy strategy, String str, Float f2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = strategy.name;
        }
        if ((i2 & 2) != 0) {
            f2 = strategy.threshold;
        }
        return strategy.copy(str, f2);
    }

    public final String component1() {
        return this.name;
    }

    public final Float component2() {
        return this.threshold;
    }

    public final Strategy copy(String str, Float f2) {
        return new Strategy(str, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Strategy) {
            Strategy strategy = (Strategy) obj;
            return s.c(this.name, strategy.name) && s.c(this.threshold, strategy.threshold);
        }
        return false;
    }

    public final String getName() {
        return this.name;
    }

    public final Float getThreshold() {
        return this.threshold;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Float f2 = this.threshold;
        return hashCode + (f2 != null ? f2.hashCode() : 0);
    }

    public String toString() {
        return "Strategy(name=" + ((Object) this.name) + ", threshold=" + this.threshold + ')';
    }
}
