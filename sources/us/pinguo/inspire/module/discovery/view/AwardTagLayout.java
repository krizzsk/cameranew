package us.pinguo.inspire.module.discovery.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import us.pinguo.inspire.R;
/* compiled from: AwardTagLayout.kt */
/* loaded from: classes9.dex */
public final class AwardTagLayout extends LinearLayout {
    public Map<Integer, View> _$_findViewCache;

    public AwardTagLayout(Context context) {
        super(context);
        this._$_findViewCache = new LinkedHashMap();
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

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(32767, Integer.MIN_VALUE);
        int size = View.MeasureSpec.getSize(i2);
        int i4 = R.id.task_list_title;
        ((TextView) _$_findCachedViewById(i4)).measure(makeMeasureSpec, makeMeasureSpec);
        int i5 = R.id.task_list_aware;
        ((TextView) _$_findCachedViewById(i5)).measure(makeMeasureSpec, makeMeasureSpec);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        ViewGroup.LayoutParams layoutParams2 = ((TextView) _$_findCachedViewById(i4)).getLayoutParams();
        if (((TextView) _$_findCachedViewById(i4)).getMeasuredWidth() + ((TextView) _$_findCachedViewById(i5)).getMeasuredWidth() + i6 < size) {
            layoutParams2.width = -2;
            ((TextView) _$_findCachedViewById(i4)).setLayoutParams(layoutParams2);
            super.onMeasure(i2, i3);
            return;
        }
        int measuredWidth = (size - i6) - ((TextView) _$_findCachedViewById(i5)).getMeasuredWidth();
        ViewGroup.LayoutParams layoutParams3 = ((TextView) _$_findCachedViewById(i4)).getLayoutParams();
        layoutParams3.width = measuredWidth;
        ((TextView) _$_findCachedViewById(i4)).setLayoutParams(layoutParams3);
        super.onMeasure(i2, i3);
    }

    public AwardTagLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this._$_findViewCache = new LinkedHashMap();
    }

    public AwardTagLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this._$_findViewCache = new LinkedHashMap();
    }
}
