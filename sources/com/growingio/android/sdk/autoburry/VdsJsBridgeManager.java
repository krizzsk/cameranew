package com.growingio.android.sdk.autoburry;

import android.view.View;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.models.ViewNode;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.Util;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VdsJsBridgeManager {
    private static final String TAG = "GIO.VdsManager";
    private static VdsJsBridgeManager mInstance;
    private List<SnapshotCallback> mSnapshotCallbacks = new ArrayList();

    /* loaded from: classes2.dex */
    public interface SnapshotCallback {
        void onSnapshotFinished(List<ViewNode> list);
    }

    private VdsJsBridgeManager() {
    }

    public static VdsJsBridgeManager getInstance() {
        if (mInstance == null) {
            mInstance = new VdsJsBridgeManager();
        }
        return mInstance;
    }

    public static void hookWebViewIfNeeded(View view) {
        GConfig config = CoreInitialize.config();
        if (config == null || Util.isIgnoredView(view)) {
            return;
        }
        if (config.shouldTrackWebView() || Util.isTrackWebView(view)) {
            VdsJsHelper vdsJsHelper = (VdsJsHelper) view.getTag(AbstractGrowingIO.GROWING_WEB_BRIDGE_KEY);
            if (vdsJsHelper == null) {
                vdsJsHelper = new VdsJsHelper(view);
                view.setTag(AbstractGrowingIO.GROWING_WEB_BRIDGE_KEY, vdsJsHelper);
            }
            vdsJsHelper.updateViewNodeForce();
            LogUtil.d(TAG, "hookWebViewIfNeeded: hooked ", view);
        }
    }

    public static boolean isWebViewHooked(View view) {
        Object tag = view.getTag(AbstractGrowingIO.GROWING_WEB_BRIDGE_KEY);
        return tag != null && (tag instanceof VdsJsHelper);
    }

    @Deprecated
    public static void refreshImpressionForce(final View view) {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.growingio.android.sdk.autoburry.VdsJsBridgeManager.1
            @Override // java.lang.Runnable
            public void run() {
                Object tag = view.getTag(AbstractGrowingIO.GROWING_WEB_BRIDGE_KEY);
                if (tag instanceof VdsJsHelper) {
                    VdsJsHelper vdsJsHelper = (VdsJsHelper) tag;
                    vdsJsHelper.impressAllElements();
                    vdsJsHelper.updateViewNodeForce();
                }
            }
        });
    }

    public void onSnapshotFinished(VdsJsHelper vdsJsHelper, List<ViewNode> list) {
        for (SnapshotCallback snapshotCallback : this.mSnapshotCallbacks) {
            snapshotCallback.onSnapshotFinished(list);
        }
    }

    public void registerSnapshotCallback(SnapshotCallback snapshotCallback) {
        if (this.mSnapshotCallbacks.indexOf(snapshotCallback) == -1) {
            this.mSnapshotCallbacks.add(snapshotCallback);
        }
    }

    public boolean unregisterSnapshotCallback(SnapshotCallback snapshotCallback) {
        return this.mSnapshotCallbacks.remove(snapshotCallback);
    }
}
