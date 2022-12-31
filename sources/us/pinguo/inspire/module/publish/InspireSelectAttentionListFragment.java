package us.pinguo.inspire.module.publish;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.foundation.base.InspireRedirectActivity;
import us.pinguo.inspire.base.easyload.EasyListFragment;
import us.pinguo.inspire.module.attention.InspireAtentionLoader;
import us.pinguo.inspire.module.attention.InspireAttention;
import us.pinguo.inspire.module.contact.ContactSearchActivity;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.inspire.module.publish.InspireSelectAttentionsCell;
import us.pinguo.user.R;
/* loaded from: classes9.dex */
public class InspireSelectAttentionListFragment extends EasyListFragment<InspireAtentionLoader.AttentionResp> implements InspireSelectAttentionsCell.OnSelectChangedListener {
    public static final String InspireAttentionList = "InspireAttentionList";
    private static final int SP_NO_MORE_ITEMS = -1;
    public static final String isFromFriend = "isFromFriend";
    private ImageView iv_right_toolbar1;
    private ImageView iv_right_toolbar2;
    private boolean addRectFirst = true;
    private boolean addFoucsFirst = true;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: us.pinguo.inspire.module.publish.InspireSelectAttentionListFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.iv_right_toolbar) {
                InspireSelectAttentionListFragment.this.onClickSelectAttentions();
            }
        }
    };
    private List<InspireSelectAttentionsCell> cells = new ArrayList();

    private void deleteDuplicate(List<InspireAttention> list) {
        if (list != null) {
            HashMap hashMap = new HashMap();
            for (InspireAttention inspireAttention : list) {
                if (hashMap.get(inspireAttention.userId) == null) {
                    hashMap.put(inspireAttention.userId, inspireAttention);
                }
            }
            list.clear();
            list.addAll(hashMap.values());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickSelectAttentions() {
        ArrayList<InspireAttention> selectedAttentions2 = getSelectedAttentions2();
        if (us.pinguo.foundation.utils.k.a(selectedAttentions2)) {
            us.pinguo.foundation.utils.j0.c(vStudio.Android.Camera360.R.string.need_select_attentions);
            return;
        }
        deleteDuplicate(selectedAttentions2);
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra(InspireAttentionList, selectedAttentions2);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void v0(View view) {
        getActivity().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public /* synthetic */ void x0(View view) {
        onClickSelectAttentions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public /* synthetic */ void z0(View view) {
        Intent intent = new Intent(getActivity(), ContactSearchActivity.class);
        intent.putExtra(isFromFriend, true);
        ((InspireRedirectActivity) getActivity()).startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.publish.InspireSelectAttentionListFragment.1
            @Override // us.pinguo.foundation.proxy.c
            public void onActivityResult(int i2, Intent intent2) {
                InspireSelectAttentionListFragment.this.getActivity().setResult(-1, intent2);
                InspireSelectAttentionListFragment.this.getActivity().finish();
            }
        });
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected HashMap<String, String> getParam() {
        HashMap<String, String> hashMap = new HashMap<>();
        String userId = us.pinguo.user.s0.getInstance().getUserId();
        hashMap.put(GuestProfileFragment.USER_ID, userId);
        hashMap.put("masterId", userId);
        hashMap.put("recommend", getRecommendFlag() + "");
        hashMap.put("sort", String.valueOf(2));
        return hashMap;
    }

    public int getRecommendFlag() {
        return 1;
    }

    protected ArrayList<InspireAttention> getSelectedAttentions() {
        List<us.pinguo.widget.common.cell.recycler.b> cells = this.mAdapter.getCells();
        if (cells != null) {
            ArrayList<InspireAttention> arrayList = new ArrayList<>();
            for (us.pinguo.widget.common.cell.recycler.b bVar : cells) {
                if (bVar instanceof InspireSelectAttentionsCell) {
                    InspireSelectAttentionsCell inspireSelectAttentionsCell = (InspireSelectAttentionsCell) bVar;
                    if (inspireSelectAttentionsCell.mSelected) {
                        arrayList.add(inspireSelectAttentionsCell.getData());
                    }
                }
            }
            return arrayList;
        }
        return new ArrayList<>();
    }

    public ArrayList<InspireAttention> getSelectedAttentions2() {
        ArrayList<InspireAttention> arrayList = new ArrayList<>();
        for (InspireSelectAttentionsCell inspireSelectAttentionsCell : this.cells) {
            if (inspireSelectAttentionsCell instanceof InspireSelectAttentionsCell) {
                InspireSelectAttentionsCell inspireSelectAttentionsCell2 = inspireSelectAttentionsCell;
                if (inspireSelectAttentionsCell2.mSelected) {
                    arrayList.add(inspireSelectAttentionsCell2.getData());
                }
            }
        }
        return arrayList;
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public Type getType() {
        return new com.google.gson.t.a<BaseResponse<InspireAtentionLoader.AttentionResp>>() { // from class: us.pinguo.inspire.module.publish.InspireSelectAttentionListFragment.3
        }.getType();
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected String getUrl() {
        return "/user/friend/follows";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public void initConfig() {
        super.initConfig();
        setForceRefreshEnabled(false);
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected void initTitle() {
        View inflate = LayoutInflater.from(getContext()).inflate(vStudio.Android.Camera360.R.layout.attention_header_title, (ViewGroup) null);
        Toolbar toolbar = (Toolbar) inflate.findViewById(vStudio.Android.Camera360.R.id.compatible_toolbar_res_0x7d06006a);
        toolbar.setBackgroundColor(-1);
        toolbar.setTitleTextColor(getResources().getColor(us.pinguo.foundation.R.color.light_main_title_text));
        toolbar.setTitleTextAppearance(getActivity(), R.style.ToolBar_TextSize);
        toolbar.setTitle(vStudio.Android.Camera360.R.string.select_attention_title);
        toolbar.setNavigationIcon(us.pinguo.ui.R.drawable.navigation_back_black);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.publish.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InspireSelectAttentionListFragment.this.v0(view);
            }
        });
        ImageView imageView = (ImageView) inflate.findViewById(vStudio.Android.Camera360.R.id.iv_right_toolbar1);
        this.iv_right_toolbar1 = imageView;
        imageView.setVisibility(0);
        this.iv_right_toolbar1.setImageResource(vStudio.Android.Camera360.R.drawable.inspire_attention_search_two);
        ImageView imageView2 = (ImageView) inflate.findViewById(vStudio.Android.Camera360.R.id.iv_right_toolbar2);
        this.iv_right_toolbar2 = imageView2;
        imageView2.setVisibility(0);
        this.iv_right_toolbar2.setImageResource(vStudio.Android.Camera360.R.drawable.inspire_attention_unselect);
        this.iv_right_toolbar2.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.publish.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InspireSelectAttentionListFragment.this.x0(view);
            }
        });
        this.iv_right_toolbar1.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.publish.b1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InspireSelectAttentionListFragment.this.z0(view);
            }
        });
        replaceTitle(inflate);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment, us.pinguo.inspire.base.BaseAbsListFragment
    public void onDataRefresh() {
        super.onDataRefresh();
        this.addRectFirst = true;
        this.addFoucsFirst = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment, us.pinguo.inspire.base.BaseAbsListFragment
    public void onLoadMore() {
        super.onLoadMore();
        this.addRectFirst = false;
        this.addFoucsFirst = false;
    }

    @Override // us.pinguo.inspire.module.publish.InspireSelectAttentionsCell.OnSelectChangedListener
    public void onSelectChanged(InspireSelectAttentionsCell inspireSelectAttentionsCell, boolean z) {
        if (this.cells.contains(inspireSelectAttentionsCell)) {
            this.cells.remove(inspireSelectAttentionsCell);
        }
        if (z) {
            this.cells.add(inspireSelectAttentionsCell);
        }
        if (getSelectedAttentions().size() == 0) {
            this.iv_right_toolbar2.setImageResource(vStudio.Android.Camera360.R.drawable.inspire_attention_unselect);
        } else {
            this.iv_right_toolbar2.setImageResource(vStudio.Android.Camera360.R.drawable.inspire_attention_select);
        }
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment, us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setDeleteDuplicateEanbled(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public void setCacheEnabled(boolean z) {
        super.setCacheEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public HashMap<String, String> addParamForPage(InspireAtentionLoader.AttentionResp attentionResp) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("sp", attentionResp.sp.toPlainString());
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b> appendCells(InspireAtentionLoader.AttentionResp attentionResp) {
        return createCells(attentionResp, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b> createCells(InspireAtentionLoader.AttentionResp attentionResp) {
        return createCells(attentionResp, true);
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public boolean isLoadMoreEnable(InspireAtentionLoader.AttentionResp attentionResp) {
        BigDecimal bigDecimal;
        return attentionResp == null || (bigDecimal = attentionResp.sp) == null || bigDecimal.intValue() != -1;
    }

    private List<us.pinguo.widget.common.cell.recycler.b> createCells(InspireAtentionLoader.AttentionResp attentionResp, boolean z) {
        List<InspireAttention> list = attentionResp.list;
        List<InspireAttention> list2 = attentionResp.recentList;
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        if (list2 != null && !list2.isEmpty()) {
            if (this.addRectFirst) {
                arrayList.add(new HeaderCell(getContext().getString(vStudio.Android.Camera360.R.string.notify_recent_linkman)));
            }
            boolean z2 = true;
            for (InspireAttention inspireAttention : list2) {
                InspireSelectAttentionsCell inspireSelectAttentionsCell = new InspireSelectAttentionsCell(inspireAttention);
                inspireSelectAttentionsCell.setOnSelectChangedListener(this);
                if (z2 && z) {
                    inspireSelectAttentionsCell.setFirst(true);
                    z2 = false;
                }
                arrayList.add(inspireSelectAttentionsCell);
            }
            ((InspireSelectAttentionsCell) arrayList.get(arrayList.size() - 1)).setRecentLast(true);
        }
        if (list != null) {
            if (this.addFoucsFirst && z) {
                arrayList.add(new HeaderCell(getContext().getString(attentionResp.isRecommend == 0 ? vStudio.Android.Camera360.R.string.notify_focus_linkman : vStudio.Android.Camera360.R.string.system_recommend_users)));
            }
            boolean z3 = true;
            for (InspireAttention inspireAttention2 : list) {
                InspireSelectAttentionsCell inspireSelectAttentionsCell2 = new InspireSelectAttentionsCell(inspireAttention2);
                inspireSelectAttentionsCell2.setOnSelectChangedListener(this);
                if (z3 && z) {
                    inspireSelectAttentionsCell2.setFirst(true);
                    z3 = false;
                }
                arrayList.add(inspireSelectAttentionsCell2);
            }
        }
        return arrayList;
    }
}
