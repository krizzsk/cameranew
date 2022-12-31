package com.ironsource.mediationsdk.model;

import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: ProviderSettingsHolder.java */
/* loaded from: classes2.dex */
public class r {
    private static r b;
    private ArrayList<l> a = new ArrayList<>();

    private r() {
    }

    public static synchronized r e() {
        r rVar;
        synchronized (r.class) {
            if (b == null) {
                b = new r();
            }
            rVar = b;
        }
        return rVar;
    }

    public void a(l lVar) {
        if (lVar != null) {
            this.a.add(lVar);
        }
    }

    public boolean b(String str) {
        Iterator<l> it = this.a.iterator();
        while (it.hasNext()) {
            if (it.next().l().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void c() {
        Iterator<l> it = this.a.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.t() && !TextUtils.isEmpty(next.m())) {
                l d2 = d(next.j());
                next.v(IronSourceUtils.T(next.b(), d2.b()));
                next.B(IronSourceUtils.T(next.h(), d2.h()));
                next.F(IronSourceUtils.T(next.o(), d2.o()));
                next.y(IronSourceUtils.T(next.d(), d2.d()));
            }
        }
    }

    public l d(String str) {
        Iterator<l> it = this.a.iterator();
        while (it.hasNext()) {
            l next = it.next();
            if (next.l().equals(str)) {
                return next;
            }
        }
        l lVar = new l(str);
        a(lVar);
        return lVar;
    }
}
