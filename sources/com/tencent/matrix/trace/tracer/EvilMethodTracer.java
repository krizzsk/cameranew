package com.tencent.matrix.trace.tracer;

import android.os.Handler;
import android.os.Process;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.trace.TracePlugin;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.tencent.matrix.trace.config.TraceConfig;
import com.tencent.matrix.trace.constants.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.UIThreadMonitor;
import com.tencent.matrix.trace.items.MethodItem;
import com.tencent.matrix.trace.util.TraceDataUtils;
import com.tencent.matrix.trace.util.Utils;
import com.tencent.matrix.util.DeviceUtil;
import com.tencent.matrix.util.MatrixHandlerThread;
import com.tencent.matrix.util.MatrixLog;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class EvilMethodTracer extends Tracer {
    private static final String TAG = "Matrix.EvilMethodTracer";
    private final TraceConfig config;
    private long evilThresholdMs;
    private AppMethodBeat.IndexRecord indexRecord;
    private boolean isEvilMethodTraceEnable;
    private long[] queueTypeCosts = new long[3];

    /* loaded from: classes3.dex */
    private class a implements Runnable {
        long[] a;
        long[] b;
        long c;

        /* renamed from: d  reason: collision with root package name */
        long f8092d;

        /* renamed from: e  reason: collision with root package name */
        long f8093e;

        /* renamed from: f  reason: collision with root package name */
        String f8094f;

        /* renamed from: g  reason: collision with root package name */
        boolean f8095g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.tencent.matrix.trace.tracer.EvilMethodTracer$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0272a implements TraceDataUtils.IStructuredDataFilter {
            C0272a(a aVar) {
            }

            @Override // com.tencent.matrix.trace.util.TraceDataUtils.IStructuredDataFilter
            public void fallback(List<MethodItem> list, int i2) {
                MatrixLog.w(EvilMethodTracer.TAG, "[fallback] size:%s targetSize:%s stack:%s", Integer.valueOf(i2), 30, list);
                ListIterator<MethodItem> listIterator = list.listIterator(Math.min(i2, 30));
                while (listIterator.hasNext()) {
                    listIterator.next();
                    listIterator.remove();
                }
            }

            @Override // com.tencent.matrix.trace.util.TraceDataUtils.IStructuredDataFilter
            public int getFilterMaxCount() {
                return 60;
            }

            @Override // com.tencent.matrix.trace.util.TraceDataUtils.IStructuredDataFilter
            public boolean isFilter(long j2, int i2) {
                return j2 < ((long) (i2 * 5));
            }
        }

        a(EvilMethodTracer evilMethodTracer, boolean z, String str, long[] jArr, long[] jArr2, long j2, long j3, long j4) {
            this.f8095g = z;
            this.f8094f = str;
            this.f8092d = j3;
            this.c = j2;
            this.b = jArr;
            this.a = jArr2;
            this.f8093e = j4;
        }

        private String b(String str, int[] iArr, boolean z, StringBuilder sb, long j2, String str2, String str3, long j3, long j4, long j5, long j6) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(String.format("-\n>>>>>>>>>>>>>>>>>>>>> maybe happens Jankiness!(%sms) <<<<<<<<<<<<<<<<<<<<<\n", Long.valueOf(j6)));
            sb2.append("|* [Status]");
            sb2.append("\n");
            sb2.append("|*\t\tScene: ");
            sb2.append(str);
            sb2.append("\n");
            sb2.append("|*\t\tForeground: ");
            sb2.append(z);
            sb2.append("\n");
            sb2.append("|*\t\tPriority: ");
            sb2.append(iArr[0]);
            sb2.append("\tNice: ");
            sb2.append(iArr[1]);
            sb2.append("\n");
            sb2.append("|*\t\tis64BitRuntime: ");
            sb2.append(DeviceUtil.is64BitRuntime());
            sb2.append("\n");
            sb2.append("|*\t\tCPU: ");
            sb2.append(str3);
            sb2.append("\n");
            sb2.append("|* [doFrame]");
            sb2.append("\n");
            sb2.append("|*\t\tinputCost:animationCost:traversalCost");
            sb2.append("\n");
            sb2.append("|*\t\t");
            sb2.append(j3);
            sb2.append(":");
            sb2.append(j4);
            sb2.append(":");
            sb2.append(j5);
            sb2.append("\n");
            if (j2 > 0) {
                sb2.append("|*\t\tStackKey: ");
                sb2.append(str2);
                sb2.append("\n");
                sb2.append(sb.toString());
            } else {
                sb2.append(String.format("AppMethodBeat is close[%s].", Boolean.valueOf(AppMethodBeat.getInstance().isAlive())));
                sb2.append("\n");
            }
            sb2.append("=========================================================================");
            return sb2.toString();
        }

        void a() {
            int[] processPriority = Utils.getProcessPriority(Process.myPid());
            String calculateCpuUsage = Utils.calculateCpuUsage(this.c, this.f8092d);
            LinkedList linkedList = new LinkedList();
            long[] jArr = this.b;
            if (jArr.length > 0) {
                TraceDataUtils.structuredDataToStack(jArr, linkedList, true, this.f8093e);
                TraceDataUtils.trimStack(linkedList, 30, new C0272a(this));
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            long max = Math.max(this.f8092d, TraceDataUtils.stackToString(linkedList, sb, sb2));
            String treeKey = TraceDataUtils.getTreeKey(linkedList, max);
            String str = this.f8094f;
            boolean z = this.f8095g;
            long size = linkedList.size();
            long[] jArr2 = this.a;
            MatrixLog.w(EvilMethodTracer.TAG, "%s", b(str, processPriority, z, sb2, size, treeKey, calculateCpuUsage, jArr2[0], jArr2[1], jArr2[2], this.f8092d));
            try {
                TracePlugin tracePlugin = (TracePlugin) Matrix.with().getPluginByClass(TracePlugin.class);
                if (tracePlugin == null) {
                    return;
                }
                JSONObject deviceInfo = DeviceUtil.getDeviceInfo(new JSONObject(), Matrix.with().getApplication());
                deviceInfo.put(SharePluginInfo.ISSUE_STACK_TYPE, Constants.Type.NORMAL);
                deviceInfo.put(SharePluginInfo.ISSUE_COST, max);
                deviceInfo.put(SharePluginInfo.ISSUE_CPU_USAGE, calculateCpuUsage);
                try {
                    deviceInfo.put(SharePluginInfo.ISSUE_SCENE, this.f8094f);
                    deviceInfo.put(SharePluginInfo.ISSUE_TRACE_STACK, sb.toString());
                    deviceInfo.put(SharePluginInfo.ISSUE_STACK_KEY, treeKey);
                    Issue issue = new Issue();
                    issue.setTag(SharePluginInfo.TAG_PLUGIN_EVIL_METHOD);
                    issue.setContent(deviceInfo);
                    tracePlugin.onDetectIssue(issue);
                } catch (JSONException e2) {
                    e = e2;
                    MatrixLog.e(EvilMethodTracer.TAG, "[JSONException error: %s", e);
                }
            } catch (JSONException e3) {
                e = e3;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    public EvilMethodTracer(TraceConfig traceConfig) {
        this.config = traceConfig;
        this.evilThresholdMs = traceConfig.getEvilThresholdMs();
        this.isEvilMethodTraceEnable = traceConfig.isEvilMethodTraceEnable();
    }

    @Override // com.tencent.matrix.trace.listeners.LooperObserver
    public void dispatchBegin(long j2, long j3, long j4) {
        super.dispatchBegin(j2, j3, j4);
        this.indexRecord = AppMethodBeat.getInstance().maskIndex("EvilMethodTracer#dispatchBegin");
    }

    @Override // com.tencent.matrix.trace.listeners.LooperObserver
    public void dispatchEnd(long j2, long j3, long j4, long j5, long j6, boolean z) {
        long j7;
        String str;
        String str2;
        int i2;
        char c;
        char c2;
        String str3;
        String str4;
        long j8;
        super.dispatchEnd(j2, j3, j4, j5, j6, z);
        long currentTimeMillis = this.config.isDevEnv() ? System.currentTimeMillis() : 0L;
        long j9 = (j4 - j2) / 1000000;
        try {
            if (j9 >= this.evilThresholdMs) {
                try {
                    long[] copyData = AppMethodBeat.getInstance().copyData(this.indexRecord);
                    long[] jArr = new long[3];
                    System.arraycopy(this.queueTypeCosts, 0, jArr, 0, 3);
                    String visibleScene = AppMethodBeat.getVisibleScene();
                    Handler defaultHandler = MatrixHandlerThread.getDefaultHandler();
                    boolean isForeground = isForeground();
                    long j10 = j5 - j3;
                    long j11 = j4 / 1000000;
                    str3 = "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s innerCost:%s";
                    c2 = 0;
                    str4 = TAG;
                    i2 = 5;
                    c = 3;
                    j8 = j9;
                    try {
                        defaultHandler.post(new a(this, isForeground, visibleScene, copyData, jArr, j10, j9, j11));
                    } catch (Throwable th) {
                        th = th;
                        str = str3;
                        str2 = str4;
                        j7 = j8;
                        this.indexRecord.release();
                        if (this.config.isDevEnv()) {
                            long j12 = j5 - j3;
                            String calculateCpuUsage = Utils.calculateCpuUsage(j12, j7);
                            Object[] objArr = new Object[i2];
                            objArr[c2] = Long.valueOf(j6);
                            objArr[1] = Long.valueOf(j7);
                            objArr[2] = Long.valueOf(j12);
                            objArr[c] = calculateCpuUsage;
                            objArr[4] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                            MatrixLog.v(str2, str, objArr);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i2 = 5;
                    c = 3;
                    c2 = 0;
                    j7 = j9;
                    str = "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s innerCost:%s";
                    str2 = TAG;
                }
            } else {
                j8 = j9;
                str3 = "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s innerCost:%s";
                str4 = TAG;
                i2 = 5;
                c = 3;
                c2 = 0;
            }
            this.indexRecord.release();
            if (this.config.isDevEnv()) {
                long j13 = j5 - j3;
                long j14 = j8;
                String calculateCpuUsage2 = Utils.calculateCpuUsage(j13, j14);
                Object[] objArr2 = new Object[i2];
                objArr2[c2] = Long.valueOf(j6);
                objArr2[1] = Long.valueOf(j14);
                objArr2[2] = Long.valueOf(j13);
                objArr2[c] = calculateCpuUsage2;
                objArr2[4] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                MatrixLog.v(str4, str3, objArr2);
            }
        } catch (Throwable th3) {
            th = th3;
            j7 = j9;
            str = "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s innerCost:%s";
            str2 = TAG;
            i2 = 5;
            c = 3;
            c2 = 0;
        }
    }

    @Override // com.tencent.matrix.trace.listeners.LooperObserver
    public void doFrame(String str, long j2, long j3, boolean z, long j4, long j5, long j6, long j7) {
        long[] jArr = this.queueTypeCosts;
        jArr[0] = j5;
        jArr[1] = j6;
        jArr[2] = j7;
    }

    public void modifyEvilThresholdMs(long j2) {
        this.evilThresholdMs = j2;
    }

    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onAlive() {
        super.onAlive();
        if (this.isEvilMethodTraceEnable) {
            UIThreadMonitor.getMonitor().addObserver(this);
        }
    }

    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onDead() {
        super.onDead();
        if (this.isEvilMethodTraceEnable) {
            UIThreadMonitor.getMonitor().removeObserver(this);
        }
    }
}
