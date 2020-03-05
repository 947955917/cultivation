guava集合主要对JDK collections 做了扩展。
主要包含以下4个方面：
1、不可变集合，主要用于防御性编程、常量集合、提高效率
2、
3、集合工具
4、集合扩展


一、不可变集合
特点:
1、线程安全
2、时间空间效率高
3、元素不允许使用null,若元素为null，可以使用JDK自身的Collections.unmodifiableXXXX()代替;
4、所有的不可变类都提供了asList()方法
创建方式
ImmutableXXXX.copyOf()
ImmutableXXXX.of()


三、集合工具
1、主要提供了一些工厂方法来创建相关集合
2、拓展了迭代器，使其提供了更加丰富的操作
3、丰富了操作类型

四、集合扩展
提供了一些基础类，方便用户自己扩展集合类




