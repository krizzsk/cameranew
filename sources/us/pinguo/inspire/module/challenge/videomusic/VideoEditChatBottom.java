package us.pinguo.inspire.module.challenge.videomusic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.rockerhieu.emoji.FaceView;
import com.rockerhieu.emoji.model.EmoticonPkg;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import us.pinguo.foundation.base.ActivityRecorder;
import us.pinguo.foundation.base.InspireContentActivity;
import us.pinguo.foundation.base.InspireRedirectActivity;
import us.pinguo.inspire.R;
import us.pinguo.inspire.module.attention.InspireAttention;
import us.pinguo.inspire.module.publish.InspireSelectAttentionListFragment;
import us.pinguo.inspire.widget.SystemErrorEditText;
import us.pinguo.inspire.widget.chat.ChatBottomLayout;
/* compiled from: VideoEditChatBottom.kt */
/* loaded from: classes9.dex */
public final class VideoEditChatBottom extends ChatBottomLayout {
    public Map<Integer, View> _$_findViewCache;
    private final ArrayList<InspireAttention> mAttentons;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditChatBottom(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.mAttentons = new ArrayList<>();
    }

    private final boolean checkIsLogin(Activity activity) {
        if (us.pinguo.user.s0.getInstance().e()) {
            return true;
        }
        us.pinguo.user.s0.getInstance().a(activity, 0, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
        return false;
    }

    private final void onClickSelectFriends(Activity activity, final EditText editText) {
        if (checkIsLogin(activity)) {
            Intent intent = new Intent(activity, InspireContentActivity.class);
            intent.putExtra(InspireContentActivity.FRAGMENT_NAME, InspireSelectAttentionListFragment.class.getName());
            ((InspireRedirectActivity) activity).startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.challenge.videomusic.l0
                @Override // us.pinguo.foundation.proxy.c
                public final void onActivityResult(int i2, Intent intent2) {
                    VideoEditChatBottom.m114onClickSelectFriends$lambda2(VideoEditChatBottom.this, editText, i2, intent2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onClickSelectFriends$lambda-2  reason: not valid java name */
    public static final void m114onClickSelectFriends$lambda2(final VideoEditChatBottom this$0, final EditText editText, int i2, Intent intent) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(editText, "$editText");
        if (i2 != -1 || intent == null) {
            return;
        }
        this$0.refreshSelectFriends(intent.getParcelableArrayListExtra(InspireSelectAttentionListFragment.InspireAttentionList), editText);
        editText.postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.k0
            @Override // java.lang.Runnable
            public final void run() {
                VideoEditChatBottom.m115onClickSelectFriends$lambda2$lambda1(editText, this$0);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onClickSelectFriends$lambda-2$lambda-1  reason: not valid java name */
    public static final void m115onClickSelectFriends$lambda2$lambda1(EditText editText, VideoEditChatBottom this$0) {
        kotlin.jvm.internal.s.h(editText, "$editText");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        this$0.showSoftInput();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onFinishInflate$lambda-0  reason: not valid java name */
    public static final void m116onFinishInflate$lambda0(VideoEditChatBottom this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Activity d2 = ActivityRecorder.getInstance().d();
        kotlin.jvm.internal.s.g(d2, "getInstance().topActivity");
        SystemErrorEditText chat_bottom_edit = (SystemErrorEditText) this$0._$_findCachedViewById(R.id.chat_bottom_edit);
        kotlin.jvm.internal.s.g(chat_bottom_edit, "chat_bottom_edit");
        this$0.onClickSelectFriends(d2, chat_bottom_edit);
    }

    private final void refreshSelectFriends(ArrayList<InspireAttention> arrayList, EditText editText) {
        if (arrayList != null) {
            ArrayList<InspireAttention> arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (!this.mAttentons.contains((InspireAttention) obj)) {
                    arrayList2.add(obj);
                }
            }
            for (InspireAttention inspireAttention : arrayList2) {
                this.mAttentons.add(inspireAttention);
            }
            ArrayList<InspireAttention> arrayList3 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (((InspireAttention) obj2).nickname != null) {
                    arrayList3.add(obj2);
                }
            }
            for (InspireAttention inspireAttention2 : arrayList3) {
                us.pinguo.inspire.widget.j.b.a(inspireAttention2.userId, inspireAttention2.nickname, editText, Color.parseColor("#6696CC"), null);
            }
        }
    }

    private final void setChatBottomColor(boolean z) {
        if (z) {
            FaceView faceView = (FaceView) _$_findCachedViewById(R.id.chat_bottom_face);
            if (faceView != null) {
                faceView.setColorFilter(-1);
            }
            ImageView imageView = (ImageView) _$_findCachedViewById(R.id.chat_bottom_at);
            if (imageView != null) {
                imageView.setColorFilter(-1);
            }
            int i2 = R.id.chat_bottom_edit;
            SystemErrorEditText systemErrorEditText = (SystemErrorEditText) _$_findCachedViewById(i2);
            if (systemErrorEditText != null) {
                systemErrorEditText.setHintTextColor(Color.parseColor("#99FFFFFF"));
            }
            SystemErrorEditText systemErrorEditText2 = (SystemErrorEditText) _$_findCachedViewById(i2);
            if (systemErrorEditText2 != null) {
                systemErrorEditText2.setTextColor(getResources().getColor(us.pinguo.ui.R.color.text_white));
            }
            setBackgroundColor(getResources().getColor(vStudio.Android.Camera360.R.color.info_bottom_bg));
            return;
        }
        FaceView faceView2 = (FaceView) _$_findCachedViewById(R.id.chat_bottom_face);
        if (faceView2 != null) {
            faceView2.setColorFilter((ColorFilter) null);
        }
        ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.chat_bottom_at);
        if (imageView2 != null) {
            imageView2.setColorFilter((ColorFilter) null);
        }
        int i3 = R.id.chat_bottom_edit;
        SystemErrorEditText systemErrorEditText3 = (SystemErrorEditText) _$_findCachedViewById(i3);
        if (systemErrorEditText3 != null) {
            systemErrorEditText3.setHintTextColor(Color.parseColor("#4D000000"));
        }
        SystemErrorEditText systemErrorEditText4 = (SystemErrorEditText) _$_findCachedViewById(i3);
        if (systemErrorEditText4 != null) {
            systemErrorEditText4.setTextColor(getResources().getColor(us.pinguo.ui.R.color.text_deeper));
        }
        setBackgroundColor(-1);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // us.pinguo.inspire.widget.chat.ChatBottomLayout
    protected boolean filterEmoticonPkg(EmoticonPkg emoticonPkg) {
        return !kotlin.jvm.internal.s.c("small", emoticonPkg == null ? null : emoticonPkg.type);
    }

    public final ArrayList<InspireAttention> getAttentions() {
        return this.mAttentons;
    }

    @Override // us.pinguo.inspire.widget.chat.ChatBottomLayout
    protected us.pinguo.inspire.util.v initSoftDetector() {
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        return new us.pinguo.inspire.util.v((Activity) context, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.widget.chat.ChatBottomLayout, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (!isInEditMode()) {
            setChatBottomColor(true);
        }
        ((ImageView) _$_findCachedViewById(R.id.chat_bottom_pic)).setVisibility(8);
        ((ImageView) _$_findCachedViewById(R.id.chat_bottom_at)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.challenge.videomusic.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoEditChatBottom.m116onFinishInflate$lambda0(VideoEditChatBottom.this, view);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditChatBottom(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        this._$_findViewCache = new LinkedHashMap();
        this.mAttentons = new ArrayList<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditChatBottom(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        this._$_findViewCache = new LinkedHashMap();
        this.mAttentons = new ArrayList<>();
    }
}
