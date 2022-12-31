package us.pinguo.widget.common.cell.recycler;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import us.pinguo.widget.common.cell.recycler.c;
/* compiled from: BaseRecyclerCell.java */
/* loaded from: classes6.dex */
public abstract class b<T, VH extends c> implements c.a {
    protected boolean clickable = true;
    public a mAdapter;
    protected T mData;
    private Rect mDecorationRect;
    protected boolean mDestroyed;
    private boolean mIsShown;
    protected RecyclerView mRecyclerView;
    public VH mViewHolder;

    public b(T t) {
        this.mData = t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean areContentsTheSame(b bVar) {
        if (bVar == null) {
            return false;
        }
        DiffMode diffMode = getDiffMode();
        if (diffMode != null && diffMode == DiffMode.UNIQUE) {
            return getClass().isInstance(bVar);
        }
        return isDataEquals(bVar.getData());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean areItemsTheSame(b bVar) {
        if (bVar != null && getClass().isInstance(bVar)) {
            T t = this.mData;
            if (!(t instanceof d)) {
                return t != null && t.equals(bVar.getData());
            }
            String a = ((d) t).a();
            String a2 = ((d) bVar.getData()).a();
            return a == a2 || (a != null && a.equals(a2));
        }
        return false;
    }

    public final void bindViewHolder(VH vh) {
        bindViewHolder(vh, null);
    }

    public boolean checkShowVisible() {
        View view;
        VH vh = this.mViewHolder;
        if (vh == null || (view = vh.itemView) == null || view.getParent() == null) {
            return false;
        }
        float visibleAreaForShowEvent = getVisibleAreaForShowEvent();
        if (visibleAreaForShowEvent > 0.0f && visibleAreaForShowEvent < 1.0f) {
            int top = this.mViewHolder.itemView.getTop();
            int bottom = this.mViewHolder.itemView.getBottom();
            int height = ((View) this.mViewHolder.itemView.getParent()).getHeight();
            if (bottom < 0 || top > height) {
                us.pinguo.common.log.a.k(getClass().getSimpleName() + "完全在屏幕外:false", new Object[0]);
                return false;
            } else if ((top <= 0 && bottom >= height) || (top > 0 && bottom < height)) {
                us.pinguo.common.log.a.k(getClass().getSimpleName() + "完全展示:true", new Object[0]);
                return true;
            } else {
                float height2 = (top < 0 ? bottom : height - top) / this.mViewHolder.itemView.getHeight();
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getSimpleName());
                sb.append("展示面积:");
                sb.append(height2);
                sb.append(" 要求展示面积:");
                sb.append(visibleAreaForShowEvent);
                sb.append(" ");
                int i2 = (height2 > visibleAreaForShowEvent ? 1 : (height2 == visibleAreaForShowEvent ? 0 : -1));
                sb.append(i2 > 0);
                us.pinguo.common.log.a.k(sb.toString(), new Object[0]);
                return i2 > 0;
            }
        }
        us.pinguo.common.log.a.k(getClass().getSimpleName() + "无要求:true", new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c createHolderByLayout(int i2, ViewGroup viewGroup) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false));
    }

    public abstract VH createViewHolder(ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Object getChangePayload(b bVar) {
        return null;
    }

    public T getData() {
        return this.mData;
    }

    public Rect getDecorationRect() {
        return this.mDecorationRect;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DiffMode getDiffMode() {
        return DiffMode.DATA;
    }

    public abstract int getType();

    public float getVisibleAreaForShowEvent() {
        return 0.0f;
    }

    public int hashCode() {
        T t = this.mData;
        if (t != null) {
            return t.hashCode();
        }
        return super.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isDataEquals(Object obj) {
        T t = this.mData;
        return t == obj || (t != null && t.equals(obj));
    }

    public boolean isShown() {
        return this.mIsShown;
    }

    protected abstract void onBindViewHolder(VH vh);

    protected void onBindViewHolder(VH vh, List<Object> list) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroyView() {
        this.mDestroyed = true;
        this.mViewHolder = null;
        this.mAdapter = null;
        this.mRecyclerView = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onHide() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onShow() {
    }

    @Override // us.pinguo.widget.common.cell.recycler.c.a
    public void onViewRecycled() {
        this.mViewHolder = null;
    }

    public void releaseResource() {
    }

    public void reloadResource() {
    }

    public <C extends b, VH extends c> void setAdapter(a<C, VH> aVar) {
        this.mAdapter = aVar;
    }

    public void setClickable(boolean z) {
        if (this.clickable != z) {
            this.clickable = z;
            VH vh = this.mViewHolder;
            if (vh != null) {
                onBindViewHolder(vh);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setData(T t) {
        this.mData = t;
    }

    public void setDecorationRect(Rect rect) {
        this.mDecorationRect = rect;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    public void setShown(boolean z) {
        if (!this.mIsShown && z) {
            if (!checkShowVisible()) {
                return;
            }
            onShow();
        }
        if (this.mIsShown && !z) {
            onHide();
        }
        this.mIsShown = z;
    }

    public void updateData(T t) {
        this.mData = t;
        VH vh = this.mViewHolder;
        if (vh != null) {
            onBindViewHolder(vh);
        }
    }

    public final void bindViewHolder(VH vh, List<Object> list) {
        this.mViewHolder = vh;
        if (vh != null) {
            vh.setOnViewRecycledListener(this);
        }
        setShown(true);
        if (list != null && list.size() != 0) {
            onBindViewHolder(vh, list);
        } else {
            onBindViewHolder(vh);
        }
    }
}
