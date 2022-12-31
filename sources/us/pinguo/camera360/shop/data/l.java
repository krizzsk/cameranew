package us.pinguo.camera360.shop.data;

import kotlin.jvm.internal.s;
import us.pinguo.camera360.shop.data.show.ShowPkg;
/* compiled from: StoreStat.kt */
/* loaded from: classes2.dex */
public final class l {
    private final int a;
    private final ShowPkg b;

    public l(int i2, ShowPkg showPkg) {
        s.h(showPkg, "showPkg");
        this.a = i2;
        this.b = showPkg;
    }

    public final int a() {
        return this.a;
    }

    public final ShowPkg b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            return this.a == lVar.a && s.c(this.b, lVar.b);
        }
        return false;
    }

    public int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public String toString() {
        return "StoreStatItem(indexPage=" + this.a + ", showPkg=" + this.b + ')';
    }
}
