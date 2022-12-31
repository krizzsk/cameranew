package us.pinguo.user.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.app.NotificationCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import rx.functions.Action1;
import us.pinguo.foundation.network.Fault;
import us.pinguo.foundation.utils.r0;
import us.pinguo.user.R;
import us.pinguo.user.User;
import us.pinguo.user.w0;
/* loaded from: classes6.dex */
public class PGLoginFragment extends PGBaseLoginFragment {
    TextView u;
    View v;
    private us.pinguo.user.request.e w;
    private PopupMenu x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements PopupMenu.OnMenuItemClickListener {
        a() {
        }

        @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
        @Instrumented
        public boolean onMenuItemClick(MenuItem menuItem) {
            VdsAgent.onMenuItemClick(this, menuItem);
            int itemId = menuItem.getItemId();
            if (itemId == 0) {
                PGLoginFragment.this.M0();
            } else if (itemId == 1) {
                PGLoginFragment.this.N0();
            }
            VdsAgent.handleClickResult(new Boolean(true));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends j.a.c.b.d<Void> {
        b() {
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(Void r1) {
            PGLoginFragment.this.h0();
            PGLoginFragment.this.V0();
        }

        @Override // j.a.c.b.d
        public void onError(Exception exc) {
            String str;
            int i2;
            PGLoginFragment.this.h0();
            if (exc instanceof Fault) {
                Fault fault = (Fault) exc;
                i2 = fault.getStatus();
                str = us.pinguo.user.api.f0.a(PGLoginFragment.this.getActivity(), fault.getStatus());
            } else {
                str = null;
                i2 = 0;
            }
            if (PGLoginFragment.this.isAdded()) {
                if (i2 == 10548) {
                    PGLoginFragment.this.F0(PGLoginFragment.this.getString(R.string.error_tips_10548));
                } else if (i2 == 10549) {
                    PGLoginFragment.this.F0(PGLoginFragment.this.getString(R.string.error_tips_10549));
                } else if (i2 == 10547) {
                    PGLoginFragment.this.F0(PGLoginFragment.this.getString(R.string.error_tips_10547));
                } else if (TextUtils.isEmpty(str)) {
                    PGLoginFragment.this.F0(PGLoginFragment.this.getString(R.string.pg_login_fail));
                } else if (i2 == 10511) {
                    PGLoginFragment.this.X(str, 1);
                } else if (i2 == 10510) {
                    PGLoginFragment.this.X(str, 2);
                } else {
                    PGLoginFragment.this.X(str, 3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        Intent intent = new Intent(getActivity(), PGEmailFindPasswordActivity.class);
        String obj = this.b.getText().toString();
        if (us.pinguo.util.t.a(obj)) {
            intent.putExtra(NotificationCompat.CATEGORY_EMAIL, obj);
        }
        startActivityForResult(intent, 1089);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        Intent intent = new Intent(getActivity(), PGPhoneFindPasswordActivity.class);
        String obj = this.b.getText().toString();
        if (us.pinguo.util.t.b(obj)) {
            intent.putExtra("phoneNumber", obj);
        }
        startActivityForResult(intent, 1088);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O0 */
    public /* synthetic */ void P0(Void r1) {
        h0();
        V0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q0 */
    public /* synthetic */ void R0(Throwable th) {
        String str;
        int i2;
        us.pinguo.foundation.e.e(th);
        h0();
        if (th instanceof Fault) {
            Fault fault = (Fault) th;
            i2 = fault.getStatus();
            str = us.pinguo.user.api.f0.a(getActivity(), fault.getStatus());
        } else {
            str = null;
            i2 = 0;
        }
        if (i2 == 10548) {
            F0(getString(R.string.error_tips_10548));
        } else if (i2 == 10549) {
            F0(getString(R.string.error_tips_10549));
        } else if (i2 == 10547) {
            F0(getString(R.string.error_tips_10547));
        } else if (TextUtils.isEmpty(str)) {
            F0(getString(R.string.pg_login_fail));
        } else if (i2 == 10511) {
            X(str, 1);
        } else if (i2 == 10510) {
            X(str, 2);
        } else {
            X(str, 3);
        }
    }

    private void S0(Context context) {
        boolean a2;
        boolean z;
        if (!us.pinguo.util.q.f(context)) {
            F0(getString(R.string.pg_login_network_exception));
            return;
        }
        String obj = this.b.getText().toString();
        String obj2 = this.c.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            if (!this.f12401j) {
                X(getString(R.string.pg_login_email_empty), 1);
                return;
            } else {
                X(getString(R.string.pg_login_phone_or_email_empty_hint), 1);
                return;
            }
        }
        if (this.f12401j) {
            a2 = us.pinguo.util.t.a(obj);
            z = us.pinguo.util.t.b(obj);
        } else {
            a2 = us.pinguo.util.t.a(obj);
            z = false;
        }
        if (!a2 && !z) {
            if (!this.f12401j) {
                X(getString(R.string.pg_login_email_format_error), 1);
            } else {
                X(getString(R.string.pg_login_phone_or_email_format_error), 1);
            }
        } else if (TextUtils.isEmpty(obj2)) {
            X(getString(R.string.pg_login_password_empty), 2);
        } else {
            j0(this.b);
            us.pinguo.user.request.e eVar = this.w;
            if (eVar != null) {
                eVar.cancel(true);
            }
            unsubscribeAll();
            if (a2) {
                T0(obj, obj2);
            }
            if (z) {
                U0(obj, obj2);
            }
        }
    }

    private void T0(String str, String str2) {
        this.w = new us.pinguo.user.request.e(getContext(), str, str2);
        G0(getString(R.string.login_progress_logining));
        this.w.get(new b());
    }

    private void U0(String str, String str2) {
        G0(getString(R.string.login_progress_logining));
        addSubscription(us.pinguo.user.request.j.b(str, str2).subscribe(new Action1() { // from class: us.pinguo.user.ui.d0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                PGLoginFragment.this.P0((Void) obj);
            }
        }, new Action1() { // from class: us.pinguo.user.ui.c0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                PGLoginFragment.this.R0((Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0() {
        w0.i(1);
        if (User.d().h().forgetPass == 1) {
            startActivityForResult(new Intent(getActivity(), PGNewModifyPasswordActivity.class), 1088);
        } else {
            B0();
        }
    }

    private void Y0(View view) {
        PopupMenu popupMenu = this.x;
        if (popupMenu == null) {
            this.x = us.pinguo.foundation.utils.w.u(getContext(), new String[]{getString(R.string.pg_login_find_password_from_email), getString(R.string.pg_login_find_password_from_phone)}, view, new a(), 0);
        } else {
            popupMenu.show();
        }
    }

    private void initView() {
        this.u.setOnClickListener(this);
        View view = this.v;
        view.setVisibility(0);
        VdsAgent.onSetViewVisibility(view, 0);
        this.v.setOnClickListener(this);
    }

    void W0(View view) {
        w0.i(0);
        view.setClickable(false);
        r0.d(view, true, 500);
        S0(getContext());
    }

    void X0(View view) {
        w0.i(2);
        j0(this.b);
        if (this.f12401j) {
            Y0(view);
        } else {
            M0();
        }
    }

    @Override // us.pinguo.user.ui.PGBaseLoginFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1088) {
            if (i3 == -1) {
                B0();
            }
        } else if (i2 == 1089 && i3 == -1) {
            F0(getString(R.string.find_password_success));
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // us.pinguo.user.ui.PGBaseLoginFragment, android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        super.onClick(view);
        if (view.getId() == R.id.login_forget_pwd) {
            X0(view);
        } else if (view.getId() == R.id.login_confirm_btn) {
            W0(view);
        }
    }

    @Override // us.pinguo.user.ui.PGBaseLoginFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.u = (TextView) onCreateView.findViewById(R.id.login_confirm_btn);
        this.v = onCreateView.findViewById(R.id.login_forget_pwd);
        initView();
        return onCreateView;
    }

    @Override // us.pinguo.user.ui.PGBaseLoginFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        us.pinguo.user.request.e eVar = this.w;
        if (eVar != null) {
            eVar.cancel(true);
        }
    }
}
