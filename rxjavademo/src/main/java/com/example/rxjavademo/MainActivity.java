package com.example.rxjavademo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.AsyncSubscription;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.CompletableSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.Subject;
import io.reactivex.rxjava3.subjects.UnicastSubject;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "zyzyzy";
    private Observer<String> mObserver;
    private Observable mObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRxJava();
        initSubject();
    }

    private void initSubject() {
        /**
         * subject 看文章说把 是能当观察者Observer 也能当被观察者Observable
         */
        Subject<String> subject = new Subject<String>() {
            @Override
            public boolean hasObservers() {
                return false;
            }

            @Override
            public boolean hasThrowable() {
                return false;
            }

            @Override
            public boolean hasComplete() {
                return false;
            }

            @Override
            public @Nullable Throwable getThrowable() {
                return null;
            }

            @Override
            protected void subscribeActual(@NonNull Observer observer) {
                Log.d(TAG, "Subject subscribeActual");
            }

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "Subject 被订阅了！！");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "Subject onNext：" + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "Subject onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Subject事件队列完结");
            }
        };

        /**
         * 这个是只会把订阅以后的数据发送给观察者
         */
        PublishSubject<String> publishSubject = PublishSubject.create();
//        publishSubject.subscribe(subject);
        publishSubject.onNext("publishSubject 111111");
        publishSubject.onNext("publishSubject 222222");
        publishSubject.onNext("publishSubject 333333");
        publishSubject.onNext("publishSubject 444444");
        publishSubject.onNext("publishSubject 555555");
        publishSubject.onNext("publishSubject 666666");
        publishSubject.onComplete();

        /**
         * 这个是只会发送订阅前一条和后面的所有数据
         * 如果是前面没数据  看log就没前一条 直接发后面的
         * 如果是最后一个 就只会发送前一条数据
         */
        BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();
        behaviorSubject.onNext("behaviorSubject 111111");
        behaviorSubject.onNext("behaviorSubject 222222");
        behaviorSubject.onNext("behaviorSubject 333333");
        behaviorSubject.onNext("behaviorSubject 444444");
//        behaviorSubject.subscribe(subject);
        behaviorSubject.onNext("behaviorSubject 555555");
        behaviorSubject.onNext("behaviorSubject 666666");
        behaviorSubject.onComplete();

        /**
         * 这个看log就是完完整整发送数据
         */
        ReplaySubject<String> replaySubject = ReplaySubject.create();
        replaySubject.onNext("ReplaySubject 111111");
        replaySubject.onNext("ReplaySubject 222222");
        replaySubject.onNext("ReplaySubject 333333");
        replaySubject.onNext("ReplaySubject 444444");
        replaySubject.onNext("ReplaySubject 555555");
        replaySubject.onNext("ReplaySubject 666666");
        replaySubject.onComplete();
//        replaySubject.subscribe(subject);

        /**
         * 这个就只会发送最后一条数据
         */
        AsyncSubject<String> asyncSubject = AsyncSubject.create();
        asyncSubject.onNext("AsyncSubject 111111");
        asyncSubject.onNext("AsyncSubject 222222");
        asyncSubject.onNext("AsyncSubject 333333");
        asyncSubject.onNext("AsyncSubject 444444");
        asyncSubject.onNext("AsyncSubject 555555");
        asyncSubject.onNext("AsyncSubject 666666");
        asyncSubject.onComplete();
//        asyncSubject.subscribe(subject);

        /**
         * 这个只允许订阅一个观察者 代码写了发现只有第一个观察者会接受到信息 第二个会触发error
         */
        UnicastSubject<String> unicastSubject = UnicastSubject.create();
        unicastSubject.onNext("unicastSubject 111111");
        unicastSubject.onNext("unicastSubject 222222");
        unicastSubject.onNext("unicastSubject 333333");
        unicastSubject.onNext("unicastSubject 444444");
        unicastSubject.onNext("unicastSubject 555555");
        unicastSubject.onNext("unicastSubject 666666");
        unicastSubject.onComplete();
        unicastSubject.subscribe(subject);

        /**
         * 这个是只能发送onComplete
         */
        CompletableSubject completableSubject = CompletableSubject.create();
        completableSubject.onComplete();


        /**
         * 用Observer订阅Subject
         */
//        replaySubject.subscribe(mObserver);
        /**
         * 用subject订阅一个Observable
         */
//        mObservable.subscribe(subject);
//        subject.subscribe(mObserver);
    }

    private void initRxJava() {

        /**
         * 观察者对象
         */
        mObserver = new Observer<String>() {

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                //当订阅的时候会被调用
                Log.d(TAG, "被订阅了！！");
            }

            @Override
            public void onNext(@NonNull String s) {
                // 普通的事件 将要处理的时间添加到事件队列中
                Log.d(TAG, "onNext：" + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                //事件队列异常 队列自动终止 不允许再有事件发出
                Log.d(TAG, "onError");
            }

            @Override
            public void onComplete() {
                //事件队列完结 不会再有onNext发出
                Log.d(TAG, "事件队列完结");
            }

        };


        /**
         * 创建被观察者并添加事件到任务队列
         */

        mObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                /**
                 * 添加事件方式一
                 */
                emitter.onNext("111111");
                emitter.onNext("222222");
                emitter.onNext("333333");
                emitter.onNext("444444");
                emitter.onNext("555555");
                emitter.onComplete();
            }
        });
        /**
         * 添加事件方式二
         * 这种方式跟上面一样
         * 最后会自动调用emitter.onComplete()
         */
        Observable observable1 = Observable.just("111111","222222","333333","444444","555555");

        /**
         * 订阅
         */
//        observable.subscribe(observer);
//        observable1.subscribe(observer);

    }
}