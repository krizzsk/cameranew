package us.pinguo.edit2020.controller;

import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.view.menuview.BeautySkinRefreshView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditBottomTabBeautyController.kt */
/* loaded from: classes4.dex */
public final class EditBottomTabBeautyController$skinRefreshTabSelectListener$1$onTabSelected$1$3 extends Lambda implements kotlin.jvm.b.l<String, kotlin.u> {
    final /* synthetic */ BeautySkinRefreshView $skinRefreshView;
    final /* synthetic */ EditBottomTabBeautyController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditBottomTabBeautyController.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.controller.EditBottomTabBeautyController$skinRefreshTabSelectListener$1$onTabSelected$1$3$1", f = "EditBottomTabBeautyController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.controller.EditBottomTabBeautyController$skinRefreshTabSelectListener$1$onTabSelected$1$3$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ String $it;
        final /* synthetic */ BeautySkinRefreshView $skinRefreshView;
        int label;
        final /* synthetic */ EditBottomTabBeautyController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(EditBottomTabBeautyController editBottomTabBeautyController, String str, BeautySkinRefreshView beautySkinRefreshView, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = editBottomTabBeautyController;
            this.$it = str;
            this.$skinRefreshView = beautySkinRefreshView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$it, this.$skinRefreshView, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            String str2;
            float floatValue;
            int maxValue;
            float defaultValue;
            float maxValue2;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                Float f0 = this.this$0.f10326e.f0(this.$it);
                String d0 = this.this$0.f10326e.d0(this.$it);
                if (f0 != null) {
                    EditBottomTabBeautyController editBottomTabBeautyController = this.this$0;
                    f0.floatValue();
                    us.pinguo.edit2020.bean.n0 s = editBottomTabBeautyController.f10326e.s();
                    if (s != null && d0 != null) {
                        if (kotlin.jvm.internal.s.a(f0, -1.0f)) {
                            if (kotlin.jvm.internal.s.c(d0, editBottomTabBeautyController.B)) {
                                defaultValue = s.g().getDefaultValue() / s.g().getMaxValue();
                                maxValue2 = editBottomTabBeautyController.C;
                            } else {
                                defaultValue = s.g().getDefaultValue();
                                maxValue2 = s.g().getMaxValue();
                            }
                            editBottomTabBeautyController.f10326e.v0(d0, defaultValue / maxValue2);
                            if (kotlin.jvm.internal.s.c(s.f(), d0)) {
                                editBottomTabBeautyController.c.I(s.g().getMinValue(), s.g().getMaxValue(), s.g().getDefaultValue(), s.g().getDefaultValue());
                            }
                        } else if (kotlin.jvm.internal.s.c(s.f(), d0)) {
                            if (kotlin.jvm.internal.s.c(d0, editBottomTabBeautyController.B)) {
                                floatValue = f0.floatValue() * editBottomTabBeautyController.C;
                                maxValue = s.g().getMaxValue();
                            } else {
                                floatValue = f0.floatValue();
                                maxValue = s.g().getMaxValue();
                            }
                            editBottomTabBeautyController.c.I(s.g().getMinValue(), s.g().getMaxValue(), (int) (floatValue * maxValue), s.g().getDefaultValue());
                        }
                    }
                }
                if (d0 != null) {
                    EditBottomTabBeautyController editBottomTabBeautyController2 = this.this$0;
                    str = editBottomTabBeautyController2.J;
                    if (str != null) {
                        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
                        str2 = editBottomTabBeautyController2.J;
                        iVar.l0(d0, str2);
                        editBottomTabBeautyController2.J = null;
                    }
                }
                this.this$0.f10326e.g0(this.$it);
                this.$skinRefreshView.u();
                us.pinguo.edit2020.bean.n0 s2 = this.this$0.f10326e.s();
                if (s2 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) this.this$0.b.findViewById(R.id.flSeekBar);
                    kotlin.jvm.internal.s.g(relativeLayout, "fragmentLayout.flSeekBar");
                    int i2 = s2.e() ^ true ? 4 : 0;
                    relativeLayout.setVisibility(i2);
                    VdsAgent.onSetViewVisibility(relativeLayout, i2);
                }
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditBottomTabBeautyController$skinRefreshTabSelectListener$1$onTabSelected$1$3(EditBottomTabBeautyController editBottomTabBeautyController, BeautySkinRefreshView beautySkinRefreshView) {
        super(1);
        this.this$0 = editBottomTabBeautyController;
        this.$skinRefreshView = beautySkinRefreshView;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(String str) {
        invoke2(str);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String it) {
        LifecycleOwner lifecycleOwner;
        kotlin.jvm.internal.s.h(it, "it");
        lifecycleOwner = this.this$0.a;
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), kotlinx.coroutines.z0.c(), null, new AnonymousClass1(this.this$0, it, this.$skinRefreshView, null), 2, null);
    }
}
