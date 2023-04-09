package com.example.rxjavademo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.example.rxjavademo.bean.Swordsman;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Function3;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.AsyncSubscription;
import io.reactivex.rxjava3.observables.GroupedObservable;
import io.reactivex.rxjava3.schedulers.Schedulers;
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

//        initRxJava();
//        initSubject();
        initOperator();
    }

    /**
     * 操作符使用
     */
    @SuppressLint("CheckResult")
    private void initOperator() {
//        Consumer<Long> consumer = new Consumer<Long>() {
//            @Override
//            public void accept(Long aLong) throws Throwable {
//                Log.d(TAG, "accept: " + aLong);
//            }
//        };

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(Integer date) {
                Log.d(TAG, "onNext: " + date);
//                Log.d(TAG, "onNext: " + Thread.currentThread().getName());
//                Log.d(TAG, "onNext: " + date.getName() + "  ======  " + date.getLevel());
//                for (Integer integer : date) {
//                    Log.d(TAG, "onNext: " + integer);
//                }
                Log.d(TAG, "--------------------分隔符------------------");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: " + e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: 任务结束");
            }
        };

    /**
     * 1.创建操作符
     */

        /**
         * 创建一个按固定时间间隔发射整数序列的Observable 相当于定时器
         */
//        Observable.interval(3, TimeUnit.SECONDS).subscribe(observer);

        /**
         * 发射一个范围内的有序整数序列 第一个参数是起始值 并且不小于0，第二个参数为终值
         */
//        Observable.range(0,5).subscribe(observer);

        /**
         * repeat()
         * 创建一个N次重复发射特定数据的observable
         */
//        Observable.range(0,5)
//                .repeat(3)
//                .subscribe(observer);

    /**
     * 2.变换操作符
     */

        /**
         * map操作符是通过指定一个Function对象将源Observable转换为一个新的Observable对象并发射
         * 观察者将收到新的Observable对象并处理
         */
//        Observable.just("??").map(new Function<String, String>() {
//            @Override
//            public String apply(String s) throws Throwable {
//                return "NMSL---" + s;
//            }
//        }).subscribe(observer);

        /**
         *flatMap操作符将Observable发射的数据集合变换为Observable集合，然后将这些Observable发射的数据平坦化的放进一个单独的Observable中
         * cast操作符的作用是强制将Observable发射的所有数据转换为指定类型的数据
         */
//        List<String> list = new ArrayList<>();
//        list.add("111111");
//        list.add("222222");
//        list.add("333333");
//        list.add("444444");
//        list.add("555555");
//        Observable.fromIterable(list)
//                .flatMap(new Function<String, ObservableSource<?>>() {
//            @Override
//            public ObservableSource<?> apply(String s) throws Throwable {
//                return Observable.just("nmsl == " + s);
//            }
//        }).cast(String.class).subscribe(observer);
        /**
         * concatMap与flatMap操作一致 但是flatMap会有交叉问题 就是观察者接收到的数据有可能和发送的数据顺序不一致
         * concatMap可以保证顺序与发送顺序一致
         *
         */
//        List<String> list = new ArrayList<>();
//        list.add("111111");
//        list.add("222222");
//        list.add("333333");
//        list.add("444444");
//        list.add("555555");
//        Observable.fromIterable(list)
//                .concatMap(new Function<String, ObservableSource<?>>() {
//            @Override
//            public ObservableSource<?> apply(String s) throws Throwable {
//                return Observable.just("nmsl == " + s);
//            }
//        }).cast(String.class).subscribe(observer);

        /**
         * flatMaplterable 操作符可以将数据包装成Iterable 在Iterable中可以对数据进行处理
         */
//        Observable.just(1, 2, 3).flatMapIterable(new Function<Integer, Iterable<Integer>>() {
//            @Override
//            public Iterable<Integer> apply(Integer integer) throws Throwable {
//                List<Integer> list = new ArrayList<>();
//                list.add(integer + 3);
//                return list;
//            }
//        }).subscribe(observer);

        /**
         * buffer是将Observable变换为一个新的Observable 每次发射一组列表 而不是一个一个发射
         * buffer(3) 意思是缓存容量为3
         */
