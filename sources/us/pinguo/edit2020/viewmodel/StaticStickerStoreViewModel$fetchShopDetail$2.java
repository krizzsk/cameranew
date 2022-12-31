package us.pinguo.edit2020.viewmodel;

import androidx.lifecycle.ViewModelKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import kotlinx.coroutines.channels.e;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
import us.pinguo.edit2020.utils.k;
import us.pinguo.repository2020.database.staticsticker.ShopDetail;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerStoreViewModel.kt */
/* loaded from: classes4.dex */
public final class StaticStickerStoreViewModel$fetchShopDetail$2 extends Lambda implements l<ShopDetail, u> {
    final /* synthetic */ StaticStickerStoreViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StaticStickerStoreViewModel.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel$fetchShopDetail$2$1", f = "StaticStickerStoreViewModel.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel$fetchShopDetail$2$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ ShopDetail $it;
        int label;
        final /* synthetic */ StaticStickerStoreViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StaticStickerStoreViewModel staticStickerStoreViewModel, ShopDetail shopDetail, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = staticStickerStoreViewModel;
            this.$it = shopDetail;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$it, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            e eVar;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                j.b(obj);
                eVar = this.this$0.c;
                k c = k.a.c(this.$it);
                this.label = 1;
                if (eVar.D(c, this) == coroutine_suspended) {
                    return coroutine_suspended;
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
    /* compiled from: StaticStickerStoreViewModel.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel$fetchShopDetail$2$2", f = "StaticStickerStoreViewModel.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.viewmodel.StaticStickerStoreViewModel$fetchShopDetail$2$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        int label;
        final /* synthetic */ StaticStickerStoreViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(StaticStickerStoreViewModel staticStickerStoreViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = staticStickerStoreViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass2) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            e eVar;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                j.b(obj);
                eVar = this.this$0.c;
                k a = k.a.a(new Exception());
                this.label = 1;
                if (eVar.D(a, this) == coroutine_suspended) {
                    return coroutine_suspended;
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
    public StaticStickerStoreViewModel$fetchShopDetail$2(StaticStickerStoreViewModel staticStickerStoreViewModel) {
        super(1);
        this.this$0 = staticStickerStoreViewModel;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(ShopDetail shopDetail) {
        invoke2(shopDetail);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ShopDetail shopDetail) {
        if (shopDetail != null) {
            kotlinx.coroutines.l.d(ViewModelKt.getViewModelScope(this.this$0), z0.c(), null, new AnonymousClass1(this.this$0, shopDetail, null), 2, null);
        } else {
            kotlinx.coroutines.l.d(ViewModelKt.getViewModelScope(this.this$0), z0.c(), null, new AnonymousClass2(this.this$0, null), 2, null);
        }
    }
}
