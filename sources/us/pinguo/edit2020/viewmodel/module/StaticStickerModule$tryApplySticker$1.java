package us.pinguo.edit2020.viewmodel.module;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
import us.pinguo.repository2020.database.staticsticker.StaticSticker;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategory;
import us.pinguo.repository2020.database.staticsticker.StaticStickerManager;
import us.pinguo.repository2020.entity.MaterialInstallState;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerModule.kt */
@DebugMetadata(c = "us.pinguo.edit2020.viewmodel.module.StaticStickerModule$tryApplySticker$1", f = "StaticStickerModule.kt", i = {}, l = {474, 475}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class StaticStickerModule$tryApplySticker$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ kotlin.jvm.b.a<u> $applySuccess;
    final /* synthetic */ StaticStickerCategory $category;
    final /* synthetic */ boolean $history;
    final /* synthetic */ String $sid;
    final /* synthetic */ StaticSticker $sticker;
    int label;
    final /* synthetic */ StaticStickerModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StaticStickerModule.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.viewmodel.module.StaticStickerModule$tryApplySticker$1$1", f = "StaticStickerModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.viewmodel.module.StaticStickerModule$tryApplySticker$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ kotlin.jvm.b.a<u> $applySuccess;
        final /* synthetic */ StaticStickerCategory $category;
        final /* synthetic */ boolean $history;
        final /* synthetic */ boolean $needUpdate;
        final /* synthetic */ StaticSticker $sticker;
        int label;
        final /* synthetic */ StaticStickerModule this$0;

        /* compiled from: StaticStickerModule.kt */
        /* renamed from: us.pinguo.edit2020.viewmodel.module.StaticStickerModule$tryApplySticker$1$1$a */
        /* loaded from: classes4.dex */
        public static final class a implements l<Integer, u> {
            final /* synthetic */ StaticSticker a;

            a(StaticSticker staticSticker) {
                this.a = staticSticker;
            }

            public void a(int i2) {
                ObservableInt downloadProgress = this.a.getDownloadProgress();
                if (downloadProgress == null) {
                    return;
                }
                downloadProgress.set(i2);
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ u invoke(Integer num) {
                a(num.intValue());
                return u.a;
            }
        }

        /* compiled from: StaticStickerModule.kt */
        /* renamed from: us.pinguo.edit2020.viewmodel.module.StaticStickerModule$tryApplySticker$1$1$b */
        /* loaded from: classes4.dex */
        public static final class b implements l<Boolean, u> {
            final /* synthetic */ StaticSticker a;
            final /* synthetic */ StaticStickerModule b;
            final /* synthetic */ StaticStickerCategory c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.b.a<u> f10881d;

            b(StaticSticker staticSticker, StaticStickerModule staticStickerModule, StaticStickerCategory staticStickerCategory, kotlin.jvm.b.a<u> aVar) {
                this.a = staticSticker;
                this.b = staticStickerModule;
                this.c = staticStickerCategory;
                this.f10881d = aVar;
            }

            public void a(boolean z) {
                if (z) {
                    ObservableField<MaterialInstallState> installState = this.a.getInstallState();
                    if (installState != null) {
                        installState.set(MaterialInstallState.STATE_INSTALLED);
                    }
                    this.b.f(this.a, this.c, false);
                    kotlin.jvm.b.a<u> aVar = this.f10881d;
                    if (aVar == null) {
                        return;
                    }
                    aVar.invoke();
                    return;
                }
                ObservableField<MaterialInstallState> installState2 = this.a.getInstallState();
                if (installState2 == null) {
                    return;
                }
                installState2.set(MaterialInstallState.STATE_UNDOWNLOAD);
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ u invoke(Boolean bool) {
                a(bool.booleanValue());
                return u.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, StaticStickerModule staticStickerModule, StaticSticker staticSticker, StaticStickerCategory staticStickerCategory, boolean z2, kotlin.jvm.b.a<u> aVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$needUpdate = z;
            this.this$0 = staticStickerModule;
            this.$sticker = staticSticker;
            this.$category = staticStickerCategory;
            this.$history = z2;
            this.$applySuccess = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$needUpdate, this.this$0, this.$sticker, this.$category, this.$history, this.$applySuccess, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            StaticStickerManager staticStickerManager;
            ArrayList f2;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                j.b(obj);
                if (this.$needUpdate) {
                    staticStickerManager = this.this$0.q;
                    f2 = kotlin.collections.u.f(this.$sticker);
                    StaticSticker staticSticker = this.$sticker;
                    staticStickerManager.l(f2, 0, new a(staticSticker), new b(staticSticker, this.this$0, this.$category, this.$applySuccess));
                } else {
                    this.this$0.f(this.$sticker, this.$category, this.$history);
                    kotlin.jvm.b.a<u> aVar = this.$applySuccess;
                    if (aVar != null) {
                        aVar.invoke();
                    }
                }
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerModule$tryApplySticker$1(StaticStickerModule staticStickerModule, String str, StaticSticker staticSticker, StaticStickerCategory staticStickerCategory, boolean z, kotlin.jvm.b.a<u> aVar, Continuation<? super StaticStickerModule$tryApplySticker$1> continuation) {
        super(2, continuation);
        this.this$0 = staticStickerModule;
        this.$sid = str;
        this.$sticker = staticSticker;
        this.$category = staticStickerCategory;
        this.$history = z;
        this.$applySuccess = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StaticStickerModule$tryApplySticker$1(this.this$0, this.$sid, this.$sticker, this.$category, this.$history, this.$applySuccess, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StaticStickerModule$tryApplySticker$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        StaticStickerManager staticStickerManager;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            staticStickerManager = this.this$0.q;
            String str = this.$sid;
            this.label = 1;
            obj = staticStickerManager.G(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j.b(obj);
            return u.a;
        } else {
            j.b(obj);
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        g2 c = z0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(booleanValue, this.this$0, this.$sticker, this.$category, this.$history, this.$applySuccess, null);
        this.label = 2;
        if (kotlinx.coroutines.j.g(c, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return u.a;
    }
}
