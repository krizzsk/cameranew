package pl.droidsonroids.gif;

import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageButton;
import pl.droidsonroids.gif.e;
/* loaded from: classes3.dex */
public class GifImageButton extends ImageButton {
    private boolean a;

    public GifImageButton(Context context) {
        super(context);
    }

    private void a(e.a aVar) {
        this.a = aVar.c;
        int i2 = aVar.a;
        if (i2 > 0) {
            super.setImageResource(i2);
        }
        int i3 = aVar.b;
        if (i3 > 0) {
            super.setBackgroundResource(i3);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        gifViewSavedState.a(getDrawable(), 0);
        gifViewSavedState.a(getBackground(), 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new GifViewSavedState(super.onSaveInstanceState(), this.a ? getDrawable() : null, this.a ? getBackground() : null);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        if (e.f(this, false, i2)) {
            return;
        }
        super.setBackgroundResource(i2);
    }

    public void setFreezesAnimation(boolean z) {
        this.a = z;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        if (e.f(this, true, i2)) {
            return;
        }
        super.setImageResource(i2);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        if (e.e(this, uri)) {
            return;
        }
        super.setImageURI(uri);
    }

    public GifImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(e.c(this, attributeSet, 0, 0));
    }

    public GifImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(e.c(this, attributeSet, i2, 0));
    }
}
