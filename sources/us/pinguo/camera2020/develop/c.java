package us.pinguo.camera2020.develop;

import kotlin.jvm.internal.s;
/* compiled from: StickerTestUtil.kt */
/* loaded from: classes2.dex */
public final class c {
    private final String a;
    private final a b;

    public final a a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return s.c(this.a, cVar.a) && s.c(this.b, cVar.b);
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        a aVar = this.b;
        return hashCode + (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "StickerDisplayTest(itemId=" + ((Object) this.a) + ", i18N=" + this.b + ')';
    }
}
