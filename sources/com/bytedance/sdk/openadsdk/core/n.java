package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.utils.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: InteractionManager.java */
/* loaded from: classes.dex */
public class n {
    private final com.bytedance.sdk.openadsdk.core.d.h a;
    private d.a.a.a.a.a.b b;
    private final Context c;

    /* renamed from: d  reason: collision with root package name */
    private final TTNativeAd f1685d;

    /* renamed from: e  reason: collision with root package name */
    private List<View> f1686e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private String f1687f;

    /* renamed from: g  reason: collision with root package name */
    private TTNativeAd.AdInteractionListener f1688g;

    public n(Context context, TTNativeAd tTNativeAd, com.bytedance.sdk.openadsdk.core.d.h hVar, String str) {
        this.f1687f = "embeded_ad";
        this.f1685d = tTNativeAd;
        this.a = hVar;
        this.c = context;
        this.f1687f = str;
        if (hVar.x() == 4) {
            this.b = d.a.a.a.a.a.c.a(context, hVar, this.f1687f);
        }
    }

    public void a(View view, int i2) {
        TTNativeAd.AdInteractionListener adInteractionListener = this.f1688g;
        if (adInteractionListener != null) {
            adInteractionListener.onAdCreativeClick(view, this.f1685d);
        }
    }

    public void a(@NonNull final ViewGroup viewGroup, List<View> list, List<View> list2, @Nullable List<View> list3, @Nullable View view, final TTNativeAd.AdInteractionListener adInteractionListener) {
        this.f1688g = adInteractionListener;
        this.f1686e = list;
        com.bytedance.sdk.openadsdk.c.d.a(this.a);
        EmptyView a = a(viewGroup);
        if (a == null) {
            a = new EmptyView(this.c, viewGroup);
            viewGroup.addView(a);
        }
        a.a();
        a.setRefClickViews(list2);
        a.setRefCreativeViews(list3);
        Context context = this.c;
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.a;
        String str = this.f1687f;
        com.bytedance.sdk.openadsdk.core.a.b bVar = new com.bytedance.sdk.openadsdk.core.a.b(context, hVar, str, ab.a(str));
        bVar.a(viewGroup);
        bVar.b(view);
        bVar.a(this.b);
        bVar.a(this.f1685d);
        bVar.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.core.n.1
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view2, int i2) {
                TTNativeAd.AdInteractionListener adInteractionListener2 = adInteractionListener;
                if (adInteractionListener2 != null) {
                    adInteractionListener2.onAdClicked(view2, n.this.f1685d);
                }
            }
        });
        Context context2 = this.c;
        com.bytedance.sdk.openadsdk.core.d.h hVar2 = this.a;
        String str2 = this.f1687f;
        com.bytedance.sdk.openadsdk.core.a.a aVar = new com.bytedance.sdk.openadsdk.core.a.a(context2, hVar2, str2, ab.a(str2));
        aVar.a(viewGroup);
        aVar.b(view);
        aVar.a(this.b);
        aVar.a(this.f1685d);
        aVar.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.core.n.2
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view2, int i2) {
                TTNativeAd.AdInteractionListener adInteractionListener2 = adInteractionListener;
                if (adInteractionListener2 != null) {
                    adInteractionListener2.onAdCreativeClick(view2, n.this.f1685d);
                }
            }
        });
        a.a(list2, bVar);
        a.a(list3, aVar);
        a.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.core.n.3
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view2) {
                HashMap hashMap = new HashMap();
                if (n.this.f1686e != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (View view3 : n.this.f1686e) {
                        if (view3 != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("width", view3.getWidth());
                                jSONObject.put("height", view3.getHeight());
                                jSONObject.put("alpha", view3.getAlpha());
                            } catch (Throwable unused) {
                            }
                            jSONArray.put(jSONObject);
                        }
                    }
                    hashMap.put("image_view", jSONArray.toString());
                }
                if (viewGroup != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("width", viewGroup.getWidth());
                        jSONObject2.put("height", viewGroup.getHeight());
                        jSONObject2.put("alpha", viewGroup.getAlpha());
                    } catch (Throwable unused2) {
                    }
                    hashMap.put("root_view", jSONObject2.toString());
                }
                com.bytedance.sdk.openadsdk.c.d.a(n.this.c, n.this.a, n.this.f1687f, hashMap);
                TTNativeAd.AdInteractionListener adInteractionListener2 = adInteractionListener;
                if (adInteractionListener2 != null) {
                    adInteractionListener2.onAdShow(n.this.f1685d);
                }
                if (n.this.a.R()) {
                    ab.a(n.this.a, view2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
            }
        });
        a.setNeedCheckingShow(true);
    }

    private EmptyView a(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }
}
