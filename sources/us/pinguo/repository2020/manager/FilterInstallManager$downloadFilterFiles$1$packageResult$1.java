package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.q;
/* compiled from: FilterInstallManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.FilterInstallManager$downloadFilterFiles$1$packageResult$1", f = "FilterInstallManager.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class FilterInstallManager$downloadFilterFiles$1$packageResult$1 extends SuspendLambda implements p<m0, Continuation<? super Boolean>, Object> {
    final /* synthetic */ q $listener;
    final /* synthetic */ String $packagePath;
    final /* synthetic */ String $packageZipUrl;
    int label;
    final /* synthetic */ FilterInstallManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterInstallManager$downloadFilterFiles$1$packageResult$1(FilterInstallManager filterInstallManager, String str, String str2, q qVar, Continuation<? super FilterInstallManager$downloadFilterFiles$1$packageResult$1> continuation) {
        super(2, continuation);
        this.this$0 = filterInstallManager;
        this.$packageZipUrl = str;
        this.$packagePath = str2;
        this.$listener = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FilterInstallManager$downloadFilterFiles$1$packageResult$1(this.this$0, this.$packageZipUrl, this.$packagePath, this.$listener, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super Boolean> continuation) {
        return ((FilterInstallManager$downloadFilterFiles$1$packageResult$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            FilterInstallManager filterInstallManager = this.this$0;
            String str = this.$packageZipUrl;
            String str2 = this.$packagePath;
            q qVar = this.$listener;
            this.label = 1;
            obj = filterInstallManager.n(str, str2, qVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        return obj;
    }
}
