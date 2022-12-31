package com.tencent.matrix.trace.tracer;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.trace.TracePlugin;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.tencent.matrix.trace.config.TraceConfig;
import com.tencent.matrix.trace.core.UIThreadMonitor;
import com.tencent.matrix.trace.listeners.IDoFrameListener;
import com.tencent.matrix.trace.util.Utils;
import com.tencent.matrix.util.DeviceUtil;
import com.tencent.matrix.util.MatrixHandlerThread;
import com.tencent.matrix.util.MatrixLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* loaded from: classes3.dex */
public class FrameTracer extends Tracer implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "Matrix.FrameTracer";
    private final TraceConfig config;
    private DropFrameListener dropFrameListener;
    private final long frameIntervalNs;
    private long frozenThreshold;
    private long highThreshold;
    private boolean isFPSEnable;
    private long middleThreshold;
    private long normalThreshold;
    private long timeSliceMs;
    private final HashSet<IDoFrameListener> listeners = new HashSet<>();
    private int dropFrameListenerThreshold = 0;
    private int droppedSum = 0;
    private long durationSum = 0;
    private Map<String, Long> lastResumeTimeMap = new HashMap();

    /* loaded from: classes3.dex */
    public interface DropFrameListener {
        void dropFrame(int i2, String str, long j2);
    }

    /* loaded from: classes3.dex */
    public enum DropStatus {
        DROPPED_FROZEN(4),
        DROPPED_HIGH(3),
        DROPPED_MIDDLE(2),
        DROPPED_NORMAL(1),
        DROPPED_BEST(0);
        
        public int index;

        DropStatus(int i2) {
            this.index = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        final /* synthetic */ IDoFrameListener a;
        final /* synthetic */ String b;
        final /* synthetic */ long c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f8096d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f8097e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f8098f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ long f8099g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ long f8100h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ long f8101i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ long f8102j;

        a(FrameTracer frameTracer, IDoFrameListener iDoFrameListener, String str, long j2, long j3, int i2, boolean z, long j4, long j5, long j6, long j7) {
            this.a = iDoFrameListener;
            this.b = str;
            this.c = j2;
            this.f8096d = j3;
            this.f8097e = i2;
            this.f8098f = z;
            this.f8099g = j4;
            this.f8100h = j5;
            this.f8101i = j6;
            this.f8102j = j7;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.doFrameAsync(this.b, this.c, this.f8096d, this.f8097e, this.f8098f, this.f8099g, this.f8100h, this.f8101i, this.f8102j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        String a;
        long b;

        /* renamed from: d  reason: collision with root package name */
        int f8104d;
        int c = 0;

        /* renamed from: e  reason: collision with root package name */
        int[] f8105e = new int[DropStatus.values().length];

        /* renamed from: f  reason: collision with root package name */
        int[] f8106f = new int[DropStatus.values().length];

        c(String str) {
            this.a = str;
        }

        void a(int i2) {
            this.b = ((float) this.b) + ((i2 + 1) * ((((float) UIThreadMonitor.getMonitor().getFrameIntervalNanos()) * 1.0f) / 1000000.0f));
            this.f8104d += i2;
            this.c++;
            long j2 = i2;
            if (j2 < FrameTracer.this.frozenThreshold) {
                if (j2 < FrameTracer.this.highThreshold) {
                    if (j2 < FrameTracer.this.middleThreshold) {
                        if (j2 >= FrameTracer.this.normalThreshold) {
                            int[] iArr = this.f8105e;
                            int i3 = DropStatus.DROPPED_NORMAL.index;
                            iArr[i3] = iArr[i3] + 1;
                            int[] iArr2 = this.f8106f;
                            iArr2[i3] = iArr2[i3] + i2;
                            return;
                        }
                        int[] iArr3 = this.f8105e;
                        int i4 = DropStatus.DROPPED_BEST.index;
                        iArr3[i4] = iArr3[i4] + 1;
                        int[] iArr4 = this.f8106f;
                        iArr4[i4] = iArr4[i4] + Math.max(i2, 0);
                        return;
                    }
                    int[] iArr5 = this.f8105e;
                    int i5 = DropStatus.DROPPED_MIDDLE.index;
                    iArr5[i5] = iArr5[i5] + 1;
                    int[] iArr6 = this.f8106f;
                    iArr6[i5] = iArr6[i5] + i2;
                    return;
                }
                int[] iArr7 = this.f8105e;
                int i6 = DropStatus.DROPPED_HIGH.index;
                iArr7[i6] = iArr7[i6] + 1;
                int[] iArr8 = this.f8106f;
                iArr8[i6] = iArr8[i6] + i2;
                return;
            }
            int[] iArr9 = this.f8105e;
            int i7 = DropStatus.DROPPED_FROZEN.index;
            iArr9[i7] = iArr9[i7] + 1;
            int[] iArr10 = this.f8106f;
            iArr10[i7] = iArr10[i7] + i2;
        }

        void b() {
            TracePlugin tracePlugin;
            float min = Math.min(60.0f, (this.c * 1000.0f) / ((float) this.b));
            MatrixLog.i(FrameTracer.TAG, "[report] FPS:%s %s", Float.valueOf(min), toString());
            try {
                try {
                    tracePlugin = (TracePlugin) Matrix.with().getPluginByClass(TracePlugin.class);
                } catch (JSONException e2) {
                    MatrixLog.e(FrameTracer.TAG, "json error", e2);
                }
                if (tracePlugin == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                DropStatus dropStatus = DropStatus.DROPPED_FROZEN;
                jSONObject.put(dropStatus.name(), this.f8105e[dropStatus.index]);
                DropStatus dropStatus2 = DropStatus.DROPPED_HIGH;
                jSONObject.put(dropStatus2.name(), this.f8105e[dropStatus2.index]);
                DropStatus dropStatus3 = DropStatus.DROPPED_MIDDLE;
                jSONObject.put(dropStatus3.name(), this.f8105e[dropStatus3.index]);
                DropStatus dropStatus4 = DropStatus.DROPPED_NORMAL;
                jSONObject.put(dropStatus4.name(), this.f8105e[dropStatus4.index]);
                DropStatus dropStatus5 = DropStatus.DROPPED_BEST;
                jSONObject.put(dropStatus5.name(), this.f8105e[dropStatus5.index]);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(dropStatus.name(), this.f8106f[dropStatus.index]);
                jSONObject2.put(dropStatus2.name(), this.f8106f[dropStatus2.index]);
                jSONObject2.put(dropStatus3.name(), this.f8106f[dropStatus3.index]);
                jSONObject2.put(dropStatus4.name(), this.f8106f[dropStatus4.index]);
                jSONObject2.put(dropStatus5.name(), this.f8106f[dropStatus5.index]);
                JSONObject deviceInfo = DeviceUtil.getDeviceInfo(new JSONObject(), tracePlugin.getApplication());
                deviceInfo.put(SharePluginInfo.ISSUE_SCENE, this.a);
                deviceInfo.put(SharePluginInfo.ISSUE_DROP_LEVEL, jSONObject);
                deviceInfo.put(SharePluginInfo.ISSUE_DROP_SUM, jSONObject2);
                deviceInfo.put(SharePluginInfo.ISSUE_FPS, min);
                Issue issue = new Issue();
                issue.setTag(SharePluginInfo.TAG_PLUGIN_FPS);
                issue.setContent(deviceInfo);
                tracePlugin.onDetectIssue(issue);
            } finally {
                this.c = 0;
                this.f8104d = 0;
                this.b = 0L;
            }
        }

        public String toString() {
            return "visibleScene=" + this.a + ", sumFrame=" + this.c + ", sumDroppedFrames=" + this.f8104d + ", sumFrameCost=" + this.b + ", dropLevel=" + Arrays.toString(this.f8105e);
        }
    }

    public FrameTracer(TraceConfig traceConfig) {
        this.config = traceConfig;
        long frameIntervalNanos = UIThreadMonitor.getMonitor().getFrameIntervalNanos();
        this.frameIntervalNs = frameIntervalNanos;
        this.timeSliceMs = traceConfig.getTimeSliceMs();
        this.isFPSEnable = traceConfig.isFPSEnable();
        this.frozenThreshold = traceConfig.getFrozenThreshold();
        this.highThreshold = traceConfig.getHighThreshold();
        this.normalThreshold = traceConfig.getNormalThreshold();
        this.middleThreshold = traceConfig.getMiddleThreshold();
        MatrixLog.i(TAG, "[init] frameIntervalMs:%s isFPSEnable:%s", Long.valueOf(frameIntervalNanos), Boolean.valueOf(this.isFPSEnable));
        if (this.isFPSEnable) {
            addListener(new b(this, null));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011d A[Catch: all -> 0x0147, TRY_LEAVE, TryCatch #3 {all -> 0x0147, blocks: (B:35:0x0115, B:37:0x011d), top: B:75:0x0115 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x013b  */
    /* JADX WARN: Type inference failed for: r1v0, types: [long] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v16, types: [com.tencent.matrix.trace.tracer.FrameTracer] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void notifyListener(java.lang.String r39, long r40, long r42, boolean r44, long r45, long r47, long r49, long r51) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.trace.tracer.FrameTracer.notifyListener(java.lang.String, long, long, boolean, long, long, long, long):void");
    }

    public void addDropFrameListener(int i2, DropFrameListener dropFrameListener) {
        this.dropFrameListener = dropFrameListener;
        this.dropFrameListenerThreshold = i2;
    }

    public void addListener(IDoFrameListener iDoFrameListener) {
        synchronized (this.listeners) {
            this.listeners.add(iDoFrameListener);
        }
    }

    @Override // com.tencent.matrix.trace.listeners.LooperObserver
    public void doFrame(String str, long j2, long j3, boolean z, long j4, long j5, long j6, long j7) {
        if (isForeground()) {
            notifyListener(str, j2, j3, z, j4, j5, j6, j7);
        }
    }

    public int getDroppedSum() {
        return this.droppedSum;
    }

    public long getDurationSum() {
        return this.durationSum;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.lastResumeTimeMap.put(activity.getClass().getName(), Long.valueOf(System.currentTimeMillis()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onAlive() {
        super.onAlive();
        if (this.isFPSEnable) {
            UIThreadMonitor.getMonitor().addObserver(this);
            Matrix.with().getApplication().registerActivityLifecycleCallbacks(this);
        }
    }

    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onDead() {
        super.onDead();
        removeDropFrameListener();
        if (this.isFPSEnable) {
            UIThreadMonitor.getMonitor().removeObserver(this);
            Matrix.with().getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    public void removeDropFrameListener() {
        this.dropFrameListener = null;
    }

    public void removeListener(IDoFrameListener iDoFrameListener) {
        synchronized (this.listeners) {
            this.listeners.remove(iDoFrameListener);
        }
    }

    /* loaded from: classes3.dex */
    private class b extends IDoFrameListener {
        private Handler a;
        Executor b;
        private HashMap<String, c> c;

        /* loaded from: classes3.dex */
        class a implements Executor {
            a() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                b.this.a.post(runnable);
            }
        }

        private b() {
            this.a = new Handler(MatrixHandlerThread.getDefaultHandlerThread().getLooper());
            this.b = new a();
            this.c = new HashMap<>();
        }

        public void b(String str, long j2, long j3, int i2, boolean z, long j4, long j5, long j6, long j7) {
            if (!Utils.isEmpty(str) && z) {
                c cVar = this.c.get(str);
                if (cVar == null) {
                    cVar = new c(str);
                    this.c.put(str, cVar);
                }
                cVar.a(i2);
                if (cVar.b >= FrameTracer.this.timeSliceMs) {
                    this.c.remove(str);
                    cVar.b();
                }
            }
        }

        @Override // com.tencent.matrix.trace.listeners.IDoFrameListener
        public void doReplay(List<IDoFrameListener.FrameReplay> list) {
            super.doReplay(list);
            for (IDoFrameListener.FrameReplay frameReplay : list) {
                b(frameReplay.focusedActivity, frameReplay.startNs, frameReplay.endNs, frameReplay.dropFrame, frameReplay.isVsyncFrame, frameReplay.intendedFrameTimeNs, frameReplay.inputCostNs, frameReplay.animationCostNs, frameReplay.traversalCostNs);
            }
        }

        @Override // com.tencent.matrix.trace.listeners.IDoFrameListener
        public Executor getExecutor() {
            return this.b;
        }

        @Override // com.tencent.matrix.trace.listeners.IDoFrameListener
        public int getIntervalFrameReplay() {
            return IjkMediaCodecInfo.RANK_SECURE;
        }

        /* synthetic */ b(FrameTracer frameTracer, a aVar) {
            this();
        }
    }
}
