package us.pinguo.inspire.module.publish;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.base.BaseAbsListFragment;
import us.pinguo.inspire.base.easyload.EasyListFragment;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class SelectTagFragment extends EasyListFragment<List<PublishTag>> implements View.OnClickListener {
    private EditText mTagEditText;
    private TextWatcher tagWatcher = new us.pinguo.foundation.ui.g() { // from class: us.pinguo.inspire.module.publish.SelectTagFragment.1
        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String trim = editable.toString().trim();
            ((BaseAbsListFragment) SelectTagFragment.this).mAdapter.clear();
            if (TextUtils.isEmpty(trim)) {
                return;
            }
            SelectTagFragment.this.onDataRefresh();
        }
    };

    private void onClickCancel() {
        getActivity().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public HashMap<String, String> addParamForPage(List<PublishTag> list) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b> appendCells(List<PublishTag> list) {
        return null;
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected HashMap<String, String> getParam() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("kw", this.mTagEditText.getText().toString());
        return hashMap;
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected Type getType() {
        return new com.google.gson.t.a<BaseResponse<List<PublishTag>>>() { // from class: us.pinguo.inspire.module.publish.SelectTagFragment.2
        }.getType();
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected String getUrl() {
        return "/tag/fuzzySearch";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public void initConfig() {
        super.initConfig();
        setPullToRefreshEnabled(false);
        setCacheEnabled(false);
        setShowStateEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public void initData() {
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected void initTitle() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.select_tag_fragment, (ViewGroup) null);
        replaceTitle(inflate);
        this.mTagEditText = (EditText) inflate.findViewById(R.id.cet_tag_select_tag_fragment);
        setOnClickListener(this.mRootView, R.id.tv_cancel_select_tag_fragment, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public boolean isLoadMoreEnable(List<PublishTag> list) {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_cancel_select_tag_fragment) {
            onClickCancel();
        }
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment, us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mTagEditText.addTextChangedListener(this.tagWatcher);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b> createCells(List<PublishTag> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (PublishTag publishTag : list) {
                arrayList.add(new SelectTagCell(publishTag, publishTag.name != null && this.mTagEditText.getText().toString().trim().equals(publishTag.name.trim())));
            }
            return arrayList;
        }
        return null;
    }
}
