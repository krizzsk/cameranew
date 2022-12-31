package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.MaterialDetail;
/* JADX WARN: Incorrect field signature: TT; */
/* compiled from: BeautyInstallManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.BeautyInstallManager$installStyleMakeup$3", f = "BeautyInstallManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class BeautyInstallManager$installStyleMakeup$3 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ q<Boolean, MaterialDetail, String, u> $installAction;
    final /* synthetic */ MaterialDetail $materialDetail;
    final /* synthetic */ String $msg;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/b/q<-Ljava/lang/Boolean;-Lus/pinguo/repository2020/entity/MaterialDetail;-Ljava/lang/String;Lkotlin/u;>;TT;Ljava/lang/String;Lkotlin/coroutines/Continuation<-Lus/pinguo/repository2020/manager/BeautyInstallManager$installStyleMakeup$3;>;)V */
    public BeautyInstallManager$installStyleMakeup$3(q qVar, MaterialDetail materialDetail, String str, Continuation continuation) {
        super(2, continuation);
        this.$installAction = qVar;
        this.$materialDetail = materialDetail;
        this.$msg = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BeautyInstallManager$installStyleMakeup$3(this.$installAction, this.$materialDetail, this.$msg, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BeautyInstallManager$installStyleMakeup$3) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            this.$installAction.invoke(Boxing.boxBoolean(false), this.$materialDetail, this.$msg);
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
