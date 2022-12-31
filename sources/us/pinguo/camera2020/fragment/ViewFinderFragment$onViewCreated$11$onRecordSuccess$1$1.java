package us.pinguo.camera2020.fragment;

import android.content.Intent;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Lambda;
import us.pinguo.camera2020.R;
import us.pinguo.foundation.VideoMusic;
import us.pinguo.svideo.bean.VideoInfo;
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
final class ViewFinderFragment$onViewCreated$11$onRecordSuccess$1$1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ FragmentActivity $it;
    final /* synthetic */ Parcelable $task;
    final /* synthetic */ VideoInfo $videoInfo;
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$onViewCreated$11$onRecordSuccess$1$1(FragmentActivity fragmentActivity, Parcelable parcelable, ViewFinderFragment viewFinderFragment, VideoInfo videoInfo) {
        super(0);
        this.$it = fragmentActivity;
        this.$task = parcelable;
        this.this$0 = viewFinderFragment;
        this.$videoInfo = videoInfo;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        VideoMusic videoMusic;
        Intent intent = new Intent();
        intent.setClassName(this.$it, "us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity");
        intent.putExtra("task", this.$task);
        videoMusic = this.this$0.B;
        if (videoMusic != null) {
            intent.putExtra(us.pinguo.foundation.constant.a.f10981e, videoMusic);
        }
        intent.putExtra("save_video_path", this.$videoInfo.getVideoPath());
        intent.putExtra("publish_video_type", 0);
        this.this$0.startActivityForResult(intent, 1002);
        this.$it.overridePendingTransition(R.anim.camera_slide_left_to_right_in, 0);
    }
}
