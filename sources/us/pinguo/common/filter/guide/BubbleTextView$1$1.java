package us.pinguo.common.filter.guide;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BubbleTextView.kt */
/* loaded from: classes4.dex */
public final class BubbleTextView$1$1 extends Lambda implements l<MotionEvent, u> {
    final /* synthetic */ Context $context;
    final /* synthetic */ BubbleTextView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BubbleTextView.kt */
    /* renamed from: us.pinguo.common.filter.guide.BubbleTextView$1$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends Lambda implements l<Boolean, u> {
        final /* synthetic */ BubbleTextView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BubbleTextView bubbleTextView) {
            super(1);
            this.this$0 = bubbleTextView;
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ u invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return u.a;
        }

        public final void invoke(boolean z) {
            l<Boolean, u> d2 = this.this$0.d();
            if (d2 == null) {
                return;
            }
            d2.invoke(Boolean.valueOf(z));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleTextView$1$1(BubbleTextView bubbleTextView, Context context) {
        super(1);
        this.this$0 = bubbleTextView;
        this.$context = context;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(MotionEvent motionEvent) {
        invoke2(motionEvent);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(MotionEvent motionEvent) {
        FilterCollectionAnimControl filterCollectionAnimControl;
        if (this.this$0.f()) {
            this.this$0.getParent().requestDisallowInterceptTouchEvent(true);
            filterCollectionAnimControl = this.this$0.c;
            if (filterCollectionAnimControl == null) {
                filterCollectionAnimControl = new FilterCollectionAnimControl((Activity) this.$context);
                filterCollectionAnimControl.s(new AnonymousClass1(this.this$0));
            }
            BubbleTextView bubbleTextView = this.this$0;
            filterCollectionAnimControl.u(bubbleTextView, bubbleTextView.g());
            this.this$0.c = filterCollectionAnimControl;
        }
    }
}
