package us.pinguo.foundation.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.foundation.R;
/* loaded from: classes4.dex */
public class CommonItemView extends RelativeLayout implements View.OnClickListener {
    private AppCompatImageView a;
    private TextView b;
    private TextView c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f11094d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f11095e;

    /* renamed from: f  reason: collision with root package name */
    private View f11096f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f11097g;

    /* renamed from: h  reason: collision with root package name */
    private int f11098h;

    /* renamed from: i  reason: collision with root package name */
    private String f11099i;

    /* renamed from: j  reason: collision with root package name */
    private Typeface f11100j;

    /* renamed from: k  reason: collision with root package name */
    private int f11101k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f11102l;
    private int m;
    private int n;
    private int o;
    private int p;
    private a q;

    /* loaded from: classes4.dex */
    public interface a {
        void onItemClick(View view);
    }

    public CommonItemView(Context context) {
        super(context);
        this.f11100j = Typeface.DEFAULT;
        this.o = -1;
        this.p = -1;
        c(null);
    }

    private void a(int i2) {
        if (i2 > 9) {
            this.f11095e.setBackgroundResource(R.drawable.red_rect);
        } else {
            this.f11095e.setBackgroundResource(R.drawable.red_oval);
        }
    }

    private void c(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CommonItemView);
            this.f11098h = obtainStyledAttributes.getResourceId(R.styleable.CommonItemView_leftIcon, 0);
            this.f11099i = obtainStyledAttributes.getString(R.styleable.CommonItemView_text);
            this.f11101k = obtainStyledAttributes.getInt(R.styleable.CommonItemView_rightCount, 0);
            this.f11102l = obtainStyledAttributes.getBoolean(R.styleable.CommonItemView_showRedDot, false);
            this.m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CommonItemView_leftIconWidth, 0);
            this.n = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CommonItemView_leftIconHeight, 0);
            this.o = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.CommonItemView_leftTextMargin, -1);
            this.p = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.CommonItemView_leftIconMargin, -1);
            obtainStyledAttributes.recycle();
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.common_item_view_layout, (ViewGroup) this, true);
        inflate.findViewById(R.id.rl_content_inspire_item_view).setOnClickListener(this);
        this.a = (AppCompatImageView) inflate.findViewById(R.id.inspire_item_view_icon);
        this.b = (TextView) inflate.findViewById(R.id.inspire_item_view_text);
        this.c = (TextView) inflate.findViewById(R.id.inspire_item_view_count);
        this.f11094d = (TextView) inflate.findViewById(R.id.item_view_right_text);
        this.f11095e = (TextView) inflate.findViewById(R.id.inspire_item_view_red_count);
        this.f11096f = inflate.findViewById(R.id.vRedPoint);
        this.f11097g = (TextView) inflate.findViewById(R.id.image_new_tag);
        d();
    }

    private void d() {
        int i2;
        int i3 = this.f11098h;
        if (i3 != 0) {
            this.a.setImageResource(i3);
        }
        this.b.setText(this.f11099i);
        this.b.setTypeface(this.f11100j);
        e(this.f11101k, this.f11102l);
        if ((this.m > 0 && this.n > 0) || this.p >= 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.a.getLayoutParams();
            int i4 = this.m;
            if (i4 > 0 && (i2 = this.n) > 0) {
                marginLayoutParams.width = i4;
                marginLayoutParams.height = i2;
            }
            int i5 = this.p;
            if (i5 >= 0) {
                marginLayoutParams.leftMargin = i5;
            }
            this.a.setLayoutParams(marginLayoutParams);
        }
        if (this.o >= 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.b.getLayoutParams();
            marginLayoutParams2.leftMargin = this.o;
            this.b.setLayoutParams(marginLayoutParams2);
        }
    }

    private void e(int i2, boolean z) {
        setRightCount(i2, z);
    }

    public TextView b() {
        return this.f11097g;
    }

    public void f() {
        TextView textView = this.c;
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        TextView textView2 = this.f11094d;
        textView2.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView2, 0);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        a aVar = this.q;
        if (aVar != null) {
            aVar.onItemClick(view);
        }
    }

    public void setContetntLeftDrawable(int i2) {
        Drawable drawable = getResources().getDrawable(i2);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.b.setCompoundDrawables(drawable, null, null, null);
        this.b.setCompoundDrawablePadding(5);
    }

    public void setIcon(int i2) {
        this.a.setImageResource(i2);
    }

    public void setOnItemClickListener(a aVar) {
        this.q = aVar;
    }

    public void setRedPoint(boolean z) {
        if (z) {
            View view = this.f11096f;
            view.setVisibility(0);
            VdsAgent.onSetViewVisibility(view, 0);
            return;
        }
        View view2 = this.f11096f;
        view2.setVisibility(8);
        VdsAgent.onSetViewVisibility(view2, 8);
    }

    public void setRightCount(int i2) {
        TextView textView = this.f11095e;
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        TextView textView2 = this.c;
        textView2.setText(i2 + "");
        if (i2 > 0) {
            TextView textView3 = this.c;
            textView3.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView3, 0);
            return;
        }
        TextView textView4 = this.c;
        textView4.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView4, 8);
    }

    public void setRightCount2(int i2) {
        TextView textView = this.f11095e;
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        TextView textView2 = this.f11094d;
        textView2.setText(i2 + "");
        if (i2 > 0) {
            TextView textView3 = this.f11094d;
            textView3.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView3, 0);
            return;
        }
        TextView textView4 = this.f11094d;
        textView4.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView4, 8);
    }

    public void setText(String str) {
        this.b.setText(str);
    }

    public void setTextColor(String str) {
        setTextColor(Color.parseColor(str));
    }

    public void setText(int i2) {
        this.b.setText(i2);
    }

    public void setTextColor(int i2) {
        this.b.setTextColor(i2);
    }

    public void setRightCount(String str) {
        TextView textView = this.f11095e;
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        this.c.setText(str);
        if (!TextUtils.isEmpty(str)) {
            TextView textView2 = this.c;
            textView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView2, 0);
            return;
        }
        TextView textView3 = this.c;
        textView3.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView3, 8);
    }

    public void setRightCount2(String str) {
        TextView textView = this.f11095e;
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        this.f11094d.setText(str);
        if (!TextUtils.isEmpty(str)) {
            TextView textView2 = this.f11094d;
            textView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView2, 0);
            return;
        }
        TextView textView3 = this.f11094d;
        textView3.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView3, 8);
    }

    public CommonItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11100j = Typeface.DEFAULT;
        this.o = -1;
        this.p = -1;
        c(attributeSet);
    }

    public void setRightCount(int i2, boolean z) {
        if (!z) {
            setRightCount(i2);
            return;
        }
        TextView textView = this.c;
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        TextView textView2 = this.f11095e;
        textView2.setText(i2 + "");
        a(i2);
        if (i2 > 0) {
            TextView textView3 = this.f11095e;
            textView3.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView3, 0);
            return;
        }
        TextView textView4 = this.f11095e;
        textView4.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView4, 8);
    }

    public void setRightCount2(int i2, boolean z) {
        if (!z) {
            setRightCount2(i2);
            return;
        }
        TextView textView = this.f11094d;
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        TextView textView2 = this.f11095e;
        textView2.setText(i2 + "");
        a(i2);
        if (i2 > 0) {
            TextView textView3 = this.f11095e;
            textView3.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView3, 0);
            return;
        }
        TextView textView4 = this.f11095e;
        textView4.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView4, 8);
    }

    public CommonItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11100j = Typeface.DEFAULT;
        this.o = -1;
        this.p = -1;
        c(attributeSet);
    }
}
