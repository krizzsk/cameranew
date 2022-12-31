package us.pinguo.share.util;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.List;
import us.pinguo.inspire.module.contact.cell.FindFriendHeaderCell;
import us.pinguo.share.R;
import us.pinguo.share.core.ShareSite;
import us.pinguo.share.util.OnShareSiteClickListener;
/* loaded from: classes6.dex */
public class BaseShareDialog extends DialogFragment implements View.OnClickListener {
    protected RecyclerView a;
    protected TextView b;
    protected OnShareSiteClickListener c;

    /* renamed from: d  reason: collision with root package name */
    private DialogInterface.OnDismissListener f11962d;

    /* renamed from: e  reason: collision with root package name */
    protected List<ExpandShareSite> f11963e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ShareSite.values().length];
            a = iArr;
            try {
                iArr[ShareSite.FACEBOOK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ShareSite.INSTAGRAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ShareSite.QQ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ShareSite.QZONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ShareSite.SINAWEIBO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ShareSite.TWITTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ShareSite.DOUYIN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ShareSite.WECHAT_FRIENDS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ShareSite.WECHAT_MOMENTS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static String a0(ShareSite shareSite) {
        switch (a.a[shareSite.ordinal()]) {
            case 1:
                return "facebook";
            case 2:
                return "instagram";
            case 3:
                return "qq_friend";
            case 4:
                return "qq_zone";
            case 5:
                return "weibo";
            case 6:
                return FindFriendHeaderCell.TWITTER;
            case 7:
                return "douyin";
            case 8:
                return "wechat_friend";
            case 9:
                return "wechat_moments";
            default:
                return "";
        }
    }

    private void b0() {
        if (getDialog() != null) {
            boolean z = us.pinguo.foundation.f.f11000h;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0 */
    public /* synthetic */ void f0(int i2) {
        b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ void h0(DialogInterface dialogInterface) {
        if (getDialog() == null) {
            return;
        }
        getDialog().getWindow().clearFlags(8);
        ((WindowManager) getActivity().getSystemService("window")).updateViewLayout(getDialog().getWindow().getDecorView(), getDialog().getWindow().getAttributes());
    }

    protected void c0(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_cancel);
        this.b = textView;
        textView.setOnClickListener(this);
    }

    protected void d0(View view) {
        this.a = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.a.setLayoutManager(linearLayoutManager);
        this.a.setHasFixedSize(true);
        this.a.setAdapter(new m(this, this.f11963e, this.c));
    }

    public void i0(OnShareSiteClickListener onShareSiteClickListener) {
        this.c = onShareSiteClickListener;
    }

    protected View inflateRootView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.inspire_share_dialog_layout, viewGroup, false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getActivity().getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: us.pinguo.share.util.a
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i2) {
                BaseShareDialog.this.f0(i2);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        if (view == this.b) {
            dismiss();
            OnShareSiteClickListener onShareSiteClickListener = this.c;
            if (onShareSiteClickListener != null) {
                onShareSiteClickListener.onShareOtherClick(OnShareSiteClickListener.ShareDialogContent.CANCEL_BTN);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.BottomDialog);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.getWindow().addFlags(8);
        onCreateDialog.getWindow().clearFlags(1024);
        onCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: us.pinguo.share.util.b
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                BaseShareDialog.this.h0(dialogInterface);
            }
        });
        onCreateDialog.setOnDismissListener(this.f11962d);
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        String C;
        this.f11963e = k.c(getArguments());
        getDialog().getWindow().requestFeature(1);
        getDialog().setCanceledOnTouchOutside(true);
        View inflateRootView = inflateRootView(layoutInflater, viewGroup, bundle);
        d0(inflateRootView);
        c0(inflateRootView);
        FragmentActivity activity = getActivity();
        if (activity == null || !activity.getClass().getSimpleName().equals("Camera2020Activity")) {
            C = activity instanceof us.pinguo.foundation.statistics.e ? ((us.pinguo.foundation.statistics.e) activity).C() : "";
        } else {
            C = "photo_preview";
        }
        for (ExpandShareSite expandShareSite : this.f11963e) {
            us.pinguo.foundation.statistics.h.a.m(a0(expandShareSite.a()), C, "show");
        }
        return inflateRootView;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        b0();
        DialogInterface.OnDismissListener onDismissListener = this.f11962d;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (getDialog() == null || getDialog().getWindow() == null) {
            return;
        }
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.8f;
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        b0();
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.f11962d = onDismissListener;
    }
}
