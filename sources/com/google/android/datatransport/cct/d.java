package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.cct.internal.a;
import com.google.android.datatransport.cct.internal.j;
import com.google.android.datatransport.cct.internal.k;
import com.google.android.datatransport.cct.internal.l;
import com.google.android.datatransport.cct.internal.m;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.f;
import com.google.android.datatransport.runtime.backends.l;
import com.google.android.datatransport.runtime.g;
import com.google.android.datatransport.runtime.h;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.tapjoy.TapjoyConstants;
import com.tencent.bugly.BuglyStrategy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.common.network.HttpRequest;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CctTransportBackend.java */
/* loaded from: classes.dex */
public final class d implements l {
    private final DataEncoder a;
    private final ConnectivityManager b;
    private final Context c;

    /* renamed from: d  reason: collision with root package name */
    final URL f3318d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.x.a f3319e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.x.a f3320f;

    /* renamed from: g  reason: collision with root package name */
    private final int f3321g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CctTransportBackend.java */
    /* loaded from: classes.dex */
    public static final class a {
        final URL a;
        final j b;
        @Nullable
        final String c;

        a(URL url, j jVar, @Nullable String str) {
            this.a = url;
            this.b = jVar;
            this.c = str;
        }

        a a(URL url) {
            return new a(url, this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CctTransportBackend.java */
    /* loaded from: classes.dex */
    public static final class b {
        final int a;
        @Nullable
        final URL b;
        final long c;

        b(int i2, @Nullable URL url, long j2) {
            this.a = i2;
            this.b = url;
            this.c = j2;
        }
    }

    d(Context context, com.google.android.datatransport.runtime.x.a aVar, com.google.android.datatransport.runtime.x.a aVar2, int i2) {
        this.a = j.b();
        this.c = context;
        this.b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f3318d = m(com.google.android.datatransport.cct.a.c);
        this.f3319e = aVar2;
        this.f3320f = aVar;
        this.f3321g = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b d(a aVar) throws IOException {
        com.google.android.datatransport.runtime.u.a.a("CctTransportBackend", "Making request to: %s", aVar.a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.a.openConnection();
        httpURLConnection.setConnectTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
        httpURLConnection.setReadTimeout(this.f3321g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty(HttpRequest.HEADER_USER_AGENT, String.format("datatransport/%s android/", "2.3.3"));
        httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_ENCODING, HttpRequest.ENCODING_GZIP);
        httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_TYPE, HttpRequest.CONTENT_TYPE_JSON);
        httpURLConnection.setRequestProperty(HttpRequest.HEADER_ACCEPT_ENCODING, HttpRequest.ENCODING_GZIP);
        String str = aVar.c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                this.a.encode(aVar.b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                gZIPOutputStream.close();
                if (outputStream != null) {
                    outputStream.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                com.google.android.datatransport.runtime.u.a.e("CctTransportBackend", "Status Code: " + responseCode);
                com.google.android.datatransport.runtime.u.a.e("CctTransportBackend", "Content-Type: " + httpURLConnection.getHeaderField(HttpRequest.HEADER_CONTENT_TYPE));
                com.google.android.datatransport.runtime.u.a.e("CctTransportBackend", "Content-Encoding: " + httpURLConnection.getHeaderField(HttpRequest.HEADER_CONTENT_ENCODING));
                if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                    return new b(responseCode, new URL(httpURLConnection.getHeaderField(HttpRequest.HEADER_LOCATION)), 0L);
                }
                if (responseCode != 200) {
                    return new b(responseCode, null, 0L);
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    InputStream l2 = l(inputStream, httpURLConnection.getHeaderField(HttpRequest.HEADER_CONTENT_ENCODING));
                    b bVar = new b(responseCode, null, m.b(new BufferedReader(new InputStreamReader(l2))).c());
                    if (l2 != null) {
                        l2.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return bVar;
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th2;
            }
        } catch (EncodingException e2) {
            e = e2;
            com.google.android.datatransport.runtime.u.a.c("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        } catch (ConnectException e3) {
            e = e3;
            com.google.android.datatransport.runtime.u.a.c("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (UnknownHostException e4) {
            e = e4;
            com.google.android.datatransport.runtime.u.a.c("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (IOException e5) {
            e = e5;
            com.google.android.datatransport.runtime.u.a.c("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        }
    }

    private static int e(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return NetworkConnectionInfo.MobileSubtype.COMBINED.getValue();
        }
        if (NetworkConnectionInfo.MobileSubtype.forNumber(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    private static int f(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.NetworkType.NONE.getValue();
        }
        return networkInfo.getType();
    }

    private static int g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            com.google.android.datatransport.runtime.u.a.c("CctTransportBackend", "Unable to find version code for package", e2);
            return -1;
        }
    }

    private j h(f fVar) {
        k.a j2;
        HashMap hashMap = new HashMap();
        for (h hVar : fVar.b()) {
            String j3 = hVar.j();
            if (!hashMap.containsKey(j3)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(hVar);
                hashMap.put(j3, arrayList);
            } else {
                ((List) hashMap.get(j3)).add(hVar);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            h hVar2 = (h) ((List) entry.getValue()).get(0);
            l.a a2 = com.google.android.datatransport.cct.internal.l.a();
            a2.f(QosTier.DEFAULT);
            a2.g(this.f3320f.a());
            a2.h(this.f3319e.a());
            ClientInfo.a a3 = ClientInfo.a();
            a3.c(ClientInfo.ClientType.ANDROID_FIREBASE);
            a.AbstractC0126a a4 = com.google.android.datatransport.cct.internal.a.a();
            a4.m(Integer.valueOf(hVar2.g("sdk-version")));
            a4.j(hVar2.b(BigAlbumStore.PhotoTagColumns.MODEL));
            a4.f(hVar2.b("hardware"));
            a4.d(hVar2.b(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX));
            a4.l(hVar2.b("product"));
            a4.k(hVar2.b("os-uild"));
            a4.h(hVar2.b("manufacturer"));
            a4.e(hVar2.b("fingerprint"));
            a4.c(hVar2.b(BigAlbumStore.PhotoAddressColumns.COUNTRY));
            a4.g(hVar2.b("locale"));
            a4.i(hVar2.b("mcc_mnc"));
            a4.b(hVar2.b("application_build"));
            a3.b(a4.a());
            a2.b(a3.a());
            try {
                a2.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                a2.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (h hVar3 : (List) entry.getValue()) {
                g e2 = hVar3.e();
                com.google.android.datatransport.b b2 = e2.b();
                if (b2.equals(com.google.android.datatransport.b.b("proto"))) {
                    j2 = k.j(e2.a());
                } else if (b2.equals(com.google.android.datatransport.b.b("json"))) {
                    j2 = k.i(new String(e2.a(), Charset.forName("UTF-8")));
                } else {
                    com.google.android.datatransport.runtime.u.a.f("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", b2);
                }
                j2.c(hVar3.f());
                j2.d(hVar3.k());
                j2.h(hVar3.h("tz-offset"));
                NetworkConnectionInfo.a a5 = NetworkConnectionInfo.a();
                a5.c(NetworkConnectionInfo.NetworkType.forNumber(hVar3.g("net-type")));
                a5.b(NetworkConnectionInfo.MobileSubtype.forNumber(hVar3.g("mobile-subtype")));
                j2.e(a5.a());
                if (hVar3.d() != null) {
                    j2.b(hVar3.d());
                }
                arrayList3.add(j2.a());
            }
            a2.c(arrayList3);
            arrayList2.add(a2.a());
        }
        return j.a(arrayList2);
    }

    private static TelephonyManager i(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    @VisibleForTesting
    static long j() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ a k(a aVar, b bVar) {
        URL url = bVar.b;
        if (url != null) {
            com.google.android.datatransport.runtime.u.a.a("CctTransportBackend", "Following redirect to: %s", url);
            return aVar.a(bVar.b);
        }
        return null;
    }

    private static InputStream l(InputStream inputStream, String str) throws IOException {
        return HttpRequest.ENCODING_GZIP.equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    private static URL m(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException("Invalid url: " + str, e2);
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.l
    public h a(h hVar) {
        NetworkInfo activeNetworkInfo = this.b.getActiveNetworkInfo();
        h.a l2 = hVar.l();
        l2.a("sdk-version", Build.VERSION.SDK_INT);
        l2.c(BigAlbumStore.PhotoTagColumns.MODEL, Build.MODEL);
        l2.c("hardware", Build.HARDWARE);
        l2.c(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, Build.DEVICE);
        l2.c("product", Build.PRODUCT);
        l2.c("os-uild", Build.ID);
        l2.c("manufacturer", Build.MANUFACTURER);
        l2.c("fingerprint", Build.FINGERPRINT);
        l2.b("tz-offset", j());
        l2.a("net-type", f(activeNetworkInfo));
        l2.a("mobile-subtype", e(activeNetworkInfo));
        l2.c(BigAlbumStore.PhotoAddressColumns.COUNTRY, Locale.getDefault().getCountry());
        l2.c("locale", Locale.getDefault().getLanguage());
        l2.c("mcc_mnc", i(this.c).getSimOperator());
        l2.c("application_build", Integer.toString(g(this.c)));
        return l2.d();
    }

    @Override // com.google.android.datatransport.runtime.backends.l
    public BackendResponse b(f fVar) {
        j h2 = h(fVar);
        URL url = this.f3318d;
        if (fVar.c() != null) {
            try {
                com.google.android.datatransport.cct.a c = com.google.android.datatransport.cct.a.c(fVar.c());
                r3 = c.d() != null ? c.d() : null;
                if (c.e() != null) {
                    url = m(c.e());
                }
            } catch (IllegalArgumentException unused) {
                return BackendResponse.a();
            }
        }
        try {
            b bVar = (b) com.google.android.datatransport.runtime.v.b.a(5, new a(url, h2, r3), com.google.android.datatransport.cct.b.a(this), c.b());
            int i2 = bVar.a;
            if (i2 == 200) {
                return BackendResponse.d(bVar.c);
            }
            if (i2 < 500 && i2 != 404) {
                return BackendResponse.a();
            }
            return BackendResponse.e();
        } catch (IOException e2) {
            com.google.android.datatransport.runtime.u.a.c("CctTransportBackend", "Could not make request to the backend", e2);
            return BackendResponse.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, com.google.android.datatransport.runtime.x.a aVar, com.google.android.datatransport.runtime.x.a aVar2) {
        this(context, aVar, aVar2, 40000);
    }
}
