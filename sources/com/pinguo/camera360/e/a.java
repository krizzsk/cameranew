package com.pinguo.camera360.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import java.util.List;
/* compiled from: AdapterBase.java */
/* loaded from: classes3.dex */
public abstract class a extends BaseAdapter {
    private List a;
    private Context b;
    private LayoutInflater c;

    public a(Context context, List list) {
        this.b = context;
        this.a = list;
        this.c = LayoutInflater.from(context);
    }

    public LayoutInflater a() {
        return this.c;
    }

    public List b() {
        return this.a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.a.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }
}
