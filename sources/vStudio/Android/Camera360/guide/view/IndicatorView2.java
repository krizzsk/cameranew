package vStudio.Android.Camera360.guide.view;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.util.c;
import vStudio.Android.Camera360.R;
/* compiled from: IndicatorView2.kt */
/* loaded from: classes7.dex */
public final class IndicatorView2 extends RelativeLayout {
    public Map<Integer, View> _$_findViewCache;
    private int indicatorColor;
    private int indicatorHeight;
    private int indicatorIdleWidth;
    private int indicatorRadius;
    private int indicatorSelectedWidth;
    private int indicatorSpace;
    private int pageCount;
    private int selectedIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IndicatorView2(Context context) {
        super(context);
        s.h(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.pageCount = 3;
        this.indicatorIdleWidth = 30;
        this.indicatorSelectedWidth = 30;
        this.indicatorSpace = 30;
        this.indicatorHeight = 30;
        addIndicators(0);
    }

    private final void addIndicators(int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            addView(createIndicator(i3));
        }
    }

    private final Rect computeIndicatorRect(int i2) {
        int i3;
        int i4;
        int i5;
        View childAt = getChildAt(i2);
        Rect rect = new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
        int i6 = this.selectedIndex;
        if (i2 < i6) {
            int i7 = this.indicatorIdleWidth;
            i4 = i2 * (this.indicatorSpace + i7);
            i5 = i7 + i4;
            childAt.setBackground(getResources().getDrawable(R.drawable.shape_round_indicator_unselected));
        } else {
            if (i2 == i6) {
                childAt.setBackground(getResources().getDrawable(R.drawable.shape_round_indicator_selected));
                i4 = i2 * (this.indicatorIdleWidth + this.indicatorSpace);
                i3 = this.indicatorSelectedWidth;
            } else {
                childAt.setBackground(getResources().getDrawable(R.drawable.shape_round_indicator_unselected));
                i3 = this.indicatorIdleWidth;
                i4 = ((i2 * (this.indicatorSpace + i3)) - i3) + this.indicatorSelectedWidth;
            }
            i5 = i4 + i3;
        }
        rect.left = i4;
        rect.right = i5;
        return rect;
    }

    private final View createIndicator(int i2) {
        Drawable drawable;
        View view = new View(getContext());
        view.setLayoutParams(new RelativeLayout.LayoutParams(this.indicatorIdleWidth, this.indicatorHeight));
        if (i2 == this.selectedIndex) {
            drawable = getResources().getDrawable(R.drawable.shape_round_indicator_selected);
        } else {
            drawable = getResources().getDrawable(R.drawable.shape_round_indicator_unselected);
        }
        if (c.c) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
        return view;
    }

    private final void updateIndicatorRect() {
        int childCount = getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            int i3 = i2 + 1;
            Rect computeIndicatorRect = computeIndicatorRect(i2);
            final View childAt = getChildAt(i2);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(childAt.getTranslationX(), computeIndicatorRect.left);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: vStudio.Android.Camera360.guide.view.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IndicatorView2.m202updateIndicatorRect$lambda0(childAt, valueAnimator);
                }
            });
            ValueAnimator ofInt = ValueAnimator.ofInt(childAt.getWidth(), computeIndicatorRect.width());
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: vStudio.Android.Camera360.guide.view.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IndicatorView2.m203updateIndicatorRect$lambda1(childAt, valueAnimator);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofInt);
            animatorSet.start();
            i2 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateIndicatorRect$lambda-0  reason: not valid java name */
    public static final void m202updateIndicatorRect$lambda0(View view, ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setTranslationX(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateIndicatorRect$lambda-1  reason: not valid java name */
    public static final void m203updateIndicatorRect$lambda1(View view, ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = intValue;
        view.setLayoutParams(layoutParams);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
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

    public final void selectIndex(int i2) {
        this.selectedIndex = i2;
        updateIndicatorRect();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IndicatorView2(Context context, AttributeSet attributes) {
        super(context, attributes);
        s.h(context, "context");
        s.h(attributes, "attributes");
        this._$_findViewCache = new LinkedHashMap();
        this.pageCount = 3;
        this.indicatorIdleWidth = 30;
        this.indicatorSelectedWidth = 30;
        this.indicatorSpace = 30;
        this.indicatorHeight = 30;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributes, R.styleable.IndicatorView2, 0, 0);
        s.g(obtainStyledAttributes, "theme.obtainStyledAttrib…ble.IndicatorView2, 0, 0)");
        this.pageCount = obtainStyledAttributes.getInteger(1, 2);
        this.indicatorIdleWidth = obtainStyledAttributes.getDimensionPixelSize(3, 16);
        this.indicatorSelectedWidth = obtainStyledAttributes.getDimensionPixelSize(5, 16);
        this.indicatorSpace = obtainStyledAttributes.getDimensionPixelSize(6, 16);
        this.indicatorHeight = obtainStyledAttributes.getDimensionPixelSize(2, 16);
        this.indicatorColor = obtainStyledAttributes.getColor(0, 0);
        this.indicatorRadius = obtainStyledAttributes.getDimensionPixelSize(4, 8);
        addIndicators(this.pageCount);
    }
}
