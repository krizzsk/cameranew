package us.pinguo.camera2020.view;

import android.content.res.Resources;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.module.sticker.CameraStickerModule;
import us.pinguo.repository2020.database.sticker.Sticker;
import us.pinguo.ui.widget.StickySeekBar;
/* compiled from: StickerViewController.kt */
@DebugMetadata(c = "us.pinguo.camera2020.view.StickerViewController$changeAdjustBarStyle$1", f = "StickerViewController.kt", i = {}, l = {467, 468}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class StickerViewController$changeAdjustBarStyle$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ boolean $isDark;
    final /* synthetic */ StickerLayout $layout;
    final /* synthetic */ CameraStickerModule $module;
    final /* synthetic */ String $type;
    int label;
    final /* synthetic */ StickerViewController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StickerViewController.kt */
    @DebugMetadata(c = "us.pinguo.camera2020.view.StickerViewController$changeAdjustBarStyle$1$1", f = "StickerViewController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.camera2020.view.StickerViewController$changeAdjustBarStyle$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ int $defaultValue;
        final /* synthetic */ boolean $isDark;
        final /* synthetic */ StickerLayout $layout;
        final /* synthetic */ CameraStickerModule $module;
        final /* synthetic */ String $type;
        int label;
        final /* synthetic */ StickerViewController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StickerLayout stickerLayout, String str, CameraStickerModule cameraStickerModule, int i2, StickerViewController stickerViewController, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$layout = stickerLayout;
            this.$type = str;
            this.$module = cameraStickerModule;
            this.$defaultValue = i2;
            this.this$0 = stickerViewController;
            this.$isDark = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$layout, this.$type, this.$module, this.$defaultValue, this.this$0, this.$isDark, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z;
            Resources resources;
            int i2;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                StickerLayout stickerLayout = this.$layout;
                String str = this.$type;
                Integer s = this.$module.s(str);
                int i3 = this.$defaultValue;
                z = this.this$0.f9309f;
                stickerLayout.g(str, s, i3, z);
                if (this.$isDark) {
                    resources = this.$layout.getResources();
                    i2 = R.color.color_camera_theme_black;
                } else {
                    resources = this.$layout.getResources();
                    i2 = R.color.color_camera_theme_light;
                }
                int color = resources.getColor(i2);
                StickerLayout stickerLayout2 = this.$layout;
                int i4 = R.id.stickerAdjustBar;
                ((StickySeekBar) stickerLayout2._$_findCachedViewById(i4)).setMainColor(color);
                ((StickySeekBar) this.$layout._$_findCachedViewById(i4)).setIndicatorColor(color);
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerViewController$changeAdjustBarStyle$1(CameraStickerModule cameraStickerModule, String str, StickerLayout stickerLayout, StickerViewController stickerViewController, boolean z, Continuation<? super StickerViewController$changeAdjustBarStyle$1> continuation) {
        super(2, continuation);
        this.$module = cameraStickerModule;
        this.$type = str;
        this.$layout = stickerLayout;
        this.this$0 = stickerViewController;
        this.$isDark = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new StickerViewController$changeAdjustBarStyle$1(this.$module, this.$type, this.$layout, this.this$0, this.$isDark, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((StickerViewController$changeAdjustBarStyle$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            CameraStickerModule cameraStickerModule = this.$module;
            String str = this.$type;
            Sticker value = cameraStickerModule.u().getValue();
            String pid = value == null ? null : value.getPid();
            this.label = 1;
            obj = cameraStickerModule.v(str, pid, this);
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
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$layout, this.$type, this.$module, intValue, this.this$0, this.$isDark, null);
        this.label = 2;
        if (kotlinx.coroutines.j.g(c, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return kotlin.u.a;
    }
}
