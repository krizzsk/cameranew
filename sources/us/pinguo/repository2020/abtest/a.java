package us.pinguo.repository2020.abtest;

import kotlin.jvm.internal.s;
/* compiled from: BeautyDataABManager.kt */
/* loaded from: classes6.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public final String a() {
        String o = ABTestManager.a.o("android_edit_portrait_listing");
        return o == null ? "the_big_six" : o;
    }

    public final boolean b() {
        String a2 = a();
        return s.c("new_portrait_makeup_list", a2) || s.c("new_portrait_makeup_smooth", a2);
    }

    public final boolean c() {
        return s.c("the_big_six", a());
    }
}
