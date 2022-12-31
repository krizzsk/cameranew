package com.google.android.play.core.missingsplits;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import com.google.android.play.core.internal.j;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
final class d implements a {

    /* renamed from: e  reason: collision with root package name */
    private static final j f4869e = new j("MissingSplitsManagerImpl");
    private final Context a;
    private final Runtime b;
    private final c c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicReference<Boolean> f4870d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, Runtime runtime, c cVar, AtomicReference<Boolean> atomicReference) {
        this.a = context;
        this.b = runtime;
        this.c = cVar;
        this.f4870d = atomicReference;
    }

    @TargetApi(21)
    private final List<ActivityManager.AppTask> b() {
        List<ActivityManager.AppTask> appTasks = ((ActivityManager) this.a.getSystemService("activity")).getAppTasks();
        return appTasks != null ? appTasks : Collections.emptyList();
    }

    @Override // com.google.android.play.core.missingsplits.a
    public final boolean a() {
        boolean booleanValue;
        boolean z;
        Intent intent;
        Class<?> cls;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Set set;
        String[] strArr;
        boolean z2;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            synchronized (this.f4870d) {
                if (this.f4870d.get() == null) {
                    AtomicReference<Boolean> atomicReference = this.f4870d;
                    if (i2 >= 21) {
                        try {
                            applicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
                        } catch (PackageManager.NameNotFoundException unused) {
                            f4869e.g("App '%s' is not found in the PackageManager", this.a.getPackageName());
                        }
                        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                            if (Boolean.TRUE.equals(bundle.get("com.android.vending.splits.required"))) {
                                if (i2 >= 21) {
                                    try {
                                        PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0);
                                        HashSet hashSet = new HashSet();
                                        if (packageInfo != null && (strArr = packageInfo.splitNames) != null) {
                                            Collections.addAll(hashSet, strArr);
                                        }
                                        set = hashSet;
                                    } catch (PackageManager.NameNotFoundException unused2) {
                                        f4869e.g("App '%s' is not found in PackageManager", this.a.getPackageName());
                                    }
                                    if (!set.isEmpty() || (set.size() == 1 && set.contains(""))) {
                                        z2 = true;
                                        atomicReference.set(Boolean.valueOf(z2));
                                    }
                                }
                                set = Collections.emptySet();
                                if (!set.isEmpty()) {
                                }
                                z2 = true;
                                atomicReference.set(Boolean.valueOf(z2));
                            }
                        }
                    }
                    z2 = false;
                    atomicReference.set(Boolean.valueOf(z2));
                }
                booleanValue = this.f4870d.get().booleanValue();
            }
            if (!booleanValue) {
                if (this.c.b()) {
                    this.c.d();
                    this.b.exit(0);
                }
                return false;
            }
            Iterator<ActivityManager.AppTask> it = b().iterator();
            while (true) {
                if (it.hasNext()) {
                    ActivityManager.AppTask next = it.next();
                    if (next.getTaskInfo() != null && next.getTaskInfo().baseIntent != null && next.getTaskInfo().baseIntent.getComponent() != null && PlayCoreMissingSplitsActivity.class.getName().equals(next.getTaskInfo().baseIntent.getComponent().getClassName())) {
                        break;
                    }
                } else {
                    loop1: for (ActivityManager.AppTask appTask : b()) {
                        ActivityManager.RecentTaskInfo taskInfo = appTask.getTaskInfo();
                        if (taskInfo != null && (intent = taskInfo.baseIntent) != null && intent.getComponent() != null) {
                            ComponentName component = taskInfo.baseIntent.getComponent();
                            String className = component.getClassName();
                            try {
                                cls = Class.forName(className);
                            } catch (ClassNotFoundException unused3) {
                                f4869e.g("ClassNotFoundException when scanning class hierarchy of '%s'", className);
                                try {
                                    if (this.a.getPackageManager().getActivityInfo(component, 0) != null) {
                                    }
                                } catch (PackageManager.NameNotFoundException unused4) {
                                }
                            }
                            while (cls != null) {
                                if (cls.equals(Activity.class)) {
                                    z = true;
                                    break;
                                }
                                Class<? super Object> superclass = cls.getSuperclass();
                                cls = superclass != cls ? superclass : null;
                            }
                            continue;
                        }
                    }
                    z = false;
                    this.c.c();
                    for (ActivityManager.AppTask appTask2 : b()) {
                        appTask2.finishAndRemoveTask();
                    }
                    if (z) {
                        this.a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.a, PlayCoreMissingSplitsActivity.class), 1, 1);
                        this.a.startActivity(new Intent(this.a, PlayCoreMissingSplitsActivity.class).addFlags(884998144));
                    }
                    this.b.exit(0);
                }
            }
            return true;
        }
        return false;
    }
}
