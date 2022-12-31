package us.pinguo.repository2020.manager;

import android.content.res.AssetManager;
import androidx.databinding.ObservableField;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pinguo.camera360.abtest.Plan;
import com.pinguo.lib.GsonUtilKt;
import com.tencent.open.SocialConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.repository2020.BeautyDataRepository;
import us.pinguo.repository2020.entity.MaterialDetail;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.entity.MaterialResponse;
import us.pinguo.repository2020.entity.SelfDefMakeup;
import us.pinguo.repository2020.entity.SelfDefMakeupMaterial;
import us.pinguo.repository2020.entity.SelfDefMakeupResponse;
import us.pinguo.repository2020.entity.StyleMakeup;
import us.pinguo.repository2020.entity.StyleMakeupDetail;
import us.pinguo.repository2020.entity.StyleMakeupUpdateData;
import us.pinguo.repository2020.network.HttpBaseResponse;
import us.pinguo.repository2020.u;
import us.pinguo.repository2020.utils.RequestIntervalPref;
import us.pinguo.repository2020.utils.n;
import us.pinguo.user.u0;
/* compiled from: BeautyDataManager.kt */
/* loaded from: classes6.dex */
public final class BeautyDataManager {
    private static final boolean b;

    /* renamed from: h */
    private static SelfDefMakeupResponse f11897h;
    public static final BeautyDataManager a = new BeautyDataManager();
    private static final BeautyDataRepository c = new BeautyDataRepository();

    /* renamed from: d */
    private static final us.pinguo.repository2020.l f11893d = new us.pinguo.repository2020.l();

    /* renamed from: e */
    private static final HashMap<String, StyleMakeup> f11894e = new HashMap<>();

    /* renamed from: f */
    private static final HashMap<String, SelfDefMakeup> f11895f = new HashMap<>();

    /* renamed from: g */
    private static u<MaterialResponse<StyleMakeup>> f11896g = new u<>(null);

    /* renamed from: i */
    private static final String f11898i = us.pinguo.foundation.e.b().getFilesDir() + "/shop/unity_style_makeup.json";

    /* renamed from: j */
    private static final String f11899j = us.pinguo.foundation.e.b().getFilesDir() + "/shop/unity_selfdef_makeup.json";

    /* renamed from: k */
    private static final String f11900k = us.pinguo.foundation.e.b().getFilesDir() + "/shop/unity_edit_style_makeup.json";

    /* renamed from: l */
    private static final String f11901l = us.pinguo.foundation.e.b().getFilesDir() + "/shop/unity_edit_selfdef_makeup.json";

    /* compiled from: BeautyDataManager.kt */
    /* loaded from: classes6.dex */
    public static final class a extends com.google.gson.t.a<HttpBaseResponse<SelfDefMakeupResponse>> {
        a() {
        }
    }

    /* compiled from: BeautyDataManager.kt */
    /* loaded from: classes6.dex */
    public static final class b extends com.google.gson.t.a<HttpBaseResponse<MaterialResponse<StyleMakeup>>> {
        b() {
        }
    }

    /* compiled from: BeautyDataManager.kt */
    /* loaded from: classes6.dex */
    public static final class c extends us.pinguo.repository2020.network.c<HttpBaseResponse<StyleMakeupDetail[]>> {
        final /* synthetic */ String[] a;
        final /* synthetic */ long b;
        final /* synthetic */ q<StyleMakeupDetail[], Boolean, String, kotlin.u> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(String[] strArr, long j2, q<? super StyleMakeupDetail[], ? super Boolean, ? super String, kotlin.u> qVar, String str) {
            super(1, str);
            this.a = strArr;
            this.b = j2;
            this.c = qVar;
        }

