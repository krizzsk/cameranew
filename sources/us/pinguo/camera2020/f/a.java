package us.pinguo.camera2020.f;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.camera2020.R;
import us.pinguo.repository2020.entity.BeautyData;
import us.pinguo.repository2020.entity.Material;
/* compiled from: BeautyBindingAdapter.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    @BindingAdapter({"isDark", "adjustType"})
    public static final void a(ImageView view, boolean z, int i2) {
        s.h(view, "view");
        int id = view.getId();
        if (id == R.id.ivStyleMakeupAdjust) {
            if (i2 == 0) {
                if (z) {
                    view.setImageResource(R.drawable.ic_sticker_makeup_adjust_selected_dark);
                } else {
                    view.setImageResource(R.drawable.ic_sticker_makeup_adjust_selected_light);
                }
            } else if (z) {
                view.setImageResource(R.drawable.ic_sticker_makeup_adjust_dark);
            } else {
                view.setImageResource(R.drawable.ic_sticker_makeup_adjust_light);
            }
        } else if (id == R.id.ivFilterAdjust) {
            if (i2 == 3) {
                if (z) {
                    view.setImageResource(R.drawable.ic_sticker_filter_adjust_selected_dark);
                } else {
                    view.setImageResource(R.drawable.ic_sticker_filter_adjust_selected_light);
                }
            } else if (z) {
                view.setImageResource(R.drawable.ic_sticker_filter_adjust_dark);
            } else {
                view.setImageResource(R.drawable.ic_sticker_filter_adjust_light);
            }
        }
    }

    @BindingAdapter({"beautyIcon", "isDark", "isSelected"})
    public static final void b(AppCompatImageView view, BeautyData beautyData, boolean z, boolean z2) {
        boolean C;
        boolean C2;
        s.h(view, "view");
        s.h(beautyData, "beautyData");
        view.setImageResource(beautyData.getBeautyIcon());
        if (beautyData.getBeautyType() != 1 || beautyData.isGroup()) {
            view.setBackgroundDrawable(null);
            if (!z2) {
                us.pinguo.common.filter.util.b.a.a(view, R.color.beauty_text_color_dark);
                return;
            } else if (z) {
                us.pinguo.common.filter.util.b.a.a(view, R.color.beauty_text_color_dark_select);
                return;
            } else {
                us.pinguo.common.filter.util.b.a.a(view, R.color.beauty_text_color_white_select);
                return;
            }
        }
        if (z) {
            C2 = StringsKt__StringsKt.C(beautyData.getBeautyKey(), Material.MATERIAL_SELECT_NONE_FLAG, false, 2, null);
            if (C2) {
                view.setImageResource(R.drawable.ic_makeup_none_dark);
            }
        } else {
            C = StringsKt__StringsKt.C(beautyData.getBeautyKey(), Material.MATERIAL_SELECT_NONE_FLAG, false, 2, null);
            if (C) {
                view.setImageResource(R.drawable.ic_makeup_none_light);
            }
        }
        if (!z2) {
            view.setBackgroundDrawable(null);
        } else if (z) {
            view.setBackgroundDrawable(view.getResources().getDrawable(R.drawable.shape_round_selected_dark));
        } else {
            view.setBackgroundDrawable(view.getResources().getDrawable(R.drawable.shape_round_selected_light));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0030, code lost:
        if (r0 == false) goto L11;
     */
    @androidx.databinding.BindingAdapter({"beautySeekBar"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(us.pinguo.ui.widget.StickySeekBar r8, us.pinguo.repository2020.entity.BeautyData r9) {
        /*
            java.lang.String r0 = "view"
            kotlin.jvm.internal.s.h(r8, r0)
            us.pinguo.repository2020.entity.BeautyData$BeautyType r0 = us.pinguo.repository2020.entity.BeautyData.BeautyType
            us.pinguo.repository2020.entity.BeautyData r0 = r0.getNoneBeauty()
            boolean r0 = kotlin.jvm.internal.s.c(r9, r0)
            r1 = 8
            java.lang.String r2 = "null cannot be cast to non-null type android.view.ViewGroup"
            if (r0 != 0) goto L88
            if (r9 != 0) goto L19
            goto L97
        L19:
            androidx.databinding.ObservableBoolean r0 = r9.isSelected()
            boolean r0 = r0.get()
            r3 = 0
            r4 = 0
            if (r0 == 0) goto L32
            java.lang.String r0 = r9.getBeautyKey()
            r5 = 2
            java.lang.String r6 = "wu"
            boolean r0 = kotlin.text.l.C(r0, r6, r4, r5, r3)
            if (r0 != 0) goto L42
        L32:
            boolean r0 = r9.isGroup()
            if (r0 == 0) goto L52
            androidx.databinding.ObservableBoolean r0 = r9.isExtended()
            boolean r0 = r0.get()
            if (r0 != 0) goto L52
        L42:
            android.view.ViewParent r8 = r8.getParent()
            java.util.Objects.requireNonNull(r8, r2)
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            r8.setVisibility(r1)
            com.growingio.android.sdk.autoburry.VdsAgent.onSetViewVisibility(r8, r1)
            goto L97
        L52:
            int r0 = r9.getMinValue()
            int r1 = r9.getMaxValue()
            androidx.databinding.ObservableInt r5 = r9.getCurrentValue()
            int r5 = r5.get()
            int r6 = r9.getDefaultValue()
            int r7 = r9.getMinValue()
            if (r6 != r7) goto L6d
            goto L75
        L6d:
            int r9 = r9.getDefaultValue()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
        L75:
            r8.setValues(r0, r1, r5, r3)
            android.view.ViewParent r8 = r8.getParent()
            java.util.Objects.requireNonNull(r8, r2)
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            r8.setVisibility(r4)
            com.growingio.android.sdk.autoburry.VdsAgent.onSetViewVisibility(r8, r4)
            goto L97
        L88:
            android.view.ViewParent r8 = r8.getParent()
            java.util.Objects.requireNonNull(r8, r2)
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            r8.setVisibility(r1)
            com.growingio.android.sdk.autoburry.VdsAgent.onSetViewVisibility(r8, r1)
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.f.a.c(us.pinguo.ui.widget.StickySeekBar, us.pinguo.repository2020.entity.BeautyData):void");
    }

    @BindingAdapter({"isDark"})
    public static final void d(ImageView view, boolean z) {
        s.h(view, "view");
        if (z) {
            view.setImageResource(R.drawable.ic_compare_to_original_dark);
        } else {
            view.setImageResource(R.drawable.ic_compare_to_original_camera_white);
        }
    }

    @BindingAdapter({"isDark", "isSelected"})
    public static final void e(ImageView view, boolean z, boolean z2) {
        s.h(view, "view");
        if (!z2) {
            us.pinguo.common.filter.util.b.a.a(view, R.color.color_camera_theme_dark);
        } else if (z) {
            us.pinguo.common.filter.util.b.a.a(view, R.color.color_camera_theme_black);
        } else {
            us.pinguo.common.filter.util.b.a.a(view, R.color.color_camera_theme_light);
        }
    }

    @BindingAdapter({"textColor"})
    public static final void f(TextView view, boolean z) {
        s.h(view, "view");
        if (z) {
            view.setTextColor(view.getResources().getColorStateList(R.color.selector_beauty_clear_or_reset_dark_enable));
        } else {
            view.setTextColor(view.getResources().getColorStateList(R.color.selector_beauty_clear_or_reset_white_enable));
        }
    }
}
