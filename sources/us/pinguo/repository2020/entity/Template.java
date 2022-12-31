package us.pinguo.repository2020.entity;

import java.util.List;
import kotlin.jvm.internal.s;
/* compiled from: UnityFilterItemTempleIndex.kt */
/* loaded from: classes6.dex */
public final class Template {
    private final List<Sources> horizontal;
    private final List<Sources> vertical;

    public Template(List<Sources> list, List<Sources> list2) {
        this.horizontal = list;
        this.vertical = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Template copy$default(Template template, List list, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = template.horizontal;
        }
        if ((i2 & 2) != 0) {
            list2 = template.vertical;
        }
        return template.copy(list, list2);
    }

    public final List<Sources> component1() {
        return this.horizontal;
    }

    public final List<Sources> component2() {
        return this.vertical;
    }

    public final Template copy(List<Sources> list, List<Sources> list2) {
        return new Template(list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Template) {
            Template template = (Template) obj;
            return s.c(this.horizontal, template.horizontal) && s.c(this.vertical, template.vertical);
        }
        return false;
    }

    public final List<Sources> getHorizontal() {
        return this.horizontal;
    }

    public final List<Sources> getVertical() {
        return this.vertical;
    }

    public int hashCode() {
        List<Sources> list = this.horizontal;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<Sources> list2 = this.vertical;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "Template(horizontal=" + this.horizontal + ", vertical=" + this.vertical + ')';
    }
}
