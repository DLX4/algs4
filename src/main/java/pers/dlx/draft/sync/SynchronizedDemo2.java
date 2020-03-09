package pers.dlx.draft.sync;

public class SynchronizedDemo2 {

    public synchronized void method() {
        System.out.println("synchronized 方法");
    }

//    $ javap -c -s -v -l SynchronizedDemo2.class
//    Classfile /D:/code/algs4/src/main/java/pers/dlx/draft/sync/SynchronizedDemo2.class
//    Last modified 2019▒▒12▒▒30▒▒; size 444 bytes
//    MD5 checksum 9e636cddd01125133ed8ffe711b02d21
//    Compiled from "SynchronizedDemo2.java"
//    public class pers.dlx.draft.sync.SynchronizedDemo2
//    minor version: 0
//    major version: 54
//    flags: (0x0021) ACC_PUBLIC, ACC_SUPER
//    this_class: #5                          // pers/dlx/draft/sync/SynchronizedDemo2
//    super_class: #6                         // java/lang/Object
//    interfaces: 0, fields: 0, methods: 2, attributes: 1
//    Constant pool:
//            #1 = Methodref          #6.#14         // java/lang/Object."<init>":()V
//            #2 = Fieldref           #15.#16        // java/lang/System.out:Ljava/io/PrintStream;
//            #3 = String             #17            // synchronized ▒▒▒▒
//            #4 = Methodref          #18.#19        // java/io/PrintStream.println:(Ljava/lang/String;)V
//            #5 = Class              #20            // pers/dlx/draft/sync/SynchronizedDemo2
//            #6 = Class              #21            // java/lang/Object
//            #7 = Utf8               <init>
//   #8 = Utf8               ()V
//   #9 = Utf8               Code
//  #10 = Utf8               LineNumberTable
//  #11 = Utf8               method
//  #12 = Utf8               SourceFile
//  #13 = Utf8               SynchronizedDemo2.java
//  #14 = NameAndType        #7:#8          // "<init>":()V
//            #15 = Class              #22            // java/lang/System
//            #16 = NameAndType        #23:#24        // out:Ljava/io/PrintStream;
//            #17 = Utf8               synchronized ▒▒▒▒
//            #18 = Class              #25            // java/io/PrintStream
//            #19 = NameAndType        #26:#27        // println:(Ljava/lang/String;)V
//            #20 = Utf8               pers/dlx/draft/sync/SynchronizedDemo2
//  #21 = Utf8               java/lang/Object
//  #22 = Utf8               java/lang/System
//  #23 = Utf8               out
//  #24 = Utf8               Ljava/io/PrintStream;
//  #25 = Utf8               java/io/PrintStream
//  #26 = Utf8               println
//  #27 = Utf8               (Ljava/lang/String;)V
//    {
//  public pers.dlx.draft.sync.SynchronizedDemo2();
//        descriptor: ()V
//        flags: (0x0001) ACC_PUBLIC
//        Code:
//        stack=1, locals=1, args_size=1
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: return
//            LineNumberTable:
//        line 3: 0
//
//        public synchronized void method();
//        descriptor: ()V
//        flags: (0x0021) ACC_PUBLIC, ACC_SYNCHRONIZED
//        Code:
//        stack=2, locals=1, args_size=1
//        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
//        3: ldc           #3                  // String synchronized ▒▒▒▒
//        5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
//        8: return
//            LineNumberTable:
//        line 6: 0
//        line 7: 8
//    }
//    SourceFile: "SynchronizedDemo2.java"

}
