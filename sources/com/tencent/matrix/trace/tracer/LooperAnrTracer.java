package com.tencent.matrix.trace.tracer;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
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
import java.lang.Thread;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LooperAnrTracer extends Tracer {
    private static final String TAG = "Matrix.AnrTracer";
    private Handler anrHandler;
    private boolean isAnrTraceEnable;
    private Handler lagHandler;
    private final TraceConfig traceConfig;
    private volatile a anrTask = new a();
    private volatile b lagTask = new b();

    /* loaded from: classes3.dex */
    class a implements Runnable {
        AppMethodBeat.IndexRecord a;
        long b;

        /* renamed from: com.tencent.matrix.trace.tracer.LooperAnrTracer$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0273a implements TraceDataUtils.IStructuredDataFilter {
            C0273a(a aVar) {
            }

            @Override // com.tencent.matrix.trace.util.TraceDataUtils.IStructuredDataFilter
            public void fallback(List<MethodItem> list, int i2) {
                MatrixLog.w(LooperAnrTracer.TAG, "[fallback] size:%s targetSize:%s stack:%s", Integer.valueOf(i2), 30, list);
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

        a() {
        }

        private String b(String str, int[] iArr, long[] jArr, Thread.State state, StringBuilder sb, boolean z, long j2, String str2, String str3, long j3, long j4, long j5, long j6) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(String.format("-\n>>>>>>>>>>>>>>>>>>>>>>> maybe happens ANR(%s ms)! <<<<<<<<<<<<<<<<<<<<<<<\n", Long.valueOf(j6)));
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
            sb2.append("|* [Memory]");
            sb2.append("\n");
            sb2.append("|*\t\tDalvikHeap: ");
            sb2.append(jArr[0]);
            sb2.append("kb\n");
            sb2.append("|*\t\tNativeHeap: ");
            sb2.append(jArr[1]);
            sb2.append("kb\n");
            sb2.append("|*\t\tVmSize: ");
            sb2.append(jArr[2]);
            sb2.append("kb\n");
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
            sb2.append("|* [Thread]");
            sb2.append("\n");
            sb2.append(String.format("|*\t\tStack(%s): ", state));
            sb2.append(str3);
            sb2.append("|* [Trace]");
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

        public AppMethodBeat.IndexRecord a() {
            return this.a;
        }

        @Override // java.lang.Runnable
        public void run() {
            String stack;
            long uptimeMillis = SystemClock.uptimeMillis();
            boolean isForeground = LooperAnrTracer.this.isForeground();
            int[] processPriority = Utils.getProcessPriority(Process.myPid());
            long[] copyData = AppMethodBeat.getInstance().copyData(this.a);
            this.a.release();
            String visibleScene = AppMethodBeat.getVisibleScene();
            long[] dumpMemory = LooperAnrTracer.this.dumpMemory();
            Thread.State state = Looper.getMainLooper().getThread().getState();
            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
            if (LooperAnrTracer.this.traceConfig.getLooperPrinterStackStyle() == 1) {
                stack = Utils.getWholeStack(stackTrace, "|*\t\t");
            } else {
                stack = Utils.getStack(stackTrace, "|*\t\t", 12);
            }
            String str = stack;
            UIThreadMonitor monitor = UIThreadMonitor.getMonitor();
            long queueCost = monitor.getQueueCost(0, this.b);
            long queueCost2 = monitor.getQueueCost(1, this.b);
            long queueCost3 = monitor.getQueueCost(2, this.b);
            LinkedList linkedList = new LinkedList();
            if (copyData.length > 0) {
                TraceDataUtils.structuredDataToStack(copyData, linkedList, true, uptimeMillis);
                TraceDataUtils.trimStack(linkedList, 30, new C0273a(this));
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            long max = Math.max(5000L, TraceDataUtils.stackToString(linkedList, sb, sb2));
            String treeKey = TraceDataUtils.getTreeKey(linkedList, max);
            MatrixLog.w(LooperAnrTracer.TAG, "%s \npostTime:%s curTime:%s", b(visibleScene, processPriority, dumpMemory, state, sb2, isForeground, linkedList.size(), treeKey, str, queueCost, queueCost2, queueCost3, max), Long.valueOf(this.b / 1000000), Long.valueOf(uptimeMillis));
            if (max >= 6000) {
                MatrixLog.w(LooperAnrTracer.TAG, "The checked anr task was not executed on time. The possible reason is that the current process has a low priority. just pass this report", new Object[0]);
                return;
            }
            try {
                TracePlugin tracePlugin = (TracePlugin) Matrix.with().getPluginByClass(TracePlugin.class);
                if (tracePlugin == null) {
                    return;
                }
                JSONObject deviceInfo = DeviceUtil.getDeviceInfo(new JSONObject(), Matrix.with().getApplication());
                deviceInfo.put(SharePluginInfo.ISSUE_STACK_TYPE, Constants.Type.ANR);
                deviceInfo.put(SharePluginInfo.ISSUE_COST, max);
                deviceInfo.put(SharePluginInfo.ISSUE_STACK_KEY, treeKey);
                deviceInfo.put(SharePluginInfo.ISSUE_SCENE, visibleScene);
                deviceInfo.put(SharePluginInfo.ISSUE_TRACE_STACK, sb.toString());
                if (LooperAnrTracer.this.traceConfig.getLooperPrinterStackStyle() == 1) {
                    deviceInfo.put(SharePluginInfo.ISSUE_THREAD_STACK, Utils.getWholeStack(stackTrace));
                } else {
                    deviceInfo.put(SharePluginInfo.ISSUE_THREAD_STACK, Utils.getStack(stackTrace));
                }
                deviceInfo.put(SharePluginInfo.ISSUE_PROCESS_PRIORITY, processPriority[0]);
                deviceInfo.put(SharePluginInfo.ISSUE_PROCESS_NICE, processPriority[1]);
                deviceInfo.put(SharePluginInfo.ISSUE_PROCESS_FOREGROUND, isForeground);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(SharePluginInfo.ISSUE_MEMORY_DALVIK, dumpMemory[0]);
                jSONObject.put(SharePluginInfo.ISSUE_MEMORY_NATIVE, dumpMemory[1]);
                jSONObject.put(SharePluginInfo.ISSUE_MEMORY_VM_SIZE, dumpMemory[2]);
                deviceInfo.put("memory", jSONObject);
                Issue issue = new Issue();
                issue.setKey(this.b + "");
                issue.setTag(SharePluginInfo.TAG_PLUGIN_EVIL_METHOD);
                issue.setContent(deviceInfo);
                tracePlugin.onDetectIssue(issue);
            } catch (JSONException e2) {
                MatrixLog.e(LooperAnrTracer.TAG, "[JSONException error: %s", e2);
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String visibleScene = AppMethodBeat.getVisibleScene();
            boolean isForeground = LooperAnrTracer.this.isForeground();
            try {
                TracePlugin tracePlugin = (TracePlugin) Matrix.with().getPluginByClass(TracePlugin.class);
                if (tracePlugin == null) {
                    return;
                }
                String wholeStack = Utils.getWholeStack(Looper.getMainLooper().getThread().getStackTrace());
                JSONObject deviceInfo = DeviceUtil.getDeviceInfo(new JSONObject(), Matrix.with().getApplication());
                deviceInfo.put(SharePluginInfo.ISSUE_STACK_TYPE, Constants.Type.LAG);
                deviceInfo.put(SharePluginInfo.ISSUE_SCENE, visibleScene);
                deviceInfo.put(SharePluginInfo.ISSUE_THREAD_STACK, wholeStack);
                deviceInfo.put(SharePluginInfo.ISSUE_PROCESS_FOREGROUND, isForeground);
                Issue issue = new Issue();
                issue.setTag(SharePluginInfo.TAG_PLUGIN_EVIL_METHOD);
                issue.setContent(deviceInfo);
                tracePlugin.onDetectIssue(issue);
                MatrixLog.e(LooperAnrTracer.TAG, "happens lag : %s, scene : %s ", wholeStack, visibleScene);
            } catch (JSONException e2) {
                MatrixLog.e(LooperAnrTracer.TAG, "[JSONException error: %s", e2);
            }
        }
    }

    public LooperAnrTracer(TraceConfig traceConfig) {
        this.traceConfig = traceConfig;
        this.isAnrTraceEnable = traceConfig.isAnrTraceEnable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long[] dumpMemory() {
        return new long[]{DeviceUtil.getDalvikHeap(), DeviceUtil.getNativeHeap(), DeviceUtil.getVmSize()};
    }

    private String printInputExpired(long j2) {
        StringBuilder sb = new StringBuilder();
        String visibleScene = AppMethodBeat.getVisibleScene();
        boolean isForeground = isForeground();
        long[] dumpMemory = dumpMemory();
        int[] processPriority = Utils.getProcessPriority(Process.myPid());
        sb.append(String.format("-\n>>>>>>>>>>>>>>>>>>>>>>> maybe happens Input ANR(%s ms)! <<<<<<<<<<<<<<<<<<<<<<<\n", Long.valueOf(j2)));
        sb.append("|* [Status]");
        sb.append("\n");
        sb.append("|*\t\tScene: ");
        sb.append(visibleScene);
        sb.append("\n");
        sb.append("|*\t\tForeground: ");
        sb.append(isForeground);
        sb.append("\n");
        sb.append("|*\t\tPriority: ");
        sb.append(processPriority[0]);
        sb.append("\tNice: ");
        sb.append(processPriority[1]);
        sb.append("\n");
        sb.append("|*\t\tis64BitRuntime: ");
        sb.append(DeviceUtil.is64BitRuntime());
        sb.append("\n");
        sb.append("|* [Memory]");
        sb.append("\n");
        sb.append("|*\t\tDalvikHeap: ");
        sb.append(dumpMemory[0]);
        sb.append("kb\n");
        sb.append("|*\t\tNativeHeap: ");
        sb.append(dumpMemory[1]);
        sb.append("kb\n");
        sb.append("|*\t\tVmSize: ");
        sb.append(dumpMemory[2]);
        sb.append("kb\n");
        sb.append("=========================================================================");
        return sb.toString();
    }

    @Override // com.tencent.matrix.trace.listeners.LooperObserver
    public void dispatchBegin(long j2, long j3, long j4) {
        super.dispatchBegin(j2, j3, j4);
        this.anrTask.a = AppMethodBeat.getInstance().maskIndex("AnrTracer#dispatchBegin");
        this.anrTask.b = j4;
        if (this.traceConfig.isDevEnv()) {
            MatrixLog.v(TAG, "* [dispatchBegin] token:%s index:%s", Long.valueOf(j4), Integer.valueOf(this.anrTask.a.index));
        }
        long nanoTime = (System.nanoTime() - j4) / 1000000;
        this.anrHandler.postDelayed(this.anrTask, 5000 - nanoTime);
        this.lagHandler.postDelayed(this.lagTask, 2000 - nanoTime);
    }

    @Override // com.tencent.matrix.trace.listeners.LooperObserver
    public void dispatchEnd(long j2, long j3, long j4, long j5, long j6, boolean z) {
        super.dispatchEnd(j2, j3, j4, j5, j6, z);
        if (this.traceConfig.isDevEnv()) {
            long j7 = (j4 - j2) / 1000000;
            long j8 = j5 - j3;
            MatrixLog.v(TAG, "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s", Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j8), Utils.calculateCpuUsage(j8, j7));
        }
        if (this.anrTask != null) {
            this.anrTask.a().release();
            this.anrHandler.removeCallbacks(this.anrTask);
        }
        if (this.lagTask != null) {
            this.lagHandler.removeCallbacks(this.lagTask);
        }
    }

    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onAlive() {
        super.onAlive();
        if (this.isAnrTraceEnable) {
            UIThreadMonitor.getMonitor().addObserver(this);
            this.anrHandler = new Handler(MatrixHandlerThread.getDefaultHandler().getLooper());
            this.lagHandler = new Handler(MatrixHandlerThread.getDefaultHandler().getLooper());
        }
    }

    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onDead() {
        super.onDead();
        if (this.isAnrTraceEnable) {
            UIThreadMonitor.getMonitor().removeObserver(this);
            if (this.anrTask != null) {
                this.anrTask.a().release();
            }
            this.anrHandler.removeCallbacksAndMessages(null);
            this.lagHandler.removeCallbacksAndMessages(null);
        }
    }
}
