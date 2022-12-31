package us.pinguo.inspire.module.guide;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.balysv.materialripple.MaterialRippleLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TJAdUnitConstants;
import java.util.Arrays;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.x;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.foundation.base.SubscriptionDialog;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.utils.u;
import us.pinguo.inspire.model.Endpage;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.MissionDetail.TaskDetailActivity;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.inspire.module.publish.vo.PublishData;
import us.pinguo.ui.uilview.PhotoNsImageView;
import us.pinguo.ui.widget.video.BaseVideoTextureView;
import us.pinguo.ui.widget.video.VideoPlayer;
import vStudio.Android.Camera360.R;
/* compiled from: ChallengeShareDialog.kt */
/* loaded from: classes9.dex */
public final class ChallengeShareDialog extends SubscriptionDialog implements View.OnClickListener {
    private final TaskDetailActivity activity;
    private final PublishData data;
    private final String path;
    private final InspireTask task;
    private VideoPlayer videoPlayer;
    private final InspireWork work;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChallengeShareDialog(TaskDetailActivity activity, InspireTask task, InspireWork work, PublishData data) {
        super(activity, R.style.ChallengeGuideDialog);
        s.h(activity, "activity");
        s.h(task, "task");
        s.h(work, "work");
        s.h(data, "data");
        this.activity = activity;
        this.task = task;
        this.work = work;
        this.data = data;
        String str = data.filePathes.get(0);
        s.g(str, "data.filePathes[0]");
        this.path = str;
    }

