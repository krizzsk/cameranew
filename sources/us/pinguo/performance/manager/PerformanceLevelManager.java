package us.pinguo.performance.manager;

import com.pinguo.lib.GsonUtilKt;
import com.pinguo.lib.HardwareInfo;
import com.tencent.matrix.trace.constants.Constants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import kotlin.io.b;
import kotlin.jvm.internal.s;
import kotlin.y.c;
import us.pinguo.paylibcenter.bean.PayResult;
import us.pinguo.performance.entity.GpuLadderInfo;
import us.pinguo.performance.entity.GpuLadderItem;
import us.pinguo.util.v;
/* compiled from: PerformanceLevelManager.kt */
/* loaded from: classes5.dex */
public final class PerformanceLevelManager {
    private static GpuLadderInfo b;

    /* renamed from: f  reason: collision with root package name */
    private static final Integer f11617f = null;
    public static final PerformanceLevelManager a = new PerformanceLevelManager();
    private static final String c = v.a().getFilesDir() + "/performance/performance-level.json";

    /* renamed from: d  reason: collision with root package name */
    private static String f11615d = "";

    /* renamed from: e  reason: collision with root package name */
    private static String f11616e = "";

    /* compiled from: PerformanceLevelManager.kt */
    /* loaded from: classes5.dex */
    public static final class a extends com.google.gson.t.a<GpuLadderInfo> {
        a() {
        }
    }

    private PerformanceLevelManager() {
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cf A[Catch: Exception -> 0x0135, TryCatch #0 {Exception -> 0x0135, blocks: (B:30:0x0076, B:52:0x00d8, B:48:0x00cf, B:33:0x007c, B:36:0x0083, B:37:0x008c, B:39:0x0092, B:43:0x00ad, B:45:0x00c7, B:42:0x00a1, B:56:0x00e4, B:57:0x00e8, B:59:0x00ee, B:63:0x0109, B:67:0x0125, B:62:0x00fd, B:71:0x012e, B:27:0x006f), top: B:86:0x006f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final us.pinguo.performance.entity.GpuLadderItem a() {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.performance.manager.PerformanceLevelManager.a():us.pinguo.performance.entity.GpuLadderItem");
    }

    private final String c() {
        return RenderManager.b();
    }

    private final String e() {
        return RenderManager.c();
    }

    private final void k() {
        InputStreamReader inputStreamReader;
        Type type = new a().getType();
        String str = c;
        if (new File(str).exists()) {
            inputStreamReader = new InputStreamReader(new BufferedInputStream(new FileInputStream(str)));
        } else {
            inputStreamReader = new InputStreamReader(new BufferedInputStream(v.a().getAssets().open("builtin_data/gpu/gpu.json", 3)));
        }
        try {
            GpuLadderInfo gpuLadderInfo = (GpuLadderInfo) GsonUtilKt.getCachedGson().i(inputStreamReader, type);
            b.a(inputStreamReader, null);
            b = gpuLadderInfo;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final Integer b() {
        return f11617f;
    }

    public final String d() {
        String str = f11615d;
        if (str == null || str.length() == 0) {
            f11615d = c();
        }
        return f11615d;
    }

    public final String f() {
        String str = f11616e;
        if (str == null || str.length() == 0) {
            f11616e = e();
        }
        return f11616e;
    }

    public final Integer g() {
        GpuLadderItem a2 = a();
        if (a2 == null) {
            return null;
        }
        return a2.getCenturionMark();
    }

    public final Integer h() {
        int b2;
        Long memSize = HardwareInfo.get().getMemSize();
        if (memSize == null) {
            return null;
        }
        b2 = c.b(((float) memSize.longValue()) / 1024.0f);
        us.pinguo.common.log.a.k(s.q("Device mem is==>", Integer.valueOf(b2)), new Object[0]);
        if (b2 >= 8) {
            return Integer.valueOf((int) PayResult.PAY_RESULT_ALIPAY_CHECK_IN);
        }
        if (b2 >= 6) {
            return Integer.valueOf((int) Constants.DEFAULT_ANR_INVALID);
        }
        return Integer.valueOf((int) Constants.DEFAULT_STARTUP_THRESHOLD_MS_WARM);
    }

    public final Integer i() {
        int b2;
        Long memSize = HardwareInfo.get().getMemSize();
        if (memSize == null) {
            return null;
        }
        b2 = c.b(((float) memSize.longValue()) / 1024.0f);
        return Integer.valueOf(b2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
        if (((r0 == null || r0.length() == 0) ? true : true) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(android.view.ViewGroup r4) {
        /*
            r3 = this;
            com.pinguo.lib.HardwareInfo r0 = com.pinguo.lib.HardwareInfo.get()
            java.lang.String r0 = r0.getHardware()
            us.pinguo.performance.manager.PerformanceLevelManager.f11615d = r0
            java.lang.String r0 = us.pinguo.util.n.a()
            us.pinguo.performance.manager.PerformanceLevelManager.f11616e = r0
            java.lang.String r0 = us.pinguo.performance.manager.PerformanceLevelManager.f11615d
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1f
            int r0 = r0.length()
            if (r0 != 0) goto L1d
            goto L1f
        L1d:
            r0 = 0
            goto L20
        L1f:
            r0 = 1
        L20:
            if (r0 != 0) goto L2f
            java.lang.String r0 = us.pinguo.performance.manager.PerformanceLevelManager.f11616e
            if (r0 == 0) goto L2c
            int r0 = r0.length()
            if (r0 != 0) goto L2d
        L2c:
            r1 = 1
        L2d:
            if (r1 == 0) goto L32
        L2f:
            us.pinguo.performance.manager.RenderManager.e(r4)
        L32:
            r3.k()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.performance.manager.PerformanceLevelManager.j(android.view.ViewGroup):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(us.pinguo.performance.entity.GpuLadderInfo r13, kotlin.coroutines.Continuation<? super java.lang.Boolean> r14) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.performance.manager.PerformanceLevelManager.l(us.pinguo.performance.entity.GpuLadderInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
