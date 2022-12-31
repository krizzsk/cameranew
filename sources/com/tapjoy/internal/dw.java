package com.tapjoy.internal;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes3.dex */
public final class dw {
    final HashMap a = new HashMap();
    final HashMap b = new HashMap();
    final HashMap c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    final HashSet f7383d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    final HashSet f7384e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    final HashSet f7385f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    final HashMap f7386g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    boolean f7387h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(cz czVar) {
        for (dq dqVar : czVar.b) {
            View view = (View) dqVar.get();
            if (view != null) {
                ArrayList arrayList = (ArrayList) this.c.get(view);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.c.put(view, arrayList);
                }
                arrayList.add(czVar.f7355f);
            }
        }
    }
}
