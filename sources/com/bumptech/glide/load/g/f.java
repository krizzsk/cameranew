package com.bumptech.glide.load.g;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import us.pinguo.common.network.HttpRequest;
/* compiled from: HttpUrlFetcher.java */
/* loaded from: classes.dex */
public class f implements com.bumptech.glide.load.g.c<InputStream> {

    /* renamed from: f  reason: collision with root package name */
    private static final c f762f = new b();
    private final com.bumptech.glide.load.model.c a;
    private final c b;
    private HttpURLConnection c;

    /* renamed from: d  reason: collision with root package name */
    private InputStream f763d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f764e;

    /* compiled from: HttpUrlFetcher.java */
    /* loaded from: classes.dex */
    private static class b implements c {
        private b() {
        }

        @Override // com.bumptech.glide.load.g.f.c
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpUrlFetcher.java */
    /* loaded from: classes.dex */
    public interface c {
        HttpURLConnection a(URL url) throws IOException;
    }

    public f(com.bumptech.glide.load.model.c cVar) {
        this(cVar, f762f);
    }

    private InputStream c(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f763d = com.bumptech.glide.l.b.d(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f763d = httpURLConnection.getInputStream();
        }
        return this.f763d;
    }

    private InputStream e(URL url, int i2, URL url2, Map<String, String> map) throws IOException {
        if (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new IOException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.c = this.b.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.c.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.c.setConnectTimeout(2500);
            this.c.setReadTimeout(2500);
            this.c.setUseCaches(false);
            this.c.setDoInput(true);
            this.c.connect();
            if (this.f764e) {
                return null;
            }
            int responseCode = this.c.getResponseCode();
            int i3 = responseCode / 100;
            if (i3 == 2) {
                return c(this.c);
            }
            if (i3 != 3) {
                if (responseCode == -1) {
                    throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
                } else {
                    throw new IOException("Request failed " + responseCode + ": " + this.c.getResponseMessage());
                }
            }
            String headerField = this.c.getHeaderField(HttpRequest.HEADER_LOCATION);
            if (!TextUtils.isEmpty(headerField)) {
                return e(new URL(url, headerField), i2 + 1, url, map);
            }
            throw new IOException("Received empty or null redirect url");
        }
        throw new IOException("Too many (> 5) redirects!");
    }

    @Override // com.bumptech.glide.load.g.c
    public void a() {
        InputStream inputStream = this.f763d;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.c;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // com.bumptech.glide.load.g.c
    public void cancel() {
        this.f764e = true;
    }

    @Override // com.bumptech.glide.load.g.c
    /* renamed from: d */
    public InputStream b(Priority priority) throws Exception {
        return e(this.a.e(), 0, null, this.a.b());
    }

    @Override // com.bumptech.glide.load.g.c
    public String getId() {
        return this.a.a();
    }

    f(com.bumptech.glide.load.model.c cVar, c cVar2) {
        this.a = cVar;
        this.b = cVar2;
    }
}
