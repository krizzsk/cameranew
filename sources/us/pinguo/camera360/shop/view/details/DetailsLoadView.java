package us.pinguo.camera360.shop.view.details;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pnikosis.materialishprogress.ProgressWheel;
import vStudio.Android.Camera360.R;
/* loaded from: classes4.dex */
public class DetailsLoadView extends RelativeLayout {
    private ProgressWheel a;
    private ImageView b;
    private TextView c;

    public DetailsLoadView(Context context) {
        super(context);
    }

    public void a() {
        this.b.setVisibility(4);
        TextView textView = this.c;
        textView.setVisibility(4);
        VdsAgent.onSetViewVisibility(textView, 4);
    }

    public void b() {
        setVisibility(4);
        VdsAgent.onSetViewVisibility(this, 4);
    }

    public void c() {
        ProgressWheel progressWheel = this.a;
        progressWheel.setVisibility(4);
        VdsAgent.onSetViewVisibility(progressWheel, 4);
    }

    public void d() {
        setVisibility(0);
        VdsAgent.onSetViewVisibility(this, 0);
        c();
        this.b.setVisibility(0);
        TextView textView = this.c;
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
    }

    public void e() {
        setVisibility(0);
        VdsAgent.onSetViewVisibility(this, 0);
        ProgressWheel progressWheel = this.a;
        progressWheel.setVisibility(0);
        VdsAgent.onSetViewVisibility(progressWheel, 0);
        a();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (ProgressWheel) findViewById(R.id.store_details_progress_wheel);
        this.b = (ImageView) findViewById(R.id.store_details_network_error_iv);
        this.c = (TextView) findViewById(R.id.store_details_network_error_tv);
    }

    public DetailsLoadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DetailsLoadView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
