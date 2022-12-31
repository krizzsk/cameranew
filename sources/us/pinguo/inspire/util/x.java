package us.pinguo.inspire.util;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.user.R;
import us.pinguo.user.util.f;
/* compiled from: ToolbarUtils.java */
/* loaded from: classes9.dex */
public class x {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ToolbarUtils.java */
    /* loaded from: classes9.dex */
    public class a implements f.b {
        final /* synthetic */ RecyclerView a;

        a(RecyclerView recyclerView) {
            this.a = recyclerView;
        }

        @Override // us.pinguo.user.util.f.b
        public void onDoubleClick(View view) {
            this.a.smoothScrollToPosition(0);
        }

        @Override // us.pinguo.user.util.f.b
        public void onSingleClick(View view) {
        }
    }

    public static void a(Toolbar toolbar, RecyclerView recyclerView) {
        final a aVar = new a(recyclerView);
        final us.pinguo.user.util.f fVar = new us.pinguo.user.util.f();
        toolbar.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.util.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                us.pinguo.user.util.f.this.d(view, aVar);
            }
        });
    }

    public static void b(Toolbar toolbar, final RecyclerView recyclerView) {
        toolbar.setTitleTextColor(0);
        toolbar.setTitleTextAppearance(recyclerView.getContext(), R.style.ToolBar_TextSize);
        toolbar.setNavigationIcon(us.pinguo.ui.R.drawable.navigation_back_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.util.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x.d(RecyclerView.this, view);
            }
        });
        recyclerView.addOnScrollListener(new us.pinguo.inspire.widget.k.a(toolbar));
        a(toolbar, recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(RecyclerView recyclerView, View view) {
        if (recyclerView.getContext() instanceof Activity) {
            ((Activity) recyclerView.getContext()).onBackPressed();
        }
    }
}
