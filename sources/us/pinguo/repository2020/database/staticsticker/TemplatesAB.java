package us.pinguo.repository2020.database.staticsticker;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StaticSticker.kt */
/* loaded from: classes6.dex */
public final class TemplatesAB implements NoProguard {
    private final String gid;
    private final String tid;

    public TemplatesAB(String str, String str2) {
        this.tid = str;
        this.gid = str2;
    }

    public static /* synthetic */ TemplatesAB copy$default(TemplatesAB templatesAB, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = templatesAB.tid;
        }
        if ((i2 & 2) != 0) {
            str2 = templatesAB.gid;
        }
        return templatesAB.copy(str, str2);
    }

    public final String component1() {
        return this.tid;
    }

    public final String component2() {
        return this.gid;
    }

    public final TemplatesAB copy(String str, String str2) {
        return new TemplatesAB(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TemplatesAB) {
            TemplatesAB templatesAB = (TemplatesAB) obj;
            return s.c(this.tid, templatesAB.tid) && s.c(this.gid, templatesAB.gid);
        }
        return false;
    }

    public final String getGid() {
        return this.gid;
    }

    public final String getTid() {
        return this.tid;
    }

    public int hashCode() {
        String str = this.tid;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.gid;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "TemplatesAB(tid=" + ((Object) this.tid) + ", gid=" + ((Object) this.gid) + ')';
    }
}
