# Розробка мобільних застосунків

# Практична робота №1.4 - Робота із кольором та локалізацією в ОС Android.

### Мета
Отримати досвід роботи із використанням значень рядків і кольорів та зміною локалізації у додатку.

### Крок 1: Робою головну сторінку додатку
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <FrameLayout
        android:id="@+id/testView"
        android:layout_width="100dp"
        android:layout_height="100dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:background="@color/black">

    </FrameLayout>

    <Button
        android:id="@+id/pulseButton"
        android:layout_width="120dp"
        android:layout_height="50dp"
        android:layout_marginBottom="32dp"
        android:text="Pulse"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />

    <Button
        android:id="@+id/rotationButton"
        android:layout_width="120dp"
        android:layout_height="50dp"
        android:layout_marginBottom="32dp"
        android:text="Rotation"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/pulseButton" />

    <Button
        android:id="@+id/leftRightButton"
        android:layout_width="120dp"
        android:layout_height="50dp"
        android:layout_marginBottom="32dp"
        android:text="Left Right"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toStartOf="@+id/pulseButton"
        app:layout_constraintStart_toStartOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

### Крок 2: Розроблюю анімаціЇ
## Крок 2.1: Створюю файл ``` left_right.xml ```
```
    <androidx.appcompat.widget.SwitchCompat
        android:id="@+id/switch_theme"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:layout_marginEnd="20dp"
        android:minWidth="48dp"
        android:minHeight="48dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginTop="80dp"
        android:layout_marginEnd="8dp"
        android:textSize="16sp"
        android:text="@string/lorem_ipsum"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```
## Крок 2.2: Створюю файл ``` pulse.xml ```
```
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android">
    <scale
        android:fromXScale="1.0"
        android:toXScale="1.5"
        android:fromYScale="1.0"
        android:toYScale="1.5"
        android:pivotX="50%"
        android:pivotY="50%"
        android:duration="500"
        android:repeatCount="3"
        android:repeatMode="reverse" />
</set>
```
## Крок 2.3: Створюю файл ``` rotation.xml ```
```
<?xml version="1.0" encoding="utf-8"?>
<rotate
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:fromDegrees="0"
    android:toDegrees="360"
    android:pivotX="50%"
    android:pivotY="50%"
    android:duration="1000"
    android:interpolator="@android:anim/accelerate_decelerate_interpolator"
    android:repeatCount="2" />

```
### Крок 3: Код для программи

```java
package com.example.rmz4;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    Button pulseButton;
    Button rotationButton;
    Button leftRightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.testView);
        pulseButton = findViewById(R.id.pulseButton);
        rotationButton = findViewById(R.id.rotationButton);
        leftRightButton = findViewById(R.id.leftRightButton);

        pulseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation pulse = AnimationUtils.loadAnimation(MainActivity.this, R.anim.pulse);
                frameLayout.startAnimation(pulse);
            }
        });

        rotationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation pulse = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotation);
                frameLayout.startAnimation(pulse);
            }
        });

        leftRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation pulse = AnimationUtils.loadAnimation(MainActivity.this, R.anim.left_right);
                frameLayout.startAnimation(pulse);
            }
        });

    }
}
```

### Висновок
Практична робота демонструє базові кроки взаємодії з кольорами з використанням Android Studio.