//        Observable.just(1, 2, 3, 4, 5, 6)
//                .buffer(3)
//                .subscribe(observer);

        /**
         * groupBy用于分组元素 将源Observable转换成一个发射Observable的新的Observable（分组后） 将每一个新的Observable都发射一组指定的数据
         * 这个地方感觉可以把这几个实体类添加到List然后传过去 达到同样效果 但是还不知道怎么搞
         */
        Swordsman s1 = new Swordsman("韦一笑", "A");
        Swordsman s2 = new Swordsman("张三丰", "SSS");
        Swordsman s3 = new Swordsman("周芷若", "S");
        Swordsman s4 = new Swordsman("宋远桥", "S");
        Swordsman s5 = new Swordsman("殷梨亭", "A");
        Swordsman s6 = new Swordsman("张无忌", "SS");
        Swordsman s7 = new Swordsman("鹤笔翁", "S");
        Swordsman s8 = new Swordsman("宋青书", "A");

//        Observable<GroupedObservable<String, Swordsman>> groupedObservableObservable = Observable.just(s1, s2, s3, s4, s5, s6, s7, s8)
//        .groupBy(new Function<Swordsman, String>() {
//            @Override
//            public String apply(Swordsman swordsman) throws Throwable {
//                return swordsman.getLevel();
//            }
//        });
//        Observable.concat(groupedObservableObservable).subscribe(observer);

    /**
     * 3.过滤操作符
     */

        /**
         * filter 操作符会对源Observable产生的结果定义规则进行过滤 满足条件的结果才会交给订阅者
         */
//        Observable.just(1,2,3,4).filter(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) throws Throwable {
//                return integer > 2;
//            }
//        }).subscribe(observer);

        /**
         * 这个不能订阅observer 只能订阅Consumer
         * elementAt 操作符用来返回指定位置的数据
         */
//        Observable.just(1,2,3,4,5,6).elementAt(3).subscribe(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Throwable {
//                Log.d(TAG, "accept: " + integer);
//            }
//        });

        /**
         * distinct操作符可以自动去重
         * 好像只能搞基础数据类型  实体啥的不行
         */
//        Observable.just(1,1,2,2,3,4,3,4).distinct().subscribe(observer);

        /**
         * skip 操作符将源Observable发射的数据过滤掉前N项
         */
//        Observable.just(1,2,3,4,5,6).skip(2).subscribe(observer);

        /**
         * take 操作符是只取前N项
         */
//        Observable.just(1,2,3,4,5,6).take(2).subscribe(observer);

        /**
         * 这个也没办法直接用observer 得用CompletableObserver
         * ignoreElements操作符是只产生onComplete onError
         */
//        Observable.just(1,2,3,4,5,6,7).ignoreElements().subscribe(new CompletableObserver() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "ignoreElements  onComplete: ");
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//        });

        /**
         * 这个操作符有点不太好理解...看描述吧 就是说只会发射设定时间段里的第一条数据
         * 如果下面代码没写Thread.sleep(150); 那log就显示发射了一个0
         * 如果睡眠150 那就是0,2,4,6,8,
         * 如果睡眠200  跟操作符设定的时间段一致  那就是全数据
         * 这个我感觉就是用设定时间来摘取数据 暂时没想到有什么应用场景 可能手机端与后台长连接 需要用吧
         *
         * throttleFirst 操作符会定期发射这个时间段里源Observable发射的第一条数据
         */
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
//                for (int i = 0; i < 10; i++) {
//                    emitter.onNext(i);
//                    Thread.sleep(150);
//                }
//                emitter.onComplete();
//            }
//        }).throttleFirst(200, TimeUnit.MILLISECONDS).subscribe(observer);

        /**
         * 这个跟上面那个差不多......
         * 看描述是说也是通过设定时间来限流 但是每次Observable每次发射一个出来 就会进行计时
         * 如果设定时间结束前  源Observable有数据发出 那这个数据就会丢弃 同时throttleWithTimeout重新计时
         */
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
//                for (int i = 0;i<10;i++){
//                    emitter.onNext(i);
//                    int sleep = 100;
//                    if (i % 3 == 0){
//                        sleep = 300;
//                    }
//                    Thread.sleep(sleep);
//                }
//                emitter.onComplete();
//            }
//        }).throttleWithTimeout(200,TimeUnit.MILLISECONDS).subscribe(observer);


    /**
     * 4.组合操作符
     */

        /**
         * merge操作符将多个Observable合并到一个Observable中发射
         * 把参数前后替换了 打印log数据都是一样的
         */
//        Observable<Integer> obs1 = Observable.just(1,2,3).subscribeOn(Schedulers.io());
//        Observable<Integer> obs2 = Observable.just(4,5,6);
//        Observable.merge(obs2,obs1).subscribe(observer);

        /**
         * concat操作符将多个Observable合并到一个Observable中发射
         * 和merge不同的是 concat是有序的 而且前一个Observable没发射完是不会发射后一个Observable的数据的
         */
