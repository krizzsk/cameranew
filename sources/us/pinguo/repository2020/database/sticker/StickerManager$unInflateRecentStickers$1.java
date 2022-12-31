package us.pinguo.repository2020.database.sticker;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.sticker.StickerManager$unInflateRecentStickers$1", f = "StickerManager.kt", i = {1, 2, 2}, l = {205, 210, 217}, m = "invokeSuspend", n = {"ids", "outStream", "e"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: classes6.dex */
public final class StickerManager$unInflateRecentStickers$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StickerManager$unInflateRecentStickers$1(Continuation<? super StickerManager$unInflateRecentStickers$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StickerManager$unInflateRecentStickers$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StickerManager$unInflateRecentStickers$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00af A[Catch: all -> 0x00e1, Exception -> 0x00e5, LOOP:0: B:32:0x00a9->B:34:0x00af, LOOP_END, TryCatch #1 {Exception -> 0x00e5, blocks: (B:31:0x0095, B:32:0x00a9, B:34:0x00af, B:35:0x00ce), top: B:50:0x0095, outer: #0 }] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.io.BufferedOutputStream] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.sticker.StickerManager$unInflateRecentStickers$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
