package us.pinguo.common.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: SkyChangeGuideView.kt */
/* loaded from: classes4.dex */
public final class SkyChangeGuideView extends LinearLayout {
    public Map<Integer, View> a;
    private final View b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkyChangeGuideView(Context context) {
        super(context);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        View inflate = LayoutInflater.from(getContext()).inflate(us.pinguo.commonui.R.layout.sky_change_guide_layout, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(us.pinguo.commonui.R.id.vHole);
        s.g(findViewById, "view.vHole");
        this.b = findViewById;
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: us.pinguo.common.widget.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean b;
                b = SkyChangeGuideView.b(SkyChangeGuideView.this, view, motionEvent);
                return b;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(SkyChangeGuideView this$0, View view, MotionEvent motionEvent) {
        s.h(this$0, "this$0");
        Rect rect = new Rect();
        this$0.b.getGlobalVisibleRect(rect);
        return !rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    public View a(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    public final View c() {
        return this.b;
    }

    public final void e(int i2, int i3, int i4, int i5, boolean z) {
        ConstraintSet constraintSet = new ConstraintSet();
        int i6 = us.pinguo.commonui.R.id.clTapSky;
        constraintSet.clone((ConstraintLayout) a(i6));
        int i7 = us.pinguo.commonui.R.id.vHole;
        constraintSet.connect(i7, 6, i6, 6, i2);
        constraintSet.connect(i7, 3, i6, 3, i3);
        constraintSet.constrainWidth(i7, i4);
        constraintSet.constrainHeight(i7, i5);
        if (z) {
            constraintSet.setVisibility(((AppCompatImageView) a(us.pinguo.commonui.R.id.ivTapSky)).getId(), 8);
            constraintSet.setVisibility(((AutofitTextView) a(us.pinguo.commonui.R.id.tvTapSky)).getId(), 8);
        } else {
            int left = this.b.getLeft() + (this.b.getWidth() / 2);
            int a = (us.pinguo.foundation.l.b.a() - this.b.getRight()) + (this.b.getWidth() / 2);
            int i8 = us.pinguo.commonui.R.id.tvHole;
            if (left < ((AutofitTextView) a(i8)).getWidth() / 2) {
                constraintSet.connect(i8, 1, i7, 1);
                constraintSet.clear(i8, 2);
            } else if (a < ((AutofitTextView) a(i8)).getWidth() / 2) {
                constraintSet.connect(i8, 2, i7, 2);
                constraintSet.clear(i8, 1);
            }
        }
        constraintSet.applyTo((ConstraintLayout) a(i6));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkyChangeGuideView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        View inflate = LayoutInflater.from(getContext()).inflate(us.pinguo.commonui.R.layout.sky_change_guide_layout, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(us.pinguo.commonui.R.id.vHole);
        s.g(findViewById, "view.vHole");
        this.b = findViewById;
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: us.pinguo.common.widget.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean b;
                b = SkyChangeGuideView.b(SkyChangeGuideView.this, view, motionEvent);
                return b;
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkyChangeGuideView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        View inflate = LayoutInflater.from(getContext()).inflate(us.pinguo.commonui.R.layout.sky_change_guide_layout, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(us.pinguo.commonui.R.id.vHole);
        s.g(findViewById, "view.vHole");
        this.b = findViewById;
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: us.pinguo.common.widget.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean b;
                b = SkyChangeGuideView.b(SkyChangeGuideView.this, view, motionEvent);
                return b;
            }
        });
    }
}
