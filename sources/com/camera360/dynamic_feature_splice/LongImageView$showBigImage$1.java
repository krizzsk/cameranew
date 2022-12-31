package com.camera360.dynamic_feature_splice;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.LinearLayout;
import com.tencent.bugly.crashreport.CrashReport;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.g2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LongImageView.kt */
@DebugMetadata(c = "com.camera360.dynamic_feature_splice.LongImageView$showBigImage$1", f = "LongImageView.kt", i = {}, l = {69, 70}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
public final class LongImageView$showBigImage$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ String $path;
    int label;
    final /* synthetic */ LongImageView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LongImageView.kt */
    @DebugMetadata(c = "com.camera360.dynamic_feature_splice.LongImageView$showBigImage$1$1", f = "LongImageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.camera360.dynamic_feature_splice.LongImageView$showBigImage$1$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ ArrayList<Bitmap> $list;
        int label;
        final /* synthetic */ LongImageView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LongImageView longImageView, ArrayList<Bitmap> arrayList, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = longImageView;
            this.$list = arrayList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$list, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z;
            LinearLayout linearLayout;
            boolean z2;
            LinearLayout linearLayout2;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                z = this.this$0.f2137f;
                if (z) {
                    return kotlin.u.a;
                }
                if (!this.$list.isEmpty()) {
                    linearLayout = this.this$0.f2136e;
                    linearLayout.removeAllViews();
                    Context context = this.this$0.getContext();
                    if (context == null) {
                        return kotlin.u.a;
                    }
                    ArrayList<Bitmap> arrayList = this.$list;
                    LongImageView longImageView = this.this$0;
                    for (Bitmap bitmap : arrayList) {
                        z2 = longImageView.f2137f;
                        if (z2) {
                            return kotlin.u.a;
                        }
                        ImageCell imageCell = new ImageCell(context, bitmap);
                        linearLayout2 = longImageView.f2136e;
                        linearLayout2.addView(imageCell, -1, -2);
                    }
                    return kotlin.u.a;
                }
                CrashReport.postCatchedException(new RuntimeException("Splice Big Image --- Empty"));
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongImageView$showBigImage$1(LongImageView longImageView, String str, Continuation<? super LongImageView$showBigImage$1> continuation) {
        super(2, continuation);
        this.this$0 = longImageView;
        this.$path = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new LongImageView$showBigImage$1(this.this$0, this.$path, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((LongImageView$showBigImage$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            LongImageView longImageView = this.this$0;
            String str = this.$path;
            this.label = 1;
            obj = longImageView.p(str, this);
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
        g2 c = kotlinx.coroutines.z0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, (ArrayList) obj, null);
        this.label = 2;
        if (kotlinx.coroutines.j.g(c, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return kotlin.u.a;
    }
}
