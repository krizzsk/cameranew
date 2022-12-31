package us.pinguo.common.filter.guide;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.GestureDetectorCompat;
import java.util.LinkedHashMap;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: BubbleTextView.kt */
/* loaded from: classes4.dex */
public final class BubbleTextView extends AppCompatTextView {
    private PointF a;
    private GestureDetectorCompat b;
    private FilterCollectionAnimControl c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9854d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9855e;

    /* renamed from: f  reason: collision with root package name */
    private kotlin.jvm.b.a<u> f9856f;

    /* renamed from: g  reason: collision with root package name */
    private l<? super Boolean, u> f9857g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BubbleTextView(Context context) {
        this(context, null, 0, 6, null);
        s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BubbleTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        s.h(context, "context");
    }

    public /* synthetic */ BubbleTextView(Context context, AttributeSet attributeSet, int i2, int i3, o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final l<Boolean, u> d() {
        return this.f9857g;
    }

    public final kotlin.jvm.b.a<u> e() {
        return this.f9856f;
    }

    public final boolean f() {
        return this.f9855e;
    }

    public final boolean g() {
        return this.f9854d;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        FilterCollectionAnimControl filterCollectionAnimControl;
        boolean z = false;
        if (motionEvent == null) {
            return false;
        }
        this.b.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            PointF pointF = this.a;
            pointF.x = x;
            pointF.y = y;
        } else if (action == 1) {
            FilterCollectionAnimControl filterCollectionAnimControl2 = this.c;
            if (filterCollectionAnimControl2 != null) {
                filterCollectionAnimControl2.h();
            }
            getParent().requestDisallowInterceptTouchEvent(false);
        } else if (action != 2) {
            if (action == 3) {
                FilterCollectionAnimControl filterCollectionAnimControl3 = this.c;
                if (filterCollectionAnimControl3 != null) {
                    filterCollectionAnimControl3.h();
                }
            } else if (action != 4) {
                return false;
            } else {
                FilterCollectionAnimControl filterCollectionAnimControl4 = this.c;
                if (filterCollectionAnimControl4 != null) {
                    filterCollectionAnimControl4.h();
                }
            }
        } else if (y - this.a.y < 0.0f) {
            FilterCollectionAnimControl filterCollectionAnimControl5 = this.c;
            if (filterCollectionAnimControl5 != null && filterCollectionAnimControl5.p()) {
                z = true;
            }
            if (z && (filterCollectionAnimControl = this.c) != null) {
                filterCollectionAnimControl.n(x, y);
            }
        }
        return true;
    }

    public final void setCollected(boolean z) {
        this.f9854d = z;
    }

    public final void setDoCollectionCallback(l<? super Boolean, u> lVar) {
        this.f9857g = lVar;
    }

    public final void setOnClickCallback(kotlin.jvm.b.a<u> aVar) {
        this.f9856f = aVar;
    }

    public final void setSelectCurrentItem(boolean z) {
        this.f9855e = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        new LinkedHashMap();
        this.a = new PointF();
        e eVar = new e();
        eVar.a(new BubbleTextView$1$1(this, context));
        eVar.b(new BubbleTextView$1$2(this));
        u uVar = u.a;
        this.b = new GestureDetectorCompat(context, eVar);
    }
}
