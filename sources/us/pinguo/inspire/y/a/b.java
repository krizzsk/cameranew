package us.pinguo.inspire.y.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import kotlin.jvm.internal.s;
import us.pinguo.inspire.y.a.c;
/* compiled from: BasePagerCell.kt */
/* loaded from: classes9.dex */
public abstract class b<DATA, VH extends c> {
    private DATA mData;
    private VH mViewHolder;

    public b(DATA data) {
        this.mData = data;
    }

    public final void bindViewHolder(VH viewHolder) {
        s.h(viewHolder, "viewHolder");
        this.mViewHolder = viewHolder;
        onBindViewHolder(viewHolder);
    }

    protected final c createHolderByLayout(int i2, ViewGroup parent) {
        s.h(parent, "parent");
        return new c(LayoutInflater.from(parent.getContext()).inflate(i2, parent, false));
    }

    public abstract VH createViewHolder(ViewGroup viewGroup);

    public final DATA getData() {
        return this.mData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DATA getMData() {
        return this.mData;
    }

    public final VH getMViewHolder() {
        return this.mViewHolder;
    }

    public abstract int getType();

    public int hashCode() {
        DATA data = this.mData;
        if (data != null) {
            s.e(data);
            return data.hashCode();
        }
        return super.hashCode();
    }

    protected abstract void onBindViewHolder(VH vh);

    public void onViewRecycled() {
        this.mViewHolder = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMData(DATA data) {
        this.mData = data;
    }

    public final void setMViewHolder(VH vh) {
        this.mViewHolder = vh;
    }

    public final void updateData(DATA data) {
        this.mData = data;
        VH vh = this.mViewHolder;
        if (vh != null) {
            s.e(vh);
            onBindViewHolder(vh);
        }
    }
}
