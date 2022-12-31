package us.pinguo.repository2020.database.background;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pinguo.lib.GsonUtilKt;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.open.SocialConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.common.log.a;
import us.pinguo.common.network.HttpStringRequest;
import us.pinguo.common.network.common.PGNetworkConfig;
import us.pinguo.common.pgdownloader.download.DownloadListener;
import us.pinguo.common.pgdownloader.download.IDownloadTask;
import us.pinguo.common.pgdownloader.download.PGDownloadManger;
import us.pinguo.foundation.e;
import us.pinguo.foundation.m.d;
import us.pinguo.foundation.statistics.i;
import us.pinguo.foundation.utils.v;
import us.pinguo.repository2020.utils.RequestIntervalPref;
import us.pinguo.repository2020.utils.h;
import us.pinguo.user.u0;
/* compiled from: BackgroundMaterialManager.kt */
/* loaded from: classes6.dex */
public final class BackgroundMaterialManager {
    private static final boolean b;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f11835g;
    public static final BackgroundMaterialManager a = new BackgroundMaterialManager();
    private static final String c = s.q(h.a(), "display.json");

    /* renamed from: d  reason: collision with root package name */
    private static ArrayList<BackgroundCategory> f11832d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap<String, Background> f11833e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private static final ConcurrentHashMap<String, BackgroundDetail> f11834f = new ConcurrentHashMap<>();

