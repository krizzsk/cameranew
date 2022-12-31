package com.facebook;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.facebook.i;
import com.facebook.internal.r;
import com.facebook.internal.w;
import com.facebook.internal.x;
import com.facebook.internal.y;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyAuctionFlags;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes.dex */
public class GraphRequest {
    public static final String n = "GraphRequest";
    private static final String o;
    private static String p;
    private static Pattern q = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    private static volatile String r;
    @Nullable
    private AccessToken a;
    private HttpMethod b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private JSONObject f2249d;

    /* renamed from: e  reason: collision with root package name */
    private String f2250e;

    /* renamed from: f  reason: collision with root package name */
    private String f2251f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2252g;

    /* renamed from: h  reason: collision with root package name */
    private Bundle f2253h;

    /* renamed from: i  reason: collision with root package name */
    private e f2254i;

    /* renamed from: j  reason: collision with root package name */
    private String f2255j;

    /* renamed from: k  reason: collision with root package name */
    private Object f2256k;

    /* renamed from: l  reason: collision with root package name */
    private String f2257l;
    private boolean m;

    /* loaded from: classes.dex */
    public static class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {
        public static final Parcelable.Creator<ParcelableResourceWithMimeType> CREATOR = new a();
        private final String mimeType;
        private final RESOURCE resource;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<ParcelableResourceWithMimeType> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public ParcelableResourceWithMimeType createFromParcel(Parcel parcel) {
                return new ParcelableResourceWithMimeType(parcel, (com.facebook.g) null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public ParcelableResourceWithMimeType[] newArray(int i2) {
                return new ParcelableResourceWithMimeType[i2];
            }
        }

        /* synthetic */ ParcelableResourceWithMimeType(Parcel parcel, com.facebook.g gVar) {
            this(parcel);
        }

        public String a() {
            return this.mimeType;
        }

        public RESOURCE b() {
            return this.resource;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.mimeType);
            parcel.writeParcelable(this.resource, i2);
        }

        public ParcelableResourceWithMimeType(RESOURCE resource, String str) {
            this.mimeType = str;
            this.resource = resource;
        }

