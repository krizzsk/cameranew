package us.pinguo.inspire.module.photomovie;

import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import com.hw.photomovie.PhotoMovieFactory$PhotoMovieType;
import com.hw.photomovie.PhotoMoviePlayer;
import com.hw.photomovie.b.d;
import com.hw.photomovie.e.a;
import com.hw.photomovie.util.AppResources;
import com.tapjoy.TJAdUnitConstants;
import i.a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import us.pinguo.foundation.VideoMusic;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.utils.e;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
import us.pinguo.inspire.module.challenge.videomusic.VideoEditProgressDialog;
import us.pinguo.inspire.module.challenge.videomusic.VideoMusicListActivity;
import us.pinguo.inspire.module.photomovie.PhotoMoviePresenter;
import us.pinguo.inspire.module.photomovie.widget.IPhotoMovieView;
import us.pinguo.inspire.module.photomovie.widget.PhotoMovieMusicCallback;
import us.pinguo.inspire.module.photomovie.widget.PhotoMovieTransferCallback;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* loaded from: classes9.dex */
public class PhotoMoviePresenter implements a.InterfaceC0200a, PhotoMovieTransferCallback, PhotoMovieMusicCallback {
    private static final int MAX_VIDEO_SIZE = 1280;
    private static final int REQUEST_MUSIC = 323;
    private com.hw.photomovie.render.c mGlMovieRenderer;
    private List<VideoMusic> mLocalMusicList;
    private int mPhotoCount;
    private com.hw.photomovie.a mPhotoMovie;
    private PhotoMoviePlayer mPhotoMoviePlayer;
    private VideoMusic mPlayingMusic;
    PhotoMovieFactory$PhotoMovieType mCurType = PhotoMovieFactory$PhotoMovieType.HORIZONTAL_TRANS;
    IPhotoMovieView mPhotoMovieView = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: us.pinguo.inspire.module.photomovie.PhotoMoviePresenter$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass1 implements a.c {
        final /* synthetic */ AlertDialog val$dialog;
        final /* synthetic */ String val$videoFile;

        AnonymousClass1(AlertDialog alertDialog, String str) {
            this.val$dialog = alertDialog;
            this.val$videoFile = str;
        }

        @Override // i.a.c
        public void onRecordFinish(boolean z) {
            if (z) {
                this.val$dialog.dismiss();
                Intent startIntent = VideoEdit2Activity.getStartIntent(PhotoMoviePresenter.this.mPhotoMovieView.getActivity(), this.val$videoFile, new InspireTask(), 0);
                if (PhotoMoviePresenter.this.mPlayingMusic != null) {
                    if (PhotoMoviePresenter.this.mPlayingMusic.j() != null && PhotoMoviePresenter.this.mPlayingMusic.j().startsWith("assets://")) {
                        String substring = PhotoMoviePresenter.this.mPlayingMusic.j().substring(9);
                        File file = new File(PhotoMoviePresenter.this.mPhotoMovieView.getActivity().getCacheDir(), "defaultMusic.mp4");
                        PhotoMoviePresenter.this.mPlayingMusic.k(file.getAbsolutePath());
                        try {
                            e.a(PhotoMoviePresenter.this.mPhotoMovieView.getActivity(), substring, file);
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    startIntent.putExtra(us.pinguo.foundation.constant.a.f10981e, PhotoMoviePresenter.this.mPlayingMusic);
                }
                if (PhotoMoviePresenter.this.mPhotoMovieView.getFragment().getArguments() != null && PhotoMoviePresenter.this.mPhotoMovieView.getFragment().getArguments().containsKey("task")) {
                    startIntent.putExtra("task", PhotoMoviePresenter.this.mPhotoMovieView.getFragment().getArguments().getParcelable("task"));
                }
                PhotoMoviePresenter.this.mPhotoMovieView.getActivity().startActivity(startIntent);
            }
        }

        @Override // i.a.c
        public void onRecordProgress(final int i2, final int i3) {
            FragmentActivity activity = PhotoMoviePresenter.this.mPhotoMovieView.getActivity();
            final AlertDialog alertDialog = this.val$dialog;
            activity.runOnUiThread(new Runnable() { // from class: us.pinguo.inspire.module.photomovie.b
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEditProgressDialog.setProgress(AlertDialog.this, i2 / i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: us.pinguo.inspire.module.photomovie.PhotoMoviePresenter$2  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass2 implements PhotoMoviePlayer.f {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b() {
            PhotoMoviePresenter.this.mPhotoMoviePlayer.p(0);
            PhotoMoviePresenter.this.mPhotoMoviePlayer.w();
        }

        @Override // com.hw.photomovie.PhotoMoviePlayer.f
        public void onError(PhotoMoviePlayer photoMoviePlayer) {
            us.pinguo.common.log.a.k("onPrepare", "onPrepare error");
        }

        @Override // com.hw.photomovie.PhotoMoviePlayer.f
        public void onPrepared(PhotoMoviePlayer photoMoviePlayer, int i2, int i3) {
            us.pinguo.common.log.a.k("onPrepare", "prepared:" + i2 + " total:" + i3);
            PhotoMoviePresenter.this.mPhotoMovieView.getActivity().runOnUiThread(new Runnable() { // from class: us.pinguo.inspire.module.photomovie.c
                @Override // java.lang.Runnable
                public final void run() {
                    PhotoMoviePresenter.AnonymousClass2.this.b();
                }
            });
        }

        @Override // com.hw.photomovie.PhotoMoviePlayer.f
        public void onPreparing(PhotoMoviePlayer photoMoviePlayer, float f2) {
            us.pinguo.common.log.a.k("onPrepare", "" + f2);
        }
    }

    static {
        AppResources.getInstance().b(us.pinguo.foundation.e.b().getResources());
    }

    private com.hw.photomovie.a genPhotoMovie(d dVar) {
        ArrayList arrayList = new ArrayList(dVar.k());
        for (int i2 = 0; i2 < dVar.k(); i2++) {
            arrayList.add(new com.hw.photomovie.segment.b(2000));
            if (i2 < dVar.k() - 1) {
                PhotoMovieFactory$PhotoMovieType photoMovieFactory$PhotoMovieType = this.mCurType;
                if (photoMovieFactory$PhotoMovieType == PhotoMovieFactory$PhotoMovieType.HORIZONTAL_TRANS) {
                    arrayList.add(new com.hw.photomovie.segment.d(com.hw.photomovie.segment.d.s, 600));
                } else if (photoMovieFactory$PhotoMovieType == PhotoMovieFactory$PhotoMovieType.VERTICAL_TRANS) {
                    arrayList.add(new com.hw.photomovie.segment.d(com.hw.photomovie.segment.d.t, 600));
                }
            }
        }
        return new com.hw.photomovie.a(dVar, arrayList);
    }

    private void initLocalMusicCell() {
        VideoMusic videoMusic = new VideoMusic("5acf00cc65833658ee028e95", "Break Away", "Young Presidents", "assets://photomovie/BreakAway.mp4", "https://phototask.c360dn.com/Fj8uEb7yKAPgdyHVxHlM2MnOt1Ur", "30", 1523515596, 1);
        this.mLocalMusicList = new ArrayList(Arrays.asList(videoMusic));
        if (us.pinguo.util.c.f12472f) {
            this.mPlayingMusic = videoMusic;
        }
    }

    private void initMoviePlayer() {
        this.mGlMovieRenderer = new com.hw.photomovie.render.c(this.mPhotoMovieView.getGLTextureView());
        PhotoMoviePlayer photoMoviePlayer = new PhotoMoviePlayer(this.mPhotoMovieView.getActivity().getApplicationContext());
        this.mPhotoMoviePlayer = photoMoviePlayer;
        photoMoviePlayer.t(this.mGlMovieRenderer);
        this.mPhotoMoviePlayer.s(this);
        this.mPhotoMoviePlayer.r(true);
    }

    private void playMusic(VideoMusic videoMusic) {
        this.mPlayingMusic = videoMusic;
        com.hw.photomovie.c.a g2 = this.mPhotoMoviePlayer.g();
        if (g2.isPlaying()) {
            g2.stop();
        }
        if (videoMusic != null) {
            if (videoMusic.j() != null && videoMusic.j().startsWith("assets")) {
                try {
                    g2.setDataSource(this.mPhotoMovieView.getActivity().getResources().getAssets().openFd(videoMusic.j().substring(9)));
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } else {
                g2.setDataSource(videoMusic.c());
            }
            this.mPhotoMoviePlayer.x();
            this.mPhotoMoviePlayer.p(0);
            this.mPhotoMoviePlayer.w();
            g2.start();
        }
        this.mPhotoMovieView.onMusicChanged(videoMusic);
    }

    private void playPhotoMovie(com.hw.photomovie.a aVar) {
        startPhotoMovie(aVar);
    }

    private String saveVideoImpl() {
        int i2;
        AlertDialog showProgressDialog = VideoEditProgressDialog.showProgressDialog(this.mPhotoMovieView.getActivity());
        showProgressDialog.show();
        this.mPhotoMoviePlayer.j();
        i.a aVar = new i.a();
        String generate = new us.pinguo.svideo.utils.a().generate();
        int width = this.mPhotoMovieView.getGLTextureView().getWidth();
        int height = this.mPhotoMovieView.getGLTextureView().getHeight();
        if (Math.max(width, height) > MAX_VIDEO_SIZE) {
            float max = Math.max(width, height) / 1280.0f;
            width = (int) (width / max);
            height = (int) (height / max);
            if (width % 2 == 1) {
                width--;
            }
            if (height % 2 == 1) {
                height--;
            }
        }
        int i3 = height;
        aVar.b(width, i3, (int) (((i2 * i3) / 921600.0f) * 4000000.0f), 20, 1, generate);
        aVar.i(this.mGlMovieRenderer);
        aVar.j(new AnonymousClass1(showProgressDialog, generate));
        return generate;
    }

    private void startPhotoMovie(com.hw.photomovie.a aVar) {
        this.mPhotoMoviePlayer.q(aVar);
        this.mPhotoMoviePlayer.u(new AnonymousClass2());
        playMusic(this.mPlayingMusic);
        this.mPhotoMoviePlayer.k();
    }

    public void attachView(us.pinguo.foundation.p.b bVar) {
        this.mPhotoMovieView = (IPhotoMovieView) bVar;
        initLocalMusicCell();
        initMoviePlayer();
    }

    public void detachView() {
        PhotoMoviePlayer photoMoviePlayer = this.mPhotoMoviePlayer;
        if (photoMoviePlayer != null && photoMoviePlayer.g() != null) {
            this.mPhotoMoviePlayer.g().release();
        }
        this.mPhotoMovieView = null;
    }

    public List<VideoMusic> getLocalMusicList() {
        return this.mLocalMusicList;
    }

    public String getPhotoCount() {
        return String.valueOf(this.mPhotoCount);
    }

    public String getPlayingMusicName() {
        VideoMusic videoMusic = this.mPlayingMusic;
        if (videoMusic == null) {
            return null;
        }
        return videoMusic.h();
    }

    public String getTransitionTypeNameForStat() {
        PhotoMovieFactory$PhotoMovieType photoMovieFactory$PhotoMovieType = this.mCurType;
        return photoMovieFactory$PhotoMovieType == PhotoMovieFactory$PhotoMovieType.VERTICAL_TRANS ? TJAdUnitConstants.String.PORTRAIT : photoMovieFactory$PhotoMovieType == PhotoMovieFactory$PhotoMovieType.HORIZONTAL_TRANS ? "Landscape" : "";
    }

    public String getWorkId() {
        return this.mPhotoMovieView.getFragment().getArguments() != null ? this.mPhotoMovieView.getFragment().getArguments().getString("work_id", "") : "";
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == REQUEST_MUSIC && i3 == -1 && intent != null) {
            playMusic((VideoMusic) intent.getParcelableExtra("music_select"));
        }
    }

    @Override // com.hw.photomovie.e.a.InterfaceC0200a
    public void onMovieEnd() {
        this.mPhotoMoviePlayer.p(0);
        this.mPhotoMoviePlayer.w();
    }

    @Override // com.hw.photomovie.e.a.InterfaceC0200a
    public void onMovieResumed() {
    }

    @Override // com.hw.photomovie.e.a.InterfaceC0200a
    public void onMovieStarted() {
    }

    @Override // com.hw.photomovie.e.a.InterfaceC0200a
    public void onMovieUpdate(int i2) {
    }

    @Override // com.hw.photomovie.e.a.InterfaceC0200a
    public void onMoviedPaused() {
    }

    @Override // us.pinguo.inspire.module.photomovie.widget.PhotoMovieMusicCallback
    public void onMusicSelect(VideoMusic videoMusic) {
        playMusic(videoMusic);
        this.mPhotoMovieView.hideMusicLayout();
    }

    @Override // us.pinguo.inspire.module.photomovie.widget.PhotoMovieMusicCallback
    public void onOnlineMusicClick() {
        Intent intent = new Intent(this.mPhotoMovieView.getActivity(), VideoMusicListActivity.class);
        intent.putExtra("publish_video_type", 1);
        intent.putExtra(us.pinguo.foundation.constant.a.f10982f, false);
        this.mPhotoMovieView.getFragment().startActivityForResult(intent, REQUEST_MUSIC);
        this.mPhotoMovieView.hideMusicLayout();
        h.a.m0("pic_video_edit", "library", "", getPlayingMusicName() == null ? "" : getPlayingMusicName(), "click", getTransitionTypeNameForStat(), getWorkId());
    }

    public void onPause() {
        PhotoMoviePlayer photoMoviePlayer = this.mPhotoMoviePlayer;
        if (photoMoviePlayer != null) {
            photoMoviePlayer.x();
        }
    }

    public void onPhotoSelected(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new UilPhotoData(InspirePublishFragment.FILE_HEADER + it.next(), 2));
        }
        com.hw.photomovie.a genPhotoMovie = genPhotoMovie(new d(arrayList2));
        this.mPhotoMovie = genPhotoMovie;
        playPhotoMovie(genPhotoMovie);
        this.mPhotoCount = arrayList.size();
    }

    public void onResume() {
        PhotoMoviePlayer photoMoviePlayer = this.mPhotoMoviePlayer;
        if (photoMoviePlayer != null) {
            photoMoviePlayer.w();
        }
    }

    @Override // us.pinguo.inspire.module.photomovie.widget.PhotoMovieTransferCallback
    public void onTransferSelect(PhotoMovieFactory$PhotoMovieType photoMovieFactory$PhotoMovieType) {
        if (this.mCurType == photoMovieFactory$PhotoMovieType) {
            return;
        }
        this.mCurType = photoMovieFactory$PhotoMovieType;
        this.mPhotoMovie = genPhotoMovie(this.mPhotoMovie.f());
        this.mPhotoMoviePlayer.x();
        startPhotoMovie(this.mPhotoMovie);
        String transitionTypeNameForStat = getTransitionTypeNameForStat();
        h.a.m0("pic_video_edit", transitionTypeNameForStat, "", getPlayingMusicName() == null ? "" : getPlayingMusicName(), "click", transitionTypeNameForStat, getWorkId());
    }

    public void onVideoSelected(String str) {
        Intent startIntent = VideoEdit2Activity.getStartIntent(this.mPhotoMovieView.getActivity(), str, new InspireTask(), 0);
        if (this.mPhotoMovieView.getFragment().getArguments() != null && this.mPhotoMovieView.getFragment().getArguments().containsKey("task")) {
            startIntent.putExtra("task", this.mPhotoMovieView.getFragment().getArguments().getParcelable("task"));
        }
        this.mPhotoMovieView.getActivity().startActivity(startIntent);
        this.mPhotoMovieView.getActivity().finish();
    }

    public void saveVideo() {
        saveVideoImpl();
    }
}
