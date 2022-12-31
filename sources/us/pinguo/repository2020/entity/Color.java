package us.pinguo.repository2020.entity;

import java.util.List;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: SelfDefMakeupParam.kt */
/* loaded from: classes6.dex */
public final class Color implements NoProguard {
    private final List<String> colors;
    private final List<String> paths;

    public Color(List<String> list, List<String> list2) {
        this.colors = list;
        this.paths = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Color copy$default(Color color, List list, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = color.colors;
        }
        if ((i2 & 2) != 0) {
            list2 = color.paths;
        }
        return color.copy(list, list2);
    }

    public final List<String> component1() {
        return this.colors;
    }

    public final List<String> component2() {
        return this.paths;
    }

    public final Color copy(List<String> list, List<String> list2) {
        return new Color(list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Color) {
            Color color = (Color) obj;
            return s.c(this.colors, color.colors) && s.c(this.paths, color.paths);
        }
        return false;
    }

    public final List<String> getColors() {
        return this.colors;
    }

    public final List<String> getPaths() {
        return this.paths;
    }

    public int hashCode() {
        List<String> list = this.colors;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<String> list2 = this.paths;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "Color(colors=" + this.colors + ", paths=" + this.paths + ')';
    }
}
