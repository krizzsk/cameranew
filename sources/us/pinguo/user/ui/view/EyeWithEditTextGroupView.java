package us.pinguo.user.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import us.pinguo.user.R;
/* loaded from: classes6.dex */
public class EyeWithEditTextGroupView extends ViewGroup {
    private ImageView a;
    private EditTextWithPrompt b;
    private int c;

    public EyeWithEditTextGroupView(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.b = (EditTextWithPrompt) findViewById(R.id.register_password_edittext);
        this.a = (ImageView) findViewById(R.id.register_password_eye);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (z) {
            int i6 = i4 - i2;
            int i7 = i5 - i3;
            this.b.layout(0, 0, i6, i7);
            this.a.layout((i6 - i7) - 20, 0, i6, i7);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        this.b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(this.c, 1073741824));
        this.a.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        setMeasuredDimension(size, this.b.getMeasuredHeight());
    }

    public EyeWithEditTextGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = (int) getResources().getDimension(R.dimen.pg_login_input_height);
    }

    public EyeWithEditTextGroupView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = (int) getResources().getDimension(R.dimen.pg_login_input_height);
        us.pinguo.common.log.a.m("test", "mEditHeight:" + this.c, new Object[0]);
    }
}
