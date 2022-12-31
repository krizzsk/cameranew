package com.facebook.core.internal.logging.dumpsys;

import android.annotation.SuppressLint;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebViewDumpHelper.java */
@SuppressLint({"NewApi", "StringFormatUse", "DefaultLocale", "BadMethodUse-java.lang.String.length"})
/* loaded from: classes.dex */
public final class c {
    private final Set<b> a = new HashSet();
    private final Map<String, String> b = new HashMap();

    /* compiled from: WebViewDumpHelper.java */
    /* loaded from: classes.dex */
    class a implements ValueCallback<String> {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            c.this.b.put(this.a.a, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WebViewDumpHelper.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: f  reason: collision with root package name */
        private static final int[] f2424f = new int[2];
        public final String a;
        public final int b;
        public final int c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2425d;

        /* renamed from: e  reason: collision with root package name */
        public final int f2426e;

        public b(WebView webView) {
            this.a = String.format("%s{%s}", webView.getClass().getName(), Integer.toHexString(webView.hashCode()));
            int[] iArr = f2424f;
            webView.getLocationOnScreen(iArr);
            this.b = iArr[0];
            this.c = iArr[1];
            this.f2425d = webView.getWidth();
            this.f2426e = webView.getHeight();
        }
    }

    private static String c(b bVar, String str) {
        String replace = str.replace("\\u003C", "<").replace("\\n", "").replace("\\\"", "\"");
        return String.format("<html id=\"%s\" data-rect=\"%d,%d,%d,%d\">%s</html>", bVar.a, Integer.valueOf(bVar.b), Integer.valueOf(bVar.c), Integer.valueOf(bVar.f2425d), Integer.valueOf(bVar.f2426e), replace.substring(1, replace.length() - 1));
    }

    public void b(PrintWriter printWriter) {
        try {
            for (b bVar : this.a) {
                String str = this.b.get(bVar.a);
                if (str != null) {
                    printWriter.print("WebView HTML for ");
                    printWriter.print(bVar);
                    printWriter.println(":");
                    printWriter.println(c(bVar, str));
                }
            }
        } catch (Exception unused) {
        }
        this.a.clear();
        this.b.clear();
    }

    public void d(WebView webView) {
        b bVar = new b(webView);
        this.a.add(bVar);
        webView.evaluateJavascript(String.format("(function() {  try {    const leftOf = %d;    const topOf = %d;    const density = %f;    const elements = Array.from(document.querySelectorAll('body, body *'));    for (const el of elements) {      const rect = el.getBoundingClientRect();      const left = Math.round(leftOf + rect.left * density);      const top = Math.round(topOf + rect.top * density);      const width = Math.round(rect.width * density);      const height = Math.round(rect.height * density);      el.setAttribute('data-rect', `${left},${top},${width},${height}`);      const style = window.getComputedStyle(el);      const hidden = style.display === 'none' || style.visibility !== 'visible' || el.getAttribute('hidden') === 'true';      const disabled = el.disabled || el.getAttribute('aria-disabled') === 'true';      const focused = el === document.activeElement;      if (hidden || disabled || focused) {        el.setAttribute('data-flag', `${hidden ? 'H' : ''}${disabled ? 'D' : ''}${focused ? 'F' : ''}`);      } else {        el.removeAttribute('data-flag');      }    }    document.activeElement.setAttribute('focused', 'true');    const doc = document.cloneNode(true);    for (const el of Array.from(doc.querySelectorAll('script, link'))) {      el.remove();    }    for (const el of Array.from(doc.querySelectorAll('*'))) {      el.removeAttribute('class');    }    return doc.getElementsByTagName('body')[0].outerHTML.trim();  } catch (e) {    return 'Failed: ' + e;  }})();", Integer.valueOf(bVar.b), Integer.valueOf(bVar.c), Float.valueOf(webView.getResources().getDisplayMetrics().scaledDensity)), new a(bVar));
    }
}
