package com.tencent.matrix.trace.tracer;

import androidx.annotation.Keep;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.trace.TracePlugin;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.tencent.matrix.trace.constants.Constants;
import com.tencent.matrix.trace.util.Utils;
import com.tencent.matrix.util.DeviceUtil;
import com.tencent.matrix.util.MatrixLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ThreadPriorityTracer extends Tracer {
    private static final String TAG = "ThreadPriorityTracer";
    private static MainThreadPriorityModifiedListener sMainThreadPriorityModifiedListener;

    /* loaded from: classes3.dex */
    public interface MainThreadPriorityModifiedListener {
        void onMainThreadPriorityModified(int i2);

        void onMainThreadTimerSlackModified(long j2);
    }

    static {
        System.loadLibrary("trace-canary");
    }

    private static native void nativeInitMainThreadPriorityDetective();

    @Keep
    private static void onMainThreadPriorityModified(int i2) {
        try {
            MainThreadPriorityModifiedListener mainThreadPriorityModifiedListener = sMainThreadPriorityModifiedListener;
            if (mainThreadPriorityModifiedListener != null) {
                mainThreadPriorityModifiedListener.onMainThreadPriorityModified(i2);
                return;
            }
            TracePlugin tracePlugin = (TracePlugin) Matrix.with().getPluginByClass(TracePlugin.class);
            if (tracePlugin == null) {
                return;
            }
            String mainThreadJavaStackTrace = Utils.getMainThreadJavaStackTrace();
            JSONObject deviceInfo = DeviceUtil.getDeviceInfo(new JSONObject(), Matrix.with().getApplication());
            deviceInfo.put(SharePluginInfo.ISSUE_STACK_TYPE, Constants.Type.PRIORITY_MODIFIED);
            deviceInfo.put(SharePluginInfo.ISSUE_THREAD_STACK, mainThreadJavaStackTrace);
            deviceInfo.put(SharePluginInfo.ISSUE_PROCESS_PRIORITY, i2);
            Issue issue = new Issue();
            issue.setTag(SharePluginInfo.TAG_PLUGIN_EVIL_METHOD);
            issue.setContent(deviceInfo);
            tracePlugin.onDetectIssue(issue);
            MatrixLog.e(TAG, "happens MainThreadPriorityModified : %s ", deviceInfo.toString());
        } catch (Throwable th) {
            MatrixLog.e(TAG, "onMainThreadPriorityModified error: %s", th.getMessage());
        }
    }

    @Keep
    private static void onMainThreadTimerSlackModified(long j2) {
        try {
            MainThreadPriorityModifiedListener mainThreadPriorityModifiedListener = sMainThreadPriorityModifiedListener;
            if (mainThreadPriorityModifiedListener != null) {
                mainThreadPriorityModifiedListener.onMainThreadTimerSlackModified(j2);
                return;
            }
            TracePlugin tracePlugin = (TracePlugin) Matrix.with().getPluginByClass(TracePlugin.class);
            if (tracePlugin == null) {
                return;
            }
            String mainThreadJavaStackTrace = Utils.getMainThreadJavaStackTrace();
            JSONObject deviceInfo = DeviceUtil.getDeviceInfo(new JSONObject(), Matrix.with().getApplication());
            deviceInfo.put(SharePluginInfo.ISSUE_STACK_TYPE, Constants.Type.TIMERSLACK_MODIFIED);
            deviceInfo.put(SharePluginInfo.ISSUE_THREAD_STACK, mainThreadJavaStackTrace);
            deviceInfo.put(SharePluginInfo.ISSUE_PROCESS_TIMER_SLACK, j2);
            Issue issue = new Issue();
            issue.setTag(SharePluginInfo.TAG_PLUGIN_EVIL_METHOD);
            issue.setContent(deviceInfo);
            tracePlugin.onDetectIssue(issue);
            MatrixLog.e(TAG, "happens MainThreadPriorityModified : %s ", deviceInfo.toString());
        } catch (Throwable th) {
            MatrixLog.e(TAG, "onMainThreadPriorityModified error: %s", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onAlive() {
        super.onAlive();
        nativeInitMainThreadPriorityDetective();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onDead() {
        super.onDead();
    }

    public void setMainThreadPriorityModifiedListener(MainThreadPriorityModifiedListener mainThreadPriorityModifiedListener) {
        sMainThreadPriorityModifiedListener = mainThreadPriorityModifiedListener;
    }
}
