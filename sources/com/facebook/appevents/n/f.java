package com.facebook.appevents.n;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.GraphRequest;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.x;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.tapjoy.TJAdUnitConstants;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ViewOnClickListener.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class f implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    private static final Set<Integer> f2342e = new HashSet();
    @Nullable
    private View.OnClickListener a;
    private WeakReference<View> b;
    private WeakReference<View> c;

    /* renamed from: d  reason: collision with root package name */
    private String f2343d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewOnClickListener.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                f.a(this.a, this.b, new float[0]);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewOnClickListener.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        b(JSONObject jSONObject, String str, String str2) {
            this.a = jSONObject;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] o;
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                String lowerCase = x.s(com.facebook.f.f()).toLowerCase();
                float[] a = com.facebook.appevents.n.a.a(this.a, lowerCase);
                String c = com.facebook.appevents.n.a.c(this.b, f.b(f.this), lowerCase);
                if (a == null || (o = ModelManager.o(ModelManager.Task.MTML_APP_EVENT_PREDICTION, new float[][]{a}, new String[]{c})) == null) {
                    return;
                }
                String str = o[0];
                com.facebook.appevents.n.b.a(this.c, str);
                if (str.equals(us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER)) {
                    return;
                }
                f.a(str, this.b, a);
            } catch (Exception unused) {
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    private f(View view, View view2, String str) {
        this.a = com.facebook.appevents.codeless.internal.d.g(view);
        this.c = new WeakReference<>(view);
        this.b = new WeakReference<>(view2);
        this.f2343d = str.toLowerCase().replace("activity", "");
    }

    static /* synthetic */ void a(String str, String str2, float[] fArr) {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return;
        }
        try {
            f(str, str2, fArr);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
        }
    }

    static /* synthetic */ String b(f fVar) {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return null;
        }
        try {
            return fVar.f2343d;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(View view, View view2, String str) {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return;
        }
        try {
            int hashCode = view.hashCode();
            Set<Integer> set = f2342e;
            if (set.contains(Integer.valueOf(hashCode))) {
                return;
            }
            com.facebook.appevents.codeless.internal.d.r(view, new f(view, view2, str));
            set.add(Integer.valueOf(hashCode));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
        }
    }

    private void d(String str, String str2, JSONObject jSONObject) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            x.q0(new b(jSONObject, str2, str));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    private void e() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            View view = this.b.get();
            View view2 = this.c.get();
            if (view != null && view2 != null) {
                try {
                    String d2 = c.d(view2);
                    String b2 = com.facebook.appevents.n.b.b(view2, d2);
                    if (b2 == null || g(b2, d2)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("view", c.b(view, view2));
                    jSONObject.put("screenname", this.f2343d);
                    d(b2, d2, jSONObject);
                } catch (Exception unused) {
                }
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    private static void f(String str, String str2, float[] fArr) {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return;
        }
        try {
            if (d.f(str)) {
                new InternalAppEventsLogger(com.facebook.f.f()).h(str, str2);
            } else if (d.e(str)) {
                h(str, str2, fArr);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
        }
    }

    private static boolean g(String str, String str2) {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return false;
        }
        try {
            String d2 = com.facebook.appevents.n.b.d(str);
            if (d2 == null) {
                return false;
            }
            if (d2.equals(us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER)) {
                return true;
            }
            x.q0(new a(d2, str2));
            return true;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
            return false;
        }
    }

    private static void h(String str, String str2, float[] fArr) {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            try {
                bundle.putString(TJAdUnitConstants.PARAM_PLACEMENT_NAME, str);
                JSONObject jSONObject = new JSONObject();
                StringBuilder sb = new StringBuilder();
                for (float f2 : fArr) {
                    sb.append(f2);
                    sb.append(",");
                }
                jSONObject.put("dense", sb.toString());
                jSONObject.put("button_text", str2);
                bundle.putString("metadata", jSONObject.toString());
                GraphRequest K = GraphRequest.K(null, String.format(Locale.US, "%s/suggested_events", com.facebook.f.g()), null, null);
                K.Z(bundle);
                K.g();
            } catch (JSONException unused) {
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
        }
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            View.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            e();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }
}
