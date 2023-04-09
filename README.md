# AndroidAdvanced
买了本android进阶之光（第二版）
一点一点跟着把项目写了

## 2023年4月3日 00:02:00
    把之前没怎么细看的rxjava看一看
        今天写了基础的观察者和被观察者的使用
        还有一个Subject 这个说是可以当观察者也可以当被观察者 没有实际使用过 就简单把书上有的写了一下 书上没给代码 自己上网找了点写了一下 看了看效果

        这是问chatgpt的
            Subject在RxJava中是一种非常有用的工具，它可以用于多个场景和使用需求下。

                实时的数据合并和处理：使用Subject可以将多个Observable的数据合并到一个Observable中，或者将多个观察者对同一Observable的观察行为合并起来。

                缓存和重放的数据处理：Subject可以扮演一个数据缓冲器缓存Observable所发射的数据并且重新发射缓存的数据给新的订阅者，例如ReplaySubject。

                作为事件总线使用：Subject可以将UI事件、广播等消息抽象成一个Observable，通过Subject的订阅和发射机制，将事件发送到对应的处理方法（即订阅者）中，这在UI与后台数据处理之间的交互中非常有用。

                将热Observable转换为冷Observable：Subject可以将热Observable转换为冷Observable，从而保证多个observer能够独立的获取到订阅的所有数据。

            总之，Subject是一种非常灵活、高效、有用的RxJava工具，它实现了观察者模式，同时集合了Observable和Observer两个角色的特点，具有非常广泛的使用场景和使用需求。在日常的RxJava编程中，使用Subject可以提高代码复用度和扩展性，简化代码结构，实现更高效、更优雅的编程体验。

    明天开始看rxjava 的操作符

## 2023年4月3日 23:21:02

    今天看了RxJava的操作符
        其他都还行 没什么难理解的地方 最后两个定时获取数据的有点不太好搞 因为没想到有什么应用场景 明天继续看操作符
        我看了这章的结尾是Rxjava结合Okhttp和Retrofit 书里讲的都是使用方法 感觉最后得找个相关面试的看一下

## 2023年4月7日 00:04:20

- 今天晚上突发奇想把之前工作中遇到的一个问题解决了 就是用android源生数据库存储list结构的实体类的事儿


## 2023年4月9日 18:08:35

    今天把操作符看完了  有点乱 因为分类有八大类 等后续打算面试的时候每个抓几个看看
    记录一下今天看到的线程控制

- Schedulers.newThread();  总是启用新线程 并且在新线程中执行操作
- Schedulers.io();         I/O操作（读写文件/，读/写数据库 网络信息交互等）所使用的Schedulers 行为模式和Schedulers.newThread()差不多，区别是io()内部实现采用的事一个无数量上限的线程池，并且可以重用空闲的线程，因此多数情况下io()比newThread()更有效率
- Schedulers.computation(); 计算所使用的Scheduler，比如图形计算。这个Scheduler使用的是固定线程池，大小为CPU的核数。不要把I/O操作放在computation()中，否则I/O操作的等待时间会浪费CPU，它是buffer，debounce，delay，interval，sample和skip操作符的默认调度器
- Scheduler.trampoline(); 当我们想在当前线程中执行一个任务时，并未立即执行，可以用trampoline()将它插入队列。这个新插入队列的任务会立即执行。如果当前队列有任务正在执行，则会将这个任务暂停，等待新插入的任务执行完毕后再执行该任务
- Scheduler.single(); 拥有一个线程单例，所有任务都在这个线程中执行
- AndroidScheduler.mainThread(); RxAndroid库提供的Scheduler，它指定的操作在主线程中运行

