package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.net.Uri;
import android.text.TextUtils;
/* compiled from: UrlUtils.java */
/* loaded from: classes.dex */
public class e {

    /* compiled from: UrlUtils.java */
    /* loaded from: classes.dex */
    public enum a {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");
        

        /* renamed from: e  reason: collision with root package name */
        private String f1931e;

        a(String str) {
            this.f1931e = str;
        }

        public String a() {
            return this.f1931e;
        }
    }

    public static a a(String str) {
        a aVar;
        a aVar2 = a.IMAGE;
        if (TextUtils.isEmpty(str)) {
            return aVar2;
        }
        try {
            String path = Uri.parse(str).getPath();
            if (path != null) {
                if (path.endsWith(".css")) {
                    aVar = a.CSS;
                } else if (path.endsWith(".js")) {
                    aVar = a.JS;
                } else if (path.endsWith(".jpg") || path.endsWith(".gif") || path.endsWith(".png") || path.endsWith(".jpeg") || path.endsWith(".webp") || path.endsWith(".bmp") || path.endsWith(".ico") || !path.endsWith(".html")) {
                    return aVar2;
                } else {
                    aVar = a.HTML;
                }
                return aVar;
            }
            return aVar2;
        } catch (Throwable unused) {
            return aVar2;
        }
    }
}
