package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActivityResultCaller.kt */
/* loaded from: classes.dex */
public final class ActivityResultCallerLauncher$resultContract$2 extends Lambda implements a<AnonymousClass1> {
    final /* synthetic */ ActivityResultCallerLauncher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityResultCallerLauncher$resultContract$2(ActivityResultCallerLauncher activityResultCallerLauncher) {
        super(0);
        this.this$0 = activityResultCallerLauncher;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.activity.result.ActivityResultCallerLauncher$resultContract$2$1] */
    @Override // kotlin.jvm.b.a
    public final AnonymousClass1 invoke() {
        return new ActivityResultContract<u, O>() { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2.1
            /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, O] */
            @Override // androidx.activity.result.contract.ActivityResultContract
            public O parseResult(int i2, Intent intent) {
                return ActivityResultCallerLauncher$resultContract$2.this.this$0.getCallerContract().parseResult(i2, intent);
            }

            @Override // androidx.activity.result.contract.ActivityResultContract
            public Intent createIntent(Context context, u uVar) {
                s.h(context, "context");
                Intent createIntent = ActivityResultCallerLauncher$resultContract$2.this.this$0.getCallerContract().createIntent(context, ActivityResultCallerLauncher$resultContract$2.this.this$0.getInput());
                s.g(createIntent, "callerContract.createIntent(context, input)");
                return createIntent;
            }
        };
    }
}