//        Observable<Integer> obs1 = Observable.just(1,2,3).subscribeOn(Schedulers.io());
//        Observable<Integer> obs2 = Observable.just(4,5,6);
//        Observable.concat(obs1,obs2).subscribe(observer);

        /**
         * zip操作符将多个Observable合并到一个Observable中根据指定的函数对Observable进行变换操作并发射一个新值
         */
//        Observable<Integer> obs1 = Observable.just(1,2,3);
//        Observable<String> obs2 = Observable.just("c","n","m");
//        Observable.zip(obs1, obs2, new BiFunction<Integer, String, String>() {
//            @Override
//            public String apply(Integer integer, String s) throws Throwable {
//                return integer + s;
//            }
//        }).subscribe(observer);

        /**
         * combineLatest操作符将多个Observable合并到一个Observable并且只作用于最近发射的数据项
         * 看log就是 3 组合下面的每一个字母
         * 如果切换了Observable的传入顺序
         * 就变成了 1 组合最后一个字母
         * 我拙略的理解一下 应该就是用传入第一个的被观察者携带的数据的最后一个参数与后面的被观察者携带的每一个参数
         *
         * 我试了一下三个被观察者 结果就是用前两个Observable携带的最后一个参数 与最后一个被观察者携带的所有参数
         */
//        Observable<Integer> obs1 = Observable.just(1, 2, 3);
//        Observable<String> obs2 = Observable.just("c", "n", "m");
//        Observable<String> obs3 = Observable.just("a", "b", "c");
//        Observable.combineLatest(obs1, obs2, obs3, new Function3<Integer, String, String, String>() {
//            @Override
//            public String apply(Integer integer, String s, String s2) throws Throwable {
//                return integer + s + s2;
//            }
//        }).subscribe(observer);


    /**
     * 5.辅助操作符
     */

        /**
         * delay就是让原始Observable发射之前暂停一段指定的时间段
         */
//        Observable.create(new ObservableOnSubscribe<Long>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Long> emitter) throws Throwable {
//                Long currentTime = System.currentTimeMillis()/1000;
//                emitter.onNext(currentTime);
//            }
//        }).delay(2,TimeUnit.SECONDS).subscribe(observer);


        /**
         * 被观察者监听观察者的具体方法
         */
//        Observable.just(1,2,3,4,5,6,7,8,9,10)
//                .doOnNext(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Throwable {
//                        Log.d(TAG, "监听到执行onNext");
//                    }
//                })
//                .doOnSubscribe(new Consumer<Disposable>() {
//                    @Override
//                    public void accept(Disposable disposable) throws Throwable {
//                        Log.d(TAG, "监听到执行OnSubscribe");
//                    }
//                }).subscribe(observer);


        /**
         * subscribeOn(Schedulers.newThread())表示Observable运行在新开的线程
         * observeOn(AndroidSchedulers.mainThread()) 表示Observable运行在主线程
         */
//        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
//                Log.d(TAG, "subscribe: " + Thread.currentThread().getName());
//                emitter.onNext(1);
//                emitter.onComplete();
//            }
//        });
//        observable.subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);

        /**
         * 如果原始Observable过了指定时间还没有发射数据 就会触发onError
         * 如果参数携带了备用的Observable 则会继续发射备用Observable携带的参数
         */
