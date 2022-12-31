package us.pinguo.inspire.module.feeds.view;

import android.content.Context;
import android.util.AttributeSet;
import us.pinguo.inspire.widget.PhotoGridView;
/* loaded from: classes9.dex */
public class FriendDynamicGridView extends PhotoGridView {
    private static final int COLUMN = 6;
    private static final int MAX_PHOTO = 18;

    public FriendDynamicGridView(Context context) {
        super(context);
    }

    @Override // us.pinguo.inspire.widget.PhotoGridView
    protected int getModeFromPhotos(PhotoGridView.b[] bVarArr) {
        return 100;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.widget.PhotoGridView
    public void initDrawables() {
        setColumn(6);
        this.mDrawables = new PhotoTagDrawable[18];
        super.initDrawables();
    }

    public FriendDynamicGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FriendDynamicGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
