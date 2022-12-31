package us.pinguo.repository2020.manager;

import android.content.res.AssetManager;
import androidx.databinding.ObservableField;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pinguo.lib.GsonUtilKt;
import com.tencent.open.SocialConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.repository2020.R;
import us.pinguo.repository2020.entity.BackgroundBlur;
import us.pinguo.repository2020.entity.BackgroundBlurMaterial;
import us.pinguo.repository2020.entity.BackgroundBlurShape;
import us.pinguo.repository2020.entity.BlurResponse;
import us.pinguo.repository2020.entity.BlurShapeResponse;
import us.pinguo.repository2020.entity.Config;
import us.pinguo.repository2020.entity.Material;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.network.HttpBaseResponse;
import us.pinguo.repository2020.utils.RequestIntervalPref;
import us.pinguo.repository2020.utils.n;
import us.pinguo.user.u0;
import us.pinguo.util.v;
/* compiled from: BackgroundBlurDataManager.kt */
/* loaded from: classes6.dex */
public final class BackgroundBlurDataManager {
    private static BlurResponse b;
    private static BlurShapeResponse c;

    /* renamed from: h  reason: collision with root package name */
    private static final boolean f11890h;
    public static final BackgroundBlurDataManager a = new BackgroundBlurDataManager();

    /* renamed from: d  reason: collision with root package name */
    private static final String f11886d = us.pinguo.foundation.e.b().getFilesDir() + "/shop/unity_edit_background_blur.json";

    /* renamed from: e  reason: collision with root package name */
    private static final String f11887e = us.pinguo.foundation.e.b().getFilesDir() + "/shop/unity_edit_customize_background_blur.json";

    /* renamed from: f  reason: collision with root package name */
    private static final String f11888f = us.pinguo.foundation.e.b().getFilesDir() + "/shop/unity_edit_background_blur_shape.json";

    /* renamed from: g  reason: collision with root package name */
    private static final HashMap<String, BackgroundBlurMaterial> f11889g = new HashMap<>();

    /* compiled from: BackgroundBlurDataManager.kt */
    /* loaded from: classes6.dex */
    public static final class a extends com.google.gson.t.a<List<? extends BackgroundBlur>> {
        a() {
        }
    }

    /* compiled from: BackgroundBlurDataManager.kt */
    /* loaded from: classes6.dex */
    public static final class b extends com.google.gson.t.a<HttpBaseResponse<BlurShapeResponse>> {
        b() {
        }
    }

    /* compiled from: BackgroundBlurDataManager.kt */
    /* loaded from: classes6.dex */
    public static final class c extends com.google.gson.t.a<HttpBaseResponse<BlurResponse>> {
        c() {
        }
    }

    /* compiled from: BackgroundBlurDataManager.kt */
    /* loaded from: classes6.dex */
    public static final class d extends com.google.gson.t.a<Config> {
        d() {
        }
    }

    static {
        Locale locale = Locale.getDefault();
        f11890h = s.c("zh", locale.getLanguage()) && s.c("CN", locale.getCountry());
    }

    private BackgroundBlurDataManager() {
    }

