package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.List;
/* compiled from: TTDislikeDialogDefault.java */
/* loaded from: classes.dex */
public class c extends TTDislikeDialogAbstract {
    private TTDislikeListView a;
    private TTDislikeListView b;
    private RelativeLayout c;

    /* renamed from: d  reason: collision with root package name */
    private View f1948d;

    /* renamed from: e  reason: collision with root package name */
    private b f1949e;

    /* renamed from: f  reason: collision with root package name */
    private b f1950f;

    /* renamed from: g  reason: collision with root package name */
    private h f1951g;

    /* renamed from: h  reason: collision with root package name */
    private a f1952h;

    /* compiled from: TTDislikeDialogDefault.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(int i2, FilterWord filterWord);

        void b();

        void c();
    }

    /* compiled from: TTDislikeDialogDefault.java */
    /* loaded from: classes.dex */
    public static class b extends BaseAdapter {
        private boolean a = true;
        private final List<FilterWord> b;
        private final LayoutInflater c;

        /* compiled from: TTDislikeDialogDefault.java */
        /* loaded from: classes.dex */
        private static class a {
            TextView a;
            ImageView b;

            private a() {
            }
        }

        public b(LayoutInflater layoutInflater, List<FilterWord> list) {
            this.b = list;
            this.c = layoutInflater;
        }

        public void a(boolean z) {
            this.a = z;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<FilterWord> list = this.b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return this.b.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            View view2;
            a aVar;
            if (view == null) {
                aVar = new a();
                LayoutInflater layoutInflater = this.c;
                view2 = layoutInflater.inflate(t.f(layoutInflater.getContext(), "tt_dialog_listview_item"), viewGroup, false);
                aVar.a = (TextView) view2.findViewById(t.e(this.c.getContext(), "tt_item_tv"));
                aVar.b = (ImageView) view2.findViewById(t.e(this.c.getContext(), "tt_item_arrow"));
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            FilterWord filterWord = this.b.get(i2);
            aVar.a.setText(filterWord.getName());
            if (i2 != this.b.size() - 1) {
                aVar.a.setBackgroundResource(t.d(this.c.getContext(), "tt_dislike_middle_seletor"));
            } else {
                aVar.a.setBackgroundResource(t.d(this.c.getContext(), "tt_dislike_bottom_seletor"));
            }
            if (this.a && i2 == 0) {
                aVar.a.setBackgroundResource(t.d(this.c.getContext(), "tt_dislike_top_seletor"));
            }
            if (filterWord.hasSecondOptions()) {
                aVar.b.setVisibility(0);
            } else {
                aVar.b.setVisibility(8);
            }
            return view2;
        }

        public void a(List<FilterWord> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            this.b.clear();
            this.b.addAll(list);
            notifyDataSetChanged();
        }

        public void a() {
            this.b.clear();
            notifyDataSetChanged();
        }
    }

    public c(Context context, h hVar) {
        super(context, t.g(context, "tt_dislikeDialog"));
        this.f1951g = hVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public int getLayoutId() {
        return t.f(getContext(), "tt_dislike_dialog_layout");
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public ViewGroup.LayoutParams getLayoutParams() {
        return new ViewGroup.LayoutParams(ac.c(getContext()) - 120, -2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public int[] getTTDislikeListViewIds() {
        return new int[]{t.e(getContext(), "tt_filer_words_lv"), t.e(getContext(), "tt_filer_words_lv_second")};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        a();
        a(getContext());
        b();
        setMaterialMeta(this.f1951g);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        VdsAgent.showDialog(this);
        c();
    }

    private void b() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (c.this.f1952h != null) {
                    c.this.f1952h.a();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (c.this.f1952h != null) {
                    c.this.f1952h.b();
                }
            }
        });
        b bVar = new b(getLayoutInflater(), this.f1951g.O());
        this.f1949e = bVar;
        this.a.setAdapter((ListAdapter) bVar);
        b bVar2 = new b(getLayoutInflater(), new ArrayList());
        this.f1950f = bVar2;
        bVar2.a(false);
        this.b.setAdapter((ListAdapter) this.f1950f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        RelativeLayout relativeLayout = this.c;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(relativeLayout, 8);
        }
        View view = this.f1948d;
        if (view != null) {
            view.setVisibility(8);
            VdsAgent.onSetViewVisibility(view, 8);
        }
        TTDislikeListView tTDislikeListView = this.a;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
            VdsAgent.onSetViewVisibility(tTDislikeListView, 0);
        }
        b bVar = this.f1950f;
        if (bVar != null) {
            bVar.a();
        }
        TTDislikeListView tTDislikeListView2 = this.b;
        if (tTDislikeListView2 != null) {
            tTDislikeListView2.setVisibility(8);
            VdsAgent.onSetViewVisibility(tTDislikeListView2, 8);
        }
    }

