package us.pinguo.repository2020.utils;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.jvm.internal.s;
import us.pinguo.util.v;
/* compiled from: SpUtils.kt */
/* loaded from: classes6.dex */
public final class o {
    public static final o a = new o();
    private static Context b;

    static {
        Context a2 = v.a();
        s.g(a2, "getAppContext()");
        b = a2;
    }

    private o() {
    }

    public static /* synthetic */ boolean b(o oVar, String str, boolean z, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            str2 = "c360_default_sp_filte";
        }
        return oVar.a(str, z, str2);
    }

    public static /* synthetic */ float d(o oVar, String str, float f2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            str2 = "c360_default_sp_filte";
        }
        return oVar.c(str, f2, str2);
    }

    public static /* synthetic */ int f(o oVar, String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            str2 = "c360_default_sp_filte";
        }
        return oVar.e(str, i2, str2);
    }

    public static /* synthetic */ long h(o oVar, String str, long j2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        if ((i2 & 4) != 0) {
            str2 = "c360_default_sp_filte";
        }
        return oVar.g(str, j2, str2);
    }

    public static /* synthetic */ String j(o oVar, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            str3 = "c360_default_sp_filte";
        }
        return oVar.i(str, str2, str3);
    }

    public static /* synthetic */ void l(o oVar, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "c360_default_sp_filte";
        }
        oVar.k(str, str2);
    }

    public static /* synthetic */ void n(o oVar, String str, boolean z, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = "c360_default_sp_filte";
        }
        oVar.m(str, z, str2);
    }

    public static /* synthetic */ void p(o oVar, String str, float f2, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = "c360_default_sp_filte";
        }
        oVar.o(str, f2, str2);
    }

    public static /* synthetic */ void r(o oVar, String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "c360_default_sp_filte";
        }
        oVar.q(str, i2, str2);
    }

    public static /* synthetic */ void t(o oVar, String str, long j2, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = "c360_default_sp_filte";
        }
        oVar.s(str, j2, str2);
    }

    public static /* synthetic */ void v(o oVar, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = "c360_default_sp_filte";
        }
        oVar.u(str, str2, str3);
    }

    public final boolean a(String key, boolean z, String file) {
        s.h(key, "key");
        s.h(file, "file");
        return b.getSharedPreferences(file, 0).getBoolean(key, z);
    }

    public final float c(String key, float f2, String file) {
        s.h(key, "key");
        s.h(file, "file");
        return b.getSharedPreferences(file, 0).getFloat(key, f2);
    }

    public final int e(String key, int i2, String file) {
        s.h(key, "key");
        s.h(file, "file");
        return b.getSharedPreferences(file, 0).getInt(key, i2);
    }

    public final long g(String key, long j2, String file) {
        s.h(key, "key");
        s.h(file, "file");
        return b.getSharedPreferences(file, 0).getLong(key, j2);
    }

    public final String i(String key, String str, String file) {
        s.h(key, "key");
        s.h(file, "file");
        return b.getSharedPreferences(file, 0).getString(key, str);
    }

    public final void k(String key, String file) {
        s.h(key, "key");
        s.h(file, "file");
        SharedPreferences prefs = b.getSharedPreferences(file, 0);
        s.g(prefs, "prefs");
        SharedPreferences.Editor editor = prefs.edit();
        s.g(editor, "editor");
        editor.remove(key);
        editor.apply();
    }

    public final void m(String key, boolean z, String file) {
        s.h(key, "key");
        s.h(file, "file");
        SharedPreferences prefs = b.getSharedPreferences(file, 0);
        s.g(prefs, "prefs");
        SharedPreferences.Editor editor = prefs.edit();
        s.g(editor, "editor");
        editor.putBoolean(key, z);
        editor.apply();
    }

    public final void o(String key, float f2, String file) {
        s.h(key, "key");
        s.h(file, "file");
        SharedPreferences prefs = b.getSharedPreferences(file, 0);
        s.g(prefs, "prefs");
        SharedPreferences.Editor editor = prefs.edit();
        s.g(editor, "editor");
        editor.putFloat(key, f2);
        editor.apply();
    }

    public final void q(String key, int i2, String file) {
        s.h(key, "key");
        s.h(file, "file");
        SharedPreferences prefs = b.getSharedPreferences(file, 0);
        s.g(prefs, "prefs");
        SharedPreferences.Editor editor = prefs.edit();
        s.g(editor, "editor");
        editor.putInt(key, i2);
        editor.apply();
    }

    public final void s(String key, long j2, String file) {
        s.h(key, "key");
        s.h(file, "file");
        SharedPreferences prefs = b.getSharedPreferences(file, 0);
        s.g(prefs, "prefs");
        SharedPreferences.Editor editor = prefs.edit();
        s.g(editor, "editor");
        editor.putLong(key, j2);
        editor.apply();
    }

    public final void u(String key, String str, String file) {
        s.h(key, "key");
        s.h(file, "file");
        SharedPreferences prefs = b.getSharedPreferences(file, 0);
        s.g(prefs, "prefs");
        SharedPreferences.Editor editor = prefs.edit();
        s.g(editor, "editor");
        editor.putString(key, str);
        editor.apply();
    }
}
