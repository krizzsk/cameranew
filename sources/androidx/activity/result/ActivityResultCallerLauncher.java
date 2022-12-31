package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: ActivityResultCaller.kt */
/* loaded from: classes.dex */
public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<u> {
    private final ActivityResultContract<I, O> callerContract;
    private final I input;
    private final ActivityResultLauncher<I> launcher;
    private final f resultContract$delegate;

    public ActivityResultCallerLauncher(ActivityResultLauncher<I> launcher, ActivityResultContract<I, O> callerContract, I i2) {
        f b;
        s.h(launcher, "launcher");
        s.h(callerContract, "callerContract");
        this.launcher = launcher;
        this.callerContract = callerContract;
        this.input = i2;
        b = h.b(new ActivityResultCallerLauncher$resultContract$2(this));
        this.resultContract$delegate = b;
    }

    public final ActivityResultContract<I, O> getCallerContract() {
        return this.callerContract;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public ActivityResultContract<u, ?> getContract() {
        return (ActivityResultContract<u, O>) getResultContract();
    }

    public final I getInput() {
        return this.input;
    }

    public final ActivityResultLauncher<I> getLauncher() {
        return this.launcher;
    }

    public final ActivityResultContract<u, O> getResultContract() {
        return (ActivityResultContract) this.resultContract$delegate.getValue();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void unregister() {
        this.launcher.unregister();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void launch(u uVar, ActivityOptionsCompat activityOptionsCompat) {
        this.launcher.launch(this.input, activityOptionsCompat);
    }
}
