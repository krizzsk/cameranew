package us.pinguo.common.n;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableInt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TJAdUnitConstants;
import kotlin.jvm.internal.s;
import us.pinguo.common.filter.util.b;
import us.pinguo.common.filter.view.FilterPackageDownloadView;
import us.pinguo.commonui.R;
import us.pinguo.repository2020.entity.SelfDefMakeupMaterial;
import us.pinguo.repository2020.entity.StyleMakeup;
/* compiled from: BeautyBindingAdapter.kt */
/* loaded from: classes4.dex */
public final class a {
    @BindingAdapter({"isSelected", "isDark"})
    public static final void a(AppCompatImageView view, boolean z, boolean z2) {
        s.h(view, "view");
        if (z2) {
            if (z) {
                b.a.a(view, R.color.color_camera_theme_black);
            } else {
                b.a.a(view, R.color.color_camera_theme_dark);
            }
        } else if (z) {
            b.a.a(view, R.color.color_camera_theme_light);
        } else {
            b.a.a(view, R.color.color_camera_theme_dark);
        }
    }

    @BindingAdapter({"makeupIcon"})
    public static final void b(SimpleDraweeView view, SelfDefMakeupMaterial makeup) {
        s.h(view, "view");
        s.h(makeup, "makeup");
        com.facebook.drawee.generic.a a = new com.facebook.drawee.generic.b(view.getResources()).a();
        int i2 = R.drawable.ic_placeholder_logo;
        a.y(i2);
        a.B(i2);
        view.setHierarchy(a);
        view.setImageURI(makeup.getIcon());
    }

    @BindingAdapter({"makeupMask"})
    public static final void c(View view, boolean z) {
        s.h(view, "view");
        int i2 = z ? 0 : 4;
        view.setVisibility(i2);
        VdsAgent.onSetViewVisibility(view, i2);
    }

    @BindingAdapter({"progress"})
    public static final void d(FilterPackageDownloadView view, ObservableInt progress) {
        s.h(view, "view");
        s.h(progress, "progress");
        view.setDownloadProgress(progress.get());
    }

    @BindingAdapter({"styleMakeupIcon"})
    public static final void e(SimpleDraweeView view, StyleMakeup styleMakeup) {
        s.h(view, "view");
        s.h(styleMakeup, "styleMakeup");
        com.facebook.drawee.generic.a a = new com.facebook.drawee.generic.b(view.getResources()).a();
        int i2 = R.drawable.ic_placeholder_logo;
        a.y(i2);
        a.B(i2);
        view.setHierarchy(a);
        view.setImageURI(styleMakeup.getIcon());
    }

    @BindingAdapter({"styleMakeupMask"})
    public static final void f(View view, boolean z) {
        s.h(view, "view");
        int i2 = z ? 0 : 4;
        view.setVisibility(i2);
        VdsAgent.onSetViewVisibility(view, i2);
    }

    @BindingAdapter({"textBackgroundColor"})
    public static final void g(TextView textView, String str) {
        s.h(textView, "textView");
        try {
            textView.setBackgroundColor(Color.parseColor(s.q("#", str)));
        } catch (Exception e2) {
            textView.setBackgroundColor(Color.parseColor("#CBBBBB"));
            e2.printStackTrace();
        }
    }

    @BindingAdapter({"isDark", "isSelected", "isInEdit"})
    public static final void h(TextView view, boolean z, boolean z2, boolean z3) {
        s.h(view, "view");
        if (!z2) {
            if (z3) {
                view.setTextColor(view.getResources().getColor(R.color.beauty_text_color_white_select));
            } else {
                view.setTextColor(view.getResources().getColor(R.color.beauty_text_color_dark));
            }
        } else if (z3) {
            view.setTextColor(view.getResources().getColor(R.color.beauty_text_color_white_select));
        } else if (z) {
            view.setTextColor(view.getResources().getColor(R.color.beauty_text_color_dark_select));
        } else {
            view.setTextColor(view.getResources().getColor(R.color.beauty_text_color_white_select));
        }
    }

    @BindingAdapter({TJAdUnitConstants.String.VISIBLE})
    public static final void i(View view, boolean z) {
        s.h(view, "view");
        int i2 = z ? 0 : 8;
        view.setVisibility(i2);
        VdsAgent.onSetViewVisibility(view, i2);
    }
}
