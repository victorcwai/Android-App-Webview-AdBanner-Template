# Android-App-Webview-AdBanner-Template

Basic Template for making a Webview App to view your website, with a Google Ad Banner in the bottom

- CompileSdkVersion 28
- Using androidx

Overriding Webview:
- Pressing back button will return to last page
- Won't reload page when orientation change

To use this,

In MainActivity.java, change ``webview.loadUrl("yourLink")`` and ``MobileAds.initialize(this, "yourAdUnitId")`` 

In activity_main.xml, change ``ads:adUnitId="yourAdUnitId"`` 

You still need to make your web page mobile friendly though.

It will look like this (blank part will be your page): <br>
![alt text](https://user-images.githubusercontent.com/9410593/41933853-9578978a-79b7-11e8-90b7-50c60affd163.png)