    private final void f() {
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new BackgroundBlurDataManager$buildBlurMap$1(null), 3, null);
    }

    private final void g() {
        InputStreamReader inputStreamReader;
        List<BackgroundBlur> packages;
        InputStreamReader inputStreamReader2;
        List<BackgroundBlur> packages2;
        Type type = new c().getType();
        String str = f11886d;
        if (new File(str).exists()) {
            inputStreamReader = new InputStreamReader(new BufferedInputStream(new FileInputStream(str)));
        } else {
            String str2 = f11890h ? "blur_cn" : "blur_en";
            AssetManager assets = us.pinguo.foundation.e.b().getAssets();
            inputStreamReader = new InputStreamReader(new BufferedInputStream(assets.open("builtin_data/blur/" + str2 + ".json", 3)));
        }
        try {
            BackgroundBlurDataManager backgroundBlurDataManager = a;
            HttpBaseResponse httpBaseResponse = (HttpBaseResponse) GsonUtilKt.getCachedGson().i(inputStreamReader, type);
            backgroundBlurDataManager.r(httpBaseResponse == null ? null : (BlurResponse) httpBaseResponse.getData());
            u uVar = u.a;
            kotlin.io.b.a(inputStreamReader, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        BackgroundBlur backgroundBlur = new BackgroundBlur(Material.MATERIAL_CUSTOMIZATION, Material.MATERIAL_CUSTOMIZATION, v.a().getString(R.string.background_blur_customize_lens), "ic_lens_customize", 0, 0L, 0L, 0, 1, "", "", null, null, 6144, null);
        backgroundBlur.setCustomizeItem(true);
        ObservableField<MaterialInstallState> installState = backgroundBlur.getInstallState();
        if (installState != null) {
            installState.set(MaterialInstallState.STATE_INSTALLED);
        }
        BlurResponse blurResponse = b;
        if (blurResponse != null && (packages2 = blurResponse.getPackages()) != null) {
            packages2.add(backgroundBlur);
        }
        Type type2 = new a().getType();
        String str3 = f11887e;
        InputStreamReader inputStreamReader3 = new File(str3).exists() ? new InputStreamReader(new BufferedInputStream(new FileInputStream(str3))) : null;
        if (inputStreamReader3 != null) {
            try {
                List customizeBlurList = (List) GsonUtilKt.getCachedGson().i(inputStreamReader3, type2);
                kotlin.io.b.a(inputStreamReader3, null);
                BlurResponse blurResponse2 = b;
                if (blurResponse2 != null && (packages = blurResponse2.getPackages()) != null) {
                    s.g(customizeBlurList, "customizeBlurList");
                    packages.addAll(0, customizeBlurList);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        Type type3 = new b().getType();
        String str4 = f11888f;
        if (new File(str4).exists()) {
            inputStreamReader2 = new InputStreamReader(new BufferedInputStream(new FileInputStream(str4)));
        } else {
            String str5 = f11890h ? "blur_shape_cn" : "blur_shape_en";
            AssetManager assets2 = us.pinguo.foundation.e.b().getAssets();
            inputStreamReader2 = new InputStreamReader(new BufferedInputStream(assets2.open("builtin_data/blur/" + str5 + ".json", 3)));
        }
        try {
            HttpBaseResponse httpBaseResponse2 = (HttpBaseResponse) GsonUtilKt.getCachedGson().i(inputStreamReader2, type3);
            BlurShapeResponse blurShapeResponse = httpBaseResponse2 == null ? null : (BlurShapeResponse) httpBaseResponse2.getData();
            kotlin.io.b.a(inputStreamReader, null);
            c = blurShapeResponse;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        f();
    }

    private final void i(boolean z) {
        Integer interval;
        if (!z && b != null) {
            RequestIntervalPref requestIntervalPref = RequestIntervalPref.a;
            BlurResponse blurResponse = b;
            long j2 = -1;
            if (blurResponse != null && (interval = blurResponse.getInterval()) != null) {
                j2 = interval.intValue();
            }
            if (requestIntervalPref.c("/api/product/unity-blur", j2, null) == RequestIntervalPref.RefreshType.NONE_REFRESH) {
                return;
            }
        }
        us.pinguo.foundation.statistics.h.b.n("", "/api/product/unity-blur", SocialConstants.TYPE_REQUEST);
        final long currentTimeMillis = System.currentTimeMillis();
        final String q = s.q(n.a.a(), "/api/product/unity-blur");
        new us.pinguo.repository2020.network.c<String>(q) { // from class: us.pinguo.repository2020.manager.BackgroundBlurDataManager$fetchBlurFromServer$request$1
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
                try {
                    HttpBaseResponse httpBaseResponse = (HttpBaseResponse) GsonUtilKt.getCachedGson().k(str, HttpBaseResponse.class);
                    if (httpBaseResponse.getStatus() == 10220) {
                        RequestIntervalPref.a.d("/api/product/unity-blur", -1L, null);
                    } else if (httpBaseResponse.getStatus() == 200) {
                        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new BackgroundBlurDataManager$fetchBlurFromServer$request$1$onResponse$1(str, null), 3, null);
                    } else {
                        new Exception(httpBaseResponse.getMessage()).printStackTrace();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }.execute();
    }

    private final void j(boolean z) {
        Integer interval;
        if (!z && c != null) {
            RequestIntervalPref requestIntervalPref = RequestIntervalPref.a;
            BlurShapeResponse blurShapeResponse = c;
            long j2 = -1;
            if (blurShapeResponse != null && (interval = blurShapeResponse.getInterval()) != null) {
                j2 = interval.intValue();
            }
            if (requestIntervalPref.c("/api/product/unity-light", j2, null) == RequestIntervalPref.RefreshType.NONE_REFRESH) {
                return;
            }
        }
        us.pinguo.foundation.statistics.h.b.n("", "/api/product/unity-light", SocialConstants.TYPE_REQUEST);
        final long currentTimeMillis = System.currentTimeMillis();
        final String q = s.q(n.a.a(), "/api/product/unity-light");
        new us.pinguo.repository2020.network.c<String>(q) { // from class: us.pinguo.repository2020.manager.BackgroundBlurDataManager$fetchBlurShapeFromServer$request$1

            /* compiled from: BackgroundBlurDataManager.kt */
            /* loaded from: classes6.dex */
            public static final class a extends com.google.gson.t.a<HttpBaseResponse<BlurShapeResponse>> {
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
                try {
                    HttpBaseResponse httpBaseResponse = (HttpBaseResponse) GsonUtilKt.getCachedGson().k(str, HttpBaseResponse.class);
                    if (httpBaseResponse.getStatus() == 10220) {
                        RequestIntervalPref.a.d("/api/product/unity-light", -1L, null);
                    } else if (httpBaseResponse.getStatus() != 200) {
                        new Exception(httpBaseResponse.getMessage()).printStackTrace();
                    } else {
                        try {
                            HttpBaseResponse httpBaseResponse2 = (HttpBaseResponse) GsonUtilKt.getCachedGson().k(str, new a().getType());
                            if (httpBaseResponse2 == null) {
                                return;
                            }
                            List<BackgroundBlurShape> packages = ((BlurShapeResponse) httpBaseResponse2.getData()).getPackages();
                            if (packages == null || packages.isEmpty()) {
                                return;
                            }
                            kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new BackgroundBlurDataManager$fetchBlurShapeFromServer$request$1$onResponse$1(httpBaseResponse2, str, null), 3, null);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }.execute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(us.pinguo.repository2020.entity.BackgroundBlurMaterial r9, kotlin.coroutines.Continuation<? super java.lang.Boolean> r10) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.BackgroundBlurDataManager.n(us.pinguo.repository2020.entity.BackgroundBlurMaterial, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0042 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(java.lang.String r5, kotlin.coroutines.Continuation<? super us.pinguo.repository2020.entity.Config> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof us.pinguo.repository2020.manager.BackgroundBlurDataManager$parseConfigJson$1
            if (r0 == 0) goto L13
            r0 = r6
            us.pinguo.repository2020.manager.BackgroundBlurDataManager$parseConfigJson$1 r0 = (us.pinguo.repository2020.manager.BackgroundBlurDataManager$parseConfigJson$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.repository2020.manager.BackgroundBlurDataManager$parseConfigJson$1 r0 = new us.pinguo.repository2020.manager.BackgroundBlurDataManager$parseConfigJson$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.j.b(r6)
            goto L3d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.j.b(r6)
            r0.label = r3
            java.lang.Object r6 = us.pinguo.util.FileIOUtils.g(r5, r0)
            if (r6 != r1) goto L3d
            return r1
        L3d:
            java.lang.String r6 = (java.lang.String) r6
            r5 = 0
            if (r6 != 0) goto L43
            return r5
        L43:
            us.pinguo.repository2020.manager.BackgroundBlurDataManager$d r0 = new us.pinguo.repository2020.manager.BackgroundBlurDataManager$d
            r0.<init>()
            java.lang.reflect.Type r0 = r0.getType()
            com.google.gson.e r1 = com.pinguo.lib.GsonUtilKt.getCachedGson()     // Catch: java.lang.Exception -> L57
            java.lang.Object r6 = r1.k(r6, r0)     // Catch: java.lang.Exception -> L57
            us.pinguo.repository2020.entity.Config r6 = (us.pinguo.repository2020.entity.Config) r6     // Catch: java.lang.Exception -> L57
            r5 = r6
        L57:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.BackgroundBlurDataManager.q(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void h(BackgroundBlurMaterial blurMaterial, p<? super Boolean, ? super BackgroundBlurMaterial, u> completeAction) {
        s.h(blurMaterial, "blurMaterial");
        s.h(completeAction, "completeAction");
        String down_url = blurMaterial.getDown_url();
        String pid = blurMaterial.getPid();
        boolean z = false;
        if (!(down_url == null || down_url.length() == 0)) {
            if (!((pid == null || pid.length() == 0) ? true : true)) {
                kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new BackgroundBlurDataManager$downloadBlurMaterial$1(blurMaterial, down_url, completeAction, pid, null), 3, null);
                return;
            }
        }
        completeAction.invoke(Boolean.FALSE, blurMaterial);
    }

    public final HashMap<String, BackgroundBlurMaterial> k() {
        return f11889g;
    }

    public final BlurResponse l() {
        return b;
    }

    public final BlurShapeResponse m() {
        return c;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(us.pinguo.repository2020.entity.BackgroundBlurMaterial r12, kotlin.jvm.b.p<? super java.lang.Boolean, ? super us.pinguo.repository2020.entity.BackgroundBlurMaterial, kotlin.u> r13, kotlin.coroutines.Continuation<? super kotlin.u> r14) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.BackgroundBlurDataManager.o(us.pinguo.repository2020.entity.BackgroundBlurMaterial, kotlin.jvm.b.p, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void p(boolean z) {
        g();
        i(z);
        j(z);
    }

    public final void r(BlurResponse blurResponse) {
        b = blurResponse;
    }

    public final void s() {
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new BackgroundBlurDataManager$writeBackgroundBlurCustomizeDataToFile$1(null), 3, null);
    }
}
