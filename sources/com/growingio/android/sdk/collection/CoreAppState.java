package com.growingio.android.sdk.collection;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.growingio.android.sdk.base.event.ActivityLifecycleEvent;
import com.growingio.android.sdk.base.event.RefreshPageEvent;
import com.growingio.android.sdk.base.event.ScreenStatusEvent;
import com.growingio.android.sdk.base.event.net.NetWorkChangedEvent;
import com.growingio.android.sdk.ipc.GrowingIOIPC;
import com.growingio.android.sdk.models.VisitorVarEvent;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.NetworkUtil;
import com.growingio.android.sdk.utils.ObjectUtils;
import com.growingio.android.sdk.utils.PersistUtil;
import com.growingio.android.sdk.utils.SimpleJSONVariableUpdateHelper;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.WeakSet;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.EventCenter;
import com.growingio.eventcenter.bus.SubscriberMethod;
import com.growingio.eventcenter.bus.ThreadMode;
import com.growingio.eventcenter.bus.meta.Subscriber;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CoreAppState implements Subscriber {
    public static final int NETWORK_CELLULAR_ONLINE = 1;
    public static final int NETWORK_OFFLINE = 0;
    public static final int NETWORK_UNKNOWN = -1;
    public static final int NETWORK_WIFI_ONLINE = 2;
    public static final String TAG = "GIO.AppState";
    @VisibleForTesting
    static String lastUserId;
    private GrowingIOIPC growingIOIPC;
    private volatile boolean mBgInitComplete;
    @VisibleForTesting
    GConfig mConfig;
    private Context mGlobalContext;
    private Double mLastLat;
    private Double mLastLon;
    private String mSpn;
    private MessageProcessor msgProcessor;
    private String networkStateName;
    private SessionManager sessionManager;
    @VisibleForTesting
    long mLastSetLocationTime = 0;
    private JSONObject mAppVariable = new JSONObject();
    private JSONObject mPeopleVariable = new JSONObject();
    private boolean screenOn = true;
    private int mNetworkState = -1;
    private int mCurrentRootWindowsHashCode = -1;
    private WeakHashMap<Object, SimpleJSONVariableUpdateHelper> mPageVariableHelpers = new WeakHashMap<>();
    private WeakReference<Activity> mResumedActivity = new WeakReference<>(null);
    private WeakReference<Activity> mForeGroundActivity = new WeakReference<>(null);
    @VisibleForTesting
    WeakHashMap<Activity, WeakSet<Dialog>> mActivitiesWithGioDialogs = null;
    private final Object mCondition = new Object();
    private SimpleJSONVariableUpdateHelper mAppVariableHelper = new SimpleJSONVariableUpdateHelper(this.mAppVariable) { // from class: com.growingio.android.sdk.collection.CoreAppState.2
        @Override // com.growingio.android.sdk.utils.SimpleJSONVariableUpdateHelper
        public void afterUpdated() {
            CoreAppState.this.msgProcessor.onAppVariableUpdated();
        }
    };
    private SimpleJSONVariableUpdateHelper mConversionVariableHelper = new SimpleJSONVariableUpdateHelper() { // from class: com.growingio.android.sdk.collection.CoreAppState.3
        @Override // com.growingio.android.sdk.utils.SimpleJSONVariableUpdateHelper
        public void afterUpdated() {
            JSONObject variable = getVariable();
            if (variable == null) {
                return;
            }
            CoreAppState.this.msgProcessor.setEvar(variable);
            setVariable(new JSONObject());
        }
    };
    private SimpleJSONVariableUpdateHelper mPeopleVariableHelper = new SimpleJSONVariableUpdateHelper(this.mPeopleVariable) { // from class: com.growingio.android.sdk.collection.CoreAppState.4
        @Override // com.growingio.android.sdk.utils.SimpleJSONVariableUpdateHelper
        public void afterUpdated() {
            JSONObject variable = getVariable();
            if (variable == null) {
                return;
            }
            CoreAppState.this.msgProcessor.setPeople(variable);
            setVariable(new JSONObject());
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.growingio.android.sdk.collection.CoreAppState$5  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass5 {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public CoreAppState(GConfig gConfig, Context context) {
        this.mGlobalContext = context;
        PersistUtil.init(context);
        this.mConfig = gConfig;
        if (GConfig.isReplace) {
            Toast.makeText(this.mGlobalContext, GConfig.GROWING_VERSION, 0).show();
        }
    }

    private int queryNetworkState() {
        this.networkStateName = NetworkUtil.NETWORK_UNKNOWN;
        int i2 = 1;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mGlobalContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                try {
                    if (activeNetworkInfo.getType() == 1) {
                        i2 = 2;
                        this.networkStateName = NetworkUtil.NETWORK_WIFI;
                    } else {
                        this.networkStateName = NetworkUtil.getMobileNetworkTypeName(activeNetworkInfo.getSubtype(), activeNetworkInfo.getSubtypeName());
                    }
                    return i2;
                } catch (Exception unused) {
                    return i2;
                }
            }
        } catch (Exception unused2) {
        }
        return 0;
    }

    private void saveAppVar(JSONObject jSONObject) {
        this.mAppVariable = jSONObject;
        this.growingIOIPC.setAppVar(jSONObject);
    }

    public void clearLocation() {
        this.mLastLat = null;
        this.mLastLon = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearUserId() {
        String appUserId = this.mConfig.getAppUserId();
        if (appUserId != null) {
            lastUserId = appUserId;
        }
        this.mConfig.cleanUserId();
    }

    public void completeBgInit() {
        if (this.mBgInitComplete) {
            return;
        }
        synchronized (this.mCondition) {
            if (!this.mBgInitComplete) {
                this.mBgInitComplete = true;
                this.mCondition.notifyAll();
            }
        }
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public void do$Action(String str, Object obj) {
        if (str.equals("#onActivityLifeCycleChange(com.growingio.android.sdk.base.event.ActivityLifecycleEvent")) {
            onActivityLifeCycleChange((ActivityLifecycleEvent) obj);
        } else if (str.equals("#onNetworkChanged(com.growingio.android.sdk.base.event.net.NetWorkChangedEvent")) {
            onNetworkChanged((NetWorkChangedEvent) obj);
        } else if (str.equals("#onScreenStatusChanged(com.growingio.android.sdk.base.event.ScreenStatusEvent")) {
            onScreenStatusChanged((ScreenStatusEvent) obj);
        } else {
            System.out.println("No such method to delegate");
        }
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public SubscriberMethod[] get$SubscriberMethods() {
        ThreadMode threadMode = ThreadMode.POSTING;
        return new SubscriberMethod[]{new SubscriberMethod("onActivityLifeCycleChange", ActivityLifecycleEvent.class, "#onActivityLifeCycleChange(com.growingio.android.sdk.base.event.ActivityLifecycleEvent", threadMode, 1000, false), new SubscriberMethod("onNetworkChanged", NetWorkChangedEvent.class, "#onNetworkChanged(com.growingio.android.sdk.base.event.net.NetWorkChangedEvent", threadMode, 0, false), new SubscriberMethod("onScreenStatusChanged", ScreenStatusEvent.class, "#onScreenStatusChanged(com.growingio.android.sdk.base.event.ScreenStatusEvent", threadMode, 0, false)};
    }

    public JSONObject getAppVariable() {
        return this.growingIOIPC.getAppVar();
    }

    public JSONObject getConversionVariable() {
        SimpleJSONVariableUpdateHelper simpleJSONVariableUpdateHelper = this.mConversionVariableHelper;
        if (simpleJSONVariableUpdateHelper != null) {
            return simpleJSONVariableUpdateHelper.getVariable();
        }
        return null;
    }

    public int getCurrentRootWindowsHashCode() {
        WeakReference<Activity> weakReference;
        if (this.mCurrentRootWindowsHashCode == -1 && (weakReference = this.mForeGroundActivity) != null && weakReference.get() != null) {
            this.mCurrentRootWindowsHashCode = this.mForeGroundActivity.get().getWindow().getDecorView().hashCode();
        }
        return this.mCurrentRootWindowsHashCode;
    }

    public Activity getForegroundActivity() {
        return this.mForeGroundActivity.get();
    }

    public Context getGlobalContext() {
        return this.mGlobalContext;
    }

    public Double getLatitude() {
        return this.mLastLat;
    }

    public Double getLongitude() {
        return this.mLastLon;
    }

    public String getNetworkStateName() {
        return this.networkStateName;
    }

    public JSONObject getPageVariable() {
        SimpleJSONVariableUpdateHelper pageVariableHelper;
        if (getResumedActivity() == null || (pageVariableHelper = getPageVariableHelper(getResumedActivity())) == null) {
            return null;
        }
        return pageVariableHelper.getVariable();
    }

    public SimpleJSONVariableUpdateHelper getPageVariableHelper(Object obj) {
        SimpleJSONVariableUpdateHelper simpleJSONVariableUpdateHelper = this.mPageVariableHelpers.get(obj);
        final WeakReference weakReference = new WeakReference(obj);
        if (simpleJSONVariableUpdateHelper == null) {
            SimpleJSONVariableUpdateHelper simpleJSONVariableUpdateHelper2 = new SimpleJSONVariableUpdateHelper() { // from class: com.growingio.android.sdk.collection.CoreAppState.1
                @Override // com.growingio.android.sdk.utils.SimpleJSONVariableUpdateHelper
                public void afterUpdated() {
                    Object obj2 = weakReference.get();
                    if (obj2 != null) {
                        CoreAppState.this.msgProcessor.onPageVariableUpdated(obj2);
                    }
                }
            };
            this.mPageVariableHelpers.put(obj, simpleJSONVariableUpdateHelper2);
            return simpleJSONVariableUpdateHelper2;
        }
        return simpleJSONVariableUpdateHelper;
    }

    public JSONObject getPeopleVariable() {
        SimpleJSONVariableUpdateHelper simpleJSONVariableUpdateHelper = this.mPeopleVariableHelper;
        if (simpleJSONVariableUpdateHelper != null) {
            return simpleJSONVariableUpdateHelper.getVariable();
        }
        return null;
    }

    public String getProjectId() {
        return AbstractGrowingIO.sProjectId;
    }

    public Activity getResumedActivity() {
        return this.mResumedActivity.get();
    }

    public String getSPN() {
        return this.mSpn;
    }

    public JSONObject getVisitorVariable() {
        return this.growingIOIPC.getVisitorVar();
    }

    @VisibleForTesting
    void hideGIODialog(@NonNull Activity activity) {
        WeakSet<Dialog> weakSet;
        WeakHashMap<Activity, WeakSet<Dialog>> weakHashMap = this.mActivitiesWithGioDialogs;
        if (weakHashMap == null || (weakSet = weakHashMap.get(activity)) == null || weakSet.isEmpty()) {
            return;
        }
        Iterator<Dialog> it = weakSet.iterator();
        while (it.hasNext()) {
            Dialog next = it.next();
            if (next != null && next.isShowing()) {
                LogUtil.d(TAG, "hideGIODialog, one dialog not hide: ===> ", next);
                next.dismiss();
            }
        }
        weakSet.clear();
        this.mActivitiesWithGioDialogs.remove(activity);
    }

    public boolean isScreenOn() {
        return this.screenOn;
    }

    public int networkState() {
        if (this.mNetworkState == -1) {
            this.mNetworkState = queryNetworkState();
        }
        return this.mNetworkState;
    }

    @Subscribe(priority = 1000)
    @TargetApi(11)
    public void onActivityLifeCycleChange(ActivityLifecycleEvent activityLifecycleEvent) {
        Activity activity = activityLifecycleEvent.getActivity();
        if (activity == null) {
            Log.d(TAG, "onActivityLifeCycleChanged, but activity not found, return");
            return;
        }
        if (!this.mBgInitComplete) {
            waitUntilInitComplete();
        }
        int i2 = AnonymousClass5.$SwitchMap$com$growingio$android$sdk$base$event$ActivityLifecycleEvent$EVENT_TYPE[activityLifecycleEvent.event_type.ordinal()];
        if (i2 == 1) {
            setForegroundActivity(activity);
            if (activity.isChild()) {
                return;
            }
            this.mCurrentRootWindowsHashCode = -1;
        } else if (i2 == 3) {
            LogUtil.d(TAG, "onActivityResumed ", activity);
            setResumedActivity(activity);
            if (activity.isChild()) {
                return;
            }
            this.mCurrentRootWindowsHashCode = activity.getWindow().getDecorView().hashCode();
        } else if (i2 == 4) {
            LogUtil.d(TAG, "onActivityPaused ", activity);
            if (!activity.isChild()) {
                this.mCurrentRootWindowsHashCode = -1;
            }
            this.mResumedActivity = new WeakReference<>(null);
        } else if (i2 != 5) {
        } else {
            LogUtil.d(TAG, "onActivityDestroyed ", activity);
            this.mPageVariableHelpers.remove(activity);
            hideGIODialog(activity);
        }
    }

    public void onGIODialogShow(@NonNull Activity activity, @NonNull Dialog dialog) {
        LogUtil.d(TAG, "onGIODialogShow: dialog ----> ", dialog);
        if (this.mActivitiesWithGioDialogs == null) {
            this.mActivitiesWithGioDialogs = new WeakHashMap<>();
        }
        WeakSet<Dialog> weakSet = this.mActivitiesWithGioDialogs.get(activity);
        if (weakSet == null) {
            weakSet = new WeakSet<>();
            this.mActivitiesWithGioDialogs.put(activity, weakSet);
        }
        weakSet.add(dialog);
    }

    @Subscribe
    public synchronized void onNetworkChanged(NetWorkChangedEvent netWorkChangedEvent) {
        this.mNetworkState = -1;
    }

    @Subscribe
    public void onScreenStatusChanged(ScreenStatusEvent screenStatusEvent) {
        this.screenOn = screenStatusEvent.type != ScreenStatusEvent.ScreenStatusType.SCREEN_OFF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAppVariable(JSONObject jSONObject) {
        this.mAppVariableHelper.update(jSONObject);
        saveAppVar(this.mAppVariableHelper.getVariable());
        this.mAppVariableHelper.setVariable(new JSONObject());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConversionVariable(JSONObject jSONObject) {
        this.mConversionVariableHelper.update(jSONObject);
    }

    public void setForegroundActivity(Activity activity) {
        this.mForeGroundActivity = new WeakReference<>(activity);
    }

    public void setGrowingIOIPC(GrowingIOIPC growingIOIPC) {
        this.growingIOIPC = growingIOIPC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v3 */
    public void setLocation(double d2, double d3) {
        String str;
        ?? r15;
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(d2) < 1.0E-5d && Math.abs(d3) < 1.0E-5d) {
            LogUtil.d(TAG, "found invalid latitude and longitude, and return: ", Double.valueOf(d2), ", ", Double.valueOf(d3));
            return;
        }
        Double d4 = this.mLastLat;
        if (d4 == null || this.mLastLon == null) {
            str = TAG;
            r15 = 0;
        } else {
            double doubleValue = d4.doubleValue();
            double doubleValue2 = this.mLastLon.doubleValue();
            long j2 = this.mLastSetLocationTime;
            str = TAG;
            r15 = 0;
            if (!Util.shouldSetLocation(d2, d3, doubleValue, doubleValue2, currentTimeMillis, j2)) {
                return;
            }
        }
        this.mLastLat = Double.valueOf(d2);
        this.mLastLon = Double.valueOf(d3);
        this.mLastSetLocationTime = currentTimeMillis;
        if (getResumedActivity() != null) {
            this.msgProcessor.saveVisit(r15);
            return;
        }
        Object[] objArr = new Object[1];
        objArr[r15] = "setLocation, but resume Activity is null, next resume send visit";
        LogUtil.d(str, objArr);
        this.sessionManager.nextResumeResendVisit();
    }

    public void setMsgProcessor(MessageProcessor messageProcessor) {
        this.msgProcessor = messageProcessor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPageVariable(Object obj, JSONObject jSONObject) {
        getPageVariableHelper(obj).update(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPeopleVariable(JSONObject jSONObject) {
        this.mPeopleVariableHelper.update(jSONObject);
    }

    public void setResumedActivity(Activity activity) {
        this.mForeGroundActivity = new WeakReference<>(activity);
        this.mResumedActivity = new WeakReference<>(activity);
    }

    public void setSPN(String str) {
        this.mSpn = str;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUserId(String str) {
        if (TextUtils.isEmpty(str)) {
            clearUserId();
        } else if (str.length() > 1000) {
            Log.e(TAG, ErrorLog.USER_ID_TOO_LONG);
        } else {
            String appUserId = this.mConfig.getAppUserId();
            if (ObjectUtils.equals(str, appUserId)) {
                LogUtil.d(TAG, "setUserId, but the userId is same as the old userId, just return");
                return;
            }
            this.mConfig.setAppUserId(str);
            if (TextUtils.isEmpty(appUserId) && (TextUtils.isEmpty(lastUserId) || ObjectUtils.equals(str, lastUserId))) {
                lastUserId = str;
                EventCenter.getInstance().post(new RefreshPageEvent(true, false));
                return;
            }
            lastUserId = str;
            if (this.mConfig.isEnabled()) {
                this.sessionManager.updateSessionByUserIdChanged();
                EventCenter.getInstance().post(new RefreshPageEvent(true, false));
            }
        }
    }

    public void setVisitorVariable(JSONObject jSONObject) {
        this.growingIOIPC.setVisitorVar(jSONObject);
        if (jSONObject != null) {
            this.msgProcessor.persistEvent(new VisitorVarEvent(jSONObject, System.currentTimeMillis()));
        }
    }

    public void waitUntilInitComplete() {
        if (this.mBgInitComplete) {
            return;
        }
        synchronized (this.mCondition) {
            while (!this.mBgInitComplete) {
                try {
                    this.mCondition.wait(200L);
                } catch (InterruptedException unused) {
                }
                LogUtil.d(TAG, "one pass, but background init sdk not completed");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConversionVariable(String str, Object obj) {
        this.mConversionVariableHelper.update(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPageVariable(Object obj, String str, Object obj2) {
        getPageVariableHelper(obj).update(str, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPeopleVariable(String str, Object obj) {
        this.mPeopleVariableHelper.update(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAppVariable(String str, Object obj) {
        this.mAppVariableHelper.update(str, obj);
        saveAppVar(this.mAppVariableHelper.getVariable());
    }

    @VisibleForTesting
    public CoreAppState() {
    }
}
