package us.pinguo.repository2020.entity;

import java.util.List;
import kotlin.jvm.internal.s;
/* compiled from: UnityFilterItemTempleIndex.kt */
/* loaded from: classes6.dex */
public final class Sources {
    private final List<Source> source;
    private final Float sourceAspect;

    public Sources(List<Source> list, Float f2) {
        this.source = list;
        this.sourceAspect = f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Sources copy$default(Sources sources, List list, Float f2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = sources.source;
        }
        if ((i2 & 2) != 0) {
            f2 = sources.sourceAspect;
        }
        return sources.copy(list, f2);
    }

    public final List<Source> component1() {
        return this.source;
    }

    public final Float component2() {
        return this.sourceAspect;
    }

    public final Sources copy(List<Source> list, Float f2) {
        return new Sources(list, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Sources) {
            Sources sources = (Sources) obj;
            return s.c(this.source, sources.source) && s.c(this.sourceAspect, sources.sourceAspect);
        }
        return false;
    }

    public final List<Source> getSource() {
        return this.source;
    }

    public final Float getSourceAspect() {
        return this.sourceAspect;
    }

    public int hashCode() {
        List<Source> list = this.source;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Float f2 = this.sourceAspect;
        return hashCode + (f2 != null ? f2.hashCode() : 0);
    }

    public String toString() {
        return "Sources(source=" + this.source + ", sourceAspect=" + this.sourceAspect + ')';
    }
}
