package us.pinguo.inspire.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Comparator;
import us.pinguo.ui.uilview.CircleImageView;
/* loaded from: classes9.dex */
public class AvatarAnimLayout extends FrameLayout implements Comparator<View> {
    private CircleImageView[] a;

    public AvatarAnimLayout(Context context) {
        super(context);
    }

    private void b() {
        new ArrayList();
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(View view, View view2) {
        if (view.getTranslationX() == view2.getTranslationX()) {
            return view.getVisibility() - view2.getVisibility();
        }
        return (int) (view.getTranslationX() - view2.getTranslationX());
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        this.a = new CircleImageView[childCount];
        for (int i2 = 0; i2 < childCount; i2++) {
            this.a[i2] = (CircleImageView) getChildAt(i2);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public AvatarAnimLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public AvatarAnimLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }
}
