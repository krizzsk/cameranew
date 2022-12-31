package us.pinguo.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: FilterLayerOpacityAdjustSelector.kt */
/* loaded from: classes4.dex */
public final class FilterLayerOpacityAdjustSelector extends ConstraintLayout {
    public Map<Integer, View> a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FilterLayerOpacityAdjustSelector(Context context) {
        this(context, null, 0, 6, null);
        s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FilterLayerOpacityAdjustSelector(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        s.h(context, "context");
    }

    public /* synthetic */ FilterLayerOpacityAdjustSelector(Context context, AttributeSet attributeSet, int i2, int i3, o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public static /* synthetic */ void setIsSelected$default(FilterLayerOpacityAdjustSelector filterLayerOpacityAdjustSelector, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        filterLayerOpacityAdjustSelector.setIsSelected(z, z2);
    }

    public View _$_findCachedViewById(int i2) {
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

    public final void setIsSelected(boolean z, boolean z2) {
        setSelected(z);
        if (z) {
            int i2 = us.pinguo.commonui.R.id.vSelected;
            View vSelected = _$_findCachedViewById(i2);
            s.g(vSelected, "vSelected");
            vSelected.setVisibility(0);
            VdsAgent.onSetViewVisibility(vSelected, 0);
            if (z2) {
                ((AutofitTextView) _$_findCachedViewById(us.pinguo.commonui.R.id.tvFilterLayer)).setTextColor(getContext().getResources().getColor(us.pinguo.commonui.R.color.color_camera_theme_light));
                _$_findCachedViewById(i2).setBackground(getContext().getResources().getDrawable(us.pinguo.commonui.R.drawable.shape_point_selected_light));
                return;
            }
            ((AutofitTextView) _$_findCachedViewById(us.pinguo.commonui.R.id.tvFilterLayer)).setTextColor(getContext().getResources().getColor(us.pinguo.commonui.R.color.color_camera_theme_dark));
            _$_findCachedViewById(i2).setBackground(getContext().getResources().getDrawable(us.pinguo.commonui.R.drawable.shape_point_selected_dark));
            return;
        }
        View vSelected2 = _$_findCachedViewById(us.pinguo.commonui.R.id.vSelected);
        s.g(vSelected2, "vSelected");
        vSelected2.setVisibility(4);
        VdsAgent.onSetViewVisibility(vSelected2, 4);
        if (z2) {
            ((AutofitTextView) _$_findCachedViewById(us.pinguo.commonui.R.id.tvFilterLayer)).setTextColor(getContext().getResources().getColor(us.pinguo.commonui.R.color.white_60_alpha));
        } else {
            ((AutofitTextView) _$_findCachedViewById(us.pinguo.commonui.R.id.tvFilterLayer)).setTextColor(getContext().getResources().getColor(us.pinguo.commonui.R.color.color_camera_theme_dark));
        }
    }

    public final void setText(String text) {
        s.h(text, "text");
        ((AutofitTextView) _$_findCachedViewById(us.pinguo.commonui.R.id.tvFilterLayer)).setText(text);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterLayerOpacityAdjustSelector(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        this.a = new LinkedHashMap();
    }
}