        @Override // us.pinguo.repository2020.network.c, com.android.volley.Request
        public Map<String, String> getParams() {
            Map<String, String> params = super.getParams();
            u0.e(us.pinguo.foundation.e.b(), params);
            com.google.gson.h hVar = new com.google.gson.h();
            String[] strArr = this.a;
            int length = strArr.length;
            int i2 = 0;
            while (i2 < length) {
                String str = strArr[i2];
                i2++;
                hVar.j(str);
            }
            String kVar = hVar.toString();
            s.g(kVar, "jsonArray.toString()");
            params.put("ids", kVar);
            us.pinguo.foundation.m.d.c(params, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
            return params;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception exc) {
            us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
            iVar.n((System.currentTimeMillis() - this.b) + "", "/api/product/detail", "failed");
            us.pinguo.common.log.a.f(exc);
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        public void onResponse(HttpBaseResponse<StyleMakeupDetail[]> httpBaseResponse) {
            us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
            iVar.n((System.currentTimeMillis() - this.b) + "", "/api/product/detail", FirebaseAnalytics.Param.SUCCESS);
            if (httpBaseResponse == null) {
                new NullPointerException().printStackTrace();
                this.c.invoke(null, Boolean.FALSE, "");
            } else if (httpBaseResponse.getStatus() == 10220) {
                RequestIntervalPref requestIntervalPref = RequestIntervalPref.a;
                String url = getUrl();
                s.g(url, "url");
                requestIntervalPref.d(url, -1L, null);
                this.c.invoke(null, Boolean.FALSE, httpBaseResponse.getMessage());
            } else if (httpBaseResponse.getStatus() != 200) {
                new Exception(httpBaseResponse.getMessage()).printStackTrace();
                this.c.invoke(null, Boolean.FALSE, httpBaseResponse.getMessage());
            } else {
                this.c.invoke(httpBaseResponse.getData(), Boolean.TRUE, "");
            }
        }
    }

    static {
        Locale locale = Locale.getDefault();
        b = s.c("zh", locale.getLanguage()) && s.c("CN", locale.getCountry());
    }

    private BeautyDataManager() {
    }

    private final void f(boolean z) {
        InputStreamReader inputStreamReader;
        Type type = new a().getType();
        if (new File(z ? f11899j : f11901l).exists()) {
            inputStreamReader = new InputStreamReader(new BufferedInputStream(new FileInputStream(z ? f11899j : f11901l)));
        } else {
            String str = b ? "selfdefmakeup_cn" : "selfdefmakeup_en";
            AssetManager assets = us.pinguo.foundation.e.b().getAssets();
            inputStreamReader = new InputStreamReader(new BufferedInputStream(assets.open("builtin_data/beauty/selfdefmakeup/" + str + ".json", 3)));
        }
        com.google.gson.e cachedGson = GsonUtilKt.getCachedGson();
        s.g(type, "type");
        HttpBaseResponse httpBaseResponse = (HttpBaseResponse) us.pinguo.repository2020.utils.l.a(cachedGson, inputStreamReader, type, "buildLocalDefaultMakeupData");
        inputStreamReader.close();
        h(httpBaseResponse == null ? null : (SelfDefMakeupResponse) httpBaseResponse.getData());
    }

    private final void g(boolean z) {
        InputStreamReader inputStreamReader;
        String str;
        Type type = new b().getType();
        File file = new File(z ? f11898i : f11900k);
        if (file.exists()) {
            str = s.q("from sdCard path=", file.getAbsolutePath());
            inputStreamReader = new InputStreamReader(new BufferedInputStream(new FileInputStream(z ? f11898i : f11900k)));
        } else {
            String str2 = b ? "stylemakeup_cn" : "stylemakeup_en";
            AssetManager assets = us.pinguo.foundation.e.b().getAssets();
            inputStreamReader = new InputStreamReader(new BufferedInputStream(assets.open("builtin_data/beauty/stylemakeup/" + str2 + ".json", 3)));
            str = "from builtIn";
        }
        com.google.gson.e cachedGson = GsonUtilKt.getCachedGson();
        s.g(type, "type");
        HttpBaseResponse httpBaseResponse = (HttpBaseResponse) us.pinguo.repository2020.utils.l.a(cachedGson, inputStreamReader, type, str);
        inputStreamReader.close();
        i(httpBaseResponse == null ? null : (MaterialResponse) httpBaseResponse.getData(), Boolean.valueOf(z));
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void h(us.pinguo.repository2020.entity.SelfDefMakeupResponse r9) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.BeautyDataManager.h(us.pinguo.repository2020.entity.SelfDefMakeupResponse):void");
    }

    private final void i(MaterialResponse<StyleMakeup> materialResponse, Boolean bool) {
        List<StyleMakeup> suites = materialResponse == null ? null : materialResponse.getSuites();
        List<String> layouts = materialResponse != null ? materialResponse.getLayouts() : null;
        if (materialResponse != null) {
            if (suites == null || suites.isEmpty()) {
                return;
            }
            kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new BeautyDataManager$buildStyleMakeupMap$1(bool, suites, layouts, materialResponse, null), 3, null);
        }
    }

