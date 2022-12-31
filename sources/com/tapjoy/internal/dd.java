package com.tapjoy.internal;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class dd {
    private static dd c = new dd();
    public final ArrayList a = new ArrayList();
    public final ArrayList b = new ArrayList();

    private dd() {
    }

    public static dd a() {
        return c;
    }

    public final boolean b() {
        return this.b.size() > 0;
    }
}
