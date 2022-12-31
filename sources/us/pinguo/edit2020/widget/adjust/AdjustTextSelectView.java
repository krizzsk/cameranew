package us.pinguo.edit2020.widget.adjust;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.R;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: AdjustTextSelectView.kt */
/* loaded from: classes4.dex */
public final class AdjustTextSelectView extends ConstraintLayout {
    private int a;
    private AutofitTextView b;
    private ImageView c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f10945d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<String> f10946e;

    /* renamed from: f  reason: collision with root package name */
    private p<? super String, ? super Integer, u> f10947f;

    /* renamed from: g  reason: collision with root package name */
    private kotlin.jvm.b.a<Boolean> f10948g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdjustTextSelectView(Context context) {
        this(context, null, 0, 6, null);
        s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdjustTextSelectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        s.h(context, "context");
    }

    public /* synthetic */ AdjustTextSelectView(Context context, AttributeSet attributeSet, int i2, int i3, o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(AdjustTextSelectView this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        kotlin.jvm.b.a<Boolean> aVar = this$0.f10948g;
        if (aVar != null) {
            s.e(aVar);
            if (aVar.invoke().booleanValue()) {
                return;
            }
        }
        int i2 = this$0.a + 1;
        this$0.a = i2;
        int i3 = i2 % 2;
        this$0.a = i3;
        if (i3 == 0) {
            this$0.c.setImageResource(R.drawable.ic_up_selected);
            this$0.f10945d.setImageResource(R.drawable.ic_down_unselected);
        } else {
            this$0.c.setImageResource(R.drawable.ic_up_unselected);
            this$0.f10945d.setImageResource(R.drawable.ic_down_selected);
        }
        this$0.b.setText(this$0.f10946e.get(this$0.a));
        p<? super String, ? super Integer, u> pVar = this$0.f10947f;
        if (pVar == null) {
            return;
        }
        String str = this$0.f10946e.get(this$0.a);
        s.g(str, "textList[textIndex]");
        pVar.invoke(str, Integer.valueOf(this$0.a));
    }

    public final ArrayList<String> h() {
        return this.f10946e;
    }

    public final AutofitTextView i() {
        return this.b;
    }

    public final void k(boolean z) {
        if (z) {
            if (this.c.getVisibility() == 0) {
                return;
            }
            ImageView imageView = this.c;
            imageView.setVisibility(0);
            VdsAgent.onSetViewVisibility(imageView, 0);
            ImageView imageView2 = this.f10945d;
            imageView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(imageView2, 0);
            return;
        }
        if (this.c.getVisibility() == 4) {
            return;
        }
        ImageView imageView3 = this.c;
        imageView3.setVisibility(4);
        VdsAgent.onSetViewVisibility(imageView3, 4);
        ImageView imageView4 = this.f10945d;
        imageView4.setVisibility(4);
        VdsAgent.onSetViewVisibility(imageView4, 4);
    }

    public final void setPredict(kotlin.jvm.b.a<Boolean> aVar) {
        this.f10948g = aVar;
    }

    public final void setSelectedText(String selectedText) {
        s.h(selectedText, "selectedText");
        ArrayList<String> arrayList = this.f10946e;
        int i2 = 0;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<String> it = this.f10946e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int i3 = i2 + 1;
            if (s.c(selectedText, it.next())) {
                this.a = i2;
                break;
            }
            i2 = i3;
        }
        this.b.setText(this.f10946e.get(this.a));
    }

    public final void setTextChangeListener(p<? super String, ? super Integer, u> pVar) {
        this.f10947f = pVar;
    }

    public final void setTextList(ArrayList<String> value) {
        s.h(value, "value");
        this.b.setText(value.get(this.a));
        this.f10946e = value;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdjustTextSelectView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        new LinkedHashMap();
        this.b = new AutofitTextView(context);
        this.c = new ImageView(context);
        this.f10945d = new ImageView(context);
        this.f10946e = new ArrayList<>();
        int id = getId();
        AutofitTextView autofitTextView = this.b;
        int i3 = R.id.tvContent;
        autofitTextView.setId(i3);
        autofitTextView.setGravity(17);
        autofitTextView.setWidth(us.pinguo.common.widget.i.a.a(70));
        autofitTextView.setMinTextSize(1, 10.0f);
        autofitTextView.setSingleLine(true);
        autofitTextView.setPadding(0, 0, us.pinguo.common.widget.i.a.a(2), 0);
        autofitTextView.setTextSize(1, 12.0f);
        autofitTextView.setTextColor(Color.parseColor("#2d2d2d"));
        autofitTextView.setSizeToFit(true);
        ImageView imageView = this.c;
        int i4 = R.id.ivUp;
        imageView.setId(i4);
        imageView.setPadding(0, 0, 2, 0);
        imageView.setImageResource(R.drawable.ic_up_selected);
        ImageView imageView2 = this.f10945d;
        int i5 = R.id.ivDown;
        imageView2.setId(i5);
        imageView2.setImageResource(R.drawable.ic_down_unselected);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -1);
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = us.pinguo.common.widget.i.a.a(Double.valueOf(6.5d));
        layoutParams.startToStart = id;
        layoutParams.topToTop = id;
        layoutParams.bottomToBottom = id;
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.topToTop = id;
        layoutParams2.startToEnd = i3;
        layoutParams2.bottomToTop = i5;
        layoutParams2.verticalChainStyle = 2;
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams3.topToBottom = i4;
        layoutParams3.startToEnd = i3;
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = us.pinguo.common.widget.i.a.a(2);
        layoutParams3.bottomToBottom = id;
        addView(this.b, layoutParams);
        addView(this.c, layoutParams2);
        addView(this.f10945d, layoutParams3);
        setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.widget.adjust.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdjustTextSelectView.g(AdjustTextSelectView.this, view);
            }
        });
    }
}
