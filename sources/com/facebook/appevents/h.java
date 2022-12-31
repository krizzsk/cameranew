package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.internal.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: SessionEventsState.java */
/* loaded from: classes.dex */
class h {

    /* renamed from: f  reason: collision with root package name */
    private static final String f2297f = "h";
    private List<AppEvent> a = new ArrayList();
    private List<AppEvent> b = new ArrayList();
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private com.facebook.internal.b f2298d;

    /* renamed from: e  reason: collision with root package name */
    private String f2299e;

    public h(com.facebook.internal.b bVar, String str) {
        this.f2298d = bVar;
        this.f2299e = str;
    }

    private void g(GraphRequest graphRequest, Context context, int i2, JSONArray jSONArray, boolean z) {
        JSONObject jSONObject;
        try {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                jSONObject = AppEventsLoggerUtility.a(AppEventsLoggerUtility.GraphAPIActivityType.CUSTOM_APP_EVENTS, this.f2298d, this.f2299e, z, context);
                if (this.c > 0) {
                    jSONObject.put("num_skipped_events", i2);
                }
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
            }
            graphRequest.X(jSONObject);
            Bundle y = graphRequest.y();
            if (y == null) {
                y = new Bundle();
            }
            String jSONArray2 = jSONArray.toString();
            if (jSONArray2 != null) {
                y.putString("custom_events", jSONArray2);
                graphRequest.b0(jSONArray2);
            }
            graphRequest.Z(y);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    public synchronized void a(AppEvent appEvent) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        if (this.a.size() + this.b.size() >= e()) {
            this.c++;
        } else {
            this.a.add(appEvent);
        }
    }

    public synchronized void b(boolean z) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        if (z) {
            this.a.addAll(this.b);
        }
        this.b.clear();
        this.c = 0;
    }

    public synchronized int c() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return 0;
        }
        return this.a.size();
    }

    public synchronized List<AppEvent> d() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return null;
        }
        List<AppEvent> list = this.a;
        this.a = new ArrayList();
        return list;
    }

    protected int e() {
        return com.facebook.internal.instrument.e.a.c(this) ? 0 : 1000;
    }

    public int f(GraphRequest graphRequest, Context context, boolean z, boolean z2) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return 0;
        }
        try {
            synchronized (this) {
                int i2 = this.c;
                com.facebook.appevents.k.a.d(this.a);
                this.b.addAll(this.a);
                this.a.clear();
                JSONArray jSONArray = new JSONArray();
                for (AppEvent appEvent : this.b) {
                    if (appEvent.isChecksumValid()) {
                        if (z || !appEvent.getIsImplicit()) {
                            jSONArray.put(appEvent.getJSONObject());
                        }
                    } else {
                        String str = f2297f;
                        x.Y(str, "Event with invalid checksum: " + appEvent.toString());
                    }
                }
                if (jSONArray.length() == 0) {
                    return 0;
                }
                g(graphRequest, context, i2, jSONArray, z2);
                return jSONArray.length();
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return 0;
        }
    }
}
