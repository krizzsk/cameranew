package vStudio.Android.Camera360.home.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import vStudio.Android.Camera360.R;
/* loaded from: classes7.dex */
public class ExploreBoxView extends RelativeLayout {
    private TextView a;
    private ImageView b;
    private TextView c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12652d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12653e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f12654f;

    public ExploreBoxView(Context context) {
        this(context, null);
    }

    private void a() {
        setBackgroundResource(R.drawable.home_explore_box_bg);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.home_view_explore_box, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(linearLayout, layoutParams);
        this.a = (TextView) linearLayout.findViewById(R.id.title);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.icon);
        this.c = new TextView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, R.id.explore_box_center_layout);
        layoutParams2.addRule(14);
        layoutParams2.topMargin = (int) (getResources().getDisplayMetrics().density * 1.0f);
        addView(this.c, layoutParams2);
        this.c.setTextSize(10.0f);
        this.c.setSingleLine(true);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        this.c.setTextColor(Color.parseColor("#8e8e8e"));
        TextView textView = this.c;
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        this.b = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(10);
        addView(this.b, layoutParams3);
        this.b.setVisibility(8);
        Paint paint = new Paint();
        this.f12654f = paint;
        paint.setColor(-1710619);
        this.f12654f.setStrokeWidth(1.0f);
        this.f12654f.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        float strokeWidth = this.f12654f.getStrokeWidth() / 2.0f;
        if (this.f12653e) {
            float f2 = width - strokeWidth;
            canvas.drawLine(f2, 0.0f, f2, height, this.f12654f);
        }
        if (this.f12652d) {
            canvas.drawLine(0.0f, strokeWidth, width, strokeWidth, this.f12654f);
        }
        float f3 = height - strokeWidth;
        canvas.drawLine(0.0f, f3, width, f3, this.f12654f);
    }

    public void setBorder(boolean z, boolean z2) {
        this.f12652d = z;
        this.f12653e = z2;
    }

    public void setDesc(String str) {
        if (TextUtils.isEmpty(str)) {
            TextView textView = this.c;
            textView.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView, 8);
            return;
        }
        TextView textView2 = this.c;
        textView2.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView2, 0);
        this.c.setText(str);
    }

    public void setTitle(int i2) {
        this.a.setText(i2);
    }

    public ExploreBoxView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setTitle(String str) {
        this.a.setText(str);
    }

    public ExploreBoxView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
