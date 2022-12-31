package us.pinguo.edit2020.view;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.edit2020.R;
/* compiled from: ManualSkinFullScreenGuide.kt */
/* loaded from: classes4.dex */
public final class ManualSkinFullScreenGuide extends ConstraintLayout {
    public Map<Integer, View> a;
    private kotlin.jvm.b.a<kotlin.u> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManualSkinFullScreenGuide(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.manual_skin_fullscreen_guide_layout, this);
        j();
        ((ImageView) _$_findCachedViewById(R.id.btClose)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.view.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManualSkinFullScreenGuide.g(ManualSkinFullScreenGuide.this, view);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.btManual)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.view.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManualSkinFullScreenGuide.h(ManualSkinFullScreenGuide.this, view);
            }
        });
        setOnClickListener(q.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ManualSkinFullScreenGuide this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.setVisibility(8);
        VdsAgent.onSetViewVisibility(this$0, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ManualSkinFullScreenGuide this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.setVisibility(8);
        VdsAgent.onSetViewVisibility(this$0, 8);
        kotlin.jvm.b.a<kotlin.u> aVar = this$0.b;
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(View view) {
        VdsAgent.lambdaOnClick(view);
    }

    private final void j() {
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.a;
        String string = getContext().getString(R.string.edit_manualskon_guide_title_start);
        kotlin.jvm.internal.s.g(string, "context.getString(R.stri…alskon_guide_title_start)");
        String format = String.format(string, Arrays.copyOf(new Object[]{"<b><font color=#fab615>" + getContext().getString(R.string.edit_manualskon_guide_title_end) + "</font></b>"}, 1));
        kotlin.jvm.internal.s.g(format, "format(format, *args)");
        ((TextView) _$_findCachedViewById(R.id.title)).setText(Html.fromHtml(format));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ManualSkinFullScreenGuide this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.o();
    }

    public View _$_findCachedViewById(int i2) {
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

    public final void o() {
        int i2 = R.id.animView;
        ((ImageView) _$_findCachedViewById(i2)).setAlpha(0.5f);
        ((ImageView) _$_findCachedViewById(i2)).setScaleX(1.0f);
        ((ImageView) _$_findCachedViewById(i2)).setScaleY(1.0f);
        ((ImageView) _$_findCachedViewById(i2)).animate().alpha(0.0f).scaleX(3.0f).scaleY(3.0f).setDuration(1600L).withEndAction(new Runnable() { // from class: us.pinguo.edit2020.view.r
            @Override // java.lang.Runnable
            public final void run() {
                ManualSkinFullScreenGuide.p(ManualSkinFullScreenGuide.this);
            }
        }).start();
    }

    public final void setBottomPadding(int i2) {
        _$_findCachedViewById(R.id.bottomPadding).getLayoutParams().height = i2;
    }

    public final void setGotoManualSkin(kotlin.jvm.b.a<kotlin.u> aVar) {
        kotlin.jvm.internal.s.h(aVar, "goto");
        this.b = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManualSkinFullScreenGuide(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.manual_skin_fullscreen_guide_layout, this);
        j();
        ((ImageView) _$_findCachedViewById(R.id.btClose)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.view.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManualSkinFullScreenGuide.g(ManualSkinFullScreenGuide.this, view);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.btManual)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.view.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManualSkinFullScreenGuide.h(ManualSkinFullScreenGuide.this, view);
            }
        });
        setOnClickListener(q.a);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManualSkinFullScreenGuide(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.manual_skin_fullscreen_guide_layout, this);
        j();
        ((ImageView) _$_findCachedViewById(R.id.btClose)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.view.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManualSkinFullScreenGuide.g(ManualSkinFullScreenGuide.this, view);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.btManual)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.view.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManualSkinFullScreenGuide.h(ManualSkinFullScreenGuide.this, view);
            }
        });
        setOnClickListener(q.a);
    }
}