    static {
        Object m41constructorimpl;
        Locale locale = Locale.getDefault();
        b = s.c("zh", locale.getLanguage()) && s.c("CN", locale.getCountry());
        Context b2 = e.b();
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService = b2.getSystemService("storage");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.storage.StorageManager");
            StorageManager storageManager = (StorageManager) systemService;
            File file = new File(h.a());
            StorageVolume storageVolume = storageManager.getStorageVolume(file);
            if (storageVolume != null && (storageVolume.isEmulated() || !storageVolume.isRemovable())) {
                UUID uuidForPath = storageManager.getUuidForPath(file);
                s.g(uuidForPath, "storageManager.getUuidForPath(backgroundDir)");
                if (storageManager.getAllocatableBytes(uuidForPath) >= 83886080) {
                    storageManager.allocateBytes(uuidForPath, 83886080L);
                } else {
                    Intent intent = new Intent();
                    intent.setAction("android.os.storage.action.MANAGE_STORAGE");
                    intent.putExtra("android.os.storage.extra.UUID", uuidForPath);
                    intent.putExtra("android.os.storage.extra.REQUESTED_BYTES", 83886080L);
                    intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
                    try {
                        Result.a aVar = Result.Companion;
                        b2.startActivity(intent);
                        m41constructorimpl = Result.m41constructorimpl(u.a);
                    } catch (Throwable th) {
                        Result.a aVar2 = Result.Companion;
                        m41constructorimpl = Result.m41constructorimpl(j.a(th));
                    }
                    Throwable m44exceptionOrNullimpl = Result.m44exceptionOrNullimpl(m41constructorimpl);
                    if (m44exceptionOrNullimpl != null) {
                        a.f(m44exceptionOrNullimpl);
                    }
                }
            }
        }
        f11835g = true;
    }

    private BackgroundMaterialManager() {
    }

    private final String k() {
        return b ? "builtin_data/background/defaultMagicBgData.json" : "builtin_data/background/defaultMagicBgData_en.json";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0135 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x026b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x028c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02bd A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0217 -> B:52:0x01df). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0269 -> B:14:0x0060). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(java.lang.String r20, kotlin.coroutines.Continuation<? super us.pinguo.repository2020.database.background.BackgroundDetail> r21) {
        /*
            Method dump skipped, instructions count: 724
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.background.BackgroundMaterialManager.n(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void d(final String id, final p<? super String, ? super Integer, u> pVar, final q<? super Boolean, ? super String, ? super String, u> qVar) {
        s.h(id, "id");
        final Background g2 = g(id);
        if (g2 == null) {
            return;
        }
        g2.setState(MaterialState.DOWNLOADING);
        if (pVar != null) {
            pVar.invoke(id, 1);
        }
        String down_url = g2.getDown_url();
        PGDownloadManger companion = PGDownloadManger.Companion.getInstance();
        IDownloadTask create = companion.create(down_url, h.a() + id + "_zip", false, 0);
        create.setForceReDownload(true);
        create.setListener(new DownloadListener() { // from class: us.pinguo.repository2020.database.background.BackgroundMaterialManager$downloadMaterial$1
            @Override // us.pinguo.common.pgdownloader.download.DownloadListener
            public void onComplete(IDownloadTask task) {
                s.h(task, "task");
                p<String, Integer, u> pVar2 = pVar;
                if (pVar2 != null) {
                    pVar2.invoke(g2.getPid(), 100);
                }
                l.d(n0.a(z0.b()), null, null, new BackgroundMaterialManager$downloadMaterial$1$onComplete$1(task.getPath(), g2, id, qVar, null), 3, null);
            }

            @Override // us.pinguo.common.pgdownloader.download.DownloadListener
            public void onError(IDownloadTask task, int i2) {
                s.h(task, "task");
                p<String, Integer, u> pVar2 = pVar;
                if (pVar2 != null) {
                    pVar2.invoke(g2.getPid(), 100);
                }
                g2.setState(MaterialState.NOT_DOWNLOADED);
                q<Boolean, String, String, u> qVar2 = qVar;
                if (qVar2 == null) {
                    return;
                }
                qVar2.invoke(Boolean.FALSE, g2.getPid(), null);
            }

            @Override // us.pinguo.common.pgdownloader.download.DownloadListener
            public void onPause(IDownloadTask task) {
                s.h(task, "task");
            }

            @Override // us.pinguo.common.pgdownloader.download.DownloadListener
            public void onProgress(IDownloadTask task, int i2, int i3, int i4) {
                s.h(task, "task");
                p<String, Integer, u> pVar2 = pVar;
                if (pVar2 == null) {
                    return;
                }
                pVar2.invoke(g2.getPid(), Integer.valueOf((int) (100 * (i3 / i4))));
            }
        });
        create.start();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [us.pinguo.repository2020.utils.RequestIntervalPref$RefreshType, T] */
    /* JADX WARN: Type inference failed for: r7v4, types: [us.pinguo.repository2020.utils.RequestIntervalPref$RefreshType, T] */
    /* JADX WARN: Type inference failed for: r7v8, types: [us.pinguo.repository2020.utils.RequestIntervalPref$RefreshType, T] */
    public final void e(boolean z) {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        if (z) {
            ref$ObjectRef.element = RequestIntervalPref.RefreshType.RESET_REFRESH;
        } else {
            int i2 = us.pinguo.foundation.j.e().i("key_fource_update_background_version", 0);
            ref$ObjectRef.element = RequestIntervalPref.RefreshType.TIME_REFRESH;
            if (i2 >= 0) {
                ?? c2 = RequestIntervalPref.a.c("/api/product/unity-background", -1L, null);
                ref$ObjectRef.element = c2;
                if (c2 == RequestIntervalPref.RefreshType.NONE_REFRESH) {
                    return;
                }
            }
        }
        us.pinguo.foundation.statistics.h.b.n("", "/api/product/unity-background", SocialConstants.TYPE_REQUEST);
        final long currentTimeMillis = System.currentTimeMillis();
        final String q = s.q(h.c(), "/api/product/unity-background");
        new HttpStringRequest(q) { // from class: us.pinguo.repository2020.database.background.BackgroundMaterialManager$fetchDisplayData$request$1
            @Override // com.android.volley.Request
            protected Map<String, String> getParams() {
                HashMap hashMap = new HashMap();
                u0.e(e.b(), hashMap);
                if (ref$ObjectRef.element == RequestIntervalPref.RefreshType.RESET_REFRESH) {
                    Locale a2 = v.a();
                    String language = a2.getLanguage();
                    String country = a2.getCountry();
                    if (country == null) {
                        country = "";
                    }
                    PGNetworkConfig.getInstance().resetLocale(language, country);
                    hashMap.put("version", "0");
                    hashMap.put("UTCOffset", String.valueOf(TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000));
                }
                d.c(hashMap, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
                return hashMap;
            }

            @Override // us.pinguo.common.network.HttpRequestBase
            protected void onErrorResponse(Exception exc) {
                i iVar = us.pinguo.foundation.statistics.h.b;
                iVar.n((System.currentTimeMillis() - currentTimeMillis) + "", "/api/product/unity-background", "failed");
                CrashReport.postCatchedException(new IllegalStateException("display data fetch failed", exc));
                if (exc == null) {
                    return;
                }
                exc.printStackTrace();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // us.pinguo.common.network.HttpRequestBase
            public void onResponse(String response) {
                s.h(response, "response");
                i iVar = us.pinguo.foundation.statistics.h.b;
                iVar.n((System.currentTimeMillis() - currentTimeMillis) + "", "/api/product/unity-background", FirebaseAnalytics.Param.SUCCESS);
                BackgroundResponseData backgroundResponseData = (BackgroundResponseData) GsonUtilKt.getCachedGson().j(response, BackgroundResponseData.class);
                if (backgroundResponseData == null) {
                    new NullPointerException().printStackTrace();
                } else if (backgroundResponseData.getStatus() == 10220) {
                    us.pinguo.foundation.j.e().q("key_fource_update_background_version", r4);
                    RequestIntervalPref.a.d("/api/product/unity-background", -1L, null);
                } else if (backgroundResponseData.getStatus() == 200) {
                    l.d(n0.a(z0.b()), null, null, new BackgroundMaterialManager$fetchDisplayData$request$1$onResponse$1(r4, backgroundResponseData, response, null), 3, null);
                } else {
                    new Exception(backgroundResponseData.getMessage()).printStackTrace();
                }
            }
        }.execute();
    }

    public final BackgroundDetail f(String id) {
        s.h(id, "id");
        return f11834f.get(id);
    }

    public final Background g(String id) {
        s.h(id, "id");
        return f11833e.get(id);
    }

    public final List<DecorationDetail> h(String id) {
        s.h(id, "id");
        BackgroundDetail f2 = f(id);
        if (f2 == null) {
            return null;
        }
        String[] layerZipPath = f2.getLayerZipPath();
        int i2 = 0;
        if (layerZipPath.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(layerZipPath.length);
        int length = layerZipPath.length;
        while (i2 < length) {
            String str = layerZipPath[i2];
            i2++;
            InputStreamReader inputStreamReader = new InputStreamReader(new BufferedInputStream(new FileInputStream(h.a() + id + '/' + str + "/config.json")));
            DecorationDetail ret = (DecorationDetail) GsonUtilKt.getCachedGson().h(inputStreamReader, DecorationDetail.class);
            inputStreamReader.close();
            s.g(ret, "ret");
            arrayList.add(ret);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0096 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.lang.String r7, kotlin.coroutines.Continuation<? super us.pinguo.repository2020.database.background.StrokeDetail> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof us.pinguo.repository2020.database.background.BackgroundMaterialManager$findStrokeDetail$1
            if (r0 == 0) goto L13
            r0 = r8
            us.pinguo.repository2020.database.background.BackgroundMaterialManager$findStrokeDetail$1 r0 = (us.pinguo.repository2020.database.background.BackgroundMaterialManager$findStrokeDetail$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.repository2020.database.background.BackgroundMaterialManager$findStrokeDetail$1 r0 = new us.pinguo.repository2020.database.background.BackgroundMaterialManager$findStrokeDetail$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.j.b(r8)
            goto L8e
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            kotlin.j.b(r8)
            us.pinguo.repository2020.database.background.BackgroundDetail r8 = r6.f(r7)
            if (r8 != 0) goto L40
            return r3
        L40:
            us.pinguo.repository2020.database.background.Cutout r8 = r8.getCutout()
            us.pinguo.repository2020.database.background.CutoutSketch r8 = r8.getSketch()
            java.lang.String r8 = r8.getSketchstyle()
            if (r8 == 0) goto L57
            int r2 = r8.length()
            if (r2 != 0) goto L55
            goto L57
        L55:
            r2 = 0
            goto L58
        L57:
            r2 = 1
        L58:
            if (r2 != 0) goto Lb6
            java.lang.String r2 = "none"
            boolean r2 = kotlin.jvm.internal.s.c(r8, r2)
            if (r2 == 0) goto L63
            goto Lb6
        L63:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = us.pinguo.repository2020.utils.h.a()
            r2.append(r5)
            r2.append(r7)
            r7 = 47
            r2.append(r7)
            r2.append(r8)
            java.lang.String r7 = "/config.json"
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = us.pinguo.util.FileUtils.q(r7, r0)
            if (r8 != r1) goto L8e
            return r1
        L8e:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L97
            return r3
        L97:
            java.io.InputStreamReader r8 = new java.io.InputStreamReader
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r7)
            r0.<init>(r1)
            r8.<init>(r0)
            com.google.gson.e r7 = com.pinguo.lib.GsonUtilKt.getCachedGson()
            java.lang.Class<us.pinguo.repository2020.database.background.StrokeDetail> r0 = us.pinguo.repository2020.database.background.StrokeDetail.class
            java.lang.Object r7 = r7.h(r8, r0)
            us.pinguo.repository2020.database.background.StrokeDetail r7 = (us.pinguo.repository2020.database.background.StrokeDetail) r7
            r8.close()
            return r7
        Lb6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.background.BackgroundMaterialManager.i(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final List<BackgroundCategory> j() {
        return f11832d;
    }

    public final boolean l() {
        return f11835g;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fa  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00e7 -> B:33:0x00ea). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(kotlin.coroutines.Continuation<? super kotlin.u> r10) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.background.BackgroundMaterialManager.m(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
