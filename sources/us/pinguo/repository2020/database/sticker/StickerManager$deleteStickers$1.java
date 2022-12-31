package us.pinguo.repository2020.database.sticker;

import com.tapjoy.TapjoyAuctionFlags;
import com.tencent.matrix.trace.config.SharePluginInfo;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* compiled from: StickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.sticker.StickerManager$deleteStickers$1", f = "StickerManager.kt", i = {0, 1}, l = {348, 350, 351}, m = "invokeSuspend", n = {TapjoyAuctionFlags.AUCTION_ID, SharePluginInfo.ISSUE_STACK_TYPE}, s = {"L$1", "L$1"})
/* loaded from: classes6.dex */
final class StickerManager$deleteStickers$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ List<String> $idList;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StickerManager$deleteStickers$1(List<String> list, Continuation<? super StickerManager$deleteStickers$1> continuation) {
        super(2, continuation);
        this.$idList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StickerManager$deleteStickers$1(this.$idList, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StickerManager$deleteStickers$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fe  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00ae -> B:14:0x0054). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.sticker.StickerManager$deleteStickers$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
