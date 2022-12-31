package us.pinguo.repository2020.database.sticker;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.sticker.StickerManager$unInflateFreshStickers$1", f = "StickerManager.kt", i = {0, 1, 1, 2, 2}, l = {167, 170, 177}, m = "invokeSuspend", n = {PGEditResultActivity2.PATH, PGEditResultActivity2.PATH, "list", "outStream", "e"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes6.dex */
public final class StickerManager$unInflateFreshStickers$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StickerManager$unInflateFreshStickers$1(Continuation<? super StickerManager$unInflateFreshStickers$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StickerManager$unInflateFreshStickers$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StickerManager$unInflateFreshStickers$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0087 A[Catch: all -> 0x00b9, Exception -> 0x00bd, LOOP:0: B:29:0x0081->B:31:0x0087, LOOP_END, TryCatch #0 {Exception -> 0x00bd, blocks: (B:28:0x0071, B:29:0x0081, B:31:0x0087, B:32:0x00a6), top: B:47:0x0071, outer: #1 }] */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, java.io.BufferedOutputStream] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.sticker.StickerManager$unInflateFreshStickers$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
