package com.mob.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: classes2.dex */
public class FakeActivity {
    private static Class<? extends Activity> shellClass;
    protected Activity activity;
    private View contentView;
    private HashMap<String, Object> result;
    private FakeActivity resultReceiver;

    public static void registerExecutor(String str, Object obj) {
        Class<? extends Activity> cls = shellClass;
        if (cls != null) {
            try {
                Method method = cls.getMethod("registerExecutor", String.class, Object.class);
                method.setAccessible(true);
                method.invoke(null, str, obj);
                return;
            } catch (Throwable th) {
                MobLog.getInstance().w(th);
                return;
            }
        }
        MobUIShell.registerExecutor(str, obj);
    }

    public static void setShell(Class<? extends Activity> cls) {
        shellClass = cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showActivity(Context context, Intent intent) {
        if (!(context instanceof Activity)) {
            Activity topActivity = DeviceHelper.getInstance(context).getTopActivity();
            if (topActivity == null) {
                intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
            } else {
                context = topActivity;
            }
        }
        context.startActivity(intent);
    }

    public void beforeStartActivityForResult(Intent intent, int i2, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean disableScreenCapture() {
        Activity activity = this.activity;
        if (activity == null || Build.VERSION.SDK_INT < 11) {
            return false;
        }
        activity.getWindow().setFlags(8192, 8192);
        return true;
    }

    public <T extends View> T findViewById(int i2) {
        Activity activity = this.activity;
        if (activity == null) {
            return null;
        }
        return (T) activity.findViewById(i2);
    }

    public <T extends View> T findViewByResName(View view, String str) {
        int idRes;
        Activity activity = this.activity;
        if (activity != null && (idRes = ResHelper.getIdRes(activity, str)) > 0) {
            return (T) view.findViewById(idRes);
        }
        return null;
    }

    public final void finish() {
        Activity activity = this.activity;
        if (activity != null) {
            activity.finish();
        }
    }

    public View getContentView() {
        return this.contentView;
    }

    public Context getContext() {
        return this.activity;
    }

    public int getOrientation() {
        return this.activity.getResources().getConfiguration().orientation;
    }

    public FakeActivity getParent() {
        return this.resultReceiver;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onCreate() {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void onDestroy() {
    }

    public boolean onFinish() {
        return false;
    }

    public boolean onKeyEvent(int i2, KeyEvent keyEvent) {
        return false;
    }

    @Instrumented
    public void onNewIntent(Intent intent) {
        VdsAgent.onNewIntent(this, intent);
    }

    @Instrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        VdsAgent.onOptionsItemSelected(this, menuItem);
        VdsAgent.handleClickResult(new Boolean(false));
        return false;
    }

    public void onPause() {
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
    }

    public void onRestart() {
    }

    public void onResult(HashMap<String, Object> hashMap) {
    }

    public void onResume() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int onSetTheme(int i2, boolean z) {
        return i2;
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void requestFullScreen(boolean z) {
        Activity activity = this.activity;
        if (activity == null) {
            return;
        }
        if (z) {
            activity.getWindow().addFlags(1024);
            this.activity.getWindow().clearFlags(2048);
        } else {
            activity.getWindow().addFlags(2048);
            this.activity.getWindow().clearFlags(1024);
        }
        this.activity.getWindow().getDecorView().requestLayout();
    }

    public void requestLandscapeOrientation() {
        setRequestedOrientation(0);
    }

    public void requestPermissions(String[] strArr, int i2) {
        Activity activity = this.activity;
        if (activity != null && Build.VERSION.SDK_INT >= 23) {
            try {
                ReflectHelper.invokeInstanceMethod(activity, "requestPermissions", new Object[]{strArr, Integer.valueOf(i2)}, new Class[]{String.class, Integer.TYPE});
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
            }
        }
    }

    public void requestPortraitOrientation() {
        setRequestedOrientation(1);
    }

    public void requestSensorLandscapeOrientation() {
        setRequestedOrientation(6);
    }

    public void requestSensorPortraitOrientation() {
        setRequestedOrientation(7);
    }

    public void runOnUIThread(final Runnable runnable) {
        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.tools.FakeActivity.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                runnable.run();
                return false;
            }
        });
    }

    public void sendResult() {
        FakeActivity fakeActivity = this.resultReceiver;
        if (fakeActivity != null) {
            fakeActivity.onResult(this.result);
        }
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setContentView(View view) {
        this.contentView = view;
    }

    public void setContentViewLayoutResName(String str) {
        int layoutRes;
        Activity activity = this.activity;
        if (activity != null && (layoutRes = ResHelper.getLayoutRes(activity, str)) > 0) {
            this.activity.setContentView(layoutRes);
        }
    }

    public void setRequestedOrientation(int i2) {
        if (this.activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 26 || getContext().getApplicationInfo().targetSdkVersion < 27) {
            this.activity.setRequestedOrientation(i2);
        }
    }

    public final void setResult(HashMap<String, Object> hashMap) {
        this.result = hashMap;
    }

    public void show(Context context, Intent intent) {
        showForResult(context, intent, null);
    }

    public void showForResult(final Context context, Intent intent, FakeActivity fakeActivity) {
        final Intent intent2;
        this.resultReceiver = fakeActivity;
        String str = null;
        if (shellClass != null) {
            intent2 = new Intent(context, shellClass);
            try {
                Method method = shellClass.getMethod("registerExecutor", Object.class);
                method.setAccessible(true);
                str = (String) method.invoke(null, this);
            } catch (Throwable th) {
                MobLog.getInstance().w(th);
            }
        } else {
            intent2 = new Intent(context, MobUIShell.class);
            str = MobUIShell.registerExecutor(this);
        }
        intent2.putExtra("launch_time", str);
        intent2.putExtra("executor_name", getClass().getName());
        if (intent != null) {
            intent2.putExtras(intent);
        }
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            showActivity(context, intent2);
        } else {
            UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.tools.FakeActivity.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    FakeActivity.this.showActivity(context, intent2);
                    return false;
                }
            });
        }
    }

    public void startActivity(Intent intent) {
        startActivityForResult(intent, -1);
    }

    public void startActivityForResult(Intent intent, int i2) {
        Activity activity = this.activity;
        if (activity == null) {
            return;
        }
        activity.startActivityForResult(intent, i2);
    }

    public void runOnUIThread(final Runnable runnable, long j2) {
        UIHandler.sendEmptyMessageDelayed(0, j2, new Handler.Callback() { // from class: com.mob.tools.FakeActivity.3
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                runnable.run();
                return false;
            }
        });
    }

    public <T extends View> T findViewByResName(String str) {
        int idRes;
        Activity activity = this.activity;
        if (activity != null && (idRes = ResHelper.getIdRes(activity, str)) > 0) {
            return (T) findViewById(idRes);
        }
        return null;
    }
}
