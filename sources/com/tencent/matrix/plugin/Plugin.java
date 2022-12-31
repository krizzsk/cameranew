package com.tencent.matrix.plugin;

import android.app.Application;
import com.tencent.matrix.AppActiveMatrixDelegate;
import com.tencent.matrix.listeners.IAppForeground;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.report.IssuePublisher;
import com.tencent.matrix.util.MatrixLog;
import com.tencent.matrix.util.MatrixUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class Plugin implements IPlugin, IssuePublisher.OnIssueDetectListener, IAppForeground {
    public static final int PLUGIN_CREATE = 0;
    public static final int PLUGIN_DESTROYED = 8;
    public static final int PLUGIN_INITED = 1;
    public static final int PLUGIN_STARTED = 2;
    public static final int PLUGIN_STOPPED = 4;
    private static final String TAG = "Matrix.Plugin";
    private Application application;
    private PluginListener pluginListener;
    private boolean isSupported = true;
    private int status = 0;

    @Override // com.tencent.matrix.plugin.IPlugin
    public void destroy() {
        if (isPluginStarted()) {
            stop();
        }
        if (!isPluginDestroyed()) {
            this.status = 8;
            PluginListener pluginListener = this.pluginListener;
            if (pluginListener != null) {
                pluginListener.onDestroy(this);
                return;
            }
            throw new RuntimeException("plugin destroy, plugin listener is null");
        }
        throw new RuntimeException("plugin destroy, but plugin has been already destroyed");
    }

    @Override // com.tencent.matrix.plugin.IPlugin
    public Application getApplication() {
        return this.application;
    }

    public JSONObject getJsonInfo() {
        return new JSONObject();
    }

    public int getStatus() {
        return this.status;
    }

    @Override // com.tencent.matrix.plugin.IPlugin
    public String getTag() {
        return getClass().getName();
    }

    @Override // com.tencent.matrix.plugin.IPlugin
    public void init(Application application, PluginListener pluginListener) {
        if (this.application == null && this.pluginListener == null) {
            this.status = 1;
            this.application = application;
            this.pluginListener = pluginListener;
            AppActiveMatrixDelegate.INSTANCE.addListener(this);
            return;
        }
        throw new RuntimeException("plugin duplicate init, application or plugin listener is not null");
    }

    public boolean isForeground() {
        return AppActiveMatrixDelegate.INSTANCE.isAppForeground();
    }

    public boolean isPluginDestroyed() {
        return this.status == 8;
    }

    public boolean isPluginStarted() {
        return this.status == 2;
    }

    public boolean isPluginStopped() {
        return this.status == 4;
    }

    public boolean isSupported() {
        return this.isSupported;
    }

    @Override // com.tencent.matrix.report.IssuePublisher.OnIssueDetectListener
    public void onDetectIssue(Issue issue) {
        if (issue.getTag() == null) {
            issue.setTag(getTag());
        }
        issue.setPlugin(this);
        JSONObject content = issue.getContent();
        try {
            if (issue.getTag() != null) {
                content.put(Issue.ISSUE_REPORT_TAG, issue.getTag());
            }
            if (issue.getType() != 0) {
                content.put("type", issue.getType());
            }
            content.put(Issue.ISSUE_REPORT_PROCESS, MatrixUtil.getProcessName(this.application));
            content.put(Issue.ISSUE_REPORT_TIME, System.currentTimeMillis());
        } catch (JSONException e2) {
            MatrixLog.e(TAG, "json error", e2);
        }
        this.pluginListener.onReportIssue(issue);
    }

    @Override // com.tencent.matrix.plugin.IPlugin, com.tencent.matrix.listeners.IAppForeground
    public void onForeground(boolean z) {
    }

    @Override // com.tencent.matrix.plugin.IPlugin
    public void start() {
        if (!isPluginDestroyed()) {
            if (!isPluginStarted()) {
                this.status = 2;
                PluginListener pluginListener = this.pluginListener;
                if (pluginListener != null) {
                    pluginListener.onStart(this);
                    return;
                }
                throw new RuntimeException("plugin start, plugin listener is null");
            }
            throw new RuntimeException("plugin start, but plugin has been already started");
        }
        throw new RuntimeException("plugin start, but plugin has been already destroyed");
    }

    @Override // com.tencent.matrix.plugin.IPlugin
    public void stop() {
        if (!isPluginDestroyed()) {
            if (isPluginStarted()) {
                this.status = 4;
                PluginListener pluginListener = this.pluginListener;
                if (pluginListener != null) {
                    pluginListener.onStop(this);
                    return;
                }
                throw new RuntimeException("plugin stop, plugin listener is null");
            }
            throw new RuntimeException("plugin stop, but plugin is never started");
        }
        throw new RuntimeException("plugin stop, but plugin has been already destroyed");
    }

    public void unSupportPlugin() {
        this.isSupported = false;
    }
}
