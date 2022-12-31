package us.pinguo.edit2020.viewmodel.module;

import java.util.List;
import kotlin.collections.c0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.y;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.BackgroundBlur;
import us.pinguo.repository2020.entity.BlurResponse;
import us.pinguo.repository2020.manager.BackgroundBlurDataManager;
import us.pinguo.repository2020.utils.n;
import us.pinguo.util.FileUtils;
/* compiled from: EditBackgroundBlurModule.kt */
@DebugMetadata(c = "us.pinguo.edit2020.viewmodel.module.EditBackgroundBlurModule$deleteCustomizedLens$1", f = "EditBackgroundBlurModule.kt", i = {0}, l = {626}, m = "invokeSuspend", n = {"backgroundBlurs"}, s = {"L$0"})
/* loaded from: classes4.dex */
final class EditBackgroundBlurModule$deleteCustomizedLens$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ EditBackgroundBlurModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditBackgroundBlurModule$deleteCustomizedLens$1(EditBackgroundBlurModule editBackgroundBlurModule, Continuation<? super EditBackgroundBlurModule$deleteCustomizedLens$1> continuation) {
        super(2, continuation);
        this.this$0 = editBackgroundBlurModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new EditBackgroundBlurModule$deleteCustomizedLens$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((EditBackgroundBlurModule$deleteCustomizedLens$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List<BackgroundBlur> list;
        boolean z;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            BlurResponse l2 = BackgroundBlurDataManager.a.l();
            List<BackgroundBlur> packages = l2 == null ? null : l2.getPackages();
            if (packages == null) {
                return u.a;
            }
            BackgroundBlur Q = this.this$0.Q();
            String pid = Q == null ? null : Q.getPid();
            if (pid == null) {
                return u.a;
            }
            us.pinguo.repository2020.database.a.a().u().a(pid);
            y.a(packages).remove(this.this$0.Q());
            String f2 = n.a.f(pid);
            this.L$0 = packages;
            this.label = 1;
            if (FileUtils.l(f2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            list = packages;
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            list = (List) this.L$0;
            j.b(obj);
        }
        BackgroundBlurDataManager.a.s();
        this.this$0.E0(null);
        z = c0.z(list, this.this$0.N());
        if (!z) {
            this.this$0.A0(list.get(0));
        }
        return u.a;
    }
}
