package us.pinguo.camera360.shop.manager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.paylibcenter.PayHelp;
import vStudio.Android.Camera360.R;
/* compiled from: PaywayItem.kt */
/* loaded from: classes4.dex */
public final class PaywayItem extends LinearLayout {
    public Map<Integer, View> a;
    private kotlin.jvm.b.p<? super PayHelp.PAYWAY, ? super String, kotlin.u> b;
    private PayHelp.PAYWAY c;

    /* renamed from: d  reason: collision with root package name */
    private String f9712d;

    public PaywayItem(Context context) {
        super(context);
        this.a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.choose_payway_dialog_item, this);
        setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera360.shop.manager.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaywayItem.b(PaywayItem.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PaywayItem this$0, View view) {
        kotlin.jvm.b.p<PayHelp.PAYWAY, String, kotlin.u> c;
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        PayHelp.PAYWAY payway = this$0.c;
        if (payway == null || (c = this$0.c()) == null) {
            return;
        }
        c.invoke(payway, this$0.d());
    }

    public static /* synthetic */ void setData$default(PaywayItem paywayItem, String str, int i2, PayHelp.PAYWAY payway, String str2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        paywayItem.setData(str, i2, payway, str2);
    }

    public View a(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    public final kotlin.jvm.b.p<PayHelp.PAYWAY, String, kotlin.u> c() {
        return this.b;
    }

    public final String d() {
        return this.f9712d;
    }

    public final void setClickCallback(kotlin.jvm.b.p<? super PayHelp.PAYWAY, ? super String, kotlin.u> pVar) {
        this.b = pVar;
    }

    public final void setData(String name, int i2, PayHelp.PAYWAY payway, String str) {
        kotlin.jvm.internal.s.h(name, "name");
        kotlin.jvm.internal.s.h(payway, "payway");
        ((ImageView) a(R.id.paywayIcon)).setImageResource(i2);
        ((TextView) a(R.id.paywayName)).setText(name);
        this.c = payway;
        this.f9712d = str;
    }

    public final void setExtra(String str) {
        this.f9712d = str;
    }

    public final void setPayway(PayHelp.PAYWAY payway) {
        this.c = payway;
    }

    public PaywayItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.choose_payway_dialog_item, this);
        setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera360.shop.manager.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaywayItem.b(PaywayItem.this, view);
            }
        });
    }

    public PaywayItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.choose_payway_dialog_item, this);
        setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera360.shop.manager.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaywayItem.b(PaywayItem.this, view);
            }
        });
    }
}
