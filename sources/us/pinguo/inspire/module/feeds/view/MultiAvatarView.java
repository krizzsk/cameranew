package us.pinguo.inspire.module.feeds.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import us.pinguo.foundation.t.b.a;
import us.pinguo.inspire.widget.PhotoGridView;
import us.pinguo.ui.R;
import us.pinguo.ui.uilview.b;
/* loaded from: classes9.dex */
public class MultiAvatarView extends PhotoGridView {
    private int mBorderWidth;
    private int mPadding;

    public MultiAvatarView(Context context) {
        super(context);
    }

    @Override // us.pinguo.inspire.widget.PhotoGridView
    protected int getModeFromPhotos(PhotoGridView.b[] bVarArr) {
        return 100;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.widget.PhotoGridView
    public void initDrawables() {
        this.mBorderWidth = a.b(getResources(), 1.0f);
        this.mPadding = a.b(getResources(), 2.0f);
        this.mDrawables = new us.pinguo.ui.uilview.a[4];
        for (int i2 = 0; i2 < this.mDrawables.length; i2++) {
            us.pinguo.ui.uilview.a aVar = new us.pinguo.ui.uilview.a();
            aVar.a(this.mBorderWidth);
            b[] bVarArr = this.mDrawables;
            bVarArr[i2] = aVar;
            bVarArr[i2].setLoadingColor(getResources().getColor(R.color.inspire_loading_color));
        }
        setColumn(2);
        setGridMarginPx(-this.mPadding);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.widget.PhotoGridView, android.view.View
    public void onDraw(Canvas canvas) {
        b[] bVarArr = this.mDrawables;
        b bVar = bVarArr[0];
        b bVar2 = bVarArr[1];
        b bVar3 = bVarArr[2];
        b bVar4 = bVarArr[3];
        if (bVar != null) {
            bVar.draw(canvas);
        }
        if (bVar2 != null) {
            bVar2.draw(canvas);
        }
        if (bVar4 != null) {
            bVar4.draw(canvas);
        }
        if (bVar3 != null) {
            bVar3.draw(canvas);
        }
        if (bVar != null) {
            int b = a.b(getResources(), 5.0f);
            Rect bounds = bVar.getBounds();
            canvas.save();
            int i2 = bounds.left;
            int i3 = bounds.bottom;
            canvas.clipRect(i2, i3 - b, bounds.right, i3);
            bVar.draw(canvas);
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.widget.PhotoGridView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        b[] bVarArr = this.mDrawables;
        b bVar = bVarArr[1];
        b bVar2 = bVarArr[2];
        b bVar3 = bVarArr[3];
        if (bVar != null) {
            Rect rect = new Rect(bVar.getBounds());
            rect.offset(-this.mPadding, 0);
            bVar.setBounds(rect);
        }
        if (bVar2 != null) {
            Rect rect2 = new Rect(bVar2.getBounds());
            rect2.offset(0, -this.mPadding);
            bVar2.setBounds(rect2);
        }
        if (bVar3 != null) {
            Rect rect3 = new Rect(bVar3.getBounds());
            int i4 = this.mPadding;
            rect3.offset(-i4, -i4);
            bVar3.setBounds(rect3);
        }
    }

    @Override // us.pinguo.inspire.widget.PhotoGridView
    public void setPhotos(PhotoGridView.b[] bVarArr) {
        super.setPhotos(bVarArr);
    }

    public MultiAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MultiAvatarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
