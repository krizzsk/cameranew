package com.pinguo.album.i.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import us.pinguo.foundation.f;
import us.pinguo.foundation.j;
/* compiled from: BlobCacheManager.java */
/* loaded from: classes3.dex */
public class b {
    private static HashMap<String, a> a = new HashMap<>();
    private static boolean b = false;

    public static a a(Context context, String str, int i2, int i3, int i4) {
        a aVar;
        File externalCacheDir;
        String str2;
        a aVar2;
        synchronized (a) {
            if (!b) {
                c(context);
                b = true;
            }
            aVar = a.get(str);
            if (aVar == null) {
                if (context.getExternalCacheDir() != null) {
                    str2 = externalCacheDir.getAbsolutePath() + "/" + str;
                } else {
                    str2 = b() + "/" + str;
                }
                try {
                    aVar2 = new a(str2, i2, i3, false, i4);
                } catch (IOException e2) {
                    e = e2;
                }
                try {
                    a.put(str, aVar2);
                    aVar = aVar2;
                } catch (IOException e3) {
                    e = e3;
                    aVar = aVar2;
                    us.pinguo.common.log.a.e("Cannot instantiate cache!", e);
                    return aVar;
                }
            }
        }
        return aVar;
    }

    public static String b() {
        return j.e().k("pref_camera_save_path_key", f.b());
    }

    private static void c(Context context) {
        File externalCacheDir;
        String str;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int i2 = 0;
        try {
            i2 = defaultSharedPreferences.getInt("cache-up-to-date", 0);
        } catch (Throwable unused) {
        }
        if (i2 != 0) {
            return;
        }
        defaultSharedPreferences.edit().putInt("cache-up-to-date", 1).apply();
        if (context.getExternalCacheDir() != null) {
            str = externalCacheDir.getAbsolutePath() + "/";
        } else {
            str = b() + "/";
        }
        a.w(str + "imgcache");
        a.w(str + "rev_geocoding");
        a.w(str + "bookmark");
    }
}
