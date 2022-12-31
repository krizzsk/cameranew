package us.pinguo.repository2020.database.sticker;

import com.tencent.matrix.trace.config.SharePluginInfo;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.sticker.StickerManager$downloadStickerDetailAsync$request$1$onResponse$1", f = "StickerManager.kt", i = {0, 0, 1}, l = {926, 928}, m = "invokeSuspend", n = {SharePluginInfo.ISSUE_STACK_TYPE, "detailSavePath", SharePluginInfo.ISSUE_STACK_TYPE}, s = {"L$2", "L$3", "L$1"})
/* loaded from: classes6.dex */
public final class StickerManager$downloadStickerDetailAsync$request$1$onResponse$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ p<String[], Boolean, u> $completeAction;
    final /* synthetic */ StickerDetail[] $stickerDetails;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StickerManager$downloadStickerDetailAsync$request$1$onResponse$1(StickerDetail[] stickerDetailArr, p<? super String[], ? super Boolean, u> pVar, Continuation<? super StickerManager$downloadStickerDetailAsync$request$1$onResponse$1> continuation) {
        super(2, continuation);
        this.$stickerDetails = stickerDetailArr;
        this.$completeAction = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StickerManager$downloadStickerDetailAsync$request$1$onResponse$1(this.$stickerDetails, this.$completeAction, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StickerManager$downloadStickerDetailAsync$request$1$onResponse$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x008b -> B:16:0x0095). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.sticker.StickerManager$downloadStickerDetailAsync$request$1$onResponse$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
