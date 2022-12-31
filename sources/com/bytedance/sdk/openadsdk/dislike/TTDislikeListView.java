package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TTDislikeListView extends ListView {
    private h a;
    private AdapterView.OnItemClickListener b;
    private AdapterView.OnItemClickListener c;

    public TTDislikeListView(Context context) {
        super(context);
        this.c = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            @Instrumented
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                VdsAgent.onItemClick(this, adapterView, view, i2, j2);
                if (TTDislikeListView.this.getAdapter() != null && TTDislikeListView.this.getAdapter().getItem(i2) != null && (TTDislikeListView.this.getAdapter().getItem(i2) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i2);
                    if (!filterWord.hasSecondOptions()) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(filterWord);
                        if (TTDislikeListView.this.a != null) {
                            d.a(TTDislikeListView.this.a, arrayList);
                        }
                    }
                    try {
                        if (TTDislikeListView.this.b != null) {
                            TTDislikeListView.this.b.onItemClick(adapterView, view, i2, j2);
                            return;
                        }
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        a();
    }

    public void setMaterialMeta(h hVar) {
        this.a = hVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener onItemClickListener) {
        this.b = onItemClickListener;
    }

    private void a() {
        super.setOnItemClickListener(this.c);
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            @Instrumented
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                VdsAgent.onItemClick(this, adapterView, view, i2, j2);
                if (TTDislikeListView.this.getAdapter() != null && TTDislikeListView.this.getAdapter().getItem(i2) != null && (TTDislikeListView.this.getAdapter().getItem(i2) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i2);
                    if (!filterWord.hasSecondOptions()) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(filterWord);
                        if (TTDislikeListView.this.a != null) {
                            d.a(TTDislikeListView.this.a, arrayList);
                        }
                    }
                    try {
                        if (TTDislikeListView.this.b != null) {
                            TTDislikeListView.this.b.onItemClick(adapterView, view, i2, j2);
                            return;
                        }
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        a();
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            @Instrumented
            public void onItemClick(AdapterView<?> adapterView, View view, int i22, long j2) {
                VdsAgent.onItemClick(this, adapterView, view, i22, j2);
                if (TTDislikeListView.this.getAdapter() != null && TTDislikeListView.this.getAdapter().getItem(i22) != null && (TTDislikeListView.this.getAdapter().getItem(i22) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i22);
                    if (!filterWord.hasSecondOptions()) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(filterWord);
                        if (TTDislikeListView.this.a != null) {
                            d.a(TTDislikeListView.this.a, arrayList);
                        }
                    }
                    try {
                        if (TTDislikeListView.this.b != null) {
                            TTDislikeListView.this.b.onItemClick(adapterView, view, i22, j2);
                            return;
                        }
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        a();
    }
}
