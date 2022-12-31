package us.pinguo.repository2020.database.staticsticker;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.u;
import kotlinx.coroutines.m0;
/* compiled from: StaticStickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.staticsticker.StaticStickerManager$downloadStickers$1$1$onComplete$1", f = "StaticStickerManager.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 5, 5}, l = {411, TypedValues.CycleType.TYPE_PATH_ROTATE, TypedValues.CycleType.TYPE_PATH_ROTATE, 417, TypedValues.CycleType.TYPE_WAVE_OFFSET, 441, 470}, m = "invokeSuspend", n = {"result", "task", "zipPath", "result", "zipPath", "stickerPath", "result", "zipPath", "stickerPath", "result", "zipPath", "stickerPath", "result", "result", "destination$iv$iv", "stickerTable"}, s = {"L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$0", "L$0", "L$1", "L$3"})
/* loaded from: classes6.dex */
final class StaticStickerManager$downloadStickers$1$1$onComplete$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ int $fromTemplate;
    final /* synthetic */ kotlin.jvm.b.l<Integer, u> $progressCallback;
    final /* synthetic */ kotlin.jvm.b.l<Boolean, u> $resultCallback;
    final /* synthetic */ List<l> $tasks;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StaticStickerManager.kt */
    @DebugMetadata(c = "us.pinguo.repository2020.database.staticsticker.StaticStickerManager$downloadStickers$1$1$onComplete$1$2", f = "StaticStickerManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.repository2020.database.staticsticker.StaticStickerManager$downloadStickers$1$1$onComplete$1$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ kotlin.jvm.b.l<Integer, u> $progressCallback;
        final /* synthetic */ Ref$BooleanRef $result;
        final /* synthetic */ kotlin.jvm.b.l<Boolean, u> $resultCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(kotlin.jvm.b.l<? super Integer, u> lVar, kotlin.jvm.b.l<? super Boolean, u> lVar2, Ref$BooleanRef ref$BooleanRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$progressCallback = lVar;
            this.$resultCallback = lVar2;
            this.$result = ref$BooleanRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$progressCallback, this.$resultCallback, this.$result, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass2) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                kotlin.jvm.b.l<Integer, u> lVar = this.$progressCallback;
                if (lVar != null) {
                    lVar.invoke(Boxing.boxInt(100));
                }
                kotlin.jvm.b.l<Boolean, u> lVar2 = this.$resultCallback;
                if (lVar2 != null) {
                    lVar2.invoke(Boxing.boxBoolean(this.$result.element));
                }
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StaticStickerManager$downloadStickers$1$1$onComplete$1(List<l> list, int i2, kotlin.jvm.b.l<? super Integer, u> lVar, kotlin.jvm.b.l<? super Boolean, u> lVar2, Continuation<? super StaticStickerManager$downloadStickers$1$1$onComplete$1> continuation) {
        super(2, continuation);
        this.$tasks = list;
        this.$fromTemplate = i2;
        this.$progressCallback = lVar;
        this.$resultCallback = lVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StaticStickerManager$downloadStickers$1$1$onComplete$1(this.$tasks, this.$fromTemplate, this.$progressCallback, this.$resultCallback, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StaticStickerManager$downloadStickers$1$1$onComplete$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0318 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x015e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0185 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0230  */
    /* JADX WARN: Type inference failed for: r8v22, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00fb -> B:15:0x00bd). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0186 -> B:15:0x00bd). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x01bb -> B:110:0x02db). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x0218 -> B:73:0x021c). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r29) {
        /*
            Method dump skipped, instructions count: 816
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.staticsticker.StaticStickerManager$downloadStickers$1$1$onComplete$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
