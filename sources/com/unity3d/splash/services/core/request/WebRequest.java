package com.unity3d.splash.services.core.request;

import com.growingio.android.sdk.collection.Constants;
import com.tencent.bugly.BuglyStrategy;
import com.unity3d.splash.services.core.log.DeviceLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes3.dex */
public class WebRequest {
    private URL a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private Map f8467d;

    /* renamed from: e  reason: collision with root package name */
    private Map f8468e;

    /* renamed from: f  reason: collision with root package name */
    private int f8469f;

    /* renamed from: g  reason: collision with root package name */
    private long f8470g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8471h;

    /* renamed from: i  reason: collision with root package name */
    private int f8472i;

    /* renamed from: j  reason: collision with root package name */
    private int f8473j;

    /* renamed from: k  reason: collision with root package name */
    private a f8474k;

    /* loaded from: classes3.dex */
    public enum RequestType {
        POST,
        GET,
        HEAD
    }

    public WebRequest(String str, String str2, Map map) {
        this(str, str2, map, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
    }

    public WebRequest(String str, String str2, Map map, int i2, int i3) {
        this.b = RequestType.GET.name();
        this.f8469f = -1;
        this.f8470g = -1L;
        this.f8471h = false;
        this.a = new URL(str);
        this.b = str2;
        this.f8467d = map;
        this.f8472i = i2;
        this.f8473j = i3;
    }

    private HttpURLConnection d() {
        HttpURLConnection httpURLConnection;
        if (i().toString().startsWith(Constants.HTTPS_PROTOCOL_PREFIX)) {
            try {
                httpURLConnection = (HttpsURLConnection) i().openConnection();
            } catch (IOException e2) {
                throw new NetworkIOException("Open HTTPS connection: " + e2.getMessage());
            }
        } else if (!i().toString().startsWith(Constants.HTTP_PROTOCOL_PREFIX)) {
            throw new IllegalArgumentException("Invalid url-protocol in url: " + i().toString());
        } else {
            try {
                httpURLConnection = (HttpURLConnection) i().openConnection();
            } catch (IOException e3) {
                throw new NetworkIOException("Open HTTP connection: " + e3.getMessage());
            }
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setConnectTimeout(b());
        httpURLConnection.setReadTimeout(f());
        try {
            httpURLConnection.setRequestMethod(g());
            if (c() != null && c().size() > 0) {
                for (String str : c().keySet()) {
                    for (String str2 : (List) c().get(str)) {
                        DeviceLog.c("Setting header: " + str + "=" + str2);
                        httpURLConnection.setRequestProperty(str, str2);
                    }
                }
            }
            return httpURLConnection;
        } catch (ProtocolException e4) {
            throw new NetworkIOException("Set Request Method: " + g() + ", " + e4.getMessage());
        }
    }

    public String a() {
        return this.c;
    }

    public int b() {
        return this.f8472i;
    }

    public Map c() {
        return this.f8467d;
    }

    public String e() {
        URL url = this.a;
        if (url != null) {
            return url.getQuery();
        }
        return null;
    }

    public int f() {
        return this.f8473j;
    }

    public String g() {
        return this.b;
    }

    public int h() {
        return this.f8469f;
    }

    public URL i() {
        return this.a;
    }

    public boolean j() {
        return this.f8471h;
    }

    public String k() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        l(byteArrayOutputStream);
        return byteArrayOutputStream.toString("UTF-8");
    }

    public long l(OutputStream outputStream) {
        InputStream errorStream;
        PrintWriter printWriter;
        HttpURLConnection d2 = d();
        d2.setDoInput(true);
        if (g().equals(RequestType.POST.name())) {
            d2.setDoOutput(true);
            PrintWriter printWriter2 = null;
            try {
                try {
                    printWriter = new PrintWriter((Writer) new OutputStreamWriter(d2.getOutputStream(), "UTF-8"), true);
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                printWriter.print(a() == null ? e() : a());
                printWriter.flush();
                try {
                    printWriter.close();
                } catch (Exception e3) {
                    DeviceLog.g("Error closing writer", e3);
                    throw e3;
                }
            } catch (IOException e4) {
                e = e4;
                printWriter2 = printWriter;
                DeviceLog.g("Error while writing POST params", e);
                throw new NetworkIOException("Error writing POST params: " + e.getMessage());
            } catch (Throwable th2) {
                th = th2;
                printWriter2 = printWriter;
                if (printWriter2 != null) {
                    try {
                        printWriter2.close();
                    } catch (Exception e5) {
                        DeviceLog.g("Error closing writer", e5);
                        throw e5;
                    }
                }
                throw th;
            }
        }
        try {
            this.f8469f = d2.getResponseCode();
            this.f8470g = d2.getContentLength();
            if (d2.getHeaderFields() != null) {
                this.f8468e = d2.getHeaderFields();
            }
            try {
                errorStream = d2.getInputStream();
            } catch (IOException e6) {
                errorStream = d2.getErrorStream();
                if (errorStream == null) {
                    throw new NetworkIOException("Can't open error stream: " + e6.getMessage());
                }
            }
            a aVar = this.f8474k;
            if (aVar != null) {
                aVar.b(i().toString(), this.f8470g, this.f8469f, this.f8468e);
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(errorStream);
            long j2 = 0;
            byte[] bArr = new byte[4096];
            int i2 = 0;
            while (!j() && i2 != -1) {
                try {
                    i2 = bufferedInputStream.read(bArr);
                    if (i2 > 0) {
                        outputStream.write(bArr, 0, i2);
                        j2 += i2;
                        a aVar2 = this.f8474k;
                        if (aVar2 != null) {
                            aVar2.a(i().toString(), j2, this.f8470g);
                        }
                    }
                } catch (IOException e7) {
                    throw new NetworkIOException("Network exception: " + e7.getMessage());
                }
            }
            d2.disconnect();
            outputStream.flush();
            return j2;
        } catch (IOException | RuntimeException e8) {
            throw new NetworkIOException("Response code: " + e8.getMessage());
        }
    }

    public void m(String str) {
        this.c = str;
    }
}
