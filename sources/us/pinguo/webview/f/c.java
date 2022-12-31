package us.pinguo.webview.f;

import android.text.TextUtils;
import com.tapjoy.TJAdUnitConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.webview.PGJsWebView;
import us.pinguo.webview.f.h.e0;
import us.pinguo.webview.f.h.q;
/* compiled from: PGQueueManager.java */
/* loaded from: classes6.dex */
public class c {
    private us.pinguo.webview.g.b a;
    private us.pinguo.webview.a b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private ThreadPoolExecutor f12496d;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<PGJsWebView> f12497e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PGQueueManager.java */
    /* loaded from: classes6.dex */
    public class b implements Runnable {
        private String a;

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.c) {
                return;
            }
            c.this.h(this.a);
        }

        private b(String str) {
            this.a = null;
            this.a = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PGQueueManager.java */
    /* renamed from: us.pinguo.webview.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0464c implements Runnable {
        private us.pinguo.webview.f.b a;

        @Override // java.lang.Runnable
        public void run() {
            List<us.pinguo.webview.f.h.a> k2;
            if (c.this.c) {
                return;
            }
            if (c.this.b.a(this.a.a())) {
                c.this.a.b(this.a);
            } else if ("checkJsApi".equals(this.a.a())) {
                us.pinguo.webview.f.b bVar = this.a;
                if (bVar instanceof us.pinguo.webview.f.h.c) {
                    us.pinguo.webview.f.h.c cVar = (us.pinguo.webview.f.h.c) bVar;
                    q b = cVar.b();
                    if (b != null) {
                        k2 = c.k(b.a(), c.this.b);
                    } else {
                        k2 = Collections.emptyList();
                    }
                    PGJsWebView pGJsWebView = (PGJsWebView) c.this.f12497e.get();
                    if (pGJsWebView != null) {
                        e0 e0Var = new e0();
                        e0Var.b(k2);
                        cVar.d(pGJsWebView, e0Var);
                    }
                }
            }
        }

        private RunnableC0464c(us.pinguo.webview.f.b bVar) {
            this.a = null;
            this.a = bVar;
        }
    }

    public c(PGJsWebView pGJsWebView, us.pinguo.webview.a aVar, us.pinguo.webview.g.b bVar) {
        this.a = null;
        this.b = null;
        this.c = false;
        this.f12496d = null;
        this.f12497e = null;
        this.a = bVar;
        this.b = aVar;
        this.c = false;
        this.f12496d = us.pinguo.webview.e.a(3, 4);
        this.f12497e = new WeakReference<>(pGJsWebView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str) {
        String string;
        String string2;
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                try {
                    string = jSONObject.getString("handlerName");
                    string2 = jSONObject.getString(TJAdUnitConstants.String.CALLBACK_ID);
                } catch (Exception unused) {
                    this.a.a("error json", jSONObject.toString());
                }
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    us.pinguo.webview.f.b i3 = i(string, string2, jSONObject.getJSONObject("data"));
                    if (i3 != null) {
                        this.f12496d.execute(new RunnableC0464c(i3));
                    } else {
                        this.a.a("error json", jSONObject.toString());
                    }
                }
                this.a.a("error json", jSONObject.toString());
            }
        } catch (Exception unused2) {
            this.a.a("error json", str);
        }
    }

    private us.pinguo.webview.f.b i(String str, String str2, JSONObject jSONObject) {
        us.pinguo.webview.f.a aVar;
        us.pinguo.webview.f.b b2 = this.b.b(str);
        if (b2 == null && "checkJsApi".equals(str)) {
            b2 = new us.pinguo.webview.f.h.c();
        }
        if (b2 != null) {
            b2.e(str2);
            b2.f(str);
            try {
                aVar = b2.c(jSONObject);
            } catch (JSONException e2) {
                us.pinguo.common.log.a.f(e2);
                aVar = null;
            }
            if (aVar == null) {
                PGJsWebView pGJsWebView = this.f12497e.get();
                if (pGJsWebView != null) {
                    try {
                        f.b(pGJsWebView, str2, new e(10300, "json error").a());
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            b2.g(aVar);
            return b2;
        }
        PGJsWebView pGJsWebView2 = this.f12497e.get();
        if (pGJsWebView2 != null) {
            try {
                f.b(pGJsWebView2, str2, new e(10300, "web不支持此函数").a());
            } catch (Exception unused2) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<us.pinguo.webview.f.h.a> k(List<String> list, us.pinguo.webview.a aVar) {
        if (list != null && !list.isEmpty() && aVar != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(new us.pinguo.webview.f.h.a(str, aVar.a(str) || "checkJsApi".equals(str)));
                }
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public void g() {
        this.f12496d.getQueue().clear();
        this.c = true;
    }

    public void j(String str) {
        this.f12496d.execute(new b(str));
    }
}
