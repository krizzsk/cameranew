package com.pinguo.camera360.camera.options;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.lib.ui.WebViewActivity;
import us.pinguo.admobvista.StaticsAdv.InspireStaticeConfig;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.Statictis.AdvStaticsticManager;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class AdFamilyView extends RelativeLayout {
    private SimpleDraweeView a;
    private TextView b;
    private View c;

    /* renamed from: d  reason: collision with root package name */
    private AdvItem f6226d;

    public AdFamilyView(Context context) {
        super(context);
    }

    private Boolean b(AdvItem advItem) {
        if (advItem == null) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf("appwall".equals(advItem.advType) && advItem.advProvider == 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(View view) {
        VdsAgent.lambdaOnClick(view);
        e();
    }

    private void e() {
        AdvItem advItem = this.f6226d;
        if (advItem == null) {
            return;
        }
        String str = advItem.interactionUri;
        Intent intent = new Intent(getContext(), WebViewActivity.class);
        intent.putExtra("web_view_url", str);
        getContext().startActivity(intent);
        AdvStaticsticManager.GetInstance().GetStaticInterface().ReportBDNoKey(InspireStaticeConfig.AD_FAMILY_CLICK, this.f6226d.advId);
    }

    public void a(AdvItem advItem) {
        LayoutInflater.from(getContext()).inflate(R.layout.ad_family_layout, this);
        this.f6226d = advItem;
        this.a = (SimpleDraweeView) findViewById(R.id.icon);
        this.b = (TextView) findViewById(R.id.text);
        this.c = findViewById(R.id.adfamily_line);
        setAdFamilyData();
        setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.options.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdFamilyView.this.d(view);
            }
        });
    }

    public void setAdFamilyData() {
        AdvItem advItem = this.f6226d;
        if (advItem != null && b(advItem).booleanValue()) {
            setVisibility(0);
            VdsAgent.onSetViewVisibility(this, 0);
            View view = this.c;
            view.setVisibility(0);
            VdsAgent.onSetViewVisibility(view, 0);
            AdvStaticsticManager.GetInstance().GetStaticInterface().ReportBDNoKey(InspireStaticeConfig.AD_FAMILY_SHOW, this.f6226d.advId);
            if (!TextUtils.isEmpty(this.f6226d.content)) {
                this.b.setText(this.f6226d.content);
            }
            AdvItem loadDownloadedImage = AdvConfigManager.getInstance().loadDownloadedImage(this.f6226d);
            if (loadDownloadedImage == null || TextUtils.isEmpty(loadDownloadedImage.downloadedFilePath)) {
                return;
            }
            SimpleDraweeView simpleDraweeView = this.a;
            simpleDraweeView.setImageURI(Uri.parse(InspirePublishFragment.FILE_HEADER + loadDownloadedImage.downloadedFilePath));
            return;
        }
        View view2 = this.c;
        view2.setVisibility(8);
        VdsAgent.onSetViewVisibility(view2, 8);
        setVisibility(8);
        VdsAgent.onSetViewVisibility(this, 8);
    }

    public AdFamilyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdFamilyView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
