package us.pinguo.repository2020.manager;

import java.io.File;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.util.FileIOUtils;
import us.pinguo.util.FileUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BeautyDataManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.BeautyDataManager$loadStyleMakeupSuitData$request$1$onResponse$1", f = "BeautyDataManager.kt", i = {0}, l = {175, 176}, m = "invokeSuspend", n = {"file"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class BeautyDataManager$loadStyleMakeupSuitData$request$1$onResponse$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ boolean $isEnterCamera;
    final /* synthetic */ String $response;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautyDataManager$loadStyleMakeupSuitData$request$1$onResponse$1(boolean z, String str, Continuation<? super BeautyDataManager$loadStyleMakeupSuitData$request$1$onResponse$1> continuation) {
        super(2, continuation);
        this.$isEnterCamera = z;
        this.$response = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BeautyDataManager$loadStyleMakeupSuitData$request$1$onResponse$1(this.$isEnterCamera, this.$response, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BeautyDataManager$loadStyleMakeupSuitData$request$1$onResponse$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        File file;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            file = new File(this.$isEnterCamera ? BeautyDataManager.f11898i : BeautyDataManager.f11900k);
            file.delete();
            this.L$0 = file;
            this.label = 1;
            if (FileUtils.g(file, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.j.b(obj);
            return u.a;
        } else {
            file = (File) this.L$0;
            kotlin.j.b(obj);
        }
        String str = this.$response;
        this.L$0 = null;
        this.label = 2;
        if (FileIOUtils.o(file, str, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return u.a;
    }
}
