package codeFromWeb;

// var. 195
public class Lab4 {
    public static void main(String[] args) {
        H a = new H();
        H b = new C();
        C c = new C();
        b.s46();
        b.s35();
        c.s36();
        a.s13();
        a.s3();
        a.s15();
        a.s29();
        b.s17();
        b.s2();
        a.s8();
        a.s16();
        a.s5();
        b.s27();
        c.s42();
        b.s40();
        b.s20();
        a.s45(a);
        c.s45(b);
        c.s45(c);
        c.s33();
        c.s1();
        c.s7();
        Thread t = new Thread(new Runnable() {
            public void run() {
                while(true) {
                    try {
                        C d = new C();
                        d.s37();
                        Thread.sleep(7);
                    } catch(Exception e) {
                        // Do nothing
                    }
                }
            }
        });
        t.start();
    }
}
class H {
    int s49;
    int s10;
    int s30;
    int s41;
    int s47;
    long s23;
    long s26;
    long s44;
    java.io.ObjectOutputStream stringsWriter;
    java.io.ObjectOutputStream printStream;
    int[] s34 = {-2, 0, 0, -1, -3};
    int[] s25 = {-2, -2, 1, 2, -3};
    int[] s32 = {2, 1, 0, -3, -1};
    static String stack = "";
    static java.util.Map<java.net.URI,byte[]> cache = new java.util.HashMap<>();
    static int s28;
    static int s43;
    static int s50;
    static int s48;
    static int s39;
    java.util.List<String> s19 = new java.util.ArrayList<>();
    java.util.List<String> s6 = new java.util.ArrayList<>();
    java.util.List<String> s38 = new java.util.ArrayList<>();
    public H() {
        s49 = 6;
        s10 = 6;
        s30 = 6;
        s41 = 0;
        s47 = 7;
        s23 = 6L;
        s26 = 8L;
        s44 = 9L;
        try {
            stringsWriter = new java.io.ObjectOutputStream(new java.io.FileOutputStream("stringsWriter.txt"));
            printStream = new java.io.ObjectOutputStream(new java.io.FileOutputStream("printStream.txt"));
        } catch (java.lang.Exception e) {
            // Do nothing
        }
    }
    public void init() {
        try {
            if (stringsWriter == null) stringsWriter = new java.io.ObjectOutputStream(new java.io.FileOutputStream("stringsWriter.txt"));
            System.out.println("Thread : " + Thread.currentThread() + ", stringsWriter = " + stringsWriter);
        } catch(Exception e) {
            // Ignore it
        }
        try {
            if (printStream == null) printStream = new java.io.ObjectOutputStream(new java.io.FileOutputStream("printStream.txt"));
            System.out.println("Thread : " + Thread.currentThread() + ", printStream = " + printStream);
        } catch(Exception e) {
            // Ignore it
        }
    }
    public byte[] getValueFromCache(String s) {
        try {
            java.net.URI url = new java.net.URI(s);
            if(!cache.containsKey(url)) {
                cache.put(url, new byte[2048]);
            }
            return cache.get(url);
        } catch (Exception e) {
            System.out.println("Error: invalid URL!");
            return null;
        }
    }
    public void s46() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                init();
                int i = 0;
                while(true) {
                    i++;
                    try {
                        synchronized(stringsWriter) {
                            stringsWriter.writeObject("метод s46 в классе H (#" + String.valueOf(i) + ")");
                            Thread.sleep(5);
                            stringsWriter.flush();
                            stringsWriter.reset();
                        }
                    } catch(Exception e) {
                        // Do nothing
                    }
                }
            }
        });
        t.start();
    }
    public void s35() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                init();
                int i = 0;
                while(true) {
                    i++;
                    try {
                        synchronized(stringsWriter) {
                            stringsWriter.writeObject("метод s35 в классе H (#" + String.valueOf(i) + ")");
                            Thread.sleep(6);
                            stringsWriter.reset();
                        }
                    } catch(Exception e) {
                        // Do nothing
                    }
                }
            }
        });
        t.start();
    }
    public void s36() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                init();
                int i = 0;
                while(true) {
                    i++;
                    try {
                        synchronized(stringsWriter) {
                            stringsWriter.writeObject("метод s36 в классе H (#" + String.valueOf(i) + ")");
                            Thread.sleep(6);
                            stringsWriter.reset();
                        }
                    } catch(Exception e) {
                        // Do nothing
                    }
                }
            }
        });
        t.start();
    }
    public void s13() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                init();
                int i = 0;
                while(true) {
                    i++;
                    try {
                        synchronized(stringsWriter) {
                            stringsWriter.writeObject("метод s13 в классе H (#" + String.valueOf(i) + ")");
                            Thread.sleep(6);
                            stringsWriter.reset();
                        }
                    } catch(Exception e) {
                        // Do nothing
                    }
                }
            }
        });
        t.start();
    }
    public void s3() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                init();
                int i = 0;
                while(true) {
                    i++;
                    try {
                        synchronized(printStream) {
                            printStream.writeObject("метод s3 в классе H (#" + String.valueOf(i) + ")");
                            Thread.sleep(5);
                            printStream.reset();
                        }
                    } catch(Exception e) {
                        // Do nothing
                    }
                }
            }
        });
        t.start();
    }
    public void s15() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                init();
                int i = 0;
                while(true) {
                    i++;
                    try {
                        synchronized(printStream) {
                            printStream.writeObject("метод s15 в классе H (#" + String.valueOf(i) + ")");
                            Thread.sleep(5);
                            printStream.reset();
                        }
                    } catch(Exception e) {
                        // Do nothing
                    }
                }
            }
        });
        t.start();
    }
    public void s42() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while(true) {
                    i++;
                    try {
                        synchronized(stack) {
                            stack += "9";
                            Thread.sleep(6);
                        }
                    } catch(Exception e) {
                        // Do nothing
                    }
                }
            }
        });
        t.start();
    }
    public void s20() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while(true) {
                    i++;
                    try {
                        synchronized(stack) {
                            stack = new String(stack.substring(0, stack.length() - 1));
                            Thread.sleep(6);
                        }
                    } catch(Exception e) {
                        // Do nothing
                    }
                }
            }
        });
        t.start();
    }
    public void s5() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while(true) {
                    i++;
                    try {
                        synchronized(stack) {
                            stack = new String(stack.substring(0, stack.length() - 1));
                            Thread.sleep(5);
                        }
                    } catch(Exception e) {
                        // Do nothing
                    }
                }
            }
        });
        t.start();
    }
    public void s16() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while(true) {
                    i++;
                    try {
                        synchronized(stack) {
                            stack += "2";
                            Thread.sleep(6);
                        }
                    } catch(Exception e) {
                        // Do nothing
                    }
                }
            }
        });
        t.start();
    }
    public void s27() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while(true) {
                    i++;
                    try {
                        synchronized(stack) {
                            stack = new String(stack.substring(0, stack.length() - 1));
                            Thread.sleep(6);
                        }
                    } catch(Exception e) {
                        // Do nothing
                    }
                }
            }
        });
        t.start();
    }
    public void s40() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while(true) {
                    i++;
                    try {
                        synchronized(stack) {
                            stack = new String(stack.substring(0, stack.length() - 1));
                            Thread.sleep(5);
                        }
                    } catch(Exception e) {
                        // Do nothing
                    }
                }
            }
        });
        t.start();
    }
    public static void s29() {
        System.out.println("метод s29 в классе H");
        System.out.println(s28);
    }
    public static void s17() {
        System.out.println("метод s17 в классе H");
        System.out.println((s28 - 4));
    }
    public static void s2() {
        System.out.println("метод s2 в классе H");
        System.out.println(s43);
    }
    public static void s8() {
        System.out.println("метод s8 в классе H");
        System.out.println((s43 + 5));
    }
    public void s45(H r) {
        r.s46();
    }
    public void s45(C r) {
        r.s35();
    }
}
class C extends H {
    public C() {
        s10 = 7;
        s47 = 2;
        s26 = 9L;
    }
    public void s35() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                init();
                int i = 0;
                while(true) {
                    i++;
                    try {
                        synchronized(printStream) {
                            printStream.writeObject("метод s35 в классе C (#" + String.valueOf(i) + ")");
                            Thread.sleep(14);
                            printStream.reset();
                        }
                    } catch(Exception e) {
                        // Do nothing
                    }
                }
            }
        });
        t.start();
    }
    public void s36() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                init();
                int i = 0;
                while(true) {
                    i++;
                    try {
                        synchronized(stringsWriter) {
                            stringsWriter.writeObject("метод s36 в классе C (#" + String.valueOf(i) + ")");
                            Thread.sleep(8);
                            stringsWriter.flush();
                            stringsWriter.reset();
                        }
                    } catch(Exception e) {
                        // Do nothing
                    }
                }
            }
        });
        t.start();
    }
    public void s13() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                init();
                int i = 0;
                while(true) {
                    i++;
                    try {
                        synchronized(stringsWriter) {
                            stringsWriter.writeObject("метод s13 в классе C (#" + String.valueOf(i) + ")");
                            Thread.sleep(5);
                            stringsWriter.flush();
                            stringsWriter.reset();
                        }
                    } catch(Exception e) {
                        // Do nothing
                    }
                }
            }
        });
        t.start();
    }
    public void s33() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                while(true) {
                    try {
                        synchronized(cache) {
                            getValueFromCache("https://www.google.com");
                            Thread.sleep(14);
                        }
                    } catch(Exception e) {
                        // Do nothing
                    }
                }
            }
        });
        t.start();
    }
    public void s1() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                while(true) {
                    try {
                        synchronized(cache) {
                            getValueFromCache("https://www.google.com");
                            Thread.sleep(10);
                        }
                    } catch(Exception e) {
                        // Do nothing
                    }
                }
            }
        });
        t.start();
    }
    public void s7() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                while(true) {
                    try {
                        synchronized(cache) {
                            getValueFromCache("https://www.google.com");
                            Thread.sleep(9);
                        }
                    } catch(Exception e) {
                        // Do nothing
                    }
                }
            }
        });
        t.start();
    }
    public static void s29() {
        System.out.println("метод s29 в классе C");
        System.out.println(s28--);
    }
    public static void s17() {
        System.out.println("метод s17 в классе C");
        System.out.println(s43);
    }
    public static void s2() {
        System.out.println("метод s2 в классе C");
        System.out.println((s43 - 5));
    }
    public static void s8() {
        System.out.println("метод s8 в классе C");
        System.out.println(s43);
    }
    public void s18() {
        for(int i = 0; i < 7; i++) {
            this.s38.add(String.valueOf(System.nanoTime()));
            // System.out.println(this.s38.size());
        }
    }
    public void s37() {
        for(int i = 0; i < 9; i++) {
            this.s19.add(String.valueOf(System.nanoTime()));
            // System.out.println(this.s19.size());
        }
    }
    public void s24() {
        for(int i = 0; i < 5; i++) {
            this.s38.add(String.valueOf(System.nanoTime()));
            // System.out.println(this.s38.size());
        }
    }
    public void s4() {
        for(int i = 0; i < 9; i++) {
            this.s6.add(String.valueOf(System.nanoTime()));
            // System.out.println(this.s6.size());
        }
    }
    public void s45(H r) {
        r.s36();
    }
    public void s45(C r) {
        r.s13();
    }
}
