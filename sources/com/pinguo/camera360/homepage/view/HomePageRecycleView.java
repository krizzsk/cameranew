package com.pinguo.camera360.homepage.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
/* compiled from: HomePageRecycleView.kt */
/* loaded from: classes3.dex */
public final class HomePageRecycleView extends RecyclerView {
    private ArrayList<RecyclerView.ItemDecoration> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageRecycleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s.h(context, "context");
        new LinkedHashMap();
        this.a = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void addItemDecoration(RecyclerView.ItemDecoration decor) {
        s.h(decor, "decor");
        super.addItemDecoration(decor);
        this.a.add(decor);
    }
}
