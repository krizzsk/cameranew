package com.growingio.android.sdk.circle;

import android.app.Activity;
import android.net.Uri;
import com.growingio.android.sdk.base.event.CircleEvent;
import com.growingio.android.sdk.base.event.CircleGotWebSnapshotNodeEvent;
import com.growingio.android.sdk.base.event.ViewTreeStatusChangeEvent;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.debugger.DebuggerEventListener;
import com.growingio.android.sdk.debugger.DebuggerManager;
import com.growingio.android.sdk.models.PageEvent;
import com.growingio.android.sdk.models.VPAEvent;
import com.growingio.android.sdk.pending.PendingStatus;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.EventCenter;
import com.growingio.eventcenter.bus.EventBus;
import com.growingio.eventcenter.bus.SubscriberMethod;
import com.growingio.eventcenter.bus.ThreadMode;
import com.growingio.eventcenter.bus.meta.Subscriber;
/* loaded from: classes2.dex */
public class CircleSubscriber implements DebuggerEventListener, Subscriber {
    private final String TAG = "GIO.CircleSubscriber";
    private DebuggerManager debuggerManager;
    private boolean isMainProcess;

    public CircleSubscriber(DebuggerManager debuggerManager, boolean z) {
        this.debuggerManager = debuggerManager;
        this.isMainProcess = z;
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public void do$Action(String str, Object obj) {
        if (str.equals("#onViewTreeChange(com.growingio.android.sdk.base.event.ViewTreeStatusChangeEvent")) {
            onViewTreeChange((ViewTreeStatusChangeEvent) obj);
        } else if (str.equals("#onVPAEvent(com.growingio.android.sdk.models.VPAEvent")) {
            onVPAEvent((VPAEvent) obj);
        } else if (str.equals("#onCircleEvent(com.growingio.android.sdk.base.event.CircleEvent")) {
            onCircleEvent((CircleEvent) obj);
        } else if (str.equals("#onGotSnapShotEvent(com.growingio.android.sdk.base.event.CircleGotWebSnapshotNodeEvent")) {
            onGotSnapShotEvent((CircleGotWebSnapshotNodeEvent) obj);
        } else {
            System.out.println("No such method to delegate");
        }
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public SubscriberMethod[] get$SubscriberMethods() {
        ThreadMode threadMode = ThreadMode.POSTING;
        return new SubscriberMethod[]{new SubscriberMethod("onViewTreeChange", ViewTreeStatusChangeEvent.class, "#onViewTreeChange(com.growingio.android.sdk.base.event.ViewTreeStatusChangeEvent", threadMode, 0, false), new SubscriberMethod("onVPAEvent", VPAEvent.class, "#onVPAEvent(com.growingio.android.sdk.models.VPAEvent", ThreadMode.MAIN, 0, false), new SubscriberMethod("onCircleEvent", CircleEvent.class, "#onCircleEvent(com.growingio.android.sdk.base.event.CircleEvent", threadMode, 0, false), new SubscriberMethod("onGotSnapShotEvent", CircleGotWebSnapshotNodeEvent.class, "#onGotSnapShotEvent(com.growingio.android.sdk.base.event.CircleGotWebSnapshotNodeEvent", threadMode, 0, false)};
    }

    @Subscribe
    public void onCircleEvent(CircleEvent circleEvent) {
        LogUtil.d("GIO.CircleSubscriber", "onCircleEvent: ", circleEvent.type);
        String str = circleEvent.type;
        str.hashCode();
        if (str.equals("defaultListener")) {
            CircleManager.getInstance().defaultListener();
        } else if (str.equals("updateTagsIfNeeded")) {
            CircleManager.getInstance().updateTagsIfNeeded();
        } else {
            LogUtil.d("GIO.CircleSubscriber", "UNKnow event type: ", circleEvent.type);
        }
    }

    @Override // com.growingio.android.sdk.debugger.DebuggerEventListener
    public void onExit() {
        EventBus.getDefault().unregister(this);
    }

    @Override // com.growingio.android.sdk.debugger.DebuggerEventListener
    public void onFirstLaunch(Uri uri) {
        EventCenter.getInstance().register(this);
        PendingStatus.HEAT_MAP_CIRCLE.equals(uri == null ? null : uri.getQueryParameter("source"));
        if (this.isMainProcess) {
            this.debuggerManager.login();
        } else {
            onLoginSuccess();
        }
    }

    @Subscribe
    public void onGotSnapShotEvent(CircleGotWebSnapshotNodeEvent circleGotWebSnapshotNodeEvent) {
        CircleManager.getInstance().gotWebSnapshotNodes(circleGotWebSnapshotNodeEvent.getNodes(), circleGotWebSnapshotNodeEvent.getHost(), circleGotWebSnapshotNodeEvent.getPath());
    }

    @Override // com.growingio.android.sdk.debugger.DebuggerEventListener
    public void onLoginSuccess() {
        LogUtil.d("GIO.CircleSubscriber", "onLoginSuccess");
        CircleManager.getInstance().launchAppCircle();
    }

    @Override // com.growingio.android.sdk.debugger.DebuggerEventListener
    public void onPagePause() {
        CircleManager.getInstance().removeFloatViews();
    }

    @Override // com.growingio.android.sdk.debugger.DebuggerEventListener
    public void onPageResume() {
        Activity foregroundActivity = CoreInitialize.coreAppState().getForegroundActivity();
        if (foregroundActivity != null) {
            CircleManager.getInstance().onResumed(foregroundActivity);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onVPAEvent(VPAEvent vPAEvent) {
        if (vPAEvent == null || !PageEvent.TYPE_NAME.equals(vPAEvent.getType())) {
            return;
        }
        CircleManager.getInstance().refreshSnapshotWithType(PageEvent.TYPE_NAME, null, vPAEvent);
    }

    @Subscribe
    public void onViewTreeChange(ViewTreeStatusChangeEvent viewTreeStatusChangeEvent) {
        CircleManager.getInstance().refreshWebCircleTasks();
    }
}
