package us.pinguo.inspire.module.publish;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.rockerhieu.emoji.KeyboardLayout;
import com.rockerhieu.emoji.expression.ExpressionPagerView;
import com.rockerhieu.emoji.expression.FaceSize;
import com.rockerhieu.emoji.model.DelEmoticon;
import com.rockerhieu.emoji.model.Emoticon;
import com.rockerhieu.emoji.model.EmoticonPkg;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import rx.functions.Action1;
import us.pinguo.common.imageloader.widget.ImageLoaderView;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.foundation.base.InspireContentActivity;
import us.pinguo.foundation.base.InspireRedirectActivity;
import us.pinguo.foundation.statistics.F$key;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.UserBannedException;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.module.MissionDetail.TaskDetailActivity;
import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
import us.pinguo.inspire.module.attention.InspireAttention;
import us.pinguo.inspire.module.challenge.FollowActivity;
import us.pinguo.inspire.module.comment.CommentLoader;
import us.pinguo.inspire.module.discovery.entity.InspireFeedPhoto;
import us.pinguo.inspire.module.guide.Common;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.inspire.module.publish.PublishGridView;
import us.pinguo.inspire.module.publish.utils.UUIDUtils;
import us.pinguo.inspire.module.publish.vo.PublishData;
import us.pinguo.inspire.proxy.InspireStatistics;
import us.pinguo.inspire.util.emoticon.EmoticonManager;
import us.pinguo.inspire.util.v;
import us.pinguo.inspire.widget.photopager.FullScreenPhoto;
import us.pinguo.inspire.widget.photopager.PictureViewPagerActivity;
import us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment;
import us.pinguo.ui.b.a;
import us.pinguo.ui.uilview.PhotoImageView;
import us.pinguo.ui.widget.snack.SnackTop;
import us.pinguo.user.ui.view.CompatibleToolbar;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class InspirePublishFragment extends InspireBaseFragment implements View.OnClickListener, KeyboardLayout.b, ActivityCompat.OnRequestPermissionsResultCallback {
    public static final String FILE_HEADER = "file://";
    public static final String FROM_ALBUM_VIDEO = "from_album_video";
    public static final String FROM_EXIST_PIC = "from_exist_pic";
    public static final String FROM_EXIST_VIDEO = "from_exist_video";
    public static final String FROM_NORMAL = "from_normal";
    public static final String FROM_NORMAL_CAMERA = "from_normal_camera";
    public static final String FROM_PORTAL = "from_portal_pic";
    public static final String FROM_SCENE_TEMPLATE = "from_scene_template";
    public static final String FROM_STICKER_PHOTO = "from_sticker_photo";
    public static final String FROM_TASK_EFFECT = "from_task_effect";
    public static final String FROM_VIDEO = "from_video";
    public static final String KEY_CLIENT_ID = "client_id";
    public static final String KEY_PHOTO_PICK_COUNT_LIMIT = "photo_count_limit";
    public static final String KEY_PHOTO_PICK_MODE_VALUE = "photo_pick_mode_value";
    public static final String KEY_VIDEO_TIME_LIMIT = "video_time_limit";
    public static final int MAX_DESC_COUNT = 140;
    public static final int MAX_PHOTO_COUNT = 9;
    public static final int MAX_VIDEO_COUNT = 1;
    public static final String MEDIA_TYPE_PICS = "from_portal_pic";
    public static final String MEDIA_TYPE_TASK_EFFECT_PHOTO = "media_task_effect_photo";
    public static final String MEDIA_TYPE_TASK_EFFECT_VIDEO = "media_task_effect_video";
    public static final String MEDIA_TYPE_VIDEO = "from_portal_video";
    public static final String PUBLISH_EXTRA_ENTRANCE_TYPE = "PUBLISH_EXTRA_ENTRANCE_TYPE";
    public static final String PUBLISH_EXTRA_FIRST_FRAME_PATH = "PUBLISH_EXTRA_FIRST_FRAME_PATH";
    public static final String PUBLISH_EXTRA_IMAGE_PATH = "PUBLISH_EXTRA_IMAGE_PATH";
    public static final String PUBLISH_EXTRA_MEDIA_TYPE = "PUBLISH_EXTRA_MEDIA_TYPE";
    public static String sTaskId;
    private ImageLoaderView change_scene;
    private boolean isLaunchFirstTime;
    private boolean isPhotoPublish;
    private ImageView iv_emoji;
    private View mAddMoreView;
    private EditText mDescriptionEt;
    private ExpressionPagerView mExpressionPagerView;
    private InspireTask mInspireTask;
    private KeyboardLayout mKeyboardLayout;
    private boolean mLessThanMax;
    private LocalBroadcastManager mLocalBroadcastManager;
    private View mPhotoContainerLl;
    private PublishGridView mPhotoFgv;
    private String mPhotoPath;
    private a.C0454a mProgressDialog;
    private TextView mPublishBtn;
    private Toolbar mToolbar;
    private View mVideoCoverContainerView;
    private PhotoImageView mVideoCoverPiv;
    private String pictureParam;
    private LinearLayout root;
    private TextView tv_count;
    private ArrayList<String> mFilePathes = new ArrayList<>();
    private int mScreenWidth = us.pinguo.foundation.t.b.a.j(Inspire.a());
    private int mVideoType = 0;
    private BroadcastReceiver mFinishReceiver = new BroadcastReceiver() { // from class: us.pinguo.inspire.module.publish.InspirePublishFragment.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (InspirePublishFragment.this.isLaunchFirstTime) {
                InspirePublishFragment.this.getActivity().finish();
            }
        }
    };
    private PublishGridView.OnItemClick onItemClick = new AnonymousClass9();
    private PublishGridView.DeleteItemClick deleItemClick = new PublishGridView.DeleteItemClick() { // from class: us.pinguo.inspire.module.publish.InspirePublishFragment.10
        @Override // us.pinguo.inspire.module.publish.PublishGridView.DeleteItemClick
        public void deleteItemClick(View view, int i2) {
            if (InspirePublishFragment.this.mFilePathes == null || i2 >= InspirePublishFragment.this.mFilePathes.size()) {
                return;
            }
            String str = (String) InspirePublishFragment.this.mFilePathes.remove(i2);
            InspirePublishFragment.this.notifyPhotoChanged();
        }
    };
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: us.pinguo.inspire.module.publish.InspirePublishFragment.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.tv_submit_inspire_publish) {
                InspirePublishFragment.this.onClickPublish();
            } else if (view.getId() == R.id.ll_select_friends_inspire_publish) {
                InspirePublishFragment.this.onClickSelectFriends();
            } else if (view.getId() == R.id.iv_play_video_inspire_publish) {
                InspirePublishFragment.this.hideSoftInput();
                InspirePublishFragment.this.onClickPlayVideo();
            } else if (view.getId() == R.id.piv_video_cover_inspire_publish) {
                InspirePublishFragment.this.onClickVideoCoverView();
            } else if (view.getId() == R.id.ll_add_more_inspire_publish) {
                InspirePublishFragment.this.hideSoftInput();
                if (InspirePublishFragment.this.isPhotoPublish) {
                    if ((InspirePublishFragment.this.mFilePathes != null && InspirePublishFragment.this.mFilePathes.size() == 9) || InspirePublishFragment.this.mInspireTask != null) {
                        Toast.makeText(InspirePublishFragment.this.getContext(), InspirePublishFragment.this.getString(R.string.comment_max_pic_count), 0).show();
                        return;
                    }
                } else if ((InspirePublishFragment.this.mFilePathes != null && InspirePublishFragment.this.mFilePathes.size() == 1) || InspirePublishFragment.this.mInspireTask != null) {
                    Toast.makeText(InspirePublishFragment.this.getContext(), InspirePublishFragment.this.getString(R.string.publish_video_msg), 0).show();
                    return;
                }
                us.pinguo.foundation.statistics.l.onEvent(InspirePublishFragment.this.getActivity(), "Community_SendPreview_Plus_Ablum_Click");
                InspirePublishFragment.this.launchGallery();
            }
        }
    };
    private ArrayList<InspireAttention> mAttentons = new ArrayList<>();
    private int mKeyboardState = -2;
    private boolean mEditTextClick = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: us.pinguo.inspire.module.publish.InspirePublishFragment$9  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass9 implements PublishGridView.OnItemClick {
        AnonymousClass9() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b(int i2, Intent intent) {
            if (i2 == -1) {
                InspirePublishFragment.this.mFilePathes.clear();
                InspirePublishFragment.this.mFilePathes.addAll((ArrayList) intent.getSerializableExtra(PictureViewPagerDialogFragment.EXTRA_IMAGE_URLS));
                InspirePublishFragment.this.notifyPhotoChanged();
            }
        }

        @Override // us.pinguo.inspire.module.publish.PublishGridView.OnItemClick
        public void onItemClick(View view, int i2) {
            Intent intent = new Intent(InspirePublishFragment.this.getActivity(), PictureViewPagerActivity.class);
            intent.putExtra(PictureViewPagerDialogFragment.EXTRA_CURRENT_ITEM, i2);
            intent.putExtra("EXTRA_DELETE_ENABLE", true);
            intent.putExtra(PictureViewPagerDialogFragment.EXTRA_IMAGE_URLS, InspirePublishFragment.this.mFilePathes);
            InspirePublishFragment.this.startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.publish.c
                @Override // us.pinguo.foundation.proxy.c
                public final void onActivityResult(int i3, Intent intent2) {
                    InspirePublishFragment.AnonymousClass9.this.b(i3, intent2);
                }
            });
            InspirePublishFragment.this.getActivity().overridePendingTransition(17432576, 17432577);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0 */
    public /* synthetic */ void b0(View view) {
        hideSoftInput();
        us.pinguo.foundation.statistics.l.onEvent(view.getContext(), "Community_SendPreview_Cancel_Click");
        getActivity().onBackPressed();
    }

    private void addOnClickListener(View view, int i2, View.OnClickListener onClickListener) {
        view.findViewById(i2).setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0 */
    public /* synthetic */ void d0(View view) {
        us.pinguo.common.log.a.m("chenxiaookai", "chenxiaokai=====>3", new Object[0]);
        if (this.mExpressionPagerView.getVisibility() == 0) {
            us.pinguo.common.log.a.m("chenxiaookai", "chenxiaokai=====>4", new Object[0]);
            this.mEditTextClick = true;
            this.iv_emoji.setImageResource(R.drawable.chat_bottom_face);
        }
    }

    private boolean checkIsLogin() {
        if (us.pinguo.user.s0.getInstance().e() || !CommentLoader.isLoginRequired()) {
            return true;
        }
        us.pinguo.foundation.statistics.h.a.g("", us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, "show");
        us.pinguo.user.s0.getInstance().a(getActivity(), 0, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
        return false;
    }

    private void checkToShowGuide() {
        if (Inspire.c().getBoolean(Common.publishKey, true)) {
            getActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: us.pinguo.inspire.module.publish.InspirePublishFragment.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT >= 16) {
                        InspirePublishFragment.this.getActivity().getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else {
                        InspirePublishFragment.this.getActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                    Inspire.c().edit().putBoolean(Common.publishKey, false).commit();
                }
            });
        }
    }

    private void clearImageCache(String str) {
        d.f.a.b.e.c(FILE_HEADER + str, ImageLoader.getInstance().o());
        d.f.a.b.a.a(FILE_HEADER + str, ImageLoader.getInstance().m());
    }

    private PublishData createPublishData() {
        String obj = this.mDescriptionEt.getText().toString();
        for (int size = this.mAttentons.size() - 1; size >= 0; size--) {
            InspireAttention inspireAttention = this.mAttentons.get(size);
            if (inspireAttention != null) {
                if (!obj.contains("@" + inspireAttention.nickname)) {
                    this.mAttentons.remove(inspireAttention);
                }
            }
        }
        for (int size2 = this.mAttentons.size() - 1; size2 >= 0; size2 += -1) {
            InspireAttention inspireAttention2 = this.mAttentons.get(size2);
            obj = obj.replace("@" + inspireAttention2.nickname, "<@ " + inspireAttention2.userId + ">" + inspireAttention2.nickname + "</@>");
        }
        InspireTask inspireTask = this.mInspireTask;
        String str = inspireTask == null ? null : inspireTask.taskId;
        PublishData publishData = new PublishData();
        publishData.taskId = str;
        publishData.pictureParam = this.pictureParam;
        publishData.isPhoto = this.isPhotoPublish;
        publishData.videoType = this.mVideoType;
        publishData.filePathes = this.mFilePathes;
        publishData.attentions = this.mAttentons;
        publishData.desc = obj;
        publishData.noGeo = 1;
        publishData.poi = null;
        publishData.placeId = null;
        return publishData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0 */
    public /* synthetic */ void f0(View view) {
        this.mVideoCoverContainerView.setVisibility(8);
        this.mFilePathes.clear();
        notifyPhotoChanged();
    }

    private void enterBigPicSeekMode(ArrayList<String> arrayList) {
        final PhotoImageView photoImageView = this.mVideoCoverPiv;
        us.pinguo.foundation.t.a.g gVar = (us.pinguo.foundation.t.a.g) photoImageView.getDrawable();
        Bitmap a = gVar != null ? gVar.a() : null;
        if (a == null) {
            return;
        }
        Rect rect = new Rect();
        int[] iArr = new int[2];
        photoImageView.getLocationInWindow(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + photoImageView.getWidth(), iArr[1] + photoImageView.getHeight());
        ArrayList arrayList2 = new ArrayList();
        FullScreenPhoto fullScreenPhoto = new FullScreenPhoto();
        fullScreenPhoto.rect = rect;
        InspireFeedPhoto inspireFeedPhoto = new InspireFeedPhoto();
        fullScreenPhoto.photo = inspireFeedPhoto;
        inspireFeedPhoto.url = arrayList.get(0);
        fullScreenPhoto.photo.width = a.getWidth();
        fullScreenPhoto.photo.height = a.getHeight();
        arrayList2.add(fullScreenPhoto);
        PictureViewPagerDialogFragment.showFullScreenPics(getActivity().getSupportFragmentManager(), new Bitmap[]{a}, arrayList2, 0, new PictureViewPagerDialogFragment.c() { // from class: us.pinguo.inspire.module.publish.InspirePublishFragment.12
            @Override // us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment.c
            public Rect getPicRect(int i2) {
                Rect rect2 = new Rect();
                int[] iArr2 = new int[2];
                photoImageView.getLocationInWindow(iArr2);
                rect2.set(iArr2[0], iArr2[1], iArr2[0] + photoImageView.getWidth(), iArr2[1] + photoImageView.getHeight());
                return rect2;
            }
        });
    }

    private void fromPortal(Bundle bundle) {
        this.isLaunchFirstTime = false;
        ArrayList<String> stringArrayList = bundle.getStringArrayList("from_portal_pic");
        if (!us.pinguo.foundation.utils.k.a(stringArrayList)) {
            this.isPhotoPublish = true;
            this.mFilePathes.addAll(stringArrayList);
            notifyPhotoChanged();
            this.mPhotoContainerLl.setVisibility(0);
            this.mVideoCoverContainerView.setVisibility(8);
            return;
        }
        this.isPhotoPublish = false;
        String string = bundle.getString(MEDIA_TYPE_VIDEO);
        this.mPhotoContainerLl.setVisibility(8);
        this.mVideoCoverContainerView.setVisibility(0);
        this.mAddMoreView.setVisibility(8);
        resultFromSelectVideo(string);
    }

    private void fromTaskEffect(Bundle bundle) {
        this.isLaunchFirstTime = false;
        this.mAddMoreView.setVisibility(8);
        String string = bundle.getString(MEDIA_TYPE_TASK_EFFECT_PHOTO);
        if (!TextUtils.isEmpty(string)) {
            resultFromTaskPhoto(string);
            return;
        }
        this.isPhotoPublish = false;
        String string2 = bundle.getString(MEDIA_TYPE_TASK_EFFECT_VIDEO);
        this.mPhotoContainerLl.setVisibility(8);
        this.mVideoCoverContainerView.setVisibility(0);
        resultFromSelectVideo(string2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ void h0(String str, int i2, Intent intent) {
        this.pictureParam = intent.getStringExtra("PUBLISH_EXTRA_PICTURE_PARAMS");
        us.pinguo.common.log.a.c("the picture param is:" + this.pictureParam, new Object[0]);
        if (i2 == -1) {
            this.isLaunchFirstTime = false;
            resultFromCamera(str);
        }
    }

    private void hideExpressionView() {
        Window window = ((Activity) getContext()).getWindow();
        this.mExpressionPagerView.setVisibility(8);
        if (window.getAttributes().softInputMode != 19) {
            window.setSoftInputMode(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hideSoftInput() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (this.mKeyboardState == -2 || inputMethodManager == null) {
            return false;
        }
        return inputMethodManager.hideSoftInputFromWindow(this.mDescriptionEt.getApplicationWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public /* synthetic */ void j0(String str, int i2, Intent intent) {
        if (intent == null) {
            return;
        }
        this.pictureParam = intent.getStringExtra("PUBLISH_EXTRA_PICTURE_PARAMS");
        us.pinguo.common.log.a.c("the picture param is:" + this.pictureParam, new Object[0]);
        if (i2 == -1) {
            this.isLaunchFirstTime = false;
            resultFromCamera(str);
        }
    }

    private void initBundleAction() {
        Bundle arguments = getArguments();
        int i2 = arguments.getInt(PUBLISH_EXTRA_ENTRANCE_TYPE, -1);
        String string = arguments.getString("key_participant_from");
        notifyPhotoChanged();
        if (-1 != i2) {
            initEntranceLauncher(arguments);
        } else if (!TextUtils.isEmpty(string)) {
            initFromTypeLauncher(arguments);
        } else {
            int i3 = arguments.getInt(PUBLISH_EXTRA_MEDIA_TYPE);
            if (i3 == 1) {
                launchCamera();
            } else if (i3 == 2) {
                launchVideoCamera();
            } else if (i3 != 7) {
            } else {
                launchGallery();
            }
        }
    }

    private void initEmoticonPkgs() {
        this.mExpressionPagerView.setOnEmoticonClickListener(new com.rockerhieu.emoji.expression.d() { // from class: us.pinguo.inspire.module.publish.InspirePublishFragment.8
            public void onDownloadClick(EmoticonPkg emoticonPkg) {
            }

            @Override // com.rockerhieu.emoji.expression.d
            public void onEmoticonClick(Emoticon emoticon) {
                if (emoticon instanceof DelEmoticon) {
                    if (InspirePublishFragment.this.mDescriptionEt.getEditableText().toString().length() > 0) {
                        InspirePublishFragment.this.mDescriptionEt.dispatchKeyEvent(new KeyEvent(0, 67));
                    }
                } else if (emoticon == null || !emoticon.isSmall()) {
                } else {
                    String name = emoticon.getName();
                    String obj = InspirePublishFragment.this.mDescriptionEt.getEditableText().toString();
                    int selectionStart = InspirePublishFragment.this.mDescriptionEt.getSelectionStart();
                    int selectionEnd = InspirePublishFragment.this.mDescriptionEt.getSelectionEnd();
                    SpannableString b = us.pinguo.inspire.util.emoticon.i.b(InspirePublishFragment.this.mDescriptionEt, name);
                    if (obj.length() == 0 || selectionStart < 0) {
                        InspirePublishFragment.this.mDescriptionEt.append(b);
                    } else if (selectionStart == selectionEnd) {
                        InspirePublishFragment.this.mDescriptionEt.getEditableText().insert(selectionStart, b);
                    } else {
                        InspirePublishFragment.this.mDescriptionEt.getEditableText().replace(selectionStart, selectionEnd, name);
                    }
                }
            }
        });
        this.mExpressionPagerView.f(EmoticonManager.getInstance().f(), R.drawable.expression_delete, FaceSize.g(getResources()));
    }

    private void initEntranceLauncher(Bundle bundle) {
        int i2 = bundle.getInt(PUBLISH_EXTRA_ENTRANCE_TYPE, -1);
        String string = bundle.getString(PUBLISH_EXTRA_IMAGE_PATH);
        us.pinguo.common.log.a.c("lxf", "inspire, entrance:" + i2 + ", imagePath:" + string);
        if (i2 == 1) {
            this.isPhotoPublish = true;
            clearImageCache(string);
            resultFromCamera(string);
        } else if (i2 != 2) {
        } else {
            switchToVideoMode();
            String string2 = bundle.getString(PUBLISH_EXTRA_FIRST_FRAME_PATH);
            Log.d("lxf", "inspire, entrance:" + i2 + ", firstFramePath:" + string2);
            resultFromVideoCamera(string, string2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0041, code lost:
        if (r0.equals("from_portal_pic") == false) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void initFromTypeLauncher(android.os.Bundle r9) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.inspire.module.publish.InspirePublishFragment.initFromTypeLauncher(android.os.Bundle):void");
    }

    private void initSoftKeyboard() {
        final us.pinguo.inspire.util.v vVar = new us.pinguo.inspire.util.v(getActivity(), this.root);
        int f2 = vVar.f();
        final int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.expression_layout_max_height);
        ViewGroup.LayoutParams layoutParams = this.mExpressionPagerView.getLayoutParams();
        if (f2 > 0 && f2 < dimensionPixelSize) {
            layoutParams.height = f2;
            this.mExpressionPagerView.setLayoutParams(layoutParams);
        } else if (f2 > 0 && f2 > dimensionPixelSize) {
            layoutParams.height = dimensionPixelSize;
            this.mExpressionPagerView.setLayoutParams(layoutParams);
        }
        this.mExpressionPagerView.getViewTreeObserver().addOnGlobalLayoutListener(vVar);
        vVar.i(new v.b() { // from class: us.pinguo.inspire.module.publish.InspirePublishFragment.7
            @Override // us.pinguo.inspire.util.v.b
            public void onKeyboardChange(boolean z) {
                if (z) {
                    int f3 = vVar.f();
                    int i2 = dimensionPixelSize;
                    if (f3 > i2) {
                        f3 = i2;
                    }
                    if (f3 > 0) {
                        ViewGroup.LayoutParams layoutParams2 = InspirePublishFragment.this.mExpressionPagerView.getLayoutParams();
                        layoutParams2.height = f3;
                        InspirePublishFragment.this.mExpressionPagerView.setLayoutParams(layoutParams2);
                    }
                    vVar.i(null);
                    if (InspirePublishFragment.this.mExpressionPagerView.getViewTreeObserver() != null) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            InspirePublishFragment.this.mExpressionPagerView.getViewTreeObserver().removeOnGlobalLayoutListener(vVar);
                        } else {
                            InspirePublishFragment.this.mExpressionPagerView.getViewTreeObserver().removeGlobalOnLayoutListener(vVar);
                        }
                    }
                }
            }
        });
    }

    private void initToolbar(View view) {
        Toolbar b = ((CompatibleToolbar) view.findViewById(R.id.toolbar_publish)).b();
        this.mToolbar = b;
        b.setTitle(R.string.public_title);
        this.mToolbar.setNavigationIcon(us.pinguo.ui.R.drawable.navigation_back_black);
        this.mToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.publish.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                InspirePublishFragment.this.b0(view2);
            }
        });
        this.mPublishBtn = (TextView) view.findViewById(R.id.tv_submit_inspire_publish);
    }

    private void initViews(View view) {
        initToolbar(view);
        this.tv_count = (TextView) view.findViewById(R.id.tv_publish_word_count);
        this.root = (LinearLayout) view.findViewById(R.id.root_res_0x7d0601f7);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_emoji);
        this.iv_emoji = imageView;
        imageView.setImageResource(R.drawable.chat_bottom_face);
        this.iv_emoji.setOnClickListener(this);
        ImageLoaderView imageLoaderView = (ImageLoaderView) view.findViewById(R.id.change_scene);
        this.change_scene = imageLoaderView;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageLoaderView.getLayoutParams();
        layoutParams.width = us.pinguo.foundation.t.b.a.j(getContext()) / 4;
        layoutParams.height = us.pinguo.foundation.t.b.a.j(getContext()) / 4;
        this.change_scene.setLayoutParams(layoutParams);
        EditText editText = (EditText) view.findViewById(R.id.et_description_inspire_publish);
        this.mDescriptionEt = editText;
        editText.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.publish.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                InspirePublishFragment.this.d0(view2);
            }
        });
        this.mDescriptionEt.setOnTouchListener(new View.OnTouchListener() { // from class: us.pinguo.inspire.module.publish.InspirePublishFragment.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    us.pinguo.common.log.a.m("chenxiaookai", "chenxiaokai=====>1", new Object[0]);
                    if (InspirePublishFragment.this.mExpressionPagerView.getVisibility() == 0) {
                        us.pinguo.common.log.a.m("chenxiaookai", "chenxiaokai=====>2", new Object[0]);
                        InspirePublishFragment.this.mEditTextClick = true;
                        InspirePublishFragment.this.iv_emoji.setImageResource(R.drawable.chat_bottom_face);
                    }
                }
                return false;
            }
        });
        this.mDescriptionEt.addTextChangedListener(new com.rockerhieu.emoji.b() { // from class: us.pinguo.inspire.module.publish.InspirePublishFragment.5
            @Override // com.rockerhieu.emoji.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int length = 140 - editable.toString().length();
                if (length < 0) {
                    if (InspirePublishFragment.this.mLessThanMax) {
                        SnackTop.p(InspirePublishFragment.this.root, InspirePublishFragment.this.root.getContext().getString(R.string.publish_content_too_long), 0, -218253006).m();
                        InspirePublishFragment.this.mLessThanMax = false;
                    }
                    InspirePublishFragment.this.tv_count.setTextColor(Color.parseColor("#F05853"));
                } else {
                    InspirePublishFragment.this.mLessThanMax = true;
                    InspirePublishFragment.this.tv_count.setTextColor(Color.parseColor("#90000000"));
                }
                InspirePublishFragment.this.tv_count.setText(String.valueOf(length));
            }
        });
        this.mPhotoContainerLl = view.findViewById(R.id.pgv_photos_inspire_publish);
        View findViewById = view.findViewById(R.id.rl_video_cover_inspire_publish);
        this.mVideoCoverContainerView = findViewById;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
        int j2 = (us.pinguo.foundation.t.b.a.j(getActivity()) - (us.pinguo.foundation.t.b.a.a(getContext(), 4.0f) * 2)) / 3;
        layoutParams2.height = j2;
        layoutParams2.width = j2;
        this.mVideoCoverContainerView.setLayoutParams(layoutParams2);
        view.findViewById(R.id.iv_close_res_0x7d06012c).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.publish.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                InspirePublishFragment.this.f0(view2);
            }
        });
        this.mAddMoreView = view.findViewById(R.id.ll_add_more_inspire_publish);
        PhotoImageView photoImageView = (PhotoImageView) view.findViewById(R.id.piv_video_cover_inspire_publish);
        this.mVideoCoverPiv = photoImageView;
        photoImageView.setImgCenterCrop(false);
        PublishGridView publishGridView = (PublishGridView) view.findViewById(R.id.pgv_photos_inspire_publish);
        this.mPhotoFgv = publishGridView;
        publishGridView.setPublishPage(true);
        this.mPhotoFgv.setColumn(3);
        this.mPhotoFgv.setCount(9);
        this.mPhotoFgv.setOnItemClick(this.onItemClick);
        this.mPhotoFgv.setOnDeleItemClick(this.deleItemClick);
        this.mPhotoFgv.setOnFinal(new PublishGridView.OnItemFinal() { // from class: us.pinguo.inspire.module.publish.InspirePublishFragment.6
            @Override // us.pinguo.inspire.module.publish.PublishGridView.OnItemFinal
            public void onItemFinal(View view2, int i2) {
                InspirePublishFragment.this.hideSoftInput();
                InspirePublishFragment.this.onClickAddPhoto();
            }
        });
        TextView textView = (TextView) view.findViewById(R.id.tv_submit_inspire_publish);
        this.mPublishBtn = textView;
        textView.setText(R.string.publish_share_title);
        this.mPublishBtn.getPaint().setFakeBoldText(true);
        this.mPublishBtn.setOnClickListener(this.onClickListener);
        addOnClickListener(view, R.id.piv_video_cover_inspire_publish, this.onClickListener);
        addOnClickListener(view, R.id.iv_play_video_inspire_publish, this.onClickListener);
        addOnClickListener(view, R.id.ll_select_friends_inspire_publish, this.onClickListener);
        addOnClickListener(view, R.id.ll_select_friends_inspire_publish, this.onClickListener);
        addOnClickListener(view, R.id.ll_add_more_inspire_publish, this.onClickListener);
        KeyboardLayout keyboardLayout = (KeyboardLayout) view.findViewById(R.id.keyboard_layout);
        this.mKeyboardLayout = keyboardLayout;
        keyboardLayout.setOnkbdStateListener(this);
        this.mExpressionPagerView = (ExpressionPagerView) view.findViewById(R.id.chat_bottom_expression);
        initEmoticonPkgs();
        initSoftKeyboard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void l0(int i2, Intent intent) {
        if (i2 == -1) {
            if (this.mExpressionPagerView.getVisibility() == 0) {
                ((Activity) getContext()).getWindow().setSoftInputMode(19);
                this.mExpressionPagerView.setVisibility(8);
                this.iv_emoji.setImageResource(R.drawable.chat_bottom_face);
            }
            this.isLaunchFirstTime = false;
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("photo_path_list");
            if (!us.pinguo.foundation.utils.k.a(stringArrayListExtra)) {
                this.isPhotoPublish = true;
                this.mFilePathes.addAll(stringArrayListExtra);
                this.mPhotoContainerLl.setVisibility(0);
                this.mVideoCoverContainerView.setVisibility(8);
                notifyPhotoChanged();
                return;
            }
            this.isPhotoPublish = false;
            String stringExtra = intent.getStringExtra("photo_path");
            this.mPhotoContainerLl.setVisibility(8);
            this.mVideoCoverContainerView.setVisibility(0);
            this.mAddMoreView.setVisibility(0);
            resultFromSelectVideo(stringExtra);
        }
    }

    private void launchArCamera() {
        this.isPhotoPublish = true;
        this.mPhotoContainerLl.setVisibility(0);
        this.mVideoCoverContainerView.setVisibility(8);
        Uri generatePhotoFile = generatePhotoFile();
        final String path = generatePhotoFile.getPath();
        Intent intent = new Intent();
        intent.setAction("com.camera360.ar_IMAGE_CAPTURE");
        intent.putExtra("output", generatePhotoFile);
        startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.publish.f
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i2, Intent intent2) {
                InspirePublishFragment.this.h0(path, i2, intent2);
            }
        });
        us.pinguo.foundation.statistics.l.onEvent("c360_ARCam_Start_PostPage_byPlus", F$key.ar);
    }

    private void launchCamera() {
        this.isPhotoPublish = true;
        this.mPhotoContainerLl.setVisibility(0);
        this.mVideoCoverContainerView.setVisibility(8);
        Uri generatePhotoFile = generatePhotoFile();
        final String path = generatePhotoFile.getPath();
        Intent intent = new Intent();
        intent.setAction("com.camera360.inspire_IMAGE_CAPTURE");
        intent.putExtra("output", generatePhotoFile);
        intent.putExtra("camera_type", 1);
        startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.publish.k
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i2, Intent intent2) {
                InspirePublishFragment.this.j0(path, i2, intent2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchGallery() {
        Intent intent = new Intent();
        intent.setClassName(getActivity(), "com.pinguo.camera360.gallery.photopick.PhotoPickActivity");
        intent.putExtra(KEY_PHOTO_PICK_COUNT_LIMIT, 9 - this.mFilePathes.size());
        if (this.mFilePathes.isEmpty()) {
            intent.putExtra(KEY_PHOTO_PICK_MODE_VALUE, 4);
            intent.putExtra(KEY_VIDEO_TIME_LIMIT, 60);
        } else {
            intent.putExtra(KEY_PHOTO_PICK_MODE_VALUE, 5);
        }
        startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.publish.a
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i2, Intent intent2) {
                InspirePublishFragment.this.l0(i2, intent2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchMediaCamera() {
        int i2 = getArguments().getInt(PUBLISH_EXTRA_MEDIA_TYPE);
        if (i2 == 4) {
            launchSelfieCamera();
        } else if (i2 == 5) {
            launchSceneTemplateCamera("", false);
        } else if (i2 != 6) {
            launchCamera();
        } else {
            launchArCamera();
        }
    }

    private void launchSceneTemplateCamera(String str, final boolean z) {
        Uri generatePhotoFile = generatePhotoFile();
        final String path = generatePhotoFile.getPath();
        Intent intent = new Intent();
        intent.setAction("com.camera360.scene_IMAGE_CAPTURE");
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(TaskDetailBasePresenter.SCENE_LIST)) {
                intent.putExtra("open_list", true);
            } else {
                intent.putExtra("scene_id", str);
            }
        }
        intent.putExtra("output", generatePhotoFile);
        startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.publish.j
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i2, Intent intent2) {
                InspirePublishFragment.this.n0(z, path, i2, intent2);
            }
        });
        if (z) {
            return;
        }
        us.pinguo.foundation.statistics.l.onEvent("c360_SceneCam_Start_PostPage_byPlus", F$key.scene);
    }

    private void launchSelfieCamera() {
        this.isPhotoPublish = true;
        this.mPhotoContainerLl.setVisibility(0);
        this.mVideoCoverContainerView.setVisibility(8);
        Uri generatePhotoFile = generatePhotoFile();
        final String path = generatePhotoFile.getPath();
        Intent intent = new Intent();
        intent.setAction("com.camera360.selfie_IMAGE_CAPTURE");
        intent.putExtra("output", generatePhotoFile);
        startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.publish.g
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i2, Intent intent2) {
                InspirePublishFragment.this.p0(path, i2, intent2);
            }
        });
        us.pinguo.foundation.statistics.l.onEvent("c360_SelfieCam_Start_PostPage_byPlus", F$key.camera);
    }

    private void launchSingleChoiceGallery() {
        this.isPhotoPublish = true;
        Intent intent = new Intent();
        intent.setClassName(getActivity(), "com.pinguo.camera360.gallery.photopick.PhotoPickActivity");
        intent.putExtra(KEY_PHOTO_PICK_MODE_VALUE, 6);
        startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.publish.b
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i2, Intent intent2) {
                InspirePublishFragment.this.r0(i2, intent2);
            }
        });
    }

    private void launchStickerCamera(String str, String str2) {
        Uri generatePhotoFile = generatePhotoFile();
        final String path = generatePhotoFile.getPath();
        Intent intent = new Intent();
        intent.setAction("com.camera360.inspire_IMAGE_CAPTURE");
        intent.putExtra("camera_type", 1);
        intent.putExtra("output", generatePhotoFile);
        startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.publish.InspirePublishFragment.15
            @Override // us.pinguo.foundation.proxy.c
            public void onActivityResult(int i2, Intent intent2) {
                if (i2 == -1) {
                    InspirePublishFragment.this.pictureParam = intent2.getStringExtra("PUBLISH_EXTRA_PICTURE_PARAMS");
                    InspirePublishFragment.this.resultFromTaskPhoto(path);
                }
            }
        });
    }

    private void launchTaskNormalCamera() {
        Uri generatePhotoFile = generatePhotoFile();
        final String path = generatePhotoFile.getPath();
        Intent intent = new Intent();
        intent.setAction("com.camera360.inspire_IMAGE_CAPTURE");
        intent.putExtra("output", generatePhotoFile);
        intent.putExtra("camera_type", 1);
        intent.putExtra("task", this.mInspireTask);
        startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.publish.InspirePublishFragment.16
            @Override // us.pinguo.foundation.proxy.c
            public void onActivityResult(int i2, Intent intent2) {
                if (i2 == -1) {
                    InspirePublishFragment.this.pictureParam = intent2.getStringExtra("PUBLISH_EXTRA_PICTURE_PARAMS");
                    InspirePublishFragment.this.resultFromTaskPhoto(path);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchVideoCamera() {
        this.isPhotoPublish = false;
        launchVideoCamera(null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void n0(boolean z, String str, int i2, Intent intent) {
        if (i2 == -1) {
            this.pictureParam = intent.getStringExtra("PUBLISH_EXTRA_PICTURE_PARAMS");
            this.isLaunchFirstTime = false;
            if (z) {
                resultFromTaskPhoto(str);
            } else {
                resultFromCamera(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPhotoChanged() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.mFilePathes.iterator();
        while (it.hasNext()) {
            arrayList.add(FILE_HEADER + it.next());
        }
        if (this.mFilePathes.size() < 9) {
            arrayList.add("drawable://2097479969");
        }
        this.mPhotoFgv.setColumn(3);
        this.mPhotoFgv.setCount(9);
        this.mPhotoFgv.setUris(arrayList);
        this.mAddMoreView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void p0(String str, int i2, Intent intent) {
        this.pictureParam = intent.getStringExtra("PUBLISH_EXTRA_PICTURE_PARAMS");
        us.pinguo.common.log.a.c("the picture param is:" + this.pictureParam, new Object[0]);
        if (i2 == -1) {
            this.isLaunchFirstTime = false;
            resultFromCamera(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickAddPhoto() {
        us.pinguo.foundation.statistics.l.onEvent(getActivity(), "Community_SendPreview_Plus_Click");
        String string = getActivity().getString(R.string.take_photo);
        String string2 = getActivity().getString(R.string.take_from_album);
        String[] strArr = {string, string2, getActivity().getString(R.string.take_video)};
        String[] strArr2 = {string, string2};
        if (!this.mFilePathes.isEmpty()) {
            strArr = strArr2;
        }
        us.pinguo.foundation.utils.w.s(getActivity(), strArr, new DialogInterface.OnClickListener() { // from class: us.pinguo.inspire.module.publish.InspirePublishFragment.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (i2 == 0) {
                    us.pinguo.foundation.statistics.l.onEvent(InspirePublishFragment.this.getActivity(), "Community_SendPreview_Plus_Camera_Click");
                    InspirePublishFragment.this.launchMediaCamera();
                } else if (i2 == 1) {
                    us.pinguo.foundation.statistics.l.onEvent(InspirePublishFragment.this.getActivity(), "Community_SendPreview_Plus_Ablum_Click");
                    InspirePublishFragment.this.launchGallery();
                } else if (i2 == 2) {
                    InspirePublishFragment.this.launchVideoCamera();
                }
                dialogInterface.dismiss();
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickPlayVideo() {
        if (us.pinguo.foundation.utils.k.a(this.mFilePathes)) {
            return;
        }
        us.pinguo.inspire_proxy.media.e.j(getActivity(), this.mFilePathes.get(0)).a((InspireBaseActivity) getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickPublish() {
        FragmentActivity activity;
        InspireStatistics.clickPublishBtn();
        hideSoftInput();
        if (!verify() || (activity = getActivity()) == null) {
            return;
        }
        us.pinguo.user.util.n.a.d(activity, new Runnable() { // from class: us.pinguo.inspire.module.publish.d
            @Override // java.lang.Runnable
            public final void run() {
                InspirePublishFragment.this.v0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickSelectFriends() {
        if (checkIsLogin()) {
            Intent intent = new Intent(getActivity(), InspireContentActivity.class);
            intent.putExtra(InspireContentActivity.FRAGMENT_NAME, InspireSelectAttentionListFragment.class.getName());
            ((InspireRedirectActivity) getActivity()).startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.publish.InspirePublishFragment.14
                @Override // us.pinguo.foundation.proxy.c
                public void onActivityResult(int i2, Intent intent2) {
                    if (i2 != -1 || intent2 == null) {
                        return;
                    }
                    InspirePublishFragment.this.refreshSelectFriends(intent2.getParcelableArrayListExtra(InspireSelectAttentionListFragment.InspireAttentionList));
                    InspirePublishFragment.this.mDescriptionEt.postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.publish.InspirePublishFragment.14.1
                        @Override // java.lang.Runnable
                        public void run() {
                            InspirePublishFragment.this.mDescriptionEt.setFocusable(true);
                            InspirePublishFragment.this.mDescriptionEt.setFocusableInTouchMode(true);
                            InspirePublishFragment.this.mDescriptionEt.requestFocus();
                            InspirePublishFragment.this.showSoftInput((InputMethodManager) InspirePublishFragment.this.getContext().getSystemService("input_method"));
                        }
                    }, 500L);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickVideoCoverView() {
        if (us.pinguo.foundation.utils.k.a(this.mFilePathes)) {
            return;
        }
        String str = this.mFilePathes.get(0);
        if (TextUtils.isEmpty(str) || !this.isPhotoPublish) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(FILE_HEADER + str);
        enterBigPicSeekMode(arrayList);
    }

    private void onFaceBtnClick() {
        Window window = ((Activity) getContext()).getWindow();
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (this.mExpressionPagerView.getVisibility() == 0) {
            window.setSoftInputMode(35);
            this.mExpressionPagerView.setVisibility(4);
            this.mDescriptionEt.setFocusable(true);
            this.mDescriptionEt.setFocusableInTouchMode(true);
            this.mDescriptionEt.requestFocus();
            this.iv_emoji.setImageResource(R.drawable.chat_bottom_face);
            showSoftInput(inputMethodManager);
            return;
        }
        window.setSoftInputMode(35);
        this.mExpressionPagerView.setVisibility(0);
        this.iv_emoji.setImageResource(R.drawable.chat_bottom_keyboard);
        hideSoftInput();
    }

    private void onUploadComplete(String str) {
        a.C0454a c0454a = this.mProgressDialog;
        if (c0454a != null) {
            c0454a.a();
        }
        if (this.mInspireTask != null) {
            Intent intent = new Intent(getActivity(), TaskDetailActivity.class);
            intent.setFlags(603979776);
            intent.putExtra("task_id", this.mInspireTask.taskId);
            intent.putExtra("key_from_page", "发布");
            getActivity().startActivity(intent);
            Intent intent2 = new Intent();
            if (str == null) {
                str = "";
            }
            intent2.putExtra("client_id", str);
            getActivity().setResult(-1, intent2);
            getActivity().finish();
            return;
        }
        getActivity().startActivity(new Intent(getContext(), FollowActivity.class));
        Intent intent3 = new Intent();
        if (str == null) {
            str = "";
        }
        intent3.putExtra("client_id", str);
        getActivity().setResult(-1, intent3);
        getActivity().finish();
    }

    private void onUploadStart() {
        this.mPublishBtn.setEnabled(false);
        if (this.mProgressDialog == null) {
            a.C0454a b = us.pinguo.ui.b.a.b(getActivity(), getActivity().getString(R.string.posting));
            this.mProgressDialog = b;
            b.c(false);
        }
        this.mProgressDialog.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: publish */
    public void v0() {
        onUploadStart();
        addSubscription(new InspirePublishTask().publishAsync(createPublishData()).subscribe(new Action1() { // from class: us.pinguo.inspire.module.publish.m
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspirePublishFragment.this.z0((PublishData) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.publish.n
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InspirePublishFragment.this.x0((Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void r0(int i2, Intent intent) {
        if (i2 == -1) {
            this.isLaunchFirstTime = false;
            String stringExtra = intent.getStringExtra("photo_path");
            this.mFilePathes.clear();
            if (stringExtra != null) {
                this.mFilePathes.add(stringExtra);
            }
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            resultFromTaskPhoto(stringExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshSelectFriends(ArrayList<InspireAttention> arrayList) {
        if (arrayList != null) {
            Iterator<InspireAttention> it = arrayList.iterator();
            while (it.hasNext()) {
                InspireAttention next = it.next();
                if (!this.mAttentons.contains(next)) {
                    this.mAttentons.add(next);
                }
            }
            Iterator<InspireAttention> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                InspireAttention next2 = it2.next();
                String str = next2.nickname;
                if (str != null) {
                    us.pinguo.inspire.widget.j.b.a(next2.userId, str, this.mDescriptionEt, Color.parseColor("#6696CC"), null);
                }
            }
        }
    }

    private void registerFinishBroadcast() {
        this.isLaunchFirstTime = true;
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(getActivity());
        this.mLocalBroadcastManager = localBroadcastManager;
        localBroadcastManager.registerReceiver(this.mFinishReceiver, new IntentFilter("us.pinguo.inspire.finish_publish"));
    }

    private boolean resultFromCamera(String str) {
        if (str == null || !new File(str).exists()) {
            return false;
        }
        this.isLaunchFirstTime = false;
        this.mFilePathes.add(str);
        notifyPhotoChanged();
        return true;
    }

    private void resultFromSVideo(String str, String str2, ImageView imageView) {
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap decodeFile = !TextUtils.isEmpty(str2) ? BitmapFactory.decodeFile(str2) : null;
        if (decodeFile == null) {
            int i2 = this.mScreenWidth;
            Bitmap a = us.pinguo.foundation.utils.q0.a(str, i2 / 2, i2 / 2);
            if (a != null) {
                imageView.setImageBitmap(a);
                return;
            }
            return;
        }
        imageView.setImageBitmap(decodeFile);
    }

    private void resultFromSelectVideo(String str) {
        this.mVideoType = 1;
        this.mFilePathes.clear();
        this.mFilePathes.add(str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mVideoCoverContainerView.setVisibility(0);
        this.mAddMoreView.setVisibility(0);
        resultFromSVideo(str, null, this.mVideoCoverPiv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resultFromTaskPhoto(String str) {
        this.isPhotoPublish = true;
        this.isLaunchFirstTime = false;
        this.mFilePathes.clear();
        this.mFilePathes.add(str);
        this.mVideoCoverContainerView.setVisibility(0);
        this.mVideoCoverContainerView.findViewById(R.id.iv_play_video_inspire_publish).setVisibility(8);
        this.mVideoCoverContainerView.findViewById(R.id.iv_close_res_0x7d06012c).setVisibility(8);
        this.mPhotoContainerLl.setVisibility(8);
        this.mAddMoreView.setVisibility(8);
        PhotoImageView photoImageView = this.mVideoCoverPiv;
        photoImageView.setImageUri(FILE_HEADER + str);
    }

    private void resultFromVideoCamera(Bundle bundle) {
        String string = bundle.getString(TapjoyConstants.TJC_VIDEO_URL);
        if (TextUtils.isEmpty(string)) {
            string = bundle.getString("key_exist_video_url");
        }
        this.mFilePathes.clear();
        this.mFilePathes.add(string);
        String string2 = bundle.getString("key_first_frame_path");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.mVideoCoverContainerView.setVisibility(0);
        this.mAddMoreView.setVisibility(8);
        resultFromSVideo(string, string2, this.mVideoCoverPiv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void t0(int i2, Intent intent) {
        if (i2 == -1) {
            switchToVideoMode();
            this.isLaunchFirstTime = false;
            resultFromVideoCamera(intent.getExtras());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSoftInput(InputMethodManager inputMethodManager) {
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.mDescriptionEt, 2);
        }
    }

    private void switchToVideoMode() {
        this.isPhotoPublish = false;
        this.mPhotoContainerLl.setVisibility(8);
        this.mVideoCoverContainerView.setVisibility(0);
    }

    private boolean verify() {
        if (checkIsLogin()) {
            if (this.mDescriptionEt.getText().length() > 140) {
                LinearLayout linearLayout = this.root;
                SnackTop.p(linearLayout, linearLayout.getContext().getString(R.string.publish_content_too_long), 0, -218253006).m();
                return false;
            } else if (us.pinguo.foundation.utils.k.a(this.mFilePathes)) {
                us.pinguo.foundation.utils.j0.c(R.string.publish_add_photo);
                return false;
            } else if (us.pinguo.util.q.f(Inspire.a())) {
                return true;
            } else {
                us.pinguo.foundation.utils.j0.c(us.pinguo.ui.R.string.network_not_available);
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public /* synthetic */ void x0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        this.mPublishBtn.setEnabled(true);
        a.C0454a c0454a = this.mProgressDialog;
        if (c0454a != null) {
            c0454a.a();
        }
        if (th instanceof UserBannedException) {
            us.pinguo.foundation.utils.j0.d(th.getMessage());
        } else {
            Toast.makeText(getActivity(), us.pinguo.c360.i18n.R.string.network_error, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public /* synthetic */ void z0(PublishData publishData) {
        new InspirePublishTask().pickAndPublish();
        onUploadComplete(publishData.clientId);
    }

    public Uri generateFile(String str) {
        File file = new File(this.mPhotoPath);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        return Uri.fromFile(file);
    }

    public Uri generatePhotoFile() {
        String str = getActivity().getExternalCacheDir() + "/inspire/IMG_" + UUIDUtils.generateUUID() + ".jpg";
        this.mPhotoPath = str;
        return generateFile(str);
    }

    public Uri generateVideoFile() {
        String str = getActivity().getExternalCacheDir() + "/inspire/VIDEO_" + UUIDUtils.generateUUID() + ".mp4";
        this.mPhotoPath = str;
        return generateFile(str);
    }

    @Override // us.pinguo.foundation.base.BaseFragment
    protected String getPageId() {
        return "enter_publish_page";
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_emoji) {
            onFaceBtnClick();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        us.pinguo.common.log.a.c("lxf", "InspirePublishFragment, onCreateView");
        getActivity().getWindow().setSoftInputMode(18);
        return layoutInflater.inflate(R.layout.inspire_publish_fragment, (ViewGroup) null);
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager localBroadcastManager = this.mLocalBroadcastManager;
        if (localBroadcastManager != null) {
            localBroadcastManager.unregisterReceiver(this.mFinishReceiver);
        }
    }

    @Override // us.pinguo.foundation.base.SubscriptionFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        us.pinguo.librouter.b.b.b().getInterface().b();
    }

    @Override // com.rockerhieu.emoji.KeyboardLayout.b
    public void onKeyBoardStateChange(int i2) {
        this.mKeyboardState = i2;
        if (i2 == -1) {
            if (this.mExpressionPagerView.getVisibility() == 4) {
                hideExpressionView();
            } else if (this.mExpressionPagerView.getVisibility() == 0 && this.mEditTextClick) {
                hideExpressionView();
                this.mEditTextClick = false;
            }
        }
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getView().setFocusable(true);
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() { // from class: us.pinguo.inspire.module.publish.InspirePublishFragment.3
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i2 == 4) {
                    us.pinguo.common.log.a.m("chenxiaokai", "onback", new Object[0]);
                    InspirePublishFragment.this.getView().setFocusable(true);
                    InspirePublishFragment.this.getView().setFocusableInTouchMode(true);
                    InspirePublishFragment.this.getView().requestFocus();
                    InspirePublishFragment.this.iv_emoji.setImageResource(R.drawable.chat_bottom_face);
                    if (InspirePublishFragment.this.mExpressionPagerView.getVisibility() == 0) {
                        InspirePublishFragment.this.mExpressionPagerView.setVisibility(8);
                        return true;
                    }
                }
                return false;
            }
        });
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        Bundle safeArguments = getSafeArguments();
        if (safeArguments != null) {
            this.pictureParam = safeArguments.getString("PUBLISH_EXTRA_PICTURE_PARAMS");
        }
        InspireTask inspireTask = (InspireTask) getSafeArguments().getParcelable("task");
        this.mInspireTask = inspireTask;
        if ((inspireTask == null || TextUtils.isEmpty(inspireTask.taskId)) && !TextUtils.isEmpty(sTaskId)) {
            InspireTask inspireTask2 = new InspireTask();
            this.mInspireTask = inspireTask2;
            inspireTask2.taskId = sTaskId;
            sTaskId = null;
        }
        initViews(view);
        InspireTask inspireTask3 = this.mInspireTask;
        if (inspireTask3 != null && !TextUtils.isEmpty(inspireTask3.taskId)) {
            this.mVideoCoverContainerView.findViewById(R.id.iv_close_res_0x7d06012c).setVisibility(8);
        }
        registerFinishBroadcast();
        initBundleAction();
        checkToShowGuide();
    }

    private void launchVideoCamera(String str, String str2) {
        Uri generateVideoFile = generateVideoFile();
        Intent intent = new Intent();
        intent.setAction("com.camera360.inspire_IMAGE_CAPTURE");
        intent.putExtra("key_no_watermark", true);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            intent.putExtra("bundle_key_filter", str);
            intent.putExtra("bundle_key_package", str2);
        }
        intent.putExtra("camera_type", 2);
        intent.putExtra("output", generateVideoFile);
        startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.publish.l
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i2, Intent intent2) {
                InspirePublishFragment.this.t0(i2, intent2);
            }
        });
    }

    private void resultFromVideoCamera(String str, String str2) {
        this.mFilePathes.clear();
        this.mFilePathes.add(str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mVideoCoverContainerView.setVisibility(0);
        this.mAddMoreView.setVisibility(8);
        resultFromSVideo(str, str2, this.mVideoCoverPiv);
    }
}
