package com.airbnb.lottie.network;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import com.airbnb.lottie.e;
import com.airbnb.lottie.f;
import com.airbnb.lottie.m;
import com.airbnb.lottie.w.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;
import us.pinguo.common.network.HttpRequest;
/* compiled from: NetworkFetcher.java */
/* loaded from: classes.dex */
public class a {
    private final Context a;
    private final String b;
    @Nullable
    private final NetworkCache c;

    private a(Context context, String str, @Nullable String str2) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = str;
        if (str2 == null) {
            this.c = null;
        } else {
            this.c = new NetworkCache(applicationContext);
        }
    }

    @Nullable
    @WorkerThread
    private e a() {
        Pair<FileExtension, InputStream> a;
        m<e> h2;
        NetworkCache networkCache = this.c;
        if (networkCache == null || (a = networkCache.a(this.b)) == null) {
            return null;
        }
        FileExtension fileExtension = a.first;
        InputStream inputStream = a.second;
        if (fileExtension == FileExtension.ZIP) {
            h2 = f.r(new ZipInputStream(inputStream), this.b);
        } else {
            h2 = f.h(inputStream, this.b);
        }
        if (h2.b() != null) {
            return h2.b();
        }
        return null;
    }

    @WorkerThread
    private m<e> b() {
        try {
            return c();
        } catch (IOException e2) {
            return new m<>(e2);
        }
    }

    @WorkerThread
    private m<e> c() throws IOException {
        d.a("Fetching " + this.b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.b).openConnection();
        httpURLConnection.setRequestMethod("GET");
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
                m<e> g2 = g(httpURLConnection);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(g2.b() != null);
                d.a(sb.toString());
                return g2;
            }
            String f2 = f(httpURLConnection);
            return new m<>(new IllegalArgumentException("Unable to fetch " + this.b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + f2));
        } catch (Exception e2) {
            return new m<>(e2);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static m<e> e(Context context, String str, @Nullable String str2) {
        return new a(context, str, str2).d();
    }

    private String f(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        sb.append('\n');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }

    @Nullable
    private m<e> g(HttpURLConnection httpURLConnection) throws IOException {
        FileExtension fileExtension;
        m<e> h2;
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = HttpRequest.CONTENT_TYPE_JSON;
        }
        if (contentType.contains("application/zip")) {
            d.a("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            NetworkCache networkCache = this.c;
            if (networkCache == null) {
                h2 = f.r(new ZipInputStream(httpURLConnection.getInputStream()), null);
            } else {
                h2 = f.r(new ZipInputStream(new FileInputStream(networkCache.f(this.b, httpURLConnection.getInputStream(), fileExtension))), this.b);
            }
        } else {
            d.a("Received json response.");
            fileExtension = FileExtension.JSON;
            NetworkCache networkCache2 = this.c;
            if (networkCache2 == null) {
                h2 = f.h(httpURLConnection.getInputStream(), null);
            } else {
                h2 = f.h(new FileInputStream(new File(networkCache2.f(this.b, httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.b);
            }
        }
        if (this.c != null && h2.b() != null) {
            this.c.e(this.b, fileExtension);
        }
        return h2;
    }

    @WorkerThread
    public m<e> d() {
        e a = a();
        if (a != null) {
            return new m<>(a);
        }
        d.a("Animation for " + this.b + " not found in cache. Fetching from network.");
        return b();
    }
}
