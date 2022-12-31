package us.pinguo.common.utils;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Arrays;
import kotlin.jvm.internal.s;
import us.pinguo.common.utils.g;
import us.pinguo.foundation.utils.n0;
/* compiled from: SettingPopMenuUtil.kt */
/* loaded from: classes4.dex */
public final class g {
    public static final g a = new g();
    private static PopupWindow b;
    private static CharSequence[] c;

    /* compiled from: SettingPopMenuUtil.kt */
    /* loaded from: classes4.dex */
    public interface a {
        void a(int i2);
    }

    private g() {
    }

    private final boolean b() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 == 24 || i2 == 25;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(a aVar, int i2, View view) {
        VdsAgent.lambdaOnClick(view);
        if (aVar != null) {
            aVar.a(i2);
        }
        PopupWindow popupWindow = b;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    public final PopupWindow a() {
        return b;
    }

    public final void d(PopupWindow popupWindow) {
        b = popupWindow;
    }

    public final PopupWindow e(Context context, CharSequence[] items, View anchor, final a aVar, int i2) {
        s.h(context, "context");
        s.h(items, "items");
        s.h(anchor, "anchor");
        CharSequence[] charSequenceArr = c;
        if (charSequenceArr != null && Arrays.equals(charSequenceArr, items)) {
            PopupWindow popupWindow = b;
            if (popupWindow != null && popupWindow.isShowing()) {
                return b;
            }
        }
        PopupWindow popupWindow2 = b;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
        }
        c = items;
        LayoutInflater from = LayoutInflater.from(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setElevation(10.0f);
        linearLayout.setTranslationZ(10.0f);
        linearLayout.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        linearLayout.setClipChildren(false);
        linearLayout.setBackground(context.getDrawable(us.pinguo.commonui.R.drawable.bg_camera_setting_menu));
        int length = items.length;
        int i3 = 0;
        final int i4 = 0;
        while (i3 < length) {
            CharSequence charSequence = items[i3];
            i3++;
            int i5 = i4 + 1;
            View inflate = from.inflate(us.pinguo.commonui.R.layout.item_camera_setting_menu, (ViewGroup) linearLayout, false);
            ImageView menuSelector = (ImageView) inflate.findViewById(us.pinguo.commonui.R.id.menu_selector);
            ((TextView) inflate.findViewById(us.pinguo.commonui.R.id.menu_name)).setText(charSequence);
            s.g(menuSelector, "menuSelector");
            int i6 = i4 != i2 ? 4 : 0;
            menuSelector.setVisibility(i6);
            VdsAgent.onSetViewVisibility(menuSelector, i6);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.utils.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.f(g.a.this, i4, view);
                }
            });
            linearLayout.addView(inflate);
            i4 = i5;
        }
        PopupWindow popupWindow3 = new PopupWindow(linearLayout, -2, -2);
        b = popupWindow3;
        popupWindow3.setOutsideTouchable(true);
        PopupWindow popupWindow4 = b;
        if (popupWindow4 != null) {
            popupWindow4.setAnimationStyle(16973826);
        }
        PopupWindow popupWindow5 = b;
        if (popupWindow5 != null) {
            popupWindow5.setBackgroundDrawable(null);
        }
        if (n0.h() - anchor.getY() < (items.length * context.getResources().getDimensionPixelSize(us.pinguo.commonui.R.dimen.camera_setting_item_height)) + us.pinguo.common.widget.i.a.a(50)) {
            if (b()) {
                PopupWindow popupWindow6 = b;
                if (popupWindow6 != null) {
                    int x = ((int) anchor.getX()) + us.pinguo.common.widget.i.a.a(16);
                    int y = (int) ((anchor.getY() - (anchor.getHeight() * 2)) - us.pinguo.common.widget.i.a.a(20));
                    popupWindow6.showAtLocation(anchor, 0, x, y);
                    VdsAgent.showAtLocation(popupWindow6, anchor, 0, x, y);
                }
            } else {
                PopupWindow popupWindow7 = b;
                if (popupWindow7 != null) {
                    int x2 = ((int) anchor.getX()) + us.pinguo.common.widget.i.a.a(16);
                    int y2 = (int) (anchor.getY() - (anchor.getHeight() / 2));
                    popupWindow7.showAtLocation(anchor, 0, x2, y2);
                    VdsAgent.showAtLocation(popupWindow7, anchor, 0, x2, y2);
                }
            }
        } else {
            PopupWindow popupWindow8 = b;
            if (popupWindow8 != null) {
                int a2 = us.pinguo.common.widget.i.a.a(16);
                popupWindow8.showAsDropDown(anchor, a2, 0);
                VdsAgent.showAsDropDown(popupWindow8, anchor, a2, 0);
            }
        }
        return b;
    }
}
