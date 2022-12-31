package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.tapjoy.TJAdUnitConstants;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class H5JavaScriptInterface {
    private static HashSet<Integer> a = new HashSet<>();
    private String b = null;
    private Thread c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f7897d = null;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f7898e = null;

    private H5JavaScriptInterface() {
    }

    private static a a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a();
                String string2 = jSONObject.getString("projectRoot");
                aVar.a = string2;
                if (string2 == null) {
                    return null;
                }
                String string3 = jSONObject.getString("context");
                aVar.b = string3;
                if (string3 == null) {
                    return null;
                }
                String string4 = jSONObject.getString("url");
                aVar.c = string4;
                if (string4 == null) {
                    return null;
                }
                String string5 = jSONObject.getString(TJAdUnitConstants.String.USER_AGENT);
                aVar.f7899d = string5;
                if (string5 == null) {
                    return null;
                }
                String string6 = jSONObject.getString(IjkMediaMeta.IJKM_KEY_LANGUAGE);
                aVar.f7900e = string6;
                if (string6 == null) {
                    return null;
                }
                String string7 = jSONObject.getString("name");
                aVar.f7901f = string7;
                if (string7 == null || string7.equals("null") || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int indexOf = string.indexOf("\n");
                if (indexOf < 0) {
                    x.d("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                aVar.f7903h = string.substring(indexOf + 1);
                String substring = string.substring(0, indexOf);
                aVar.f7902g = substring;
                int indexOf2 = substring.indexOf(":");
                if (indexOf2 > 0) {
                    aVar.f7902g = aVar.f7902g.substring(indexOf2 + 1);
                }
                aVar.f7904i = jSONObject.getString("file");
                if (aVar.f7901f == null) {
                    return null;
                }
                long j2 = jSONObject.getLong("lineNumber");
                aVar.f7905j = j2;
                if (j2 < 0) {
                    return null;
                }
                long j3 = jSONObject.getLong("columnNumber");
                aVar.f7906k = j3;
                if (j3 < 0) {
                    return null;
                }
                x.a("H5 crash information is following: ", new Object[0]);
                x.a("[projectRoot]: " + aVar.a, new Object[0]);
                x.a("[context]: " + aVar.b, new Object[0]);
                x.a("[url]: " + aVar.c, new Object[0]);
                x.a("[userAgent]: " + aVar.f7899d, new Object[0]);
                x.a("[language]: " + aVar.f7900e, new Object[0]);
                x.a("[name]: " + aVar.f7901f, new Object[0]);
                x.a("[message]: " + aVar.f7902g, new Object[0]);
                x.a("[stacktrace]: \n" + aVar.f7903h, new Object[0]);
                x.a("[file]: " + aVar.f7904i, new Object[0]);
                x.a("[lineNumber]: " + aVar.f7905j, new Object[0]);
                x.a("[columnNumber]: " + aVar.f7906k, new Object[0]);
                return aVar;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static H5JavaScriptInterface getInstance(CrashReport.WebViewInterface webViewInterface) {
        String str = null;
        if (webViewInterface == null || a.contains(Integer.valueOf(webViewInterface.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        a.add(Integer.valueOf(webViewInterface.hashCode()));
        Thread currentThread = Thread.currentThread();
        h5JavaScriptInterface.c = currentThread;
        if (currentThread != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for (int i2 = 2; i2 < currentThread.getStackTrace().length; i2++) {
                StackTraceElement stackTraceElement = currentThread.getStackTrace()[i2];
                if (!stackTraceElement.toString().contains("crashreport")) {
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
            str = sb.toString();
        }
        h5JavaScriptInterface.f7897d = str;
        HashMap hashMap = new HashMap();
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) webViewInterface.getContentDescription());
        hashMap.put("[WebView] ContentDescription", sb2.toString());
        h5JavaScriptInterface.f7898e = hashMap;
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        x.d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            x.d("Payload from JS is null.", new Object[0]);
            return;
        }
        String a2 = z.a(str.getBytes());
        String str2 = this.b;
        if (str2 != null && str2.equals(a2)) {
            x.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.b = a2;
        x.d("Handling JS exception ...", new Object[0]);
        a a3 = a(str);
        if (a3 == null) {
            x.d("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        String str3 = a3.a;
        if (str3 != null) {
            linkedHashMap2.put("[JS] projectRoot", str3);
        }
        String str4 = a3.b;
        if (str4 != null) {
            linkedHashMap2.put("[JS] context", str4);
        }
        String str5 = a3.c;
        if (str5 != null) {
            linkedHashMap2.put("[JS] url", str5);
        }
        String str6 = a3.f7899d;
        if (str6 != null) {
            linkedHashMap2.put("[JS] userAgent", str6);
        }
        String str7 = a3.f7904i;
        if (str7 != null) {
            linkedHashMap2.put("[JS] file", str7);
        }
        long j2 = a3.f7905j;
        if (j2 != 0) {
            linkedHashMap2.put("[JS] lineNumber", Long.toString(j2));
        }
        linkedHashMap.putAll(linkedHashMap2);
        linkedHashMap.putAll(this.f7898e);
        linkedHashMap.put("Java Stack", this.f7897d);
        Thread thread = this.c;
        if (a3 != null) {
            InnerApi.postH5CrashAsync(thread, a3.f7901f, a3.f7902g, a3.f7903h, linkedHashMap);
        }
    }
}