//        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
//                for (int i = 0;i<10;i++){
//                    Thread.sleep(i * 100);
//                    emitter.onNext(i * 100);
//                }
//                emitter.onComplete();
//            }
//        }).timeout(200,TimeUnit.MILLISECONDS,Observable.just(10,11,12));
//        observable.subscribe(observer);

     /**
      *  6.错误处理操作符
      */

        /**
         * onErrorReturn 返回一个镜像原有Observable行为的新Observable，后者会忽略前者的onError 不会把错误传递给观察者
         * onErrorResumeNext 不会调用onError 发射一个备用的Observable
         */
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
//                for (int i = 0;i<5;i++){
//                    if (i > 2){
//                        emitter.onError(new Throwable("报个错试试"));
//                    }
//                    emitter.onNext(i);
//                }
//                emitter.onComplete();
//            }
//        }).onErrorReturn(new Function<Throwable, Integer>() {
//            @Override
//            public Integer apply(Throwable throwable) throws Throwable {
//                return 10;
//            }
//        })
////                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends Integer>>() {
////                    @Override
////                    public ObservableSource<? extends Integer> apply(Throwable throwable) throws Throwable {
////                        return Observable.just(9,10,11);
////                    }
////                })
//
//                .subscribe(observer);


        /**
         * retry 设置重新订阅次数
         * retryWhen 书上没说咋用 我查了一下  也是返回一个新策略 关于重新订阅相关的
         */
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
//                for (int i = 0;i<5;i++){
//                    if(i == 1){
//                        emitter.onError(new Throwable("搞个错误试试"));
//                    }else {
//                        emitter.onNext(i);
//                    }
//                }
//                emitter.onComplete();
//            }
//        })
////                .retry(2)
//                .retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
//                    @Override
//                    public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Throwable {
//                        return Observable.just(1,2,3,4,5,6);
//                    }
//                })
//                .subscribe(observer);


      /**
       *  7.条件操作符和布尔操作符
       */

        /**
         * 对于给定的两个或者多个Observable 只发射首先发射数据或通知那个Observable的所有数据
         * 就是只发射前面参数 且不耗时直接能发射的
         */
//        Observable.ambArray(Observable.just(1,2,3),Observable.just(4,5,6))
//                .subscribe(observer);


        /**
         * defaultIfEmpty 发射来自原始Observable数据 如果原始Observable没有发射数据 就发射一个默认数据
         */
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
//                emitter.onComplete();
//            }
//        }).defaultIfEmpty(3).subscribe(observer);


        /**
         * all 根据函数对所有数据进行判断
         * 这个好像也没法直接用observer
         */
//        Observable.just(1,2,3,4,5,6,7,8,9,10)
//                .all(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) throws Throwable {
//                        return integer<5;
//                    }
//                }).subscribe(new Consumer<Boolean>() {
//                    @Override
//                    public void accept(Boolean aBoolean) throws Throwable {
//                        Log.d(TAG, "accept: " + aBoolean);
//                    }
//                });

        /**
         * contains 用来判断源Observable是否包含某一个数据
         */
//        Observable.just(1,2,3,4,5,6,7,8,9,10).contains(8).subscribe(new Consumer<Boolean>() {
//            @Override
//            public void accept(Boolean aBoolean) throws Throwable {
//                Log.d(TAG, "accept: " + aBoolean);
//            }
//        });


        /**
         * isEmpty 用来判断源Observable 是否发射过数据
         */
//        Observable.just(1,2,3,4,5,6,7,8,9,10).isEmpty().subscribe(new Consumer<Boolean>() {
//            @Override
//            public void accept(Boolean aBoolean) throws Throwable {
//                Log.d(TAG, "accept: " + aBoolean);
//            }
//        });


     /**
      * 8.转换操作符
      */

        /**
         * 把多个数据的Observable整合为一个list
         */
//        Observable.just(1,2,3,4,5,6,7,8,9,10)
//                .toList()
//                .subscribe(new Consumer<List<Integer>>() {
//                    @Override
//                    public void accept(List<Integer> integers) throws Throwable {
//                        Log.d(TAG, "accept: " + integers.toString());
//                    }
//                });


        /**
         * 跟tolist一样的功能 带了排序功能
         * 看源码是用了Collections.sort
         */
//        Observable.just(3,4,5,8,7,6,2,1,9,10)
//                .toSortedList()
//                .subscribe(new Consumer<List<Integer>>() {
//                    @Override
//                    public void accept(List<Integer> integers) throws Throwable {
//                        Log.d(TAG, "accept: " + integers.toString());
//                    }
//                });


        /**
         * toMap 将原始Observable发射的数据收集到一个map中然后发射，可以设置key
         */
        Observable.just(s1,s2,s3,s4,s5,s6,s7,s8)
                .toMap(new Function<Swordsman, String>() {
                    @Override
                    public String apply(Swordsman swordsman) throws Throwable {
                        //设置map中的key
                        return swordsman.getLevel();
                    }
                }).subscribe(new Consumer<Map<String, Swordsman>>() {
                    @Override
                    public void accept(Map<String, Swordsman> stringSwordsmanMap) throws Throwable {
                        //key就是上面手动设置的
                        Log.d(TAG, "accept: " + stringSwordsmanMap.toString());
                    }
                });

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
        Observable observable1 = Observable.just("111111", "222222", "333333", "444444", "555555");

        /**
         * 订阅
         */
//        observable.subscribe(observer);
//        observable1.subscribe(observer);

    }
}