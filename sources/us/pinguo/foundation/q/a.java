package us.pinguo.foundation.q;

import android.content.Context;
import us.pinguo.foundation.base.e;
import us.pinguo.foundation.eventbus.PGEventBus;
import us.pinguo.foundation.eventbus.b;
import us.pinguo.foundation.r.d;
/* compiled from: NewFlagManager.java */
/* loaded from: classes4.dex */
public class a {
    public static void a(Context context) {
        us.pinguo.common.log.a.c("clear sticker new", new Object[0]);
        e.e(context, "pref_effect_red_key_effect_btn", false);
    }

    public static void b(Context context) {
        e.e(context, "pref_home_effect_red_key_new", false);
    }

    public static void c(Context context) {
        e.e(context, "pref_effect_red_key_shop_btn", false);
    }

    public static boolean d(Context context) {
        return e.a(context, "pref_effect_red_key_effect_btn", false);
    }

    public static boolean e(Context context) {
        return e.a(context, "pref_effect_red_key_shop_btn", false);
    }

    public static boolean f(Context context) {
        return e.a(context, "pref_home_effect_red_key_new", false) || e.a(context, "pref_home_sticker_red_key_new", false);
    }

    public static void g(Context context) {
        us.pinguo.common.log.a.m("redPoint", "redPoint setEffectNew", new Object[0]);
        e.e(context, "pref_home_effect_red_key_new", true);
        e.e(context, "pref_effect_red_key_effect_btn", true);
        e.e(context, "pref_effect_red_key_shop_btn", true);
        b bVar = new b();
        PGEventBus.getInstance().a(bVar);
        d.a().b(bVar);
    }

    public static void h(Context context) {
        us.pinguo.common.log.a.m("redPoint", "redPoint setEffectNew", new Object[0]);
        e.e(context, "pref_home_effect_red_key_new", false);
        e.e(context, "pref_effect_red_key_effect_btn", false);
        e.e(context, "pref_effect_red_key_shop_btn", false);
    }

    public static void i(Context context) {
        us.pinguo.common.log.a.c("set sticker new", new Object[0]);
        e.e(context, "pref_home_sticker_red_key_new", true);
        e.e(context, "pref_sticker_red_key_new", true);
        b bVar = new b();
        PGEventBus.getInstance().a(bVar);
        d.a().b(bVar);
    }
}
