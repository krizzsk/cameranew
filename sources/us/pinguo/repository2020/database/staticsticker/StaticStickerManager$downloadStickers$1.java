package us.pinguo.repository2020.database.staticsticker;

import com.tapjoy.TapjoyAuctionFlags;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.common.pgdownloader.download.PGDownloadManger;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.staticsticker.StaticStickerManager$downloadStickers$1", f = "StaticStickerManager.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {394, 394}, m = "invokeSuspend", n = {"destination$iv$iv", "url", TapjoyAuctionFlags.AUCTION_ID, "zipPath", "destination$iv$iv", "url", TapjoyAuctionFlags.AUCTION_ID, "zipPath"}, s = {"L$1", "L$3", "L$4", "L$5", "L$1", "L$3", "L$4", "L$5"})
/* loaded from: classes6.dex */
public final class StaticStickerManager$downloadStickers$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ int $fromTemplate;
    final /* synthetic */ PGDownloadManger $manager;
    final /* synthetic */ kotlin.jvm.b.l<Integer, u> $progressCallback;
    final /* synthetic */ kotlin.jvm.b.l<Boolean, u> $resultCallback;
    final /* synthetic */ List<StaticSticker> $stickerList;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StaticStickerManager$downloadStickers$1(List<StaticSticker> list, PGDownloadManger pGDownloadManger, int i2, kotlin.jvm.b.l<? super Integer, u> lVar, kotlin.jvm.b.l<? super Boolean, u> lVar2, Continuation<? super StaticStickerManager$downloadStickers$1> continuation) {
        super(2, continuation);
        this.$stickerList = list;
        this.$manager = pGDownloadManger;
        this.$fromTemplate = i2;
        this.$progressCallback = lVar;
        this.$resultCallback = lVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StaticStickerManager$downloadStickers$1(this.$stickerList, this.$manager, this.$fromTemplate, this.$progressCallback, this.$resultCallback, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StaticStickerManager$downloadStickers$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f6  */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x007c -> B:29:0x00ed). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00c6 -> B:28:0x00dd). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00da -> B:28:0x00dd). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.staticsticker.StaticStickerManager$downloadStickers$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
