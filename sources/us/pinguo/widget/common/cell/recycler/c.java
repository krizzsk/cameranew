package us.pinguo.widget.common.cell.recycler;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: BaseRecyclerViewHolder.java */
/* loaded from: classes6.dex */
public class c extends RecyclerView.ViewHolder {
    private static final int INVALID = -1324671;
    private int backupItemViewParamHeight;
    private int backupItemViewParamWidth;
    private a mOnViewRecycledListener;
    private SparseArray<View> mViews;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseRecyclerViewHolder.java */
    /* loaded from: classes6.dex */
    public interface a {
        void onViewRecycled();
    }

    public c(View view) {
        super(view);
        this.backupItemViewParamWidth = INVALID;
        this.backupItemViewParamHeight = INVALID;
        this.mViews = new SparseArray<>();
    }

    public <T extends View> T getView(int i2) {
        T t = (T) this.mViews.get(i2);
        if (t == null) {
            T t2 = (T) this.itemView.findViewById(i2);
            this.mViews.put(i2, t2);
            return t2;
        }
        return t;
    }

    public void hide(int i2) {
        View view = getView(i2);
        if (view != null) {
            view.setVisibility(8);
            VdsAgent.onSetViewVisibility(view, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onViewRecycled() {
        a aVar = this.mOnViewRecycledListener;
        if (aVar != null) {
            aVar.onViewRecycled();
            this.mOnViewRecycledListener = null;
        }
    }

    public void setBackgroundRes(int i2, int i3) {
        if (i3 != 0) {
            getView(i2).setBackgroundResource(i3);
        }
    }

    public void setEnabled(int i2, boolean z) {
        getView(i2).setEnabled(z);
    }

    public void setImageBitmap(int i2, Bitmap bitmap) {
        ((ImageView) getView(i2)).setImageBitmap(bitmap);
    }

    public void setImageResource(int i2, int i3) {
        if (i3 != 0) {
            ((ImageView) getView(i2)).setImageResource(i3);
        }
    }

    public void setOnClickListener(int i2, View.OnClickListener onClickListener) {
        View view = getView(i2);
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnViewRecycledListener(a aVar) {
        this.mOnViewRecycledListener = aVar;
    }

    public void setSelected(int i2, boolean z) {
        getView(i2).setSelected(z);
    }

    public void setTag(int i2, String str) {
        getView(i2).setTag(str);
    }

    public void setText(int i2, CharSequence charSequence) {
        TextView textView = (TextView) getView(i2);
        if (charSequence == null) {
            charSequence = "";
        }
        textView.setText(charSequence);
    }

    public void setVisibility(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
        if (z) {
            int i2 = this.backupItemViewParamWidth;
            if (i2 != INVALID) {
                layoutParams.width = i2;
            }
            int i3 = this.backupItemViewParamHeight;
            if (i3 != INVALID) {
                layoutParams.height = i3;
            }
            View view = this.itemView;
            view.setVisibility(0);
            VdsAgent.onSetViewVisibility(view, 0);
        } else {
            View view2 = this.itemView;
            view2.setVisibility(8);
            VdsAgent.onSetViewVisibility(view2, 8);
            this.backupItemViewParamWidth = layoutParams.width;
            this.backupItemViewParamHeight = layoutParams.height;
            layoutParams.height = 0;
            layoutParams.width = 0;
        }
        this.itemView.setLayoutParams(layoutParams);
    }

    public void setVisible(int i2, int i3) {
        View view = getView(i2);
        view.setVisibility(i3);
        VdsAgent.onSetViewVisibility(view, i3);
    }

    public void show(int i2) {
        View view = getView(i2);
        if (view != null) {
            view.setVisibility(0);
            VdsAgent.onSetViewVisibility(view, 0);
        }
    }

    public void setText(int i2, int i3) {
        ((TextView) getView(i2)).setText(i3);
    }
}
