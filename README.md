# TintedImageView Library

###Purpose
This Android library works mainly as backport for the one released by Google for Lollipop but it has been written from scratch to make use of [Filters][1] instead of Tint Manager

###Requirements

  - Minimum Android SDK Version **16**
  - Nothing more.

##Implementation
### Import with Gradle
In order to import this library with Gradle, you have to be sure to be using the `jcenter` repository and then declare this dependency in the `build.gradle` file of your app
```java
compile 'it.tiwiz.tintedimageview:view:1.0.0'
```

###Use in XML layouts
Once you declare the `View` in your layout, it's as simple as this to add a tint.

**Note**: you can use both a `reference` and a `color` as parameter

```xml
<it.tiwiz.view.TintedImageView
    android:id="@+id/tintedImageView"
    android:layout_width="200dp"
    android:layout_height="200dp"
    android:layout_centerHorizontal="true"
    android:src="@drawable/test_image"
    app:tint="@android:color/holo_green_light"
    />
```
###Use in Java
... and you can use it at runtime as well using both a `reference` or a `color` by simply calling these methods
```java
tintedImageView.setTint(colorTint);
tintedImageView.setTintResource(R.color.colorTint);
```

### Version
[![release](https://img.shields.io/badge/release-1.0.0-green.svg)](https://github.com/tiwiz/TintedImageView/releases/tag/1.0.0)

### License
[![](https://img.shields.io/badge/license-MIT-blue.svg?style=flat)](https://github.com/tiwiz/TintedImageView/blob/master/LICENSE)

### Demo
[![demo video](http://img.youtube.com/vi/Tqh9lj6Ip3Q/0.jpg)](http://www.youtube.com/watch?v=Tqh9lj6Ip3Q)