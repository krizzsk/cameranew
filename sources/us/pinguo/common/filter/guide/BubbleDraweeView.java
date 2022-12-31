package us.pinguo.common.filter.guide;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.view.GestureDetectorCompat;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.LinkedHashMap;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: BubbleDraweeView.kt */
/* loaded from: classes4.dex */
public final class BubbleDraweeView extends SimpleDraweeView {

    /* renamed from: i  reason: collision with root package name */
    private PointF f9850i;

    /* renamed from: j  reason: collision with root package name */
    private GestureDetectorCompat f9851j;

    /* renamed from: k  reason: collision with root package name */
    private FilterCollectionAnimControl f9852k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f9853l;
    private boolean m;
    private boolean n;
    private kotlin.jvm.b.a<u> o;
    private l<? super Boolean, u> p;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BubbleDraweeView(Context context) {
        this(context, null, 0, 6, null);
        s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BubbleDraweeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        s.h(context, "context");
    }

    public /* synthetic */ BubbleDraweeView(Context context, AttributeSet attributeSet, int i2, int i3, o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        FilterCollectionAnimControl filterCollectionAnimControl;
        boolean z = false;
        if (motionEvent == null) {
            return false;
        }
        this.f9851j.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            PointF pointF = this.f9850i;
            pointF.x = x;
            pointF.y = y;
        } else if (action == 1) {
            FilterCollectionAnimControl filterCollectionAnimControl2 = this.f9852k;
            if (filterCollectionAnimControl2 != null) {
                filterCollectionAnimControl2.h();
            }
            getParent().requestDisallowInterceptTouchEvent(false);
        } else if (action != 2) {
            if (action == 3) {
                FilterCollectionAnimControl filterCollectionAnimControl3 = this.f9852k;
                if (filterCollectionAnimControl3 != null) {
                    filterCollectionAnimControl3.h();
                }
            } else if (action != 4) {
                return false;
            } else {
                FilterCollectionAnimControl filterCollectionAnimControl4 = this.f9852k;
                if (filterCollectionAnimControl4 != null) {
                    filterCollectionAnimControl4.h();
                }
            }
        } else if (y - this.f9850i.y < 0.0f) {
            FilterCollectionAnimControl filterCollectionAnimControl5 = this.f9852k;
            if (filterCollectionAnimControl5 != null && filterCollectionAnimControl5.p()) {
                z = true;
            }
            if (z && (filterCollectionAnimControl = this.f9852k) != null) {
                filterCollectionAnimControl.n(x, y);
            }
        }
        return true;
    }

    public final l<Boolean, u> p() {
        return this.p;
    }

    public final kotlin.jvm.b.a<u> q() {
        return this.o;
    }

    public final boolean r() {
        return this.n;
    }

    public final boolean s() {
        return this.f9853l;
    }

    public final void setCollected(boolean z) {
        this.f9853l = z;
    }

    public final void setDoCollectionCallback(l<? super Boolean, u> lVar) {
        this.p = lVar;
    }

    public final void setDownloaded(boolean z) {
        this.m = z;
    }

    public final void setOnClickCallback(kotlin.jvm.b.a<u> aVar) {
        this.o = aVar;
    }

    public final void setSelectCurrentItem(boolean z) {
        this.n = z;
    }

    public final boolean t() {
        return this.m;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleDraweeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        new LinkedHashMap();
        this.f9850i = new PointF();
        e eVar = new e();
        eVar.a(new BubbleDraweeView$1$1(this, context));
        eVar.b(new BubbleDraweeView$1$2(this));
        u uVar = u.a;
        this.f9851j = new GestureDetectorCompat(context, eVar);
    }
}
