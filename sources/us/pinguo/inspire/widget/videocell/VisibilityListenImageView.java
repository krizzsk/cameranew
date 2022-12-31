package us.pinguo.inspire.widget.videocell;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class VisibilityListenImageView extends ImageView {
    private ArrayList<a> a;

    /* loaded from: classes9.dex */
    public interface a {
        void onVisibilityChange(int i2);
    }

    public VisibilityListenImageView(Context context) {
        super(context);
        this.a = new ArrayList<>();
    }

    public void a(a aVar) {
        this.a.add(aVar);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        ArrayList<a> arrayList = this.a;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onVisibilityChange(i2);
            }
        }
    }

    public VisibilityListenImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new ArrayList<>();
    }

    public VisibilityListenImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new ArrayList<>();
    }
}
