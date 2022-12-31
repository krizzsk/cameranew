package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class a {
    protected HashMap<String, b> a = new HashMap<>();

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public static class b {
        /* JADX WARN: Code restructure failed: missing block: B:44:0x013c, code lost:
            r13.a((java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x013f, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void call(java.lang.String r11, java.util.List<java.lang.String> r12, com.tencent.open.a.C0279a r13) {
            /*
                Method dump skipped, instructions count: 353
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.a.b.call(java.lang.String, java.util.List, com.tencent.open.a$a):void");
        }

        public boolean customCallback() {
            return false;
        }
    }

    public void a(b bVar, String str) {
        this.a.put(str, bVar);
    }

    public void a(String str, String str2, List<String> list, C0279a c0279a) {
        SLog.v("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                list.set(i2, URLDecoder.decode(list.get(i2), "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        b bVar = this.a.get(str);
        if (bVar != null) {
            SLog.d("openSDK_LOG.JsBridge", "call----");
            bVar.call(str2, list, c0279a);
            return;
        }
        SLog.d("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
        if (c0279a != null) {
            c0279a.a();
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0279a {
        protected WeakReference<WebView> a;
        protected long b;
        protected String c;

        public C0279a(WebView webView, long j2, String str) {
            this.a = new WeakReference<>(webView);
            this.b = j2;
            this.c = str;
        }

        public void a(Object obj) {
            String obj2;
            WebView webView = this.a.get();
            if (webView == null) {
                return;
            }
            if (obj instanceof String) {
                String replace = ((String) obj).replace("\\", "\\\\").replace("'", "\\'");
                obj2 = "'" + ((Object) replace) + "'";
            } else if (!(obj instanceof Number) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Double) && !(obj instanceof Float)) {
                obj2 = obj instanceof Boolean ? obj.toString() : "'undefined'";
            } else {
                obj2 = obj.toString();
            }
            String str = "javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':0,'result':" + obj2 + "});";
            webView.loadUrl(str);
            VdsAgent.loadUrl(webView, str);
        }

        public void a() {
            WebView webView = this.a.get();
            if (webView == null) {
                return;
            }
            String str = "javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':1,'result':'no such method'})";
            webView.loadUrl(str);
            VdsAgent.loadUrl(webView, str);
        }

        public void a(String str) {
            WebView webView = this.a.get();
            if (webView != null) {
                String str2 = "javascript:" + str;
                webView.loadUrl(str2);
                VdsAgent.loadUrl(webView, str2);
            }
        }
    }

    public boolean a(WebView webView, String str) {
        SLog.v("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str != null && Uri.parse(str).getScheme().equals("jsbridge")) {
            ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
            if (arrayList.size() < 6) {
                return false;
            }
            List<String> subList = arrayList.subList(4, arrayList.size() - 1);
            C0279a c0279a = new C0279a(webView, 4L, str);
            webView.getUrl();
            a((String) arrayList.get(2), (String) arrayList.get(3), subList, c0279a);
            return true;
        }
        return false;
    }
}
