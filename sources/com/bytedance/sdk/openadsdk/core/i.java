package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.ab;
/* compiled from: H5AdInteractionManager.java */
/* loaded from: classes.dex */
public class i {
    private final Context a;
    private final com.bytedance.sdk.openadsdk.core.d.h b;
    private d.a.a.a.a.a.b c;

    /* renamed from: d  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.nativeexpress.e f1671d;

    /* renamed from: e  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.nativeexpress.d f1672e;

    /* renamed from: f  reason: collision with root package name */
    private View f1673f;

    /* renamed from: g  reason: collision with root package name */
    private String f1674g;

    public i(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, View view) {
        this.f1674g = "rewarded_video";
        this.b = hVar;
        this.a = context;
        this.f1673f = view;
        this.f1674g = ab.b(ab.c(hVar.M()));
        if (hVar.x() == 4) {
            this.c = d.a.a.a.a.a.c.a(context, hVar, this.f1674g);
        }
        String str = this.f1674g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context, hVar, str, ab.a(str));
        this.f1671d = eVar;
        eVar.a(this.f1673f);
        this.f1671d.a(this.c);
        String str2 = this.f1674g;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context, hVar, str2, ab.a(str2));
        this.f1672e = dVar;
        dVar.a(this.f1673f);
        this.f1672e.a(this.c);
    }

    public void a(int i2, com.bytedance.sdk.openadsdk.core.d.f fVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar;
        if (i2 == -1 || fVar == null) {
            return;
        }
        int i3 = fVar.a;
        int i4 = fVar.b;
        int i5 = fVar.c;
        int i6 = fVar.f1574d;
        if (i2 != 1) {
            if (i2 == 2 && (dVar = this.f1672e) != null) {
                dVar.a(fVar);
                this.f1672e.a(this.f1673f, i3, i4, i5, i6);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = this.f1671d;
        if (eVar != null) {
            eVar.a(fVar);
            this.f1671d.a(this.f1673f, i3, i4, i5, i6);
        }
    }
}
