package us.pinguo.inspire.module.profile;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes9.dex */
public class GridSpaceDecoration extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int a = us.pinguo.foundation.t.b.a.a(recyclerView.getContext(), 3.0f);
        rect.bottom = a;
        rect.right = a;
        if (recyclerView.getChildAdapterPosition(view) % 3 == 0) {
            rect.right = 0;
        } else {
            rect.right = rect.bottom;
        }
    }
}
