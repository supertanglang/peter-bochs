# Table of content #



# Introduction #

If you want to enhance peter-bochs, here is the development guide

# Tools we need #

My primary development environment is Fedora 13 + JDK 1.6.x. You can develop peter-bochs in windows too, but if you are enhancing "peter-bochs instrument", you have to do it in linux because "peter-bochs instrument" only work in linux at the moment.

! "peter-bochs instrument" is a profiling/sampling module, you can use it to profile your assembly program. please take a look [this](http://code.google.com/p/peter-bochs/wiki/JmpProfiling) and [this](http://code.google.com/p/peter-bochs/wiki/MemorySampling_ChineseIntroduction).

# setup your development tool #

Please follow the steps to start develop peter-bochs

## Step 1 , download everything ##

Please download [eclipse](http://www.eclipse.org) and [java](http://java.sun.com).

## Step 2 , checkout dependence project from svn ##

To build/test peter-bochs in eclipse, you need to download [petersoft-java-style-2](http://code.google.com/p/petersoft-java-style-2/). petersoft-java-style-2 is a Swing Look & feel, I use it to make peter-bochs look better.

Please checkout the source from [here](http://code.google.com/p/petersoft-java-style-2/source/checkout) and import the source to eclipse like :

![http://peter-bochs.googlecode.com/files/dev_p1.png](http://peter-bochs.googlecode.com/files/dev_p1.png)

## Step 3 , checkout peter-bochs source ##

Please checkout from here http://code.google.com/p/peter-bochs/source/checkout

In eclipse, you have to add "petersoft-java-style-2" to "peter-bochs" project's dependency

![http://peter-bochs.googlecode.com/files/dev_p2.png](http://peter-bochs.googlecode.com/files/dev_p2.png)

## Step 4 , install Jigloo and Fatjar ##

I use these two plugins

[Jigloo](http://www.cloudgarden.com/jigloo/) - Swing graphical editor

[Fatjar](http://fjep.sourceforge.net/) - I use this to pack the whole project into a single jar file, that jar file is the one you find in the dowload page.

## Step 5 , edit using Jigloo ##

After you installed Jigloo to eclipse, try to open "Application.java" by "Form editor", you will see the following screen and edit every components on peter-bochs.

![http://peter-bochs.googlecode.com/files/dev_p3.png](http://peter-bochs.googlecode.com/files/dev_p3.png)

## Step 6 , run/debug peter-bochs ##

The main method is in Application.java, so right click Application.java -> "run as" -> "Java application". The first time you run will produce the following error because you didn't give it the parameter.

![http://peter-bochs.googlecode.com/files/dev_p4.png](http://peter-bochs.googlecode.com/files/dev_p4.png)

To prevent the above error, please goto "Run configuration" window and add the programs argument.

![http://peter-bochs.googlecode.com/files/dev_p5.png](http://peter-bochs.googlecode.com/files/dev_p5.png)