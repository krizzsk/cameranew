package com.airbnb.lottie.w;

import android.util.Log;
import com.airbnb.lottie.j;
import java.util.HashSet;
import java.util.Set;
/* compiled from: LogcatLogger.java */
/* loaded from: classes.dex */
public class c implements j {
    private static final Set<String> a = new HashSet();

    @Override // com.airbnb.lottie.j
    public void a(String str) {
        b(str, null);
    }

    @Override // com.airbnb.lottie.j
    public void b(String str, Throwable th) {
        Set<String> set = a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        set.add(str);
    }

    public void c(String str, Throwable th) {
        if (com.airbnb.lottie.d.a) {
            Log.d("LOTTIE", str, th);
        }
    }

    @Override // com.airbnb.lottie.j
    public void debug(String str) {
        c(str, null);
    }

    @Override // com.airbnb.lottie.j
    public void error(String str, Throwable th) {
        if (com.airbnb.lottie.d.a) {
            Log.d("LOTTIE", str, th);
        }
    }
}
