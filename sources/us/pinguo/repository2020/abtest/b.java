package us.pinguo.repository2020.abtest;

import kotlin.jvm.internal.s;
/* compiled from: CloudAlbumABManager.kt */
/* loaded from: classes6.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    private final String a() {
        String o = ABTestManager.a.o("cloudalbum_entrance");
        return o == null ? "cloudalbum_entrance_default" : o;
    }

    public final boolean b() {
        return s.c(a(), "cloudalbum_entrance_hide");
    }
}