        private ParcelableResourceWithMimeType(Parcel parcel) {
            this.mimeType = parcel.readString();
            this.resource = (RESOURCE) parcel.readParcelable(com.facebook.f.f().getClassLoader());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements e {
        final /* synthetic */ e a;

        a(GraphRequest graphRequest, e eVar) {
            this.a = eVar;
        }

        @Override // com.facebook.GraphRequest.e
        public void a(GraphResponse graphResponse) {
            JSONObject h2 = graphResponse.h();
            JSONObject optJSONObject = h2 != null ? h2.optJSONObject("__debug__") : null;
            JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray("messages") : null;
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                    String optString = optJSONObject2 != null ? optJSONObject2.optString("message") : null;
                    String optString2 = optJSONObject2 != null ? optJSONObject2.optString("type") : null;
                    String optString3 = optJSONObject2 != null ? optJSONObject2.optString("link") : null;
                    if (optString != null && optString2 != null) {
                        LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
                        if (optString2.equals("warning")) {
                            loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
                        }
                        if (!x.S(optString3)) {
                            optString = optString + " Link: " + optString3;
                        }
                        r.g(loggingBehavior, GraphRequest.n, optString);
                    }
                }
            }
            e eVar = this.a;
            if (eVar != null) {
                eVar.a(graphResponse);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        final /* synthetic */ ArrayList a;
        final /* synthetic */ i b;

        b(ArrayList arrayList, i iVar) {
            this.a = arrayList;
            this.b = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    ((e) pair.first).a((GraphResponse) pair.second);
                }
                for (i.a aVar : this.b.k()) {
                    aVar.a(this.b);
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements f {
        final /* synthetic */ ArrayList a;

        c(GraphRequest graphRequest, ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // com.facebook.GraphRequest.f
        public void a(String str, String str2) throws IOException {
            this.a.add(String.format(Locale.US, "%s=%s", str, URLEncoder.encode(str2, "UTF-8")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {
        private final GraphRequest a;
        private final Object b;

        public d(GraphRequest graphRequest, Object obj) {
            this.a = graphRequest;
            this.b = obj;
        }

        public GraphRequest a() {
            return this.a;
        }

        public Object b() {
            return this.b;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(GraphResponse graphResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface f {
        void a(String str, String str2) throws IOException;
    }

    /* loaded from: classes.dex */
    public interface g extends e {
        void onProgress(long j2, long j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h implements f {
        private final OutputStream a;
        private final r b;
        private boolean c = true;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2258d;

        public h(OutputStream outputStream, r rVar, boolean z) {
            this.f2258d = false;
            this.a = outputStream;
            this.b = rVar;
            this.f2258d = z;
        }

        private RuntimeException b() {
            return new IllegalArgumentException("value is not a supported type.");
        }

        @Override // com.facebook.GraphRequest.f
        public void a(String str, String str2) throws IOException {
            f(str, null, null);
            i("%s", str2);
            k();
            r rVar = this.b;
            if (rVar != null) {
                rVar.c("    " + str, str2);
            }
        }

        public void c(String str, Object... objArr) throws IOException {
            if (!this.f2258d) {
                if (this.c) {
                    this.a.write("--".getBytes());
                    this.a.write(GraphRequest.o.getBytes());
                    this.a.write("\r\n".getBytes());
                    this.c = false;
                }
                this.a.write(String.format(str, objArr).getBytes());
                return;
            }
            this.a.write(URLEncoder.encode(String.format(Locale.US, str, objArr), "UTF-8").getBytes());
        }

        public void d(String str, Bitmap bitmap) throws IOException {
            f(str, str, "image/png");
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, this.a);
            i("", new Object[0]);
            k();
            r rVar = this.b;
            if (rVar != null) {
                rVar.c("    " + str, "<Image>");
            }
        }

        public void e(String str, byte[] bArr) throws IOException {
            f(str, str, "content/unknown");
            this.a.write(bArr);
            i("", new Object[0]);
            k();
            r rVar = this.b;
            if (rVar != null) {
                rVar.c("    " + str, String.format(Locale.ROOT, "<Data: %d>", Integer.valueOf(bArr.length)));
            }
        }

        public void f(String str, String str2, String str3) throws IOException {
            if (!this.f2258d) {
                c("Content-Disposition: form-data; name=\"%s\"", str);
                if (str2 != null) {
                    c("; filename=\"%s\"", str2);
                }
                i("", new Object[0]);
                if (str3 != null) {
                    i("%s: %s", HttpRequest.HEADER_CONTENT_TYPE, str3);
                }
                i("", new Object[0]);
                return;
            }
            this.a.write(String.format("%s=", str).getBytes());
        }

        public void g(String str, Uri uri, String str2) throws IOException {
            int m;
            if (str2 == null) {
                str2 = "content/unknown";
            }
            f(str, str, str2);
            if (this.a instanceof l) {
                ((l) this.a).i(x.v(uri));
                m = 0;
            } else {
                m = x.m(com.facebook.f.f().getContentResolver().openInputStream(uri), this.a) + 0;
            }
            i("", new Object[0]);
            k();
            r rVar = this.b;
            if (rVar != null) {
                rVar.c("    " + str, String.format(Locale.ROOT, "<Data: %d>", Integer.valueOf(m)));
            }
        }

        public void h(String str, ParcelFileDescriptor parcelFileDescriptor, String str2) throws IOException {
            int m;
            if (str2 == null) {
                str2 = "content/unknown";
            }
            f(str, str, str2);
            OutputStream outputStream = this.a;
            if (outputStream instanceof l) {
                ((l) outputStream).i(parcelFileDescriptor.getStatSize());
                m = 0;
            } else {
                m = x.m(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), this.a) + 0;
            }
            i("", new Object[0]);
            k();
            r rVar = this.b;
            if (rVar != null) {
                rVar.c("    " + str, String.format(Locale.ROOT, "<Data: %d>", Integer.valueOf(m)));
            }
        }

        public void i(String str, Object... objArr) throws IOException {
            c(str, objArr);
            if (this.f2258d) {
                return;
            }
            c("\r\n", new Object[0]);
        }

        public void j(String str, Object obj, GraphRequest graphRequest) throws IOException {
            OutputStream outputStream = this.a;
            if (outputStream instanceof n) {
                ((n) outputStream).a(graphRequest);
            }
            if (GraphRequest.I(obj)) {
                a(str, GraphRequest.L(obj));
            } else if (obj instanceof Bitmap) {
                d(str, (Bitmap) obj);
            } else if (obj instanceof byte[]) {
                e(str, (byte[]) obj);
            } else if (obj instanceof Uri) {
                g(str, (Uri) obj, null);
            } else if (obj instanceof ParcelFileDescriptor) {
                h(str, (ParcelFileDescriptor) obj, null);
            } else if (obj instanceof ParcelableResourceWithMimeType) {
                ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType) obj;
                Parcelable b = parcelableResourceWithMimeType.b();
                String a = parcelableResourceWithMimeType.a();
                if (b instanceof ParcelFileDescriptor) {
                    h(str, (ParcelFileDescriptor) b, a);
                } else if (b instanceof Uri) {
                    g(str, (Uri) b, a);
                } else {
                    throw b();
                }
            } else {
                throw b();
            }
        }

        public void k() throws IOException {
            if (this.f2258d) {
                this.a.write("&".getBytes());
            } else {
                i("--%s", GraphRequest.o);
            }
        }

        public void l(String str, JSONArray jSONArray, Collection<GraphRequest> collection) throws IOException, JSONException {
            OutputStream outputStream = this.a;
            if (!(outputStream instanceof n)) {
                a(str, jSONArray.toString());
                return;
            }
            n nVar = (n) outputStream;
            f(str, null, null);
            c("[", new Object[0]);
            int i2 = 0;
            for (GraphRequest graphRequest : collection) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                nVar.a(graphRequest);
                if (i2 > 0) {
                    c(",%s", jSONObject.toString());
                } else {
                    c("%s", jSONObject.toString());
                }
                i2++;
            }
            c("]", new Object[0]);
            r rVar = this.b;
            if (rVar != null) {
                rVar.c("    " + str, jSONArray.toString());
            }
        }
    }

    static {
        char[] charArray = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        int nextInt = secureRandom.nextInt(11) + 30;
        for (int i2 = 0; i2 < nextInt; i2++) {
            sb.append(charArray[secureRandom.nextInt(charArray.length)]);
        }
        o = sb.toString();
    }

    public GraphRequest() {
        this(null, null, null, null, null);
    }

    private static String C() {
        if (r == null) {
            r = String.format("%s.%s", "FBAndroidSDK", "8.2.0");
            String a2 = com.facebook.internal.p.a();
            if (!x.S(a2)) {
                r = String.format(Locale.ROOT, "%s/%s", r, a2);
            }
        }
        return r;
    }

    private static boolean E(i iVar) {
        for (i.a aVar : iVar.k()) {
            if (aVar instanceof i.b) {
                return true;
            }
        }
        Iterator<GraphRequest> it = iVar.iterator();
        while (it.hasNext()) {
            if (it.next().s() instanceof g) {
                return true;
            }
        }
        return false;
    }

    private static boolean F(i iVar) {
        Iterator<GraphRequest> it = iVar.iterator();
        while (it.hasNext()) {
            GraphRequest next = it.next();
            for (String str : next.f2253h.keySet()) {
                if (H(next.f2253h.get(str))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean G(String str) {
        Matcher matcher = q.matcher(str);
        if (matcher.matches()) {
            str = matcher.group(1);
        }
        return str.startsWith("me/") || str.startsWith("/me/");
    }

    private static boolean H(Object obj) {
        return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelableResourceWithMimeType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean I(Object obj) {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
    }

    public static GraphRequest J(@Nullable AccessToken accessToken, String str, e eVar) {
        return new GraphRequest(accessToken, str, null, null, eVar);
    }

    public static GraphRequest K(@Nullable AccessToken accessToken, String str, JSONObject jSONObject, e eVar) {
        GraphRequest graphRequest = new GraphRequest(accessToken, str, null, HttpMethod.POST, eVar);
        graphRequest.X(jSONObject);
        return graphRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String L(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof Boolean) && !(obj instanceof Number)) {
            if (obj instanceof Date) {
                return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(obj);
            }
            throw new IllegalArgumentException("Unsupported parameter type.");
        }
        return obj.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void M(org.json.JSONObject r6, java.lang.String r7, com.facebook.GraphRequest.f r8) throws java.io.IOException {
        /*
            boolean r0 = G(r7)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1e
            java.lang.String r0 = ":"
            int r0 = r7.indexOf(r0)
            java.lang.String r3 = "?"
            int r7 = r7.indexOf(r3)
            r3 = 3
            if (r0 <= r3) goto L1e
            r3 = -1
            if (r7 == r3) goto L1c
            if (r0 >= r7) goto L1e
        L1c:
            r7 = 1
            goto L1f
        L1e:
            r7 = 0
        L1f:
            java.util.Iterator r0 = r6.keys()
        L23:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L44
            java.lang.Object r3 = r0.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r6.opt(r3)
            if (r7 == 0) goto L3f
            java.lang.String r5 = "image"
            boolean r5 = r3.equalsIgnoreCase(r5)
            if (r5 == 0) goto L3f
            r5 = 1
            goto L40
        L3f:
            r5 = 0
        L40:
            N(r3, r4, r8, r5)
            goto L23
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.M(org.json.JSONObject, java.lang.String, com.facebook.GraphRequest$f):void");
    }

    private static void N(String str, Object obj, f fVar, boolean z) throws IOException {
        Class<?> cls = obj.getClass();
        if (JSONObject.class.isAssignableFrom(cls)) {
            JSONObject jSONObject = (JSONObject) obj;
            if (z) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    N(String.format("%s[%s]", str, next), jSONObject.opt(next), fVar, z);
                }
            } else if (jSONObject.has(TapjoyAuctionFlags.AUCTION_ID)) {
                N(str, jSONObject.optString(TapjoyAuctionFlags.AUCTION_ID), fVar, z);
            } else if (jSONObject.has("url")) {
                N(str, jSONObject.optString("url"), fVar, z);
            } else if (jSONObject.has("fbsdk:create_object")) {
                N(str, jSONObject.toString(), fVar, z);
            }
        } else if (JSONArray.class.isAssignableFrom(cls)) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                N(String.format(Locale.ROOT, "%s[%d]", str, Integer.valueOf(i2)), jSONArray.opt(i2), fVar, z);
            }
        } else if (!String.class.isAssignableFrom(cls) && !Number.class.isAssignableFrom(cls) && !Boolean.class.isAssignableFrom(cls)) {
            if (Date.class.isAssignableFrom(cls)) {
                fVar.a(str, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj));
            }
        } else {
            fVar.a(str, obj.toString());
        }
    }

    private static void O(i iVar, r rVar, int i2, URL url, OutputStream outputStream, boolean z) throws IOException, JSONException {
        h hVar = new h(outputStream, rVar, z);
        if (i2 == 1) {
            GraphRequest graphRequest = iVar.get(0);
            HashMap hashMap = new HashMap();
            for (String str : graphRequest.f2253h.keySet()) {
                Object obj = graphRequest.f2253h.get(str);
                if (H(obj)) {
                    hashMap.put(str, new d(graphRequest, obj));
                }
            }
            if (rVar != null) {
                rVar.a("  Parameters:\n");
            }
            R(graphRequest.f2253h, hVar, graphRequest);
            if (rVar != null) {
                rVar.a("  Attachments:\n");
            }
            Q(hashMap, hVar);
            JSONObject jSONObject = graphRequest.f2249d;
            if (jSONObject != null) {
                M(jSONObject, url.getPath(), hVar);
                return;
            }
            return;
        }
        String r2 = r(iVar);
        if (!x.S(r2)) {
            hVar.a("batch_app_id", r2);
            HashMap hashMap2 = new HashMap();
            S(hVar, iVar, hashMap2);
            if (rVar != null) {
                rVar.a("  Attachments:\n");
            }
            Q(hashMap2, hVar);
            return;
        }
        throw new FacebookException("App ID was not specified at the request or Settings.");
    }

    static void P(i iVar, List<GraphResponse> list) {
        int size = iVar.size();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            GraphRequest graphRequest = iVar.get(i2);
            if (graphRequest.f2254i != null) {
                arrayList.add(new Pair(graphRequest.f2254i, list.get(i2)));
            }
        }
        if (arrayList.size() > 0) {
            b bVar = new b(arrayList, iVar);
            Handler j2 = iVar.j();
            if (j2 == null) {
                bVar.run();
            } else {
                j2.post(bVar);
            }
        }
    }

    private static void Q(Map<String, d> map, h hVar) throws IOException {
        for (String str : map.keySet()) {
            d dVar = map.get(str);
            if (H(dVar.b())) {
                hVar.j(str, dVar.b(), dVar.a());
            }
        }
    }

    private static void R(Bundle bundle, h hVar, GraphRequest graphRequest) throws IOException {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (I(obj)) {
                hVar.j(str, obj, graphRequest);
            }
        }
    }

    private static void S(h hVar, Collection<GraphRequest> collection, Map<String, d> map) throws JSONException, IOException {
        JSONArray jSONArray = new JSONArray();
        for (GraphRequest graphRequest : collection) {
            graphRequest.T(jSONArray, map);
        }
        hVar.l("batch", jSONArray, collection);
    }

    private void T(JSONArray jSONArray, Map<String, d> map) throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        String str = this.f2250e;
        if (str != null) {
            jSONObject.put("name", str);
            jSONObject.put("omit_response_on_success", this.f2252g);
        }
        String str2 = this.f2251f;
        if (str2 != null) {
            jSONObject.put("depends_on", str2);
        }
        String z = z();
        jSONObject.put("relative_url", z);
        jSONObject.put("method", this.b);
        AccessToken accessToken = this.a;
        if (accessToken != null) {
            r.j(accessToken.t());
        }
        ArrayList arrayList = new ArrayList();
        for (String str3 : this.f2253h.keySet()) {
            Object obj = this.f2253h.get(str3);
            if (H(obj)) {
                String format = String.format(Locale.ROOT, "%s%d", "file", Integer.valueOf(map.size()));
                arrayList.add(format);
                map.put(format, new d(this, obj));
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put("attached_files", TextUtils.join(",", arrayList));
        }
        if (this.f2249d != null) {
            ArrayList arrayList2 = new ArrayList();
            M(this.f2249d, z, new c(this, arrayList2));
            jSONObject.put("body", TextUtils.join("&", arrayList2));
        }
        jSONArray.put(jSONObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static final void U(com.facebook.i r13, java.net.HttpURLConnection r14) throws java.io.IOException, org.json.JSONException {
        /*
            com.facebook.internal.r r6 = new com.facebook.internal.r
            com.facebook.LoggingBehavior r0 = com.facebook.LoggingBehavior.REQUESTS
            java.lang.String r1 = "Request"
            r6.<init>(r0, r1)
            int r2 = r13.size()
            boolean r5 = F(r13)
            r0 = 0
            r1 = 1
            if (r2 != r1) goto L1c
            com.facebook.GraphRequest r3 = r13.get(r0)
            com.facebook.HttpMethod r3 = r3.b
            goto L1e
        L1c:
            com.facebook.HttpMethod r3 = com.facebook.HttpMethod.POST
        L1e:
            java.lang.String r4 = r3.name()
            r14.setRequestMethod(r4)
            W(r14, r5)
            java.net.URL r4 = r14.getURL()
            java.lang.String r7 = "Request:\n"
            r6.a(r7)
            java.lang.String r7 = r13.l()
            java.lang.String r8 = "Id"
            r6.c(r8, r7)
            java.lang.String r7 = "URL"
            r6.c(r7, r4)
            java.lang.String r7 = r14.getRequestMethod()
            java.lang.String r8 = "Method"
            r6.c(r8, r7)
            java.lang.String r7 = "User-Agent"
            java.lang.String r8 = r14.getRequestProperty(r7)
            r6.c(r7, r8)
            java.lang.String r7 = "Content-Type"
            java.lang.String r8 = r14.getRequestProperty(r7)
            r6.c(r7, r8)
            int r7 = r13.n()
            r14.setConnectTimeout(r7)
            int r7 = r13.n()
            r14.setReadTimeout(r7)
            com.facebook.HttpMethod r7 = com.facebook.HttpMethod.POST
            if (r3 != r7) goto L6d
            r0 = 1
        L6d:
            if (r0 != 0) goto L73
            r6.d()
            return
        L73:
            r14.setDoOutput(r1)
            r0 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> Lc9
            java.io.OutputStream r14 = r14.getOutputStream()     // Catch: java.lang.Throwable -> Lc9
            r1.<init>(r14)     // Catch: java.lang.Throwable -> Lc9
            if (r5 == 0) goto L8c
            java.util.zip.GZIPOutputStream r14 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L89
            r14.<init>(r1)     // Catch: java.lang.Throwable -> L89
            r0 = r14
            goto L8d
        L89:
            r13 = move-exception
            r0 = r1
            goto Lca
        L8c:
            r0 = r1
        L8d:
            boolean r14 = E(r13)     // Catch: java.lang.Throwable -> Lc9
            if (r14 == 0) goto Lb7
            com.facebook.l r14 = new com.facebook.l     // Catch: java.lang.Throwable -> Lc9
            android.os.Handler r1 = r13.j()     // Catch: java.lang.Throwable -> Lc9
            r14.<init>(r1)     // Catch: java.lang.Throwable -> Lc9
            r8 = 0
            r7 = r13
            r9 = r2
            r10 = r4
            r11 = r14
            r12 = r5
            O(r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> Lc9
            int r1 = r14.t()     // Catch: java.lang.Throwable -> Lc9
            java.util.Map r10 = r14.v()     // Catch: java.lang.Throwable -> Lc9
            com.facebook.m r14 = new com.facebook.m     // Catch: java.lang.Throwable -> Lc9
            long r11 = (long) r1     // Catch: java.lang.Throwable -> Lc9
            r7 = r14
            r8 = r0
            r9 = r13
            r7.<init>(r8, r9, r10, r11)     // Catch: java.lang.Throwable -> Lc9
            goto Lb8
        Lb7:
            r14 = r0
        Lb8:
            r0 = r13
            r1 = r6
            r3 = r4
            r4 = r14
            O(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lc6
            r14.close()
            r6.d()
            return
        Lc6:
            r13 = move-exception
            r0 = r14
            goto Lca
        Lc9:
            r13 = move-exception
        Lca:
            if (r0 == 0) goto Lcf
            r0.close()
        Lcf:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.U(com.facebook.i, java.net.HttpURLConnection):void");
    }

    private static void W(HttpURLConnection httpURLConnection, boolean z) {
        if (z) {
            httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_TYPE, HttpRequest.CONTENT_TYPE_FORM);
            httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_ENCODING, HttpRequest.ENCODING_GZIP);
            return;
        }
        httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_TYPE, x());
    }

    private void d() {
        if (this.a != null) {
            if (!this.f2253h.containsKey("access_token")) {
                String t = this.a.t();
                r.j(t);
                this.f2253h.putString("access_token", t);
            }
        } else if (!this.m && !this.f2253h.containsKey("access_token")) {
            String g2 = com.facebook.f.g();
            String n2 = com.facebook.f.n();
            if (!x.S(g2) && !x.S(n2)) {
                this.f2253h.putString("access_token", g2 + Effect.DIVIDER + n2);
            } else {
                x.Y(n, "Warning: Request without access token missing application ID or client token.");
            }
        }
        this.f2253h.putString("sdk", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
        this.f2253h.putString(IjkMediaMeta.IJKM_KEY_FORMAT, "json");
        if (com.facebook.f.B(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            this.f2253h.putString("debug", TJAdUnitConstants.String.VIDEO_INFO);
        } else if (com.facebook.f.B(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.f2253h.putString("debug", "warning");
        }
    }

    static final boolean d0(GraphRequest graphRequest) {
        String D = graphRequest.D();
        if (x.S(D)) {
            return true;
        }
        if (D.startsWith("v")) {
            D = D.substring(1);
        }
        String[] split = D.split("\\.");
        if (split.length < 2 || Integer.parseInt(split[0]) <= 2) {
            return Integer.parseInt(split[0]) >= 2 && Integer.parseInt(split[1]) >= 4;
        }
        return true;
    }

    private String e(String str, Boolean bool) {
        if (bool.booleanValue() || this.b != HttpMethod.POST) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            for (String str2 : this.f2253h.keySet()) {
                Object obj = this.f2253h.get(str2);
                if (obj == null) {
                    obj = "";
                }
                if (I(obj)) {
                    buildUpon.appendQueryParameter(str2, L(obj).toString());
                } else if (this.b == HttpMethod.GET) {
                    throw new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", obj.getClass().getSimpleName()));
                }
            }
            return buildUpon.toString();
        }
        return str;
    }

    public static HttpURLConnection e0(i iVar) {
        URL url;
        f0(iVar);
        try {
            if (iVar.size() == 1) {
                url = new URL(iVar.get(0).B());
            } else {
                url = new URL(w.c());
            }
            HttpURLConnection httpURLConnection = null;
            try {
                httpURLConnection = f(url);
                U(iVar, httpURLConnection);
                return httpURLConnection;
            } catch (IOException | JSONException e2) {
                x.o(httpURLConnection);
                throw new FacebookException("could not construct request body", e2);
            }
        } catch (MalformedURLException e3) {
            throw new FacebookException("could not construct URL for request", e3);
        }
    }

    private static HttpURLConnection f(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty(HttpRequest.HEADER_USER_AGENT, C());
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
        httpURLConnection.setChunkedStreamingMode(0);
        return httpURLConnection;
    }

    static final void f0(i iVar) {
        Iterator<GraphRequest> it = iVar.iterator();
        while (it.hasNext()) {
            GraphRequest next = it.next();
            if (HttpMethod.GET.equals(next.w()) && d0(next)) {
                Bundle y = next.y();
                if (!y.containsKey("fields") || x.S(y.getString("fields"))) {
                    r.f(LoggingBehavior.DEVELOPER_ERRORS, 5, "Request", "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.", next.u());
                }
            }
        }
    }

    public static GraphResponse h(GraphRequest graphRequest) {
        List<GraphResponse> l2 = l(graphRequest);
        if (l2 != null && l2.size() == 1) {
            return l2.get(0);
        }
        throw new FacebookException("invalid state: expected a single response");
    }

    public static List<GraphResponse> j(i iVar) {
        y.k(iVar, "requests");
        try {
            try {
                HttpURLConnection e0 = e0(iVar);
                List<GraphResponse> p2 = p(e0, iVar);
                x.o(e0);
                return p2;
            } catch (Exception e2) {
                List<GraphResponse> a2 = GraphResponse.a(iVar.m(), null, new FacebookException(e2));
                P(iVar, a2);
                x.o(null);
                return a2;
            }
        } catch (Throwable th) {
            x.o(null);
            throw th;
        }
    }

    public static List<GraphResponse> k(Collection<GraphRequest> collection) {
        return j(new i(collection));
    }

    public static List<GraphResponse> l(GraphRequest... graphRequestArr) {
        y.l(graphRequestArr, "requests");
        return k(Arrays.asList(graphRequestArr));
    }

    public static com.facebook.h m(i iVar) {
        y.k(iVar, "requests");
        com.facebook.h hVar = new com.facebook.h(iVar);
        hVar.executeOnExecutor(com.facebook.f.p(), new Void[0]);
        return hVar;
    }

    public static com.facebook.h n(Collection<GraphRequest> collection) {
        return m(new i(collection));
    }

    public static com.facebook.h o(GraphRequest... graphRequestArr) {
        y.l(graphRequestArr, "requests");
        return n(Arrays.asList(graphRequestArr));
    }

    public static List<GraphResponse> p(HttpURLConnection httpURLConnection, i iVar) {
        List<GraphResponse> f2 = GraphResponse.f(httpURLConnection, iVar);
        x.o(httpURLConnection);
        int size = iVar.size();
        if (size == f2.size()) {
            P(iVar, f2);
            com.facebook.b.h().f();
            return f2;
        }
        throw new FacebookException(String.format(Locale.US, "Received %d responses while expecting %d", Integer.valueOf(f2.size()), Integer.valueOf(size)));
    }

    private static String r(i iVar) {
        String h2;
        if (!x.S(iVar.i())) {
            return iVar.i();
        }
        Iterator<GraphRequest> it = iVar.iterator();
        while (it.hasNext()) {
            AccessToken accessToken = it.next().a;
            if (accessToken != null && (h2 = accessToken.h()) != null) {
                return h2;
            }
        }
        if (!x.S(p)) {
            return p;
        }
        return com.facebook.f.g();
    }

    private String v() {
        return q.matcher(this.c).matches() ? this.c : String.format("%s/%s", this.f2257l, this.c);
    }

    private static String x() {
        return String.format("multipart/form-data; boundary=%s", o);
    }

    public final Object A() {
        return this.f2256k;
    }

    final String B() {
        String c2;
        String str;
        String str2 = this.f2255j;
        if (str2 != null) {
            return str2.toString();
        }
        if (w() == HttpMethod.POST && (str = this.c) != null && str.endsWith("/videos")) {
            c2 = w.d();
        } else {
            c2 = w.c();
        }
        String format = String.format("%s/%s", c2, v());
        d();
        return e(format, Boolean.FALSE);
    }

    public final String D() {
        return this.f2257l;
    }

    public final void V(e eVar) {
        if (!com.facebook.f.B(LoggingBehavior.GRAPH_API_DEBUG_INFO) && !com.facebook.f.B(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.f2254i = eVar;
        } else {
            this.f2254i = new a(this, eVar);
        }
    }

    public final void X(JSONObject jSONObject) {
        this.f2249d = jSONObject;
    }

    public final void Y(HttpMethod httpMethod) {
        if (this.f2255j != null && httpMethod != HttpMethod.GET) {
            throw new FacebookException("Can't change HTTP method on request with overridden URL.");
        }
        if (httpMethod == null) {
            httpMethod = HttpMethod.GET;
        }
        this.b = httpMethod;
    }

    public final void Z(Bundle bundle) {
        this.f2253h = bundle;
    }

    public final void a0(boolean z) {
        this.m = z;
    }

    public final void b0(Object obj) {
        this.f2256k = obj;
    }

    public final void c0(String str) {
        this.f2257l = str;
    }

    public final GraphResponse g() {
        return h(this);
    }

    public final com.facebook.h i() {
        return o(this);
    }

    @Nullable
    public final AccessToken q() {
        return this.a;
    }

    public final e s() {
        return this.f2254i;
    }

    public final JSONObject t() {
        return this.f2249d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{Request: ");
        sb.append(" accessToken: ");
        Object obj = this.a;
        if (obj == null) {
            obj = "null";
        }
        sb.append(obj);
        sb.append(", graphPath: ");
        sb.append(this.c);
        sb.append(", graphObject: ");
        sb.append(this.f2249d);
        sb.append(", httpMethod: ");
        sb.append(this.b);
        sb.append(", parameters: ");
        sb.append(this.f2253h);
        sb.append("}");
        return sb.toString();
    }

    public final String u() {
        return this.c;
    }

    public final HttpMethod w() {
        return this.b;
    }

    public final Bundle y() {
        return this.f2253h;
    }

    final String z() {
        if (this.f2255j == null) {
            String format = String.format("%s/%s", w.c(), v());
            d();
            Uri parse = Uri.parse(e(format, Boolean.TRUE));
            return String.format("%s?%s", parse.getPath(), parse.getQuery());
        }
        throw new FacebookException("Can't override URL for a batch request");
    }

    public GraphRequest(@Nullable AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod) {
        this(accessToken, str, bundle, httpMethod, null);
    }

    public GraphRequest(@Nullable AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod, e eVar) {
        this(accessToken, str, bundle, httpMethod, eVar, null);
    }

    public GraphRequest(@Nullable AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod, e eVar, String str2) {
        this.f2252g = true;
        this.m = false;
        this.a = accessToken;
        this.c = str;
        this.f2257l = str2;
        V(eVar);
        Y(httpMethod);
        if (bundle != null) {
            this.f2253h = new Bundle(bundle);
        } else {
            this.f2253h = new Bundle();
        }
        if (this.f2257l == null) {
            this.f2257l = com.facebook.f.r();
        }
    }
}
