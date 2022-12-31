package us.pinguo.camera2020.module.sticker;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraStickerModule.kt */
@DebugMetadata(c = "us.pinguo.camera2020.module.sticker.CameraStickerModule$reloadSticker$1$1", f = "CameraStickerModule.kt", i = {}, l = {195}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class CameraStickerModule$reloadSticker$1$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ String $it;
    int label;
    final /* synthetic */ CameraStickerModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraStickerModule$reloadSticker$1$1(CameraStickerModule cameraStickerModule, String str, Continuation<? super CameraStickerModule$reloadSticker$1$1> continuation) {
        super(2, continuation);
        this.this$0 = cameraStickerModule;
        this.$it = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new CameraStickerModule$reloadSticker$1$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((CameraStickerModule$reloadSticker$1$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int intValue;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            this.this$0.K(this.$it, true);
            this.this$0.B();
            Integer s = this.this$0.s("makeup");
            if (s != null) {
                intValue = s.intValue();
                this.this$0.I(intValue / 100.0f);
                return u.a;
            }
            CameraStickerModule cameraStickerModule = this.this$0;
            String str = this.$it;
            this.label = 1;
            obj = cameraStickerModule.v("makeup", str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        intValue = ((Number) obj).intValue();
        this.this$0.I(intValue / 100.0f);
        return u.a;
    }
}
