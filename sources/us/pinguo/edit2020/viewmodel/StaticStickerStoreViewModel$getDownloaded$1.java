package us.pinguo.edit2020.viewmodel;

import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.channels.e;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.database.staticsticker.StaticSticker;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerStoreViewModel.kt */
@DebugMetadata(c = "us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel$getDownloaded$1", f = "StaticStickerStoreViewModel.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class StaticStickerStoreViewModel$getDownloaded$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ ArrayList<StaticSticker> $stickerList;
    int label;
    final /* synthetic */ StaticStickerStoreViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerStoreViewModel$getDownloaded$1(StaticStickerStoreViewModel staticStickerStoreViewModel, ArrayList<StaticSticker> arrayList, Continuation<? super StaticStickerStoreViewModel$getDownloaded$1> continuation) {
        super(2, continuation);
        this.this$0 = staticStickerStoreViewModel;
        this.$stickerList = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StaticStickerStoreViewModel$getDownloaded$1(this.this$0, this.$stickerList, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StaticStickerStoreViewModel$getDownloaded$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        e eVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            eVar = this.this$0.f10819g;
            ArrayList<StaticSticker> arrayList = this.$stickerList;
            this.label = 1;
            if (eVar.D(arrayList, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        return u.a;
    }
}
