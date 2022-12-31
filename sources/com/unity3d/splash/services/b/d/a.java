package com.unity3d.splash.services.b.d;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a {
    private static Set a = Collections.synchronizedSet(new LinkedHashSet());

    public static void a(com.unity3d.splash.a aVar) {
        if (aVar == null || a.contains(aVar)) {
            return;
        }
        a.add(aVar);
    }
}
