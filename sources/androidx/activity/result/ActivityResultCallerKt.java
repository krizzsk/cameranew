package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: ActivityResultCaller.kt */
/* loaded from: classes.dex */
public final class ActivityResultCallerKt {
    public static final <I, O> ActivityResultLauncher<u> registerForActivityResult(ActivityResultCaller registerForActivityResult, ActivityResultContract<I, O> contract, I i2, ActivityResultRegistry registry, final l<? super O, u> callback) {
        s.h(registerForActivityResult, "$this$registerForActivityResult");
        s.h(contract, "contract");
        s.h(registry, "registry");
        s.h(callback, "callback");
        ActivityResultLauncher<I> registerForActivityResult2 = registerForActivityResult.registerForActivityResult(contract, registry, new ActivityResultCallback<O>() { // from class: androidx.activity.result.ActivityResultCallerKt$registerForActivityResult$resultLauncher$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(O o) {
                l.this.invoke(o);
            }
        });
        s.g(registerForActivityResult2, "registerForActivityResul…egistry) { callback(it) }");
        return new ActivityResultCallerLauncher(registerForActivityResult2, contract, i2);
    }

    public static final <I, O> ActivityResultLauncher<u> registerForActivityResult(ActivityResultCaller registerForActivityResult, ActivityResultContract<I, O> contract, I i2, final l<? super O, u> callback) {
        s.h(registerForActivityResult, "$this$registerForActivityResult");
        s.h(contract, "contract");
        s.h(callback, "callback");
        ActivityResultLauncher<I> registerForActivityResult2 = registerForActivityResult.registerForActivityResult(contract, new ActivityResultCallback<O>() { // from class: androidx.activity.result.ActivityResultCallerKt$registerForActivityResult$resultLauncher$2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(O o) {
                l.this.invoke(o);
            }
        });
        s.g(registerForActivityResult2, "registerForActivityResul…ontract) { callback(it) }");
        return new ActivityResultCallerLauncher(registerForActivityResult2, contract, i2);
    }
}
