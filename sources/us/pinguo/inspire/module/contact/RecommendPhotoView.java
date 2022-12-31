package us.pinguo.inspire.module.contact;

import android.content.Context;
import android.util.AttributeSet;
import us.pinguo.inspire.module.profile.view.ProfileHeaderPhotoView;
/* loaded from: classes9.dex */
public class RecommendPhotoView extends ProfileHeaderPhotoView {
    public RecommendPhotoView(Context context) {
        super(context);
    }

    @Override // us.pinguo.inspire.module.profile.view.ProfileHeaderPhotoView
    protected void initAndSize(Context context) {
        int j2 = (int) ((us.pinguo.foundation.t.b.a.j(context) - (us.pinguo.foundation.t.b.a.a(context, 3.0f) * 3)) / 4.0f);
        setSize(this.mImage1, j2, j2);
        setSize(this.mImage2, j2, j2);
        setSize(this.mImage3, j2, j2);
        setSize(this.mImage4, j2, j2);
    }

    public RecommendPhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RecommendPhotoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public RecommendPhotoView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }
}
