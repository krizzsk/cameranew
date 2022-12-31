package rx.functions;
/* loaded from: classes3.dex */
public final class Actions {
    private static final EmptyAction EMPTY_ACTION = new EmptyAction();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class EmptyAction<T0, T1, T2, T3, T4, T5, T6, T7, T8> implements Action0, Action1<T0>, Action2<T0, T1>, Action3<T0, T1, T2>, Action4<T0, T1, T2, T3>, Action5<T0, T1, T2, T3, T4>, Action6<T0, T1, T2, T3, T4, T5>, Action7<T0, T1, T2, T3, T4, T5, T6>, Action8<T0, T1, T2, T3, T4, T5, T6, T7>, Action9<T0, T1, T2, T3, T4, T5, T6, T7, T8>, ActionN {
        private EmptyAction() {
        }

        @Override // rx.functions.Action0
        public void call() {
        }

        @Override // rx.functions.Action1
        public void call(T0 t0) {
        }

        @Override // rx.functions.Action2
        public void call(T0 t0, T1 t1) {
        }

        @Override // rx.functions.Action3
        public void call(T0 t0, T1 t1, T2 t2) {
        }

        @Override // rx.functions.Action4
        public void call(T0 t0, T1 t1, T2 t2, T3 t3) {
        }

        @Override // rx.functions.Action5
        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4) {
        }

