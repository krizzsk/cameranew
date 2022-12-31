package com.airbnb.lottie;

import androidx.collection.ArraySet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* compiled from: PerformanceTracker.java */
/* loaded from: classes.dex */
public class p {
    private boolean a = false;
    private final Set<a> b = new ArraySet();
    private final Map<String, com.airbnb.lottie.w.f> c = new HashMap();

    /* compiled from: PerformanceTracker.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(float f2);
    }

    public void a(String str, float f2) {
        if (this.a) {
            com.airbnb.lottie.w.f fVar = this.c.get(str);
            if (fVar == null) {
                fVar = new com.airbnb.lottie.w.f();
                this.c.put(str, fVar);
            }
            fVar.a(f2);
            if (str.equals("__container")) {
                for (a aVar : this.b) {
                    aVar.a(f2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        this.a = z;
    }
}