    public void a(h hVar) {
        b bVar = this.f1949e;
        if (bVar == null || hVar == null) {
            return;
        }
        this.f1951g = hVar;
        bVar.a(hVar.O());
        setMaterialMeta(this.f1951g);
    }

    public void a(a aVar) {
        this.f1952h = aVar;
    }

    private void a() {
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = 50;
            window.setAttributes(attributes);
        }
    }

    private void a(Context context) {
        this.c = (RelativeLayout) findViewById(t.e(getContext(), "tt_dislike_title_content"));
        this.f1948d = findViewById(t.e(getContext(), "tt_dislike_line1"));
        findViewById(t.e(getContext(), "tt_dislike_header_back")).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.3
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                c.this.c();
                if (c.this.f1952h != null) {
                    c.this.f1952h.c();
                }
            }
        });
        TTDislikeListView tTDislikeListView = (TTDislikeListView) findViewById(t.e(getContext(), "tt_filer_words_lv"));
        this.a = tTDislikeListView;
        tTDislikeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.4
            /* JADX WARN: Type inference failed for: r1v6, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            @Instrumented
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                VdsAgent.onItemClick(this, adapterView, view, i2, j2);
                try {
                    FilterWord filterWord = (FilterWord) adapterView.getAdapter().getItem(i2);
                    if (filterWord.hasSecondOptions()) {
                        c.this.a(filterWord);
                        if (c.this.f1952h != null) {
                            c.this.f1952h.a(i2, filterWord);
                            return;
                        }
                        return;
                    }
                } catch (Throwable unused) {
                }
                if (c.this.f1952h != null) {
                    try {
                        c.this.f1952h.a(i2, c.this.f1951g.O().get(i2));
                    } catch (Throwable unused2) {
                    }
                }
                c.this.dismiss();
            }
        });
        TTDislikeListView tTDislikeListView2 = (TTDislikeListView) findViewById(t.e(getContext(), "tt_filer_words_lv_second"));
        this.b = tTDislikeListView2;
        tTDislikeListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.c.5
            /* JADX WARN: Type inference failed for: r1v1, types: [android.widget.Adapter] */
            @Override // android.widget.AdapterView.OnItemClickListener
            @Instrumented
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                VdsAgent.onItemClick(this, adapterView, view, i2, j2);
                if (c.this.f1952h != null) {
                    try {
                        c.this.f1952h.a(i2, (FilterWord) adapterView.getAdapter().getItem(i2));
                    } catch (Throwable unused) {
                    }
                }
                c.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        b bVar = this.f1950f;
        if (bVar != null) {
            bVar.a(filterWord.getOptions());
        }
        RelativeLayout relativeLayout = this.c;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(relativeLayout, 0);
        }
        View view = this.f1948d;
        if (view != null) {
            view.setVisibility(0);
            VdsAgent.onSetViewVisibility(view, 0);
        }
        TTDislikeListView tTDislikeListView = this.a;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(8);
            VdsAgent.onSetViewVisibility(tTDislikeListView, 8);
        }
        TTDislikeListView tTDislikeListView2 = this.b;
        if (tTDislikeListView2 != null) {
            tTDislikeListView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(tTDislikeListView2, 0);
        }
    }
}
