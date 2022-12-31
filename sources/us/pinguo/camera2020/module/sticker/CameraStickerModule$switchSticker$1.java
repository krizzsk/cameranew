package us.pinguo.camera2020.module.sticker;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.camera2020.model.render.UnityRender;
import us.pinguo.repository2020.database.sticker.Sticker;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraStickerModule.kt */
@DebugMetadata(c = "us.pinguo.camera2020.module.sticker.CameraStickerModule$switchSticker$1", f = "CameraStickerModule.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class CameraStickerModule$switchSticker$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ String $id;
    int label;
    final /* synthetic */ CameraStickerModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraStickerModule$switchSticker$1(CameraStickerModule cameraStickerModule, String str, Continuation<? super CameraStickerModule$switchSticker$1> continuation) {
        super(2, continuation);
        this.this$0 = cameraStickerModule;
        this.$id = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new CameraStickerModule$switchSticker$1(this.this$0, this.$id, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((CameraStickerModule$switchSticker$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        UnityRender unityRender;
        us.pinguo.repository2020.u uVar;
        Sticker m;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            CameraStickerModule cameraStickerModule = this.this$0;
            String str = this.$id;
            this.label = 1;
            obj = cameraStickerModule.g(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        String[] strArr = (String[]) obj;
        if (strArr == null) {
            return u.a;
        }
        String str2 = strArr[0];
        String str3 = strArr[1];
        unityRender = this.this$0.a;
        unityRender.Y(str2, str3);
        uVar = this.this$0.b;
        m = this.this$0.m(this.$id);
        uVar.postValue(m);
        return u.a;
    }
}
