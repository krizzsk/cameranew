package us.pinguo.user.util;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.jvm.internal.s;
import us.pinguo.inspire.Inspire;
/* compiled from: PreferencesUtil.kt */
/* loaded from: classes6.dex */
public final class h {
    public static final h a = new h();

    private h() {
    }

    private final SharedPreferences a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("preferences", 0);
        s.g(sharedPreferences, "context.getSharedPrefere…AME,Context.MODE_PRIVATE)");
        return sharedPreferences;
    }

    public final boolean b() {
        Context a2 = Inspire.a();
        s.g(a2, "getAppContext()");
        return a(a2).getBoolean("key_has_shown_filter_delete_hint", false);
    }

    public final boolean c(Context context) {
        s.h(context, "context");
        return a(context).getBoolean("key_is_show_privacy_dialog", true);
    }

    public final void d() {
        Context a2 = Inspire.a();
        s.g(a2, "getAppContext()");
        SharedPreferences.Editor edit = a(a2).edit();
        edit.putBoolean("key_has_shown_filter_delete_hint", true);
        edit.apply();
    }

    public final void e(Context context, boolean z) {
        s.h(context, "context");
        SharedPreferences.Editor edit = a(context).edit();
        edit.putBoolean("key_is_show_privacy_dialog", z);
        edit.apply();
    }
}
