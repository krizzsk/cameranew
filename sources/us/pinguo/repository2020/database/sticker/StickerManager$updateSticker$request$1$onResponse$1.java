package us.pinguo.repository2020.database.sticker;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.sticker.StickerManager$updateSticker$request$1$onResponse$1", f = "StickerManager.kt", i = {0}, l = {630, 631}, m = "invokeSuspend", n = {"file"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class StickerManager$updateSticker$request$1$onResponse$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ int $forceUpdateVersion;
    final /* synthetic */ String $response;
    final /* synthetic */ StickerResponseData $responseData;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManager$updateSticker$request$1$onResponse$1(int i2, StickerResponseData stickerResponseData, String str, Continuation<? super StickerManager$updateSticker$request$1$onResponse$1> continuation) {
        super(2, continuation);
        this.$forceUpdateVersion = i2;
        this.$responseData = stickerResponseData;
        this.$response = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StickerManager$updateSticker$request$1$onResponse$1(this.$forceUpdateVersion, this.$responseData, this.$response, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StickerManager$updateSticker$request$1$onResponse$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L23
            if (r1 == r4) goto L1b
            if (r1 != r3) goto L13
            kotlin.j.b(r8)
            goto L66
        L13:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1b:
            java.lang.Object r1 = r7.L$0
            java.io.File r1 = (java.io.File) r1
            kotlin.j.b(r8)
            goto L59
        L23:
            kotlin.j.b(r8)
            us.pinguo.foundation.j r8 = us.pinguo.foundation.j.e()
            int r1 = r7.$forceUpdateVersion
            java.lang.String r5 = "key_fource_update_unity_version"
            r8.q(r5, r1)
            us.pinguo.repository2020.utils.RequestIntervalPref r8 = us.pinguo.repository2020.utils.RequestIntervalPref.a
            us.pinguo.repository2020.database.sticker.StickerResponseData r1 = r7.$responseData
            us.pinguo.repository2020.database.sticker.StickerJson r1 = r1.getData()
            int r1 = r1.getInterval()
            int r1 = r1 * 1000
            long r5 = (long) r1
            java.lang.String r1 = "/api/product/unity-system"
            r8.d(r1, r5, r2)
            java.io.File r1 = new java.io.File
            java.lang.String r8 = us.pinguo.repository2020.database.sticker.StickerManager.m()
            r1.<init>(r8)
            r7.L$0 = r1
            r7.label = r4
            java.lang.Object r8 = us.pinguo.util.FileUtils.g(r1, r7)
            if (r8 != r0) goto L59
            return r0
        L59:
            java.lang.String r8 = r7.$response
            r7.L$0 = r2
            r7.label = r3
            java.lang.Object r8 = us.pinguo.util.FileIOUtils.o(r1, r8, r7)
            if (r8 != r0) goto L66
            return r0
        L66:
            java.util.Map r8 = us.pinguo.repository2020.database.sticker.StickerManager.q()
            us.pinguo.repository2020.database.sticker.StickerResponseData r0 = r7.$responseData
            us.pinguo.repository2020.database.sticker.StickerJson r0 = r0.getData()
            us.pinguo.repository2020.database.sticker.Sticker[] r0 = r0.getPackages()
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L77:
            if (r3 >= r1) goto L9a
            r5 = r0[r3]
            int r3 = r3 + 1
            if (r8 != 0) goto L81
        L7f:
            r6 = 0
            goto L8c
        L81:
            java.lang.String r6 = r5.getPid()
            boolean r6 = r8.containsKey(r6)
            if (r6 != r4) goto L7f
            r6 = 1
        L8c:
            if (r6 != 0) goto L77
            java.util.concurrent.CopyOnWriteArrayList r6 = us.pinguo.repository2020.database.sticker.StickerManager.g()
            java.lang.String r5 = r5.getPid()
            r6.add(r5)
            goto L77
        L9a:
            us.pinguo.repository2020.database.sticker.StickerManager r8 = us.pinguo.repository2020.database.sticker.StickerManager.a
            us.pinguo.repository2020.database.sticker.StickerManager.x(r8)
            kotlin.u r8 = kotlin.u.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.sticker.StickerManager$updateSticker$request$1$onResponse$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
