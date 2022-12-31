package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes.dex */
public class LifecycleService extends Service implements LifecycleOwner {
    private final ServiceLifecycleDispatcher mDispatcher = new ServiceLifecycleDispatcher(this);

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mDispatcher.getLifecycle();
    }

    @Override // android.app.Service
    @Nullable
    @CallSuper
    public IBinder onBind(Intent intent) {
        this.mDispatcher.onServicePreSuperOnBind();
        return null;
    }

    @Override // android.app.Service
    @CallSuper
    public void onCreate() {
        this.mDispatcher.onServicePreSuperOnCreate();
        super.onCreate();
    }

    @Override // android.app.Service
    @CallSuper
    public void onDestroy() {
        this.mDispatcher.onServicePreSuperOnDestroy();
        super.onDestroy();
    }

    @Override // android.app.Service
    @CallSuper
    public void onStart(Intent intent, int i2) {
        VdsAgent.onServiceStart(this, intent, i2);
        this.mDispatcher.onServicePreSuperOnStart();
        super.onStart(intent, i2);
    }

    @Override // android.app.Service
    @CallSuper
    public int onStartCommand(Intent intent, int i2, int i3) {
        VdsAgent.onServiceStartCommand(this, intent, i2, i3);
        return super.onStartCommand(intent, i2, i3);
    }
}
