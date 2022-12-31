package com.pinguo.camera360.sticker;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.camera360.shop.data.show.ShowTopic;
import us.pinguo.common.imageloader.widget.ImageLoaderView;
import us.pinguo.foundation.utils.j0;
import us.pinguo.util.q;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class PurchaseStickerDialog extends Dialog implements View.OnClickListener {
    private Activity mActivity;
    private ImageLoaderView mBanner;
    private View mCancel;
    private TextView mDescription;
    private PayDialogOnClickListener mListener;
    private TextView mProductName;
    private TextView mPurchase;

    /* loaded from: classes3.dex */
    public interface PayDialogOnClickListener {
        void onPayClick();
    }

    public PurchaseStickerDialog(Activity activity) {
        super(activity, R.style.StickerPurchaseTheme);
        this.mActivity = activity;
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.layout_sticker_purchase);
        findViews();
    }

    private void fillCommodityInfo(ShowTopic showTopic) {
        String banner = showTopic.getBanner();
        if (banner != null && !banner.isEmpty()) {
            this.mBanner.setImageUrl(banner);
        } else {
            this.mBanner.setImageResource(R.drawable.purchase_bannder_default);
        }
        this.mProductName.setText(showTopic.getTopicName());
        this.mDescription.setText(showTopic.getDescription());
        this.mPurchase.setText(getContext().getString(R.string.purchase_now));
    }

    private void findViews() {
        View findViewById = findViewById(R.id.sticker_purchase_cancel);
        this.mCancel = findViewById;
        findViewById.setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.sticker_purchase);
        this.mPurchase = textView;
        textView.setOnClickListener(this);
        this.mProductName = (TextView) findViewById(R.id.purchase_product_name);
        this.mBanner = (ImageLoaderView) findViewById(R.id.purchase_banner_image);
        this.mDescription = (TextView) findViewById(R.id.purchase_product_description);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        switch (view.getId()) {
            case R.id.sticker_purchase /* 2131298002 */:
                dismiss();
                if (!q.f(this.mActivity)) {
                    j0.c(R.string.no_network_connection_toast);
                    return;
                }
                PayDialogOnClickListener payDialogOnClickListener = this.mListener;
                if (payDialogOnClickListener != null) {
                    payDialogOnClickListener.onPayClick();
                    return;
                }
                return;
            case R.id.sticker_purchase_cancel /* 2131298003 */:
                dismiss();
                return;
            default:
                return;
        }
    }

    public void setPayDialogClickerListener(PayDialogOnClickListener payDialogOnClickListener) {
        this.mListener = payDialogOnClickListener;
    }

    public void show(ShowTopic showTopic) {
        if (showTopic == null) {
            return;
        }
        fillCommodityInfo(showTopic);
    }
}
