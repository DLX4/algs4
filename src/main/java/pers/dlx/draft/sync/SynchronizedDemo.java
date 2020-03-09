package pers.dlx.draft.sync;

public class SynchronizedDemo {

    public void methodX() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }
}
//
//$ javap -c -s -v -l SynchronizedDemo.class
//Classfile /D:/code/algs4/src/main/java/pers/dlx/draft/sync/SynchronizedDemo.class
//Last modified 2019▒▒12▒▒30▒▒; size 552 bytes
//        MD5 checksum 1d33d0bf1a5f750b8b8ba8e02cedc33e
//        Compiled from "SynchronizedDemo.java"
//public class pers.dlx.draft.sync.SynchronizedDemo
//        minor version: 0
//        major version: 54
//        flags: (0x0021) ACC_PUBLIC, ACC_SUPER
//        this_class: #5                          // pers/dlx/draft/sync/SynchronizedDemo
//        super_class: #6                         // java/lang/Object
//        interfaces: 0, fields: 0, methods: 2, attributes: 1
//        Constant pool:
//        #1 = Methodref          #6.#16         // java/lang/Object."<init>":()V
//        #2 = Fieldref           #17.#18        // java/lang/System.out:Ljava/io/PrintStream;
//        #3 = String             #19            // synchronized ▒▒▒▒▒
//        #4 = Methodref          #20.#21        // java/io/PrintStream.println:(Ljava/lang/String;)V
//        #5 = Class              #22            // pers/dlx/draft/sync/SynchronizedDemo
//        #6 = Class              #23            // java/lang/Object
//        #7 = Utf8               <init>
//   #8 = Utf8               ()V
//           #9 = Utf8               Code
//           #10 = Utf8               LineNumberTable
//           #11 = Utf8               methodX
//           #12 = Utf8               StackMapTable
//           #13 = Class              #24            // java/lang/Throwable
//           #14 = Utf8               SourceFile
//           #15 = Utf8               SynchronizedDemo.java
//           #16 = NameAndType        #7:#8          // "<init>":()V
//           #17 = Class              #25            // java/lang/System
//           #18 = NameAndType        #26:#27        // out:Ljava/io/PrintStream;
//           #19 = Utf8               synchronized ▒▒▒▒▒
//        #20 = Class              #28            // java/io/PrintStream
//        #21 = NameAndType        #29:#30        // println:(Ljava/lang/String;)V
//        #22 = Utf8               pers/dlx/draft/sync/SynchronizedDemo
//        #23 = Utf8               java/lang/Object
//        #24 = Utf8               java/lang/Throwable
//        #25 = Utf8               java/lang/System
//        #26 = Utf8               out
//        #27 = Utf8               Ljava/io/PrintStream;
//        #28 = Utf8               java/io/PrintStream
//        #29 = Utf8               println
//        #30 = Utf8               (Ljava/lang/String;)V
//        {
//public pers.dlx.draft.sync.SynchronizedDemo();
//        descriptor: ()V
//        flags: (0x0001) ACC_PUBLIC
//        Code:
//        stack=1, locals=1, args_size=1
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: return
//        LineNumberTable:
//        line 3: 0
//
//public void methodX();
//        descriptor: ()V
//        flags: (0x0001) ACC_PUBLIC
//        Code:
//        stack=2, locals=3, args_size=1
//        0: aload_0
//        1: dup
//        2: astore_1
//        3: monitorenter
//        4: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
//        7: ldc           #3                  // String synchronized ▒▒▒▒▒
//        9: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
//        12: aload_1
//        13: monitorexit
//        14: goto          22
//        17: astore_2
//        18: aload_1
//        19: monitorexit
//        20: aload_2
//        21: athrow
//        22: return
//        Exception table:
//        from    to  target type
//        4    14    17   any
//        17    20    17   any
//        LineNumberTable:
//        line 6: 0
//        line 7: 4
//        line 8: 12
//        line 9: 22
//        StackMapTable: number_of_entries = 2
//        frame_type = 255 /* full_frame */
//        offset_delta = 17
//        locals = [ class pers/dlx/draft/sync/SynchronizedDemo, class java/lang/Object ]
//        stack = [ class java/lang/Throwable ]
//        frame_type = 250 /* chop */
//        offset_delta = 4
//        }
//        SourceFile: "SynchronizedDemo.java"
//
