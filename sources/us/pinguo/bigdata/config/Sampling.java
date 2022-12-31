package us.pinguo.bigdata.config;

import kotlin.jvm.internal.s;
/* compiled from: SamplingStrategy.kt */
/* loaded from: classes3.dex */
public final class Sampling {
    private final String element;
    private final String evtId;
    private final Strategy strategy;

    public Sampling(String str, String str2, Strategy strategy) {
        this.evtId = str;
        this.element = str2;
        this.strategy = strategy;
    }

    public static /* synthetic */ Sampling copy$default(Sampling sampling, String str, String str2, Strategy strategy, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sampling.evtId;
        }
        if ((i2 & 2) != 0) {
            str2 = sampling.element;
        }
        if ((i2 & 4) != 0) {
            strategy = sampling.strategy;
        }
        return sampling.copy(str, str2, strategy);
    }

    public final String component1() {
        return this.evtId;
    }

    public final String component2() {
        return this.element;
    }

    public final Strategy component3() {
        return this.strategy;
    }

    public final Sampling copy(String str, String str2, Strategy strategy) {
        return new Sampling(str, str2, strategy);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Sampling) {
            Sampling sampling = (Sampling) obj;
            return s.c(this.evtId, sampling.evtId) && s.c(this.element, sampling.element) && s.c(this.strategy, sampling.strategy);
        }
        return false;
    }

    public final String getElement() {
        return this.element;
    }

    public final String getEvtId() {
        return this.evtId;
    }

    public final Strategy getStrategy() {
        return this.strategy;
    }

    public int hashCode() {
        String str = this.evtId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.element;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Strategy strategy = this.strategy;
        return hashCode2 + (strategy != null ? strategy.hashCode() : 0);
    }

    public String toString() {
        return "Sampling(evtId=" + ((Object) this.evtId) + ", element=" + ((Object) this.element) + ", strategy=" + this.strategy + ')';
    }
}
