package com.mob.commons.b;

import android.content.Context;
import java.util.HashMap;
/* compiled from: FidsSDK.java */
/* loaded from: classes2.dex */
public class a {
    private static b a;

    public static synchronized HashMap<String, Object> a(Context context) {
        HashMap<String, Object> hashMap;
        synchronized (a.class) {
            hashMap = new HashMap<>();
        }
        return hashMap;
    }

    public static String b(Context context) {
        return null;
    }

    public static String c(Context context) {
        return null;
    }
}
