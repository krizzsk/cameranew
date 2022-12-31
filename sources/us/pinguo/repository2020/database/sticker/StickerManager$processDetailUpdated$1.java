package us.pinguo.repository2020.database.sticker;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.sticker.StickerManager$processDetailUpdated$1", f = "StickerManager.kt", i = {0, 0, 1, 1, 2}, l = {746, 747, 748}, m = "invokeSuspend", n = {"pendingList", "it", "pendingList", "it", "pendingList"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0"})
/* loaded from: classes6.dex */
public final class StickerManager$processDetailUpdated$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ List<String> $installedList;
    final /* synthetic */ StickerUpdateData[] $updateData;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManager$processDetailUpdated$1(List<String> list, StickerUpdateData[] stickerUpdateDataArr, Continuation<? super StickerManager$processDetailUpdated$1> continuation) {
        super(2, continuation);
        this.$installedList = list;
        this.$updateData = stickerUpdateDataArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StickerManager$processDetailUpdated$1(this.$installedList, this.$updateData, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StickerManager$processDetailUpdated$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0189  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0185 -> B:37:0x00bc). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.sticker.StickerManager$processDetailUpdated$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
