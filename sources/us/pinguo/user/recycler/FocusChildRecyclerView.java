package us.pinguo.user.recycler;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class FocusChildRecyclerView extends FlingFilterRecyclerView {
    private a mGetFocusChild;

    /* loaded from: classes6.dex */
    public interface a {
        View getFocusChild(FocusChildRecyclerView focusChildRecyclerView);
    }

    public FocusChildRecyclerView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public View getFocusedChild() {
        a aVar = this.mGetFocusChild;
        if (aVar != null) {
            return aVar.getFocusChild(this);
        }
        return super.getFocusedChild();
    }

    public void setGetFocusChild(a aVar) {
        this.mGetFocusChild = aVar;
    }

    public View superGetFocusedChild() {
        return super.getFocusedChild();
    }

    public FocusChildRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FocusChildRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
