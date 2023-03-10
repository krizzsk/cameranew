package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyConstants;
import com.tapjoy.internal.gj;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes3.dex */
public final class ga {
    private static final ga b;
    private static ga c;
    public final fy a = new fy();

    /* renamed from: d  reason: collision with root package name */
    private Context f7554d;

    static {
        ga gaVar = new ga();
        b = gaVar;
        c = gaVar;
    }

    ga() {
    }

    public static ga a() {
        return c;
    }

    public static fy b() {
        return c.a;
    }

    public final SharedPreferences c() {
        return this.f7554d.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);
    }

    public final synchronized void a(Context context) {
        if (context != null) {
            if (this.f7554d == null) {
                this.f7554d = context;
                SharedPreferences c2 = c();
                String string = c().getString(TapjoyConstants.PREF_SERVER_PROVIDED_CONFIGURATIONS, null);
                if (string != null) {
                    try {
                        bn b2 = bn.b(string);
                        try {
                            Map d2 = b2.d();
                            b2.close();
                            this.a.a(d2);
                        } catch (Throwable th) {
                            b2.close();
                            throw th;
                        }
                    } catch (Exception unused) {
                        c2.edit().remove(TapjoyConstants.PREF_SERVER_PROVIDED_CONFIGURATIONS).apply();
                    }
                }
                Observer observer = new Observer() { // from class: com.tapjoy.internal.ga.1
                    @Override // java.util.Observer
                    public final void update(Observable observable, Object obj) {
                        Object obj2;
                        gf.a(ga.this.a.a("usage_tracking_enabled", false));
                        Iterator it = ga.this.a.b.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            Object a = ((gj.a) it.next()).a("usage_tracking_exclude");
                            if (a != null && List.class.isInstance(a)) {
                                obj2 = List.class.cast(a);
                                break;
                            }
                        }
                        gf.a((Collection) obj2);
                    }
                };
                this.a.addObserver(observer);
                observer.update(this.a, null);
            }
        }
    }
}
