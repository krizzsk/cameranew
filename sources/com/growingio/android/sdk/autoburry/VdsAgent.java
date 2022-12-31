package com.growingio.android.sdk.autoburry;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TimePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ActionMenuView;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.growingio.android.sdk.base.event.ActivityLifecycleEvent;
import com.growingio.android.sdk.base.event.NewIntentEvent;
import com.growingio.android.sdk.base.event.ViewTreeStatusChangeEvent;
import com.growingio.android.sdk.base.event.message.MessageEvent;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.models.ActionEvent;
import com.growingio.android.sdk.models.ViewNode;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.ClickEventAsyncExecutor;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.ReflectUtil;
import com.growingio.android.sdk.utils.SysTrace;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.android.sdk.utils.WindowHelper;
import com.growingio.eventcenter.EventCenter;
import com.growingio.eventcenter.bus.EventBus;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URLConnection;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes2.dex */
public class VdsAgent {
    static final String TAG = "GIO.VdsAgent";
    private static ThreadLocal<Boolean> sWebViewProcessChanging = new ThreadLocal<>();
    private static ThreadLocal<Boolean> sNotHandleClickResult = new ThreadLocal<>();
    private static PersistClickEventRunnable persistClickEventRunnable = new PersistClickEventRunnable();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class PersistClickEventRunnable implements Runnable {
        private ActionEvent actionEvent;
        private ViewNode viewNode;

        private PersistClickEventRunnable() {
        }

        public boolean havePendingEvent() {
            return this.viewNode != null;
        }

        public void resetData(ViewNode viewNode) {
            this.viewNode = viewNode;
            if (viewNode != null) {
                this.actionEvent = ViewHelper.getClickActionEvent(viewNode);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ViewHelper.persistClickEvent(this.actionEvent, this.viewNode);
            } catch (Throwable th) {
                LogUtil.d(th);
            }
            this.viewNode = null;
        }
    }

    public static void clickOn(View view) {
        if (GConfig.sCanHook) {
            try {
                SysTrace.beginSection("gio.Click");
            } finally {
                try {
                } finally {
                }
            }
            if (persistClickEventRunnable.havePendingEvent()) {
                return;
            }
            ViewNode clickViewNode = ViewHelper.getClickViewNode(view);
            if (clickViewNode == null) {
                return;
            }
            if (CoreInitialize.config().isImageViewCollectionEnable() && TextUtils.isEmpty(clickViewNode.mViewContent) && (view instanceof ImageView)) {
                ClickEventAsyncExecutor.getInstance().execute(new WeakReference<>(view), clickViewNode, ViewHelper.getClickActionEvent(clickViewNode).m20clone());
            } else {
                persistClickEventRunnable.resetData(clickViewNode);
                handleClickResult(Boolean.TRUE);
            }
        }
    }

