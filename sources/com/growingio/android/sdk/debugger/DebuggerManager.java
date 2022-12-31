package com.growingio.android.sdk.debugger;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.view.WindowManager;
import com.growingio.android.sdk.api.LoginAPI;
import com.growingio.android.sdk.base.event.ActivityLifecycleEvent;
import com.growingio.android.sdk.base.event.HttpCallBack;
import com.growingio.android.sdk.base.event.ValidUrlEvent;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.debugger.event.ExitAndKillAppEvent;
import com.growingio.android.sdk.ipc.GrowingIOIPC;
import com.growingio.android.sdk.models.PageEvent;
import com.growingio.android.sdk.pending.PendingStatus;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.ScreenshotHelper;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.rom.FloatPermissionChecker;
import com.growingio.android.sdk.utils.rom.FloatPermissionUtil;
import com.growingio.android.sdk.utils.rom.RomChecker;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.bus.SubscriberMethod;
import com.growingio.eventcenter.bus.ThreadMode;
import com.growingio.eventcenter.bus.meta.Subscriber;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DebuggerManager implements Subscriber {
    private static final String TAG = "GIO.Debugger";
    private CoreAppState coreAppState;
    private LoginAPI loginAPI;
    private AlertDialog needSystemAlertPermissionDialog;
    private boolean isLoginDone = false;
    private boolean hasCheckPermissionAgain = false;
    private Map<String, DebuggerEventListener> type2EventListener = new HashMap();
    private DebuggerEventListener currentEventListener = null;
    private Runnable mCheckCanDrawOverlayPermissionDelay = new Runnable() { // from class: com.growingio.android.sdk.debugger.DebuggerManager.1
        @Override // java.lang.Runnable
        public void run() {
            Activity resumedActivity = DebuggerManager.this.coreAppState.getResumedActivity();
            if (resumedActivity == null) {
                return;
            }
            boolean check = FloatPermissionUtil.getPermissionChecker(resumedActivity).check();
            LogUtil.d(DebuggerManager.TAG, "onResume, delayed times, to check has canDrawOverlay permission: ", Boolean.valueOf(check));
            if (check || DebuggerManager.this.currentEventListener == null) {
                return;
            }
            LogUtil.d(DebuggerManager.TAG, "don't has canDrawOverlay permission, check permission again");
            DebuggerManager.this.hasCheckPermissionAgain = true;
            DebuggerManager.this.checkWindowPermission(resumedActivity);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.growingio.android.sdk.debugger.DebuggerManager$6  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE;

        static {
            int[] iArr = new int[ActivityLifecycleEvent.EVENT_TYPE.values().length];
            $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE = iArr;
            try {
                iArr[ActivityLifecycleEvent.EVENT_TYPE.ON_CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE[ActivityLifecycleEvent.EVENT_TYPE.ON_NEW_INTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE[ActivityLifecycleEvent.EVENT_TYPE.ON_RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE[ActivityLifecycleEvent.EVENT_TYPE.ON_PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE[ActivityLifecycleEvent.EVENT_TYPE.ON_DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public DebuggerManager(CoreAppState coreAppState) {
        this.coreAppState = coreAppState;
    }

    private void checkMultipleProcessState(Activity activity) {
        if (PendingStatus.isValidMultiProcessState()) {
            LogUtil.d(TAG, "found multi process state, and launch float view");
            ScreenshotHelper.initial();
            launchFloatViewIfNeed(null, activity);
        }
    }

    private DebuggerEventListener getEventListenerFromUriType(boolean z) {
        String str;
        String str2;
        if (PendingStatus.isAppCircleEnabled()) {
            str = "app-circle";
        } else if (PendingStatus.isWebCircleEnabled()) {
            str = "web-circle";
        } else if (!PendingStatus.isDebuggerEnabled()) {
            return null;
        } else {
            str = "mobile-debugger";
        }
        if (z) {
            str2 = str + "-main";
        } else {
            str2 = str + "-non-main";
        }
        return getDebuggerEventListenerByType(str2);
    }

    private LoginAPI getLoginAPI() {
        if (this.loginAPI == null) {
            synchronized (this) {
                this.loginAPI = new LoginAPI();
            }
        }
        return this.loginAPI;
    }

    private void showGuideDialog(Activity activity, final Intent intent) {
        AlertDialog alertDialog = this.needSystemAlertPermissionDialog;
        if (alertDialog != null && alertDialog.getOwnerActivity() == activity && this.needSystemAlertPermissionDialog.isShowing()) {
            return;
        }
        AlertDialog alertDialog2 = this.needSystemAlertPermissionDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
            this.needSystemAlertPermissionDialog = null;
        }
        AlertDialog.Builder cancelable = new AlertDialog.Builder(activity).setTitle("GrowingIO SDK提示").setMessage("使用圈选功能,需要您开启当前应用的悬浮窗权限").setPositiveButton(intent == null ? "自行设置" : "去设置", new DialogInterface.OnClickListener() { // from class: com.growingio.android.sdk.debugger.DebuggerManager.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                try {
                    if (DebuggerManager.this.needSystemAlertPermissionDialog != null) {
                        DebuggerManager.this.needSystemAlertPermissionDialog.dismiss();
                        DebuggerManager.this.needSystemAlertPermissionDialog = null;
                    }
                } catch (Exception unused) {
                }
                if (intent != null) {
                    CoreInitialize.coreAppState().getGlobalContext().startActivity(intent);
                }
            }
        }).setCancelable(false);
        if (this.hasCheckPermissionAgain || (RomChecker.isHuaweiRom() && Build.VERSION.SDK_INT >= 26)) {
            cancelable.setNegativeButton("已设置", new DialogInterface.OnClickListener() { // from class: com.growingio.android.sdk.debugger.DebuggerManager.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    try {
                        LogUtil.d(DebuggerManager.TAG, "权限已设置， 启动之");
                        if (DebuggerManager.this.needSystemAlertPermissionDialog != null) {
                            DebuggerManager.this.needSystemAlertPermissionDialog.dismiss();
                            DebuggerManager.this.needSystemAlertPermissionDialog = null;
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
        AlertDialog create = cancelable.create();
        this.needSystemAlertPermissionDialog = create;
        create.show();
        this.coreAppState.onGIODialogShow(activity, this.needSystemAlertPermissionDialog);
    }

    public boolean checkWindowPermission(Activity activity) {
        FloatPermissionChecker build = new FloatPermissionChecker.Builder(activity).build();
        Intent intentOrNull = build.getIntentOrNull();
        if (build.checkOp()) {
            return true;
        }
        try {
            showGuideDialog(activity, intentOrNull);
            return false;
        } catch (Exception unused) {
            this.needSystemAlertPermissionDialog = null;
            return false;
        }
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public void do$Action(String str, Object obj) {
        if (str.equals("#onActivityLifecycle(com.growingio.android.sdk.base.event.ActivityLifecycleEvent")) {
            onActivityLifecycle((ActivityLifecycleEvent) obj);
        } else if (str.equals("#onValidUrlSchema(com.growingio.android.sdk.base.event.ValidUrlEvent")) {
            onValidUrlSchema((ValidUrlEvent) obj);
        } else if (str.equals("#onPageEvent(com.growingio.android.sdk.models.PageEvent")) {
            onPageEvent((PageEvent) obj);
        } else if (str.equals("#onExitAndKillApp(com.growingio.android.sdk.debugger.event.ExitAndKillAppEvent")) {
            onExitAndKillApp((ExitAndKillAppEvent) obj);
        } else {
            System.out.println("No such method to delegate");
        }
    }

    public void exit() {
        LogUtil.d(TAG, "exit");
        getLoginAPI().logout();
        PendingStatus.disable();
        this.isLoginDone = false;
        DebuggerEventListener debuggerEventListener = this.currentEventListener;
        if (debuggerEventListener != null) {
            debuggerEventListener.onExit();
        }
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public SubscriberMethod[] get$SubscriberMethods() {
        ThreadMode threadMode = ThreadMode.POSTING;
        ThreadMode threadMode2 = ThreadMode.MAIN;
        return new SubscriberMethod[]{new SubscriberMethod("onActivityLifecycle", ActivityLifecycleEvent.class, "#onActivityLifecycle(com.growingio.android.sdk.base.event.ActivityLifecycleEvent", threadMode, 0, false), new SubscriberMethod("onValidUrlSchema", ValidUrlEvent.class, "#onValidUrlSchema(com.growingio.android.sdk.base.event.ValidUrlEvent", threadMode, 0, false), new SubscriberMethod("onPageEvent", PageEvent.class, "#onPageEvent(com.growingio.android.sdk.models.PageEvent", threadMode2, 0, false), new SubscriberMethod("onExitAndKillApp", ExitAndKillAppEvent.class, "#onExitAndKillApp(com.growingio.android.sdk.debugger.event.ExitAndKillAppEvent", threadMode2, 0, false)};
    }

    public DebuggerEventListener getDebuggerEventListenerByType(String str) {
        return this.type2EventListener.get(str);
    }

    public boolean isLoginDone() {
        return this.isLoginDone;
    }

    public void killApp() {
        Activity foregroundActivity = this.coreAppState.getForegroundActivity();
        if (foregroundActivity != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            foregroundActivity.startActivity(intent);
            if (Build.VERSION.SDK_INT >= 16) {
                foregroundActivity.finishAffinity();
            } else {
                foregroundActivity.finish();
            }
        }
        ThreadUtils.postOnUiThreadDelayed(new Runnable() { // from class: com.growingio.android.sdk.debugger.DebuggerManager.4
            @Override // java.lang.Runnable
            public void run() {
                GrowingIOIPC growingIOIPC = CoreInitialize.growingIOIPC();
                int myPid = Process.myPid();
                if (growingIOIPC != null) {
                    for (Integer num : growingIOIPC.getAlivePid()) {
                        if (myPid != num.intValue()) {
                            LogUtil.d(DebuggerManager.TAG, "kill process: ", num);
                            Process.killProcess(num.intValue());
                        }
                    }
                }
                Process.killProcess(myPid);
            }
        }, 1000L);
    }

    void launchFloatViewIfNeed(Uri uri, Activity activity) {
        Boolean bool;
        LogUtil.d(TAG, "launchFloatViewIfNeed()");
        if (this.coreAppState.getForegroundActivity() == null) {
            this.coreAppState.setForegroundActivity(activity);
        }
        if (uri != null) {
            LogUtil.d(TAG, "isValidData:true");
            String queryParameter = uri.getQueryParameter("circleType");
            if (queryParameter == null && uri.getQueryParameter("dataCheckRoomNumber") != null) {
                LogUtil.d(TAG, "found data-check url, and set circleType to debugger");
                queryParameter = PendingStatus.DATA_CHECK;
            }
            PendingStatus.mLoginToken = uri.getQueryParameter("loginToken");
            PendingStatus.setSpecialModelFromType(queryParameter);
            bool = Boolean.TRUE;
        } else {
            bool = Boolean.FALSE;
        }
        if (bool != null) {
            if (this.currentEventListener != null) {
                LogUtil.d(TAG, "currentEventListener is not null, may be re-create Activity or multiple special model");
                this.isLoginDone = false;
                this.currentEventListener.onExit();
                this.currentEventListener = null;
            }
            DebuggerEventListener eventListenerFromUriType = getEventListenerFromUriType(bool.booleanValue());
            this.currentEventListener = eventListenerFromUriType;
            LogUtil.d(TAG, "currentEventListener=", eventListenerFromUriType, ", and shouldFindEventMainProcessListener: ", bool);
            DebuggerEventListener debuggerEventListener = this.currentEventListener;
            if (debuggerEventListener == null) {
                LogUtil.e(TAG, "not found valid event listener");
                PendingStatus.disable();
                return;
            }
            debuggerEventListener.onFirstLaunch(uri);
        }
    }

    public void login() {
        String str = PendingStatus.mLoginToken;
        getLoginAPI().setHttpCallBack(new HttpCallBack() { // from class: com.growingio.android.sdk.debugger.DebuggerManager.5
            @Override // com.growingio.android.sdk.base.event.HttpCallBack
            public void afterRequest(final Integer num, final byte[] bArr, long j2, Map<String, List<String>> map) {
                ThreadUtils.runOnUiThread(new Runnable() { // from class: com.growingio.android.sdk.debugger.DebuggerManager.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DebuggerManager.this.coreAppState.getResumedActivity() != null) {
                            if (num.intValue() == 200) {
                                DebuggerManager.this.loginSuccess();
                            } else {
                                DebuggerManager.this.loginFailed(num.intValue(), bArr);
                            }
                        }
                    }
                });
            }
        });
        getLoginAPI().login(str);
    }

    public void loginFailed(int i2, byte[] bArr) {
        String string;
        LogUtil.d(TAG, "loginFailed");
        String str = PendingStatus.isProjection() ? "请重新扫描" : "请重新唤醒App";
        if (i2 == 422) {
            try {
                string = new JSONObject(new String(bArr)).getString("error");
            } catch (JSONException unused) {
            }
        } else if (i2 >= 500) {
            string = "服务器错误，请稍后重新扫描二维码";
        } else {
            if (i2 == 0) {
                string = "检测不到网络连接，请确保已接入互联网";
                str = "请连接网络";
            }
            string = "发生未知错误";
        }
        Activity resumedActivity = this.coreAppState.getResumedActivity();
        exit();
        if (resumedActivity == null || resumedActivity.isFinishing()) {
            return;
        }
        try {
            AlertDialog create = new AlertDialog.Builder(resumedActivity).setTitle(str).setMessage(string).setPositiveButton("知道了", (DialogInterface.OnClickListener) null).create();
            create.show();
            this.coreAppState.onGIODialogShow(resumedActivity, create);
        } catch (WindowManager.BadTokenException unused2) {
        }
    }

    public void loginSuccess() {
        LogUtil.d(TAG, "loginSuccess");
        this.isLoginDone = true;
        DebuggerEventListener debuggerEventListener = this.currentEventListener;
        if (debuggerEventListener != null) {
            debuggerEventListener.onLoginSuccess();
        }
    }

    @Subscribe
    public void onActivityLifecycle(ActivityLifecycleEvent activityLifecycleEvent) {
        int i2 = AnonymousClass6.$SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE[activityLifecycleEvent.event_type.ordinal()];
        if (i2 == 1 || i2 == 2) {
            checkMultipleProcessState(activityLifecycleEvent.getActivity());
        } else if (i2 == 3) {
            onResumeActivity(activityLifecycleEvent.getActivity());
        } else if (i2 == 4 || i2 == 5) {
            onPauseActivity(activityLifecycleEvent.getActivity());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onExitAndKillApp(ExitAndKillAppEvent exitAndKillAppEvent) {
        LogUtil.d(TAG, "onExitAndKillApp", new Exception("just for log"));
        exit();
        killApp();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPageEvent(PageEvent pageEvent) {
        if (this.currentEventListener == null || this.coreAppState.getResumedActivity() == null) {
            return;
        }
        this.currentEventListener.onPageResume();
    }

    public void onPauseActivity(Activity activity) {
        DebuggerEventListener debuggerEventListener;
        if (this.coreAppState.getForegroundActivity() != activity || (debuggerEventListener = this.currentEventListener) == null) {
            return;
        }
        debuggerEventListener.onPagePause();
        ThreadUtils.cancelTaskOnUiThread(this.mCheckCanDrawOverlayPermissionDelay);
    }

    public void onResumeActivity(Activity activity) {
        if (this.currentEventListener != null) {
            PendingStatus.syncModelOnResume();
            if (PendingStatus.isEnable() && checkWindowPermission(activity)) {
                this.currentEventListener.onPageResume();
                ThreadUtils.postOnUiThreadDelayed(this.mCheckCanDrawOverlayPermissionDelay, 1000L);
            }
            activity.getWindow().addFlags(128);
        }
    }

    @Subscribe
    public void onValidUrlSchema(ValidUrlEvent validUrlEvent) {
        if (validUrlEvent.activity == null || validUrlEvent.type != 1) {
            return;
        }
        ScreenshotHelper.initial();
        launchFloatViewIfNeed(validUrlEvent.data, validUrlEvent.activity);
    }

    public void registerDebuggerEventListener(String str, DebuggerEventListener debuggerEventListener) {
        this.type2EventListener.put(str, debuggerEventListener);
    }
}
