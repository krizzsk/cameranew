package us.pinguo.edit2020.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.jvm.internal.s;
import us.pinguo.edit2020.R;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: EditExtensions.kt */
/* loaded from: classes4.dex */
public final class d {
    public static final View a(Context context, int i2, boolean z, boolean z2) {
        s.h(context, "<this>");
        return b(context, k(i2), z, z2);
    }

    public static final View b(Context context, String strFunctionName, boolean z, boolean z2) {
        s.h(context, "<this>");
        s.h(strFunctionName, "strFunctionName");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(0);
        if (z) {
            ImageView imageView = new ImageView(linearLayout.getContext());
            imageView.setImageResource(R.drawable.icon_vip_round_label);
            int a = us.pinguo.common.widget.i.a.a(18);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a, a);
            layoutParams.setMarginEnd(us.pinguo.common.widget.i.a.a(4));
            linearLayout.addView(imageView, layoutParams);
        }
        AutofitTextView autofitTextView = new AutofitTextView(linearLayout.getContext());
        autofitTextView.setTextColor(ContextCompat.getColor(autofitTextView.getContext(), R.color.edit_function_select));
        autofitTextView.setTextSize(1, 14.0f);
        autofitTextView.getPaint().setFakeBoldText(true);
        autofitTextView.setText(strFunctionName);
        linearLayout.addView(autofitTextView, new ViewGroup.LayoutParams(-2, -2));
        if (z2) {
            ImageView imageView2 = new ImageView(linearLayout.getContext());
            imageView2.setImageResource(R.drawable.ic_function_tip);
            TypedArray obtainStyledAttributes = imageView2.getContext().getTheme().obtainStyledAttributes(new int[]{16843868});
            s.g(obtainStyledAttributes, "imageView.context.theme.…temBackgroundBorderless))");
            imageView2.setBackground(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
            int a2 = us.pinguo.common.widget.i.a.a(18);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a2, a2);
            layoutParams2.leftMargin = us.pinguo.common.widget.i.a.a(4);
            linearLayout.addView(imageView2, layoutParams2);
        }
        return linearLayout;
    }

    public static final int c(Context context, @ColorRes int i2) {
        s.h(context, "<this>");
        return ContextCompat.getColor(context, i2);
    }

    public static final boolean d(Object obj) {
        return obj != null;
    }

    public static final boolean e(Object obj) {
        return obj == null;
    }

    public static final boolean f(Context context) {
        s.h(context, "<this>");
        return context.getResources().getConfiguration().getLayoutDirection() == 1;
    }

    public static final void g(SimpleDraweeView simpleDraweeView, Uri uri, int i2, int i3) {
        s.h(simpleDraweeView, "<this>");
        s.h(uri, "uri");
        ImageRequestBuilder s = ImageRequestBuilder.s(uri);
        s.D(new com.facebook.imagepipeline.common.d(i2, i3, 9999.0f));
        ImageRequest a = s.a();
        com.facebook.drawee.backends.pipeline.e h2 = com.facebook.drawee.backends.pipeline.c.h();
        h2.C(simpleDraweeView.d());
        com.facebook.drawee.backends.pipeline.e eVar = h2;
        eVar.B(a);
        simpleDraweeView.setController(eVar.build());
    }

    public static final int h(int i2) {
        return ContextCompat.getColor(us.pinguo.foundation.e.b(), i2);
    }

    public static final int i(int i2) {
        return us.pinguo.foundation.e.b().getResources().getDimensionPixelSize(i2);
    }

    public static final Drawable j(int i2) {
        return ContextCompat.getDrawable(us.pinguo.foundation.e.b(), i2);
    }

    public static final String k(int i2) {
        String string = us.pinguo.foundation.e.b().getString(i2);
        s.g(string, "getAppContext().getString(this)");
        return string;
    }
}