    private static boolean handleBooleanResult(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static void handleClickResult(Object obj) {
        if (handleBooleanResult(obj) && persistClickEventRunnable.havePendingEvent()) {
            ThreadUtils.cancelTaskOnUiThread(persistClickEventRunnable);
            ThreadUtils.postOnUiThread(persistClickEventRunnable);
            return;
        }
        persistClickEventRunnable.resetData(null);
    }

    private static void hookWebViewLoad(View view) {
        Class<?> cls = view.getClass();
        if (!GConfig.sCanHook || isTaoBao(cls)) {
            return;
        }
        VdsJsBridgeManager.hookWebViewIfNeeded(view);
        LogUtil.d(TAG, "trackWebView: ", view, " with client ", null);
    }

    public static boolean isRightClass(String str, String str2, String str3, String str4) {
        Method method = ReflectUtil.getMethod(str, str2, str3);
        if (method == null) {
            return false;
        }
        return method.getDeclaringClass().getName().equals(str4.replace('/', '.'));
    }

    private static boolean isTaoBao(Class cls) {
        while (!cls.getName().equals("android.webkit.WebView") && !cls.getName().equals("java.lang.Object")) {
            if (cls.getName().equals("android.taobao.windvane.webview.WVWebView")) {
                return true;
            }
            cls = cls.getSuperclass();
        }
        return false;
    }

    private static boolean isX5WebView(Object obj) {
        for (Class<?> cls = obj.getClass(); !cls.getName().equals("java.lang.Object"); cls = cls.getSuperclass()) {
            if (cls.getName().equals("com.tencent.smtt.sdk.WebView")) {
                return true;
            }
        }
        return false;
    }

    public static void lambdaOnCheckedChangeRadioGroup(RadioGroup radioGroup, int i2) {
        clickOn(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
    }

    public static void lambdaOnCheckedChangedCompoundButton(CompoundButton compoundButton, boolean z) {
        clickOn(compoundButton);
    }

    public static void lambdaOnChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
        try {
            if (GConfig.sCanHook && !persistClickEventRunnable.havePendingEvent()) {
                persistClickEventRunnable.resetData(ViewHelper.getClickViewNode(view));
                if (threadLocalResult(sNotHandleClickResult)) {
                    return;
                }
                handleClickResult(Boolean.TRUE);
            }
        } catch (Throwable th) {
            LogUtil.e(TAG, th.getMessage(), th);
        }
    }

    public static void lambdaOnClick(View view) {
        clickOn(view);
    }

    public static void lambdaOnDialogClick(DialogInterface dialogInterface, int i2) {
        clickOn(dialogInterface, i2);
    }

    public static void lambdaOnGroupClick(ExpandableListView expandableListView, View view, int i2, long j2) {
        try {
            if (GConfig.sCanHook && !persistClickEventRunnable.havePendingEvent()) {
                persistClickEventRunnable.resetData(ViewHelper.getClickViewNode(view));
                if (threadLocalResult(sNotHandleClickResult)) {
                    return;
                }
                handleClickResult(Boolean.TRUE);
            }
        } catch (Throwable th) {
            LogUtil.e(TAG, th.getMessage(), th);
        }
    }

    public static void lambdaOnItemClick(AdapterView adapterView, View view, int i2, long j2) {
        clickOn(adapterView, view, i2, j2);
    }

    public static void lambdaOnMenuItemClick(MenuItem menuItem) {
        try {
            if (GConfig.sCanHook && !persistClickEventRunnable.havePendingEvent()) {
                persistClickEventRunnable.resetData(ViewHelper.getClickViewNode(menuItem));
                if (threadLocalResult(sNotHandleClickResult)) {
                    return;
                }
                handleClickResult(Boolean.TRUE);
            }
        } catch (Throwable th) {
            LogUtil.e(TAG, th.getMessage(), th);
        }
    }

    public static void lambdaOnRatingChanged(RatingBar ratingBar, float f2, boolean z) {
        if (z) {
            clickOn(ratingBar);
        }
    }

    public static void loadData(View view, String str, String str2, String str3) {
        LogUtil.d(TAG, String.format("loadData: data=%s", str));
        hookWebViewLoad(view);
    }

    public static void loadDataWithBaseURL(View view, String str, String str2, String str3, String str4, String str5) {
        LogUtil.d(TAG, String.format(Locale.CHINA, "loadDataWithBaseURL: baseURL=%s, data=%s", str, str2));
        hookWebViewLoad(view);
    }

    public static void loadUrl(View view, String str) {
        loadUrl(view, str, null);
    }

    public static void onBroadcastReceiver(BroadcastReceiver broadcastReceiver, Context context, Intent intent) {
        onBroadcastServiceIntent(intent);
    }

    private static void onBroadcastServiceIntent(Intent intent) {
        if (GConfig.sCanHook) {
            LogUtil.d(TAG, "onBroadcastServiceIntent");
            EventCenter.getInstance().post(new NewIntentEvent(intent));
        }
    }

    public static void onCheckedChanged(Object obj, RadioGroup radioGroup, int i2) {
        try {
            if (obj instanceof RadioGroup.OnCheckedChangeListener) {
                clickOn(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
            }
        } catch (Throwable th) {
            LogUtil.d(th);
        }
    }

    public static boolean onChildClick(Object obj, ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
        if (obj instanceof ExpandableListView.OnChildClickListener) {
            sNotHandleClickResult.set(Boolean.TRUE);
            lambdaOnChildClick(expandableListView, view, i2, i3, j2);
            sNotHandleClickResult.set(Boolean.FALSE);
            return false;
        }
        return false;
    }

    public static void onClick(Object obj, View view) {
        try {
            if (obj instanceof View.OnClickListener) {
                clickOn(view);
            }
        } catch (Throwable th) {
            LogUtil.d(th);
        }
    }

    public static void onFocusChange(Object obj, View view, boolean z) {
        if ((obj instanceof View.OnFocusChangeListener) && (view instanceof TextView)) {
            LogUtil.d(TAG, "onFocusChanged");
            ViewHelper.changeOn(view);
        }
    }

    public static void onFragmentAttach(Object obj, Object obj2, Object obj3) {
        if (GConfig.sCanHook) {
            AutoBuryObservableInitialize.autoBuryAppState().trackFragmentWithFilter(obj2);
        }
    }

    public static void onFragmentHiddenChanged(Object obj, boolean z) {
        if (GConfig.sCanHook) {
            if (!z) {
                AutoBuryObservableInitialize.autoBuryAppState().trackFragmentWithFilter(obj);
            }
            EventCenter.getInstance().post(new ViewTreeStatusChangeEvent(ViewTreeStatusChangeEvent.StatusType.ScrollChanged));
        }
    }

    public static void onFragmentPause(Object obj) {
    }

    public static void onFragmentResume(Object obj) {
        if (GConfig.sCanHook) {
            AutoBuryObservableInitialize.autoBuryAppState().trackFragmentWithFilter(obj);
        }
    }

    public static void onFragmentShow(Object obj, Object obj2, Object obj3) {
        if (GConfig.sCanHook) {
            AutoBuryObservableInitialize.autoBuryAppState().trackFragmentWithFilter(obj2);
        }
    }

    public static void onFragmentTransactionAdd(Object obj, int i2, Object obj2, Object obj3) {
        onFragmentTransactionAdd(obj, i2, obj2, null, obj3);
    }

    public static void onFragmentTransactionReplace(Object obj, int i2, Object obj2, String str, Object obj3) {
        if (GConfig.sCanHook) {
            AutoBuryObservableInitialize.autoBuryAppState().trackFragmentWithFilter(obj2);
        }
    }

    public static boolean onGroupClick(Object obj, ExpandableListView expandableListView, View view, int i2, long j2) {
        if (obj instanceof ExpandableListView.OnGroupClickListener) {
            sNotHandleClickResult.set(Boolean.TRUE);
            lambdaOnGroupClick(expandableListView, view, i2, j2);
            sNotHandleClickResult.set(Boolean.FALSE);
            return false;
        }
        return false;
    }

    public static void onItemClick(Object obj, AdapterView adapterView, View view, int i2, long j2) {
        try {
            if ((obj instanceof AdapterView.OnItemClickListener) || (obj instanceof AdapterView.OnItemSelectedListener)) {
                clickOn(adapterView, view, i2, j2);
            }
        } catch (Throwable th) {
            LogUtil.d(th);
        }
    }

    public static void onItemSelected(Object obj, AdapterView adapterView, View view, int i2, long j2) {
        if (adapterView == null || !(adapterView instanceof Spinner)) {
            return;
        }
        onItemClick(obj, adapterView, view, i2, j2);
    }

    public static void onLocationChanged(Object obj, Location location) {
        try {
            if (GConfig.sCanHook && (obj instanceof LocationListener)) {
                AbstractGrowingIO.getInstance().setGeoLocation(location.getLatitude(), location.getLongitude());
            }
        } catch (Throwable th) {
            LogUtil.d(th);
        }
    }

    public static boolean onMenuItemClick(Object obj, MenuItem menuItem) {
        if ((Build.VERSION.SDK_INT >= 21 && ((obj instanceof Toolbar.OnMenuItemClickListener) || (obj instanceof ActionMenuView.OnMenuItemClickListener))) || (obj instanceof MenuItem.OnMenuItemClickListener) || (obj instanceof PopupMenu.OnMenuItemClickListener)) {
            sNotHandleClickResult.set(Boolean.TRUE);
            lambdaOnMenuItemClick(menuItem);
            sNotHandleClickResult.set(Boolean.FALSE);
        }
        return false;
    }

    public static void onNewIntent(Object obj, Intent intent) {
        if (GConfig.sCanHook && (obj instanceof Activity)) {
            EventCenter.getInstance().post(ActivityLifecycleEvent.createOnNewIntentEvent((Activity) obj, intent));
        }
    }

    public static void onNotify(NotificationManager notificationManager, String str, int i2, Notification notification) {
        if (GConfig.sCanHook && CoreInitialize.config().isEnabled()) {
            AutoBuryObservableInitialize.notificationProcessor().onNotify(str, i2, notification);
        }
    }

    public static boolean onOptionsItemSelected(Object obj, MenuItem menuItem) {
        if (GConfig.sCanHook && !persistClickEventRunnable.havePendingEvent()) {
            ViewNode viewNode = null;
            if ((obj instanceof Activity) && !ClassExistHelper.instanceOfAndroidXFragmentActivity(obj) && !ClassExistHelper.instanceOfSupportFragmentActivity(obj)) {
                viewNode = ViewHelper.getClickViewNode(menuItem);
            }
            persistClickEventRunnable.resetData(viewNode);
        }
        return false;
    }

    private static void onPendingIntentCreateAfter(Intent intent, PendingIntent pendingIntent) {
        if (GConfig.sCanHook && CoreInitialize.config().isEnabled()) {
            AutoBuryObservableInitialize.notificationProcessor().hookPendingIntentCreateAfter(intent, pendingIntent);
        }
    }

    private static void onPendingIntentCreateBefore(Intent intent) {
        if (GConfig.sCanHook && CoreInitialize.config().isEnabled()) {
            AutoBuryObservableInitialize.notificationProcessor().hookPendingIntentCreateBefore(intent);
        }
    }

    public static void onPendingIntentGetActivityAfter(Context context, int i2, Intent intent, int i3, Bundle bundle, PendingIntent pendingIntent) {
        onPendingIntentCreateAfter(intent, pendingIntent);
    }

    public static void onPendingIntentGetActivityBefore(Context context, int i2, Intent intent, int i3, Bundle bundle) {
        onPendingIntentCreateBefore(intent);
    }

    public static void onPendingIntentGetActivityShortAfter(Context context, int i2, Intent intent, int i3, PendingIntent pendingIntent) {
        onPendingIntentCreateAfter(intent, pendingIntent);
    }

    public static void onPendingIntentGetActivityShortBefore(Context context, int i2, Intent intent, int i3) {
        onPendingIntentCreateBefore(intent);
    }

    public static void onPendingIntentGetBroadcastAfter(Context context, int i2, Intent intent, int i3, PendingIntent pendingIntent) {
        onPendingIntentCreateAfter(intent, pendingIntent);
    }

    public static void onPendingIntentGetBroadcastBefore(Context context, int i2, Intent intent, int i3) {
        onPendingIntentCreateBefore(intent);
    }

    public static void onPendingIntentGetForegroundServiceAfter(Context context, int i2, Intent intent, int i3, PendingIntent pendingIntent) {
        onPendingIntentCreateAfter(intent, pendingIntent);
    }

    public static void onPendingIntentGetForegroundServiceBefore(Context context, int i2, Intent intent, int i3) {
        onPendingIntentCreateBefore(intent);
    }

    public static void onPendingIntentGetServiceAfter(Context context, int i2, Intent intent, int i3, PendingIntent pendingIntent) {
        onPendingIntentCreateAfter(intent, pendingIntent);
    }

    public static void onPendingIntentGetServiceBefore(Context context, int i2, Intent intent, int i3) {
        onPendingIntentCreateBefore(intent);
    }

    public static void onProgressChangedEnd(View view, int i2) {
        sWebViewProcessChanging.set(Boolean.FALSE);
    }

    public static void onProgressChangedStart(View view, int i2) {
        if (GConfig.sCanHook) {
            if (sWebViewProcessChanging.get() == null || !sWebViewProcessChanging.get().booleanValue()) {
                sWebViewProcessChanging.set(Boolean.TRUE);
                VdsJsHelper vdsJsHelper = (VdsJsHelper) view.getTag(AbstractGrowingIO.GROWING_WEB_BRIDGE_KEY);
                if (vdsJsHelper == null) {
                    return;
                }
                SysTrace.beginSection("gio.onProgressChanged");
                vdsJsHelper.onVdsAgentProgressChanged(view, i2);
                SysTrace.endSection();
            }
        }
    }

    public static void onRatingChanged(Object obj, RatingBar ratingBar, float f2, boolean z) {
        if (z) {
            try {
                clickOn(ratingBar);
            } catch (Throwable th) {
                LogUtil.d(th);
            }
        }
    }

    public static void onReceiveLocation(Object obj, BDLocation bDLocation) {
        try {
            if (GConfig.sCanHook && (obj instanceof BDLocationListener)) {
                int locType = bDLocation.getLocType();
                if (locType == 61 || locType == 161 || locType == 66) {
                    AbstractGrowingIO.getInstance().setGeoLocation(bDLocation.getLatitude(), bDLocation.getLongitude());
                }
            }
        } catch (Throwable th) {
            LogUtil.d(th);
        }
    }

    public static void onServiceStart(Service service, Intent intent, int i2) {
        onBroadcastServiceIntent(intent);
    }

    public static void onServiceStartCommand(Service service, Intent intent, int i2, int i3) {
        onBroadcastServiceIntent(intent);
    }

    public static void onSetViewVisibility(View view, int i2) {
        if (i2 == 8 || !GConfig.sCanHook) {
            return;
        }
        EventCenter.getInstance().post(new ViewTreeStatusChangeEvent(ViewTreeStatusChangeEvent.StatusType.LayoutChanged));
    }

    public static void onStopTrackingTouch(Object obj, SeekBar seekBar) {
        try {
            clickOn(seekBar);
        } catch (Throwable th) {
            LogUtil.d(th);
        }
    }

    public static void onXiaoMiMessageArrived(PushMessageReceiver pushMessageReceiver, Context context, MiPushMessage miPushMessage) {
        if (GConfig.sCanHook && CoreInitialize.config().isEnabled()) {
            AutoBuryObservableInitialize.notificationProcessor().onXiaoMiMessageArrived(miPushMessage);
        }
    }

    public static void onXiaoMiMessageClick(PushMessageReceiver pushMessageReceiver, Context context, MiPushMessage miPushMessage) {
        if (GConfig.sCanHook && CoreInitialize.config().isEnabled()) {
            AutoBuryObservableInitialize.notificationProcessor().onXiaoMiMessageClicked(miPushMessage);
        }
    }

    public static URLConnection openConnection(URLConnection uRLConnection) throws IOException {
        LogUtil.d(TAG, "openConnection: ", uRLConnection);
        return uRLConnection;
    }

    public static void setFragmentUserVisibleHint(Object obj, boolean z) {
        if (GConfig.sCanHook) {
            if (z) {
                AutoBuryObservableInitialize.autoBuryAppState().trackFragmentWithFilter(obj);
            }
            EventCenter.getInstance().post(new ViewTreeStatusChangeEvent(ViewTreeStatusChangeEvent.StatusType.ScrollChanged));
        }
    }

    public static void setWebChromeClient(WebView webView, WebChromeClient webChromeClient) {
        if (webChromeClient != null && webChromeClient.getClass() != WebChromeClient.class) {
            webView.setTag(AbstractGrowingIO.GROWING_WEB_CLIENT_KEY, Boolean.TRUE);
        } else {
            webView.setTag(AbstractGrowingIO.GROWING_WEB_CLIENT_KEY, null);
        }
    }

    public static void showAlertDialogBuilder(AlertDialog.Builder builder, AlertDialog alertDialog) {
        trySaveNewWindow();
    }

    public static void showAsDropDown(PopupWindow popupWindow, View view) {
        trySaveNewWindow();
    }

    public static void showAtLocation(PopupWindow popupWindow, View view, int i2, int i3, int i4) {
        trySaveNewWindow();
    }

    public static void showDialog(Dialog dialog) {
        trySaveNewWindow();
    }

    public static void showDialogFragment(Object obj, Object obj2, String str) {
        trySaveNewWindow();
    }

    @TargetApi(11)
    public static void showPopupMenu(PopupMenu popupMenu) {
        trySaveNewWindow();
    }

    public static void showToast(Toast toast) {
        WindowHelper.onToastShow(toast);
        trySaveNewWindow();
    }

    private static boolean threadLocalResult(ThreadLocal<Boolean> threadLocal) {
        return threadLocal.get() != null && threadLocal.get().booleanValue();
    }

    private static void trySaveNewWindow() {
        if (GConfig.sCanHook && CoreInitialize.config().isEnabled()) {
            EventBus.getDefault().post(new MessageEvent(MessageEvent.MessageType.IMP));
        }
    }

    public static void loadUrl(View view, String str, Map<String, String> map) {
        LogUtil.i(TAG, "loadUrl: " + str);
        hookWebViewLoad(view);
    }

    public static void onFragmentTransactionAdd(Object obj, int i2, Object obj2, String str, Object obj3) {
        if (GConfig.sCanHook) {
            AutoBuryObservableInitialize.autoBuryAppState().trackFragmentWithFilter(obj2);
        }
    }

    public static void showAsDropDown(PopupWindow popupWindow, View view, int i2, int i3) {
        trySaveNewWindow();
    }

    public static void showDialog(TimePickerDialog timePickerDialog) {
        showDialog((Dialog) timePickerDialog);
    }

    public static void showDialogFragment(Object obj, Object obj2, String str, int i2) {
        trySaveNewWindow();
    }

    public static void onFragmentTransactionReplace(Object obj, int i2, Object obj2, Object obj3) {
        onFragmentTransactionReplace(obj, i2, obj2, null, obj3);
    }

    public static void onNotify(NotificationManager notificationManager, int i2, Notification notification) {
        onNotify(notificationManager, null, i2, notification);
    }

    @TargetApi(19)
    public static void showAsDropDown(PopupWindow popupWindow, View view, int i2, int i3, int i4) {
        trySaveNewWindow();
    }

    public static void onClick(Object obj, DialogInterface dialogInterface, int i2) {
        try {
            if (obj instanceof DialogInterface.OnClickListener) {
                clickOn(dialogInterface, i2);
            }
        } catch (Throwable th) {
            LogUtil.d(th);
        }
    }

    public static void onFragmentTransactionAdd(Object obj, Object obj2, String str, Object obj3) {
        onFragmentTransactionAdd(obj, 0, obj2, str, obj3);
    }

    public static void onLocationChanged(Object obj, AMapLocation aMapLocation) {
        try {
            if (aMapLocation.getErrorCode() == 0 && GConfig.sCanHook && (obj instanceof AMapLocationListener)) {
                AbstractGrowingIO.getInstance().setGeoLocation(aMapLocation.getLatitude(), aMapLocation.getLongitude());
            }
        } catch (Throwable th) {
            LogUtil.d(th);
        }
    }

    public static void setWebChromeClient(com.tencent.smtt.sdk.WebView webView, com.tencent.smtt.sdk.WebChromeClient webChromeClient) {
        if (webChromeClient != null && webChromeClient.getClass() != com.tencent.smtt.sdk.WebChromeClient.class) {
            webView.setTag((int) AbstractGrowingIO.GROWING_WEB_CLIENT_KEY, Boolean.TRUE);
        } else {
            webView.setTag((int) AbstractGrowingIO.GROWING_WEB_CLIENT_KEY, (Object) null);
        }
    }

    public static void onCheckedChanged(Object obj, CompoundButton compoundButton, boolean z) {
        try {
            if (obj instanceof CompoundButton.OnCheckedChangeListener) {
                clickOn(compoundButton);
            }
        } catch (Throwable th) {
            LogUtil.d(th);
        }
    }

    public static void onLocationChanged(Object obj, TencentLocation tencentLocation, int i2, String str) {
        if (i2 == 0) {
            try {
                if (GConfig.sCanHook && (obj instanceof TencentLocationListener)) {
                    AbstractGrowingIO.getInstance().setGeoLocation(tencentLocation.getLatitude(), tencentLocation.getLongitude());
                }
            } catch (Throwable th) {
                LogUtil.d(th);
            }
        }
    }

    public static void clickOn(DialogInterface dialogInterface, int i2) {
        try {
            if (dialogInterface instanceof AlertDialog) {
                clickOn(((AlertDialog) dialogInterface).getButton(i2));
            }
        } catch (Exception e2) {
            LogUtil.d(e2);
        }
    }

    public static void clickOn(AdapterView adapterView, View view, int i2, long j2) {
        if (adapterView instanceof Spinner) {
            clickOn(adapterView);
        } else {
            clickOn(view);
        }
    }
}
