package com.tencent.matrix.trace.tracer;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue;
import androidx.annotation.Nullable;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.trace.TracePlugin;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.tencent.matrix.trace.config.TraceConfig;
import com.tencent.matrix.trace.constants.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.util.AppForegroundUtil;
import com.tencent.matrix.trace.util.Utils;
import com.tencent.matrix.util.DeviceUtil;
import com.tencent.matrix.util.MatrixLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IdleHandlerLagTracer extends Tracer {
    private static final String TAG = "Matrix.AnrTracer";
    private static Handler idleHandlerLagHandler;
    private static HandlerThread idleHandlerLagHandlerThread;
    private static Runnable idleHanlderLagRunnable;
    private final TraceConfig traceConfig;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class MyArrayList<T> extends ArrayList {
        Map<MessageQueue.IdleHandler, b> map = new HashMap();

        MyArrayList() {
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(Object obj) {
            if (obj instanceof MessageQueue.IdleHandler) {
                MessageQueue.IdleHandler idleHandler = (MessageQueue.IdleHandler) obj;
                b bVar = new b(idleHandler);
                this.map.put(idleHandler, bVar);
                return super.add(bVar);
            }
            return super.add(obj);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(@Nullable Object obj) {
            if (obj instanceof b) {
                this.map.remove(((b) obj).a);
                return super.remove(obj);
            }
            b remove = this.map.remove(obj);
            if (remove != null) {
                return super.remove(remove);
            }
            return super.remove(obj);
        }
    }

    /* loaded from: classes3.dex */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TracePlugin tracePlugin = (TracePlugin) Matrix.with().getPluginByClass(TracePlugin.class);
                if (tracePlugin == null) {
                    return;
                }
                String mainThreadJavaStackTrace = Utils.getMainThreadJavaStackTrace();
                boolean isInterestingToUser = AppForegroundUtil.isInterestingToUser();
                String visibleScene = AppMethodBeat.getVisibleScene();
                JSONObject deviceInfo = DeviceUtil.getDeviceInfo(new JSONObject(), Matrix.with().getApplication());
                deviceInfo.put(SharePluginInfo.ISSUE_STACK_TYPE, Constants.Type.LAG_IDLE_HANDLER);
                deviceInfo.put(SharePluginInfo.ISSUE_SCENE, visibleScene);
                deviceInfo.put(SharePluginInfo.ISSUE_THREAD_STACK, mainThreadJavaStackTrace);
                deviceInfo.put(SharePluginInfo.ISSUE_PROCESS_FOREGROUND, isInterestingToUser);
                Issue issue = new Issue();
                issue.setTag(SharePluginInfo.TAG_PLUGIN_EVIL_METHOD);
                issue.setContent(deviceInfo);
                tracePlugin.onDetectIssue(issue);
                MatrixLog.e(IdleHandlerLagTracer.TAG, "happens idle handler Lag : %s ", deviceInfo.toString());
            } catch (Throwable th) {
                MatrixLog.e(IdleHandlerLagTracer.TAG, "Matrix error, error = " + th.getMessage(), new Object[0]);
            }
        }
    }

    /* loaded from: classes3.dex */
    static class b implements MessageQueue.IdleHandler {
        private MessageQueue.IdleHandler a;

        b(MessageQueue.IdleHandler idleHandler) {
            this.a = idleHandler;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            IdleHandlerLagTracer.idleHandlerLagHandler.postDelayed(IdleHandlerLagTracer.idleHanlderLagRunnable, 2000L);
            boolean queueIdle = this.a.queueIdle();
            IdleHandlerLagTracer.idleHandlerLagHandler.removeCallbacks(IdleHandlerLagTracer.idleHanlderLagRunnable);
            return queueIdle;
        }
    }

    public IdleHandlerLagTracer(TraceConfig traceConfig) {
        this.traceConfig = traceConfig;
    }

    private static void detectIdleHandler() {
        try {
            if (Build.VERSION.SDK_INT < 23) {
                return;
            }
            MessageQueue queue = Looper.getMainLooper().getQueue();
            Field declaredField = MessageQueue.class.getDeclaredField("mIdleHandlers");
            declaredField.setAccessible(true);
            declaredField.set(queue, new MyArrayList());
            idleHandlerLagHandlerThread.start();
            idleHandlerLagHandler = new Handler(idleHandlerLagHandlerThread.getLooper());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onAlive() {
        super.onAlive();
        if (this.traceConfig.isIdleHandlerEnable()) {
            idleHandlerLagHandlerThread = new HandlerThread("IdleHandlerLagThread");
            idleHanlderLagRunnable = new a();
            detectIdleHandler();
        }
    }

    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onDead() {
        super.onDead();
        if (this.traceConfig.isIdleHandlerEnable()) {
            idleHandlerLagHandler.removeCallbacksAndMessages(null);
        }
    }
}
