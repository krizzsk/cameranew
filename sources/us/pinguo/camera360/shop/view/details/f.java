package us.pinguo.camera360.shop.view.details;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.common.utils.g;
import us.pinguo.common.utils.k;
import us.pinguo.ui.widget.AutofitTextView;
import vStudio.Android.Camera360.R;
/* compiled from: ShopPopMenuHelper.kt */
/* loaded from: classes4.dex */
public final class f {
    private final View a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        AutofitTextView autofitTextView = new AutofitTextView(context);
        autofitTextView.setTag(k.c(R.id.menu_name));
        autofitTextView.setMinTextSize(1, 10.0f);
        autofitTextView.setTextSize(1, 14.0f);
        autofitTextView.setTextColor(Color.parseColor("#FF333333"));
        autofitTextView.setPadding(us.pinguo.common.widget.i.a.a(16), 0, us.pinguo.common.widget.i.a.a(16), 0);
        autofitTextView.setBackgroundResource(R.drawable.ripple_common_bg);
        autofitTextView.setMaxLines(1);
        autofitTextView.setGravity(16);
        frameLayout.addView(autofitTextView, new FrameLayout.LayoutParams(us.pinguo.common.widget.i.a.a(150), us.pinguo.common.widget.i.a.a(44)));
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(l lVar, int i2, View view) {
        VdsAgent.lambdaOnClick(view);
        if (lVar != null) {
            lVar.invoke(Integer.valueOf(i2));
        }
        PopupWindow a = g.a.a();
        if (a == null) {
            return;
        }
        a.dismiss();
    }

    public final PopupWindow c(Context context, CharSequence[] items, final l<? super Integer, u> lVar) {
        s.h(context, "context");
        s.h(items, "items");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setElevation(10.0f);
        linearLayout.setTranslationZ(10.0f);
        linearLayout.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        linearLayout.setClipChildren(false);
        linearLayout.setBackground(context.getDrawable(R.drawable.bg_camera_setting_menu));
        int length = items.length;
        int i2 = 0;
        final int i3 = 0;
        while (i2 < length) {
            CharSequence charSequence = items[i2];
            View a = a(context);
            ((TextView) a.findViewWithTag(k.c(R.id.menu_name))).setText(charSequence);
            a.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera360.shop.view.details.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.d(l.this, i3, view);
                }
            });
            linearLayout.addView(a);
            i2++;
            i3++;
        }
        PopupWindow popupWindow = new PopupWindow(linearLayout, -2, -2);
        popupWindow.setAnimationStyle(16973826);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        return popupWindow;
    }
}
