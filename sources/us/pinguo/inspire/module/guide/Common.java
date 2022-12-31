package us.pinguo.inspire.module.guide;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import us.pinguo.inspire.module.guide.MaskView;
/* loaded from: classes9.dex */
public class Common {
    public static final String authorityKey = "show_guide_authority_key";
    public static final String feedKey = "show_guide_feed_key";
    public static final String masterKey = "show_guide_profile_master_key";
    public static final String publishKey = "show_guide_publish_key";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View componentToView(LayoutInflater layoutInflater, Component component) {
        View view = component.getView(layoutInflater);
        MaskView.LayoutParams layoutParams = new MaskView.LayoutParams(-2, -2);
        layoutParams.offsetX = component.getXOffset();
        layoutParams.offsetY = component.getYOffset();
        layoutParams.targetAnchor = component.getAnchor();
        layoutParams.targetParentPosition = component.getFitPosition();
        view.setLayoutParams(layoutParams);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Rect getViewAbsRect(View view, int i2, int i3) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        Rect rect = new Rect();
        rect.set(iArr[0], iArr[1], iArr[0] + view.getMeasuredWidth(), iArr[1] + view.getMeasuredHeight());
        rect.offset(-i2, -i3);
        return rect;
    }
}
