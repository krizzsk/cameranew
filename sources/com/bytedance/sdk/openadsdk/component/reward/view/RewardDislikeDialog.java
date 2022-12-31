package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
import com.bytedance.sdk.openadsdk.dislike.c;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RewardDislikeDialog extends FrameLayout {
    private View a;
    private TTDislikeListView b;
    private TTDislikeListView c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f1489d;

    /* renamed from: e  reason: collision with root package name */
    private View f1490e;

    /* renamed from: f  reason: collision with root package name */
    private c.b f1491f;

    /* renamed from: g  reason: collision with root package name */
    private c.b f1492g;

    /* renamed from: h  reason: collision with root package name */
    private h f1493h;

    /* renamed from: i  reason: collision with root package name */
    private a f1494i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1495j;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i2, FilterWord filterWord);

        void a(View view);

        void b(View view);

        void c(View view);
    }

    public RewardDislikeDialog(@NonNull Context context, @NonNull h hVar) {
        this(context);
        this.f1493h = hVar;
        c();
    }

    private void d() {
        this.f1489d = (RelativeLayout) this.a.findViewById(t.e(getContext(), "tt_dislike_title_content"));
        this.f1490e = this.a.findViewById(t.e(getContext(), "tt_dislike_line1"));
        this.a.findViewById(t.e(getContext(), "tt_dislike_header_back")).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialog.2
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                RewardDislikeDialog.this.e();
                if (RewardDislikeDialog.this.f1494i != null) {
                    RewardDislikeDialog.this.f1494i.c(view);
                }
            }
        });
        TTDislikeListView tTDislikeListView = (TTDislikeListView) this.a.findViewById(t.e(getContext(), "tt_filer_words_lv"));
        this.b = tTDislikeListView;
        tTDislikeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialog.3
            /* JADX WARN: Type inference failed for: r1v6, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            @Instrumented
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                VdsAgent.onItemClick(this, adapterView, view, i2, j2);
                try {
                    FilterWord filterWord = (FilterWord) adapterView.getAdapter().getItem(i2);
                    if (filterWord.hasSecondOptions()) {
                        RewardDislikeDialog.this.a(filterWord);
                        if (RewardDislikeDialog.this.f1494i != null) {
                            RewardDislikeDialog.this.f1494i.a(i2, filterWord);
                            return;
                        }
                        return;
                    }
                } catch (Throwable unused) {
                }
                if (RewardDislikeDialog.this.f1494i != null) {
                    try {
                        RewardDislikeDialog.this.f1494i.a(i2, RewardDislikeDialog.this.f1493h.O().get(i2));
                    } catch (Throwable unused2) {
                    }
                }
                RewardDislikeDialog.this.b();
            }
        });
        TTDislikeListView tTDislikeListView2 = (TTDislikeListView) this.a.findViewById(t.e(getContext(), "tt_filer_words_lv_second"));
        this.c = tTDislikeListView2;
        tTDislikeListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialog.4
            /* JADX WARN: Type inference failed for: r1v1, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            @Instrumented
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                VdsAgent.onItemClick(this, adapterView, view, i2, j2);
                if (RewardDislikeDialog.this.f1494i != null) {
                    try {
                        RewardDislikeDialog.this.f1494i.a(i2, (FilterWord) adapterView.getAdapter().getItem(i2));
                    } catch (Throwable unused) {
                    }
                }
                RewardDislikeDialog.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        RelativeLayout relativeLayout = this.f1489d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(relativeLayout, 8);
        }
        View view = this.f1490e;
        if (view != null) {
            view.setVisibility(8);
            VdsAgent.onSetViewVisibility(view, 8);
        }
        TTDislikeListView tTDislikeListView = this.b;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
            VdsAgent.onSetViewVisibility(tTDislikeListView, 0);
        }
        c.b bVar = this.f1492g;
        if (bVar != null) {
            bVar.a();
        }
        TTDislikeListView tTDislikeListView2 = this.c;
        if (tTDislikeListView2 != null) {
            tTDislikeListView2.setVisibility(8);
            VdsAgent.onSetViewVisibility(tTDislikeListView2, 8);
        }
    }

    public void setCallback(a aVar) {
        this.f1494i = aVar;
    }

    private void c() {
        if (this.f1493h == null) {
            return;
        }
        LayoutInflater from = LayoutInflater.from(getContext());
        c.b bVar = new c.b(from, this.f1493h.O());
        this.f1491f = bVar;
        this.b.setAdapter((ListAdapter) bVar);
        c.b bVar2 = new c.b(from, new ArrayList());
        this.f1492g = bVar2;
        bVar2.a(false);
        this.c.setAdapter((ListAdapter) this.f1492g);
        this.b.setMaterialMeta(this.f1493h);
        this.c.setMaterialMeta(this.f1493h);
    }

    public void b() {
        setVisibility(8);
        VdsAgent.onSetViewVisibility(this, 8);
        this.f1495j = false;
        a aVar = this.f1494i;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        setClickable(true);
        setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialog.1
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                RewardDislikeDialog.this.b();
            }
        });
        setBackgroundColor(Color.parseColor("#80000000"));
        this.a = LayoutInflater.from(context).inflate(t.f(context, "tt_dislike_dialog_layout"), (ViewGroup) this, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = ac.c(getContext(), 20.0f);
        layoutParams.rightMargin = ac.c(getContext(), 20.0f);
        this.a.setLayoutParams(layoutParams);
        this.a.setClickable(true);
        d();
        c();
    }

    public RewardDislikeDialog(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public RewardDislikeDialog(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardDislikeDialog(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1495j = false;
        a(context, attributeSet);
    }

    public void a() {
        if (this.a.getParent() == null) {
            addView(this.a);
        }
        e();
        setVisibility(0);
        VdsAgent.onSetViewVisibility(this, 0);
        this.f1495j = true;
        a aVar = this.f1494i;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        c.b bVar = this.f1492g;
        if (bVar != null) {
            bVar.a(filterWord.getOptions());
        }
        RelativeLayout relativeLayout = this.f1489d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(relativeLayout, 0);
        }
        View view = this.f1490e;
        if (view != null) {
            view.setVisibility(0);
            VdsAgent.onSetViewVisibility(view, 0);
        }
        TTDislikeListView tTDislikeListView = this.b;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(8);
            VdsAgent.onSetViewVisibility(tTDislikeListView, 8);
        }
        TTDislikeListView tTDislikeListView2 = this.c;
        if (tTDislikeListView2 != null) {
            tTDislikeListView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(tTDislikeListView2, 0);
        }
    }
}
