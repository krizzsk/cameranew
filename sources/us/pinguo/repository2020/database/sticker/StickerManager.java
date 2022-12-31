package us.pinguo.repository2020.database.sticker;

import android.text.TextUtils;
import android.util.LruCache;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pinguo.lib.GsonUtilKt;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.b.r;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.z0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.common.network.HttpStringRequest;
import us.pinguo.common.network.common.PGNetworkConfig;
import us.pinguo.common.pgdownloader.download.IDownloadTask;
import us.pinguo.common.pgdownloader.download.PGDownloadManger;
import us.pinguo.foundation.j;
import us.pinguo.foundation.statistics.i;
import us.pinguo.foundation.utils.o0;
import us.pinguo.foundation.utils.y;
import us.pinguo.repository2020.R;
import us.pinguo.repository2020.utils.RequestIntervalPref;
import us.pinguo.repository2020.utils.h;
import us.pinguo.user.u0;
import us.pinguo.util.v;
/* compiled from: StickerManager.kt */
/* loaded from: classes6.dex */
public final class StickerManager {
    private static final boolean b;

    /* renamed from: j  reason: collision with root package name */
    private static volatile List<StickerCategory> f11860j;

    /* renamed from: k  reason: collision with root package name */
    private static volatile Map<String, Sticker> f11861k;

    /* renamed from: l  reason: collision with root package name */
    private static volatile StickerJson f11862l;
    private static final ConcurrentHashMap<String, StickerDetail> m;
    private static final CopyOnWriteArrayList<String> n;
    private static final LruCache<String, Sticker> o;
    private static final ConcurrentHashMap<String, g> p;
    private static final LruCache<String, StickerRenderData> q;
    private static final HashMap<String, d> r;
    private static final CopyOnWriteArrayList<String> s;
    private static final kotlinx.coroutines.sync.c t;
    public static final StickerManager a = new StickerManager();
    private static final String c = s.q(us.pinguo.foundation.e.b().getFilesDir().getAbsolutePath(), "/shop/specific_builtin_unity_sticker.json");

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f11854d = {"5e6a360ea35dde3d3e028c25", "5e6a360fa35dde3d3e028c29", "5e6a360fa35dde3d3e028c2d", "5e6a35fba35dde3d3e028bc1", "5e6a3601a35dde3d3e028bd9", "5e6a3600a35dde3d3e028bd5", "5e6a3603a35dde3d3e028be9", "5e6a3602a35dde3d3e028be1", "5e6a3607a35dde3d3e028c05", "5e6a3620a35dde3d3e028c7d", "5e6a361ba35dde3d3e028c69", "5e6a3621a35dde3d3e028c81", "5e6a3629a35dde3d3e028ca9", "5e6a3628a35dde3d3e028ca5", "5e6a3625a35dde3d3e028c99", "5e6a3637a35dde3d3e028ce9", "5e6a3639a35dde3d3e028cf1", "5e6a363ba35dde3d3e028cf9"};

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f11855e = {"5d355117fb27043047d68f90", "5e6b28fff40fcf357ce33aa1", "5e6b286efb27046915d6a8bd", "5e6b28ccf34b854438fe448f", "5e6b295d9ac530cd0ab9bc53", "5e6b29ad9ac5302773b9c714", "5e6b29f69ac530bf31b9b912"};

    /* renamed from: f  reason: collision with root package name */
    private static final String f11856f = s.q(us.pinguo.foundation.e.b().getFilesDir().getAbsolutePath(), "/shop/unity_stickers_2019.json");

    /* renamed from: g  reason: collision with root package name */
    private static final String f11857g = s.q(v.d(), "/shop/");

    /* renamed from: h  reason: collision with root package name */
    private static final String f11858h = s.q(h.e(), "cache/recent.txt");

    /* renamed from: i  reason: collision with root package name */
    private static final String f11859i = s.q(h.e(), "cache/fresh.txt");

    /* compiled from: StickerManager.kt */
    /* loaded from: classes6.dex */
    public static final class a extends HttpStringRequest {
        final /* synthetic */ List<String> a;
        final /* synthetic */ long b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List<String> list, long j2, String str) {
            super(1, str);
            this.a = list;
            this.b = j2;
        }

