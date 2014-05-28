# Java Proxy Check

Have you ever had the (mis-)fortune to have to run Java code behind an
HTTP proxy?  Or worse, having to have to go through a proxy for certain
URLs, but not for others?  Have you fought the syntax for defining proxy
exceptions that differ between OSes and Java?

This tool won't help you fix your config, but it helps you to test things
out quickly.


## Building

The project uses gradle, a simple `gradle build` should create the jar in 
`build/libs/javaproxycheck.jar`.


## Download

A ready-to-run binary compiled with Java 1.7.0_51 is available here:
http://www.lassitu.de/software/javaproxycheck/javaproxycheck.jar


## Usage

proxycheck.jar can be run like this:
```
$ java -jar proxycheck.jar http://www.example.com https://secure.example.com
```

The output will list the URLs and the selection the system ProxySelector.select() method
returns.  You can interactively try out the various system properties like so:
```
$ java -Dhttps.proxyHost=proxy.example.com -Dhttps.proxyPort=3128 -jar build/libs/javaproxycheck.jar http://www.example.com https://secure.example.com
http://www.example.com                   [DIRECT]
https://secure.example.com               [HTTP @ proxy.example.com:3128]
```


## Java Proxy Settings

Java has built-in support for Windows, Mac OS X, and Gnome system proxy settings; on other
platforms, you have to run Java programs with appropriate system properties specifying
which proxies to use when.  See the following documentation:

http://download.java.net/jdk7/archive/b123/docs/api/java/net/doc-files/net-properties.html#Proxies
