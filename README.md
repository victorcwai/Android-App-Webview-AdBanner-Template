# Android-App-Webview-AdBanner-Template

Basic Template for making a Webview App to view your website, with a Google Ad Banner in the bottom

- compileSdkVersion 28
- using androidx

To use this,

In MainActivity.java, change ``webview.loadUrl("yourLink")`` and ``MobileAds.initialize(this, "yourAdUnitId")`` 

In activity_main.xml, change ``ads:adUnitId="yourAdUnitId"`` 

It will look like this: <br>
![alt text](https://user-images.githubusercontent.com/9410593/41933853-9578978a-79b7-11e8-90b7-50c60affd163.png)
