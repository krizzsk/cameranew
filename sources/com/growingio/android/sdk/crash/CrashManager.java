package com.growingio.android.sdk.crash;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.monitor.Monitor;
import com.growingio.android.sdk.monitor.MonitorClient;
import com.growingio.android.sdk.monitor.analysis.Analysed;
import com.growingio.android.sdk.monitor.analysis.Analyser;
import com.growingio.android.sdk.monitor.analysis.GIOAnalyser;
import com.growingio.android.sdk.monitor.event.EventBuilder;
import com.growingio.android.sdk.monitor.event.User;
import com.growingio.android.sdk.utils.LogUtil;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class CrashManager {
    public static final String ALIAS = "gandroid";
    private static final String DSN = "https://3db1f04a7238465ab285f46b462b5ffe@sentry.growingio.com/7";
    private static final String PROJECT_ID = "ai";
    public static final String TAG = "CrashManager";
    private static volatile boolean mEnabled = false;

    public static void close() {
        if (mEnabled) {
            Monitor.close(ALIAS);
        }
    }

    public static boolean isEnabled() {
        return mEnabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @VisibleForTesting
    public static boolean isSdkException(Analysed analysed) {
        StackTraceElement firstTargetElement;
        if (analysed == null || !analysed.isFindTarget() || (firstTargetElement = analysed.getFirstTargetElement()) == null) {
            return false;
        }
        return firstTargetElement.getClassName().startsWith("com.growingio");
    }

    public static void register(Context context) {
        if (mEnabled) {
            return;
        }
        try {
            MonitorClient register = Monitor.register(ALIAS, DSN, context, new MonitorClient.FilterThrowableRule() { // from class: com.growingio.android.sdk.crash.CrashManager.1
                @Override // com.growingio.android.sdk.monitor.MonitorClient.FilterThrowableRule
                public boolean filterThrowable(Throwable th) {
                    Analyser analyser = GIOAnalyser.getInstance().getAnalyser();
                    Analysed lastAnalysed = analyser.getLastAnalysed();
                    if (lastAnalysed == null || lastAnalysed.getThrowable() != th) {
                        lastAnalysed = analyser.analyze(th);
                    }
                    return CrashManager.isSdkException(lastAnalysed);
                }
            });
            register.setRelease("autotrack-2.9.4");
            if (CoreInitialize.coreAppState() != null) {
                register.getContext().addTag(PROJECT_ID, CoreInitialize.coreAppState().getProjectId());
                register.getContext().setUser(new User(CoreInitialize.deviceUUIDFactory().getDeviceId(), CoreInitialize.config().getAppUserId()));
            }
            mEnabled = true;
            LogUtil.add(CrashUtil.getInstance());
        } catch (Throwable th) {
            LogUtil.e(TAG, "Monitor注册失败（请检查依赖sdk时是否未删除@aar）", th);
        }
    }

    public static void sendEvent(EventBuilder eventBuilder) {
        if (mEnabled) {
            Monitor.getStoredClient(ALIAS).sendEvent(eventBuilder);
        }
    }

    public static void sendException(Throwable th) {
        if (mEnabled) {
            Monitor.getStoredClient(ALIAS).sendException(th);
        }
    }

    public static void sendMessage(String str) {
        if (mEnabled) {
            Monitor.getStoredClient(ALIAS).sendMessage(str);
        }
    }

    public static void unRegister() {
        if (mEnabled) {
            Monitor.unregister(ALIAS);
            mEnabled = false;
        }
    }
}
