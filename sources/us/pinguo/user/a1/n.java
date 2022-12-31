package us.pinguo.user.a1;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.user.FastLoginCellFragment;
import us.pinguo.user.ui.FastLoginDialog;
/* compiled from: LoginCell.java */
/* loaded from: classes6.dex */
public class n extends us.pinguo.widget.common.cell.recycler.b<FragmentManager, us.pinguo.widget.common.cell.recycler.c> implements us.pinguo.user.recycler.a {
    private View a;

    public n(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void a(View view) {
        this.a = view;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setId(344);
        return new us.pinguo.widget.common.cell.recycler.c(frameLayout);
    }

    @Override // us.pinguo.user.recycler.a
    public boolean drawDecoration(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state) {
        return false;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return us.pinguo.user.recycler.c.TYPE_EMPTY;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        cVar.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, this.a.getHeight()));
        Fragment findFragmentByTag = ((FragmentManager) this.mData).findFragmentByTag(FirebaseAnalytics.Event.LOGIN);
        if (findFragmentByTag == null || !findFragmentByTag.isAdded()) {
            if (findFragmentByTag == null) {
                findFragmentByTag = new FastLoginCellFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(FastLoginDialog.KEY_REQ_CODE, 222);
                bundle.putInt(FastLoginDialog.KEY_POSITION, -999);
                findFragmentByTag.setArguments(bundle);
            }
            FragmentTransaction beginTransaction = ((FragmentManager) this.mData).beginTransaction();
            FragmentTransaction add = beginTransaction.add(344, findFragmentByTag, FirebaseAnalytics.Event.LOGIN);
            VdsAgent.onFragmentTransactionAdd(beginTransaction, 344, findFragmentByTag, FirebaseAnalytics.Event.LOGIN, add);
            add.commitAllowingStateLoss();
        }
    }

    @Override // us.pinguo.user.recycler.a
    public boolean setDecorationRect(us.pinguo.widget.common.cell.recycler.b bVar, us.pinguo.widget.common.cell.recycler.b bVar2, Rect rect, Rect rect2) {
        rect.set(0, 0, 0, 0);
        return true;
    }
}
