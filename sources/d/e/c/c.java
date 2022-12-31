package d.e.c;

import android.net.Uri;
import android.util.Pair;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.common.network.HttpRequest;
/* compiled from: ISHttpService.java */
/* loaded from: classes2.dex */
public class c {

    /* compiled from: ISHttpService.java */
    /* loaded from: classes2.dex */
    public static class a {
        final String a;
        final String b;
        final String c;

        /* renamed from: d  reason: collision with root package name */
        final int f8525d;

        /* renamed from: e  reason: collision with root package name */
        final int f8526e;

        /* renamed from: f  reason: collision with root package name */
        final String f8527f;

        /* renamed from: g  reason: collision with root package name */
        ArrayList<Pair<String, String>> f8528g;

        /* compiled from: ISHttpService.java */
        /* renamed from: d.e.c.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static class C0296a {
            String b;

            /* renamed from: d  reason: collision with root package name */
            String f8529d;
            List<Pair<String, String>> a = new ArrayList();
            String c = "POST";

            /* renamed from: e  reason: collision with root package name */
            int f8530e = 15000;

            /* renamed from: f  reason: collision with root package name */
            int f8531f = 15000;

            /* renamed from: g  reason: collision with root package name */
            String f8532g = "UTF-8";

            C0296a() {
            }

            C0296a a(List<Pair<String, String>> list) {
                this.a.addAll(list);
                return this;
            }

            a b() {
                return new a(this);
            }

            C0296a c(String str) {
                this.f8529d = str;
                return this;
            }

            C0296a d(String str) {
                this.b = str;
                return this;
            }

            C0296a e(String str) {
                this.c = str;
                return this;
            }
        }

        public a(C0296a c0296a) {
            this.a = c0296a.b;
            this.b = c0296a.c;
            this.c = c0296a.f8529d;
            this.f8528g = new ArrayList<>(c0296a.a);
            this.f8525d = c0296a.f8530e;
            this.f8526e = c0296a.f8531f;
            this.f8527f = c0296a.f8532g;
        }

        boolean a() {
            return "POST".equals(this.b);
        }
    }

    private static boolean a(String str, String str2) {
        return (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) ? false : true;
    }

    private static HttpURLConnection b(a aVar) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(aVar.a).openConnection();
        httpURLConnection.setConnectTimeout(aVar.f8525d);
        httpURLConnection.setReadTimeout(aVar.f8526e);
        httpURLConnection.setRequestMethod(aVar.b);
        return httpURLConnection;
    }

    public static d c(String str, String str2, List<Pair<String, String>> list) throws Exception {
        Uri build = Uri.parse(str).buildUpon().encodedQuery(str2).build();
        a.C0296a c0296a = new a.C0296a();
        c0296a.d(build.toString());
        c0296a.c(str2);
        c0296a.e("GET");
        c0296a.a(list);
        return e(c0296a.b());
    }

    public static d d(String str, String str2, List<Pair<String, String>> list) throws Exception {
        a.C0296a c0296a = new a.C0296a();
        c0296a.d(str);
        c0296a.c(str2);
        c0296a.e("POST");
        c0296a.a(list);
        return e(c0296a.b());
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static d.e.c.d e(d.e.c.c.a r7) throws java.lang.Exception {
        /*
            java.lang.String r0 = r7.a
            java.lang.String r1 = r7.c
            boolean r0 = a(r0, r1)
            if (r0 == 0) goto L8b
            d.e.c.d r0 = new d.e.c.d
            r0.<init>()
            r1 = 0
            java.net.HttpURLConnection r2 = b(r7)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L40
            java.util.ArrayList<android.util.Pair<java.lang.String, java.lang.String>> r3 = r7.f8528g     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            f(r2, r3)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            g(r2, r7)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            java.io.InputStream r1 = r2.getInputStream()     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            int r3 = r2.getResponseCode()     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            r0.a = r3     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            if (r1 == 0) goto L2b
            d.e.c.e.a(r1)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
        L2b:
            if (r1 == 0) goto L30
            r1.close()
        L30:
            if (r2 == 0) goto L7a
            r2.disconnect()
            goto L7a
        L36:
            r7 = move-exception
            goto L80
        L38:
            r3 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L42
        L3d:
            r7 = move-exception
            r2 = r1
            goto L80
        L40:
            r3 = move-exception
            r2 = r1
        L42:
            if (r1 == 0) goto L7b
            int r4 = r1.getResponseCode()     // Catch: java.lang.Throwable -> L7c
            r0.a = r4     // Catch: java.lang.Throwable -> L7c
            r5 = 400(0x190, float:5.6E-43)
            if (r4 < r5) goto L7b
            java.lang.String r3 = "ISHttpService"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            r4.<init>()     // Catch: java.lang.Throwable -> L7c
            java.lang.String r5 = "Failed post to "
            r4.append(r5)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r7 = r7.a     // Catch: java.lang.Throwable -> L7c
            r4.append(r7)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r7 = " StatusCode: "
            r4.append(r7)     // Catch: java.lang.Throwable -> L7c
            int r7 = r0.a     // Catch: java.lang.Throwable -> L7c
            r4.append(r7)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L7c
            android.util.Log.d(r3, r7)     // Catch: java.lang.Throwable -> L7c
            if (r2 == 0) goto L75
            r2.close()
        L75:
            if (r1 == 0) goto L7a
            r1.disconnect()
        L7a:
            return r0
        L7b:
            throw r3     // Catch: java.lang.Throwable -> L7c
        L7c:
            r7 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
        L80:
            if (r1 == 0) goto L85
            r1.close()
        L85:
            if (r2 == 0) goto L8a
            r2.disconnect()
        L8a:
            throw r7
        L8b:
            java.security.InvalidParameterException r7 = new java.security.InvalidParameterException
            java.lang.String r0 = "not valid params"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: d.e.c.c.e(d.e.c.c$a):d.e.c.d");
    }

    private static void f(HttpURLConnection httpURLConnection, List<Pair<String, String>> list) throws ProtocolException {
        for (Pair<String, String> pair : list) {
            httpURLConnection.setRequestProperty((String) pair.first, (String) pair.second);
        }
    }

    private static void g(HttpURLConnection httpURLConnection, a aVar) throws Exception {
        if (aVar.a()) {
            byte[] bytes = aVar.c.getBytes(aVar.f8527f);
            httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_LENGTH, Integer.toString(bytes.length));
            h(httpURLConnection, bytes);
        }
    }

    private static void h(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        httpURLConnection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        try {
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
        } finally {
            dataOutputStream.close();
        }
    }
}
