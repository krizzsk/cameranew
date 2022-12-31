package us.pinguo.share.util;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.tencent.open.SocialConstants;
import java.util.List;
import us.pinguo.share.R;
import us.pinguo.share.util.OnShareSiteClickListener;
/* loaded from: classes6.dex */
public class StickerShareDialog extends DialogFragment implements View.OnClickListener {
    protected RecyclerView a;
    protected TextView b;
    protected OnShareSiteClickListener c;

    /* renamed from: d  reason: collision with root package name */
    protected List<ExpandShareSite> f11966d;

    /* renamed from: e  reason: collision with root package name */
    private String f11967e;

    protected void a0(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_cancel);
        this.b = textView;
        textView.setOnClickListener(this);
    }

    protected void b0(View view) {
        this.a = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.a.setLayoutManager(linearLayoutManager);
        this.a.setHasFixedSize(true);
        this.a.setAdapter(new m(this, this.f11966d, this.c));
        com.facebook.drawee.backends.pipeline.e L = com.facebook.drawee.backends.pipeline.c.h().L(this.f11967e);
        L.y(true);
        ((SimpleDraweeView) view.findViewById(R.id.share_banner)).setController(L.build());
    }

    public void c0(OnShareSiteClickListener onShareSiteClickListener) {
        this.c = onShareSiteClickListener;
    }

    protected View inflateRootView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.sticker_share_dialog_layout, viewGroup, false);
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

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        this.f11966d = k.c(arguments);
        this.f11967e = arguments.getString(SocialConstants.PARAM_IMG_URL);
        getDialog().getWindow().requestFeature(1);
        getDialog().setCanceledOnTouchOutside(true);
        View inflateRootView = inflateRootView(layoutInflater, viewGroup, bundle);
        b0(inflateRootView);
        a0(inflateRootView);
        return inflateRootView;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
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
    }
}
