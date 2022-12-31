package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.HashMap;
import java.util.Map;
/* compiled from: RequestManagerRetriever.java */
/* loaded from: classes.dex */
public class j implements Handler.Callback {

    /* renamed from: e  reason: collision with root package name */
    private static final j f821e = new j();
    private volatile com.bumptech.glide.f a;
    final Map<FragmentManager, RequestManagerFragment> b = new HashMap();
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Handler f822d = new Handler(Looper.getMainLooper(), this);

    j() {
    }

    @TargetApi(17)
    private static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    public static j f() {
        return f821e;
    }

    private com.bumptech.glide.f g(Context context) {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = new com.bumptech.glide.f(context.getApplicationContext(), new b(), new f());
                }
            }
        }
        return this.a;
    }

    @TargetApi(11)
    com.bumptech.glide.f b(Context context, FragmentManager fragmentManager) {
        RequestManagerFragment h2 = h(fragmentManager);
        com.bumptech.glide.f c = h2.c();
        if (c == null) {
            com.bumptech.glide.f fVar = new com.bumptech.glide.f(context, h2.b(), h2.d());
            h2.f(fVar);
            return fVar;
        }
        return c;
    }

    @TargetApi(11)
    public com.bumptech.glide.f c(Activity activity) {
        if (!com.bumptech.glide.l.h.h() && Build.VERSION.SDK_INT >= 11) {
            a(activity);
            return b(activity, activity.getFragmentManager());
        }
        return d(activity.getApplicationContext());
    }

    public com.bumptech.glide.f d(Context context) {
        if (context != null) {
            if (com.bumptech.glide.l.h.i() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return e((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return c((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    return d(((ContextWrapper) context).getBaseContext());
                }
            }
            return g(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public com.bumptech.glide.f e(FragmentActivity fragmentActivity) {
        if (com.bumptech.glide.l.h.h()) {
            return d(fragmentActivity.getApplicationContext());
        }
        a(fragmentActivity);
        return j(fragmentActivity, fragmentActivity.getSupportFragmentManager());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(17)
    public RequestManagerFragment h(FragmentManager fragmentManager) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (requestManagerFragment == null) {
            RequestManagerFragment requestManagerFragment2 = this.b.get(fragmentManager);
            if (requestManagerFragment2 == null) {
                RequestManagerFragment requestManagerFragment3 = new RequestManagerFragment();
                this.b.put(fragmentManager, requestManagerFragment3);
                FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                FragmentTransaction add = beginTransaction.add(requestManagerFragment3, "com.bumptech.glide.manager");
                VdsAgent.onFragmentTransactionAdd(beginTransaction, requestManagerFragment3, "com.bumptech.glide.manager", add);
                add.commitAllowingStateLoss();
                this.f822d.obtainMessage(1, fragmentManager).sendToTarget();
                return requestManagerFragment3;
            }
            return requestManagerFragment2;
        }
        return requestManagerFragment;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Object remove;
        Object obj2;
        int i2 = message.what;
        Object obj3 = null;
        boolean z = true;
        if (i2 == 1) {
            obj = (FragmentManager) message.obj;
            remove = this.b.remove(obj);
        } else if (i2 == 2) {
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            remove = this.c.remove(obj);
        } else {
            z = false;
            obj2 = null;
            if (z && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
            }
            return z;
        }
        Object obj4 = obj;
        obj3 = remove;
        obj2 = obj4;
        if (z) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SupportRequestManagerFragment i(androidx.fragment.app.FragmentManager fragmentManager) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null) {
            SupportRequestManagerFragment supportRequestManagerFragment2 = this.c.get(fragmentManager);
            if (supportRequestManagerFragment2 == null) {
                SupportRequestManagerFragment supportRequestManagerFragment3 = new SupportRequestManagerFragment();
                this.c.put(fragmentManager, supportRequestManagerFragment3);
                androidx.fragment.app.FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                androidx.fragment.app.FragmentTransaction add = beginTransaction.add(supportRequestManagerFragment3, "com.bumptech.glide.manager");
                VdsAgent.onFragmentTransactionAdd(beginTransaction, supportRequestManagerFragment3, "com.bumptech.glide.manager", add);
                add.commitAllowingStateLoss();
                this.f822d.obtainMessage(2, fragmentManager).sendToTarget();
                return supportRequestManagerFragment3;
            }
            return supportRequestManagerFragment2;
        }
        return supportRequestManagerFragment;
    }

    com.bumptech.glide.f j(Context context, androidx.fragment.app.FragmentManager fragmentManager) {
        SupportRequestManagerFragment i2 = i(fragmentManager);
        com.bumptech.glide.f c0 = i2.c0();
        if (c0 == null) {
            com.bumptech.glide.f fVar = new com.bumptech.glide.f(context, i2.b0(), i2.d0());
            i2.f0(fVar);
            return fVar;
        }
        return c0;
    }
}
