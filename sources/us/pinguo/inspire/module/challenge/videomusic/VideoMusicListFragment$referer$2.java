package us.pinguo.inspire.module.challenge.videomusic;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Lambda;
/* compiled from: VideoMusicListFragment.kt */
/* loaded from: classes9.dex */
final class VideoMusicListFragment$referer$2 extends Lambda implements kotlin.jvm.b.a<String> {
    final /* synthetic */ VideoMusicListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMusicListFragment$referer$2(VideoMusicListFragment videoMusicListFragment) {
        super(0);
        this.this$0 = videoMusicListFragment;
    }

    @Override // kotlin.jvm.b.a
    public final String invoke() {
        Intent intent;
        String stringExtra;
        FragmentActivity activity = this.this$0.getActivity();
        return (activity == null || (intent = activity.getIntent()) == null || (stringExtra = intent.getStringExtra(us.pinguo.foundation.constant.a.f10983g)) == null) ? "" : stringExtra;
    }
}
