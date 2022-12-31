package us.pinguo.ui.widget.progress;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.timepicker.TimeModel;
import com.zhy.android.percent.support.PercentLayoutHelper;
import us.pinguo.ui.R;
/* loaded from: classes6.dex */
public class FabbyLoadingView extends FrameLayout {
    private ImageView a;
    private TextView b;
    private TextView c;

    /* renamed from: d  reason: collision with root package name */
    private int f12310d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f12311e;

    /* renamed from: f  reason: collision with root package name */
    private int f12312f;

    /* renamed from: g  reason: collision with root package name */
    private Runnable f12313g;

    /* loaded from: classes6.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FabbyLoadingView.this.a.setImageResource(FabbyLoadingView.this.f12311e[FabbyLoadingView.d(FabbyLoadingView.this)]);
            if (FabbyLoadingView.this.f12312f == FabbyLoadingView.this.f12311e.length) {
                FabbyLoadingView.this.f12312f = 0;
            }
            FabbyLoadingView.this.g(2000);
        }
    }

    public FabbyLoadingView(Context context) {
        super(context);
        this.f12313g = new a();
        h();
    }

    static /* synthetic */ int d(FabbyLoadingView fabbyLoadingView) {
        int i2 = fabbyLoadingView.f12312f;
        fabbyLoadingView.f12312f = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i2) {
        postDelayed(this.f12313g, i2);
    }

    private void h() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.view_fabby_loading, (ViewGroup) this, true);
        this.a = (ImageView) inflate.findViewById(R.id.iv_loading_fabby_progress);
        this.b = (TextView) inflate.findViewById(R.id.tv_percent_fabby_progress);
        this.c = (TextView) inflate.findViewById(R.id.tv_promot_text_fabby_progress);
        this.b.setText(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(this.f12310d)) + PercentLayoutHelper.PercentLayoutInfo.BASEMODE.PERCENT);
    }

    public void setPhotoResources(int[] iArr) {
        this.f12311e = iArr;
    }

    public void setPromptText(int i2) {
        this.c.setText(i2);
    }

    public FabbyLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12313g = new a();
        h();
    }

    public FabbyLoadingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12313g = new a();
        h();
    }
}