        @Override // rx.functions.Action6
        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        }

        @Override // rx.functions.Action7
        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        }

        @Override // rx.functions.Action8
        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        }

        @Override // rx.functions.Action9
        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        }

        @Override // rx.functions.ActionN
        public void call(Object... objArr) {
        }
    }

    private Actions() {
        throw new IllegalStateException("No instances!");
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> EmptyAction<T0, T1, T2, T3, T4, T5, T6, T7, T8> empty() {
        return EMPTY_ACTION;
    }

    public static Func0<Void> toFunc(Action0 action0) {
        return toFunc(action0, (Object) null);
    }

    public static <T1> Func1<T1, Void> toFunc(Action1<T1> action1) {
        return toFunc(action1, (Object) null);
    }

    public static <T1, T2> Func2<T1, T2, Void> toFunc(Action2<T1, T2> action2) {
        return toFunc(action2, (Object) null);
    }

    public static <T1, T2, T3> Func3<T1, T2, T3, Void> toFunc(Action3<T1, T2, T3> action3) {
        return toFunc(action3, (Object) null);
    }

    public static <T1, T2, T3, T4> Func4<T1, T2, T3, T4, Void> toFunc(Action4<T1, T2, T3, T4> action4) {
        return toFunc(action4, (Object) null);
    }

    public static <T1, T2, T3, T4, T5> Func5<T1, T2, T3, T4, T5, Void> toFunc(Action5<T1, T2, T3, T4, T5> action5) {
        return toFunc(action5, (Object) null);
    }

    public static <T1, T2, T3, T4, T5, T6> Func6<T1, T2, T3, T4, T5, T6, Void> toFunc(Action6<T1, T2, T3, T4, T5, T6> action6) {
        return toFunc(action6, (Object) null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7> Func7<T1, T2, T3, T4, T5, T6, T7, Void> toFunc(Action7<T1, T2, T3, T4, T5, T6, T7> action7) {
        return toFunc(action7, (Object) null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> Func8<T1, T2, T3, T4, T5, T6, T7, T8, Void> toFunc(Action8<T1, T2, T3, T4, T5, T6, T7, T8> action8) {
        return toFunc(action8, (Object) null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Void> toFunc(Action9<T1, T2, T3, T4, T5, T6, T7, T8, T9> action9) {
        return toFunc(action9, (Object) null);
    }

    public static FuncN<Void> toFunc(ActionN actionN) {
        return toFunc(actionN, (Object) null);
    }

    public static <R> Func0<R> toFunc(final Action0 action0, final R r) {
        return new Func0<R>() { // from class: rx.functions.Actions.1
            /* JADX WARN: Type inference failed for: r0v1, types: [R, java.lang.Object] */
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public R call() {
                Action0.this.call();
                return r;
            }
        };
    }

    public static <T1, R> Func1<T1, R> toFunc(final Action1<T1> action1, final R r) {
        return new Func1<T1, R>() { // from class: rx.functions.Actions.2
            /* JADX WARN: Type inference failed for: r2v1, types: [R, java.lang.Object] */
            @Override // rx.functions.Func1
            public R call(T1 t1) {
                Action1.this.call(t1);
                return r;
            }
        };
    }

    public static <T1, T2, R> Func2<T1, T2, R> toFunc(final Action2<T1, T2> action2, final R r) {
        return new Func2<T1, T2, R>() { // from class: rx.functions.Actions.3
            /* JADX WARN: Type inference failed for: r2v1, types: [R, java.lang.Object] */
            @Override // rx.functions.Func2
            public R call(T1 t1, T2 t2) {
                Action2.this.call(t1, t2);
                return r;
            }
        };
    }

    public static <T1, T2, T3, R> Func3<T1, T2, T3, R> toFunc(final Action3<T1, T2, T3> action3, final R r) {
        return new Func3<T1, T2, T3, R>() { // from class: rx.functions.Actions.4
            /* JADX WARN: Type inference failed for: r2v1, types: [R, java.lang.Object] */
            @Override // rx.functions.Func3
            public R call(T1 t1, T2 t2, T3 t3) {
                Action3.this.call(t1, t2, t3);
                return r;
            }
        };
    }

    public static <T1, T2, T3, T4, R> Func4<T1, T2, T3, T4, R> toFunc(final Action4<T1, T2, T3, T4> action4, final R r) {
        return new Func4<T1, T2, T3, T4, R>() { // from class: rx.functions.Actions.5
            /* JADX WARN: Type inference failed for: r2v1, types: [R, java.lang.Object] */
            @Override // rx.functions.Func4
            public R call(T1 t1, T2 t2, T3 t3, T4 t4) {
                Action4.this.call(t1, t2, t3, t4);
                return r;
            }
        };
    }

    public static <T1, T2, T3, T4, T5, R> Func5<T1, T2, T3, T4, T5, R> toFunc(final Action5<T1, T2, T3, T4, T5> action5, final R r) {
        return new Func5<T1, T2, T3, T4, T5, R>() { // from class: rx.functions.Actions.6
            /* JADX WARN: Type inference failed for: r7v1, types: [R, java.lang.Object] */
            @Override // rx.functions.Func5
            public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
                Action5.this.call(t1, t2, t3, t4, t5);
                return r;
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, R> Func6<T1, T2, T3, T4, T5, T6, R> toFunc(final Action6<T1, T2, T3, T4, T5, T6> action6, final R r) {
        return new Func6<T1, T2, T3, T4, T5, T6, R>() { // from class: rx.functions.Actions.7
            /* JADX WARN: Type inference failed for: r8v1, types: [R, java.lang.Object] */
            @Override // rx.functions.Func6
            public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
                Action6.this.call(t1, t2, t3, t4, t5, t6);
                return r;
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Func7<T1, T2, T3, T4, T5, T6, T7, R> toFunc(final Action7<T1, T2, T3, T4, T5, T6, T7> action7, final R r) {
        return new Func7<T1, T2, T3, T4, T5, T6, T7, R>() { // from class: rx.functions.Actions.8
            /* JADX WARN: Type inference failed for: r9v1, types: [R, java.lang.Object] */
            @Override // rx.functions.Func7
            public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
                Action7.this.call(t1, t2, t3, t4, t5, t6, t7);
                return r;
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Func8<T1, T2, T3, T4, T5, T6, T7, T8, R> toFunc(final Action8<T1, T2, T3, T4, T5, T6, T7, T8> action8, final R r) {
        return new Func8<T1, T2, T3, T4, T5, T6, T7, T8, R>() { // from class: rx.functions.Actions.9
            /* JADX WARN: Type inference failed for: r1v1, types: [R, java.lang.Object] */
            @Override // rx.functions.Func8
            public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
                Action8.this.call(t1, t2, t3, t4, t5, t6, t7, t8);
                return r;
            }
        };
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> toFunc(final Action9<T1, T2, T3, T4, T5, T6, T7, T8, T9> action9, final R r) {
        return new Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>() { // from class: rx.functions.Actions.10
            /* JADX WARN: Type inference failed for: r1v1, types: [R, java.lang.Object] */
            @Override // rx.functions.Func9
            public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
                Action9.this.call(t1, t2, t3, t4, t5, t6, t7, t8, t9);
                return r;
            }
        };
    }

    public static <R> FuncN<R> toFunc(final ActionN actionN, final R r) {
        return new FuncN<R>() { // from class: rx.functions.Actions.11
            /* JADX WARN: Type inference failed for: r2v1, types: [R, java.lang.Object] */
            @Override // rx.functions.FuncN
            public R call(Object... objArr) {
                ActionN.this.call(objArr);
                return r;
            }
        };
    }
}
