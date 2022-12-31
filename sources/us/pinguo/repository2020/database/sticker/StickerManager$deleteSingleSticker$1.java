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
@DebugMetadata(c = "us.pinguo.repository2020.database.sticker.StickerManager$deleteSingleSticker$1", f = "StickerManager.kt", i = {1}, l = {334, 336, 337}, m = "invokeSuspend", n = {SharePluginInfo.ISSUE_STACK_TYPE}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class StickerManager$deleteSingleSticker$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ String $id;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManager$deleteSingleSticker$1(String str, Continuation<? super StickerManager$deleteSingleSticker$1> continuation) {
        super(2, continuation);
        this.$id = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StickerManager$deleteSingleSticker$1(this.$id, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StickerManager$deleteSingleSticker$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00dc  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 0
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L2d
            if (r1 == r6) goto L29
            if (r1 == r5) goto L20
            if (r1 != r4) goto L18
            kotlin.j.b(r9)
            goto Lef
        L18:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L20:
            java.lang.Object r1 = r8.L$0
            us.pinguo.repository2020.database.sticker.StickerDetail r1 = (us.pinguo.repository2020.database.sticker.StickerDetail) r1
            kotlin.j.b(r9)
            goto Lcd
        L29:
            kotlin.j.b(r9)
            goto L96
        L2d:
            kotlin.j.b(r9)
            java.util.Map r9 = us.pinguo.repository2020.database.sticker.StickerManager.q()
            if (r9 != 0) goto L38
            r9 = r3
            goto L40
        L38:
            java.lang.String r1 = r8.$id
            java.lang.Object r9 = r9.get(r1)
            us.pinguo.repository2020.database.sticker.Sticker r9 = (us.pinguo.repository2020.database.sticker.Sticker) r9
        L40:
            if (r9 != 0) goto L43
            goto L48
        L43:
            us.pinguo.repository2020.database.sticker.StickerState r1 = us.pinguo.repository2020.database.sticker.StickerState.NOT_DOWNLOADED
            r9.setState(r1)
        L48:
            java.util.concurrent.CopyOnWriteArrayList r9 = us.pinguo.repository2020.database.sticker.StickerManager.h()
            java.lang.String r1 = r8.$id
            r9.remove(r1)
            android.util.LruCache r9 = us.pinguo.repository2020.database.sticker.StickerManager.k()
            java.lang.String r1 = r8.$id
            r9.remove(r1)
            android.util.LruCache r9 = us.pinguo.repository2020.database.sticker.StickerManager.l()
            java.lang.String r1 = r8.$id
            r9.remove(r1)
            us.pinguo.repository2020.database.EffectDbManager r9 = us.pinguo.repository2020.database.a.a()
            us.pinguo.repository2020.database.sticker.e r9 = r9.G()
            java.lang.String r1 = r8.$id
            r9.a(r1)
            us.pinguo.repository2020.database.EffectDbManager r9 = us.pinguo.repository2020.database.a.a()
            us.pinguo.repository2020.database.sticker.b r9 = r9.F()
            java.lang.String r1 = r8.$id
            r9.f(r1)
            java.lang.String r9 = us.pinguo.repository2020.database.sticker.StickerManager.n()
            us.pinguo.repository2020.database.sticker.StickerManager r1 = us.pinguo.repository2020.database.sticker.StickerManager.a
            java.lang.String r7 = r8.$id
            java.lang.String r1 = us.pinguo.repository2020.database.sticker.StickerManager.i(r1, r7)
            java.lang.String r9 = kotlin.jvm.internal.s.q(r9, r1)
            r8.label = r6
            java.lang.Object r9 = us.pinguo.util.FileUtils.l(r9, r8)
            if (r9 != r0) goto L96
            return r0
        L96:
            java.util.concurrent.ConcurrentHashMap r9 = us.pinguo.repository2020.database.sticker.StickerManager.o()
            java.lang.String r1 = r8.$id
            java.lang.Object r9 = r9.remove(r1)
            r1 = r9
            us.pinguo.repository2020.database.sticker.StickerDetail r1 = (us.pinguo.repository2020.database.sticker.StickerDetail) r1
            if (r1 != 0) goto La8
            kotlin.u r9 = kotlin.u.a
            return r9
        La8:
            java.lang.String r9 = r1.getPackage_zip_md5()
            if (r9 == 0) goto Lb7
            int r9 = r9.length()
            if (r9 != 0) goto Lb5
            goto Lb7
        Lb5:
            r9 = 0
            goto Lb8
        Lb7:
            r9 = 1
        Lb8:
            if (r9 != 0) goto Lcd
            java.lang.String r9 = r1.getPackage_zip_md5()
            java.lang.String r9 = us.pinguo.repository2020.utils.h.i(r9)
            r8.L$0 = r1
            r8.label = r5
            java.lang.Object r9 = us.pinguo.util.FileUtils.l(r9, r8)
            if (r9 != r0) goto Lcd
            return r0
        Lcd:
            java.lang.String r9 = r1.getDisplay_zip_md5()
            if (r9 == 0) goto Ld9
            int r9 = r9.length()
            if (r9 != 0) goto Lda
        Ld9:
            r2 = 1
        Lda:
            if (r2 != 0) goto Lef
            java.lang.String r9 = r1.getDisplay_zip_md5()
            java.lang.String r9 = us.pinguo.repository2020.utils.h.i(r9)
            r8.L$0 = r3
            r8.label = r4
            java.lang.Object r9 = us.pinguo.util.FileUtils.l(r9, r8)
            if (r9 != r0) goto Lef
            return r0
        Lef:
            kotlin.u r9 = kotlin.u.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.sticker.StickerManager$deleteSingleSticker$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
