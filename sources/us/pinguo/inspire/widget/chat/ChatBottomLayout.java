package us.pinguo.inspire.widget.chat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.c;
import com.rockerhieu.emoji.FaceView;
import com.rockerhieu.emoji.KeyboardLayout;
import com.rockerhieu.emoji.expression.ExpressionPagerView;
import com.rockerhieu.emoji.expression.FaceSize;
import com.rockerhieu.emoji.model.DelEmoticon;
import com.rockerhieu.emoji.model.Emoticon;
import com.rockerhieu.emoji.model.EmoticonPkg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.foundation.base.ActivityRecorder;
import us.pinguo.foundation.base.InspireContentActivity;
import us.pinguo.foundation.base.InspireRedirectActivity;
import us.pinguo.foundation.statistics.PageStack;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.statistics.l;
import us.pinguo.foundation.utils.j0;
import us.pinguo.inspire.module.attention.InspireAttention;
import us.pinguo.inspire.module.comment.InspireComment;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.inspire.module.publish.InspireSelectAttentionListFragment;
import us.pinguo.inspire.util.emoticon.EmoticonManager;
import us.pinguo.inspire.util.emoticon.g;
import us.pinguo.inspire.util.emoticon.i;
import us.pinguo.inspire.util.v;
import us.pinguo.inspire.widget.chat.ChatPicLayout;
import us.pinguo.user.s0;
import us.pinguo.user.util.n;
import us.pinguo.util.q;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class ChatBottomLayout extends LinearLayout implements View.OnClickListener, KeyboardLayout.b, KeyboardLayout.a, com.rockerhieu.emoji.expression.d, ChatPicLayout.c {
    private static final int COMMENT_LENGTH_LIMIT = 140;
    private ImageView mAtBtn;
    private List<InspireAttention> mAtMembers;
    private ChatPic2Layout mChatPicLayout;
    private EditText mEditText;
    private boolean mEditTextClick;
    protected ExpressionPagerView mExpressionPagerView;
    private FaceView mFaceView;
    private e mGetWorkIdPresenter;
    private InputMethodManager mImm;
    private int mKeyboardState;
    private f mOnSendClickListener;
    private ImageView mPicBtn;
    private InspireComment mReplyComment;
    private View mSendBtn;
    private Window mWindow;
    static final Integer HINT_TAG_REPLY = 1;
    static final Integer HINT_TAG_INPUT = 2;

    /* loaded from: classes9.dex */
    class a extends com.rockerhieu.emoji.b {
        a() {
        }

        @Override // com.rockerhieu.emoji.b, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence == null || charSequence.length() <= 0) {
                if (ChatBottomLayout.this.mChatPicLayout.i()) {
                    ChatBottomLayout.this.mSendBtn.setEnabled(true);
                    return;
                } else {
                    ChatBottomLayout.this.mSendBtn.setEnabled(false);
                    return;
                }
            }
            ChatBottomLayout.this.mSendBtn.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b implements v.b {
        final /* synthetic */ v a;
        final /* synthetic */ int b;

        b(v vVar, int i2) {
            this.a = vVar;
            this.b = i2;
        }

        @Override // us.pinguo.inspire.util.v.b
        public void onKeyboardChange(boolean z) {
            if (z) {
                int f2 = this.a.f();
                int i2 = this.b;
                if (f2 > i2) {
                    f2 = i2;
                }
                if (f2 > 0) {
                    ViewGroup.LayoutParams layoutParams = ChatBottomLayout.this.mExpressionPagerView.getLayoutParams();
                    layoutParams.height = f2;
                    ChatBottomLayout.this.mExpressionPagerView.setLayoutParams(layoutParams);
                }
                this.a.i(null);
                if (ChatBottomLayout.this.getViewTreeObserver() != null) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        ChatBottomLayout.this.getViewTreeObserver().removeOnGlobalLayoutListener(this.a);
                    } else {
                        ChatBottomLayout.this.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class c implements us.pinguo.foundation.proxy.c {
        final /* synthetic */ EditText a;

        c(EditText editText) {
            this.a = editText;
        }

        @Override // us.pinguo.foundation.proxy.c
        public void onActivityResult(int i2, Intent intent) {
            ArrayList parcelableArrayListExtra;
            if (i2 != -1 || intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra(InspireSelectAttentionListFragment.InspireAttentionList)) == null || parcelableArrayListExtra.size() == 0) {
                return;
            }
            Iterator it = parcelableArrayListExtra.iterator();
            while (it.hasNext()) {
                InspireAttention inspireAttention = (InspireAttention) it.next();
                if (!ChatBottomLayout.this.mAtMembers.contains(inspireAttention)) {
                    ChatBottomLayout.this.mAtMembers.add(inspireAttention);
                }
                us.pinguo.inspire.widget.j.b.b(inspireAttention.userId, inspireAttention.nickname, this.a, null);
            }
            ChatBottomLayout.this.showSoftInputAfterResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ChatBottomLayout.this.mExpressionPagerView.getVisibility() == 0) {
                ChatBottomLayout.this.onFaceBtnClick();
                return;
            }
            ChatBottomLayout.this.mEditText.requestFocus();
            ChatBottomLayout.this.showSoftInput();
        }
    }

    /* loaded from: classes9.dex */
    public interface e {
        String a();
    }

    /* loaded from: classes9.dex */
    public interface f {
        void onSendClick(String str, List<InspireAttention> list, InspireComment inspireComment, String[] strArr, Emoticon emoticon);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class g implements g.c<EmoticonPkg> {
        private WeakReference<DownloadButton> a;
        private WeakReference<ExpressionPagerView> b;

        public g(DownloadButton downloadButton, ExpressionPagerView expressionPagerView) {
            this.a = new WeakReference<>(downloadButton);
            this.b = new WeakReference<>(expressionPagerView);
        }

        @Override // us.pinguo.inspire.util.emoticon.g.c
        /* renamed from: b */
        public void a(int i2, float f2, EmoticonPkg emoticonPkg) {
            FaceSize f3;
            WeakReference<DownloadButton> weakReference = this.a;
            DownloadButton downloadButton = weakReference == null ? null : weakReference.get();
            if (downloadButton == null) {
                return;
            }
            if (i2 == 0) {
                downloadButton.setEnabled(false);
                downloadButton.setText(R.string.emoticon_downloading);
                downloadButton.setRate(0.0f);
            } else if (i2 == 1) {
                downloadButton.setEnabled(false);
                downloadButton.setText(R.string.emoticon_downloading);
                downloadButton.setRate(f2);
            } else if (i2 == 2) {
                downloadButton.setEnabled(false);
                downloadButton.setText(R.string.emoticon_downloading);
                downloadButton.setRate(1.0f);
            } else if (i2 != 3) {
                if (i2 != 4) {
                    return;
                }
                downloadButton.setEnabled(true);
                downloadButton.setText(R.string.emoticon_download);
                downloadButton.setRate(0.0f);
                j0.c(R.string.load_error);
            } else {
                downloadButton.setEnabled(false);
                downloadButton.setText(R.string.emoticon_downloading);
                downloadButton.setRate(1.0f);
                WeakReference<ExpressionPagerView> weakReference2 = this.b;
                ExpressionPagerView expressionPagerView = weakReference2 != null ? weakReference2.get() : null;
                if (expressionPagerView == null || emoticonPkg == null) {
                    return;
                }
                boolean equals = "small".equals(emoticonPkg.type);
                if (equals) {
                    f3 = FaceSize.g(expressionPagerView.getResources());
                } else {
                    f3 = FaceSize.f(expressionPagerView.getResources());
                }
                expressionPagerView.k(emoticonPkg, equals ? R.drawable.expression_delete : 0, f3);
            }
        }
    }

    public ChatBottomLayout(Context context) {
        super(context);
        this.mEditTextClick = false;
        this.mKeyboardState = -2;
        this.mAtMembers = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(View view) {
        l.onEvent(view.getContext(), "comment_submit_click", getSecondParam());
        onSendClick();
    }

    private String getSecondParam() {
        e eVar = this.mGetWorkIdPresenter;
        String a2 = eVar == null ? null : eVar.a();
        if (TextUtils.isEmpty(a2)) {
            a2 = IADStatisticBase.VARCHAR_DEFALUT_VALUE;
        }
        return "feed_id=" + a2 + ",src=" + PageStack.getInstance().e();
    }

    private void hideExpressionView() {
        this.mExpressionPagerView.setVisibility(8);
        if (this.mWindow.getAttributes().softInputMode != 19) {
            this.mWindow.setSoftInputMode(19);
        }
        this.mFaceView.setFace(true);
    }

    private void initEmoticonPkgs() {
        this.mExpressionPagerView.setOnEmoticonClickListener(this);
        List<EmoticonPkg> h2 = EmoticonManager.getInstance().h();
        Collections.sort(h2);
        for (EmoticonPkg emoticonPkg : h2) {
            if (!filterEmoticonPkg(emoticonPkg)) {
                if (emoticonPkg.isOnline != 0) {
                    this.mExpressionPagerView.e(emoticonPkg, initOnlineEmoticonView(emoticonPkg));
                } else if ("small".equals(emoticonPkg.type)) {
                    this.mExpressionPagerView.f(emoticonPkg, R.drawable.expression_delete, FaceSize.g(getResources()));
                } else {
                    this.mExpressionPagerView.f(emoticonPkg, 0, FaceSize.f(getResources()));
                }
            }
        }
    }

    private View initOnlineEmoticonView(EmoticonPkg emoticonPkg) {
        String str;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.emoticon_online_layout, (ViewGroup) this.mExpressionPagerView, false);
        DownloadButton downloadButton = (DownloadButton) inflate.findViewById(R.id.emoticon_online_download);
        TextView textView = (TextView) inflate.findViewById(R.id.emoticon_online_name);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.emoticon_online_img);
        downloadButton.setTag(emoticonPkg);
        String name = emoticonPkg.getName();
        if (name == null) {
            name = "";
        }
        textView.setText(name);
        g.b k2 = us.pinguo.inspire.util.emoticon.g.k(emoticonPkg);
        c.b bVar = new c.b();
        bVar.A(ImageScaleType.EXACTLY);
        bVar.u(true);
        bVar.J(new ColorDrawable(getResources().getColor(us.pinguo.ui.R.color.inspire_loading_color)));
        bVar.D(true);
        com.nostra13.universalimageloader.core.c t = bVar.t();
        if (TextUtils.isEmpty(emoticonPkg.cover)) {
            str = emoticonPkg.coverUrl;
        } else {
            str = InspirePublishFragment.FILE_HEADER + emoticonPkg.cover;
        }
        ImageLoader.getInstance().f(str, imageView, t);
        if (k2 != null && k2.d()) {
            downloadButton.setText(R.string.emoticon_downloading);
            downloadButton.setRate(k2.c());
            k2.g(new g(downloadButton, this.mExpressionPagerView));
        } else {
            downloadButton.setOnClickListener(this);
        }
        return inflate;
    }

    private void launchAtList(EditText editText) {
        Intent intent = new Intent(getContext(), InspireContentActivity.class);
        intent.putExtra(InspireContentActivity.FRAGMENT_NAME, InspireSelectAttentionListFragment.class.getName());
        ((InspireRedirectActivity) getContext()).startActivityForResult(intent, new c(editText));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFaceBtnClick() {
        if (this.mExpressionPagerView.getVisibility() == 0) {
            this.mWindow.setSoftInputMode(35);
            this.mExpressionPagerView.setVisibility(4);
            this.mEditText.setFocusable(true);
            this.mEditText.setFocusableInTouchMode(true);
            this.mEditText.requestFocus();
            showSoftInput();
        } else {
            this.mWindow.setSoftInputMode(35);
            this.mExpressionPagerView.setVisibility(0);
            hideSoftInput();
        }
        this.mFaceView.b();
    }

    private void onSendClick() {
        e eVar = this.mGetWorkIdPresenter;
        if (eVar != null) {
            h.a.r0("comment_submit", eVar.a(), "click", "1");
        }
        String trim = this.mEditText.getText().toString().trim();
        String[] h2 = this.mChatPicLayout.h();
        Emoticon g2 = this.mChatPicLayout.g();
        if (TextUtils.isEmpty(trim) && ((h2 == null || h2.length == 0) && g2 == null)) {
            j0.d(getContext().getString(R.string.comment_can_not_empty));
            return;
        }
        if (this.mAtMembers.size() > 0) {
            trim = us.pinguo.inspire.widget.j.b.c(this.mAtMembers, this.mEditText);
        }
        String str = trim;
        if (us.pinguo.inspire.widget.j.b.j(str).length() > 140) {
            j0.d(getContext().getString(R.string.comment_content_limit_new));
            return;
        }
        if (this.mKeyboardState == -3) {
            hideSoftInput();
        }
        if (this.mExpressionPagerView.getVisibility() != 8) {
            hideExpressionView();
        }
        f fVar = this.mOnSendClickListener;
        if (fVar != null) {
            fVar.onSendClick(str, new ArrayList(this.mAtMembers), this.mReplyComment, h2, g2);
            this.mChatPicLayout.j();
            this.mAtMembers.clear();
            this.mReplyComment = null;
        }
        clearEditText(this.mEditText);
    }

    void clearEditText(EditText editText) {
        if (!TextUtils.isEmpty(editText.getText())) {
            editText.setText("");
        }
        if (HINT_TAG_REPLY.equals(editText.getTag())) {
            editText.setHint(R.string.input_comment);
            editText.setTag(HINT_TAG_INPUT);
        }
        editText.clearFocus();
    }

    protected boolean filterEmoticonPkg(EmoticonPkg emoticonPkg) {
        return false;
    }

    public ImageView getAtBtn() {
        return this.mAtBtn;
    }

    public EditText getEditText() {
        return this.mEditText;
    }

    public ImageView getPicBtn() {
        return this.mPicBtn;
    }

    public View getSendBtn() {
        return this.mSendBtn;
    }

    public boolean hideSoftInput() {
        InputMethodManager inputMethodManager;
        if (this.mKeyboardState == -2 || (inputMethodManager = this.mImm) == null) {
            return false;
        }
        return inputMethodManager.hideSoftInputFromWindow(this.mEditText.getApplicationWindowToken(), 0);
    }

    protected void initExpression() {
        this.mExpressionPagerView = (ExpressionPagerView) findViewById(R.id.chat_bottom_expression);
        initEmoticonPkgs();
        if (isInEditMode()) {
            return;
        }
        v initSoftDetector = initSoftDetector();
        int f2 = initSoftDetector.f();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.expression_layout_max_height);
        ViewGroup.LayoutParams layoutParams = this.mExpressionPagerView.getLayoutParams();
        if (f2 > 0 && f2 < dimensionPixelSize) {
            layoutParams.height = f2;
            this.mExpressionPagerView.setLayoutParams(layoutParams);
        } else if (f2 > 0 && f2 > dimensionPixelSize) {
            layoutParams.height = dimensionPixelSize;
            this.mExpressionPagerView.setLayoutParams(layoutParams);
        }
        getViewTreeObserver().addOnGlobalLayoutListener(initSoftDetector);
        initSoftDetector.i(new b(initSoftDetector, dimensionPixelSize));
    }

    protected v initSoftDetector() {
        return new v((Activity) getContext(), this);
    }

    public boolean onBackPressed() {
        InputMethodManager inputMethodManager = this.mImm;
        if (inputMethodManager == null || !inputMethodManager.hideSoftInputFromWindow(this.mEditText.getApplicationWindowToken(), 0)) {
            if (this.mExpressionPagerView.getVisibility() == 0) {
                hideExpressionView();
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // us.pinguo.inspire.widget.chat.ChatPicLayout.c
    public void onChatPicChange(boolean z) {
        this.mSendBtn.setEnabled(z || !TextUtils.isEmpty(this.mEditText.getText()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        this.mEditTextClick = false;
        if (view == this.mFaceView) {
            l.onEvent(view.getContext(), "comment_emoji_click", getSecondParam());
            onFaceBtnClick();
        } else if (view == this.mPicBtn) {
            l.onEvent(view.getContext(), "comment_icon_click", getSecondParam());
            hideSoftInput();
            this.mChatPicLayout.s();
        } else if (view == this.mAtBtn) {
            l.onEvent(view.getContext(), "comment_aticon_click", getSecondParam());
            if (!s0.getInstance().e()) {
                h.a.g("", us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, "show");
                s0.getInstance().a((Activity) getContext(), 1, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
                hideSoftInput();
            } else if (!q.f(getContext())) {
                j0.c(us.pinguo.ui.R.string.network_not_available);
            } else {
                launchAtList(this.mEditText);
            }
        } else if (view == this.mSendBtn) {
            Activity activity = (Activity) getContext();
            if (activity != null) {
                n.a.d(activity, new Runnable() { // from class: us.pinguo.inspire.widget.chat.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        ChatBottomLayout.this.b(view);
                    }
                });
            }
        } else if (view == this.mEditText) {
            e eVar = this.mGetWorkIdPresenter;
            if (eVar != null) {
                h.a.C("comment_box", "main_page_focus", eVar.a(), "click", "1");
            }
            if (this.mExpressionPagerView.getVisibility() == 0) {
                this.mFaceView.setFace(true);
                this.mEditTextClick = true;
            }
        } else if ((view instanceof DownloadButton) && (view.getTag() instanceof EmoticonPkg)) {
            if (!q.f(getContext())) {
                j0.c(us.pinguo.c360.i18n.R.string.network_error);
                return;
            }
            DownloadButton downloadButton = (DownloadButton) view;
            downloadButton.setEnabled(false);
            downloadButton.setText(R.string.emoticon_download);
            downloadButton.setRate(0.0f);
            us.pinguo.inspire.util.emoticon.g.a(getContext(), (EmoticonPkg) view.getTag(), new g(downloadButton, this.mExpressionPagerView));
        }
    }

    @Override // com.rockerhieu.emoji.KeyboardLayout.a
    public void onDispatchTouchEvent(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        if (motionEvent.getRawY() > iArr[1]) {
            return;
        }
        if (motionEvent.getAction() == 0 && this.mExpressionPagerView.getVisibility() == 0) {
            hideExpressionView();
        }
        if (this.mKeyboardState == -3) {
            hideSoftInput();
        }
    }

    public void onDownloadClick(EmoticonPkg emoticonPkg) {
    }

    @Override // com.rockerhieu.emoji.expression.d
    public void onEmoticonClick(Emoticon emoticon) {
        boolean z = emoticon instanceof DelEmoticon;
        if (!z && emoticon != null) {
            Context context = getContext();
            l.onEvent(context, "comment_emoji_useage", getSecondParam() + ",emoji_id=" + emoticon.getStatisticsId());
        }
        if (z) {
            if (this.mEditText.getEditableText().toString().length() > 0) {
                this.mEditText.dispatchKeyEvent(new KeyEvent(0, 67));
            }
        } else if (emoticon != null && emoticon.isSmall()) {
            String name = emoticon.getName();
            if (this.mEditText.getText().toString().length() + name.length() > 140) {
                return;
            }
            String obj = this.mEditText.getEditableText().toString();
            int selectionStart = this.mEditText.getSelectionStart();
            int selectionEnd = this.mEditText.getSelectionEnd();
            SpannableString b2 = i.b(this.mEditText, name);
            if (obj.length() == 0 || selectionStart < 0) {
                this.mEditText.append(b2);
            } else if (selectionStart == selectionEnd) {
                this.mEditText.getEditableText().insert(selectionStart, b2);
            } else {
                this.mEditText.getEditableText().replace(selectionStart, selectionEnd, name);
            }
        } else if (emoticon == null || emoticon.isSmall()) {
        } else {
            this.mChatPicLayout.setEmoticon(emoticon);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (!isInEditMode()) {
            if (getContext() instanceof Activity) {
                this.mWindow = ((Activity) getContext()).getWindow();
            } else {
                this.mWindow = ActivityRecorder.getInstance().d().getWindow();
            }
        }
        this.mImm = (InputMethodManager) getContext().getSystemService("input_method");
        setOrientation(1);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.chat_bottom_layout, (ViewGroup) this, true);
        this.mExpressionPagerView = (ExpressionPagerView) inflate.findViewById(R.id.chat_bottom_expression);
        this.mChatPicLayout = (ChatPic2Layout) inflate.findViewById(R.id.chat_bottom_pic_layout);
        this.mEditText = (EditText) inflate.findViewById(R.id.chat_bottom_edit);
        this.mFaceView = (FaceView) inflate.findViewById(R.id.chat_bottom_face);
        this.mSendBtn = inflate.findViewById(R.id.chat_bottom_send);
        this.mPicBtn = (ImageView) inflate.findViewById(R.id.chat_bottom_pic);
        this.mAtBtn = (ImageView) inflate.findViewById(R.id.chat_bottom_at);
        this.mFaceView.setBtnRes(R.drawable.chat_bottom_face, R.drawable.chat_bottom_keyboard);
        this.mEditText.setOnClickListener(this);
        this.mFaceView.setOnClickListener(this);
        this.mPicBtn.setOnClickListener(this);
        this.mAtBtn.setOnClickListener(this);
        this.mSendBtn.setOnClickListener(this);
        this.mSendBtn.setEnabled(false);
        this.mChatPicLayout.setOnChatPicChange(this);
        this.mChatPicLayout.setChatBottomLayout(this);
        if (!isInEditMode()) {
            initExpression();
        }
        this.mEditText.addTextChangedListener(new a());
    }

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

    public void refreshBottomLayout() {
        clearEditText(this.mEditText);
        this.mChatPicLayout.j();
    }

    public void setCommentMode() {
        if (HINT_TAG_REPLY.equals(this.mEditText.getTag())) {
            this.mEditText.setHint(R.string.input_comment);
            this.mEditText.setTag(HINT_TAG_INPUT);
        }
        this.mEditText.clearFocus();
    }

    public void setGetWorkIdPresenter(e eVar) {
        this.mGetWorkIdPresenter = eVar;
    }

    public void setOnSendClickListener(f fVar) {
        this.mOnSendClickListener = fVar;
    }

    public void setReplyMode(InspireComment inspireComment) {
        this.mReplyComment = inspireComment;
        EditText editText = this.mEditText;
        editText.setHint(getResources().getString(R.string.comment_answer) + inspireComment.sender.nickname);
        this.mEditText.setTag(HINT_TAG_REPLY);
        us.pinguo.inspire.util.q.a(getContext(), this.mEditText);
    }

    public void showSoftInput() {
        InputMethodManager inputMethodManager = this.mImm;
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.mEditText, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showSoftInputAfterResume() {
        postDelayed(new d(), 250L);
    }

    public ChatBottomLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEditTextClick = false;
        this.mKeyboardState = -2;
        this.mAtMembers = new ArrayList();
    }

    public ChatBottomLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mEditTextClick = false;
        this.mKeyboardState = -2;
        this.mAtMembers = new ArrayList();
    }
}
