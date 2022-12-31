package com.tapjoy.internal;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import javax.annotation.concurrent.ThreadSafe;
import us.pinguo.common.network.HttpRequest;
@ThreadSafe
/* loaded from: classes3.dex */
public final class ce implements cd {
    private final String a;
    private final URL b;

    public ce(String str, URL url) {
        this.a = str;
        this.b = url;
    }

    @Override // com.tapjoy.internal.cd
    public final Object a(ca caVar) {
        URL url = new URL(this.b, caVar.c());
        String b = caVar.b();
        if ("GET".equals(b) || "DELETE".equals(b)) {
            Map e2 = caVar.e();
            if (!e2.isEmpty()) {
                url = new URL(url, url.getPath() + "?" + fk.a(e2));
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) fj.a(url);
        httpURLConnection.setRequestMethod(b);
        httpURLConnection.setRequestProperty(HttpRequest.HEADER_USER_AGENT, this.a);
        for (Map.Entry entry : caVar.a().entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), entry.getValue().toString());
        }
        if (!"GET".equals(b) && !"DELETE".equals(b)) {
            if (!"POST".equals(b) && !"PUT".equals(b)) {
                throw new IllegalArgumentException("Unknown method: " + b);
            }
            String d2 = caVar.d();
            if (d2 == null) {
                fk.a(httpURLConnection, HttpRequest.CONTENT_TYPE_FORM, fk.a(caVar.e()), jm.c);
            } else if (HttpRequest.CONTENT_TYPE_JSON.equals(d2)) {
                fk.a(httpURLConnection, "application/json; charset=utf-8", bh.a((Object) caVar.e()), jm.c);
            } else {
                throw new IllegalArgumentException("Unknown content type: " + d2);
            }
        }
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode != 200 && responseCode != 201 && responseCode != 409) {
            throw new IOException("Unexpected status code: " + httpURLConnection.getResponseCode());
        }
        InputStream inputStream = httpURLConnection.getInputStream();
        URI uri = null;
        try {
            try {
                uri = httpURLConnection.getURL().toURI();
            } finally {
                inputStream.close();
            }
        } catch (URISyntaxException unused) {
        }
        return caVar.a(uri, inputStream);
    }
}
