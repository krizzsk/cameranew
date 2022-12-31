package us.pinguo.inspire.module.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action1;
import us.pinguo.inspire.base.BaseAbsListFragment;
import us.pinguo.inspire.module.attention.AttentionItemCell;
import us.pinguo.inspire.module.attention.FromFriendItemCell;
import us.pinguo.inspire.module.attention.InspireAtentionLoader;
import us.pinguo.inspire.module.attention.InspireAttention;
import us.pinguo.inspire.module.publish.InspireSelectAttentionListFragment;
import us.pinguo.user.s0;
import us.pinguo.user.ui.view.CompatibleToolbar;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class SearchFragment extends BaseAbsListFragment implements FromFriendItemCell.OnSelectListener {
    private boolean isFromFriend;
    private ImageView mClearIcon;
    private boolean mClickSearch;
    private EditText mSearchEditText;
    private String mSearchKeyName;
    private BigDecimal mSearchSp;
    private RecyclerView.OnScrollListener mKeyboardOnScrollListener = new RecyclerView.OnScrollListener() { // from class: us.pinguo.inspire.module.contact.SearchFragment.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 1) {
                SearchFragment.this.hideSoftInput();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
        }
    };
    private Runnable doSearchRunnable = new Runnable() { // from class: us.pinguo.inspire.module.contact.SearchFragment.3
        @Override // java.lang.Runnable
        public void run() {
            SearchFragment.this.search(s0.getInstance().getUserId(), SearchFragment.this.mSearchEditText.getText().toString());
        }
    };

    private void appendData(List<InspireAttention> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.mAdapter.addAll(getItemCells(list));
    }

    private boolean doSearch() {
        String obj = this.mSearchEditText.getText().toString();
        us.pinguo.common.log.a.m("zhouwei", "content;" + obj, new Object[0]);
        us.pinguo.user.util.k.a(this.mSearchEditText, getContext());
        if (TextUtils.isEmpty(obj)) {
            Toast.makeText(getActivity(), getString(R.string.search_fragment_msg), 0).show();
            return false;
        }
        search(s0.getInstance().getUserId(), obj);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0 */
    public /* synthetic */ void f0(View view) {
        this.mSearchEditText.getEditableText().clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ boolean h0(TextView textView, int i2, KeyEvent keyEvent) {
        this.mClickSearch = true;
        return doSearch();
    }

    private List<us.pinguo.widget.common.cell.recycler.b> getItemCells(List<InspireAttention> list) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        if (this.isFromFriend) {
            if (list != null) {
                while (i2 < list.size()) {
                    FromFriendItemCell fromFriendItemCell = new FromFriendItemCell(list.get(i2));
                    fromFriendItemCell.setOnSelectListener(this);
                    arrayList.add(fromFriendItemCell);
                    i2++;
                }
            }
        } else if (list != null) {
            while (i2 < list.size()) {
                arrayList.add(new AttentionItemCell(list.get(i2)));
                i2++;
            }
        }
        return arrayList;
    }

    private void hideLoading() {
        this.mAdapter.hideLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hideSoftInput() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager == null || !inputMethodManager.isActive()) {
            return false;
        }
        return inputMethodManager.hideSoftInputFromWindow(this.mSearchEditText.getApplicationWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public /* synthetic */ void j0(View view, boolean z) {
        if (z) {
            return;
        }
        us.pinguo.user.util.k.a(this.mSearchEditText, view.getContext());
    }

    private void initSearch() {
        this.mSearchEditText.addTextChangedListener(new us.pinguo.foundation.ui.g() { // from class: us.pinguo.inspire.module.contact.SearchFragment.2
            @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                us.pinguo.common.log.a.d("zhouwei", "afterTextChanged......", new Object[0]);
                SearchFragment.this.mClickSearch = false;
                SearchFragment.this.mSearchEditText.removeCallbacks(SearchFragment.this.doSearchRunnable);
                if (TextUtils.isEmpty(SearchFragment.this.mSearchEditText.getText().toString())) {
                    SearchFragment.this.mClearIcon.setVisibility(8);
                    ((BaseAbsListFragment) SearchFragment.this).mAdapter.clear();
                    return;
                }
                SearchFragment.this.mClearIcon.setVisibility(0);
                SearchFragment.this.mSearchEditText.postDelayed(SearchFragment.this.doSearchRunnable, 500L);
            }
        });
        this.mClearIcon.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.contact.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchFragment.this.f0(view);
            }
        });
        this.mSearchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: us.pinguo.inspire.module.contact.k0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return SearchFragment.this.h0(textView, i2, keyEvent);
            }
        });
        this.mSearchEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: us.pinguo.inspire.module.contact.o0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                SearchFragment.this.j0(view, z);
            }
        });
        this.mSearchEditText.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void l0(InspireAtentionLoader.AttentionResp attentionResp) {
        this.mSearchSp = attentionResp.sp;
        appendData(attentionResp.list);
        this.mAdapter.hideFooter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void n0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        d.f.a.b.d.c(th);
        this.mAdapter.hideFooter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void p0(View view) {
        getActivity().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void r0(String str, InspireAtentionLoader.AttentionResp attentionResp) {
        if (!TextUtils.isEmpty(str) && this.mSearchEditText.getText().toString().trim().equals(str.trim())) {
            this.mSearchSp = attentionResp.sp;
            setData(attentionResp.list);
            hideLoading();
            return;
        }
        this.mAdapter.clear();
        this.mAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void t0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        d.f.a.b.d.c(th);
        hideLoading();
    }

    private void setData(List<InspireAttention> list) {
        if (this.mClickSearch && (list == null || list.size() == 0)) {
            us.pinguo.inspire.base.c.h(this.mAdapter);
        } else {
            this.mAdapter.set(getItemCells(list));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void initRecycleView(RecyclerView recyclerView, us.pinguo.widget.common.cell.recycler.a aVar) {
        super.initRecycleView(recyclerView, aVar);
        recyclerView.addOnScrollListener(this.mKeyboardOnScrollListener);
        this.isFromFriend = ((Boolean) getArguments().get(InspireSelectAttentionListFragment.isFromFriend)).booleanValue();
        replaceTitle(null);
        setPullToRefreshEnabled(false);
        initSearch();
    }

    public void loadMoreSearchUser(String str, String str2, BigDecimal bigDecimal) {
        addSubscription(new InspireAtentionLoader().searchUser(str, str2, bigDecimal).subscribe(new Action1() { // from class: us.pinguo.inspire.module.contact.n0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                SearchFragment.this.l0((InspireAtentionLoader.AttentionResp) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.contact.j0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                SearchFragment.this.n0((Throwable) obj);
            }
        }));
    }

    public void onBackPressed() {
        us.pinguo.user.util.k.a(this.mSearchEditText, getActivity());
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void onDataRefresh() {
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void onLoadMore() {
        loadMoreSearchUser(s0.getInstance().getUserId(), this.mSearchKeyName, this.mSearchSp);
    }

    @Override // us.pinguo.inspire.module.attention.FromFriendItemCell.OnSelectListener
    public void onSelect(FromFriendItemCell fromFriendItemCell) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        arrayList.add(fromFriendItemCell.getData());
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra(InspireSelectAttentionListFragment.InspireAttentionList, arrayList);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void replaceTitle(View view) {
        Context context = getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.public_toolbar_layout, (ViewGroup) null);
        CompatibleToolbar compatibleToolbar = (CompatibleToolbar) inflate.findViewById(R.id.public_toolbar);
        compatibleToolbar.setNavigationIcon(us.pinguo.ui.R.drawable.navigation_back_black);
        compatibleToolbar.setTitle(R.string.search);
        compatibleToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.contact.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SearchFragment.this.p0(view2);
            }
        });
        View inflate2 = LayoutInflater.from(context).inflate(R.layout.search_layout, (ViewGroup) null);
        this.mSearchEditText = (EditText) inflate2.findViewById(R.id.search_edit_text);
        this.mClearIcon = (ImageView) inflate2.findViewById(R.id.search_clear_btn);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.setMargins(0, 0, us.pinguo.foundation.t.b.a.a(context, 16.0f), 0);
        inflate2.setLayoutParams(layoutParams);
        ((ViewGroup) compatibleToolbar.b().findViewById(us.pinguo.user.R.id.toolbar_custom_view)).addView(inflate2);
        super.replaceTitle(inflate);
    }

    public void search(String str, String str2) {
        this.mSearchKeyName = str2;
        searchUser(str, str2);
    }

    public void searchUser(String str, final String str2) {
        addSubscription(new InspireAtentionLoader().searchUser(str, str2, new BigDecimal(0)).subscribe(new Action1() { // from class: us.pinguo.inspire.module.contact.h0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                SearchFragment.this.r0(str2, (InspireAtentionLoader.AttentionResp) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.contact.i0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                SearchFragment.this.t0((Throwable) obj);
            }
        }));
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void triggerFirstRefresh(View view) {
    }
}
