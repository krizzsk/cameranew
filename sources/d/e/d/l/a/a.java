package d.e.d.l.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.iab.omid.library.ironsrc.adsession.CreativeType;
import com.iab.omid.library.ironsrc.adsession.ImpressionType;
import com.iab.omid.library.ironsrc.adsession.Owner;
import com.iab.omid.library.ironsrc.adsession.b;
import com.iab.omid.library.ironsrc.adsession.c;
import com.iab.omid.library.ironsrc.adsession.d;
import com.iab.omid.library.ironsrc.adsession.e;
import com.ironsource.sdk.WPAD.AdViewsManager;
import com.ironsource.sdk.utils.f;
import org.json.JSONObject;
/* compiled from: OMIDManager.java */
/* loaded from: classes2.dex */
public class a {
    private static b b;
    private static final e a = e.a("Ironsrc", "7");
    private static boolean c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OMIDManager.java */
    /* renamed from: d.e.d.l.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0299a {
        public boolean a;
        public Owner b;
        public Owner c;

        /* renamed from: d  reason: collision with root package name */
        public String f8562d;

        /* renamed from: e  reason: collision with root package name */
        public ImpressionType f8563e;

        /* renamed from: f  reason: collision with root package name */
        public CreativeType f8564f;

        /* renamed from: g  reason: collision with root package name */
        public String f8565g;

        public static C0299a a(JSONObject jSONObject) throws IllegalArgumentException {
            C0299a c0299a = new C0299a();
            c0299a.a = jSONObject.optBoolean("isolateVerificationScripts", false);
            String optString = jSONObject.optString("impressionOwner", "");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    c0299a.b = Owner.valueOf(optString.toUpperCase());
                    String optString2 = jSONObject.optString("videoEventsOwner", "");
                    if (!TextUtils.isEmpty(optString)) {
                        try {
                            c0299a.c = Owner.valueOf(optString2.toUpperCase());
                            c0299a.f8562d = jSONObject.optString("customReferenceData", "");
                            c0299a.f8564f = b(jSONObject);
                            c0299a.f8563e = c(jSONObject);
                            c0299a.f8565g = f(jSONObject);
                            d(jSONObject);
                            e(jSONObject);
                            return c0299a;
                        } catch (IllegalArgumentException unused) {
                            throw new IllegalArgumentException(String.format("%s | Invalid OMID videoEventsOwner", optString2));
                        }
                    }
                    throw new IllegalArgumentException(String.format("Missing OMID videoEventsOwner", optString2));
                } catch (IllegalArgumentException unused2) {
                    throw new IllegalArgumentException(String.format("%s | Invalid OMID impressionOwner", optString));
                }
            }
            throw new IllegalArgumentException(String.format("Missing OMID impressionOwner", optString));
        }

        private static CreativeType b(JSONObject jSONObject) throws IllegalArgumentException {
            CreativeType[] values;
            String optString = jSONObject.optString("creativeType", "");
            if (!TextUtils.isEmpty(optString)) {
                for (CreativeType creativeType : CreativeType.values()) {
                    if (optString.equalsIgnoreCase(creativeType.toString())) {
                        return creativeType;
                    }
                }
                throw new IllegalArgumentException(String.format("Missing OMID creativeType", optString));
            }
            throw new IllegalArgumentException(String.format("Missing OMID creativeType", optString));
        }

        private static ImpressionType c(JSONObject jSONObject) throws IllegalArgumentException {
            ImpressionType[] values;
            String optString = jSONObject.optString("impressionType", "");
            if (!TextUtils.isEmpty(optString)) {
                for (ImpressionType impressionType : ImpressionType.values()) {
                    if (optString.equalsIgnoreCase(impressionType.toString())) {
                        return impressionType;
                    }
                }
                throw new IllegalArgumentException(String.format("Missing OMID creativeType", optString));
            }
            throw new IllegalArgumentException(String.format("Missing OMID creativeType", optString));
        }

        private static boolean d(JSONObject jSONObject) throws IllegalArgumentException {
            return jSONObject.optBoolean("signalLoaded", false);
        }

        private static Owner e(JSONObject jSONObject) throws IllegalArgumentException {
            String optString = jSONObject.optString("videoEventsOwner", "");
            Owner owner = Owner.NONE;
            try {
                return Owner.valueOf(optString.toUpperCase());
            } catch (IllegalArgumentException unused) {
                return owner;
            }
        }

        private static String f(JSONObject jSONObject) throws IllegalArgumentException {
            String optString = jSONObject.optString("adViewId", "");
            if (TextUtils.isEmpty(optString)) {
                throw new IllegalArgumentException(String.format("Missing OMID webview id", optString));
            }
            return optString;
        }
    }

    public static void a(Context context) throws IllegalArgumentException {
        if (c) {
            return;
        }
        d.d.a.a.a.a.a(context);
        c = true;
    }

    private static void b() throws IllegalStateException {
        if (c) {
            if (b == null) {
                throw new IllegalStateException("OMID Session has not started");
            }
            return;
        }
        throw new IllegalStateException("OMID has not been activated");
    }

    private static b c(C0299a c0299a, WebView webView) throws IllegalArgumentException {
        b a2 = b.a(c.a(c0299a.f8564f, c0299a.f8563e, c0299a.b, c0299a.c, c0299a.a), d.a(a, webView, null, c0299a.f8562d));
        a2.c(webView);
        return a2;
    }

    public static void d() throws IllegalStateException {
        b();
        b.b();
        b = null;
    }

    public static com.ironsource.sdk.data.d e() {
        com.ironsource.sdk.data.d dVar = new com.ironsource.sdk.data.d();
        dVar.h(f.c("omidVersion"), f.c(d.d.a.a.a.a.b()));
        dVar.h(f.c("omidPartnerName"), f.c("Ironsrc"));
        dVar.h(f.c("omidPartnerVersion"), f.c("7"));
        return dVar;
    }

    public static void f(JSONObject jSONObject) throws IllegalArgumentException, IllegalStateException {
        b();
        com.iab.omid.library.ironsrc.adsession.a a2 = com.iab.omid.library.ironsrc.adsession.a.a(b);
        try {
            if (((Boolean) jSONObject.get("signalLoaded")).booleanValue()) {
                a2.c();
            }
        } catch (Exception unused) {
        }
        a2.b();
    }

    public static void g(C0299a c0299a, WebView webView) throws IllegalStateException, IllegalArgumentException {
        if (c) {
            if (b == null) {
                if (!TextUtils.isEmpty(c0299a.f8565g) && (webView = AdViewsManager.getInstance().a(c0299a.f8565g)) == null) {
                    throw new IllegalStateException("webview not found");
                }
                b c2 = c(c0299a, webView);
                b = c2;
                c2.d();
                return;
            }
            throw new IllegalStateException("OMID Session has already started");
        }
        throw new IllegalStateException("OMID has not been activated");
    }

    public static void h(JSONObject jSONObject, WebView webView) throws IllegalStateException, IllegalArgumentException {
        g(C0299a.a(jSONObject), webView);
    }
}
