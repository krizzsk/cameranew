package us.pinguo.camera360.shop.data.m;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.s;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.camera360.shop.data.show.ShowTopic;
/* compiled from: UnityCacheManager.kt */
/* loaded from: classes4.dex */
public final class b {
    private final List<ShowTopic> a;
    private final Map<String, ShowPkg> b;

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends ShowTopic> topics, Map<String, ? extends ShowPkg> pkgMap) {
        s.h(topics, "topics");
        s.h(pkgMap, "pkgMap");
        this.a = topics;
        this.b = pkgMap;
    }

    public final Map<String, ShowPkg> a() {
        return this.b;
    }

    public final List<ShowTopic> b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return s.c(this.a, bVar.a) && s.c(this.b, bVar.b);
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "ProcessInfo(topics=" + this.a + ", pkgMap=" + this.b + ')';
    }
}
