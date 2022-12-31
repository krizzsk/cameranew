package us.pinguo.repository2020.database.staticsticker;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.staticsticker.StaticStickerManager$unInflateRecentStickers$1", f = "StaticStickerManager.kt", i = {0, 1, 1, 2, 2}, l = {334, 339, 346}, m = "invokeSuspend", n = {"recentPath", "recentPath", "idList", "outStream", "e"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes6.dex */
public final class StaticStickerManager$unInflateRecentStickers$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StaticStickerManager$unInflateRecentStickers$1(Continuation<? super StaticStickerManager$unInflateRecentStickers$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StaticStickerManager$unInflateRecentStickers$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StaticStickerManager$unInflateRecentStickers$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00be A[Catch: all -> 0x00f0, Exception -> 0x00f4, LOOP:0: B:33:0x00b8->B:35:0x00be, LOOP_END, TryCatch #1 {Exception -> 0x00f4, blocks: (B:32:0x00a8, B:33:0x00b8, B:35:0x00be, B:36:0x00dd), top: B:51:0x00a8, outer: #0 }] */
    /* JADX WARN: Type inference failed for: r6v2, types: [T, java.io.BufferedOutputStream] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.staticsticker.StaticStickerManager$unInflateRecentStickers$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
