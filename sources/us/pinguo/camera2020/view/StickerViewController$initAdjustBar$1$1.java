package us.pinguo.camera2020.view;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.camera2020.module.sticker.CameraStickerModule;
import us.pinguo.repository2020.database.sticker.Sticker;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerViewController.kt */
@DebugMetadata(c = "us.pinguo.camera2020.view.StickerViewController$initAdjustBar$1$1", f = "StickerViewController.kt", i = {}, l = {361, 362}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class StickerViewController$initAdjustBar$1$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ StickerLayout $layout;
    final /* synthetic */ CameraStickerModule $module;
    final /* synthetic */ String $type;
    int label;
    final /* synthetic */ StickerViewController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StickerViewController.kt */
    @DebugMetadata(c = "us.pinguo.camera2020.view.StickerViewController$initAdjustBar$1$1$1", f = "StickerViewController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.camera2020.view.StickerViewController$initAdjustBar$1$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ int $defaultValue;
        final /* synthetic */ StickerLayout $layout;
        final /* synthetic */ CameraStickerModule $module;
        final /* synthetic */ String $type;
        int label;
        final /* synthetic */ StickerViewController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StickerLayout stickerLayout, String str, CameraStickerModule cameraStickerModule, int i2, StickerViewController stickerViewController, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$layout = stickerLayout;
            this.$type = str;
            this.$module = cameraStickerModule;
            this.$defaultValue = i2;
            this.this$0 = stickerViewController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$layout, this.$type, this.$module, this.$defaultValue, this.this$0, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                StickerLayout stickerLayout = this.$layout;
                String type = this.$type;
                kotlin.jvm.internal.s.g(type, "type");
                CameraStickerModule cameraStickerModule = this.$module;
                String type2 = this.$type;
                kotlin.jvm.internal.s.g(type2, "type");
                Integer s = cameraStickerModule.s(type2);
                int i2 = this.$defaultValue;
                z = this.this$0.f9309f;
                stickerLayout.g(type, s, i2, z);
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerViewController$initAdjustBar$1$1(CameraStickerModule cameraStickerModule, String str, StickerLayout stickerLayout, StickerViewController stickerViewController, Continuation<? super StickerViewController$initAdjustBar$1$1> continuation) {
        super(2, continuation);
        this.$module = cameraStickerModule;
        this.$type = str;
        this.$layout = stickerLayout;
        this.this$0 = stickerViewController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new StickerViewController$initAdjustBar$1$1(this.$module, this.$type, this.$layout, this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((StickerViewController$initAdjustBar$1$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            CameraStickerModule cameraStickerModule = this.$module;
            String type = this.$type;
            kotlin.jvm.internal.s.g(type, "type");
            Sticker value = this.$module.u().getValue();
            String pid = value == null ? null : value.getPid();
            this.label = 1;
            obj = cameraStickerModule.v(type, pid, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.j.b(obj);
            return kotlin.u.a;
        } else {
            kotlin.j.b(obj);
        }
        int intValue = ((Number) obj).intValue();
        kotlinx.coroutines.g2 c = kotlinx.coroutines.z0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$layout, this.$type, this.$module, intValue, this.this$0, null);
        this.label = 2;
        if (kotlinx.coroutines.j.g(c, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return kotlin.u.a;
    }
}
