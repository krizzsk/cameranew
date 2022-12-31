package com.mob.tools.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
@SuppressLint({"MissingPermission"})
/* loaded from: classes3.dex */
public class LHelper {
    private static LHelper instance;

    private LHelper() {
    }

    public static LHelper getInstance() {
        if (instance == null) {
            synchronized (LHelper.class) {
                if (instance == null) {
                    instance = new LHelper();
                }
            }
        }
        return instance;
    }

    public Location getLocation(Context context) {
        return getLocation(context, 0);
    }

    public Location getLocation(Context context, int i2, int i3, boolean z, boolean z2) {
        return null;
    }

    public Location getLocation(Context context, int i2) {
        return getLocation(context, i2, 0);
    }

    public Location getLocation(Context context, int i2, int i3) {
        return getLocation(context, i2, i3, true);
    }

    public Location getLocation(Context context, int i2, int i3, boolean z) {
        return getLocation(context, i2, i3, z, false);
    }
}
