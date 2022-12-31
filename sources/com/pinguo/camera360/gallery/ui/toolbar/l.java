package com.pinguo.camera360.gallery.ui.toolbar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.adv.ui.AlbumGIFAdvActivity;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import vStudio.Android.Camera360.R;
/* compiled from: LocalAlbumSetPageToolBarImpl.java */
/* loaded from: classes3.dex */
public class l extends b {
    private void q(final Activity activity) {
        AdvItem itemHightPrioritys = AdvConfigManager.getInstance().getItemHightPrioritys("eae77201a0313555644877c074710069");
        if (itemHightPrioritys == null || !us.pinguo.admobvista.c.a.a()) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) activity.findViewById(R.id.ad_layout);
        relativeLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(relativeLayout, 0);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) activity.findViewById(R.id.ad_view_button_res_0x7f090081);
        try {
            AdvItem loadDownloadedImage = AdvConfigManager.getInstance().loadDownloadedImage(itemHightPrioritys);
            if (loadDownloadedImage == null) {
                com.facebook.drawee.backends.pipeline.e h2 = com.facebook.drawee.backends.pipeline.c.h();
                h2.y(true);
                simpleDraweeView.setController(h2.a(Uri.parse("res://drawable/2131230827")).build());
            } else {
                String str = loadDownloadedImage.downloadedFilePath;
                com.facebook.drawee.backends.pipeline.e h3 = com.facebook.drawee.backends.pipeline.c.h();
                h3.y(true);
                simpleDraweeView.setController(h3.a(Uri.parse(InspirePublishFragment.FILE_HEADER + str)).build());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        simpleDraweeView.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.gallery.ui.toolbar.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.r(activity, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void r(Activity activity, View view) {
        VdsAgent.lambdaOnClick(view);
        us.pinguo.foundation.statistics.h.a.d("click");
        Intent intent = new Intent(activity, AlbumGIFAdvActivity.class);
        intent.putExtra("unit_Id", IADStatisticBase.UNIT_ID_ALBUM_TOP_GIF);
        activity.startActivity(intent);
    }

    @Override // com.pinguo.camera360.gallery.ui.toolbar.b
    public boolean g(PgToolBar pgToolBar, Spinner spinner, Menu menu, Activity activity) {
        super.g(pgToolBar, spinner, menu, activity);
        q(activity);
        this.a.setBackgroundColor(-1);
        pgToolBar.setTitle(R.string.album);
        Spinner spinner2 = this.b;
        spinner2.setVisibility(8);
        VdsAgent.onSetViewVisibility(spinner2, 8);
        pgToolBar.setNavigationIcon(R.drawable.back);
        return true;
    }

    @Override // com.pinguo.camera360.gallery.ui.toolbar.b
    public void i(Activity activity) {
        if (this.a == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) activity.findViewById(R.id.ad_layout);
        relativeLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(relativeLayout, 8);
        this.a.setAlpha(1.0f);
        this.a.setTranslationY(0.0f);
        this.a.clearAnimation();
        this.a.setVisibility(0);
    }
}