        @Override // com.android.volley.Request
        protected Map<String, String> getParams() {
            Iterator<T> it;
            HashMap hashMap = new HashMap();
            u0.e(us.pinguo.foundation.e.b(), hashMap);
            String str = "";
            while (this.a.iterator().hasNext()) {
                str = str + ((String) it.next()) + ',';
            }
            String substring = str.substring(0, str.length() - 1);
            s.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            hashMap.put("pids", substring);
            us.pinguo.foundation.m.d.c(hashMap, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
            return hashMap;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception e2) {
            s.h(e2, "e");
            i iVar = us.pinguo.foundation.statistics.h.b;
            iVar.n((System.currentTimeMillis() - this.b) + "", "/api/product/check-update", "failed");
            us.pinguo.common.log.a.f(e2);
            e2.printStackTrace();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.common.network.HttpRequestBase
        public void onResponse(String response) {
            s.h(response, "response");
            i iVar = us.pinguo.foundation.statistics.h.b;
            iVar.n((System.currentTimeMillis() - this.b) + "", "/api/product/check-update", FirebaseAnalytics.Param.SUCCESS);
            StickerUpdateResponse stickerUpdateResponse = (StickerUpdateResponse) GsonUtilKt.getCachedGson().j(response, StickerUpdateResponse.class);
            if (stickerUpdateResponse == null) {
                new NullPointerException().printStackTrace();
                return;
            }
            int status = stickerUpdateResponse.getStatus();
            if (status == 10220) {
                return;
            }
            if (status != 200) {
                new Exception(stickerUpdateResponse.getMessage()).printStackTrace();
                return;
            }
            StickerUpdateData[] data = stickerUpdateResponse.getData();
            if (data.length == 0) {
                return;
            }
            StickerManager.a.Y(this.a, data);
        }
    }

    static {
        Locale locale = Locale.getDefault();
        b = s.c("zh", locale.getLanguage()) && s.c("CN", locale.getCountry());
        m = new ConcurrentHashMap<>();
        n = new CopyOnWriteArrayList<>();
        o = new LruCache<>(100);
        p = new ConcurrentHashMap<>();
        q = new LruCache<>(20);
        r = new HashMap<>();
        s = new CopyOnWriteArrayList<>();
        t = MutexKt.b(false, 1, null);
    }

    private StickerManager() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object A(StickerManager stickerManager, q qVar, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            qVar = null;
        }
        return stickerManager.z(qVar, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(final String[] strArr, final p<? super String[], ? super Boolean, u> pVar) {
        us.pinguo.foundation.statistics.h.b.n("", "/api/product/detail", SocialConstants.TYPE_REQUEST);
        final long currentTimeMillis = System.currentTimeMillis();
        final String q2 = s.q(h.c(), "/api/product/detail");
        new HttpStringRequest(q2) { // from class: us.pinguo.repository2020.database.sticker.StickerManager$downloadStickerDetailAsync$request$1
            @Override // com.android.volley.Request
            protected Map<String, String> getParams() {
                HashMap hashMap = new HashMap();
                u0.e(us.pinguo.foundation.e.b(), hashMap);
                JSONArray jSONArray = new JSONArray();
                String[] strArr2 = strArr;
                int length = strArr2.length;
                int i2 = 0;
                while (i2 < length) {
                    String str = strArr2[i2];
                    i2++;
                    jSONArray.put(str);
                }
                String jSONArray2 = jSONArray.toString();
                s.g(jSONArray2, "jsonArray.toString()");
                hashMap.put("ids", jSONArray2);
                us.pinguo.foundation.m.d.c(hashMap, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
                return hashMap;
            }

            @Override // us.pinguo.common.network.HttpRequestBase
            protected void onErrorResponse(Exception e2) {
                s.h(e2, "e");
                i iVar = us.pinguo.foundation.statistics.h.b;
                iVar.n((System.currentTimeMillis() - currentTimeMillis) + "", "/api/product/detail", "failed");
                us.pinguo.common.log.a.f(e2);
                e2.printStackTrace();
                int length = strArr.length;
                String[] strArr2 = new String[length];
                for (int i2 = 0; i2 < length; i2++) {
                    strArr2[i2] = strArr[i2];
                }
                p<String[], Boolean, u> pVar2 = pVar;
                if (pVar2 == null) {
                    return;
                }
                pVar2.invoke(strArr2, Boolean.FALSE);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // us.pinguo.common.network.HttpRequestBase
            public void onResponse(String response) {
                s.h(response, "response");
                i iVar = us.pinguo.foundation.statistics.h.b;
                iVar.n((System.currentTimeMillis() - currentTimeMillis) + "", "/api/product/detail", FirebaseAnalytics.Param.SUCCESS);
                StickerDetailResponse stickerDetailResponse = (StickerDetailResponse) GsonUtilKt.getCachedGson().j(response, StickerDetailResponse.class);
                StickerDetail[] data = stickerDetailResponse == null ? null : stickerDetailResponse.getData();
                int i2 = 0;
                if (!(stickerDetailResponse != null && stickerDetailResponse.getStatus() == 200)) {
                    int length = strArr.length;
                    String[] strArr2 = new String[length];
                    while (i2 < length) {
                        strArr2[i2] = strArr[i2];
                        i2++;
                    }
                    p<String[], Boolean, u> pVar2 = pVar;
                    if (pVar2 == null) {
                        return;
                    }
                    pVar2.invoke(strArr2, Boolean.FALSE);
                    return;
                }
                if (data != null) {
                    if (!(data.length == 0)) {
                        l.d(n0.a(z0.b()), null, null, new StickerManager$downloadStickerDetailAsync$request$1$onResponse$1(data, pVar, null), 3, null);
                        return;
                    }
                }
                int length2 = strArr.length;
                String[] strArr3 = new String[length2];
                while (i2 < length2) {
                    strArr3[i2] = strArr[i2];
                    i2++;
                }
                p<String[], Boolean, u> pVar3 = pVar;
                if (pVar3 == null) {
                    return;
                }
                pVar3.invoke(strArr3, Boolean.FALSE);
            }
        }.execute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(StickerDetail stickerDetail, final r<? super String, ? super String, ? super String, ? super Boolean, u> rVar) {
        String package_zip = stickerDetail.getPackage_zip();
        if (!(package_zip == null || package_zip.length() == 0)) {
            String package_zip_md5 = stickerDetail.getPackage_zip_md5();
            if (!(package_zip_md5 == null || package_zip_md5.length() == 0)) {
                String display_zip_url = stickerDetail.getDisplay_zip_url();
                if (!(display_zip_url == null || display_zip_url.length() == 0)) {
                    String display_zip_md5 = stickerDetail.getDisplay_zip_md5();
                    if (!(display_zip_md5 == null || display_zip_md5.length() == 0) && stickerDetail.getFile_size() > 0) {
                        String q2 = s.q(h.d(stickerDetail.getDisplay_zip_md5()), "_dsp");
                        final String i2 = h.i(stickerDetail.getDisplay_zip_md5());
                        String q3 = s.q(h.d(stickerDetail.getPackage_zip_md5()), "_pkg");
                        final String i3 = h.i(stickerDetail.getPackage_zip_md5());
                        PGDownloadManger companion = PGDownloadManger.Companion.getInstance();
                        IDownloadTask create = companion.create(stickerDetail.getDisplay_zip_url(), q2, false, 0);
                        create.setForceReDownload(true);
                        IDownloadTask create2 = companion.create(stickerDetail.getPackage_zip(), q3, false, 0);
                        create2.setForceReDownload(true);
                        g gVar = new g(stickerDetail.getPid(), create, create2);
                        d dVar = r.get(stickerDetail.getPid());
                        final int a2 = dVar != null ? dVar.a() : 0;
                        gVar.g(new us.pinguo.repository2020.database.sticker.a() { // from class: us.pinguo.repository2020.database.sticker.StickerManager$downloadStickerMaterialAsync$1
                            @Override // us.pinguo.repository2020.database.sticker.a
                            public void a(String id, IDownloadTask displayTask, IDownloadTask packageTask) {
                                s.h(id, "id");
                                s.h(displayTask, "displayTask");
                                s.h(packageTask, "packageTask");
                                l.d(n0.a(z0.b()), null, null, new StickerManager$downloadStickerMaterialAsync$1$onComplete$1(id, displayTask, packageTask, rVar, i2, i3, null), 3, null);
                            }

                            @Override // us.pinguo.repository2020.database.sticker.a
                            public void b(String id, IDownloadTask displayTask, IDownloadTask packageTask) {
                                HashMap hashMap;
                                s.h(id, "id");
                                s.h(displayTask, "displayTask");
                                s.h(packageTask, "packageTask");
                                hashMap = StickerManager.r;
                                d dVar2 = (d) hashMap.get(id);
                                if (dVar2 == null) {
                                    return;
                                }
                                dVar2.b(a2 + ((int) (75 * ((displayTask.getSoFarBytes() + packageTask.getSoFarBytes()) / (displayTask.getTotalBytes() + packageTask.getTotalBytes())))));
                            }

                            @Override // us.pinguo.repository2020.database.sticker.a
                            public void c(String id, IDownloadTask task, int i4) {
                                ConcurrentHashMap concurrentHashMap;
                                s.h(id, "id");
                                s.h(task, "task");
                                concurrentHashMap = StickerManager.p;
                                concurrentHashMap.remove(id);
                                new Exception(s.q("download error:", Integer.valueOf(i4))).printStackTrace();
                                r<String, String, String, Boolean, u> rVar2 = rVar;
                                if (rVar2 == null) {
                                    return;
                                }
                                rVar2.invoke(id, i2, i3, Boolean.FALSE);
                            }
                        });
                        p.put(gVar.f(), gVar);
                        gVar.h();
                        return;
                    }
                }
            }
        }
        if (rVar == null) {
            return;
        }
        rVar.invoke(stickerDetail.getPid(), "", "", Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object J(us.pinguo.repository2020.database.sticker.StickerResponseData r14, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, us.pinguo.repository2020.database.sticker.Sticker>> r15) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.sticker.StickerManager.J(us.pinguo.repository2020.database.sticker.StickerResponseData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String K() {
        return b ? "builtin_data/sticker/sticker_cn.json" : "builtin_data/sticker/sticker_en.json";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String M(String str) {
        Locale a2 = us.pinguo.foundation.utils.v.a();
        return str + '_' + ((Object) a2.getLanguage()) + ((Object) a2.getCountry());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object P(kotlin.coroutines.Continuation<? super kotlin.u> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof us.pinguo.repository2020.database.sticker.StickerManager$inflateFreshStickers$1
            if (r0 == 0) goto L13
            r0 = r6
            us.pinguo.repository2020.database.sticker.StickerManager$inflateFreshStickers$1 r0 = (us.pinguo.repository2020.database.sticker.StickerManager$inflateFreshStickers$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.repository2020.database.sticker.StickerManager$inflateFreshStickers$1 r0 = new us.pinguo.repository2020.database.sticker.StickerManager$inflateFreshStickers$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.L$0
            java.util.concurrent.CopyOnWriteArrayList r0 = (java.util.concurrent.CopyOnWriteArrayList) r0
            kotlin.j.b(r6)
            goto L5b
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L39:
            kotlin.j.b(r6)
            java.util.concurrent.CopyOnWriteArrayList<java.lang.String> r6 = us.pinguo.repository2020.database.sticker.StickerManager.s
            boolean r2 = r6.isEmpty()
            r2 = r2 ^ r3
            if (r2 == 0) goto L48
            kotlin.u r6 = kotlin.u.a
            return r6
        L48:
            java.lang.String r2 = us.pinguo.repository2020.database.sticker.StickerManager.f11859i
            r0.L$0 = r6
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r0 = us.pinguo.util.FileUtils.q(r2, r0)
            if (r0 != r1) goto L57
            return r1
        L57:
            r1 = r2
            r4 = r0
            r0 = r6
            r6 = r4
        L5b:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L66
            kotlin.u r6 = kotlin.u.a
            return r6
        L66:
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile
            java.lang.String r2 = "r"
            r6.<init>(r1, r2)
        L6d:
            java.lang.String r1 = r6.readLine()
            if (r1 != 0) goto L79
            r6.close()
            kotlin.u r6 = kotlin.u.a
            return r6
        L79:
            r0.add(r1)
            goto L6d
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.sticker.StickerManager.P(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Q(kotlin.coroutines.Continuation<? super kotlin.u> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof us.pinguo.repository2020.database.sticker.StickerManager$inflateRecentStickers$1
            if (r0 == 0) goto L13
            r0 = r5
            us.pinguo.repository2020.database.sticker.StickerManager$inflateRecentStickers$1 r0 = (us.pinguo.repository2020.database.sticker.StickerManager$inflateRecentStickers$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.repository2020.database.sticker.StickerManager$inflateRecentStickers$1 r0 = new us.pinguo.repository2020.database.sticker.StickerManager$inflateRecentStickers$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            us.pinguo.repository2020.database.sticker.StickerManager r0 = (us.pinguo.repository2020.database.sticker.StickerManager) r0
            kotlin.j.b(r5)
            goto L51
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.j.b(r5)
            android.util.LruCache<java.lang.String, us.pinguo.repository2020.database.sticker.Sticker> r5 = us.pinguo.repository2020.database.sticker.StickerManager.o
            int r5 = r5.size()
            if (r5 <= 0) goto L43
            kotlin.u r5 = kotlin.u.a
            return r5
        L43:
            java.lang.String r5 = us.pinguo.repository2020.database.sticker.StickerManager.f11858h
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = us.pinguo.util.FileUtils.q(r5, r0)
            if (r5 != r1) goto L50
            return r1
        L50:
            r0 = r4
        L51:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L6a
            java.lang.String r5 = "5e6a360fa35dde3d3e028c2d"
            us.pinguo.repository2020.database.sticker.Sticker r0 = r0.H(r5)
            if (r0 != 0) goto L64
            kotlin.u r5 = kotlin.u.a
            return r5
        L64:
            android.util.LruCache<java.lang.String, us.pinguo.repository2020.database.sticker.Sticker> r1 = us.pinguo.repository2020.database.sticker.StickerManager.o
            r1.put(r5, r0)
            goto L7c
        L6a:
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile
            java.lang.String r1 = us.pinguo.repository2020.database.sticker.StickerManager.f11858h
            java.lang.String r2 = "r"
            r5.<init>(r1, r2)
        L73:
            java.lang.String r1 = r5.readLine()
            if (r1 != 0) goto L7f
            r5.close()
        L7c:
            kotlin.u r5 = kotlin.u.a
            return r5
        L7f:
            us.pinguo.repository2020.database.sticker.Sticker r2 = r0.H(r1)
            if (r2 != 0) goto L86
            goto L73
        L86:
            android.util.LruCache<java.lang.String, us.pinguo.repository2020.database.sticker.Sticker> r3 = us.pinguo.repository2020.database.sticker.StickerManager.o
            r3.put(r1, r2)
            goto L73
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.sticker.StickerManager.Q(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00b0 -> B:41:0x00b3). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object R(kotlin.coroutines.Continuation<? super kotlin.u> r15) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.sticker.StickerManager.R(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x04fc  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0501  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0289 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02de A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x046a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x046b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x04e0 -> B:111:0x04e3). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:116:0x0501 -> B:117:0x0506). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:118:0x0511 -> B:119:0x0521). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object S(us.pinguo.repository2020.database.sticker.StickerDetail r38, java.lang.String r39, java.lang.String r40, boolean r41, kotlin.coroutines.Continuation<? super java.lang.Boolean> r42) {
        /*
            Method dump skipped, instructions count: 1492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.sticker.StickerManager.S(us.pinguo.repository2020.database.sticker.StickerDetail, java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object V(File file, JSONObject jSONObject, Continuation<? super Boolean> continuation) throws JSONException {
        if (!jSONObject.has("filterInner")) {
            return Boxing.boxBoolean(true);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("filterInner");
        if (optJSONObject == null) {
            return Boxing.boxBoolean(true);
        }
        File file2 = new File(file, optJSONObject.getString("folder"));
        if (!file2.exists()) {
            return Boxing.boxBoolean(false);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("filters");
        if (optJSONArray == null) {
            return Boxing.boxBoolean(false);
        }
        int length = optJSONArray.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            File file3 = new File(file2, optJSONArray.getString(i2));
            if (!file3.exists()) {
                return Boxing.boxBoolean(false);
            }
            if (!new File(file3, "index.json").exists()) {
                return Boxing.boxBoolean(false);
            }
            i2 = i3;
        }
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(List<String> list, StickerUpdateData[] stickerUpdateDataArr) {
        l.d(n0.a(z0.b()), null, null, new StickerManager$processDetailUpdated$1(list, stickerUpdateDataArr, null), 3, null);
    }

    private final List<StickerCategory> Z(StickerResponseData stickerResponseData, boolean z) {
        StickerCategory[] stickerCategoryArr;
        StickerCategory[] topics = stickerResponseData.getData().getTopics();
        Map<String, Sticker> map = f11861k;
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = z ? 0L : System.currentTimeMillis();
        int length = topics.length;
        int i2 = 0;
        while (i2 < length) {
            StickerCategory stickerCategory = topics[i2];
            i2++;
            if (stickerCategory.isValid(currentTimeMillis)) {
                String[] package_ids = stickerCategory.getPackage_ids();
                ArrayList arrayList2 = new ArrayList();
                int length2 = package_ids.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        break;
                    }
                    String str = package_ids[i3];
                    i3++;
                    if (map != null && map.containsKey(str)) {
                        arrayList2.add(str);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    int type = stickerCategory.getType();
                    String topic_id = stickerCategory.getTopic_id();
                    int unlock_type = stickerCategory.getUnlock_type();
                    String icon = stickerCategory.getIcon();
                    String banner = stickerCategory.getBanner();
                    String name = stickerCategory.getName();
                    stickerCategoryArr = topics;
                    Object[] array = arrayList2.toArray(new String[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    StickerCategory copy = stickerCategory.copy(type, topic_id, unlock_type, icon, banner, name, (String[]) array, stickerCategory.getShare_id(), stickerCategory.getPriority(), stickerCategory.getVip(), stickerCategory.getOnsale_time(), stickerCategory.getOff_time());
                    String topic_id2 = copy.getTopic_id();
                    if (y.c(f11855e, topic_id2) >= 0) {
                        copy.setIcon(s.q("asset:///builtin_data/sticker/", "unity_topic_icon_" + topic_id2 + ".png"));
                    }
                    CopyOnWriteArrayList<String> copyOnWriteArrayList = s;
                    int length3 = copy.getPackage_ids().length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length3) {
                            break;
                        }
                        int i5 = i4 + 1;
                        if (copyOnWriteArrayList.contains(copy.getPackage_ids()[i4])) {
                            copy.setHasFreshSticker(true);
                            break;
                        }
                        i4 = i5;
                    }
                    arrayList.add(copy);
                    topics = stickerCategoryArr;
                }
            }
            stickerCategoryArr = topics;
            topics = stickerCategoryArr;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add("5e6a360fa35dde3d3e028c2d");
        String string = us.pinguo.foundation.e.b().getResources().getString(R.string.sticker_category_recent_name);
        s.g(string, "getAppContext().resource…ker_category_recent_name)");
        Object[] array2 = linkedList.toArray(new String[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        arrayList.add(0, new StickerCategory(-1, "recent_", -1, "", "", string, (String[]) array2, "", -1, 0, -1L, -1L));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        List<String> L = L();
        if (!L.isEmpty() && us.pinguo.util.q.f(us.pinguo.foundation.e.b())) {
            us.pinguo.foundation.statistics.h.b.n("", "/api/product/check-update", SocialConstants.TYPE_REQUEST);
            new a(L, System.currentTimeMillis(), s.q(h.c(), "/api/product/check-update")).execute();
        }
    }

    private final Object y(String str, Continuation<? super Boolean> continuation) {
        if (TextUtils.isEmpty(str)) {
            return Boxing.boxBoolean(false);
        }
        return Boxing.boxBoolean(52428800 <= o0.d(us.pinguo.foundation.e.b()).a(new File(str).getParent()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0293 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02c7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x031f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x033a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0372  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(kotlin.jvm.b.q<? super java.lang.String, ? super java.lang.String, ? super java.lang.String, kotlin.u> r19, kotlin.coroutines.Continuation<? super java.lang.Boolean> r20) {
        /*
            Method dump skipped, instructions count: 922
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.sticker.StickerManager.z(kotlin.jvm.b.q, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void B(String id) {
        s.h(id, "id");
        l.d(n0.a(z0.b()), null, null, new StickerManager$deleteSingleSticker$1(id, null), 3, null);
    }

    public final void C(String stickerId, boolean z, p<? super String, ? super Boolean, u> pVar) {
        s.h(stickerId, "stickerId");
        Map<String, Sticker> map = f11861k;
        Sticker sticker = map == null ? null : map.get(stickerId);
        if ((sticker == null ? null : sticker.getState()) == StickerState.DOWNLOADING) {
            return;
        }
        if ((sticker != null ? sticker.getState() : null) != StickerState.AVAILABLE) {
            l.d(n0.a(z0.b()), null, null, new StickerManager$downloadAndInstallSticker$1(sticker, stickerId, z, pVar, null), 3, null);
            return;
        }
        d remove = r.remove(stickerId);
        if (remove != null) {
            remove.b(100);
        }
        if (pVar == null) {
            return;
        }
        pVar.invoke(stickerId, Boolean.TRUE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object F(java.lang.String r8, kotlin.coroutines.Continuation<? super us.pinguo.repository2020.database.sticker.StickerRenderData> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof us.pinguo.repository2020.database.sticker.StickerManager$findRenderData$1
            if (r0 == 0) goto L13
            r0 = r9
            us.pinguo.repository2020.database.sticker.StickerManager$findRenderData$1 r0 = (us.pinguo.repository2020.database.sticker.StickerManager$findRenderData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.repository2020.database.sticker.StickerManager$findRenderData$1 r0 = new us.pinguo.repository2020.database.sticker.StickerManager$findRenderData$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L46
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r8 = r0.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.j.b(r9)
            goto Lb0
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            java.lang.Object r8 = r0.L$1
            java.io.File r8 = (java.io.File) r8
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.j.b(r9)
            goto L99
        L46:
            kotlin.j.b(r9)
            android.util.LruCache<java.lang.String, us.pinguo.repository2020.database.sticker.StickerRenderData> r9 = us.pinguo.repository2020.database.sticker.StickerManager.q
            java.lang.Object r9 = r9.get(r8)
            us.pinguo.repository2020.database.sticker.StickerRenderData r9 = (us.pinguo.repository2020.database.sticker.StickerRenderData) r9
            if (r9 != 0) goto Lc8
            java.util.concurrent.ConcurrentHashMap<java.lang.String, us.pinguo.repository2020.database.sticker.StickerDetail> r9 = us.pinguo.repository2020.database.sticker.StickerManager.m
            java.lang.Object r9 = r9.get(r8)
            us.pinguo.repository2020.database.sticker.StickerDetail r9 = (us.pinguo.repository2020.database.sticker.StickerDetail) r9
            if (r9 != 0) goto L5e
            return r5
        L5e:
            us.pinguo.repository2020.database.sticker.StickerDetailItem[] r9 = r9.getItems()
            r2 = 0
            r9 = r9[r2]
            java.lang.String r9 = r9.getId()
            us.pinguo.repository2020.database.EffectDbManager r2 = us.pinguo.repository2020.database.a.a()
            us.pinguo.repository2020.database.sticker.b r2 = r2.F()
            us.pinguo.repository2020.database.sticker.StickerItemTable r2 = r2.d(r9)
            if (r2 != 0) goto L79
            r2 = r5
            goto L7d
        L79:
            java.lang.String r2 = r2.getPackageMd5()
        L7d:
            if (r2 != 0) goto L80
            return r5
        L80:
            java.lang.String r9 = us.pinguo.repository2020.utils.h.h(r2, r9)
            java.io.File r2 = new java.io.File
            r2.<init>(r9)
            r0.L$0 = r8
            r0.L$1 = r2
            r0.label = r4
            java.lang.Object r9 = us.pinguo.util.FileUtils.p(r2, r0)
            if (r9 != r1) goto L96
            return r1
        L96:
            r6 = r2
            r2 = r8
            r8 = r6
        L99:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto La2
            return r5
        La2:
            r0.L$0 = r2
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r9 = us.pinguo.util.FileIOUtils.e(r8, r0)
            if (r9 != r1) goto Laf
            return r1
        Laf:
            r8 = r2
        Lb0:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto Lb5
            return r5
        Lb5:
            com.google.gson.e r0 = com.pinguo.lib.GsonUtilKt.getCachedGson()
            java.lang.Class<us.pinguo.repository2020.database.sticker.StickerRenderData> r1 = us.pinguo.repository2020.database.sticker.StickerRenderData.class
            java.lang.Object r9 = r0.j(r9, r1)
            us.pinguo.repository2020.database.sticker.StickerRenderData r9 = (us.pinguo.repository2020.database.sticker.StickerRenderData) r9
            if (r9 == 0) goto Lc8
            android.util.LruCache<java.lang.String, us.pinguo.repository2020.database.sticker.StickerRenderData> r0 = us.pinguo.repository2020.database.sticker.StickerManager.q
            r0.put(r8, r9)
        Lc8:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.sticker.StickerManager.F(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final StickerRenderData G(String id) {
        s.h(id, "id");
        return q.get(id);
    }

    public final Sticker H(String id) {
        s.h(id, "id");
        Map<String, Sticker> map = f11861k;
        if (map == null) {
            return null;
        }
        return map.get(id);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object I(java.lang.String r6, kotlin.coroutines.Continuation<? super java.lang.String> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof us.pinguo.repository2020.database.sticker.StickerManager$findStickerPackagePath$1
            if (r0 == 0) goto L13
            r0 = r7
            us.pinguo.repository2020.database.sticker.StickerManager$findStickerPackagePath$1 r0 = (us.pinguo.repository2020.database.sticker.StickerManager$findStickerPackagePath$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.repository2020.database.sticker.StickerManager$findStickerPackagePath$1 r0 = new us.pinguo.repository2020.database.sticker.StickerManager$findStickerPackagePath$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.j.b(r7)
            goto L62
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            kotlin.j.b(r7)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, us.pinguo.repository2020.database.sticker.StickerDetail> r7 = us.pinguo.repository2020.database.sticker.StickerManager.m
            java.lang.Object r6 = r7.get(r6)
            us.pinguo.repository2020.database.sticker.StickerDetail r6 = (us.pinguo.repository2020.database.sticker.StickerDetail) r6
            if (r6 != 0) goto L44
            return r3
        L44:
            java.lang.String r7 = r6.getPackage_zip_md5()
            us.pinguo.repository2020.database.sticker.StickerDetailItem[] r6 = r6.getItems()
            r2 = 0
            r6 = r6[r2]
            java.lang.String r6 = r6.getId()
            java.lang.String r6 = us.pinguo.repository2020.utils.h.g(r7, r6)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = us.pinguo.util.FileUtils.o(r6, r0)
            if (r7 != r1) goto L62
            return r1
        L62:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L6b
            return r3
        L6b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.sticker.StickerManager.I(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final List<String> L() {
        List<StickerTable> all;
        List<StickerItemTable> all2;
        boolean z;
        CopyOnWriteArrayList<String> copyOnWriteArrayList = n;
        if ((!copyOnWriteArrayList.isEmpty()) || (all = us.pinguo.repository2020.database.a.a().G().getAll()) == null || (all2 = us.pinguo.repository2020.database.a.a().F().getAll()) == null) {
            return copyOnWriteArrayList;
        }
        ConcurrentHashMap<String, StickerDetail> concurrentHashMap = m;
        for (StickerTable stickerTable : all) {
            String id = stickerTable.getId();
            boolean z2 = false;
            if (!(all2 instanceof Collection) || !all2.isEmpty()) {
                Iterator<T> it = all2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    StickerItemTable stickerItemTable = (StickerItemTable) it.next();
                    String packageId = stickerItemTable.getPackageId();
                    if (packageId == null || !s.c(packageId, id) || !s.c(stickerItemTable.getType(), "ut") || concurrentHashMap.get(packageId) == null) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        z2 = true;
                        break;
                    }
                }
            }
            if (z2) {
                Map<String, Sticker> map = f11861k;
                Sticker sticker = map == null ? null : map.get(id);
                if (sticker != null) {
                    sticker.setState(StickerState.AVAILABLE);
                }
                copyOnWriteArrayList.add(id);
            }
        }
        return copyOnWriteArrayList;
    }

    public final List<StickerCategory> N() {
        return f11860j;
    }

    public final Sticker[] O() {
        StickerJson stickerJson = f11862l;
        if (stickerJson == null) {
            return null;
        }
        return stickerJson.getPackages();
    }

    public final boolean U(String id) {
        s.h(id, "id");
        return s.c(id, "5e6a360fa35dde3d3e028c2d");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x022c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0239 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f0 A[Catch: all -> 0x0247, TryCatch #6 {all -> 0x0247, blocks: (B:73:0x0153, B:45:0x00cd, B:47:0x00d1, B:49:0x00d5, B:51:0x00d9, B:54:0x00df, B:56:0x00f0, B:64:0x012e, B:66:0x0133, B:69:0x0139, B:57:0x0101, B:59:0x011b, B:63:0x0124), top: B:134:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0101 A[Catch: all -> 0x0247, TRY_LEAVE, TryCatch #6 {all -> 0x0247, blocks: (B:73:0x0153, B:45:0x00cd, B:47:0x00d1, B:49:0x00d5, B:51:0x00d9, B:54:0x00df, B:56:0x00f0, B:64:0x012e, B:66:0x0133, B:69:0x0139, B:57:0x0101, B:59:0x011b, B:63:0x0124), top: B:134:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0133 A[Catch: all -> 0x0247, TRY_LEAVE, TryCatch #6 {all -> 0x0247, blocks: (B:73:0x0153, B:45:0x00cd, B:47:0x00d1, B:49:0x00d5, B:51:0x00d9, B:54:0x00df, B:56:0x00f0, B:64:0x012e, B:66:0x0133, B:69:0x0139, B:57:0x0101, B:59:0x011b, B:63:0x0124), top: B:134:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0139 A[Catch: all -> 0x0247, TRY_ENTER, TryCatch #6 {all -> 0x0247, blocks: (B:73:0x0153, B:45:0x00cd, B:47:0x00d1, B:49:0x00d5, B:51:0x00d9, B:54:0x00df, B:56:0x00f0, B:64:0x012e, B:66:0x0133, B:69:0x0139, B:57:0x0101, B:59:0x011b, B:63:0x0124), top: B:134:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0167 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0194 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x019f A[Catch: all -> 0x0066, TRY_LEAVE, TryCatch #5 {all -> 0x0066, blocks: (B:20:0x005f, B:85:0x0197, B:87:0x019f, B:93:0x01af, B:95:0x01d1, B:97:0x01df, B:106:0x01f8, B:91:0x01a7, B:94:0x01c7), top: B:132:0x005f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object W(kotlin.coroutines.Continuation<? super kotlin.u> r15) {
        /*
            Method dump skipped, instructions count: 612
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.sticker.StickerManager.W(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void X(String id) {
        s.h(id, "id");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = s;
        copyOnWriteArrayList.remove(id);
        Sticker H = H(id);
        if (H != null) {
            H.setFresh(false);
        }
        List<StickerCategory> list = f11860j;
        if (list == null) {
            return;
        }
        for (StickerCategory stickerCategory : list) {
            if (stickerCategory.getHasFreshSticker()) {
                int length = stickerCategory.getPackage_ids().length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        int i3 = i2 + 1;
                        stickerCategory.setHasFreshSticker(false);
                        if (copyOnWriteArrayList.contains(stickerCategory.getPackage_ids()[i2])) {
                            stickerCategory.setHasFreshSticker(true);
                            break;
                        }
                        i2 = i3;
                    }
                }
            }
        }
    }

    public final void a0(String id) {
        s.h(id, "id");
        LruCache<String, Sticker> lruCache = o;
        if (lruCache.get(id) == null) {
            Map<String, Sticker> map = f11861k;
            Sticker sticker = map == null ? null : map.get(id);
            if (sticker == null) {
                return;
            }
            lruCache.put(id, sticker);
        }
    }

    public final void b0(String id, d liveData) {
        s.h(id, "id");
        s.h(liveData, "liveData");
        r.put(id, liveData);
    }

    public final void c0(List<String> idList) {
        s.h(idList, "idList");
        for (String str : idList) {
            o.remove(str);
        }
    }

    public final void d0(String id) {
        s.h(id, "id");
        r.remove(id);
    }

    public final List<Sticker> e0() {
        Map<String, Sticker> map = o.snapshot();
        int size = map.size() <= 50 ? map.size() : 50;
        ArrayList arrayList = new ArrayList(size);
        s.g(map, "map");
        Iterator<Map.Entry<String, Sticker>> it = map.entrySet().iterator();
        int i2 = 0;
        while (i2 < size) {
            i2++;
            if (!it.hasNext()) {
                break;
            }
            arrayList.add(0, it.next().getValue());
        }
        return arrayList;
    }

    public final void f0() {
        l.d(n0.a(z0.b()), null, null, new StickerManager$unInflateFreshStickers$1(null), 3, null);
    }

    public final void g0() {
        l.d(n0.a(z0.b()), null, null, new StickerManager$unInflateRecentStickers$1(null), 3, null);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [us.pinguo.repository2020.utils.RequestIntervalPref$RefreshType, T] */
    /* JADX WARN: Type inference failed for: r7v4, types: [us.pinguo.repository2020.utils.RequestIntervalPref$RefreshType, T] */
    /* JADX WARN: Type inference failed for: r7v8, types: [us.pinguo.repository2020.utils.RequestIntervalPref$RefreshType, T] */
    public final void h0(boolean z) {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        if (z) {
            ref$ObjectRef.element = RequestIntervalPref.RefreshType.RESET_REFRESH;
        } else {
            int i2 = j.e().i("key_fource_update_unity_version", 0);
            ref$ObjectRef.element = RequestIntervalPref.RefreshType.TIME_REFRESH;
            if (i2 >= 0) {
                ?? c2 = RequestIntervalPref.a.c("/api/product/unity-system", -1L, null);
                ref$ObjectRef.element = c2;
                if (c2 == RequestIntervalPref.RefreshType.NONE_REFRESH) {
                    return;
                }
            }
        }
        us.pinguo.foundation.statistics.h.b.n("", "/api/product/unity-system", SocialConstants.TYPE_REQUEST);
        final long currentTimeMillis = System.currentTimeMillis();
        final String q2 = s.q(h.c(), "/api/product/unity-system");
        new HttpStringRequest(q2) { // from class: us.pinguo.repository2020.database.sticker.StickerManager$updateSticker$request$1
            @Override // com.android.volley.Request
            protected Map<String, String> getParams() {
                StickerJson stickerJson;
                HashMap hashMap = new HashMap();
                u0.e(us.pinguo.foundation.e.b(), hashMap);
                if (ref$ObjectRef.element != RequestIntervalPref.RefreshType.RESET_REFRESH) {
                    stickerJson = StickerManager.f11862l;
                    hashMap.put("version", String.valueOf(stickerJson == null ? 0 : stickerJson.getVersion()));
                } else {
                    Locale a2 = us.pinguo.foundation.utils.v.a();
                    String language = a2.getLanguage();
                    String country = a2.getCountry();
                    if (country == null) {
                        country = "";
                    }
                    PGNetworkConfig.getInstance().resetLocale(language, country);
                    hashMap.put("version", "0");
                    hashMap.put("UTCOffset", String.valueOf(TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000));
                }
                us.pinguo.foundation.m.d.c(hashMap, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
                return hashMap;
            }

            @Override // us.pinguo.common.network.HttpRequestBase
            protected void onErrorResponse(Exception e2) {
                s.h(e2, "e");
                i iVar = us.pinguo.foundation.statistics.h.b;
                iVar.n((System.currentTimeMillis() - currentTimeMillis) + "", "/api/product/unity-system", "failed");
                e2.printStackTrace();
                us.pinguo.common.log.a.f(e2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // us.pinguo.common.network.HttpRequestBase
            public void onResponse(String response) {
                s.h(response, "response");
                i iVar = us.pinguo.foundation.statistics.h.b;
                iVar.n((System.currentTimeMillis() - currentTimeMillis) + "", "/api/product/unity-system", FirebaseAnalytics.Param.SUCCESS);
                StickerResponseData stickerResponseData = (StickerResponseData) GsonUtilKt.getCachedGson().j(response, StickerResponseData.class);
                if (stickerResponseData != null) {
                    StickerJson data = stickerResponseData.getData();
                    if ((data == null ? null : data.getPackages()) != null) {
                        StickerJson data2 = stickerResponseData.getData();
                        if ((data2 == null ? null : data2.getTopics()) != null) {
                            if (stickerResponseData.getStatus() == 10220) {
                                j.e().q("key_fource_update_unity_version", r4);
                                RequestIntervalPref.a.d("/api/product/unity-system", -1L, null);
                                return;
                            } else if (stickerResponseData.getStatus() == 200) {
                                l.d(n0.a(z0.b()), null, null, new StickerManager$updateSticker$request$1$onResponse$1(r4, stickerResponseData, response, null), 3, null);
                                return;
                            } else {
                                new Exception(stickerResponseData.getMessage()).printStackTrace();
                                return;
                            }
                        }
                    }
                }
                CrashReport.postCatchedException(new IllegalStateException(s.q("/api/product/unity-system :", response)));
            }
        }.execute();
    }
}