    private final void s(String[] strArr, q<? super StyleMakeupDetail[], ? super Boolean, ? super String, kotlin.u> qVar) {
        us.pinguo.foundation.statistics.h.b.n("", "/api/product/detail", SocialConstants.TYPE_REQUEST);
        new c(strArr, System.currentTimeMillis(), qVar, s.q(n.a.a(), "/api/product/detail")).execute();
    }

    public static /* synthetic */ void u(BeautyDataManager beautyDataManager, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        beautyDataManager.t(z, z2);
    }

    public final void w() {
        final CopyOnWriteArrayList<String> n = c.n();
        us.pinguo.foundation.statistics.h.b.n("", "/api/product/check-update", SocialConstants.TYPE_REQUEST);
        final long currentTimeMillis = System.currentTimeMillis();
        new us.pinguo.repository2020.network.c<HttpBaseResponse<StyleMakeupUpdateData[]>>(s.q(n.a.a(), "/api/product/check-update")) { // from class: us.pinguo.repository2020.manager.BeautyDataManager$updateStyleMakeupDetail$request$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // us.pinguo.repository2020.network.c, com.android.volley.Request
            public Map<String, String> getParams() {
                Iterator<T> it;
                Map<String, String> params = super.getParams();
                u0.e(us.pinguo.foundation.e.b(), params);
                String str = "";
                while (n.iterator().hasNext()) {
                    str = str + ((Object) ((String) it.next())) + ',';
                }
                String substring = str.substring(0, str.length() == 0 ? 0 : str.length() - 1);
                s.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                params.put("pids", substring);
                us.pinguo.foundation.m.d.c(params, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
                return params;
            }

            @Override // us.pinguo.common.network.HttpRequestBase
            protected void onErrorResponse(Exception exc) {
                us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
                iVar.n((System.currentTimeMillis() - currentTimeMillis) + "", "/api/product/check-update", "failed");
                us.pinguo.common.log.a.f(exc);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x006b, code lost:
                if ((r10.length == 0) != false) goto L25;
             */
            @Override // us.pinguo.common.network.HttpRequestBase
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onResponse(us.pinguo.repository2020.network.HttpBaseResponse<us.pinguo.repository2020.entity.StyleMakeupUpdateData[]> r10) {
                /*
                    r9 = this;
                    us.pinguo.foundation.statistics.i r0 = us.pinguo.foundation.statistics.h.b
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    long r2 = java.lang.System.currentTimeMillis()
                    long r4 = r2
                    long r2 = r2 - r4
                    r1.append(r2)
                    java.lang.String r2 = ""
                    r1.append(r2)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "/api/product/check-update"
                    java.lang.String r3 = "success"
                    r0.n(r1, r2, r3)
                    if (r10 != 0) goto L2c
                    java.lang.NullPointerException r10 = new java.lang.NullPointerException
                    r10.<init>()
                    r10.printStackTrace()
                    return
                L2c:
                    int r0 = r10.getStatus()
                    r1 = 10220(0x27ec, float:1.4321E-41)
                    r2 = 0
                    if (r0 != r1) goto L46
                    us.pinguo.repository2020.utils.RequestIntervalPref r10 = us.pinguo.repository2020.utils.RequestIntervalPref.a
                    java.lang.String r0 = r9.getUrl()
                    java.lang.String r1 = "url"
                    kotlin.jvm.internal.s.g(r0, r1)
                    r3 = -1
                    r10.d(r0, r3, r2)
                    return
                L46:
                    int r0 = r10.getStatus()
                    r1 = 200(0xc8, float:2.8E-43)
                    if (r0 == r1) goto L5b
                    java.lang.Exception r0 = new java.lang.Exception
                    java.lang.String r10 = r10.getMessage()
                    r0.<init>(r10)
                    r0.printStackTrace()
                    return
                L5b:
                    java.lang.Object r10 = r10.getData()
                    us.pinguo.repository2020.entity.StyleMakeupUpdateData[] r10 = (us.pinguo.repository2020.entity.StyleMakeupUpdateData[]) r10
                    r0 = 0
                    r1 = 1
                    if (r10 == 0) goto L6d
                    int r3 = r10.length
                    if (r3 != 0) goto L6a
                    r3 = 1
                    goto L6b
                L6a:
                    r3 = 0
                L6b:
                    if (r3 == 0) goto L6e
                L6d:
                    r0 = 1
                L6e:
                    if (r0 == 0) goto L71
                    return
                L71:
                    kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.z0.b()
                    kotlinx.coroutines.m0 r3 = kotlinx.coroutines.n0.a(r0)
                    r4 = 0
                    r5 = 0
                    us.pinguo.repository2020.manager.BeautyDataManager$updateStyleMakeupDetail$request$1$onResponse$1 r6 = new us.pinguo.repository2020.manager.BeautyDataManager$updateStyleMakeupDetail$request$1$onResponse$1
                    java.util.concurrent.CopyOnWriteArrayList<java.lang.String> r0 = r1
                    r6.<init>(r10, r0, r2)
                    r7 = 3
                    r8 = 0
                    kotlinx.coroutines.j.d(r3, r4, r5, r6, r7, r8)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.BeautyDataManager$updateStyleMakeupDetail$request$1.onResponse(us.pinguo.repository2020.network.HttpBaseResponse):void");
            }
        }.execute();
    }

    public final void j(SelfDefMakeupMaterial material, q<? super Boolean, ? super SelfDefMakeupMaterial, ? super String, kotlin.u> downloadAction) {
        ObservableField<MaterialInstallState> installState;
        s.h(material, "material");
        s.h(downloadAction, "downloadAction");
        SelfDefMakeup selfDefMakeup = f11895f.get(material.getPid());
        if (selfDefMakeup != null && (installState = selfDefMakeup.getInstallState()) != null) {
            installState.set(MaterialInstallState.STATE_DOWNLOADING);
        }
        BeautyDownloadManager.a.a(material, new BeautyDataManager$downloadAndInstallSelfDefMakeupMaterial$1(downloadAction));
    }

    public final void k(String styleMakeupId, q<? super Boolean, ? super MaterialDetail, ? super String, kotlin.u> downloadAction) {
        s.h(styleMakeupId, "styleMakeupId");
        s.h(downloadAction, "downloadAction");
        s(new String[]{styleMakeupId}, new BeautyDataManager$downloadAndInstallStyleMakeup$1(styleMakeupId, downloadAction));
    }

    public final BeautyDataRepository l() {
        return c;
    }

    public final us.pinguo.repository2020.l m() {
        return f11893d;
    }

    public final HashMap<String, SelfDefMakeup> n() {
        return f11895f;
    }

    public final SelfDefMakeupResponse o() {
        return f11897h;
    }

    public final u<MaterialResponse<StyleMakeup>> p() {
        return f11896g;
    }

    public final HashMap<String, StyleMakeup> q() {
        return f11894e;
    }

    public final void r(boolean z, final boolean z2) {
        Integer interval;
        f(z2);
        if (!z && f11897h != null) {
            RequestIntervalPref requestIntervalPref = RequestIntervalPref.a;
            SelfDefMakeupResponse selfDefMakeupResponse = f11897h;
            long j2 = -1;
            if (selfDefMakeupResponse != null && (interval = selfDefMakeupResponse.getInterval()) != null) {
                j2 = interval.intValue();
            }
            if (requestIntervalPref.c("/api/product/unity-makeup", j2, null) == RequestIntervalPref.RefreshType.NONE_REFRESH) {
                return;
            }
        }
        us.pinguo.foundation.statistics.h.b.n("", "/api/product/unity-makeup", SocialConstants.TYPE_REQUEST);
        final long currentTimeMillis = System.currentTimeMillis();
        new us.pinguo.repository2020.network.c<String>(s.q(n.a.a(), "/api/product/unity-makeup")) { // from class: us.pinguo.repository2020.manager.BeautyDataManager$loadSelfDefMakeupData$request$1

            /* compiled from: BeautyDataManager.kt */
            /* loaded from: classes6.dex */
            public static final class a extends com.google.gson.t.a<HttpBaseResponse<SelfDefMakeupResponse>> {
                a() {
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // us.pinguo.repository2020.network.c, com.android.volley.Request
            public Map<String, String> getParams() {
                Map<String, String> params = super.getParams();
                u0.e(us.pinguo.foundation.e.b(), params);
                us.pinguo.foundation.m.d.c(params, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
                return params;
            }

            @Override // us.pinguo.common.network.HttpRequestBase
            protected void onErrorResponse(Exception e2) {
                s.h(e2, "e");
                us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
                iVar.n((System.currentTimeMillis() - currentTimeMillis) + "", r3, "failed");
                e2.printStackTrace();
                us.pinguo.common.log.a.f(e2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // us.pinguo.common.network.HttpRequestBase
            public void onResponse(String str) {
                us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
                iVar.n((System.currentTimeMillis() - currentTimeMillis) + "", r3, FirebaseAnalytics.Param.SUCCESS);
                if (str == null) {
                    new NullPointerException().printStackTrace();
                    return;
                }
                HttpBaseResponse httpBaseResponse = (HttpBaseResponse) GsonUtilKt.getCachedGson().k(str, HttpBaseResponse.class);
                if (httpBaseResponse.getStatus() == 10220) {
                    RequestIntervalPref requestIntervalPref2 = RequestIntervalPref.a;
                    boolean z3 = z2;
                    requestIntervalPref2.d("/api/product/unity-makeup", -1L, null);
                } else if (httpBaseResponse.getStatus() != 200) {
                    new Exception(httpBaseResponse.getMessage()).printStackTrace();
                } else {
                    HttpBaseResponse httpBaseResponse2 = (HttpBaseResponse) GsonUtilKt.getCachedGson().k(str, new a().getType());
                    if (httpBaseResponse2 == null) {
                        return;
                    }
                    ArrayList<SelfDefMakeup> packages = ((SelfDefMakeupResponse) httpBaseResponse2.getData()).getPackages();
                    if (packages == null || packages.isEmpty()) {
                        return;
                    }
                    kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new BeautyDataManager$loadSelfDefMakeupData$request$1$onResponse$1(httpBaseResponse2, z2, str, null), 3, null);
                }
            }
        }.execute();
    }

    public final void t(boolean z, final boolean z2) {
        RequestIntervalPref.RefreshType refreshType;
        Integer interval;
        g(z2);
        if (!z && f11896g.getValue() != null) {
            RequestIntervalPref requestIntervalPref = RequestIntervalPref.a;
            String str = z2 ? "/api/product/unity-suit" : "/api/product/unity-suit-edit";
            MaterialResponse<StyleMakeup> value = f11896g.getValue();
            long j2 = -1;
            if (value != null && (interval = value.getInterval()) != null) {
                j2 = interval.intValue();
            }
            refreshType = requestIntervalPref.c(str, j2, null);
            if (refreshType == RequestIntervalPref.RefreshType.NONE_REFRESH) {
                return;
            }
        } else {
            refreshType = RequestIntervalPref.RefreshType.RESET_REFRESH;
        }
        final RequestIntervalPref.RefreshType refreshType2 = refreshType;
        final String str2 = z2 ? "/api/product/unity-suit" : "/api/product/unity-suit-edit";
        us.pinguo.foundation.statistics.h.b.n("", str2, SocialConstants.TYPE_REQUEST);
        final long currentTimeMillis = System.currentTimeMillis();
        new us.pinguo.repository2020.network.c<String>(s.q(n.a.a(), str2)) { // from class: us.pinguo.repository2020.manager.BeautyDataManager$loadStyleMakeupSuitData$request$1

            /* compiled from: BeautyDataManager.kt */
            /* loaded from: classes6.dex */
            public static final class a extends com.google.gson.t.a<HttpBaseResponse<MaterialResponse<StyleMakeup>>> {
                a() {
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // us.pinguo.repository2020.network.c, com.android.volley.Request
            public Map<String, String> getParams() {
                Integer version;
                Map<String, String> params = super.getParams();
                u0.e(us.pinguo.foundation.e.b(), params);
                if (RequestIntervalPref.RefreshType.this == RequestIntervalPref.RefreshType.RESET_REFRESH) {
                    params.put("version", "0");
                } else {
                    MaterialResponse<StyleMakeup> value2 = BeautyDataManager.a.p().getValue();
                    int i2 = 0;
                    if (value2 != null && (version = value2.getVersion()) != null) {
                        i2 = version.intValue();
                    }
                    params.put("version", String.valueOf(i2));
                }
                us.pinguo.foundation.m.d.c(params, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
                return params;
            }

            @Override // us.pinguo.common.network.HttpRequestBase
            protected void onErrorResponse(Exception e2) {
                s.h(e2, "e");
                us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
                iVar.n((System.currentTimeMillis() - currentTimeMillis) + "", str2, "failed");
                e2.printStackTrace();
                us.pinguo.common.log.a.f(e2);
                iVar.v0("camera_looks", "get_list_error", "get_list_error", "get_success");
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // us.pinguo.common.network.HttpRequestBase
            public void onResponse(String str3) {
                Integer interval2;
                us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
                iVar.n((System.currentTimeMillis() - currentTimeMillis) + "", str2, FirebaseAnalytics.Param.SUCCESS);
                if (str3 == null) {
                    new NullPointerException().printStackTrace();
                    return;
                }
                HttpBaseResponse httpBaseResponse = (HttpBaseResponse) GsonUtilKt.getCachedGson().k(str3, HttpBaseResponse.class);
                if (httpBaseResponse.getStatus() == 10220) {
                    RequestIntervalPref.a.d(z2 ? "/api/product/unity-suit" : "/api/product/unity-suit-edit", -1L, null);
                } else if (httpBaseResponse.getStatus() != 200) {
                    new Exception(httpBaseResponse.getMessage()).printStackTrace();
                } else {
                    HttpBaseResponse httpBaseResponse2 = (HttpBaseResponse) GsonUtilKt.getCachedGson().k(str3, new a().getType());
                    if (httpBaseResponse2 == null) {
                        return;
                    }
                    BeautyDataManager beautyDataManager = BeautyDataManager.a;
                    MaterialResponse<StyleMakeup> value2 = beautyDataManager.p().getValue();
                    List<StyleMakeup> suites = value2 == null ? null : value2.getSuites();
                    boolean z3 = true;
                    int i2 = 0;
                    if (!(suites == null || suites.isEmpty())) {
                        List suites2 = ((MaterialResponse) httpBaseResponse2.getData()).getSuites();
                        if (suites2 != null && !suites2.isEmpty()) {
                            z3 = false;
                        }
                        if (z3) {
                            return;
                        }
                    }
                    RequestIntervalPref requestIntervalPref2 = RequestIntervalPref.a;
                    String str4 = z2 ? "/api/product/unity-suit" : "/api/product/unity-suit-edit";
                    MaterialResponse<StyleMakeup> value3 = beautyDataManager.p().getValue();
                    if (value3 != null && (interval2 = value3.getInterval()) != null) {
                        i2 = interval2.intValue();
                    }
                    requestIntervalPref2.d(str4, i2 * 1000, null);
                    kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new BeautyDataManager$loadStyleMakeupSuitData$request$1$onResponse$1(z2, str3, null), 3, null);
                    beautyDataManager.w();
                    Plan suites_ab_sort = ((MaterialResponse) httpBaseResponse2.getData()).getSuites_ab_sort();
                    if (suites_ab_sort == null) {
                        return;
                    }
                    String tid = suites_ab_sort.getTid();
                    if (tid == null) {
                        tid = "get_list_error";
                    }
                    String gid = suites_ab_sort.getGid();
                    iVar.v0("camera_looks", tid, gid != null ? gid : "get_list_error", "apply_success");
                }
            }
        }.execute();
    }

    public final void v() {
        c.x();
    }
}
