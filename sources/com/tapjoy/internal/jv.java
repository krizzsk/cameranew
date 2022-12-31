package com.tapjoy.internal;

import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class jv {
    public static HashSet a(Iterator it) {
        HashSet hashSet = new HashSet();
        while (it.hasNext()) {
            hashSet.add(it.next());
        }
        return hashSet;
    }
}
