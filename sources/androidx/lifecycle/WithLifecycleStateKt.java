package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.q;
import kotlinx.coroutines.z0;
/* compiled from: WithLifecycleState.kt */
/* loaded from: classes.dex */
public final class WithLifecycleStateKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1, androidx.lifecycle.LifecycleObserver] */
    public static final <R> Object suspendWithStateAtLeastUnchecked(final Lifecycle lifecycle, final Lifecycle.State state, boolean z, CoroutineDispatcher coroutineDispatcher, final kotlin.jvm.b.a<? extends R> aVar, Continuation<? super R> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final q qVar = new q(intercepted, 1);
        qVar.x();
        final ?? r1 = new LifecycleEventObserver() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Object m41constructorimpl;
                s.h(source, "source");
                s.h(event, "event");
                if (event == Lifecycle.Event.upTo(Lifecycle.State.this)) {
                    lifecycle.removeObserver(this);
                    Continuation continuation2 = qVar;
                    kotlin.jvm.b.a<R> aVar2 = aVar;
                    try {
                        Result.a aVar3 = Result.Companion;
                        m41constructorimpl = Result.m41constructorimpl(aVar2.invoke());
                    } catch (Throwable th) {
                        Result.a aVar4 = Result.Companion;
                        m41constructorimpl = Result.m41constructorimpl(j.a(th));
                    }
                    continuation2.resumeWith(m41constructorimpl);
                } else if (event == Lifecycle.Event.ON_DESTROY) {
                    lifecycle.removeObserver(this);
                    Continuation continuation3 = qVar;
                    LifecycleDestroyedException lifecycleDestroyedException = new LifecycleDestroyedException();
                    Result.a aVar5 = Result.Companion;
                    continuation3.resumeWith(Result.m41constructorimpl(j.a(lifecycleDestroyedException)));
                }
            }
        };
        if (z) {
            coroutineDispatcher.dispatch(EmptyCoroutineContext.INSTANCE, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1
                @Override // java.lang.Runnable
                public final void run() {
                    Lifecycle.this.addObserver(r1);
                }
            });
        } else {
            lifecycle.addObserver(r1);
        }
        qVar.e(new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(coroutineDispatcher, lifecycle, r1));
        Object u = qVar.u();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (u == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    public static final <R> Object withCreated(Lifecycle lifecycle, kotlin.jvm.b.a<? extends R> aVar, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        g2 z = z0.c().z();
        boolean isDispatchNeeded = z.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), continuation);
    }

    private static final <R> Object withCreated$$forInline(Lifecycle lifecycle, kotlin.jvm.b.a<? extends R> aVar, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        g2 z = z0.c().z();
        r.c(3);
        Continuation continuation2 = null;
        boolean isDispatchNeeded = z.isDispatchNeeded(continuation2.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        WithLifecycleStateKt$withStateAtLeastUnchecked$2 withLifecycleStateKt$withStateAtLeastUnchecked$2 = new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar);
        r.c(0);
        Object suspendWithStateAtLeastUnchecked = suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z, withLifecycleStateKt$withStateAtLeastUnchecked$2, continuation);
        r.c(1);
        return suspendWithStateAtLeastUnchecked;
    }

    public static final <R> Object withResumed(Lifecycle lifecycle, kotlin.jvm.b.a<? extends R> aVar, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        g2 z = z0.c().z();
        boolean isDispatchNeeded = z.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), continuation);
    }

    private static final <R> Object withResumed$$forInline(Lifecycle lifecycle, kotlin.jvm.b.a<? extends R> aVar, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        g2 z = z0.c().z();
        r.c(3);
        Continuation continuation2 = null;
        boolean isDispatchNeeded = z.isDispatchNeeded(continuation2.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        WithLifecycleStateKt$withStateAtLeastUnchecked$2 withLifecycleStateKt$withStateAtLeastUnchecked$2 = new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar);
        r.c(0);
        Object suspendWithStateAtLeastUnchecked = suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z, withLifecycleStateKt$withStateAtLeastUnchecked$2, continuation);
        r.c(1);
        return suspendWithStateAtLeastUnchecked;
    }

    public static final <R> Object withStarted(Lifecycle lifecycle, kotlin.jvm.b.a<? extends R> aVar, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        g2 z = z0.c().z();
        boolean isDispatchNeeded = z.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), continuation);
    }

    private static final <R> Object withStarted$$forInline(Lifecycle lifecycle, kotlin.jvm.b.a<? extends R> aVar, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        g2 z = z0.c().z();
        r.c(3);
        Continuation continuation2 = null;
        boolean isDispatchNeeded = z.isDispatchNeeded(continuation2.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        WithLifecycleStateKt$withStateAtLeastUnchecked$2 withLifecycleStateKt$withStateAtLeastUnchecked$2 = new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar);
        r.c(0);
        Object suspendWithStateAtLeastUnchecked = suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z, withLifecycleStateKt$withStateAtLeastUnchecked$2, continuation);
        r.c(1);
        return suspendWithStateAtLeastUnchecked;
    }

    public static final <R> Object withStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, kotlin.jvm.b.a<? extends R> aVar, Continuation<? super R> continuation) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            g2 z = z0.c().z();
            boolean isDispatchNeeded = z.isDispatchNeeded(continuation.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return aVar.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), continuation);
        }
        throw new IllegalArgumentException(s.q("target state must be CREATED or greater, found ", state).toString());
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle.State state, kotlin.jvm.b.a<? extends R> aVar, Continuation<? super R> continuation) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            g2 z = z0.c().z();
            r.c(3);
            Continuation continuation2 = null;
            boolean isDispatchNeeded = z.isDispatchNeeded(continuation2.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return aVar.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            WithLifecycleStateKt$withStateAtLeastUnchecked$2 withLifecycleStateKt$withStateAtLeastUnchecked$2 = new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar);
            r.c(0);
            Object suspendWithStateAtLeastUnchecked = suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z, withLifecycleStateKt$withStateAtLeastUnchecked$2, continuation);
            r.c(1);
            return suspendWithStateAtLeastUnchecked;
        }
        throw new IllegalArgumentException(s.q("target state must be CREATED or greater, found ", state).toString());
    }

    public static final <R> Object withStateAtLeastUnchecked(Lifecycle lifecycle, Lifecycle.State state, kotlin.jvm.b.a<? extends R> aVar, Continuation<? super R> continuation) {
        g2 z = z0.c().z();
        boolean isDispatchNeeded = z.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), continuation);
    }

    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle.State state, kotlin.jvm.b.a<? extends R> aVar, Continuation<? super R> continuation) {
        g2 z = z0.c().z();
        r.c(3);
        Continuation continuation2 = null;
        boolean isDispatchNeeded = z.isDispatchNeeded(continuation2.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        WithLifecycleStateKt$withStateAtLeastUnchecked$2 withLifecycleStateKt$withStateAtLeastUnchecked$2 = new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar);
        r.c(0);
        Object suspendWithStateAtLeastUnchecked = suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z, withLifecycleStateKt$withStateAtLeastUnchecked$2, continuation);
        r.c(1);
        return suspendWithStateAtLeastUnchecked;
    }

    public static final <R> Object withCreated(LifecycleOwner lifecycleOwner, kotlin.jvm.b.a<? extends R> aVar, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        s.g(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.CREATED;
        g2 z = z0.c().z();
        boolean isDispatchNeeded = z.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), continuation);
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner lifecycleOwner, kotlin.jvm.b.a<? extends R> aVar, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        s.g(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.CREATED;
        g2 z = z0.c().z();
        r.c(3);
        Continuation continuation2 = null;
        boolean isDispatchNeeded = z.isDispatchNeeded(continuation2.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        WithLifecycleStateKt$withStateAtLeastUnchecked$2 withLifecycleStateKt$withStateAtLeastUnchecked$2 = new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar);
        r.c(0);
        Object suspendWithStateAtLeastUnchecked = suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z, withLifecycleStateKt$withStateAtLeastUnchecked$2, continuation);
        r.c(1);
        return suspendWithStateAtLeastUnchecked;
    }

    public static final <R> Object withResumed(LifecycleOwner lifecycleOwner, kotlin.jvm.b.a<? extends R> aVar, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        s.g(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.RESUMED;
        g2 z = z0.c().z();
        boolean isDispatchNeeded = z.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), continuation);
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner lifecycleOwner, kotlin.jvm.b.a<? extends R> aVar, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        s.g(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.RESUMED;
        g2 z = z0.c().z();
        r.c(3);
        Continuation continuation2 = null;
        boolean isDispatchNeeded = z.isDispatchNeeded(continuation2.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        WithLifecycleStateKt$withStateAtLeastUnchecked$2 withLifecycleStateKt$withStateAtLeastUnchecked$2 = new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar);
        r.c(0);
        Object suspendWithStateAtLeastUnchecked = suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z, withLifecycleStateKt$withStateAtLeastUnchecked$2, continuation);
        r.c(1);
        return suspendWithStateAtLeastUnchecked;
    }

    public static final <R> Object withStarted(LifecycleOwner lifecycleOwner, kotlin.jvm.b.a<? extends R> aVar, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        s.g(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.STARTED;
        g2 z = z0.c().z();
        boolean isDispatchNeeded = z.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), continuation);
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner lifecycleOwner, kotlin.jvm.b.a<? extends R> aVar, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        s.g(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.STARTED;
        g2 z = z0.c().z();
        r.c(3);
        Continuation continuation2 = null;
        boolean isDispatchNeeded = z.isDispatchNeeded(continuation2.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        WithLifecycleStateKt$withStateAtLeastUnchecked$2 withLifecycleStateKt$withStateAtLeastUnchecked$2 = new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar);
        r.c(0);
        Object suspendWithStateAtLeastUnchecked = suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z, withLifecycleStateKt$withStateAtLeastUnchecked$2, continuation);
        r.c(1);
        return suspendWithStateAtLeastUnchecked;
    }

    public static final <R> Object withStateAtLeast(LifecycleOwner lifecycleOwner, Lifecycle.State state, kotlin.jvm.b.a<? extends R> aVar, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        s.g(lifecycle, "lifecycle");
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            g2 z = z0.c().z();
            boolean isDispatchNeeded = z.isDispatchNeeded(continuation.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return aVar.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), continuation);
        }
        throw new IllegalArgumentException(s.q("target state must be CREATED or greater, found ", state).toString());
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle.State state, kotlin.jvm.b.a<? extends R> aVar, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        s.g(lifecycle, "lifecycle");
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            g2 z = z0.c().z();
            r.c(3);
            Continuation continuation2 = null;
            boolean isDispatchNeeded = z.isDispatchNeeded(continuation2.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return aVar.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            WithLifecycleStateKt$withStateAtLeastUnchecked$2 withLifecycleStateKt$withStateAtLeastUnchecked$2 = new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar);
            r.c(0);
            Object suspendWithStateAtLeastUnchecked = suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, z, withLifecycleStateKt$withStateAtLeastUnchecked$2, continuation);
            r.c(1);
            return suspendWithStateAtLeastUnchecked;
        }
        throw new IllegalArgumentException(s.q("target state must be CREATED or greater, found ", state).toString());
    }
}