    private final void showPhoto() {
        Endpage endpage;
        ((ImageView) findViewById(us.pinguo.inspire.R.id.challenge_play_icon)).setVisibility(8);
        ((BaseVideoTextureView) findViewById(us.pinguo.inspire.R.id.challenge_share_video)).setVisibility(8);
        int i2 = us.pinguo.inspire.R.id.challenge_share_photo;
        ((PhotoNsImageView) findViewById(i2)).setVisibility(0);
        InspireWork.TaskInfo taskInfo = this.work.taskInfo;
        if (taskInfo.endpageMode == 2 && (endpage = taskInfo.endpage) != null && !TextUtils.isEmpty(endpage.getEndpageBanner())) {
            ((PhotoNsImageView) findViewById(i2)).setImageUri(this.work.taskInfo.endpage.getEndpageBanner());
        } else {
            ((PhotoNsImageView) findViewById(i2)).setImageUri(s.q(InspirePublishFragment.FILE_HEADER, this.path));
        }
        ((PhotoNsImageView) findViewById(i2)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.guide.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChallengeShareDialog.m183showPhoto$lambda0(ChallengeShareDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showPhoto$lambda-0  reason: not valid java name */
    public static final void m183showPhoto$lambda0(ChallengeShareDialog this$0, View view) {
        Endpage endpage;
        s.h(this$0, "this$0");
        InspireWork.TaskInfo taskInfo = this$0.work.taskInfo;
        if (taskInfo.endpageMode != 2 || (endpage = taskInfo.endpage) == null || TextUtils.isEmpty(endpage.getEndpageLink())) {
            return;
        }
        h.a.e("submit_challenge_success_popup_action", this$0.work.taskInfo.taskId, "play");
        Intent intent = new Intent();
        intent.setClassName(this$0.getContext(), "com.pinguo.camera360.lib.ui.WebViewActivity");
        intent.putExtra("web_view_url", this$0.work.taskInfo.endpage.getEndpageLink());
        intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
        this$0.activity.startActivity(intent);
        this$0.dismiss();
    }

    private final void showVideo() {
        ((ImageView) findViewById(us.pinguo.inspire.R.id.challenge_play_icon)).setVisibility(0);
        ((PhotoNsImageView) findViewById(us.pinguo.inspire.R.id.challenge_share_photo)).setVisibility(0);
        ((BaseVideoTextureView) findViewById(us.pinguo.inspire.R.id.challenge_share_video)).setVisibility(8);
        try {
            new MediaMetadataRetriever().setDataSource(this.path);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int i2 = us.pinguo.inspire.R.id.challenge_share_photo;
        ((PhotoNsImageView) findViewById(i2)).setLocalVideoUri(s.q(InspirePublishFragment.FILE_HEADER, this.path));
        ((PhotoNsImageView) findViewById(i2)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.guide.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChallengeShareDialog.m184showVideo$lambda1(ChallengeShareDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showVideo$lambda-1  reason: not valid java name */
    public static final void m184showVideo$lambda1(ChallengeShareDialog this$0, View view) {
        s.h(this$0, "this$0");
        x xVar = x.a;
        String format = String.format("app://camera360/homeinspire/rec?workIds=%s&rec", Arrays.copyOf(new Object[]{this$0.work.workId}, 1));
        s.g(format, "format(format, *args)");
        AppGoto.getInstance().c(format).b(this$0.getContext());
        this$0.dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null) {
            videoPlayer.f();
        }
        VideoPlayer videoPlayer2 = this.videoPlayer;
        if (videoPlayer2 != null) {
            videoPlayer2.b();
        }
        this.videoPlayer = null;
        h.a.e("submit_challenge_success_popup_action", this.work.workId, TJAdUnitConstants.String.CLOSE);
    }

    public final TaskDetailActivity getActivity() {
        return this.activity;
    }

    public final PublishData getData() {
        return this.data;
    }

    public final String getPath() {
        return this.path;
    }

    public final InspireTask getTask() {
        return this.task;
    }

    public final InspireWork getWork() {
        return this.work;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Endpage endpage;
        s.h(v, "v");
        int id = v.getId();
        if (id == R.id.challengeGuideCloseBtn) {
            dismiss();
        } else if (id != R.id.challenge_guide_goto_challenge_child) {
        } else {
            InspireWork.TaskInfo taskInfo = this.work.taskInfo;
            if (taskInfo.endpageMode == 2 && (endpage = taskInfo.endpage) != null && !TextUtils.isEmpty(endpage.getEndpageLink())) {
                Intent intent = new Intent();
                intent.setClassName(getContext(), "com.pinguo.camera360.lib.ui.WebViewActivity");
                intent.putExtra("web_view_url", this.work.taskInfo.endpage.getEndpageLink());
                intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
                this.activity.startActivity(intent);
                dismiss();
                return;
            }
            this.activity.share(this.work);
            h.a.e("submit_challenge_success_popup_action", this.work.workId, FirebaseAnalytics.Event.SHARE);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        InspireWork.TaskInfo taskInfo = this.work.taskInfo;
        if (taskInfo.endpageMode == 2 && taskInfo.endpage != null) {
            setContentView(R.layout.challenge_success_layout);
        } else {
            setContentView(R.layout.challenge_share_layout);
        }
        ((MaterialRippleLayout) findViewById(us.pinguo.inspire.R.id.challenge_guide_goto_challenge)).setOnClickListener(this);
        ((ImageView) findViewById(us.pinguo.inspire.R.id.challengeGuideCloseBtn)).setOnClickListener(this);
    }

    public final void onPause() {
        VideoPlayer videoPlayer;
        VideoPlayer videoPlayer2 = this.videoPlayer;
        boolean z = false;
        if (videoPlayer2 != null && videoPlayer2.isPlaying()) {
            z = true;
        }
        if (!z || (videoPlayer = this.videoPlayer) == null) {
            return;
        }
        videoPlayer.a();
    }

    public final void onResume() {
        VideoPlayer videoPlayer = this.videoPlayer;
        boolean z = false;
        if (videoPlayer != null && videoPlayer.H()) {
            z = true;
        }
        if (z) {
            VideoPlayer videoPlayer2 = this.videoPlayer;
            if (videoPlayer2 != null) {
                videoPlayer2.c((BaseVideoTextureView) findViewById(us.pinguo.inspire.R.id.challenge_share_video));
            }
            VideoPlayer videoPlayer3 = this.videoPlayer;
            if (videoPlayer3 == null) {
                return;
            }
            videoPlayer3.d();
        }
    }

    public final void setWorks() {
        String endpageText;
        if (this.work.isVideo() && this.work.taskInfo.endpageMode != 2) {
            showVideo();
        } else {
            showPhoto();
        }
        InspireWork.TaskInfo taskInfo = this.work.taskInfo;
        if (taskInfo.endpageMode == 2) {
            if (TextUtils.isEmpty(taskInfo.endpage.getEndpageText())) {
                endpageText = getContext().getString(R.string.text_challenge_success);
                s.g(endpageText, "context.getString(R.string.text_challenge_success)");
            } else {
                endpageText = this.work.taskInfo.endpage.getEndpageText();
            }
            ((TextView) findViewById(us.pinguo.inspire.R.id.challenge_guide_goto_challenge_child)).setText(endpageText);
        } else if (u.a()) {
            ((TextView) findViewById(us.pinguo.inspire.R.id.challenge_guide_goto_challenge_child)).setText(getContext().getString(R.string.text_challenge_share));
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        setWorks();
        h.a.e("submit_challenge_success_popup_action", this.work.workId, "show");
    }
}
