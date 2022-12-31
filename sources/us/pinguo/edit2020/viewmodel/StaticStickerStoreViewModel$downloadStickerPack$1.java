package us.pinguo.edit2020.viewmodel;

import androidx.lifecycle.ViewModelKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.channels.e;
import kotlinx.coroutines.l;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategory;
import us.pinguo.repository2020.database.staticsticker.StaticStickerManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerStoreViewModel.kt */
/* loaded from: classes4.dex */
public final class StaticStickerStoreViewModel$downloadStickerPack$1 extends Lambda implements p<String, Integer, u> {
    final /* synthetic */ StaticStickerCategory $stickerCategory;
    final /* synthetic */ StaticStickerStoreViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StaticStickerStoreViewModel.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel$downloadStickerPack$1$1", f = "StaticStickerStoreViewModel.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel$downloadStickerPack$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ int $progress;
        final /* synthetic */ StaticStickerCategory $stickerCategory;
        int label;
        final /* synthetic */ StaticStickerStoreViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StaticStickerStoreViewModel staticStickerStoreViewModel, int i2, StaticStickerCategory staticStickerCategory, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = staticStickerStoreViewModel;
            this.$progress = i2;
            this.$stickerCategory = staticStickerCategory;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$progress, this.$stickerCategory, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            e eVar;
            e eVar2;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                j.b(obj);
                if (!this.this$0.u()) {
                    eVar2 = this.this$0.f10821i;
                    Integer boxInt = Boxing.boxInt(this.$progress);
                    this.label = 1;
                    if (eVar2.D(boxInt, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (this.$progress == 100) {
                        StaticStickerManager staticStickerManager = StaticStickerManager.a;
                        String pid = this.$stickerCategory.getPid();
                        if (pid == null) {
                            pid = "";
                        }
                        staticStickerManager.i(pid);
                    }
                    eVar = this.this$0.f10821i;
                    eVar.poll();
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                j.b(obj);
            }
            return u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerStoreViewModel$downloadStickerPack$1(StaticStickerStoreViewModel staticStickerStoreViewModel, StaticStickerCategory staticStickerCategory) {
        super(2);
        this.this$0 = staticStickerStoreViewModel;
        this.$stickerCategory = staticStickerCategory;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(String str, Integer num) {
        invoke(str, num.intValue());
        return u.a;
    }

    public final void invoke(String noName_0, int i2) {
        s.h(noName_0, "$noName_0");
        l.d(ViewModelKt.getViewModelScope(this.this$0), z0.c(), null, new AnonymousClass1(this.this$0, i2, this.$stickerCategory, null), 2, null);
    }
}
