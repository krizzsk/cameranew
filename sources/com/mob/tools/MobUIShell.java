package com.mob.tools;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes2.dex */
public class MobUIShell extends Activity {
    private static HashMap<String, FakeActivity> executors = new HashMap<>();
    private FakeActivity executor;

    static {
        MobLog.getInstance().d("===============================", new Object[0]);
        String replace = "2021-12-30".replace("-0", PGTransHeader.CONNECTOR).replace(PGTransHeader.CONNECTOR, ".");
        MobLog.getInstance().d("MobTools " + replace, new Object[0]);
        MobLog.getInstance().d("===============================", new Object[0]);
    }

    private FakeActivity activityForName(String str) {
        Object newInstance;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith(".")) {
                str = getPackageName() + str;
            }
            String importClass = ReflectHelper.importClass(str);
            if (TextUtils.isEmpty(importClass) || (newInstance = ReflectHelper.newInstance(importClass, new Object[0])) == null || !(newInstance instanceof FakeActivity)) {
                return null;
            }
            return (FakeActivity) newInstance;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    private boolean fixOrientation() {
        if (Build.VERSION.SDK_INT > 27) {
            return false;
        }
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e2) {
            MobLog.getInstance().w(e2, "Fix orientation for 8.0 encountered exception", new Object[0]);
            return false;
        }
    }

    private boolean initExecutor() {
        if (this.executor == null) {
            Intent intent = getIntent();
            Uri data = intent.getData();
            if (data != null && "mobui".equals(data.getScheme())) {
                FakeActivity activityForName = activityForName(data.getHost());
                this.executor = activityForName;
                if (activityForName != null) {
                    NLog mobLog = MobLog.getInstance();
                    mobLog.i("MobUIShell found executor: " + this.executor.getClass(), new Object[0]);
                    this.executor.setActivity(this);
                    return true;
                }
            }
            try {
                String stringExtra = intent.getStringExtra("launch_time");
                String stringExtra2 = intent.getStringExtra("executor_name");
                FakeActivity remove = executors.remove(stringExtra);
                this.executor = remove;
                if (remove == null) {
                    FakeActivity remove2 = executors.remove(intent.getScheme());
                    this.executor = remove2;
                    if (remove2 == null) {
                        FakeActivity fakeActivity = getDefault();
                        this.executor = fakeActivity;
                        if (fakeActivity == null) {
                            NLog mobLog2 = MobLog.getInstance();
                            mobLog2.w(new RuntimeException("Executor lost! launchTime = " + stringExtra + ", executorName: " + stringExtra2));
                            return false;
                        }
                    }
                }
                NLog mobLog3 = MobLog.getInstance();
                mobLog3.i("MobUIShell found executor: " + this.executor.getClass(), new Object[0]);
                this.executor.setActivity(this);
            } catch (Throwable th) {
                MobLog.getInstance().w(th);
                return false;
            }
        }
        return true;
    }

    private boolean isTranslucentOrFloating() {
        Exception e2;
        boolean z;
        Method method;
        if (Build.VERSION.SDK_INT > 27) {
            return false;
        }
        try {
            TypedArray obtainStyledAttributes = this.executor.activity.obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            z = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
        } catch (Exception e3) {
            e2 = e3;
            z = false;
        }
        try {
            method.setAccessible(false);
        } catch (Exception e4) {
            e2 = e4;
            MobLog.getInstance().w(e2);
            return z;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String registerExecutor(Object obj) {
        return registerExecutor(String.valueOf(System.currentTimeMillis()), obj);
    }

    public static Uri toMobUIShellUri(String str, HashMap<String, Object> hashMap) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : hashMap.keySet()) {
            arrayList.add(new KVPair(str2, String.valueOf(hashMap.get(str2))));
        }
        return Uri.parse("mobui://" + str + "?" + ResHelper.encodeUrl(arrayList));
    }

    @Override // android.app.Activity
    public void finish() {
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity == null || !fakeActivity.onFinish()) {
            super.finish();
        }
    }

    public FakeActivity getDefault() {
        String str;
        try {
            str = getPackageManager().getActivityInfo(getComponentName(), 128).metaData.getString("defaultActivity");
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            str = null;
        }
        return activityForName(str);
    }

    public Object getExecutor() {
        return this.executor;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity != null) {
            fakeActivity.onActivityResult(i2, i3, intent);
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity != null) {
            fakeActivity.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (initExecutor()) {
            NLog mobLog = MobLog.getInstance();
            mobLog.d(this.executor.getClass().getSimpleName() + " onCreate", new Object[0]);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 == 26 && isTranslucentOrFloating()) {
                fixOrientation();
            }
            if (i2 >= 21) {
                this.executor.activity.getWindow().addFlags(Integer.MIN_VALUE);
                this.executor.activity.getWindow().setStatusBarColor(0);
            }
            super.onCreate(bundle);
            this.executor.onCreate();
            return;
        }
        super.onCreate(bundle);
        finish();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        FakeActivity fakeActivity = this.executor;
        return fakeActivity != null ? fakeActivity.onCreateOptionsMenu(menu) : onCreateOptionsMenu;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity != null) {
            fakeActivity.sendResult();
            NLog mobLog = MobLog.getInstance();
            mobLog.d(this.executor.getClass().getSimpleName() + " onDestroy", new Object[0]);
            this.executor.onDestroy();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        try {
            FakeActivity fakeActivity = this.executor;
            if (fakeActivity != null ? fakeActivity.onKeyEvent(i2, keyEvent) : false) {
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return false;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        try {
            FakeActivity fakeActivity = this.executor;
            if (fakeActivity != null ? fakeActivity.onKeyEvent(i2, keyEvent) : false) {
                return true;
            }
            return super.onKeyUp(i2, keyEvent);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return false;
        }
    }

    @Override // android.app.Activity
    @Instrumented
    protected void onNewIntent(Intent intent) {
        VdsAgent.onNewIntent(this, intent);
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity == null) {
            super.onNewIntent(intent);
        } else {
            fakeActivity.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    @Instrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        VdsAgent.onOptionsItemSelected(this, menuItem);
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity != null) {
            boolean onOptionsItemSelected2 = fakeActivity.onOptionsItemSelected(menuItem);
            VdsAgent.handleClickResult(new Boolean(onOptionsItemSelected2));
            return onOptionsItemSelected2;
        }
        VdsAgent.handleClickResult(new Boolean(onOptionsItemSelected));
        return onOptionsItemSelected;
    }

    @Override // android.app.Activity
    protected void onPause() {
        if (this.executor != null) {
            NLog mobLog = MobLog.getInstance();
            mobLog.d(this.executor.getClass().getSimpleName() + " onPause", new Object[0]);
            this.executor.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity != null) {
            fakeActivity.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        if (this.executor != null) {
            NLog mobLog = MobLog.getInstance();
            mobLog.d(this.executor.getClass().getSimpleName() + " onRestart", new Object[0]);
            this.executor.onRestart();
        }
        super.onRestart();
    }

    @Override // android.app.Activity
    protected void onResume() {
        if (this.executor != null) {
            NLog mobLog = MobLog.getInstance();
            mobLog.d(this.executor.getClass().getSimpleName() + " onResume", new Object[0]);
            this.executor.onResume();
        }
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStart() {
        if (this.executor != null) {
            NLog mobLog = MobLog.getInstance();
            mobLog.d(this.executor.getClass().getSimpleName() + " onStart", new Object[0]);
            this.executor.onStart();
        }
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onStop() {
        if (this.executor != null) {
            NLog mobLog = MobLog.getInstance();
            mobLog.d(this.executor.getClass().getSimpleName() + " onStop", new Object[0]);
            this.executor.onStop();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        setContentView(LayoutInflater.from(this).inflate(i2, (ViewGroup) null));
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        if (Build.VERSION.SDK_INT == 26 && isTranslucentOrFloating()) {
            return;
        }
        super.setRequestedOrientation(i2);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i2) {
        if (initExecutor()) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int i3 = 0;
            while (i3 < stackTrace.length) {
                if (stackTrace[i3].toString().startsWith("java.lang.Thread.getStackTrace") && (i3 = i3 + 2) < stackTrace.length) {
                    int onSetTheme = this.executor.onSetTheme(i2, stackTrace[i3].toString().startsWith("android.app.ActivityThread.performLaunchActivity"));
                    if (onSetTheme > 0) {
                        super.setTheme(onSetTheme);
                        return;
                    }
                    return;
                }
                i3++;
            }
        }
        super.setTheme(i2);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity != null) {
            fakeActivity.beforeStartActivityForResult(intent, i2, null);
        }
        super.startActivityForResult(intent, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String registerExecutor(String str, Object obj) {
        executors.put(str, (FakeActivity) obj);
        return str;
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        if (view == null) {
            return;
        }
        super.setContentView(view);
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity != null) {
            fakeActivity.setContentView(view);
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity != null) {
            fakeActivity.beforeStartActivityForResult(intent, i2, bundle);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            super.startActivityForResult(intent, i2, bundle);
        } else {
            super.startActivityForResult(intent, i2);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            return;
        }
        if (layoutParams == null) {
            super.setContentView(view);
        } else {
            super.setContentView(view, layoutParams);
        }
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity != null) {
            fakeActivity.setContentView(view);
        }
    }
}
