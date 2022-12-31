package us.pinguo.repository2020.database.staticsticker;

import com.pinguo.lib.GsonUtilKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerManager.kt */
/* loaded from: classes6.dex */
public final class StaticStickerManager$fetchStickers$1 extends Lambda implements p<StaticStickerJson, Throwable, u> {
    final /* synthetic */ p<StaticStickerJson, Exception, u> $callback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StaticStickerManager.kt */
    @DebugMetadata(c = "us.pinguo.repository2020.database.staticsticker.StaticStickerManager$fetchStickers$1$1", f = "StaticStickerManager.kt", i = {}, l = {374, 375}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.repository2020.database.staticsticker.StaticStickerManager$fetchStickers$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ p<StaticStickerJson, Exception, u> $callback;
        final /* synthetic */ String $filePath;
        final /* synthetic */ String $jsonStr;
        final /* synthetic */ StaticStickerJson $staticStickerJson;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(String str, String str2, p<? super StaticStickerJson, ? super Exception, u> pVar, StaticStickerJson staticStickerJson, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$filePath = str;
            this.$jsonStr = str2;
            this.$callback = pVar;
            this.$staticStickerJson = staticStickerJson;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$filePath, this.$jsonStr, this.$callback, this.$staticStickerJson, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.j.b(r5)
                goto L3e
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                kotlin.j.b(r5)
                goto L2c
            L1e:
                kotlin.j.b(r5)
                java.lang.String r5 = r4.$filePath
                r4.label = r3
                java.lang.Object r5 = us.pinguo.util.FileUtils.l(r5, r4)
                if (r5 != r0) goto L2c
                return r0
            L2c:
                java.lang.String r5 = r4.$filePath
                java.lang.String r1 = r4.$jsonStr
                java.lang.String r3 = "jsonStr"
                kotlin.jvm.internal.s.g(r1, r3)
                r4.label = r2
                java.lang.Object r5 = us.pinguo.util.FileIOUtils.q(r5, r1, r4)
                if (r5 != r0) goto L3e
                return r0
            L3e:
                kotlin.jvm.b.p<us.pinguo.repository2020.database.staticsticker.StaticStickerJson, java.lang.Exception, kotlin.u> r5 = r4.$callback
                if (r5 != 0) goto L43
                goto L49
            L43:
                us.pinguo.repository2020.database.staticsticker.StaticStickerJson r0 = r4.$staticStickerJson
                r1 = 0
                r5.invoke(r0, r1)
            L49:
                kotlin.u r5 = kotlin.u.a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.staticsticker.StaticStickerManager$fetchStickers$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StaticStickerManager$fetchStickers$1(p<? super StaticStickerJson, ? super Exception, u> pVar) {
        super(2);
        this.$callback = pVar;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(StaticStickerJson staticStickerJson, Throwable th) {
        invoke2(staticStickerJson, th);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(StaticStickerJson staticStickerJson, Throwable th) {
        if (staticStickerJson != null && th == null) {
            String s = GsonUtilKt.getCachedGson().s(staticStickerJson);
            kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new AnonymousClass1(s.q(StaticStickerManager.a.u(), "static_sticker_list.json"), s, this.$callback, staticStickerJson, null), 3, null);
            return;
        }
        p<StaticStickerJson, Exception, u> pVar = this.$callback;
        if (pVar == null) {
            return;
        }
        pVar.invoke(null, new Exception(th));
    }
}
