package us.pinguo.inspire.module.master;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.internal.view.SupportMenu;
import androidx.fragment.app.FragmentTransaction;
import rx.functions.Action1;
import us.pinguo.foundation.base.BaseFragment;
import us.pinguo.foundation.network.Fault;
import us.pinguo.foundation.statistics.l;
import us.pinguo.foundation.ui.g;
import us.pinguo.foundation.utils.j0;
import us.pinguo.foundation.utils.w;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.master.MasterApplyFragment;
import us.pinguo.ui.R;
import us.pinguo.user.s0;
import us.pinguo.user.ui.view.EditTextWithPrompt;
/* loaded from: classes9.dex */
public class MasterApplyFragment extends BaseFragment {
    private static final int MAX_DESC_COUNT = 140;
    private Button mBtnApply;
    private TextWatcher mDescCountTextWatcher = new g() { // from class: us.pinguo.inspire.module.master.MasterApplyFragment.5
        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int length = editable.length();
            TextView textView = MasterApplyFragment.this.mQuantity;
            textView.setText(length + "/140");
            if (length > 140) {
                MasterApplyFragment.this.mQuantity.setTextColor(SupportMenu.CATEGORY_MASK);
            } else {
                MasterApplyFragment.this.mQuantity.setTextColor(Inspire.a().getResources().getColor(R.color.text_primary));
            }
        }
    };
    private EditTextWithPrompt mEtContact;
    private EditText mEtInfo;
    private TextView mQuantity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: us.pinguo.inspire.module.master.MasterApplyFragment$4  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b(AlertDialog alertDialog, Boolean bool) {
            alertDialog.dismiss();
            Log.i("song", " apply for : " + bool);
            if (bool.booleanValue()) {
                ((MasterActivity) MasterApplyFragment.this.getActivity()).updateMasterUI(1);
                final AlertDialog i2 = w.i(MasterApplyFragment.this.getActivity(), vStudio.Android.Camera360.R.string.master_apply_commit_tip, -999, -999, null);
                i2.setCancelable(false);
                new Handler().postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.master.MasterApplyFragment.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        i2.dismiss();
                        MasterApplyFragment.this.removeSelf();
                    }
                }, 3000L);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void c(AlertDialog alertDialog, Throwable th) {
            us.pinguo.foundation.e.e(th);
            us.pinguo.common.log.a.f(th);
            th.printStackTrace();
            alertDialog.dismiss();
            if (th instanceof Fault) {
                Fault fault = (Fault) th;
                if (fault.getStatus() == 16001) {
                    j0.c(vStudio.Android.Camera360.R.string.error_master_16001);
                } else if (fault.getStatus() == 16002) {
                    j0.c(vStudio.Android.Camera360.R.string.error_master_16002);
                } else if (fault.getStatus() == 16003) {
                    j0.c(vStudio.Android.Camera360.R.string.error_master_16003);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.h(Inspire.a(), "master_apply_click");
            String trim = MasterApplyFragment.this.mEtContact.getText().toString().trim();
            int length = MasterApplyFragment.this.mEtInfo.length();
            if (!us.pinguo.admobvista.f.b.a(trim)) {
                Toast.makeText(MasterApplyFragment.this.getContext(), (int) vStudio.Android.Camera360.R.string.mater_apply_toast_mail, 0).show();
            } else if (length > 140) {
                Toast.makeText(MasterApplyFragment.this.getContext(), (int) vStudio.Android.Camera360.R.string.mater_apply_toast_text140, 0).show();
            } else {
                final AlertDialog p = w.p(MasterApplyFragment.this.getContext(), vStudio.Android.Camera360.R.string.master_waiting_text);
                p.setCancelable(false);
                MasterApi.apply(s0.getInstance().getUserId(), MasterApplyFragment.this.mEtContact.getText().toString(), MasterApplyFragment.this.mEtInfo.getText().toString()).subscribe(new Action1() { // from class: us.pinguo.inspire.module.master.c
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        MasterApplyFragment.AnonymousClass4.this.b(p, (Boolean) obj);
                    }
                }, new Action1() { // from class: us.pinguo.inspire.module.master.b
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        MasterApplyFragment.AnonymousClass4.c(AlertDialog.this, (Throwable) obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0 */
    public /* synthetic */ void b0(View view) {
        removeSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSelf() {
        ((MasterActivity) getActivity()).updateUIForMaterFragment();
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.remove(this);
        beginTransaction.commit();
    }

    private void setListeners() {
        TextWatcher textWatcher = new TextWatcher() { // from class: us.pinguo.inspire.module.master.MasterApplyFragment.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(MasterApplyFragment.this.mEtInfo.getText()) || TextUtils.isEmpty(MasterApplyFragment.this.mEtContact.getText())) {
                    MasterApplyFragment.this.mBtnApply.setEnabled(false);
                } else {
                    MasterApplyFragment.this.mBtnApply.setEnabled(true);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        };
        this.mEtContact.addTextChangedListener(textWatcher);
        this.mEtInfo.addTextChangedListener(textWatcher);
        this.mEtContact.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.master.MasterApplyFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.mEtInfo.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.master.MasterApplyFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.mBtnApply.setOnClickListener(new AnonymousClass4());
    }

    @Override // us.pinguo.foundation.base.BaseFragment
    protected String getPageId() {
        return "master_apply_page";
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(vStudio.Android.Camera360.R.layout.fragment_master_apply, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((MasterActivity) getActivity()).updateUIForMasterApplyFragment();
        ((MasterActivity) getActivity()).getToolbar().setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.master.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MasterApplyFragment.this.b0(view);
            }
        });
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mEtContact = (EditTextWithPrompt) view.findViewById(vStudio.Android.Camera360.R.id.mater_apply_edittext_contact_way_iv);
        this.mEtInfo = (EditText) view.findViewById(vStudio.Android.Camera360.R.id.mater_apply_edittext_self_introduction_iv);
        this.mBtnApply = (Button) view.findViewById(vStudio.Android.Camera360.R.id.mater_apply_submit_iv);
        this.mQuantity = (TextView) view.findViewById(vStudio.Android.Camera360.R.id.mater_apply_number_of_words);
        this.mEtInfo.addTextChangedListener(this.mDescCountTextWatcher);
        this.mQuantity.setText("0/140");
        setListeners();
        this.mBtnApply.setEnabled(false);
    }
}
